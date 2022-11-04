package com.github.cesar1287.challengecstv.features.matchdetail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.cesar1287.challengecstv.base.BaseViewModel
import com.github.cesar1287.challengecstv.features.matchdetail.domain.MatchDetailUseCase
import com.github.cesar1287.challengecstv.model.TeamsResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    private val matchDetailUseCase: MatchDetailUseCase
): BaseViewModel() {

    private val _onTeamsLoaded: MutableLiveData<List<TeamsResponseItem>> = MutableLiveData()

    val onTeamsLoaded: LiveData<List<TeamsResponseItem>>
        get() = _onTeamsLoaded

    fun getTeams(teamAId: Int, teamBId: Int) {
        viewModelScope.launch {
            callApi(
                call = suspend { matchDetailUseCase.getTeams(teamAId, teamBId) },
                onSuccess = {

                }
            )
        }
    }
}