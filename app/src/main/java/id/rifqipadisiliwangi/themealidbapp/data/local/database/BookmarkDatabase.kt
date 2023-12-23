package id.rifqipadisiliwangi.themealidbapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BookmarkDataItem::class], version = 1 )
abstract class BookmarkDatabase: RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
    companion object{
        private var INSTANCE : BookmarkDatabase? = null
        fun getInstance(context: Context):BookmarkDatabase? {
            if (INSTANCE == null){
                synchronized(BookmarkDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BookmarkDatabase::class.java,"Bookmark.db").build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}