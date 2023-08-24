package fr.vyxs.fdjapp.data.network.converter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.vyxs.fdjapp.data.network.response.LeagueResponse
import fr.vyxs.fdjapp.data.network.response.TeamResponse
import fr.vyxs.fdjapp.data.network.response.TeamListResponse
import okhttp3.ResponseBody
import retrofit2.Converter

/**
 * This class unwrap TeamList from the response body to get the list of leagues. So it return a List<Team>
 * It use Gson to deserialize the response body. If the type is not TeamList, it returns null.
 **/
class TeamListConverterFactory(
    private val gson: Gson
): Converter.Factory() {

    override fun responseBodyConverter(
        type: java.lang.reflect.Type,
        annotations: Array<Annotation>,
        retrofit: retrofit2.Retrofit
    ): Converter<ResponseBody, *>? {
        val handledType = TypeToken.getParameterized(List::class.java, TeamResponse::class.java).type

        return if (type == handledType) {
            Converter<ResponseBody, List<TeamResponse>> { value ->
                val teamList = gson.fromJson(value.string(), TeamListResponse::class.java)
                teamList.teams
            }
        } else {
            null
        }
    }
}