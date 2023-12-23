package id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.adapter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.rifqipadisiliwangi.themealidbapp.core.ViewHolderBinder
import id.rifqipadisiliwangi.themealidbapp.databinding.ItemGridMenuBinding
import id.rifqipadisiliwangi.themealidbapp.model.SearchMealsItem

class SearchMealsAdapter(
    private val onClickListener: (SearchMealsItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataDiffer = AsyncListDiffer(
        this,
        object : DiffUtil.ItemCallback<SearchMealsItem>() {
            override fun areItemsTheSame(oldItem: SearchMealsItem, newItem: SearchMealsItem): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }

            override fun areContentsTheSame(oldItem: SearchMealsItem, newItem: SearchMealsItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            else -> {
                GridMenuItemViewHolder(
                    binding = ItemGridMenuBinding.inflate(
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
        (holder as ViewHolderBinder<SearchMealsItem>).bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size


    fun setData(data: List<SearchMealsItem>) {
        dataDiffer.submitList(data)
        notifyDataSetChanged()
    }

    fun refreshList() {
        notifyItemRangeChanged(0, dataDiffer.currentList.size)
    }


    class GridMenuItemViewHolder(
        private val binding: ItemGridMenuBinding,
        private val onClickListener: (SearchMealsItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<SearchMealsItem> {
        override fun bind(item: SearchMealsItem) {
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
}