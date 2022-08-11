package com.example.widgets

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var drawer: DrawerLayout
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    /**    var webView: WebView = findViewById(R.id.webView)
        var settigsWeb: WebSettings = webView.settings
        settigsWeb.javaScriptEnabled = true
        // webView.webViewClient
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.marca.com/")

*/

        initToolBar()
    }


    private fun initToolBar(){
        val toolBar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolBar)

        drawer = findViewById(R.id.mainMi)
        val toogle = ActionBarDrawerToggle (
            this,drawer, toolBar, R.string.bar_title, R.string.navgation_drawer_close
                )
        drawer.addDrawerListener(toogle)
        toogle.syncState()

    }

    private fun initNavitagionView(){
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        var headerView: View = LayoutInflater.from(this).inflate(R.layout.header_nav_bar, navigationView, false)

        navigationView.removeHeaderView(headerView)
        navigationView.addHeaderView(headerView)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

}