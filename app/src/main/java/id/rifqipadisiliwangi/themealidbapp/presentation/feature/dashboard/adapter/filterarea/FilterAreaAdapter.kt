package id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.filterarea

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.rifqipadisiliwangi.themealidbapp.core.ViewHolderBinder
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDataItem
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import id.rifqipadisiliwangi.themealidbapp.databinding.ItemLinearMenuBinding
import id.rifqipadisiliwangi.themealidbapp.model.CategorieMealsItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class FilterAreaAdapter(
    private val onClickListener: (CategorieMealsItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataDiffer = AsyncListDiffer(
        this,
        object : DiffUtil.ItemCallback<CategorieMealsItem>() {
            override fun areItemsTheSame(oldItem: CategorieMealsItem, newItem: CategorieMealsItem): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }

            override fun areContentsTheSame(oldItem: CategorieMealsItem, newItem: CategorieMealsItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            else -> {
                LinearMenuItemViewHolder(
                    binding = ItemLinearMenuBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onClickListener
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderBinder<CategorieMealsItem>).bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size


    fun setData(data: List<CategorieMealsItem>) {
        dataDiffer.submitList(data)
        notifyDataSetChanged()
    }

    fun refreshList() {
        notifyItemRangeChanged(0, dataDiffer.currentList.size)
    }

    class LinearMenuItemViewHolder(
        private val binding: ItemLinearMenuBinding,
        private val onClickListener: (CategorieMealsItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<CategorieMealsItem> {
        override fun bind(item: CategorieMealsItem) {
            with(binding) {
                strMealThumb.load(item.strMealThumb)
                strMeal.text = item.strMeal

            }
            binding.root.setOnClickListener {
                onClickListener(item)
            }
        }
    }
}