package jmi.gnu.week04_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jmi.gnu.week04_1.databinding.ActivityAnimalBinding

// 4주차 실습 4-11: 동물 사진 보여주기
class AnimalActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityAnimalBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 시작함 체크박스
        binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(binding.checkbox.isChecked == true) {
                binding.textAnimal.visibility = View.VISIBLE
                binding.radioGroup.visibility = View.VISIBLE
                binding.btnCheck.visibility = View.VISIBLE
                binding.textAnimal.visibility = View.VISIBLE
                binding.imgAnimal.visibility = View.VISIBLE
            }
            else {
                binding.textAnimal.visibility = View.INVISIBLE
                binding.radioGroup.visibility = View.INVISIBLE
                binding.btnCheck.visibility = View.INVISIBLE
                binding.textAnimal.visibility = View.INVISIBLE
                binding.imgAnimal.visibility = View.INVISIBLE
            }
        }

        // 선택 완료 버튼
        binding.btnCheck.setOnClickListener {
            when(binding.radioGroup.checkedRadioButtonId) {
                binding.radioDog.id -> binding.imgAnimal.setImageResource(R.drawable.img_dog)
                binding.radioCat.id -> binding.imgAnimal.setImageResource(R.drawable.img_cat)
                binding.radioRabbit.id -> binding.imgAnimal.setImageResource(R.drawable.img_rabbit)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}