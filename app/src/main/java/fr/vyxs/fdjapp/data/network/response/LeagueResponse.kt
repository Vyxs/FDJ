package fr.vyxs.fdjapp.data.network.response

data class LeagueResponse(
    val idLeague: String,
    val strLeague: String? = null,
    val strSport: String? = null,
    val strLeagueAlternate: String? = null
)