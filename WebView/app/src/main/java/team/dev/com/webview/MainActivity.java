package team.dev.com.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final TextView textView = findViewById(R.id.textView);
        //textView.setText(Html.fromHtml("Bonjour <i>tout</i> le <b>monde!</b>"));

        /*final InputStream stream = getResources().openRawResource(R.raw.content);
        final String text;
        try {
            text = IOUtils.toString(stream);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

        textView.setText(Html.fromHtml(text));*/

        WebView webView = findViewById(R.id.webView);
        //Enabling JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Binding JavaScript code to Android code
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        webView.loadUrl("file:///android_asset/page.html");
    }
}
