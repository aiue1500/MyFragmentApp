package com.takaha4apps.myfragmentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.takaha4apps.myfragmentapp.TitlesFragment.OnTitleSelectedListener;

public class MainActivity extends AppCompatActivity
        implements OnTitleSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onTitleSelected(int position) {
        DetailFragment detailFragment = DetailFragment.newInstance(position);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detailFrame,detailFragment)
                .addToBackStack(null)
                .commit();
    }
}
