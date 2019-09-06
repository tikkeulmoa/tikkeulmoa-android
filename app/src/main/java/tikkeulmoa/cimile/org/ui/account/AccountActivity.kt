package tikkeulmoa.cimile.org.ui.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_account.*
import tikkeulmoa.cimile.org.R

class AccountActivity : AppCompatActivity() {

    var click_flag = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        img_account_certificate.visibility = View.INVISIBLE
        layout_account_third.visibility = View.GONE

        btn_next.setOnClickListener { //다음 버튼 눌렀을 때
            click_flag ++
            if(click_flag == 2){
                img_account_agree.visibility = View.INVISIBLE
                img_account_certificate.visibility = View.VISIBLE
            }else if(click_flag == 3){
                img_account_certificate.visibility = View.INVISIBLE
                layout_account_third.visibility = View.VISIBLE
                btn_next.
                    text = "완 료"
            }


        }

        btn_close.setOnClickListener {
            //정말 취소할꺼냐는 다이얼로그 추가
        }



    }
}
