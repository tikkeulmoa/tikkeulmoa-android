package tikkeulmoa.cimile.org.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.ui.MainActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        btn_login_act_login.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
    }
}
