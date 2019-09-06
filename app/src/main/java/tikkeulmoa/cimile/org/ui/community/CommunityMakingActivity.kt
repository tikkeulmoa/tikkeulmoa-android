package tikkeulmoa.cimile.org.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_community_making.*
import tikkeulmoa.cimile.org.R

class CommunityMakingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_making)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        btn_close.setOnClickListener {
            finish()
        }

        btn_next.setOnClickListener {
            finish()
        }
    }
}
