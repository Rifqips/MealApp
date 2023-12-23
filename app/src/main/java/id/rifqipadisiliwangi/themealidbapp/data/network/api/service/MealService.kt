package id.rifqipadisiliwangi.themealidbapp.data.network.api.service

import com.chuckerteam.chucker.api.ChuckerInterceptor
import id.rifqipadisiliwangi.themealidbapp.BuildConfig
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.filtercategory.ResponseFilterCategorie
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.listallmeals.ResponseAllMeals
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.searchmeals.ResponseSearchMeals
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface MealService {

    @GET("1/search.php")
    suspend fun getAllMeals(
        @Query("f") mealsAll: String? = null
    ): ResponseAllMeals

    @GET("1/search.php")
    suspend fun getSearchMeals(
        @Query("s") searchQuery: String? = null
    ): ResponseSearchMeals

    @GET("1/filter.php")
    suspend fun getFilterArea(
        @Query("a") filterArea: String? = null
    ): ResponseFilterCategorie

    @GET("1/filter.php")
    suspend fun getTypeCategorisMeals(
        @Query("c") categoriesMeals: String? = null
    ): ResponseFilterCategorie

    companion object {
        @JvmStatic
        operator fun invoke(chucker: ChuckerInterceptor): MealService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(chucker)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(MealService::class.java)
        }
    }

}