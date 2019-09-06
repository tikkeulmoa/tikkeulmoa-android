package tikkeulmoa.cimile.org.util

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponse

interface NetworkService {
    @GET ("/api/details")
    fun getDpsAndWtdrList(@Query("groups_idx") groups_idx : Int): Call<GetDpsAndWtdrListResponse>
}