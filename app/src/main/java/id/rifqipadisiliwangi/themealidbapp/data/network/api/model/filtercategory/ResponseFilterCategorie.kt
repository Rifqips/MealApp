package id.rifqipadisiliwangi.themealidbapp.data.network.api.model.filtercategory


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.listallmeals.MealAll
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.listallmeals.toMeal
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.CategorieMealsItem

@Keep
data class ResponseFilterCategorie(
    @SerializedName("meals")
    val meals: List<MealFilterCategorie>?
)

@Keep
data class MealFilterCategorie(
    @SerializedName("idMeal")
    val idMeal: String?,
    @SerializedName("strMeal")
    val strMeal: String?,
    @SerializedName("strMealThumb")
    val strMealThumb: String?
)
fun MealFilterCategorie.toMealCateogorie() = CategorieMealsItem(
    idMeal = this.idMeal.orEmpty(),
    strMeal = this.strMeal.orEmpty(),
    strMealThumb = this.strMealThumb.orEmpty(),
)

fun Collection<MealFilterCategorie>.toCategoriesList() = this.map { it.toMealCateogorie() }