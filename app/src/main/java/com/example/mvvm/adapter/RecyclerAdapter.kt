package com.example.mvvm.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.MainActivity
import com.example.mvvm.R
import com.example.mvvm.viewmodels.CategoryViewModel
import kotlinx.android.synthetic.main.innerlayout.view.*

class RecyclerAdapter(
    private val context: MainActivity,
    private val nicePlaces: ArrayList<CategoryViewModel>
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.innerlayout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return nicePlaces.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = nicePlaces[position].title.toString()
//        holder.itemView.setOnClickListener {
//            println("!!Q!!Q!Q!Q! :-"+nicePlaces?.get(position))
//        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.mTitle
    }
}
