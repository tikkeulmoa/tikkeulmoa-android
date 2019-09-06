package tikkeulmoa.cimile.org.ui.account.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_account_detail.*
import kotlinx.android.synthetic.main.dialog_deposit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponse
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponseData
import tikkeulmoa.cimile.org.model.PostDepositResponse
import tikkeulmoa.cimile.org.model.PostDepositResponseData
import tikkeulmoa.cimile.org.ui.account.AccountDetailActivity
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService
import java.io.IOException
import java.lang.Exception

class DepositDialog(activity: AccountDetailActivity, groups_idx: Int, addr : String) : Dialog(activity) {
    var mActivity: AccountDetailActivity = activity

    init{

        val networkService: NetworkService by lazy {
            ApplicationController.instance.networkService
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_deposit)
//        this.setCancelable(false) //뒤로가기,터치 무력화

        address.text = addr

        btn_real_deposit.setOnClickListener {


            var user_idx = 1
            var groups_idx = groups_idx
            try{
                var price = Integer.parseInt(deposit_money.text.toString())
                var memo = deposit_memo.text.toString()
                postDeposit(networkService, user_idx, groups_idx, price, memo)
            }catch (ex : Exception){
                Toast.makeText(mActivity,"올바른 값을 입력해주세요!",Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun postDeposit(networkService:NetworkService,user_idx:Int,groups_idx:Int,price:Int,memo:String){

        val postDepositResponseData = PostDepositResponseData(user_idx, groups_idx, price, memo)
        val postDepositResponse = networkService.postDepositResponse(postDepositResponseData)
        postDepositResponse.enqueue(object : Callback<PostDepositResponse>{
            override fun onFailure(call: Call<PostDepositResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<PostDepositResponse>, response: Response<PostDepositResponse>) {
                if(response.isSuccessful){
                    Toast.makeText(mActivity,"입금이 완료되었습니다!",Toast.LENGTH_SHORT).show()

                    mActivity.getDpsAndWtdrList(networkService,groups_idx)
                    mActivity.account_detail_money.text = (mActivity.account_money+price).toString()

                    deposit_memo.text = null
                    deposit_money.text = null
                    password_deposit.text = null

                    dismiss()

                }else{

                }
            }

        })

    }

}