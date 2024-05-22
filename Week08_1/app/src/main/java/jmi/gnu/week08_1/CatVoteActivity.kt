package jmi.gnu.week08_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jmi.gnu.week08_1.databinding.ActivityCatVoteBinding

class CatVoteActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityCatVoteBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding
        _binding = ActivityCatVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var voteCount = IntArray(6, {0})
        var imageBinding = arrayOf(binding.imgCat1, binding.imgCat2, binding.imgCat3,
            binding.imgCat4, binding.imgCat5, binding.imgCat6)
        var imageName = arrayOf("고양이1", "고양이2", "고양이3", "고양이4", "고양이5", "고양이6")

        for(i in imageBinding.indices) {
            imageBinding[i].setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imageName[i] + ": 총 " + voteCount[i] + " 표", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnResult.setOnClickListener {
            var intent = Intent(applicationContext, CatResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imageName)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}