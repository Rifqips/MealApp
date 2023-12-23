package id.rifqipadisiliwangi.themealidbapp.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class BookmarkDataItem(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    val strMealThumb: String?,
    val strMeal: String?,
    val strArea: String?,
    val strInstructions: String?,
    val strYoutube: String?,
    val idMeal: String?,
    val strCategory: String?,
)
