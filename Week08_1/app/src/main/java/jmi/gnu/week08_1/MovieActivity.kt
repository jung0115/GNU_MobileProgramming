package jmi.gnu.week08_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView
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

        var galleryAdapter = MyGalleryAdpater(this)
        binding.gallery.adapter = galleryAdapter

    }

    inner class MyGalleryAdpater(var context: Context) : BaseAdapter() {
        var posterId = arrayOf(R.drawable.img_poster1, R.drawable.img_poster2, R.drawable.img_poster3, R.drawable.img_poster4, R.drawable.img_poster5,
            R.drawable.img_poster6, R.drawable.img_poster7, R.drawable.img_poster8, R.drawable.img_poster9, R.drawable.img_poster10)

        override fun getCount(): Int {
            return posterId.size
        }

        override fun getItem(position: Int): Any {
            return posterId[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var imageView: ImageView = if (convertView == null) {
                ImageView(context).apply {
                    layoutParams = Gallery.LayoutParams(200, 300)
                    scaleType = ImageView.ScaleType.FIT_CENTER
                    setPadding(5, 5, 5, 5)
                }
            } else {
                convertView as ImageView
            }
            imageView.setImageResource(posterId[position])

            imageView.setOnClickListener {
                binding.imagePoster.scaleType = ImageView.ScaleType.FIT_CENTER
                binding.imagePoster.setImageResource(posterId[position])
                false
            }

            return imageView
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}