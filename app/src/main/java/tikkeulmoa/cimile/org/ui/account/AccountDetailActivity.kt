package tikkeulmoa.cimile.org.ui.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_account_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponse
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponseData
import tikkeulmoa.cimile.org.ui.account.adapter.AccountDetailAdapter
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService

class AccountDetailActivity : AppCompatActivity() {

    val groups_idx = intent.getIntExtra("group_idx",-1)

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    var dataList: ArrayList<GetDpsAndWtdrListResponseData> = ArrayList()
    lateinit var accountDetailAdapter: AccountDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_detail)

        initRcv()
        getDpsAndWtdrList()


    }

    private fun getDpsAndWtdrList(){
        val getDpsAndWtdrListResponse = networkService.getDpsAndWtdrList(groups_idx)
        getDpsAndWtdrListResponse.enqueue(object : Callback<GetDpsAndWtdrListResponse>{
            override fun onFailure(call: Call<GetDpsAndWtdrListResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<GetDpsAndWtdrListResponse>,
                response: Response<GetDpsAndWtdrListResponse>
            ) {

                if(response!!.isSuccessful){
                    dataList = response.body()!!.data
                    accountDetailAdapter.dataList = dataList

                }else{

                }
            }

        })
    }

    private fun initRcv(){
        accountDetailAdapter = AccountDetailAdapter(this,dataList)
        rcv_account_detail.adapter = accountDetailAdapter
        rcv_account_detail.layoutManager = LinearLayoutManager(this)
    }
}
