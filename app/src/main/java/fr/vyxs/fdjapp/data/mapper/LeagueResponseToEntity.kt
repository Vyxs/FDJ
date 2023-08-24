package fr.vyxs.fdjapp.data.mapper

import fr.vyxs.fdjapp.data.local.entity.LeagueEntity
import fr.vyxs.fdjapp.data.network.response.LeagueResponse

internal fun LeagueResponse?.toEntity() = this?.let {
    LeagueEntity(
        idLeague = idLeague,
        strLeague = strLeague,
        strSport = strSport,
        strLeagueAlternate = strLeagueAlternate
    )
}