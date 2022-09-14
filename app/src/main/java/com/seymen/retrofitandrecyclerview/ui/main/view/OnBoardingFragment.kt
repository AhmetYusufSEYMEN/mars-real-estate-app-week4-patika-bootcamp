package com.seymen.retrofitandrecyclerview.ui.main.view

import android.content.Context
import android.content.SharedPreferences
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
        val win: Window = requireActivity().window
        win.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        initView()
        initListeners()
    }

    private fun initListeners() {
        // TODO: interface click listener denenecek

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

    private fun initView() {

        // binding.textView2.text = Html.fromHtml( "<font color=#000000>Let’s Explore the</font> <font color=#F9AD1A>Solar System</font> <font color=#000000>with</font> <font color=#F9AD1A>Explorer</font>")
        //<font face='balsamiq-sans-bold'>Let’s Explore the Solar System with Explorer</font> <br/> <font face='monospace'>monospace</font>
        /*   val text = "<font color=#000000>Let’s Explore the</font> <font color=#F9AD1A>Solar System</font> <font color=#000000>with</font> <font color=#F9AD1A>Explorer</font>"

           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
               binding.textView3.setText(
                   Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY),
                   TextView.BufferType.SPANNABLE
               )
           } else {
               binding.textView3.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE)
           }*/

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}