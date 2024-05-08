package jmi.gnu.week07_01

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import jmi.gnu.week07_01.databinding.ActivityToastBinding
import jmi.gnu.week07_01.databinding.CustomToastBinding


class ToastActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityToastBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityToastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "토스트 연습"

        binding.buttonToast.setOnClickListener {
            // API 29 이하에만 적용 가능한 방법
            /*var tMsg = Toast.makeText(applicationContext, "토스트 연습", Toast.LENGTH_SHORT)

            var display = (getSystemService(Context.WINDOW_SERVICE) as
                    WindowManager).defaultDisplay
            var xOffset = (Math.random() * display.width).toInt()
            var yOffset = (Math.random() * display.height).toInt()

            tMsg.setGravity(Gravity.TOP or Gravity.START, xOffset, yOffset)
            tMsg.show()*/

            val inflater = LayoutInflater.from(this)
            val toastBinding = CustomToastBinding.inflate(inflater, null, false)

            toastBinding.toastText.text = "Custom Toast - setGravity"

            Toast(this).apply {
                setGravity(Gravity.BOTTOM or Gravity.CENTER, 200, 500)
                duration = Toast.LENGTH_LONG
                view = toastBinding.root
            }.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}