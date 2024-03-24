package jmi.gnu.week03homework

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jmi.gnu.week03homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 글자 나타나기
        binding.btnViewText.setOnClickListener {
            Toast.makeText(applicationContext, binding.edittext.text,
                Toast.LENGTH_SHORT).show()
        }

        // 홈페이지 열기
        binding.btnOpenPage.setOnClickListener {
            // url을 브라우저 앱에서 실행
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.edittext.text.toString()))
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}