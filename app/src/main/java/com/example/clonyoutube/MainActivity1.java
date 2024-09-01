package com.example.clonyoutube;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity1 extends AppCompatActivity {
    WebView edWeb1;
    public static String image_url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        edWeb1=findViewById(R.id.edWeb1);



        edWeb1.getSettings().setJavaScriptEnabled(true);
        edWeb1.loadUrl(image_url);







    }
}