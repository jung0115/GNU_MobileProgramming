package jmi.gnu.week07_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import jmi.gnu.week07_01.databinding.ActivityUserBinding

// 실습 7-3: 사용자 정보 입력 앱 만들기
class UserActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityUserBinding? = null
    private val binding get() = _binding!!

    lateinit var dialogView: View
    lateinit var toastView: View
    lateinit var dlgEdtName: EditText
    lateinit var dlgEdtEmail: EditText
    lateinit var toastText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "사용자 정보 입력"

        binding.button1.setOnClickListener {
            dialogView = View.inflate(this@UserActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@UserActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.icon)
            dlg.setView(dialogView)

            dlg.setPositiveButton("확인") { dialog, which ->
                dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
                dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)

                binding.tvName.text = dlgEdtName.text.toString()
                binding.tvEmail.text = dlgEdtEmail.text.toString()
            }

            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this@UserActivity)
                toastView = View.inflate(this@UserActivity, R.layout.toast1, null)
                toastText = toastView.findViewById<TextView>(R.id.toastText1)
                toastText.text = "취소했습니다"
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}