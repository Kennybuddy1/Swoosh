package com.arora.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arora.swoosh.Model.Player
import com.arora.swoosh.R
import com.arora.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
        if (player.leauge.equals("mens"))
        {
            beginnerSkillBtn.setBackgroundResource(R.drawable.swoosh_toggle_men)
            ballerSkillBtn.setBackgroundResource(R.drawable.swoosh_toggle_men)
        }
        else if(player.leauge.equals("womens"))
        {
            beginnerSkillBtn.setBackgroundResource(R.drawable.swoosh_toggle_women)
            ballerSkillBtn.setBackgroundResource(R.drawable.swoosh_toggle_women)
        }
        else
        {
            beginnerSkillBtn.setBackgroundResource(R.drawable.swoosh_toggle_coed)
            ballerSkillBtn.setBackgroundResource(R.drawable.swoosh_toggle_coed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null)
        {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onBallerClicked(view: View)
    {
        if(!ballerSkillBtn.isChecked)
        {
            ballerHintTxt.visibility = View.INVISIBLE
            beginnerHintTxt.visibility = View.INVISIBLE
        }
        else
        {
            beginnerSkillBtn.isChecked = false
            player.skill = "baller"
            ballerHintTxt.visibility = View.VISIBLE
            beginnerHintTxt.visibility = View.INVISIBLE
        }
    }

    fun onBeginnerClicked(view: View)
    {
        if(!beginnerSkillBtn.isChecked)
        {
            beginnerHintTxt.visibility = View.INVISIBLE
            ballerHintTxt.visibility = View.INVISIBLE
        }
        else
        {
            ballerSkillBtn.isChecked = false
            player.skill = "beginner"
            beginnerHintTxt.visibility = View.VISIBLE
            ballerHintTxt.visibility = View.INVISIBLE
        }
    }

    fun onSkillFinishedClicked(view: View)
    {
        if(player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }
        else
        {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}
