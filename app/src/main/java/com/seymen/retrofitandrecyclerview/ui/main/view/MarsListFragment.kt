package com.seymen.retrofitandrecyclerview.ui.main.view

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.seymen.retrofitandrecyclerview.data.api.ApiHelper
import com.seymen.retrofitandrecyclerview.data.api.MarsApi
import com.seymen.retrofitandrecyclerview.data.model.MarsModel
import com.seymen.retrofitandrecyclerview.databinding.FragmentMarsListBinding
import com.seymen.retrofitandrecyclerview.ui.base.ViewModelFactory
import com.seymen.retrofitandrecyclerview.ui.main.adapter.MainAdapter
import com.seymen.retrofitandrecyclerview.ui.main.viewmodel.MainViewModel
import com.seymen.retrofitandrecyclerview.utils.Status

class MarsListFragment : Fragment() {

    private var _binding : FragmentMarsListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupUI()
        setupObservers()
    }
    override fun onResume() {
        super.onResume()
        showBar()
    }

    /**
     * Clear fullscreen flag
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

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(MarsApi.apiService)))[MainViewModel::class.java]
    }

    private fun setupUI() {
        /**
         * recycler adapter setted
         */
        binding.recyclerMars.layoutManager = LinearLayoutManager(requireContext())
        adapter = MainAdapter(arrayListOf()){ item ->
            val mars = MarsModel(item.id,item.img_src,item.price,item.type)
           // Toast.makeText(requireContext(), item.id, Toast.LENGTH_SHORT).show()
            val action = MarsListFragmentDirections.actionMarsListFragment2ToMarsDetailsFragment(mars)
            findNavController().navigate(action)
        }
        binding.recyclerMars.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerMars.context,
                (binding.recyclerMars.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerMars.adapter = adapter
    }

    /**
     * Views are set according to the state of the data
     */
    private fun setupObservers() {
        viewModel.getMarsInfo().observe(requireActivity(), Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.recyclerMars.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { informations -> retrieveList(informations) }
                    }
                    Status.ERROR -> {
                        binding.recyclerMars.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.recyclerMars.visibility = View.VISIBLE
                        binding.recyclerMars.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(informations: List<MarsModel>) {
        adapter.apply {
            addInfo(informations)
            notifyDataSetChanged()
        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}