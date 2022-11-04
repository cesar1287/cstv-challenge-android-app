package com.github.cesar1287.challengecstv.features.matchdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.FragmentMatchDetailBinding
import com.github.cesar1287.challengecstv.model.MatchVO

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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}