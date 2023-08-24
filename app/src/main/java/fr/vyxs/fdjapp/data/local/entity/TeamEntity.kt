package fr.vyxs.fdjapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class TeamEntity(
    @PrimaryKey
    @ColumnInfo(name = "team_id")
    val idTeam: String,
    @ColumnInfo(name = "team_soccer_xml_id")
    val idSoccerXML: String? = null,
    @ColumnInfo(name = "team_api_football_id")
    val idAPIfootball: String? = null,
    @ColumnInfo(name = "team_int_loved")
    val intLoved: String? = null,
    @ColumnInfo(name = "team_str_team")
    val strTeam: String? = null,
    @ColumnInfo(name = "team_str_team_short")
    val strTeamShort: String? = null,
    @ColumnInfo(name = "team_str_alternate")
    val strAlternate: String? = null,
    @ColumnInfo(name = "team_int_formed_year")
    val intFormedYear: String? = null,
    @ColumnInfo(name = "team_str_sport")
    val strSport: String? = null,
    @ColumnInfo(name = "team_str_league")
    val strLeague: String? = null,
    @ColumnInfo(name = "team_id_league")
    val idLeague: String? = null,
    @ColumnInfo(name = "team_str_league2")
    val strLeague2: String? = null,
    @ColumnInfo(name = "team_id_league2")
    val idLeague2: String? = null,
    @ColumnInfo(name = "team_str_league3")
    val strLeague3: String? = null,
    @ColumnInfo(name = "team_id_league3")
    val idLeague3: String? = null,
    @ColumnInfo(name = "team_str_league4")
    val strLeague4: String? = null,
    @ColumnInfo(name = "team_id_league4")
    val idLeague4: String? = null,
    @ColumnInfo(name = "team_str_league5")
    val strLeague5: String? = null,
    @ColumnInfo(name = "team_id_league5")
    val idLeague5: String? = null,
    @ColumnInfo(name = "team_str_league6")
    val strLeague6: String? = null,
    @ColumnInfo(name = "team_id_league6")
    val idLeague6: String? = null,
    @ColumnInfo(name = "team_str_league7")
    val strLeague7: String? = null,
    @ColumnInfo(name = "team_id_league7")
    val idLeague7: String? = null,
    @ColumnInfo(name = "team_str_division")
    val strDivision: String? = null,
    @ColumnInfo(name = "team_str_manager")
    val strManager: String? = null,
    @ColumnInfo(name = "team_str_stadium")
    val strStadium: String? = null,
    @ColumnInfo(name = "team_str_keywords")
    val strKeywords: String? = null,
    @ColumnInfo(name = "team_str_rss")
    val strRSS: String? = null,
    @ColumnInfo(name = "team_str_stadium_thumb")
    val strStadiumThumb: String? = null,
    @ColumnInfo(name = "team_str_stadium_description")
    val strStadiumDescription: String? = null,
    @ColumnInfo(name = "team_str_stadium_location")
    val strStadiumLocation: String? = null,
    @ColumnInfo(name = "team_int_stadium_capacity")
    val intStadiumCapacity: String? = null,
    @ColumnInfo(name = "team_str_website")
    val strWebsite: String? = null,
    @ColumnInfo(name = "team_str_facebook")
    val strFacebook: String? = null,
    @ColumnInfo(name = "team_str_twitter")
    val strTwitter: String? = null,
    @ColumnInfo(name = "team_str_instagram")
    val strInstagram: String? = null,
    @ColumnInfo(name = "team_str_description_en")
    val strDescriptionEN: String? = null,
    @ColumnInfo(name = "team_str_description_de")
    val strDescriptionDE: String? = null,
    @ColumnInfo(name = "team_str_description_fr")
    val strDescriptionFR: String? = null,
    @ColumnInfo(name = "team_str_description_cn")
    val strDescriptionCN: String? = null,
    @ColumnInfo(name = "team_str_description_it")
    val strDescriptionIT: String? = null,
    @ColumnInfo(name = "team_str_description_jp")
    val strDescriptionJP: String? = null,
    @ColumnInfo(name = "team_str_description_ru")
    val strDescriptionRU: String? = null,
    @ColumnInfo(name = "team_str_description_es")
    val strDescriptionES: String? = null,
    @ColumnInfo(name = "team_str_description_pt")
    val strDescriptionPT: String? = null,
    @ColumnInfo(name = "team_str_description_se")
    val strDescriptionSE: String? = null,
    @ColumnInfo(name = "team_str_description_nl")
    val strDescriptionNL: String? = null,
    @ColumnInfo(name = "team_str_description_hu")
    val strDescriptionHU: String? = null,
    @ColumnInfo(name = "team_str_description_no")
    val strDescriptionNO: String? = null,
    @ColumnInfo(name = "team_str_description_il")
    val strDescriptionIL: String? = null,
    @ColumnInfo(name = "team_str_description_pl")
    val strDescriptionPL: String? = null,
    @ColumnInfo(name = "team_str_kit_colour1")
    val strKitColour1: String? = null,
    @ColumnInfo(name = "team_str_kit_colour2")
    val strKitColour2: String? = null,
    @ColumnInfo(name = "team_str_kit_colour3")
    val strKitColour3: String? = null,
    @ColumnInfo(name = "team_str_gender")
    val strGender: String? = null,
    @ColumnInfo(name = "team_str_country")
    val strCountry: String? = null,
    @ColumnInfo(name = "team_str_team_badge")
    val strTeamBadge: String? = null,
    @ColumnInfo(name = "team_str_team_jersey")
    val strTeamJersey: String? = null,
    @ColumnInfo(name = "team_str_team_logo")
    val strTeamLogo: String? = null,
    @ColumnInfo(name = "team_str_team_fanart1")
    val strTeamFanart1: String? = null,
    @ColumnInfo(name = "team_str_team_fanart2")
    val strTeamFanart2: String? = null,
    @ColumnInfo(name = "team_str_team_fanart3")
    val strTeamFanart3: String? = null,
    @ColumnInfo(name = "team_str_team_fanart4")
    val strTeamFanart4: String? = null,
    @ColumnInfo(name = "team_str_team_banner")
    val strTeamBanner: String? = null,
    @ColumnInfo(name = "team_str_youtube")
    val strYoutube: String? = null,
    @ColumnInfo(name = "team_str_locked")
    val strLocked: String? = null
)