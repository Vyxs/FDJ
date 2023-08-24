package fr.vyxs.fdjapp.data.local.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.vyxs.fdjapp.data.local.dao.LeagueDao
import fr.vyxs.fdjapp.data.local.dao.TeamDao
import fr.vyxs.fdjapp.data.local.entity.LeagueEntity
import fr.vyxs.fdjapp.data.local.entity.TeamEntity

@Database(entities = [LeagueEntity::class, TeamEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private val LOCK = Any()

        @Volatile
        private var instance: AppDatabase? = null

        fun get(): AppDatabase = instance!!

        fun init(applicationContext: android.content.Context, dbName: String) {
            if (instance == null) {
                synchronized(LOCK) {
                    instance = Room.databaseBuilder(applicationContext, AppDatabase::class.java, dbName).build()
                }
            }
        }
    }

    abstract fun leagueDao(): LeagueDao
    abstract fun teamDao(): TeamDao
}