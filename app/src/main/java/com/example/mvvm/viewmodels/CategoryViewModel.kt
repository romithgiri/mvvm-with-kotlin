package com.example.mvvm.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.Category
import com.example.mvvm.utils.RetroFitApiFunction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel {
    var title = ""
    constructor() : super()

    constructor(category: Category) : super() {
        this.title = category.title
    }

    var arrayListMutableLiveData = MutableLiveData<ArrayList<CategoryViewModel>>()
    var arraylist = ArrayList<CategoryViewModel>()

    fun getArrayList():MutableLiveData<ArrayList<CategoryViewModel>>{
        val t1 = Category("1abc")
        val t2 = Category("2abc")
        val t3 = Category("3abc")
        val t4 = Category("4abc")
        val t5 = Category("5abc")

        val categoryViewModel1: CategoryViewModel = CategoryViewModel(t1)
        val categoryViewModel2: CategoryViewModel = CategoryViewModel(t2)
        val categoryViewModel3: CategoryViewModel = CategoryViewModel(t3)
        val categoryViewModel4: CategoryViewModel = CategoryViewModel(t4)
        val categoryViewModel5: CategoryViewModel = CategoryViewModel(t5)

        arraylist.add(categoryViewModel1)
        arraylist.add(categoryViewModel2)
        arraylist.add(categoryViewModel3)
        arraylist.add(categoryViewModel4)
        arraylist.add(categoryViewModel5)

        arrayListMutableLiveData.value = arraylist
        println("ROhit :-"+arrayListMutableLiveData)
        return arrayListMutableLiveData
    }

    fun getCovidDataForIndia(): Unit? {
        GlobalScope.launch(Dispatchers.IO){
            val response = RetroFitApiFunction.api().getIndiaCovid19Data()
            if (response.isSuccessful){
                for (i in response.body()?.DataList!!){
                    println(""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""")
                    println(i)
                    println("************************************************************************")
                }
            }else{
                print("Error")
            }
        }
        println("DDD2222")
        return null
    }
}
