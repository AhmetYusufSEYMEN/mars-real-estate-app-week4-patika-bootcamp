package com.seymen.retrofitandrecyclerview.ui.main.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.seymen.retrofitandrecyclerview.R
import com.seymen.retrofitandrecyclerview.databinding.FragmentSplashBinding
import com.seymen.retrofitandrecyclerview.utils.Constants.ONBOARDING_SP_KEY
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private  lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = requireContext().getSharedPreferences("com.seymen.retrofitandrecyclerview" , Context.MODE_PRIVATE)
        lifecycleScope.launch {
            delay(2000)

            when(shared.getString(ONBOARDING_SP_KEY , "0" )){
                "0" ->  findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
                else ->  findNavController().navigate(R.id.action_splashFragment_to_marsListFragment)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      _binding = FragmentSplashBinding.inflate(inflater,container,false)
        val slideAnimation = AnimationUtils.loadAnimation(requireContext(),R.anim.side_slide)
        binding.imgvMars.startAnimation(slideAnimation)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}