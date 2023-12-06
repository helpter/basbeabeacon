package net.helpter.basbeabeacon

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import androidx.appcompat.app.AppCompatActivity
import net.helpter.basbeabeacon.databinding.ActivityMainBinding

@SuppressLint("SetJavaScriptEnabled")
class MainActivity : AppCompatActivity() {
    //private var webview: WebViewClient// = findViewById(R.id.webView)
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://bnq.kr/basbea/webview.html")
        binding.webView.webChromeClient = WebChromeClient()
        binding.webView.addJavascriptInterface(WebAppInterface(this), "Android")

        sendWeb()
        
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    
    private fun sendWeb(){
        binding.webView.loadUrl("javascript:rcvData('statusOk')")
    }
/*    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (webview.canGoBack()){
            webview.goBack();
        }
        else
        {
            finish();
        }
    }*/
}