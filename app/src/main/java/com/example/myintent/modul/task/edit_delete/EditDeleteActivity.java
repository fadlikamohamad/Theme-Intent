package com.example.myintent.modul.task.edit_delete;

import android.view.View;

import com.example.myintent.base.BaseFragmentHolderActivity;

public class EditDeleteActivity extends BaseFragmentHolderActivity {

    EditDeleteFragment editDeleteFragment;

    @Override
    protected void initializeFragment() {
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        editDeleteFragment = new EditDeleteFragment();
        setCurrentFragment(editDeleteFragment, false);
    }

}
