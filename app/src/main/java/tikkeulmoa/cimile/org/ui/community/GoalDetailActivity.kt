package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_goal_detail.*
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.ui.community.dialog.GoalDialog

class GoalDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal_detail)

        goal1.setOnClickListener {
            goal1.visibility = View.GONE
            goal2.visibility = View.VISIBLE
            goal3.visibility = View.GONE
        }
        goal2.setOnClickListener {
            goal1.visibility = View.GONE
            goal2.visibility = View.GONE
            goal3.visibility = View.VISIBLE
        }

        btn_back.setOnClickListener {
            finish()
        }

        val goalDialog = GoalDialog(this)
        btn_edit.setOnClickListener {
            goalDialog.show()
        }
    }
}
