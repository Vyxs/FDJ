package fr.vyxs.fdjapp.data.repository

import android.util.Log
import fr.vyxs.fdjapp.data.local.database.AppDatabase
import fr.vyxs.fdjapp.data.mapper.toDomain
import fr.vyxs.fdjapp.data.mapper.toEntity
import fr.vyxs.fdjapp.data.network.api.TheSportDbApi
import fr.vyxs.fdjapp.domain.model.League
import fr.vyxs.fdjapp.domain.model.Team
import fr.vyxs.fdjapp.domain.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepositoryImpl(
    private val remote: TheSportDbApi,
    private val local: AppDatabase
) : AppRepository {

    override suspend fun getLeagues(): List<League> {
        return withContext(Dispatchers.IO) {
            try {
                handleGetLeague()
            } catch (e: Exception) {
                Log.e("AppRepositoryImpl", "getLeagues: ", e)
                emptyList()
            }
        }
    }

    override suspend fun getTeams(leagueName: String): List<Team> {
        return withContext(Dispatchers.IO) {
            try {
                handleGetTeams(leagueName)
            } catch (e: Exception) {
                Log.e("AppRepositoryImpl", "getTeams: ", e)
                emptyList()
            }
        }
    }

    override suspend fun getTeamDetails(teamName: String): Team? {
        return withContext(Dispatchers.IO) {
            try {
                handleGetTeamDetails(teamName)
            } catch (e: Exception) {
                Log.e("AppRepositoryImpl", "getTeamDetails: ", e)
                null
            }
        }
    }

    private suspend fun handleGetLeague() : List<League> {
        local.leagueDao().getAll().let { leagueEntityList ->
            if (leagueEntityList.isEmpty()) {
                remote.getLeagues().body()?.let { leagues ->
                    val list = leagues.mapNotNull { it.toEntity() }
                    local.leagueDao().insertAll(*list.toTypedArray())
                    list
                }.also { leagueEntities -> return leagueEntities?.mapNotNull { it.toDomain() }?: emptyList() }
            } else {
                return leagueEntityList.mapNotNull { it.toDomain() }
            }
        }
    }

    private suspend fun handleGetTeams(leagueName: String): List<Team> {
        local.teamDao().getTeams(leagueName).let { teamEntityList ->
            if (teamEntityList.isEmpty()) {
                remote.getTeams(leagueName).body()?.let { teams ->
                    val list = teams.mapNotNull { it.toEntity() }
                    local.teamDao().insertAll(*list.toTypedArray())
                    list
                }.also { teamEntities -> return teamEntities?.mapNotNull { it.toDomain() }?: emptyList() }
            } else {
                return teamEntityList.mapNotNull { it.toDomain() }
            }
        }
    }

    private suspend fun handleGetTeamDetails(teamName: String): Team? {
        local.teamDao().getTeam(teamName).let { teamEntity ->
            if (teamEntity == null) {
                remote.getTeamDetails(teamName).body()?.let { teams ->
                    teams.firstOrNull()?.let { team ->
                        val teamEnt = team.toEntity()
                        if (teamEnt != null) {
                            local.teamDao().insert(teamEnt)
                        }
                        teamEnt
                    }
                }.also {  return it?.toDomain() }
            } else {
                return teamEntity.toDomain()
            }
        }
    }
}