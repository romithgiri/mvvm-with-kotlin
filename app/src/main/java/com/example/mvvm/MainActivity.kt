package com.example.mvvm
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.adapter.RecyclerAdapter
import com.example.mvvm.utils.RetroFitApiFunction
import com.example.mvvm.viewmodels.CategoryViewModel
import com.example.mvvm.viewmodels.Covid19ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var recyclerAdapter: RecyclerAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var covid19ViewModel: Covid19ViewModel = ViewModelProviders.of(this).get(Covid19ViewModel::class.java)

        covid19ViewModel.getCovidDataForIndia()?.observe(this, Observer {covid19ViewModel->
            recyclerAdapter = RecyclerAdapter(this, covid19ViewModel)
            layoutManager = LinearLayoutManager(this)
            recycler_view.layoutManager = layoutManager
            recycler_view!!.adapter = recyclerAdapter
        })
    }

}