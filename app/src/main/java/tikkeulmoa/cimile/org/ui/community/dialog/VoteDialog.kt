package tikkeulmoa.cimile.org.ui.community.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.dialog_vote.*
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.ui.account.AccountDetailActivity
import tikkeulmoa.cimile.org.ui.community.WriteActivity
import tikkeulmoa.cimile.org.util.ApplicationController
import tikkeulmoa.cimile.org.util.NetworkService

class VoteDialog(activity: WriteActivity) : Dialog(activity) {
    init {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_vote)
//        this.setCancelable(false) //뒤로가기,터치 무력화

        btn_finish.setOnClickListener {
            activity.vote_exist.visibility = View.VISIBLE
            dismiss()
        }




    }
}