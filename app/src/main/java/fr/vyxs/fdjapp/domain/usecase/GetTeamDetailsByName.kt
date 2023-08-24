package fr.vyxs.fdjapp.domain.usecase

import fr.vyxs.fdjapp.domain.model.Team
import fr.vyxs.fdjapp.domain.repository.AppRepository

class GetTeamDetailsByName(
    private val repository: AppRepository
) {
    suspend fun execute(name: String): Team? = repository.getTeamDetails(name)
}