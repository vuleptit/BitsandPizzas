package com.ptit.bitsandpizzas;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        ActionBar actionBar = getActionBar();
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setIntent("This is test String");
        return super.onCreateOptionsMenu(menu);
    }

    private void setIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_setting:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
