package com.hfad.pokercomb.helper

import android.view.View

interface ItemClickListener {

    fun onClick(v:View, position: Int, isLongClick: Boolean)

}