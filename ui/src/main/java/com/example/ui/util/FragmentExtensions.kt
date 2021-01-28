package com.example.ui.util

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import coil.load
import coil.transform.CircleCropTransformation


fun <T : Any, L : LiveData<T>> Fragment.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer(body))
}

fun View.show(show: Boolean) {
    visibility = if (show) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun ImageView.loadUrl(url: Drawable) {
    load(url) {
        crossfade(true)
    }
}