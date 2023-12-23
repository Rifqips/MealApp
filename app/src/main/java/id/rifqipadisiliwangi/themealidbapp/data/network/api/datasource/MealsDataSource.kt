package id.rifqipadisiliwangi.themealidbapp.data.network.api.datasource

import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.filtercategory.ResponseFilterCategorie
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.listallmeals.ResponseAllMeals
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.searchmeals.ResponseSearchMeals
import id.rifqipadisiliwangi.themealidbapp.data.network.api.service.MealService

interface MealsDataSource {
    suspend fun getAllMeals(mealsAll: String? = null): ResponseAllMeals
    suspend fun getSearchMeals(searchMeals: String? = null): ResponseSearchMeals
    suspend fun getCategoriesMeals(categorieMeals: String? = null): ResponseFilterCategorie
    suspend fun getFilterArea(filterArea: String? = null): ResponseFilterCategorie
}

class MealApiDataSource(private val service: MealService) : MealsDataSource {
    override suspend fun getAllMeals(mealsAll: String?): ResponseAllMeals {
        return service.getAllMeals(mealsAll)
    }

    override suspend fun getSearchMeals(searchMeals: String?): ResponseSearchMeals {
        return service.getSearchMeals(searchMeals)
    }

    override suspend fun getFilterArea(filterArea: String?): ResponseFilterCategorie {
        return service.getFilterArea(filterArea)
    }

    override suspend fun getCategoriesMeals(categorieMeals: String?): ResponseFilterCategorie {
        return service.getTypeCategorisMeals(categorieMeals)
    }
}