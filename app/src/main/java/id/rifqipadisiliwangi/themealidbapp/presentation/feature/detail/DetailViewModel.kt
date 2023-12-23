package id.rifqipadisiliwangi.themealidbapp.presentation.feature.detail

import android.os.Bundle
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

class DetailViewModel(
    private val extras: Bundle?,
    private val extrasSearch: Bundle?,
    private val extrasCategories: Bundle?,
    private val extrasAreas: Bundle?,
    private val mealsRepo: MealsRepository,
): ViewModel() {
    val meals = extras?.getParcelable<AllMealsItem>(DetailMealsActivity.EXTRA_MENU)
    val mealsSearch = extrasSearch?.getParcelable<SearchMealsItem>(DetailMealsActivity.EXTRA_SEARCH)
    val mealsCategories = extrasCategories?.getParcelable<CategorieMealsItem>(DetailMealsActivity.EXTRA_CATEGORIES)
    val mealsAreas = extrasAreas?.getParcelable<CategorieMealsItem>(DetailMealsActivity.EXTRA_AREAS)
}