package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notice_all.*
import tikkeulmoa.cimile.org.R

class NoticeAllActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_all)

        btn_close.setOnClickListener {
            finish()
        }
    }
}
