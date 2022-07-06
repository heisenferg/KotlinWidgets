package com.example.widgets

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var webView: WebView = findViewById(R.id.webView)
        var settigsWeb : WebSettings = webView.settings
        settigsWeb.javaScriptEnabled = true
       // webView.webViewClient
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.marca.com/")
    }
}