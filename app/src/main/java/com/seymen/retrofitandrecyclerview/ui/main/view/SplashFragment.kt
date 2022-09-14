package com.seymen.retrofitandrecyclerview.ui.main.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AnimationUtils
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
            delay(1000) // TODO: Finalde 2000 yapılacak
            val check = shared.getString(ONBOARDING_SP_KEY , "0" )
            if(check == "0"){
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }
            else {
                findNavController().navigate(R.id.action_splashFragment_to_marsListFragment)
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
        // make full screen
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}