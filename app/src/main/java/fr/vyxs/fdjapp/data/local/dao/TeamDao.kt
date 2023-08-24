package fr.vyxs.fdjapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.vyxs.fdjapp.data.local.entity.TeamEntity

@Dao
interface TeamDao {

    @Query("SELECT * FROM teams LIMIT 1000")
    fun getAll(): List<TeamEntity>

    @Query("SELECT * FROM teams WHERE team_str_league LIKE :leagueName")
    fun getTeams(leagueName: String): List<TeamEntity>

    @Query("SELECT * FROM teams WHERE team_str_team LIKE :teamName")
    fun getTeam(teamName: String): TeamEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg teams: TeamEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(team: TeamEntity)
}