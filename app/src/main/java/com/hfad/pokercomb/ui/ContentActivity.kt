package com.hfad.pokercomb.ui

import com.hfad.pokercomb.R
import com.hfad.pokercomb._core.BaseActivity


/**
 * Created by Andriy Deputat email(andriy.deputat@gmail.com) on 3/13/19.
 *
 * TODO: add here content for bots or unsuitable users
 */
class ContentActivity : BaseActivity() {
    override fun getContentView(): Int = R.layout.activity_content

    override fun initUI() {
    }

    override fun setUI() {
        logEvent("content-screen")
    }
}