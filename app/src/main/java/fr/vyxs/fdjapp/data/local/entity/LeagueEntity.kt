package fr.vyxs.fdjapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leagues")
data class LeagueEntity(
    @PrimaryKey
    @ColumnInfo(name = "league_id")
    val idLeague: String,
    @ColumnInfo(name = "league_desc")
    val strLeague: String? = null,
    @ColumnInfo(name = "league_sport")
    val strSport: String? = null,
    @ColumnInfo(name = "league_desc_alternate")
    val strLeagueAlternate: String? = null
)