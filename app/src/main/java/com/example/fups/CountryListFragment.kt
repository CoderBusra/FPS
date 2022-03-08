package com.example.fups

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.fups.adapter.SingleAdapter
import com.example.fups.databinding.CountryListFragmentBinding
import com.example.fups.listener.CountryClickListener
import com.example.fups.model.CountryModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CountryListFragment : BottomSheetDialogFragment(), CountryClickListener {
    val viewModel: CountryItemViewModel by activityViewModels()
    private lateinit var binding: CountryListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.country_list_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        click()
    }

    private fun click() {
        binding.tcClose.setOnClickListener {
            dismiss()
        }
    }

    private fun loadData() {
        val adapter: SingleAdapter<CountryClickListener, CountryModel> =
            SingleAdapter(R.layout.country_list_item, this)
        viewModel.countryList.observe(this, Observer {
            adapter.setData(it)
        })
        binding.sliderList.adapter = adapter
    }

    override fun itemClick(model: CountryModel) {
        viewModel.selectItem(model)
        dismiss()
    }


}