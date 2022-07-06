package com.example.widgets

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class Videos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)


        // Variables del videoView
        var vLocal: VideoView = findViewById(R.id.videoViewLocal)
        var vOnline: VideoView = findViewById(R.id.videoViewOnline)

        // Controladores del video
        var mControllerLocal: MediaController = MediaController(this)
        var mControllerOnline: MediaController = MediaController(this)

        // Le pasamos al controlador, el videoView que le corresponde
        mControllerLocal.setAnchorView(vLocal)
        mControllerOnline.setAnchorView(vOnline)

        // Le pasamos al video view la ruta a reproducir
        vOnline.setVideoPath("https://www.jotajotavm.com/img/video.mp4")
        var ruta = "android.resource://" + packageName + "/" + R.raw.video
        vLocal.setVideoURI(Uri.parse(ruta))

        // Indicamos el controlador al video
        vLocal.setMediaController(mControllerLocal)
        vOnline.setMediaController(mControllerOnline)


        /**
         * Calendario
         */

        var calendario: CalendarView = findViewById(R.id.calendarView)
        var tvFecha: TextView = findViewById(R.id.textView)

        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            var date = "$dayOfMonth/${month+1}/$year"
            tvFecha.text = "Fecha seleccionada: $date"
        }

        // ^Poner lunes como primer día de la semana
        var day = calendario.firstDayOfWeek
        calendario.firstDayOfWeek = (day+1) % 7

        /**
         * ProgressBar
         */

        var pbRalla: ProgressBar = findViewById(R.id.pbRalla)
        var pbSecondary: ProgressBar = findViewById(R.id.pbSecondary)
        pbRalla.max = 300
        pbRalla.progress = 0
        pbSecondary.max = 500
        pbSecondary.progress = 0

        GlobalScope.launch {
            pbManager(pbRalla)
            pbManager(pbSecondary)
        }



    }

    fun pbManager(pb: ProgressBar){
        while (pb.progress < pb.max) {
            // pb.progress += 5
            sleep(100L)
            pb.incrementProgressBy(5)

            // Para la barra secundaria
            if (pb.id == R.id.pbSecondary){
                pb.incrementSecondaryProgressBy(10)
            }
        }

    }

}