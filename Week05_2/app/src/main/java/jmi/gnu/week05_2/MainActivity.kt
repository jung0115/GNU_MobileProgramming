package jmi.gnu.week05_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0))
        setContentView(baseLayout, params)

        var btn = Button(this)
        btn.text = "버튼입니다"
        btn.setBackgroundColor(Color.MAGENTA)
        baseLayout.addView(btn)

        btn.setOnClickListener {
            Toast.makeText(applicationContext,
                "코드로 생성한 버튼입니다", Toast.LENGTH_SHORT).show()
        }
    }
}