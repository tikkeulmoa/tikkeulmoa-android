package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_write.*
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.ui.community.dialog.CalendarDialog
import tikkeulmoa.cimile.org.ui.community.dialog.VoteDialog

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        vote_exist.visibility = View.GONE
        calender_exist.visibility = View.GONE

        val voteDialog = VoteDialog(this@WriteActivity)
        val calendarDialog = CalendarDialog(this@WriteActivity)

        btn_close.setOnClickListener {
            finish()
        }
        btn_vote.setOnClickListener {
            //투표하는 다이얼로그 띄우기
            voteDialog.show()
        }
        btn_calender.setOnClickListener {
            //일정 다이얼로그 띄우기
            calendarDialog.show()
        }
        btn_confirm.setOnClickListener {
            finish()
        }
    }
}
