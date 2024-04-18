package jmi.gnu.week06_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import jmi.gnu.week06_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    var selectYear: Int = 0
    var selectMonth: Int = 0
    var selectDay: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 날짜, 시간 설정 가리기
        binding.calendarview1.visibility = View.INVISIBLE
        binding.timepicker1.visibility = View.INVISIBLE

        // 날짜 설정 라디오 버튼 선택
        binding.radioCal.setOnClickListener {
            binding.calendarview1.visibility = View.VISIBLE
            binding.timepicker1.visibility = View.INVISIBLE
        }

        // 시간 설정 라디오 버튼 선택
        binding.radioTime.setOnClickListener {
            binding.calendarview1.visibility = View.INVISIBLE
            binding.timepicker1.visibility = View.VISIBLE
        }

        // 예약 시작 버튼
        binding.btnStart.setOnClickListener {
            binding.chronometer1.base = SystemClock.elapsedRealtime()
            binding.chronometer1.start()
            binding.chronometer1.setTextColor(Color.RED)
        }

        // 예약 완료 버튼
        binding.btnEnd.setOnClickListener {
            binding.chronometer1.stop()
            binding.chronometer1.setTextColor(Color.BLUE)

            // 예약 완료 버튼 옆 텍스트 변경
            binding.textYear.text = selectYear.toString() + "년"
            binding.textMonth.text = selectMonth.toString() + "월"
            binding.textDay.text = selectDay.toString() + "일"

            binding.textHour.text = binding.timepicker1.currentHour.toString() + "시"
            binding.textMinute.text = binding.timepicker1.currentMinute.toString() + "분"
        }

        // 날짜 설정
        binding.calendarview1.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}