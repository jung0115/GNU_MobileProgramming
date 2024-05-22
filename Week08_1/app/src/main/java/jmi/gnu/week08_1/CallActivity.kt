package jmi.gnu.week08_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jmi.gnu.week08_1.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityCallBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding
        _binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        android.util.Log.i("액티비티 테스트", "onCreate()")

        binding.btnDial.setOnClickListener {
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        binding.btnFinish.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        android.util.Log.i("액티비티 테스트", "onDestroy()")
        _binding = null
    }
}