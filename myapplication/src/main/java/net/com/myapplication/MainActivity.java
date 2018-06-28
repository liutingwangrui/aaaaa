package net.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.xmwdkk.boothprint.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        textView = findViewById(R.id.tv);
        webView = findViewById(R.id.wv);
       Button button= findViewById(R.id.scan);
        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivityForResult(new Intent(MainActivity.this, ScannerActivity.class), 1);
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            textView.setText(data.getStringExtra("text")); // 显示识别到的文字
            webView.loadUrl(data.getStringExtra("text")); // 将识别的内容当作网址加载到WebView
        }
    }
}
