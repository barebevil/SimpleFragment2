package com.derekpoon.simplefragment2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

//Fragment transactions should be handled in the activity

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFragment;
    SecondFragment secondFragment;
    private final String FRAG1_TAG = "frag1", FRAG2_TAG = "frag2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if the fragment exists
        if (savedInstanceState != null) {
            // look up the instance that already exists by tag
            firstFragment = (FirstFragment)
                    getSupportFragmentManager().findFragmentByTag(FRAG1_TAG);
            secondFragment = (SecondFragment)
                    getSupportFragmentManager().findFragmentByTag(FRAG2_TAG);

            //if fragment doesn't exist, example, launching the app for the first time
        } else if (firstFragment == null && secondFragment == null) {
            // create a new fragment
            firstFragment = new FirstFragment();
            secondFragment = new SecondFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_top, firstFragment, FRAG1_TAG);
            ft.replace(R.id.fragment_bottom, secondFragment, FRAG2_TAG);
            ft.commit();
        }
    }
}
