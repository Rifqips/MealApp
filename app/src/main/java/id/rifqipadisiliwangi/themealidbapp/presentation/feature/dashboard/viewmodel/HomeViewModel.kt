package id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import id.rifqipadisiliwangi.themealidbapp.data.local.datastore.AppPreferenceDataSource
import id.rifqipadisiliwangi.themealidbapp.data.repository.MealsRepository
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.CategorieMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.SearchMealsItem
import id.rifqipadisiliwangi.themealidbapp.utils.AssetWrapper
import id.rifqipadisiliwangi.themealidbapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val mealsRepo: MealsRepository,
    private val appPreferenceDataSource: AppPreferenceDataSource,
    private val assetWrapper: AssetWrapper,
): ViewModel() {

    private val _meals = MutableLiveData<ResultWrapper<List<AllMealsItem>>>()
    val meals: LiveData<ResultWrapper<List<AllMealsItem>>>
        get() = _meals

    private val _mealsSearch = MutableLiveData<ResultWrapper<List<SearchMealsItem>>>()
    val mealsSearch: LiveData<ResultWrapper<List<SearchMealsItem>>>
        get() = _mealsSearch

    private val _mealsCategories = MutableLiveData<ResultWrapper<List<CategorieMealsItem>>>()
    val mealsCategories: LiveData<ResultWrapper<List<CategorieMealsItem>>>
        get() = _mealsCategories

    private val _filterArea = MutableLiveData<ResultWrapper<List<CategorieMealsItem>>>()
    val filterArea: LiveData<ResultWrapper<List<CategorieMealsItem>>>
        get() = _filterArea

    val appLayoutGridLiveData = appPreferenceDataSource.getAppLayoutFlow().asLiveData(Dispatchers.IO)

    fun getAllMeals(category: String? = null) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                mealsRepo.getAllMeals(category).collect {
                    _meals.postValue(it)
                }
            }
        }catch (e:Exception){

        }
    }

    fun getSearchMeals(searchMeals: String? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mealsRepo.getSearchMeals(searchMeals).collect {
                    _mealsSearch.postValue(it)
                }
            } catch(e: Exception) {
//                _mealsSearch.postValue(List<>)
            }
        }
    }
    fun getCategoriesMeals(categoryMeals: String? = null) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                mealsRepo.getCategoriesMeals(categoryMeals).collect {
                    _mealsCategories.postValue(it)
                }
            }
        }catch (e : Exception){

        }
    }

    fun getFilterArea(filterArea: String? = null) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                mealsRepo.getFilterArea(filterArea).collect {
                    _filterArea.postValue(it)
                }
            }
        }catch (e : Exception){

        }
    }

    fun setAppLayoutPref(isGridLayout: Boolean) {
        viewModelScope.launch {
            appPreferenceDataSource.setAppLayoutPref(isGridLayout)
        }
    }
}