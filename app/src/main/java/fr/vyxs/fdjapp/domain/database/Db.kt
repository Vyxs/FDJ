package fr.vyxs.fdjapp.domain.database

import android.app.Application
import fr.vyxs.fdjapp.BuildConfig
import fr.vyxs.fdjapp.data.local.database.AppDatabase
import fr.vyxs.fdjapp.data.network.provider.NetProvider
import fr.vyxs.fdjapp.data.repository.AppRepositoryImpl
import fr.vyxs.fdjapp.domain.repository.AppRepository

object Db {

    fun init(application: Application) {
        AppDatabase.init(application, BuildConfig.DB_NAME)
    }

    private val appDatabase: AppDatabase by lazy {
        AppDatabase.get()
    }

    val repository: AppRepository by lazy {
        AppRepositoryImpl(
            remote = NetProvider.theSportDbApi,
            local = appDatabase
        )
    }
}