package jmi.gnu.week07_01

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jmi.gnu.week07_01.databinding.ActivityFileBinding
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class FileActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityFileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityFileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWrite.setOnClickListener {
            var outf: FileOutputStream = openFileOutput("file.text", Context.MODE_PRIVATE)
            var str = "쿡북 안드로이드"
            outf.write(str.toByteArray())
            outf.close()
            Toast.makeText(applicationContext, "file.txt가 생성됨", Toast.LENGTH_SHORT).show()
        }

        binding.btnRead.setOnClickListener {
            try {
                var inFs: FileInputStream = openFileInput("file.text")
                var txt = ByteArray(30)
                inFs.read(txt)
                var str = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
                inFs.close()
            } catch (e: IOException) {
                Toast.makeText(applicationContext, "파일 없음", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}