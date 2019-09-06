package tikkeulmoa.cimile.org.util

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tikkeulmoa.cimile.org.model.GetAccountListResponse
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponse

interface NetworkService {
    @GET ("/api/details")
    fun getDpsAndWtdrList(@Query("groups_idx") groups_idx : Int): Call<GetDpsAndWtdrListResponse>

    //모임리스트
    @GET ("/api/groups")
    fun getAccountListResponse(
        @Query("user_idx") user_idx : Int
    ): Call<GetAccountListResponse>
}