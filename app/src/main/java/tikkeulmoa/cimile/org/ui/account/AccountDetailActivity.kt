package tikkeulmoa.cimile.org.ui.account


import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_account_detail.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponse
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponseData
import tikkeulmoa.cimile.org.ui.MainActivity
import tikkeulmoa.cimile.org.ui.account.adapter.AccountDetailAdapter
import tikkeulmoa.cimile.org.ui.account.dialog.DepositDialog
import tikkeulmoa.cimile.org.ui.account.dialog.WithdrawDialog
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService
import java.text.DecimalFormat


class AccountDetailActivity : AppCompatActivity() {

    var groups_idx : Int = 0
    var account_money : Int = 0

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    lateinit var mainActivity: MainActivity

    var dataList: ArrayList<GetDpsAndWtdrListResponseData> = ArrayList()
    lateinit var accountDetailAdapter: AccountDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_detail)

        mainActivity = MainActivity()

        groups_idx = intent.getIntExtra("group_idx",-1)
        var account_name = intent.getStringExtra("account_name")
        var account_num = intent.getStringExtra("account_num")
        account_money = intent.getIntExtra("account_money",-1)


        val depositDialog = DepositDialog(this@AccountDetailActivity,groups_idx,account_num)
        val withdrawDialog = WithdrawDialog(this@AccountDetailActivity,groups_idx,account_money)

        account_detail_name.text = account_name
        account_detail_number.text = account_num
        account_detail_money.text = insertComma(account_money)


        initRcv()
        getDpsAndWtdrList(networkService,groups_idx)

        btn_deposit.setOnClickListener {
            depositDialog.show()
        }
        btn_withdraw.setOnClickListener {
            withdrawDialog.show()
        }


    }

    fun getDpsAndWtdrList(networkService: NetworkService,groups_idx:Int){
        val getDpsAndWtdrListResponse = networkService.getDpsAndWtdrList(groups_idx)
        getDpsAndWtdrListResponse.enqueue(object : Callback<GetDpsAndWtdrListResponse>{
            override fun onFailure(call: Call<GetDpsAndWtdrListResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<GetDpsAndWtdrListResponse>,
                response: Response<GetDpsAndWtdrListResponse>
            ) {

                if(response.isSuccessful){
                    if(response.body()!!.data!=null){
                        dataList = response.body()!!.data
                        accountDetailAdapter.dataList = dataList

                        rcv_account_detail.adapter = accountDetailAdapter
                    }


                }else{

                }
            }

        })
    }

    private fun initRcv(){
        accountDetailAdapter = AccountDetailAdapter(this,dataList)
        rcv_account_detail.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity<MainActivity>()
        finish()

    }

    fun insertComma(money:Int):String{
        val formatter = DecimalFormat("###,###")
        return formatter.format(money)
    }

}
