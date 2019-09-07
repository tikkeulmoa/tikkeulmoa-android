package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_community_detail.*
import org.jetbrains.anko.startActivity
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.ui.calendar.CalendarActivity
import tikkeulmoa.cimile.org.ui.community.dialog.PlusMemberDialog

class CommunityDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_detail)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        val plusMemberDialog = PlusMemberDialog(this@CommunityDetailActivity)
        btn_community_detail_act_notice_all.setOnClickListener {
            startActivity<NoticeAllActivity>()
        }
        btn_write.setOnClickListener {
            startActivity<WriteActivity>()
        }
        btn_community_detail_act_plus_member.setOnClickListener {
            plusMemberDialog.show()
        }
        btn_calendar_go.setOnClickListener {
            startActivity<CalendarActivity>()
        }
        btn_goal_go.setOnClickListener {
            startActivity<GoalDetailActivity>()
        }
    }
}