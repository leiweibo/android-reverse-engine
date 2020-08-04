package com.wblei.trywebview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private WebView webview;
  private final String URL = "https://m.baidu.com/";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webview = findViewById(R.id.webview);
    webview.setWebViewClient(new WebViewClient() {
      @Override public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return super.shouldOverrideKeyEvent(view, event);
      }

      @Nullable @Override
      public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return super.shouldInterceptRequest(view, request);
      }
    });
    webview.getSettings().setJavaScriptEnabled(true);
    webview.getSettings().setDomStorageEnabled(true);
    webview.addJavascriptInterface(new JScriptInterface(this), "JSInterface");
    webview.loadUrl(URL);

    findViewById(R.id.callJs).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        webview.loadUrl("javascript:window.JSInterface.getValue(document.getElementById('index-kw').value);");
      }
    });
  }

  public class JScriptInterface {
    private Context context;

    public JScriptInterface(Context context) {
      this.context = context;
    }

    @JavascriptInterface
    public void getValue(String value) {
      Log.e("MainActivity", "get the value:" + value);
    }
  }
}
