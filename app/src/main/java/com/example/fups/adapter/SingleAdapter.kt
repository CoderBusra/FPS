package com.example.fups.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.fups.BR
import com.example.fups.R
import com.example.fups.databinding.SliderListItemBinding
import com.example.fups.listener.SliderClickListener
import com.example.fups.model.SliderModel
import java.util.ArrayList

class SingleAdapter<LISTENER, DATA>(
    private val singleLayout: Int,
    private val clickListener: LISTENER?
) : RecyclerView.Adapter<SingleAdapter<LISTENER, DATA>.ViewHolder>() {

    private var list: MutableList<DATA> = mutableListOf()

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return ViewHolder(
            DataBindingUtil.inflate(layoutInflater, viewType, viewGroup, false),
            clickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemViewType(position: Int): Int = singleLayout

    override fun getItemCount(): Int = list.size

    fun setData(data: MutableList<DATA>?) {
        if (data == null) return
        list.clear()
        list = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ViewDataBinding, private val listener: LISTENER?) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(data: DATA) {
            binding.setVariable(BR.data, data)
            if (listener != null) binding.setVariable(BR.clicklistener, listener)
            binding.executePendingBindings()
        }
    }
}
