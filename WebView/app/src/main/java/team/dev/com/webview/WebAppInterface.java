<<<<<<< HEAD
package team.dev.com.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    private Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        this.mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(this.mContext, toast, Toast.LENGTH_SHORT).show();
    }
=======
package team.dev.com.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    private Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        this.mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(this.mContext, toast, Toast.LENGTH_SHORT).show();
    }
>>>>>>> 570f82a09631368aed6127f8aedbe1527028ba45
}