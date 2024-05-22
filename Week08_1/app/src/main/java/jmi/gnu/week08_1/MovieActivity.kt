package jmi.gnu.week08_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import jmi.gnu.week08_1.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding
        _binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    inner class MyGalleryAdpater(var context: Context) : BaseAdapter() {
        var posterId = arrayOf(R.drawable.img_poster1)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}