package jmi.gnu.week08_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jmi.gnu.week08_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReturn.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}