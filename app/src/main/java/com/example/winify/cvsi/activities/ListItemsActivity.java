package com.example.winify.cvsi.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.winify.cvsi.fragments.ListItemsFragment;
import com.example.winify.cvsi.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class stands as a base class, containing the Navigation Drawer and the Toolbar, with general elements
 */
public class ListItemsActivity extends BaseActivity {

    private static ViewGroup viewGroup;
    protected static Fragment fragment;
    private FloatingActionMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        this.initBuilder();
        menu = (FloatingActionMenu) findViewById(R.id.menu);
        showListItemsFragment();
        initMenu();
        initToolbar();

    }

    @Override
    public void onBackPressed() {
        if (menu.isOpened()) {
            menu.close(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_menu);
        getMenuInflater().inflate(R.menu.sub_menu, menuItem.getSubMenu());
        return true;
    }

    public void initMenu() {
        menu = (FloatingActionMenu) findViewById(R.id.menu);

        HashMap<FloatingActionButton, Class> fabMapList = new HashMap<FloatingActionButton, Class>();
        fabMapList.put((FloatingActionButton) findViewById(R.id.fab1), CreateBorrowProductActivity.class);
        fabMapList.put((FloatingActionButton) findViewById(R.id.fab2), CreateBuyProductActivity.class);
        fabMapList.put((FloatingActionButton) findViewById(R.id.fab3), CreateSellProductActivity.class);

        for (HashMap.Entry<FloatingActionButton, Class> entry : fabMapList.entrySet()) {
            onMenuButtonClicked(entry.getKey(), entry.getValue());
        }
    }

    private void onMenuButtonClicked(FloatingActionButton fab, final Class classy) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), classy));
            }
        });
    }

    public void showListItemsFragment() {
        viewGroup = (ViewGroup) findViewById(R.id.fragment_place);
        fragment = new ListItemsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}
