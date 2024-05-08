package jmi.gnu.week07_01

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import jmi.gnu.week07_01.databinding.ActivityToastBinding

class ToastActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityToastBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        // ViewBinding
        _binding = ActivityToastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "토스트 연습"

        binding.buttonToast.setOnClickListener {
            var tMsg = Toast.makeText(applicationContext, "토스트 연습", Toast.LENGTH_SHORT)

            var display = (getSystemService(Context.WINDOW_SERVICE) as
                    WindowManager).defaultDisplay
            var xOffset = (Math.random() * display.width).toInt()
            var yOffset = (Math.random() * display.height).toInt()

            tMsg.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)
            tMsg.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}