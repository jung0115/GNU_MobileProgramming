package jmi.gnu.week05_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import jmi.gnu.week05_2.databinding.ActivityMain3Binding

class MainActivity4 : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityMain3Binding? = null
    private val binding get() = _binding!!

    // 계산을 위한 변수
    var num1: String = ""
    var num2: String = ""
    var result: Int? = null

    private var numButtons: MutableList<Button>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 숫자 버튼
        numButtons = mutableListOf(binding.btnNum0, binding.btnNum1, binding.btnNum2, binding.btnNum3, binding.btnNum4,
            binding.btnNum5, binding.btnNum6, binding.btnNum7, binding.btnNum8, binding.btnNum9)

        var i: Int = 0
        for(i in 0..(numButtons!!.size - 1) step 1) {
            numButtons!![i].setOnClickListener {
                if(binding.editNum1.isFocused == true) {
                    num1 = binding.editNum1.text.toString() + numButtons!![i].text.toString()
                    binding.editNum1.setText(num1)
                }
                else if(binding.editNum2.isFocused == true) {
                    num2 = binding.editNum2.text.toString() + numButtons!![i].text.toString()
                    binding.editNum2.setText(num2)
                }
                else {
                    Toast.makeText(applicationContext,
                        "먼저 EditText를 선택하세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // 더하기
        binding.btnAdd.setOnClickListener {
            num1 = binding.editNum1.text.toString()
            num2 = binding.editNum2.text.toString()

            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            binding.textResult.text = "계산 결과: " + result.toString()
        }

        // 빼기
        binding.btnSub.setOnClickListener {
            num1 = binding.editNum1.text.toString()
            num2 = binding.editNum2.text.toString()

            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            binding.textResult.text = "계산 결과: " + result.toString()
        }

        // 곱하기
        binding.btnMul.setOnClickListener {
            num1 = binding.editNum1.text.toString()
            num2 = binding.editNum2.text.toString()

            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            binding.textResult.text = "계산 결과: " + result.toString()
        }

        // 나누기
        binding.btnDiv.setOnClickListener {
            num1 = binding.editNum1.text.toString()
            num2 = binding.editNum2.text.toString()

            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            binding.textResult.text = "계산 결과: " + result.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}