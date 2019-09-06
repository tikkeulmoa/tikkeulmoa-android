package tikkeulmoa.cimile.org.ui.account.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_account_detail.*
import kotlinx.android.synthetic.main.dialog_deposit.*
import kotlinx.android.synthetic.main.dialog_withdraw.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.PostDepositResponse
import tikkeulmoa.cimile.org.model.PostDepositResponseData
import tikkeulmoa.cimile.org.model.PostWithdrawResponse
import tikkeulmoa.cimile.org.model.PostWithdrawResponseData
import tikkeulmoa.cimile.org.ui.account.AccountDetailActivity
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService
import java.lang.Exception

class WithdrawDialog(activity: AccountDetailActivity, groups_idx: Int, money : Int) : Dialog(activity)  {

    var mActivity: AccountDetailActivity = activity
    var click_flag = 1

    init {
        val networkService: NetworkService by lazy {
            ApplicationController.instance.networkService
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_withdraw)
//        this.setCancelable(false) //뒤로가기,터치 무력화

        img_withdraw_agree.visibility = View.INVISIBLE
        can_withdraw_money.text = money.toString()

        var user_idx = 1
        var groups_idx = groups_idx
        var price = 0
        var memo = ""


        btn_real_withdraw.setOnClickListener {
            if(click_flag == 1){
                this.setCancelable(false) //뒤로가기,터치 무력화
                if(withdraw_money.text.toString()!=""){
                    price = Integer.parseInt(withdraw_money.text.toString())
                    memo = withdraw_memo.text.toString()

                    withdraw_memo.text = null
                    withdraw_money.text = null
                    withdraw_address.text = null
                    password_withdraw.text = null

                    layout_withdraw.visibility = View.GONE
                    img_withdraw_agree.visibility = View.VISIBLE
                    btn_real_withdraw.setImageResource(R.drawable.btn_real_withdraw)

                    click_flag++
                }else {
                    Toast.makeText(mActivity,"올바른 값을 입력해주세요!",Toast.LENGTH_SHORT).show()
                }

            }else if(click_flag == 2){

                postWithdraw(networkService, user_idx, groups_idx, price, memo)

            }



        }



    }

    private fun postWithdraw(networkService:NetworkService,user_idx:Int,groups_idx:Int,price:Int,memo:String){

        val postWithdrawResponseData = PostWithdrawResponseData(user_idx, groups_idx, price, memo)
        val postWithdrawResponse = networkService.postWithdrawResponse(postWithdrawResponseData)
        postWithdrawResponse.enqueue(object : Callback<PostWithdrawResponse> {
            override fun onFailure(call: Call<PostWithdrawResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<PostWithdrawResponse>, response: Response<PostWithdrawResponse>) {
                if(response.isSuccessful){
                    Toast.makeText(mActivity,"출금이 완료되었습니다!",Toast.LENGTH_SHORT).show()

                    mActivity.getDpsAndWtdrList(networkService,groups_idx)
                    mActivity.account_detail_money.text = (mActivity.account_money-price).toString()

                    dismiss()

                }else{

                }
            }

        })

    }
}