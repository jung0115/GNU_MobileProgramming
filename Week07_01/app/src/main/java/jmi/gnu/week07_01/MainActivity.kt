package jmi.gnu.week07_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import jmi.gnu.week07_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.itemRed -> {
                binding.baseLayout.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemGreen -> {
                binding.baseLayout.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.itemBlue -> {
                binding.baseLayout.setBackgroundColor(Color.BLUE)
                return true
            }
            R.id.subRotate -> {
                binding.button1.rotation = 45f
                return true
            }
            R.id.subSize -> {
                binding.button1.scaleX = 2f
                return true
            }
        }

        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}