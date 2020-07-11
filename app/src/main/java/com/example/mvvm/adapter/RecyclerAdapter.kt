package com.example.mvvm.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.MainActivity
import com.example.mvvm.R
import com.example.mvvm.viewmodels.CategoryViewModel
import com.example.mvvm.viewmodels.Covid19ViewModel
import kotlinx.android.synthetic.main.innerlayout.view.*

class RecyclerAdapter(
    private val context: MainActivity,
    private val nicePlaces: ArrayList<Covid19ViewModel>
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
        holder.t1?.text = nicePlaces[position].date
        holder.t2?.text = nicePlaces[position].dailyconfirmed
        holder.t3?.text = nicePlaces[position].dailydeceased
        holder.t4?.text = nicePlaces[position].dailyrecovered
        holder.t5?.text = nicePlaces[position].totalconfirmed
        holder.t6?.text = nicePlaces[position].totaldeceased
        holder.t7?.text = nicePlaces[position].totalrecovered
//        holder.itemView.setOnClickListener {
//            println("!!Q!!Q!Q!Q! :-"+nicePlaces?.get(position))
//        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val t1: TextView = view.date
        val t2: TextView = view.dailyconfirmed
        val t3: TextView = view.dailydeceased
        val t4: TextView = view.dailyrecovered
        val t5: TextView = view.totalconfirmed
        val t6: TextView = view.totaldeceased
        val t7: TextView = view.totalrecovered
    }
}
