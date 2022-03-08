package com.example.fups

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fups.model.CountryModel

class CountryItemViewModel : ViewModel() {
    var countryList = MutableLiveData<MutableList<CountryModel>>()
    private val mutableSelectedItem = MutableLiveData<CountryModel>()
    val selectedItem: LiveData<CountryModel>
        get() = mutableSelectedItem

    init {
        getCountyList()
    }

    fun selectItem(item: CountryModel) {
        mutableSelectedItem.value = item
    }

    fun getCountyList() {
        var list = ArrayList<CountryModel>().apply {
            add(CountryModel("+90", "Türkiye",R.drawable.ic_tr))
            add(CountryModel("+33", "France", R.drawable.ic_fr))
            add(CountryModel("+49", "Germany", R.drawable.ic_as))
            add(CountryModel("+20", "USA",R.drawable.ic_us))
            add(CountryModel("+33", "France", R.drawable.ic_fr))
            add(CountryModel("+49", "Germany", R.drawable.ic_as))
            add(CountryModel("+90", "Türkiye",R.drawable.ic_tr))
            add(CountryModel("+33", "France", R.drawable.ic_fr))
            add(CountryModel("+49", "Germany", R.drawable.ic_as))
        }
        countryList.postValue(list)
    }


}