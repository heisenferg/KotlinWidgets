package com.example.widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.core.view.contains

class searchView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)


        var svUsuarios: SearchView = findViewById(R.id.searchView)
        var lvUsuarios: ListView = findViewById(R.id.lvOptions)

        val users = arrayOf("Paco", "Fernanndo", "Ramón", "Aurelio", "Roberto", "Rigoberta", "Lucía", "María", "Isabel")
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)

        lvUsuarios.adapter = adapter

        svUsuarios.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                svUsuarios.clearFocus()
                if (users.contains(query)) adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }

        })
    }

    fun abrirActivity(view: View){
        val intent= Intent (this, SeekBars::class.java)
        startActivity(intent)
    }


}