package tikkeulmoa.cimile.org.ui.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_account_making.*
import okhttp3.MultipartBody
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Multipart
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.PostAccountMakeResponse
import tikkeulmoa.cimile.org.ui.MainActivity
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService

class AccountMakingActivity : AppCompatActivity() {

    var click_flag = 1
    val user_idx :Int = 1
    var name: String = " "
    var pw: Int = -1
    var jsonObject = JSONObject()
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_making)

        img_account_certificate.visibility = View.INVISIBLE
        layout_account_third.visibility = View.GONE

        setOnClickListener()

    }

    private fun postAccountMakeResponse() {
        val gsonObject = JsonParser().parse(jsonObject.toString().toString()) as JsonObject
        val postAccountMakeResponse = networkService.postAccountMakeResponse("application/json",gsonObject)
        postAccountMakeResponse.enqueue(object : Callback<PostAccountMakeResponse> {
            override fun onFailure(call: Call<PostAccountMakeResponse>, t: Throwable) {
                Log.e("postAccountMake_Fail", t.toString())
            }

            override fun onResponse(call: Call<PostAccountMakeResponse>, response: Response<PostAccountMakeResponse>) {
                if (response.isSuccessful) {
                    Log.d("getAccountList", response.body().toString())
                }
            }
        })
    }
    private fun setOnClickListener() {
        btn_next.setOnClickListener { //다음 버튼 눌렀을 때
            click_flag ++
            if(click_flag == 2){
                img_account_agree.visibility = View.INVISIBLE
                img_account_certificate.visibility = View.VISIBLE
            }else if(click_flag == 3){
                img_account_certificate.visibility = View.INVISIBLE
                layout_account_third.visibility = View.VISIBLE
                btn_next.text = "완 료"
            } else if(click_flag == 4) {
                name = account_name.text.toString()
                pw = Integer.parseInt(account_password.text.toString())
                jsonObject.put("user_idx",user_idx)
                jsonObject.put("name", name)
                jsonObject.put("pw",pw)
                postAccountMakeResponse()
                startActivity<MainActivity>()
                finish()
            }
        }

        btn_close.setOnClickListener {
            //정말 취소할꺼냐는 다이얼로그 추가
            finish()
            startActivity<MainActivity>()
        }
    }
}
