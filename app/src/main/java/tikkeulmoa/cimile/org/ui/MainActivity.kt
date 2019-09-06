package tikkeulmoa.cimile.org.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.GetAccountListResponse
import tikkeulmoa.cimile.org.model.AccountData
import tikkeulmoa.cimile.org.ui.account.AccountMakingActivity
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService

class MainActivity : AppCompatActivity() {


    val user_idx :Int = 1
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    var dataList: ArrayList<AccountData> = ArrayList()
    lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        getAccountListResponse()
        setOnClickListener()
    }

   fun getAccountListResponse() {
        val getAccountListResponse = networkService.getAccountListResponse(user_idx)
        getAccountListResponse.enqueue(object : Callback<GetAccountListResponse> {
            override fun onFailure(call: Call<GetAccountListResponse>, t: Throwable) {
                Log.e("getAccountList_Fail", t.toString())
            }

            override fun onResponse(call: Call<GetAccountListResponse>, response: Response<GetAccountListResponse>) {
                if(response.isSuccessful) {
                    Log.d("getAccountList", response.body().toString())
                    val temp: ArrayList<AccountData> = response.body()!!.data
                    if(temp.size>0) {
                        val position = mainRecyclerViewAdapter.itemCount
                        mainRecyclerViewAdapter.dataList.addAll(temp)
                        mainRecyclerViewAdapter.notifyItemInserted(position)
                    }

                }
            }
        })
    }

    fun setRecyclerView() {
        mainRecyclerViewAdapter = MainRecyclerViewAdapter(this, dataList)
        rv_main_act_list.adapter = mainRecyclerViewAdapter
        rv_main_act_list.layoutManager = LinearLayoutManager(this)
    }

    fun setOnClickListener() {
        btn_main_act_make_account.setOnClickListener {
            startActivity<AccountMakingActivity>()
            finish()
        }
    }
}
