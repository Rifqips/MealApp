package id.rifqipadisiliwangi.themealidbapp.data.repository

import id.rifqipadisiliwangi.themealidbapp.data.network.api.datasource.MealsDataSource
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.filtercategory.toCategoriesList
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.listallmeals.toMealsList
import id.rifqipadisiliwangi.themealidbapp.data.network.api.model.searchmeals.toSearchMeal
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.CategorieMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.SearchMealsItem
import id.rifqipadisiliwangi.themealidbapp.utils.ResultWrapper
import id.rifqipadisiliwangi.themealidbapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface MealsRepository {
    fun getAllMeals(mealsAll: String? = null): Flow<ResultWrapper<List<AllMealsItem>>>
    fun getSearchMeals(searchMeals: String? = null): Flow<ResultWrapper<List<SearchMealsItem>>>
    fun getCategoriesMeals(categorieMeals: String? = null): Flow<ResultWrapper<List<CategorieMealsItem>>>
    fun getFilterArea(filterArea: String? = null): Flow<ResultWrapper<List<CategorieMealsItem>>>
}

class MealsRepositoryImpl(
    private val apiDataSource: MealsDataSource
) :MealsRepository{
    override fun getAllMeals(mealsAll: String?): Flow<ResultWrapper<List<AllMealsItem>>> {
        return proceedFlow {
            apiDataSource.getAllMeals(mealsAll).meals?.toMealsList() ?: emptyList()
        }
    }

    override fun getSearchMeals(searchMeals: String?): Flow<ResultWrapper<List<SearchMealsItem>>> {
        return proceedFlow {
            apiDataSource.getSearchMeals(searchMeals).meals?.toSearchMeal() ?: emptyList()
        }
    }

    override fun getCategoriesMeals(categorieMeals: String?): Flow<ResultWrapper<List<CategorieMealsItem>>> {
        return proceedFlow {
            apiDataSource.getCategoriesMeals(categorieMeals).meals?.toCategoriesList() ?: emptyList()
        }
    }

    override fun getFilterArea(filterArea: String?): Flow<ResultWrapper<List<CategorieMealsItem>>> {
        return proceedFlow {
            apiDataSource.getFilterArea(filterArea).meals?.toCategoriesList() ?: emptyList()
        }
    }
}