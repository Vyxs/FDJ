package fr.vyxs.fdjapp.domain.usecase

import fr.vyxs.fdjapp.domain.repository.AppRepository

class GetAllLeagueName(
    private val repository: AppRepository
) {
    suspend fun execute() : List<String> = repository.getLeagues().map { it.name?: "" }
}