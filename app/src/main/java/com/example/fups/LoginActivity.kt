package com.example.fups

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.fups.adapter.SingleAdapter
import com.example.fups.databinding.ActivityMainBinding
import com.example.fups.listener.CountryClickListener
import com.example.fups.listener.SliderClickListener
import com.example.fups.model.CountryModel
import com.example.fups.model.SliderModel

class LoginActivity : AppCompatActivity(), SliderClickListener {
    val viewModel: LoginViewModel by viewModels()
    val viewModelItem: CountryItemViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        loadData()
        observe()
        click()

    }

    private fun click() {

        binding.countryCode.setOnClickListener {
            val modalBottomSheet = CountryListFragment()
            modalBottomSheet.show(supportFragmentManager, " ModalBottomSheet.TAG")
        }

        binding.button.setOnClickListener {
            if (it.isSelected)
                startActivity(Intent(this, SecondActivity::class.java))
        }
        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.button.isSelected = p0!!.length > 6 && binding.edtPassword.text!!.length > 6

            }

        })
        binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.button.isSelected = p0!!.length > 6 && binding.edtEmail.text!!.length > 6

            }

        })
    }

    private fun observe() {
        viewModelItem.selectedItem.observe(this, Observer {
            binding.tvCountry.setText(it.code)
        })

    }

    private fun loadData() {

        val adapter: SingleAdapter<SliderClickListener, SliderModel> =
            SingleAdapter(R.layout.slider_list_item, this)
        viewModel.slider.observe(this, Observer {
            adapter.setData(it)
        })

        binding.sliderList.adapter = adapter

    }

    override fun itemClick(moder: SliderModel) {
        startActivity(Intent(this, SecondActivity::class.java))
    }


}