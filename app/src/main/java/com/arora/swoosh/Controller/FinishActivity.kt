package com.arora.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arora.swoosh.Model.Player
import com.arora.swoosh.R
import com.arora.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        var player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeagueTxt.text = "Looking for ${player.leauge} ${player.skill} league near you..."
    }
}
