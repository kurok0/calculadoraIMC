package br.com.vinicidesu.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import br.com.vinicidesu.estacaohack.databinding.ActivityLoginBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wbvWeb.settings.javaScriptEnabled = true
        binding.wbvWeb.loadUrl("https://www.myfitnesspal.com/pt/")
        binding.wbvWeb.webViewClient = WebViewClient()
    }
}