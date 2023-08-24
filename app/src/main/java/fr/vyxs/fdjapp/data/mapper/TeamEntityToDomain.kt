package fr.vyxs.fdjapp.data.mapper

import fr.vyxs.fdjapp.data.local.entity.TeamEntity
import fr.vyxs.fdjapp.domain.model.Team
import fr.vyxs.fdjapp.domain.model.TeamBadge

internal fun TeamEntity?.toDomain() = this?.let {
    Team(
        id = idTeam,
        name = strTeam,
        description = getDescription(it),
        country = strCountry,
        teamBanner = strTeamBanner,
        teamBadge = TeamBadge(strTeamBadge, strLeague, strTeam),
    )
}

private fun getDescription(team: TeamEntity) : String {
    return team.strDescriptionEN ?:
    team.strDescriptionFR ?:
    team.strDescriptionDE ?:
    team.strDescriptionIT ?:
    team.strDescriptionCN ?:
    team.strDescriptionJP ?:
    team.strDescriptionRU ?:
    team.strDescriptionES ?:
    team.strDescriptionPT ?:
    team.strDescriptionSE ?:
    team.strDescriptionNL ?:
    team.strDescriptionHU ?:
    team.strDescriptionNO ?:
    team.strDescriptionIL ?:
    team.strDescriptionPL ?:
    "No description available"
}