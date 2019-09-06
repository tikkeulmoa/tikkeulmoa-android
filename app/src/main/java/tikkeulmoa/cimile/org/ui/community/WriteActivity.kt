package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_write.*
import tikkeulmoa.cimile.org.R

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        btn_close.setOnClickListener {
            finish()
        }
        btn_vote.setOnClickListener {
            //투표하는 다이얼로그 띄우기
        }
        btn_calender.setOnClickListener {
            //일정 다이얼로그 띄우기
        }
        btn_confirm.setOnClickListener {
            finish()
        }
    }
}
