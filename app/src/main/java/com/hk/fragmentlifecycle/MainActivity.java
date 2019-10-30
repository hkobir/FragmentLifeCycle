package com.hk.fragmentlifecycle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load the fragment using FragmentManager
        manager = getSupportFragmentManager();

       // Toast.makeText(this, "for exploring override method go logcat and type MainActivity|FragmentA", Toast.LENGTH_LONG).show();
    }


    public void addA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.add(R.id.container,fragmentA,"fragA");
        transaction.commit();

    }
    public void removeA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA!=null){
            transaction.remove(fragmentA);
            transaction.commit();

        }
        else{
            Toast.makeText(this, "Fragment A not found!", Toast.LENGTH_SHORT).show();
        }
    }
    public void addB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.add(R.id.container,fragmentB,"fragB");
        transaction.commit();
    }
    public void removeB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction =manager.beginTransaction();
        if(fragmentB!=null){
            transaction.remove(fragmentB);
            transaction.commit();

        }
        else{
            Toast.makeText(this, "Fragment B not found!", Toast.LENGTH_SHORT).show();
        }

    }


    public void replacewithA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.replace(R.id.container,fragmentA,"fragA");
        transaction.commit();
    }

    public void replacewithB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.replace(R.id.container,fragmentB,"fragB");
        transaction.commit();
    }
}
