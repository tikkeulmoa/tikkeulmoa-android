package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calendar.*
import tikkeulmoa.cimile.org.R

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        btn_close.setOnClickListener {
            finish()
        }
    }
}
