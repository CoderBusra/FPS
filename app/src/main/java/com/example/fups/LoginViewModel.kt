package com.example.fups

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fups.model.SliderModel

class LoginViewModel : ViewModel() {
    var slider = MutableLiveData<ArrayList<SliderModel>>()
    init {
        sliderList()
    }
    fun sliderList() {
        var list = ArrayList<SliderModel>().apply {
            add(SliderModel("SOSYAL HESAP","Sosyal Hesap’larını\n" +
                    "oluşturarak sevdiklerine\n" +
                    "para gönder, iste.", R.drawable.image_banner_big_01))
            add(SliderModel("OYUN & E-PIN","Oyun servislerine hızlıca para aktarın,\n" +
                    "vakit kaybetmeyin.\n" +
                    "para gönder, iste.", R.drawable.image_banner_big_02))
        }
        slider.postValue(list)
    }


}