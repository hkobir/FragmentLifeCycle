package com.hk.fragmentlifecycle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private final String TAG = MainActivity.class.getSimpleName();
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load the fragment using FragmentManager
        manager = getSupportFragmentManager();

        //add backStack for implement back button
        manager.addOnBackStackChangedListener(this);

        // Toast.makeText(this, "for exploring override method go logcat and type Fragment, Toast.LENGTH_LONG).show();
    }


    public void addA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("fragA");
        transaction.commit();

    }

    public void removeA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.addToBackStack("fragA");
            transaction.commit();

        } else {
            Toast.makeText(this, "Fragment A not found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void addB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("fragB");
        transaction.commit();
    }

    public void removeB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.addToBackStack("fragB");
            transaction.commit();

        } else {
            Toast.makeText(this, "Fragment B not found!", Toast.LENGTH_SHORT).show();
        }

    }


    public void replacewithA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("fragA");
        transaction.commit();
    }

    public void replacewithB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("fragB");
        transaction.commit();
    }

    public void attachA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.addToBackStack("fragA");
            transaction.commit();

        } else {
            Toast.makeText(this, "Fragment A not found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void dettachA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.addToBackStack("fragA");
            transaction.commit();

        } else {
            Toast.makeText(this, "Fragment A not found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void showA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.show(fragmentA);
            transaction.addToBackStack("fragA");
            transaction.commit();

        } else {
            Toast.makeText(this, "Fragment A not found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.hide(fragmentA);
            transaction.addToBackStack("fragA");
            transaction.commit();

        } else {
            Toast.makeText(this, "Fragment A not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackStackChanged() {

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(manager.getBackStackEntryCount()>0){                //if has any state in stack then back to load it
            manager.popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }
}