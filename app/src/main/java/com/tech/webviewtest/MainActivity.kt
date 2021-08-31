package com.tech.webviewtest

import android.content.DialogInterface
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var et_url: EditText? = null
    var btn_search: Button? = null
    var webView: WebView? = null
    var btn_youtube: ImageButton? = null
    var btn_java: ImageButton? = null
    var btn_insta: ImageButton? = null
    var btn_github: ImageButton? = null
    var progress_bar: ProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        webView?.loadUrl("https://github.com/dnyaneshrt")

        //to display webpages into our web view
        webView?.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

//                Toast.makeText(this@MainActivity, url, Toast.LENGTH_SHORT).show()
                progress_bar?.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress_bar?.visibility = View.GONE
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
        progress_bar = findViewById(R.id.progress_bar)

    }


    //these method will excute after clicking on any of the 5 buttons
    fun callUrl(view: View) {

        var url = et_url?.text.toString()

        when (view.id) {
            R.id.btn_serach -> {
                webView?.loadUrl("https://${url}")
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

    //this method will execute after clicking on back button.
    //Alert dialog
    @Override
    override fun onBackPressed() {

        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Exit App!")
            alertDialog.setMessage("Do you really want to exit app?")
            alertDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24)
            alertDialog.setCancelable(false)

            var listener = DialogInterface.OnClickListener { dialogInterface, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    super.onBackPressed()
                    finish()
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    dialogInterface.dismiss()

                } else if (which == DialogInterface.BUTTON_NEUTRAL) {
                    dialogInterface.dismiss()
                }

            }

            alertDialog.setPositiveButton("yes", listener)
            alertDialog.setNegativeButton("no", listener)
            alertDialog.setNeutralButton("cancel", listener)
            alertDialog.show()


        }
    }
}