package com.example.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.adapter.AppAdapter
import com.example.ui.databinding.FragmentHomeBinding
import com.example.ui.model.AppModel
import com.example.ui.util.MarginItemDecoration
import com.example.ui.util.observe
import com.example.ui.viewModel.LatestUiState
import com.example.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var appAdapter: AppAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.getInstalledApps()

        observe(viewModel.installedApps, ::observeInstalledApps)
    }

    private fun setupRecyclerView() {
        binding.rvInstalledApps.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false
        )
        binding.rvInstalledApps.addItemDecoration(MarginItemDecoration(16))
        binding.rvInstalledApps.adapter = appAdapter
    }

    private fun observeInstalledApps(state: LatestUiState<List<AppModel>>?) {
        state?.let {
            when (it) {

                is LatestUiState.Loading -> {
                }
                is LatestUiState.Success -> {
                    appAdapter.setData(it.apps)
                }
                else -> {

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}