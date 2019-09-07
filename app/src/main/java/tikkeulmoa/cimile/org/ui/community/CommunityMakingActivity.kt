package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_community_making.*
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.PostCommunityResponse
import tikkeulmoa.cimile.org.ui.MainActivity
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService

class CommunityMakingActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    var group_idx = 0
    var jsonObject = JSONObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_making)

        group_idx = intent.getIntExtra("group_idx",-1)
        setOnClickListener()



    }

    private fun setOnClickListener() {
        btn_close.setOnClickListener {
            finish()
        }

        btn_next.setOnClickListener {
            postCommunity(group_idx)
            finish()
            startActivity<MainActivity>()
        }
    }

    fun postCommunity(group_idx:Int){

        jsonObject.put("groups_idx",group_idx)
        val gsonObject = JsonParser().parse(jsonObject.toString().toString()) as JsonObject

        val postCommunityResponse = networkService.postCommunity("application/json",gsonObject)


        postCommunityResponse.enqueue(object : Callback<PostCommunityResponse>{
            override fun onFailure(call: Call<PostCommunityResponse>, t: Throwable) {


            }

            override fun onResponse(call: Call<PostCommunityResponse>, response: Response<PostCommunityResponse>) {
                if(response.isSuccessful){
                    Toast.makeText(applicationContext,"커뮤니티 개설이 완료되었습니다 :)",Toast.LENGTH_SHORT).show()
                }else{

                }

            }

        })
    }
}
