package jmi.gnu.week07_01

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jmi.gnu.week07_01.databinding.ActivitySimpleDiaryBinding
import java.io.FileInputStream
import java.io.IOException
import java.util.Calendar

// 8-1 간단 일기장 앱 만들기
class SimpleDiaryActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivitySimpleDiaryBinding? = null
    private val binding get() = _binding!!

    lateinit var fileName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivitySimpleDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "간단 일기장"

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        binding.datePicker1.init(cYear, cMonth, cDay) { view, year, monthOfYear, dayOfMonth ->
            fileName = (Integer.toString(year) + "_"
                    + Integer.toString(monthOfYear + 1) + "_"
                    + Integer.toString(dayOfMonth + 1) + ".txt")
            val str = readDiary(fileName)
            binding.edtDiary.setText(str)
            binding.btnWrite.isEnabled = true
        }
        binding.btnWrite.setOnClickListener {
            var outFs = openFileOutput(fileName, Context.MODE_PRIVATE)
            var str = binding.edtDiary.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        }
    }

    fun readDiary(fName: String) : String? {
        var diaryStr: String? = null
        var inFs: FileInputStream
        try {
            inFs = openFileInput(fName)
            var txt = ByteArray(500)
            inFs.read(txt)
            inFs.close()
            diaryStr = txt.toString(Charsets.UTF_8).trim()
            binding.btnWrite.text = "수정하기"
        } catch (e: IOException) {
            binding.edtDiary.hint = "일기 없음"
            binding.btnWrite.text = "새로 저장"
        }

        return diaryStr
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}