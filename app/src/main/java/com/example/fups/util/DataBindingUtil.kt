package com.example.fups.util

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.fups.R

@BindingAdapter("drawable")
fun drawable(view: ImageView, drawable: Int?) {
    drawable?.let { view.setImageResource(it) }
}


@BindingAdapter("circledrawable")
fun circledrawable(view: ImageView, drawable: Int?) {
    Glide.with(view.context)
        .load(drawable).transform(CircleCrop())
        .into(view)
}