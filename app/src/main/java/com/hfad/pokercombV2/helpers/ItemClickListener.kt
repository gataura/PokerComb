package com.hfad.pokercombV2.helpers

import android.view.View

interface ItemClickListener {

    fun onClick(v:View, position: Int, isLongClick: Boolean)

}