package com.example.webaplivcation.webView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.webaplivcation.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    private WebView webView;
    private Button cancelLoadingButton;
    private String url = "https://students.kpfu.ru";
    SwipeRefreshLayout mySwipeRefreshLayout;

    Activity activity;
    private ProgressDialog progDailog;

    //    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);

//        activity = this;

//        progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
//        progDailog.setCancelable(false);
        webView = (WebView) findViewById(R.id.webBrowser);

        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
//        Делаем зум
        webView.getSettings().setBuiltInZoomControls(true);
//        убрали кнопки зума
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setAppCacheEnabled(true);
//        webView.clearCache(true);

//        webView.getSettings().setAppCacheMaxSize(1024*1024*8);
//        webView.getSettings().setAppCachePath("./data/data/com.example.webaplivcation/cache/WebView");
//        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

//        new Thread(new Runnable() {
//            public void run() {
//                webView.post(new Runnable() {
//                    public void run() {
//                        cancelLoadingButton = (Button) findViewById(R.id.cancelLoadingButton);
//
//                        cancelLoadingButton.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                webView.stopLoading();
//                                System.out.println("-------------------------------");
//                            }
//                        });
//
////                            webView = (WebView) findViewById(R.id.webBrowser);
////
////                            mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
////
////                            webView.getSettings().setJavaScriptEnabled(true);
////                            webView.getSettings().setLoadWithOverviewMode(true);
////                            webView.getSettings().setUseWideViewPort(true);
//////        Делаем зум
////                            webView.getSettings().setBuiltInZoomControls(true);
//////        убрали кнопки зума
////                            webView.getSettings().setDisplayZoomControls(false);
////                            webView.getSettings().setAppCacheEnabled(true);
////
//////        webView.getSettings().setAppCacheMaxSize(1024*1024*8);
//////        webView.getSettings().setAppCachePath("./data/data/com.example.webaplivcation/cache/WebView");
//////        webView.getSettings().setAppCacheEnabled(true);
////                            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
//
//                        if (Build.VERSION.SDK_INT >= 19) {
//                            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//                        }
////        if (isNetworkAvailable()){
////            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
////        }else {
////            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY );
////        }
////        WebSettings webSettings = webView.getSettings();
//
////        webSettings.setAllowContentAccess(true);
////        webSettings.setAppCacheEnabled(true);
////        webSettings.setDatabaseEnabled(true);
////        webSettings.setLoadWithOverviewMode(true);
////        webSettings.setUseWideViewPort(true);
////        webSettings.setDomStorageEnabled(true);
////        webSettings.setDatabaseEnabled(true);
////        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
////        webSettings.setAllowContentAccess(true);
////        webSettings.setAllowFileAccessFromFileURLs(true);
////        webSettings.setJavaScriptEnabled(true);
//
//
////        webView.loadUrl(url);
////        webView.setWebViewClient(new WebViewClient(){
////
////            @Override
////            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                progDailog.show();
////                view.loadUrl(url);
////
////                return true;
////            }
////            @Override
////            public void onPageFinished(WebView view, final String url) {
////                progDailog.dismiss();
////            }
////        });
//
//                        webView.loadUrl(url);
//
////        Начала загрузки и запуск анимации
//                        mySwipeRefreshLayout.setOnRefreshListener(
//                                new SwipeRefreshLayout.OnRefreshListener() {
//                                    @Override
//                                    public void onRefresh() {
////                        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
////
////                        if (Build.VERSION.SDK_INT >= 19) {
////                            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
////                        }
////                        if (isNetworkAvailable()){
////                            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
////                        }else {
////                            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY );
////                        }
//                                        if (isNetworkAvailable()) {
////                            WebView obj;
//                                            webView.clearCache(true);
//                                            webView.reload();
//                                        }else {
//                                            mySwipeRefreshLayout.setRefreshing(false);
//                                            Toast.makeText(getApplicationContext(),
//                                                    "Нет подклюение к интернету!", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                }
//                        );
//
////        отключение анимации обновления страницы
//                        webView.setWebViewClient(new WebViewClient() {
//                            @Override
//                            public void onPageFinished(WebView view, String url) {
//                                super.onPageFinished(view, url);
//                                mySwipeRefreshLayout.setRefreshing(false);
//                            }
//
//                            //            Открытваь новые вкладке в приложении
//                            @Override
//                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                view.loadUrl(url);
////                if (isNetworkAvailable()){
////                    webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
////                }else {
////                    webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY );
////                }
//                                view.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
//
//                                if (Build.VERSION.SDK_INT >= 19) {
//                                    view.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//                                }
//                                view.loadUrl(url);
//                                return true;
//                            }
//                        });
//
//                        webView.setWebChromeClient(new WebChromeClient() {
//                            @Override
//                            public void onProgressChanged(WebView view, int newProgress) {
//                                super.onProgressChanged(view, newProgress);
//
//                                if (newProgress == 100) {
////                    Выводим название сайта
//                                    setTitle(view.getTitle());
////                    Выводим ссылку сайта
//                                    setTitle(view.getUrl());
//                                } else {
//                                    setTitle("Загрузка страницы...");
//                                }
//                            }
//                        });
//                    }
//                });
//
//            }
//        }).start();


        cancelLoadingButton = (Button) findViewById(R.id.cancelLoadingButton);

        cancelLoadingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.stopLoading();
                System.out.println("-------------------------------");
            }
        });

        webView = (WebView) findViewById(R.id.webBrowser);

        mySwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipeContainer);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
//        Делаем зум
        webView.getSettings().setBuiltInZoomControls(true);
//        убрали кнопки зума
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setAppCacheEnabled(true);

//        webView.getSettings().setAppCacheMaxSize(1024*1024*8);
//        webView.getSettings().setAppCachePath("./data/data/com.example.webaplivcation/cache/WebView");
//        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
//        if (isNetworkAvailable()){
//            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        }else {
//            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY );
//        }
//        WebSettings webSettings = webView.getSettings();

//        webSettings.setAllowContentAccess(true);
//        webSettings.setAppCacheEnabled(true);
//        webSettings.setDatabaseEnabled(true);
//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setUseWideViewPort(true);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setDatabaseEnabled(true);
//        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        webSettings.setAllowContentAccess(true);
//        webSettings.setAllowFileAccessFromFileURLs(true);
//        webSettings.setJavaScriptEnabled(true);


//        webView.loadUrl(url);
//        webView.setWebViewClient(new WebViewClient(){
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                progDailog.show();
//                view.loadUrl(url);
//
//                return true;
//            }
//            @Override
//            public void onPageFinished(WebView view, final String url) {
//                progDailog.dismiss();
//            }
//        });

        webView.loadUrl(url);

//        Начала загрузки и запуск анимации
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
//                        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
//
//                        if (Build.VERSION.SDK_INT >= 19) {
//                            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//                        }
//                        if (isNetworkAvailable()){
//                            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//                        }else {
//                            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY );
//                        }
                        if (isNetworkAvailable()) {
//                            WebView obj;
                            webView.clearCache(true);
                            webView.reload();
                        }else {
                            mySwipeRefreshLayout.setRefreshing(false);
                            Toast.makeText(getApplicationContext(),
                                    "Нет подклюение к интернету!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

//        отключение анимации обновления страницы
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mySwipeRefreshLayout.setRefreshing(false);
            }

//            Открытваь новые вкладке в приложении
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                if (isNetworkAvailable()){
//                    webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//                }else {
//                    webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY );
//                }
                view.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

                if (Build.VERSION.SDK_INT >= 19) {
                    view.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                }
                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                if (newProgress == 100) {
//                    Выводим название сайта
                    setTitle(view.getTitle());
//                    Выводим ссылку сайта
                    setTitle(view.getUrl());
                } else {
                    setTitle("Загрузка страницы...");
                }
            }
        });
    }

    private String getContent(String path) throws IOException {
        BufferedReader reader=null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            URL url=new URL(path);
            connection =(HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("GET"); // установка метода получения данных -GET
            connection.setReadTimeout(10000); // установка таймаута перед выполнением - 10 000 миллисекунд
            connection.connect(); // подключаемся к ресурсу
            stream = connection.getInputStream();
            reader= new BufferedReader(new InputStreamReader(stream));
            StringBuilder buf=new StringBuilder();
            String line;
            while ((line=reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            return(buf.toString());
        }
        finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    public void buttonCopyURL(View view) {
            String url = webView.getUrl();
            ClipboardManager clipboard = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", url);
            clipboard.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(),
                "Ссылка скопирована!", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onBackPressed() {
        if (webView.canGoForward())
            webView.goForward();
    }

    public  void forwardButton(View view){
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        if (isNetworkAvailable()) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
            if (webView.canGoForward())
                webView.goForward();
        }else {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY/*LOAD_CACHE_ELSE_NETWORK*/);
            if (webView.canGoForward())
                webView.goForward();
        }
//        else
//            finish();
    }

    public  void backButton(View view){
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        if (isNetworkAvailable()) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
            if (webView.canGoBack())
                webView.goBack();
        }else {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY/*LOAD_CACHE_ELSE_NETWORK*/);
            if (webView.canGoBack())
                webView.goBack();
        }
//        else
//            finish();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

//    public   void cancelLoadingButton(View view){
//        webView.stopLoading();
//    }
}