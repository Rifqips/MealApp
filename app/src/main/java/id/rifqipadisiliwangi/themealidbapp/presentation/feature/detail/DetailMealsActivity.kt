package id.rifqipadisiliwangi.themealidbapp.presentation.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import id.rifqipadisiliwangi.themealidbapp.R
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDataItem
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import id.rifqipadisiliwangi.themealidbapp.databinding.ActivityDetailMealsBinding
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.CategorieMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.SearchMealsItem
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.viewmodel.BookmarkViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.regex.Pattern


private const val TAG = "DetailsActivity"
class DetailMealsActivity : AppCompatActivity() {

    private lateinit var youTubePlayer: YouTubePlayer
    private var youtubeID : String = ""
    private var ivStrMealThumb : String = ""
    private var tvStrMeal : String = ""
    private var tvStrArea : String = ""
    private var tvStrInstructions : String = ""
    private var youtubePlayerView : String = ""
    private var tvIdMeal : String = ""
    private var tvStrCategory : String = ""

    private var dbHistory : BookmarkDatabase? = null


    private val binding : ActivityDetailMealsBinding by lazy {
        ActivityDetailMealsBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailViewModel by viewModel{
        parametersOf(intent.extras ?: bundleOf())
    }
    private lateinit var bookmarkViewModel: BookmarkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bookmarkViewModel = ViewModelProvider(this).get(BookmarkViewModel::class.java)
        dbHistory = BookmarkDatabase.getInstance(this)
        showDetailMeals(viewModel.meals)
        showDetailSearch(viewModel.mealsSearch)
        showDetailMealsCategories(viewModel.mealsCategories)
        showDetailMealsAreas(viewModel.mealsAreas)
        setClickListener()
        getYoutube()
        setOnClickListener()
    }
    private fun setOnClickListener() {
        binding.let {
            it.ivBookmart.setOnClickListener {
                addBookmark()
                binding.ivBookmart.setImageResource(R.drawable.ic_bookmart_filled)
            }
        }
    }

    private fun showDetailMeals(meals: AllMealsItem?) {
        meals?.let {
            ivStrMealThumb = it.strMealThumb.toString()
            tvStrMeal = it.strMeal.toString()
            tvStrArea = it.strArea.toString()
            tvStrInstructions = it.strInstructions.toString()
            youtubePlayerView = it.strYoutube.toString()
            tvIdMeal = it.idMeal.toString()
            tvStrCategory = it.strCategory.toString()

            binding.ivStrMealThumb.load(it.strMealThumb)
            binding.tvStrMeal.text = it.strMeal
            binding.tvStrArea.text = it.strArea
            binding.tvStrCategory.text = it.strCategory
            binding.tvStrInstructions.text = it.strInstructions
            binding.tvIdMeal.text = it.idMeal
            youtubeID = getYouTubeVideoId(it.strYoutube.toString()).toString()
            Log.d(TAG, "${getYouTubeVideoId(it.strYoutube.toString())}")
        }

    }

    private fun showDetailSearch(meals: SearchMealsItem?) {
        meals?.let {
            ivStrMealThumb = it.strMealThumb.toString()
            tvStrMeal = it.strMeal.toString()
            tvStrArea = it.strArea.toString()
            tvStrInstructions = it.strInstructions.toString()
            youtubePlayerView = it.strYoutube.toString()
            tvIdMeal = it.idMeal.toString()
            tvStrCategory = it.strCategory.toString()

            binding.ivStrMealThumb.load(it.strMealThumb)
            binding.tvStrMeal.text = it.strMeal
            binding.tvStrArea.text = it.strArea
            binding.tvStrInstructions.text = it.strInstructions
            binding.tvIdMeal.text = it.idMeal
            youtubeID = getYouTubeVideoId(it.strYoutube.toString()).toString()
            Log.d(TAG, "${getYouTubeVideoId(it.strYoutube.toString())}")
        }

    }

    private fun showDetailMealsCategories(meals: CategorieMealsItem?) {
        meals?.let {
            ivStrMealThumb = it.strMealThumb.toString()
            tvStrMeal = it.strMeal.toString()
            tvIdMeal = it.idMeal.toString()

            binding.ivStrMealThumb.load(it.strMealThumb)
            binding.tvStrMeal.text = it.strMeal
            binding.tvIdMeal.text = it.idMeal
        }

    }

    private fun showDetailMealsAreas(meals: CategorieMealsItem?) {
        meals?.let {
            ivStrMealThumb = it.strMealThumb.toString()
            tvStrMeal = it.strMeal.toString()
            tvIdMeal = it.idMeal.toString()

            binding.ivStrMealThumb.load(it.strMealThumb)
            binding.tvStrMeal.text = it.strMeal
            binding.tvIdMeal.text = it.idMeal
        }

    }

    private fun setClickListener() {
        binding.ivBackHome.setOnClickListener {
            onBackPressed()
        }
    }

    fun getYouTubeVideoId(link: String): String? {
        val pattern = "(?<=youtu\\.be/|watch\\?v=|/videos/|embed\\/|youtu\\.be\\/|watch\\?v=|\\/videos\\/|embed\\/|watch\\?feature=player_embedded&v=|embed/videoseries\\?list=)([^#\\&\\?\\n]*)"
        val compiledPattern = Pattern.compile(pattern)
        val matcher = compiledPattern.matcher(link)

        return if (matcher.find()) {
            matcher.group()
        } else {
            null
        }
    }

    private fun getYoutube(){
        val youtubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                this@DetailMealsActivity.youTubePlayer = youTubePlayer

                Log.d(TAG, youtubeID)
                youTubePlayer.cueVideo(youtubeID, 0.0F)
                youTubePlayer.play()
                youTubePlayer.addListener(object : AbstractYouTubePlayerListener() {
                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        super.onStateChange(youTubePlayer, state)
                    }
                })
            }
        }
        binding.youtubePlayerView.initialize(youtubePlayerListener)
    }
    private fun addBookmark(){
        GlobalScope.async {
            dbHistory!!.bookmarkDao().insertBookmark(BookmarkDataItem(0,
                ivStrMealThumb,
                tvStrMeal,
                tvStrArea,
                tvStrInstructions,
                youtubePlayerView,
                tvIdMeal,
                tvStrCategory)
            )
            Log.d("ListBookmark", dbHistory.toString())
        }
        Toast.makeText(this, "Success Added to Bookmark", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_MENU = "EXTRA_MENU"
        const val EXTRA_CATEGORIES = "EXTRA_CATEGORIES"
        const val EXTRA_SEARCH = "EXTRA_SEARCH"
        const val EXTRA_AREAS = "EXTRA_AREAS"

        fun startActivity(context: Context, menu: AllMealsItem) {
            val intent = Intent(context, DetailMealsActivity::class.java)
            intent.putExtra(EXTRA_MENU, menu)
            context.startActivity(intent)
        }

        fun startActivitySearch(context: Context, menu: SearchMealsItem) {
            val intent = Intent(context, DetailMealsActivity::class.java)
            intent.putExtra(EXTRA_SEARCH, menu)
            context.startActivity(intent)
        }

        fun startActivityAreas(context: Context, menu: CategorieMealsItem) {
            val intent = Intent(context, DetailMealsActivity::class.java)
            intent.putExtra(EXTRA_AREAS, menu)
            context.startActivity(intent)
        }

        fun startActivityCategories(context: Context, menu: CategorieMealsItem) {
            val intent = Intent(context, DetailMealsActivity::class.java)
            intent.putExtra(EXTRA_CATEGORIES, menu)
            context.startActivity(intent)
        }
    }
}