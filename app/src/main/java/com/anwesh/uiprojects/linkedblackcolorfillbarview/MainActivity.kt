package com.anwesh.uiprojects.linkedblackcolorfillbarview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.blackcolorfillbarview.BlackColorFillBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BlackColorFillBarView.create(this)
    }
}
