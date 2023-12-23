package id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.rifqipadisiliwangi.themealidbapp.R
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDataItem
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import id.rifqipadisiliwangi.themealidbapp.databinding.ActivityBookmarkBinding
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.adapter.BookmarkAdapter
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.viewmodel.BookmarkViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookmarkActivity : AppCompatActivity() {

    private val binding : ActivityBookmarkBinding by lazy {
        ActivityBookmarkBinding.inflate(layoutInflater)
    }

    private var bookmarkDB : BookmarkDatabase? = null
    lateinit var adapterBookmark : BookmarkAdapter
    lateinit var viewModel: BookmarkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapterBookmark = BookmarkAdapter(emptyList())
        bookmarkDB = BookmarkDatabase.getInstance(this@BookmarkActivity)
        vmBookmark()
        bookmarkAdapter()
        setOnClick()
    }

    private fun setOnClick(){
        binding.ivBackHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun vmBookmark(){
        viewModel = ViewModelProvider(this)[BookmarkViewModel::class.java]
        viewModel.getAllBookmarkObserve().observe(this@BookmarkActivity) {
            adapterBookmark.setBookmarkData(it as List<BookmarkDataItem>)
        }
    }

    private fun bookmarkAdapter(){
        binding.rvBookmark.adapter = adapterBookmark
        binding.rvBookmark.layoutManager = LinearLayoutManager(
            this@BookmarkActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.rvBookmark.isNestedScrollingEnabled = false
        GlobalScope.launch {
            val listHistory = bookmarkDB?.bookmarkDao()?.getDataBookmark()
            this@BookmarkActivity.runOnUiThread { listHistory.let {
                    adapterBookmark.setBookmarkData(it!!)
                }
            }
            Log.d("ListBookmark", listHistory.toString())
        }
    }
}