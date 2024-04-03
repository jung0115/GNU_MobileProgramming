package jmi.gnu.week05_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jmi.gnu.week05_2.databinding.ActivityMain3Binding

class MainActivity4 : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityMain3Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}