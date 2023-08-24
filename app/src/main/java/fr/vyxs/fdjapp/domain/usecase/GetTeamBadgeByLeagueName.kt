package fr.vyxs.fdjapp.domain.usecase

import fr.vyxs.fdjapp.domain.model.TeamBadge
import fr.vyxs.fdjapp.domain.repository.AppRepository

/**
 * Affichage de la liste des équipes du championnat triées par ordre anti-alphabétique
 * en n’affichant qu’1 équipe sur 2.
 **/
class GetTeamBadgeByLeagueName(
    private val repository: AppRepository
) {
    suspend fun execute(name: String) : List<TeamBadge> =
        repository.getLeagues()
            .firstOrNull { it.name?.contains(name, true) ?: false }
            ?.let { repository.getTeams(it.name ?: "") }
            ?.sortedBy { it.name }
            ?.reversed()
            ?.filterIndexed { index, _ -> index % 2 != 0 }
            ?.map { it.teamBadge?: TeamBadge() }
            ?: emptyList()
}