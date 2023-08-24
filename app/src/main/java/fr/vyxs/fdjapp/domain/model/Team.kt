package fr.vyxs.fdjapp.domain.model

data class Team(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val country: String? = null,
    val teamBanner: String? = null,
    val teamBadge: TeamBadge? = null
)
