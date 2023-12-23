package id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.mealslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.rifqipadisiliwangi.themealidbapp.core.ViewHolderBinder
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDataItem
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import id.rifqipadisiliwangi.themealidbapp.databinding.ItemGridMenuBinding
import id.rifqipadisiliwangi.themealidbapp.databinding.ItemLinearMenuBinding
import id.rifqipadisiliwangi.themealidbapp.model.AllMealsItem
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.AdapterLayoutMode
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.GridMenuItemViewHolder
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.LinearMenuItemViewHolder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class MealsListAdapter(
    var adapterLayoutMode: AdapterLayoutMode,
    private val onClickListener: (AllMealsItem) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    private val dataDiffer = AsyncListDiffer(
        this,
        object : DiffUtil.ItemCallback<AllMealsItem>() {
            override fun areItemsTheSame(oldItem: AllMealsItem, newItem: AllMealsItem): Boolean {
                return oldItem.idMeal == newItem.idMeal && oldItem.strMeal == newItem.strMeal
            }

            override fun areContentsTheSame(oldItem: AllMealsItem, newItem: AllMealsItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            AdapterLayoutMode.GRID.ordinal -> {
                GridMenuItemViewHolder(
                    binding = ItemGridMenuBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onClickListener
                )
            }
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolderBinder<AllMealsItem>).bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun getItemViewType(position: Int): Int {
        return adapterLayoutMode.ordinal
    }

    fun setData(data: List<AllMealsItem>) {
        dataDiffer.submitList(data)
        notifyDataSetChanged()
    }

    fun refreshList() {
        notifyItemRangeChanged(0, dataDiffer.currentList.size)
    }


}
