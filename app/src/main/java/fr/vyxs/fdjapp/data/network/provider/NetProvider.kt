package fr.vyxs.fdjapp.data.network.provider

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import fr.vyxs.fdjapp.BuildConfig
import fr.vyxs.fdjapp.data.network.api.TheSportDbApi
import fr.vyxs.fdjapp.data.network.converter.LeagueListConverterFactory
import fr.vyxs.fdjapp.data.network.converter.TeamListConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object NetProvider {

    val theSportDbApi: TheSportDbApi by lazy {
        retrofit.create(TheSportDbApi::class.java)
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(LeagueListConverterFactory(gson))
            .addConverterFactory(TeamListConverterFactory(gson))
            .build()
    }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val gson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
    }
}