package com.devcreature.moderndashboard;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devcreature.moderndashboard.adapter.MenuAdapter;
import com.devcreature.moderndashboard.data.MenuData;
import com.devcreature.moderndashboard.model.MenuModel;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity
    implements MenuAdapter.OnClickListener{

    private ArrayList<MenuModel> menuModels = new ArrayList<>();

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
        titleToggle();

        ImageView headImage = findViewById(R.id.head_image);
        Glide.with(this).asGif().load(R.raw.night_hill).into(headImage);
        RecyclerView recyclerView = findViewById(R.id.rv_menu);
        recyclerView.setHasFixedSize(true);

        menuModels.addAll(MenuData.getListData());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        MenuAdapter menuAdapter = new MenuAdapter(menuModels, this);
        recyclerView.setAdapter(menuAdapter);

    }

    private void titleToggle(){
        AppBarLayout barLayout = findViewById(R.id.app_bar);
        final LinearLayout linearLayout = findViewById(R.id.parent_profile);

        barLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    linearLayout.setVisibility(View.GONE);
                    isShow = true;
                } else if (isShow) {
                    linearLayout.setVisibility(View.VISIBLE);
                    isShow = false;
                }
            }
        });
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

    @Override
    public void onItemClickListener(int position) {
        Toast.makeText(this, ""+menuModels.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}