package com.seymen.retrofitandrecyclerview.ui.main.view

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.seymen.retrofitandrecyclerview.databinding.FragmentMarsDetailsBinding


class MarsDetailsFragment : Fragment() {

    private var _binding : FragmentMarsDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: MarsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsDetailsBinding.inflate(inflater,container,false)
        return binding.apply {
            val marsDetail = args.marsArgs
            binding.marsDetailBinding = marsDetail
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        hideBar()
    }

    private fun hideBar() {
        if (Build.VERSION.SDK_INT < 30) {
            requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            requireActivity().actionBar?.hide()
        } else {
            requireActivity().window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
        }
    }

    private fun initListeners() {
        binding.apply {
            backButton.setOnClickListener {
                findNavController().navigateUp()
            }
            btnBuy.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Congratulations! You have purchased a plot of land from Mars.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } 
        
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}