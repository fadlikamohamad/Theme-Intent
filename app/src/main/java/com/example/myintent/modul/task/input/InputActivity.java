package com.example.myintent.modul.task.input;

import android.view.View;

import com.example.myintent.base.BaseFragmentHolderActivity;

public class InputActivity extends BaseFragmentHolderActivity {

    InputFragment inputFragment;

    @Override
    protected void initializeFragment() {
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        inputFragment = new InputFragment();
        setCurrentFragment(inputFragment, false);
    }

}
