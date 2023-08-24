package fr.vyxs.fdjapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.vyxs.fdjapp.data.local.entity.LeagueEntity

@Dao
interface LeagueDao {

    @Query("SELECT * FROM leagues LIMIT 1000")
    fun getAll(): List<LeagueEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg leagues: LeagueEntity)
}