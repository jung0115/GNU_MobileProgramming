package jmi.gnu.week08_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jmi.gnu.week08_1.databinding.ActivityCatResultBinding

class CatResultActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityCatResultBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding
        _binding = ActivityCatResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        var text = arrayOf(binding.text1, binding.text2, binding.text3,
                binding.text4, binding.text5, binding.text6)
        var rating = arrayOf(binding.rating1, binding.rating2, binding.rating3,
            binding.rating4, binding.rating5, binding.rating6)

        for(i in 0..5) {
            text[i].setText(imageName!![i])
            rating[i].setRating(voteResult!![i].toFloat())
        }

        binding.btnReturn.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}