package com.screechstudios.compoundview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ArticleView extends RelativeLayout {

    private TextView titleTextView;
    private TextView contentTextView;
    private LinearLayout contentLayout;
    private ProgressBar loadingProgress;

    public ArticleView(Context context) {
        super(context);

        initView(context);
    }

    public ArticleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context);
    }

    public ArticleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.view_article, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        contentTextView = (TextView) findViewById(R.id.contentTextView);
        contentLayout = (LinearLayout) findViewById(R.id.contentLayout);
        loadingProgress = (ProgressBar) findViewById(R.id.loadingProgressBar);
    }

    public void setLoading(boolean isLoading) {
        if (isLoading) {
            contentLayout.setVisibility(INVISIBLE);
            loadingProgress.setVisibility(VISIBLE);
        } else {
            contentLayout.setVisibility(VISIBLE);
            loadingProgress.setVisibility(INVISIBLE);
        }
    }

    public void populate(String title, String content) {
        titleTextView.setText(title);
        contentTextView.setText(content);
    }

    public void setBackground(int color) {
        contentLayout.setBackgroundColor(color);
    }

}
