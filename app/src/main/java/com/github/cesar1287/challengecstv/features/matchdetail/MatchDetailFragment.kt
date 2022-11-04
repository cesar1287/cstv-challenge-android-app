package com.github.cesar1287.challengecstv.features.matchdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.FragmentMatchDetailBinding
import com.github.cesar1287.challengecstv.model.MatchVO
import com.github.cesar1287.challengecstv.utils.GlideApp

class MatchDetailFragment : Fragment() {

    private var binding: FragmentMatchDetailBinding? = null

    private val args by navArgs<MatchDetailFragmentArgs>()

    private val match: MatchVO by lazy {
        args.match
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
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}