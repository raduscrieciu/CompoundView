package com.screechstudios.compoundview;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the ArticleView
        final ArticleView articleView = (ArticleView) findViewById(R.id.articleView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArticle(articleView);
            }
        });

    }

    private void populateArticle(final ArticleView articleView) {
        articleView.setLoading(true);

        // Display the article after 3 seconds.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                articleView.setLoading(false);
                articleView.setBackground(Color.LTGRAY);
                articleView.populate("My First Article", "This is my first ever article, hope you enjoy!");
            }
        }, 3000);
    }
}
