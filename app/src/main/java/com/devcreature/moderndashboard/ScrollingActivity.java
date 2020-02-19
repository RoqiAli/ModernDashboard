package com.devcreature.moderndashboard;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        initStatusBar(toolbar);

        ImageView headImage = findViewById(R.id.head_image);
        Glide.with(this).asGif().load(R.raw.night_hill).into(headImage);

    }

    protected void initStatusBar(View toolbar) {
        ViewGroup contentParent = findViewById(android.R.id.content);
        View content = contentParent.getChildAt(0);
        setFitsSystemWindows(content);
        clipToStatusBar(toolbar);
    }

    protected void setFitsSystemWindows(View view) {
        if (view == null) return;
        view.setFitsSystemWindows(false);
        if ((view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0, n = viewGroup.getChildCount(); i < n; i++) {
                viewGroup.getChildAt(i).setFitsSystemWindows(false);
            }
        }
    }

    protected void clipToStatusBar(View view) {
        final int statusBarHeight = getStatusBarHeight();
        view.getLayoutParams().height += statusBarHeight;
        view.setPadding(0, statusBarHeight, 0, 0);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}