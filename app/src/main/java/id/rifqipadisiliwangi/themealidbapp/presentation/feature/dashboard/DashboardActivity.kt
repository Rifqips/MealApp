package id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import id.rifqipadisiliwangi.themealidbapp.R
import id.rifqipadisiliwangi.themealidbapp.databinding.ActivityDashboardBinding
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.CategorieMealsItem
import id.rifqipadisiliwangi.themealidbapp.model.SearchMealsItem
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.BookmarkActivity
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.categories.CategorieMealsAdapter
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.AdapterLayoutMode
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.filterarea.FilterAreaAdapter
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.mealslist.MealsListAdapter
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.search.SearchMealsAdapter
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.viewmodel.HomeViewModel
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.detail.DetailMealsActivity
import id.rifqipadisiliwangi.themealidbapp.utils.AssetWrapper
import id.rifqipadisiliwangi.themealidbapp.utils.Constants
import id.rifqipadisiliwangi.themealidbapp.utils.proceedWhen
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "DashboardActivity"
class DashboardActivity : AppCompatActivity() {

    private val binding: ActivityDashboardBinding by lazy {
        ActivityDashboardBinding.inflate(layoutInflater)
    }

    private val viewModel: HomeViewModel by viewModel()

    private val assetWrapper: AssetWrapper by inject()

    private val adapterMenu: MealsListAdapter by lazy {
        MealsListAdapter(AdapterLayoutMode.LINEAR) {
            navigateToDetailMenu(it)
        }
    }

    private val adapterSearch: SearchMealsAdapter by lazy {
        SearchMealsAdapter{
            navigateToDetailSeach(it)
        }
    }

    private val adapterCategory: CategorieMealsAdapter by lazy {
        CategorieMealsAdapter{
            navigateToDetailCategories(it)
        }
    }

    private val adapterFilterArea: FilterAreaAdapter by lazy {
        FilterAreaAdapter{
            navigateToDetailAreas(it)
        }
    }

    private fun navigateToDetailMenu(mealsDetail: AllMealsItem) {
        DetailMealsActivity.startActivity(this@DashboardActivity, mealsDetail)
    }

    private fun navigateToDetailSeach(searchMeals: SearchMealsItem) {
        DetailMealsActivity.startActivitySearch(this@DashboardActivity, searchMeals)
    }

    private fun navigateToDetailCategories(mealsCategories: CategorieMealsItem) {
        DetailMealsActivity.startActivityCategories(this@DashboardActivity, mealsCategories)
    }

    private fun navigateToDetailAreas(mealsAreas: CategorieMealsItem) {
        DetailMealsActivity.startActivityAreas(this@DashboardActivity, mealsAreas)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rvListMeals()
        rvMealsSearch()
        rvCategories()
        rvFilterArea()
        getData()
        observeData()
        observeLayout()
        setupSwitchLayout()
        setOnClick()
    }

    private fun getData() {
        viewModel.getAllMeals("a")
        viewModel.getCategoriesMeals("Seafood")
        viewModel.getFilterArea("Canadian")
        viewModel.getSearchMeals("")
    }

    private fun setOnClick(){
        binding.let {
            it.tvFilterLetterMeaals.setOnClickListener {
                shownDialog()
            }
            it.tvFilterCategoriesMeaals.setOnClickListener {
                showBottomSheetCategories()
            }
            it.tvFilterAreasMeaals.setOnClickListener {
                shownBottomSheetAreas()
            }
            it.fabBookmark.setOnClickListener {
                startActivity(Intent(this, BookmarkActivity::class.java))
            }
            it.etSearch.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.ivSeachMealsName.setOnClickListener {
                        viewModel.getSearchMeals(s.toString())
                    }
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Trigger search when text changes
                }

                override fun afterTextChanged(s: Editable?) {
                    // Not needed
                }
            })
        }
    }
    private fun shownDialog(){
        val dialog = Constants.dialogFilledLetter(this@DashboardActivity)
        val etfiiledletter = dialog.findViewById<EditText>(R.id.et_fiiled_letter)
        val btnfilter = dialog.findViewById<Button>(R.id.btn_filter)
        etfiiledletter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                btnfilter.setOnClickListener {
                    viewModel.getAllMeals(s.toString())
                    dialog.dismiss()
                }
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        dialog.show()
    }
    @SuppressLint("MissingInflatedId")
    private fun showBottomSheetCategories() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_filter_categories, null)

        val radioGroup = bottomSheetView.findViewById<RadioGroup>(R.id.rg_categories)
        val btnDismis = bottomSheetView.findViewById<Button>(R.id.btn_Dismis_categories)
        btnDismis.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = bottomSheetView.findViewById<RadioButton>(checkedId)
            viewModel.getCategoriesMeals(selectedRadioButton.text.toString())
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }


    private fun shownBottomSheetAreas(){
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_filter_areas, null)

        val radioGroup = bottomSheetView.findViewById<RadioGroup>(R.id.rg_areas)
        val btnDismis = bottomSheetView.findViewById<Button>(R.id.btn_Dismis_areas)
        btnDismis.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = bottomSheetView.findViewById<RadioButton>(checkedId)
            viewModel.getFilterArea( selectedRadioButton.text.toString())
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

    private fun rvListMeals() {
        val span = if (adapterMenu.adapterLayoutMode == AdapterLayoutMode.LINEAR) 1 else 2
        binding.rvMealsList.apply {
            layoutManager = GridLayoutManager(this@DashboardActivity, span)
            adapter = adapterMenu
            adapterMenu.refreshList()
        }
    }

    private fun rvMealsSearch() {
        binding.rvSearchMeaals.apply {
            layoutManager = GridLayoutManager(this@DashboardActivity,1, RecyclerView.HORIZONTAL, false)
            adapter = adapterSearch
            adapterSearch.refreshList()
        }
    }

    private fun rvCategories() {
        binding.rvCategoriesMeaals.apply {
            layoutManager = LinearLayoutManager(this@DashboardActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterCategory
            adapterCategory.refreshList()
        }
    }

    private fun rvFilterArea() {
        binding.rvAreasMeaals.apply {
            layoutManager = LinearLayoutManager(this@DashboardActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterFilterArea
            adapterFilterArea.refreshList()
        }
    }

    private fun observeData() {
        viewModel.meals.observe(this) {
            val span = if (adapterMenu.adapterLayoutMode == AdapterLayoutMode.LINEAR) 1 else 2
            it.proceedWhen(
                doOnSuccess = {
                    binding.rvMealsList.isVisible = true
                    binding.layoutStateMenu.root.isVisible = false
                    binding.layoutStateMenu.pbLoading.isVisible = false
                    binding.layoutStateMenu.tvError.isVisible = false
                    binding.rvMealsList.apply {
                        layoutManager = GridLayoutManager(this@DashboardActivity, span)
                        adapter = adapterMenu
                    }
                    it.payload?.let { data ->
                        adapterMenu.setData(data)
                        binding.rvMealsList.smoothScrollToPosition(0)
                    }
                },
                doOnLoading = {
                    binding.rvMealsList.isVisible = false
                    binding.layoutStateMenu.root.isVisible = true
                    binding.layoutStateMenu.pbLoading.isVisible = true
                    binding.layoutStateMenu.tvError.isVisible = false
                },
                doOnError = {
                    binding.rvMealsList.isVisible = false
                    binding.layoutStateMenu.root.isVisible = true
                    binding.layoutStateMenu.pbLoading.isVisible = false
                    binding.layoutStateMenu.tvError.isVisible = true
                    binding.layoutStateMenu.tvError.text = it.exception?.message
                },
                doOnEmpty = {
                    binding.rvMealsList.isVisible = false
                    binding.layoutStateMenu.root.isVisible = true
                    binding.layoutStateMenu.pbLoading.isVisible = false
                    binding.layoutStateMenu.tvError.isVisible = true
                    binding.layoutStateMenu.tvError.text = assetWrapper.getString(R.string.meals_not_found)
                }
            )
        }

        viewModel.mealsSearch.observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.rvSearchMeaals.isVisible = true
                    binding.layoutStateMenuSearch.root.isVisible = false
                    binding.layoutStateMenuSearch.pbLoading.isVisible = false
                    binding.layoutStateMenuSearch.tvError.isVisible = false
                    binding.rvSearchMeaals.apply {
                        layoutManager = GridLayoutManager(this@DashboardActivity, 1, RecyclerView.HORIZONTAL, false)
                        adapter = adapterSearch
                    }
                    it.payload?.let { data ->
                        adapterSearch.setData(data)
                        binding.rvSearchMeaals.smoothScrollToPosition(0)
                    }
                },
                doOnLoading = {
                    binding.rvSearchMeaals.isVisible = false
                    binding.layoutStateMenuSearch.root.isVisible = true
                    binding.layoutStateMenuSearch.pbLoading.isVisible = true
                    binding.layoutStateMenuSearch.tvError.isVisible = false
                },
                doOnError = {
                    binding.rvSearchMeaals.isVisible = false
                    binding.layoutStateMenuSearch.root.isVisible = true
                    binding.layoutStateMenuSearch.pbLoading.isVisible = false
                    binding.layoutStateMenuSearch.tvError.isVisible = true
                    binding.layoutStateMenuSearch.tvError.text = it.exception?.message
                },
                doOnEmpty = {
                    binding.rvSearchMeaals.isVisible = false
                    binding.layoutStateMenuSearch.root.isVisible = true
                    binding.layoutStateMenuSearch.pbLoading.isVisible = false
                    binding.layoutStateMenuSearch.tvError.isVisible = true
                    binding.layoutStateMenuSearch.tvError.text = assetWrapper.getString(R.string.meals_not_found)
                }
            )
        }

        viewModel.mealsCategories.observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.rvCategoriesMeaals.isVisible = true
                    binding.layoutStateCategoriesMeals.root.isVisible = false
                    binding.layoutStateCategoriesMeals.pbLoading.isVisible = false
                    binding.layoutStateCategoriesMeals.tvError.isVisible = false
                    binding.rvCategoriesMeaals.apply {
                        layoutManager = LinearLayoutManager(this@DashboardActivity,LinearLayoutManager.HORIZONTAL,false)
                        adapter = adapterCategory
                    }
                    it.payload?.let { data ->
                        adapterCategory.setData(data)
                        binding.rvCategoriesMeaals.smoothScrollToPosition(0)
                    }
                },
                doOnLoading = {
                    binding.rvCategoriesMeaals.isVisible = false
                    binding.layoutStateCategoriesMeals.root.isVisible = true
                    binding.layoutStateCategoriesMeals.pbLoading.isVisible = true
                    binding.layoutStateCategoriesMeals.tvError.isVisible = false
                },
                doOnError = {
                    binding.rvCategoriesMeaals.isVisible = false
                    binding.layoutStateCategoriesMeals.root.isVisible = true
                    binding.layoutStateCategoriesMeals.pbLoading.isVisible = false
                    binding.layoutStateCategoriesMeals.tvError.isVisible = true
                    binding.layoutStateCategoriesMeals.tvError.text = it.exception?.message
                },
                doOnEmpty = {
                    binding.rvCategoriesMeaals.isVisible = false
                    binding.layoutStateCategoriesMeals.root.isVisible = true
                    binding.layoutStateCategoriesMeals.pbLoading.isVisible = false
                    binding.layoutStateCategoriesMeals.tvError.isVisible = true
                    binding.layoutStateCategoriesMeals.tvError.text = assetWrapper.getString(R.string.meals_not_found)
                }
            )
        }

        viewModel.filterArea.observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.rvAreasMeaals.isVisible = true
                    binding.layoutStateAreasMeals.root.isVisible = false
                    binding.layoutStateAreasMeals.pbLoading.isVisible = false
                    binding.layoutStateAreasMeals.tvError.isVisible = false
                    binding.rvAreasMeaals.apply {
                        layoutManager = LinearLayoutManager(this@DashboardActivity,LinearLayoutManager.HORIZONTAL,false)
                        adapter = adapterFilterArea
                    }
                    it.payload?.let { data ->
                        adapterFilterArea.setData(data)
                        binding.rvAreasMeaals.smoothScrollToPosition(0)
                    }
                },
                doOnLoading = {
                    binding.rvAreasMeaals.isVisible = false
                    binding.layoutStateAreasMeals.root.isVisible = true
                    binding.layoutStateAreasMeals.pbLoading.isVisible = true
                    binding.layoutStateAreasMeals.tvError.isVisible = false
                },
                doOnError = {
                    binding.rvAreasMeaals.isVisible = false
                    binding.layoutStateAreasMeals.root.isVisible = true
                    binding.layoutStateAreasMeals.pbLoading.isVisible = false
                    binding.layoutStateAreasMeals.tvError.isVisible = true
                    binding.layoutStateAreasMeals.tvError.text = it.exception?.message
                },
                doOnEmpty = {
                    binding.rvAreasMeaals.isVisible = false
                    binding.layoutStateAreasMeals.root.isVisible = true
                    binding.layoutStateAreasMeals.pbLoading.isVisible = false
                    binding.layoutStateAreasMeals.tvError.isVisible = true
                    binding.layoutStateAreasMeals.tvError.text = assetWrapper.getString(R.string.meals_not_found)
                }
            )
        }
    }

    private fun observeLayout() {
        viewModel.appLayoutGridLiveData.observe(this) { isGridLayout ->
            binding.ivSwitchGrid.isGone = isGridLayout
            binding.ivSwitchList.isGone = !isGridLayout
            (binding.rvMealsList.layoutManager as GridLayoutManager).spanCount =
                if (isGridLayout) 2 else 1
            adapterMenu.adapterLayoutMode =
                if (isGridLayout) AdapterLayoutMode.GRID else AdapterLayoutMode.LINEAR
            adapterMenu.refreshList()
        }
    }

    private fun setupSwitchLayout() {
        binding.ivSwitchGrid.setOnClickListener {
            viewModel.setAppLayoutPref(isGridLayout = true)
        }
        binding.ivSwitchList.setOnClickListener {
            viewModel.setAppLayoutPref(isGridLayout = false)
        }
    }
}