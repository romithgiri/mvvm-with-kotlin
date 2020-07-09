package com.example.mvvm
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.adapter.RecyclerAdapter
import com.example.mvvm.viewmodels.CategoryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var recyclerAdapter: RecyclerAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var categoryViewModel: CategoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        categoryViewModel.getArrayList().observe(this, Observer {categoryViewModel->
            recyclerAdapter = RecyclerAdapter(this, categoryViewModel)
            layoutManager = LinearLayoutManager(this)
            recycler_view.layoutManager = layoutManager
            recycler_view!!.adapter = recyclerAdapter
        })

    }
}