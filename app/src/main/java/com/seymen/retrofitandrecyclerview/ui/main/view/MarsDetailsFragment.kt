package com.seymen.retrofitandrecyclerview.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    private fun initListeners() {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}