package com.tech.webviewtest

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    var et_url: EditText? = null
    var btn_search: Button? = null
    var webView: WebView? = null
    var btn_youtube: ImageButton? = null
    var btn_java: ImageButton? = null
    var btn_insta: ImageButton? = null
    var btn_github: ImageButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        webView?.loadUrl("https://github.com/dnyaneshrt")

        //to display webpages into our web view
        webView?.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

        }

        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.builtInZoomControls = true

    }

    private fun initialize() {
        et_url = findViewById(R.id.et_url)
        btn_search = findViewById(R.id.btn_serach)
        webView = findViewById(R.id.webview)
        btn_youtube = findViewById(R.id.btn_youtube)
        btn_java = findViewById(R.id.btn_javatpoint)
        btn_insta = findViewById(R.id.btn_instagram)
        btn_github = findViewById(R.id.btn_github)


    }


    //these method will excute after clicking on any of the 5 buttons
    fun callUrl(view: View) {

        var url = et_url?.text.toString()

        when (view.id) {
            R.id.btn_serach -> {
                webView?.loadUrl(url)
            }

            R.id.btn_youtube -> {
                webView?.loadUrl("https://www.youtube.com/")
            }
            R.id.btn_javatpoint -> {
                //load url method is used to load the url
                webView?.loadUrl("https://www.javatpoint.com/")
            }
            R.id.btn_instagram -> {
                webView?.loadUrl("https://www.instagram.com/")
            }
            R.id.btn_github -> {
                webView?.loadUrl("https://github.com/")
            }
        }


    }
}