package com.seymen.retrofitandrecyclerview.presentation.onboard

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.seymen.retrofitandrecyclerview.R
import com.seymen.retrofitandrecyclerview.databinding.FragmentOnBoardingBinding
import com.seymen.retrofitandrecyclerview.utils.Constants.ONBOARDING_SP_KEY

class OnBoardingFragment : Fragment() {
    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var shared: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        showBar()
    }

    /**
     * Notification bar hidden on splash screen made visible
     *
     */
    private fun showBar() {
        if (Build.VERSION.SDK_INT < 30) {
            requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            requireActivity().actionBar?.show()
        } else {
            requireActivity().window.decorView.windowInsetsController?.show(WindowInsets.Type.statusBars())
        }
    }

    private fun initListeners() {

        binding.btnGetStarted.setOnClickListener {

            shared = requireContext().getSharedPreferences(
                "com.seymen.retrofitandrecyclerview",
                Context.MODE_PRIVATE
            )
            val edit = shared.edit()
            edit.putString(ONBOARDING_SP_KEY, "1")
            edit.apply()

            findNavController().navigate(R.id.action_onBoardingFragment_to_marsListFragment)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}