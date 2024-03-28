package jmi.gnu.week04_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// 4주차 실습 4-1: 초간단 계산기
class MainActivity : AppCompatActivity() {
    lateinit var edit1: EditText
    lateinit var edit2: EditText

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button

    lateinit var textResult: TextView

    // 계산을 위한 변수
    var num1: Int? = null
    var num2: Int? = null
    var result: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 숫자 입력
        edit1 = findViewById(R.id.edit_num1)
        edit2 = findViewById(R.id.edit_num2)

        // 버튼
        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)
        btnMul = findViewById(R.id.btn_mul)
        btnDiv = findViewById(R.id.btn_div)

        // 결과 text
        textResult = findViewById(R.id.text_result)

        // 더하기
        btnAdd.setOnClickListener {
            num1 = Integer.parseInt(edit1.text.toString())
            num2 = Integer.parseInt(edit2.text.toString())

            result = num1!! + num2!!
            textResult.text = "계산 결과: " + result.toString()
        }

        // 빼기
        btnSub.setOnClickListener {
            num1 = Integer.parseInt(edit1.text.toString())
            num2 = Integer.parseInt(edit2.text.toString())

            result = num1!! - num2!!
            textResult.text = "계산 결과: " + result.toString()
        }

        // 곱하기
        btnMul.setOnClickListener {
            num1 = Integer.parseInt(edit1.text.toString())
            num2 = Integer.parseInt(edit2.text.toString())

            result = num1!! * num2!!
            textResult.text = "계산 결과: " + result.toString()
        }

        // 나누기
        btnDiv.setOnClickListener {
            num1 = Integer.parseInt(edit1.text.toString())
            num2 = Integer.parseInt(edit2.text.toString())

            result = num1!! / num2!!
            textResult.text = "계산 결과: " + result.toString()
        }
    }
}