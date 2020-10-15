package com.example.myintent.modul.task.list;

import android.view.View;

import com.example.myintent.base.BaseFragmentHolderActivity;

public class ListActivity extends BaseFragmentHolderActivity {

    ListFragment listFragment;

    @Override
    protected void initializeFragment() {
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        listFragment = new ListFragment();
        setCurrentFragment(listFragment, false);
    }

}
