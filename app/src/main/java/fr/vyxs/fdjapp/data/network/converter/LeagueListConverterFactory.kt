package fr.vyxs.fdjapp.data.network.converter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.vyxs.fdjapp.data.network.response.LeagueResponse
import fr.vyxs.fdjapp.data.network.response.LeagueListResponse
import okhttp3.ResponseBody
import retrofit2.Converter

/**
 * This class unwrap LeagueList from the response body to get the list of leagues. So it return a List<League>
 * It use Gson to deserialize the response body. If the type is not LeagueList, it returns null.
 **/
class LeagueListConverterFactory(
    private val gson: Gson
): Converter.Factory() {

    override fun responseBodyConverter(
        type: java.lang.reflect.Type,
        annotations: Array<Annotation>,
        retrofit: retrofit2.Retrofit
    ): Converter<ResponseBody, *>? {
        val handledType = TypeToken.getParameterized(List::class.java, LeagueResponse::class.java).type

        return if (type == handledType) {
            Converter<ResponseBody, List<LeagueResponse>> { value ->
                val leagueList = gson.fromJson(value.string(), LeagueListResponse::class.java)
                leagueList.leagues
            }
        } else {
            null
        }
    }
}