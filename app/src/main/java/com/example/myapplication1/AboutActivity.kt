package com.example.myapplication1

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.http.SslError
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_about.view.*


    class AboutActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_about)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
                web_view.apply {
                    settings.javaScriptEnabled = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    webViewClient = object : WebViewClient() {

                        override fun onReceivedSslError(
                            view: WebView?,
                            handler: SslErrorHandler?,
                            error: SslError?
                        ) {
                            handler?.proceed()
                        }
                }
        }

        if (isConnected) {
            web_view.loadUrl(getString(R.string.about_url))
        } else {
            Snackbar.make(
                main, getString(R.string.check_internet),
                Snackbar.LENGTH_INDEFINITE
            ).setAction(getString(R.string.reload)) {
                web_view.loadUrl(getString(R.string.about_url))
            }.show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
    val Context.isConnected: Boolean
        get() {
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager
                .activeNetworkInfo?.isConnected == true && connectivityManager.activeNetworkInfo != null

        }

