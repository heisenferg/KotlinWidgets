package com.example.widgets

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SeekBars : AppCompatActivity() {

    private lateinit var myontext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bars)

        myontext = this

        var sbCustom: SeekBar = findViewById(R.id.sbNormal)

        sbCustom.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    Toast.makeText(myontext, "Lo cambiastge tú", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
        } )

        GlobalScope.launch {
            changeSeekBar(sbCustom)
        }


        /**
         * RatingBar
         */
        var ratingBar: RatingBar = findViewById(R.id.ratingBar)
        var textRating: TextView = findViewById(R.id.textViewRating)
        ratingBar.rating = 1f
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            textRating.text = "Puntuación: ${rating}/${ratingBar.numStars}"
        }

    }

    private fun changeSeekBar(sb: SeekBar){
        while(true) {
            sleep(100L)
            sb.incrementProgressBy(5)
        }
    }
}