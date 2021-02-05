package com.hb.rickandmortyapollo.utils

import android.content.Context
import android.view.View
import android.widget.Toast


/**
 * extension function that make any view visible
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * extension function that hide any view (gone)
 */
fun View.hide() {
    visibility = View.GONE
}

/**
 * extension function for the Toast class that takes a string
 */
fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()


