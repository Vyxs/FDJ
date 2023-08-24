package fr.vyxs.fdjapp.app.vm

import androidx.lifecycle.*
import fr.vyxs.fdjapp.domain.model.Team
import fr.vyxs.fdjapp.domain.model.TeamBadge
import fr.vyxs.fdjapp.domain.repository.AppRepository
import fr.vyxs.fdjapp.domain.usecase.GetAllLeagueName
import fr.vyxs.fdjapp.domain.usecase.GetTeamBadgeByLeagueName
import fr.vyxs.fdjapp.domain.usecase.GetTeamDetailsByName
import kotlinx.coroutines.launch

class MainViewModel(
    repository: AppRepository
) : ViewModel() {
    private val getAllLeagueName: GetAllLeagueName = GetAllLeagueName(repository)
    private val getTeamBadgeByLeagueName: GetTeamBadgeByLeagueName = GetTeamBadgeByLeagueName(repository)
    private val getTeamDetailsByName: GetTeamDetailsByName = GetTeamDetailsByName(repository)
    private val leagueName = MutableLiveData<String>()

    fun setLeagueName(leagueName: String) {
        viewModelScope.launch {
            this@MainViewModel.leagueName.postValue(leagueName)
        }
    }

    fun getAllLeagueName() : LiveData<List<String>> {
        val leagues = MutableLiveData<List<String>>()
        viewModelScope.launch {
            leagues.postValue(getAllLeagueName.execute())
        }
        return leagues
    }

    fun getFilteredTeamBadges() : LiveData<List<TeamBadge>> {
        return Transformations.switchMap(leagueName) {
            val teamBadges = MutableLiveData<List<TeamBadge>>()
            viewModelScope.launch {
                teamBadges.postValue(getTeamBadgeByLeagueName.execute(it))
            }
            teamBadges
        }
    }

    fun getTeamDetails(teamName: String) : LiveData<Team> {
        val team = MutableLiveData<Team>()
        viewModelScope.launch {
            team.postValue(getTeamDetailsByName.execute(teamName))
        }
        return team
    }
}