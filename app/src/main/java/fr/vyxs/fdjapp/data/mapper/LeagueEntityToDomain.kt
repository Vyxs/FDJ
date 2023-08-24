package fr.vyxs.fdjapp.data.mapper

import fr.vyxs.fdjapp.data.local.entity.LeagueEntity
import fr.vyxs.fdjapp.domain.model.League

internal fun LeagueEntity?.toDomain() = this?.let {
    League(
        id = idLeague,
        name = strLeague,
        sport = strSport,
        alternate = strLeagueAlternate
    )
}