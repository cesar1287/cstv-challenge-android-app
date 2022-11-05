package com.github.cesar1287.challengecstv.features.matchdetail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.base.BaseFragment
import com.github.cesar1287.challengecstv.databinding.FragmentMatchDetailBinding
import com.github.cesar1287.challengecstv.model.MatchVO
import com.github.cesar1287.challengecstv.utils.Command
import com.github.cesar1287.challengecstv.utils.GlideApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchDetailFragment : BaseFragment() {

    private var binding: FragmentMatchDetailBinding? = null

    private val args by navArgs<MatchDetailFragmentArgs>()

    private val match: MatchVO by lazy {
        args.match
    }

    private val matchDetailViewModel: MatchDetailViewModel by viewModels()

    private val teamAAdapter by lazy {
        TeamAAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupObservables()
    }

    private fun setupObservables() {
        matchDetailViewModel.command = command
        matchDetailViewModel.getTeams(match.teamAId, match.teamBId)

        matchDetailViewModel.onTeamsLoaded.observe(viewLifecycleOwner) {
            teamAAdapter.submitList(it.first().players)
        }
    }

    private fun setupView() {
        binding?.let {
            with(it) {
                tvMatchDetailLeagueSeries.text = getString(
                    R.string.league_series_label,
                    match.leagueName,
                    match.seriesName
                )
                tvMatchDetailHour.text = match.datePretty
                tvMatchTeamA.text = match.teamAName
                tvMatchTeamB.text = match.teamBName

                context?.let { contextNonNull ->
                    GlideApp.with(contextNonNull)
                        .load(match.teamAImageUrl)
                        .error(R.drawable.no_logo)
                        .into(ivMatchTeamA)

                    GlideApp.with(contextNonNull)
                        .load(match.teamBImageUrl)
                        .error(R.drawable.no_logo)
                        .into(ivMatchTeamB)
                }

                ivMatchDetailBack.setOnClickListener {
                    findNavController().popBackStack()
                }

                rvMatchDetailTeamA.apply {
                    adapter = teamAAdapter
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override var command: MutableLiveData<Command> = MutableLiveData()
}