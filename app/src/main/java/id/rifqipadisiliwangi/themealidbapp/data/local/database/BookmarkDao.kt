package id.rifqipadisiliwangi.themealidbapp.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BookmarkDao {
    @Insert
    fun insertBookmark(bookmark : BookmarkDataItem)

    @Query("SELECT * FROM BookmarkDataItem ORDER BY id DESC")
    fun getDataBookmark() :List<BookmarkDataItem>

    @Query("SELECT * FROM BookmarkDataItem WHERE idMeal = :idMeal")
    suspend fun getValidateBookmark(idMeal: String): List<BookmarkDataItem>?

    @Delete
    fun deleteBookmark(bookmark: BookmarkDataItem) : Int

    @Update
    fun updateBookmark(bookmark: BookmarkDataItem) : Int

}