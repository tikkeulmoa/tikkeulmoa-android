package tikkeulmoa.cimile.org.util

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import tikkeulmoa.cimile.org.model.*

interface NetworkService {
    //입출금 내역 조회
    @GET ("/api/details")
    fun getDpsAndWtdrList(@Query("groups_idx") groups_idx : Int
    ): Call<GetDpsAndWtdrListResponse>

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

    //입금
    @POST("/api/deposit")
    fun postDepositResponse(
        @Body body: PostDepositResponseData
    ):Call<PostDepositResponse>
}