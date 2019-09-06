package tikkeulmoa.cimile.org.util

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import tikkeulmoa.cimile.org.model.GetAccountListResponse
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponse
import tikkeulmoa.cimile.org.model.PostAccountMakeResponse

interface NetworkService {
    @GET ("/api/details")
    fun getDpsAndWtdrList(@Query("groups_idx") groups_idx : Int): Call<GetDpsAndWtdrListResponse>

    //모임리스트
    @GET ("/api/groups")
    fun getAccountListResponse(
        @Query("user_idx") user_idx : Int
    ): Call<GetAccountListResponse>

    //모임생성
    @POST("/api/group")
    fun postAccountMakeResponse(
        @Header("Content-Type") content_type: String,
        @Body body: JsonObject
    ): Call<PostAccountMakeResponse>
}