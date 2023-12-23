package id.rifqipadisiliwangi.themealidbapp.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import id.rifqipadisiliwangi.themealidbapp.data.local.datastore.AppPreferenceDataSource
import id.rifqipadisiliwangi.themealidbapp.data.local.datastore.AppPreferenceDataSourceImpl
import id.rifqipadisiliwangi.themealidbapp.data.local.datastore.appDataStore
import id.rifqipadisiliwangi.themealidbapp.data.network.api.datasource.MealApiDataSource
import id.rifqipadisiliwangi.themealidbapp.data.network.api.datasource.MealsDataSource
import id.rifqipadisiliwangi.themealidbapp.data.network.api.service.MealService
import id.rifqipadisiliwangi.themealidbapp.data.repository.MealsRepository
import id.rifqipadisiliwangi.themealidbapp.data.repository.MealsRepositoryImpl
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.viewmodel.BookmarkViewModel
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.viewmodel.HomeViewModel
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.detail.DetailViewModel
import id.rifqipadisiliwangi.themealidbapp.utils.AssetWrapper
import id.rifqipadisiliwangi.themealidbapp.utils.PreferenceDataStoreHelper
import id.rifqipadisiliwangi.themealidbapp.utils.PreferenceDataStoreHelperImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModules {
    private val localModule = module {
        single { androidContext().appDataStore }
        single<PreferenceDataStoreHelper> { PreferenceDataStoreHelperImpl(get()) }
        single { get<BookmarkDatabase>().bookmarkDao() }
    }

    private val networkModule = module {
        single { ChuckerInterceptor(androidContext()) }
        single { MealService.invoke(get()) }
    }

    private val dataSourceModule = module {
        single<AppPreferenceDataSource> { AppPreferenceDataSourceImpl(get()) }
        single<MealsDataSource> { MealApiDataSource(get()) }
    }

    private val repositoryModule = module {
        single<MealsRepository> { MealsRepositoryImpl(get()) }
    }

    private val viewModelModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::DetailViewModel)
        viewModelOf(::BookmarkViewModel)
    }

    private val utilsModule = module {
        single { AssetWrapper(androidContext()) }
    }

    val modules: List<Module> = listOf(
        localModule,
        networkModule,
        dataSourceModule,
        repositoryModule,
        viewModelModule,
        utilsModule
    )
}