package fr.vyxs.fdjapp.app.core

import fr.vyxs.fdjapp.domain.database.Db

class App : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        Db.init(this)
    }
}