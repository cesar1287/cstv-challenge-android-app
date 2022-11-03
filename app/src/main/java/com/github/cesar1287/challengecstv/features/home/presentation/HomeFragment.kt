package com.github.cesar1287.challengecstv.features.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.cesar1287.challengecstv.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    private val homeViewModel: HomeViewModel by viewModels()

    private val homeAdapter by lazy {
        HomeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        collectUiState()
    }

    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.getMatches().collect {
                homeAdapter.submitData(it)
            }
        }

        homeAdapter.addLoadStateListener { loadState ->
            binding?.let {
                with(it) {
                    // Only shows the list if refresh succeeds.
                    gpHomeContent.isVisible = loadState.source.refresh is LoadState.NotLoading
                    // Show loading spinner during initial load or refresh.
                    pbHomeLoading.isVisible = loadState.source.refresh is LoadState.Loading
                    // Show the retry state if initial load or refresh fails.
                    btHomeTryAgain.isVisible = loadState.source.refresh is LoadState.Error
                }
            }
        }
    }

    private fun setupView() {
        binding?.let {
            it.vgMatchesList.apply {
                adapter = homeAdapter
                layoutManager = LinearLayoutManager(context)
            }

            it.btHomeTryAgain.setOnClickListener {
                homeAdapter.refresh()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}