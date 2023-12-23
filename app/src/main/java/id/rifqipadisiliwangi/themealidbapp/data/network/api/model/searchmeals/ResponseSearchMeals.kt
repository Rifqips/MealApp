package id.rifqipadisiliwangi.themealidbapp.data.network.api.model.searchmeals


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.listallmeals.MealAll
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.SearchMealsItem

@Keep
data class ResponseSearchMeals(
    @SerializedName("meals")
    val meals: List<MealSearch>?
)

@Keep
data class MealSearch(
    @SerializedName("dateModified")
    val dateModified: String?,
    @SerializedName("idMeal")
    val idMeal: String?,
    @SerializedName("strArea")
    val strArea: String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String?,
    @SerializedName("strDrinkAlternate")
    val strDrinkAlternate: String?,
    @SerializedName("strImageSource")
    val strImageSource: String?,
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
    @SerializedName("strIngredient10")
    val strIngredient10: String?,
    @SerializedName("strIngredient11")
    val strIngredient11: String?,
    @SerializedName("strIngredient12")
    val strIngredient12: String?,
    @SerializedName("strIngredient13")
    val strIngredient13: String?,
    @SerializedName("strIngredient14")
    val strIngredient14: String?,
    @SerializedName("strIngredient15")
    val strIngredient15: String?,
    @SerializedName("strIngredient16")
    val strIngredient16: String?,
    @SerializedName("strIngredient17")
    val strIngredient17: String?,
    @SerializedName("strIngredient18")
    val strIngredient18: String?,
    @SerializedName("strIngredient19")
    val strIngredient19: String?,
    @SerializedName("strIngredient2")
    val strIngredient2: String?,
    @SerializedName("strIngredient20")
    val strIngredient20: String?,
    @SerializedName("strIngredient3")
    val strIngredient3: String?,
    @SerializedName("strIngredient4")
    val strIngredient4: String?,
    @SerializedName("strIngredient5")
    val strIngredient5: String?,
    @SerializedName("strIngredient6")
    val strIngredient6: String?,
    @SerializedName("strIngredient7")
    val strIngredient7: String?,
    @SerializedName("strIngredient8")
    val strIngredient8: String?,
    @SerializedName("strIngredient9")
    val strIngredient9: String?,
    @SerializedName("strInstructions")
    val strInstructions: String?,
    @SerializedName("strMeal")
    val strMeal: String?,
    @SerializedName("strMealThumb")
    val strMealThumb: String?,
    @SerializedName("strMeasure1")
    val strMeasure1: String?,
    @SerializedName("strMeasure10")
    val strMeasure10: String?,
    @SerializedName("strMeasure11")
    val strMeasure11: String?,
    @SerializedName("strMeasure12")
    val strMeasure12: String?,
    @SerializedName("strMeasure13")
    val strMeasure13: String?,
    @SerializedName("strMeasure14")
    val strMeasure14: String?,
    @SerializedName("strMeasure15")
    val strMeasure15: String?,
    @SerializedName("strMeasure16")
    val strMeasure16: String?,
    @SerializedName("strMeasure17")
    val strMeasure17: String?,
    @SerializedName("strMeasure18")
    val strMeasure18: String?,
    @SerializedName("strMeasure19")
    val strMeasure19: String?,
    @SerializedName("strMeasure2")
    val strMeasure2: String?,
    @SerializedName("strMeasure20")
    val strMeasure20: String?,
    @SerializedName("strMeasure3")
    val strMeasure3: String?,
    @SerializedName("strMeasure4")
    val strMeasure4: String?,
    @SerializedName("strMeasure5")
    val strMeasure5: String?,
    @SerializedName("strMeasure6")
    val strMeasure6: String?,
    @SerializedName("strMeasure7")
    val strMeasure7: String?,
    @SerializedName("strMeasure8")
    val strMeasure8: String?,
    @SerializedName("strMeasure9")
    val strMeasure9: String?,
    @SerializedName("strSource")
    val strSource: String?,
    @SerializedName("strTags")
    val strTags: String?,
    @SerializedName("strYoutube")
    val strYoutube: String?
)



fun MealSearch.toSearch() = SearchMealsItem(
    dateModified = this.dateModified.orEmpty(),
    idMeal = this.idMeal.orEmpty(),
    strArea = this.strArea.orEmpty(),
    strCategory = this.strCategory.orEmpty(),
    strCreativeCommonsConfirmed = this.strCreativeCommonsConfirmed.orEmpty(),
    strDrinkAlternate = this.strDrinkAlternate.orEmpty(),
    strImageSource = this.strImageSource.orEmpty(),
    strIngredient1 = this.strIngredient1.orEmpty(),
    strIngredient10 = this.strIngredient10.orEmpty(),
    strIngredient11 = this.strIngredient10.orEmpty(),
    strIngredient12 = this.strIngredient12.orEmpty(),
    strIngredient13 = this.strIngredient13.orEmpty(),
    strIngredient14 = this.strIngredient14.orEmpty(),
    strIngredient15 = this.strIngredient15.orEmpty(),
    strIngredient16 = this.strIngredient16.orEmpty(),
    strIngredient17 = this.strIngredient17.orEmpty(),
    strIngredient18 = this.strIngredient18.orEmpty(),
    strIngredient19 = this.strIngredient19.orEmpty(),
    strIngredient2 = this.strIngredient2.orEmpty(),
    strIngredient20 = this.strIngredient20.orEmpty(),
    strIngredient3 = this.strIngredient3.orEmpty(),
    strIngredient4 = this.strIngredient4.orEmpty(),
    strIngredient5 = this.strIngredient5.orEmpty(),
    strIngredient6 = this.strIngredient6.orEmpty(),
    strIngredient7 = this.strIngredient7.orEmpty(),
    strIngredient8 = this.strIngredient8.orEmpty(),
    strIngredient9 = this.strIngredient9.orEmpty(),
    strInstructions = this.strInstructions.orEmpty(),
    strMeal = this.strMeal.orEmpty(),
    strMealThumb = this.strMealThumb.orEmpty(),
    strMeasure1 = this.strMeasure1.orEmpty(),
    strMeasure10 = this.strMeasure10.orEmpty(),
    strMeasure11 = this.strMeasure11.orEmpty(),
    strMeasure12 = this.strMeasure12.orEmpty(),
    strMeasure13 = this.strMeasure13.orEmpty(),
    strMeasure14 = this.strMeasure14.orEmpty(),
    strMeasure15 = this.strMeasure15.orEmpty(),
    strMeasure16 = this.strMeasure16.orEmpty(),
    strMeasure17 = this.strMeasure17.orEmpty(),
    strMeasure18 = this.strMeasure18.orEmpty(),
    strMeasure19 = this.strMeasure19.orEmpty(),
    strMeasure2 = this.strMeasure2.orEmpty(),
    strMeasure20 = this.strMeasure20.orEmpty(),
    strMeasure3 = this.strMeasure3.orEmpty(),
    strMeasure4 = this.strMeasure4.orEmpty(),
    strMeasure5 = this.strMeasure5.orEmpty(),
    strMeasure6 = this.strMeasure6.orEmpty(),
    strMeasure7 = this.strMeasure7.orEmpty(),
    strMeasure8 = this.strMeasure8.orEmpty(),
    strMeasure9 = this.strMeasure9.orEmpty(),
    strSource = this.strSource.orEmpty(),
    strTags = this.strTags.orEmpty(),
    strYoutube = this.strYoutube.orEmpty(),
)

fun Collection<MealSearch>.toSearchMeal() = this.map { it.toSearch() }