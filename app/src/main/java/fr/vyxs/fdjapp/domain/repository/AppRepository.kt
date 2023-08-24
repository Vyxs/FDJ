package fr.vyxs.fdjapp.domain.repository

import fr.vyxs.fdjapp.domain.model.League
import fr.vyxs.fdjapp.domain.model.Team


interface AppRepository {

    /**
     * Get all leagues
     */
    suspend fun getLeagues(): List<League>

    /**
     * Get all teams for a given league
     */
    suspend fun getTeams(leagueName: String): List<Team>

    /**
     * Get team details for a given team
     */
    suspend fun getTeamDetails(teamName: String): Team?
}
