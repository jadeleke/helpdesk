package co.obware.hashcode.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import co.obware.hashcode.R;
import ir.alirezabdn.wp7progress.WP10ProgressBar;

public class SipActivity extends AppCompatActivity{

    Toolbar toolbar;
    WebView webView;
    WP10ProgressBar progressBar;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sip );
        webView = findViewById( R.id.sip_webview );
        toolbar = findViewById( R.id.tb_sip );
        progressBar = findViewById( R.id.sip_progressBar );
        setSupportActionBar( toolbar );
        progressBar.showProgressBar();
        progressBar.setIndicatorRadius(5);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle( "SIP" );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        }
        webView.setWebChromeClient( new MyWebChromeClient());
        webView.setWebViewClient( new webClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://sip.gtuc.edu.gh");
    }

    public class MyWebChromeClient extends WebChromeClient {
        public void onProgressChanged(WebView view, int newProgress) {
            progressBar.setVisibility( View.VISIBLE);
            progressBar.showProgressBar();
        }
    }

    public class webClient extends WebViewClient {
        public boolean  shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            progressBar.hideProgressBar();
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
            progressBar.setVisibility(View.GONE);
            progressBar.hideProgressBar();
        } else  {
            super.onBackPressed();
        }
    }
}
