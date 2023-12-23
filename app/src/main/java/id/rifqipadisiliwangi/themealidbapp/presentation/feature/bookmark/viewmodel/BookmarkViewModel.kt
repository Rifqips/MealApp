package id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDataItem
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val TAG = "BookmarkViewModel"

class BookmarkViewModel(app: Application) : AndroidViewModel(app)  {

    lateinit var allBookmark: MutableLiveData<List<BookmarkDataItem>>

    init {
        allBookmark = MutableLiveData()
        getAllBookmark()
    }

    fun getAllBookmarkObserve() : MutableLiveData<List<BookmarkDataItem>>{
        return allBookmark
    }

    fun getAllBookmark(){
        GlobalScope.launch {
            val bookmarkDao = BookmarkDatabase.getInstance(getApplication())!!.bookmarkDao()
            val listBookmark = bookmarkDao.getDataBookmark()
            allBookmark.postValue(listBookmark)
        }
    }

    fun getValidateBookmark(idMeals : String){
        viewModelScope.launch {
            val bookmarkDao = BookmarkDatabase.getInstance(getApplication())!!.bookmarkDao()
            bookmarkDao.getValidateBookmark(idMeals)
        }
    }

}