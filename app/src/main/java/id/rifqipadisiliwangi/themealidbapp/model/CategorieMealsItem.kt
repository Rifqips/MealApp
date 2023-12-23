package id.rifqipadisiliwangi.themealidbapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategorieMealsItem(
    val idMeal: String?,
    val strMeal: String?,
    val strMealThumb: String?
): Parcelable