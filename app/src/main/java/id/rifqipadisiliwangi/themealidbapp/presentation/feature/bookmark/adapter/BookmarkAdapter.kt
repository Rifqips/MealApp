package id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDataItem
import id.rifqipadisiliwangi.themealidbapp.data.local.database.BookmarkDatabase
import id.rifqipadisiliwangi.themealidbapp.databinding.ItemLinearMenuBinding
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.bookmark.viewmodel.BookmarkViewModel

class BookmarkAdapter(var listBookmark : List<BookmarkDataItem>): RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

    private var database : BookmarkDatabase? = null
    lateinit var viewModel: BookmarkViewModel

    class ViewHolder(var binding: ItemLinearMenuBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkAdapter.ViewHolder {
        val view = ItemLinearMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkAdapter.ViewHolder, position: Int) {
        with(holder){
            binding.strMealThumb.load(listBookmark[position].strMealThumb)
            binding.strMeal.text = listBookmark[position].strMeal
            binding.strCategory.text = listBookmark[position].strCategory
            binding.strArea.text = listBookmark[position].strArea
        }

//        holder.binding.tvTitle.text =listBookmark[position].title
//        holder.binding.tvDate.text =listBookmark[position].dateTime
//        holder.binding.tvContent.text =listBookmark[position].content
//
//        holder.binding.ivOption.setOnClickListener {
//            holder.binding.llOption.isGone = false
//        }
//        holder.binding.cvItem.setOnClickListener {
//            holder.binding.llOption.isGone = true
//        }

//        holder.binding.tvDelete.setOnClickListener {
//            holder.binding.llOption.isGone = true
//            database = BookmarkDatabase.getInstance(it.context)
//            run{
//                GlobalScope.async {
//                    database?.historyDao()?.deleteHistorylistBookmark[position])
//                }
//                it.context.startActivity(Intent(it.context, DashboardActivity::class.java))
//            }
//        }

//        holder.binding.tvDetail.setOnClickListener {
//            holder.binding.llOption.isGone = true
//            val dialog = Constants.dialogHistory(it.context,listBookmark[position].score,"", Gravity.CENTER)
//            val ivBack = dialog.findViewById<ImageView>(R.id.iv_close)
//            val description = dialog.findViewById<TextView>(R.id.tv_description)
//            if listBookmark[position].score.toDouble() == 1.0){
//                description.text = "Pertahankan tetapi jangan terlalu santai ingat masa depan tidak semudah itu kak :)"
//            } else if listBookmark[position].score.toDouble() <= 2.0){
//                description.text = "Pertahankan terus kondisi ini, ikan sepat ikan curut bisa yuk!"
//            } else if listBookmark[position].score.toDouble() <= 3.0){
//                description.text = "Kalo capek istirahat sebentar ya kak, habis itu lanjut lagi :)"
//            } else if listBookmark[position].score.toDouble() <= 4.0){
//                description.text = "Kamu butuh refreshing lupakan sejenak aktifitas mu dan cukupkan galau mu itu :)"
//            }
//            ivBack.setOnClickListener {
//                dialog.dismiss()
//            }
//            dialog.show() }
    }

    override fun getItemCount(): Int {
        return listBookmark.size
    }

    fun setBookmarkData(listBookmark: List<BookmarkDataItem>){
        this.listBookmark = listBookmark
        notifyDataSetChanged()
    }
}