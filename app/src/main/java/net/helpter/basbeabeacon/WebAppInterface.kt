package net.helpter.basbeabeacon

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast
import org.json.JSONObject

/** Instantiate the interface and set the context.  */
class WebAppInterface(private val mContext: Context) {

    /** Show a toast from the web page.  */
    @JavascriptInterface
    fun postMessage(arg: String) {
        val major = JSONObject(arg).getString("major")
        Toast.makeText(mContext, major, Toast.LENGTH_SHORT).show()


     //   sendWeb()
    }
}