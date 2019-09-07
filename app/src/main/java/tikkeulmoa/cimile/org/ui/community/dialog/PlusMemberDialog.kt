package tikkeulmoa.cimile.org.ui.community.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import kotlinx.android.synthetic.main.dialog_plus_member.*
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.ui.community.CommunityDetailActivity

class PlusMemberDialog(activity: CommunityDetailActivity) : Dialog(activity) {
    init {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_plus_member)
//        this.setCancelable(false) //뒤로가기,터치 무력화

        btn_plus.setOnClickListener {
            dismiss()
        }
    }
}