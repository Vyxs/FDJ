package fr.vyxs.fdjapp.data.network.api

import fr.vyxs.fdjapp.data.network.response.LeagueResponse
import fr.vyxs.fdjapp.data.network.response.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheSportDbApi {

    @GET("all_leagues.php")
    suspend fun getLeagues(): Response<List<LeagueResponse>>

    @GET("search_all_teams.php")
    suspend fun getTeams(@Query("l") leagueName: String): Response<List<TeamResponse>>

    @GET("searchteams.php")
    suspend fun getTeamDetails(@Query("t") teamName: String): Response<List<TeamResponse>>
}