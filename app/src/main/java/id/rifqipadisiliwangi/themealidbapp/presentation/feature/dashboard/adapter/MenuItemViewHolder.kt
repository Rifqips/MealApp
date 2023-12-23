package id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.rifqipadisiliwangi.themealidbapp.core.ViewHolderBinder
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import id.rifqipadisiliwangi.themealidbapp.databinding.ItemGridMenuBinding
import id.rifqipadisiliwangi.themealidbapp.databinding.ItemLinearMenuBinding
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem

class LinearMenuItemViewHolder(
    private val binding: ItemLinearMenuBinding,
    private val onClickListener: (AllMealsItem) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<AllMealsItem> {

    private var dbHistory : BookmarkDatabase? = null

    override fun bind(item: AllMealsItem) {
        with(binding) {
            strMealThumb.load(item.strMealThumb)
            strMeal.text = item.strMeal
            strCategory.text = item.strCategory
            strArea.text = item.strArea
        }
        binding.root.setOnClickListener {
            onClickListener(item)
        }
    }

}

class GridMenuItemViewHolder(
    private val binding: ItemGridMenuBinding,
    private val onClickListener: (AllMealsItem) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<AllMealsItem> {



    override fun bind(item: AllMealsItem) {
        with(binding) {
            strMealThumb.load(item.strMealThumb)
            strMeal.text = item.strMeal
            strCategory.text = item.strCategory
            strArea.text = item.strArea
        }
        binding.root.setOnClickListener {
            onClickListener(item)
        }
    }
}
