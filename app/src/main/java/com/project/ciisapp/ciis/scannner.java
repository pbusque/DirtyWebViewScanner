package com.project.ciisapp.ciis;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;

import android.webkit.WebViewClient;
import android.widget.Toast;


public class scannner extends AppCompatActivity {
   private WebView wvv;



 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  wvv = (WebView)findViewById(R.id.wvv);
  wvv.setWebChromeClient(new WebChromeClient());
  wvv.setWebViewClient(new WebViewClient(){



   @Override
   public boolean shouldOverrideUrlLoading(WebView view, String url) {
    view.loadUrl(url);

    if (url.startsWith("http") || url.startsWith("https")) {
     return true;
    }else {
     wvv.stopLoading();
     wvv.goBack();
     Toast.makeText(scannner.this, "Unknown Link, unable to handle", Toast.LENGTH_SHORT).show();
    }
    return false;



   }});

  Intent intent=getIntent();
  String QRurl = getIntent().getExtras().getString("QRurl");
  wvv.setWebViewClient(new WebViewClient());

  wvv.loadUrl(QRurl);
  WebSettings webSettings = wvv.getSettings();
  webSettings.setJavaScriptEnabled(true);
 }}
