package com.example.myintent.modul.profile;

import android.os.Bundle;
import android.view.View;
import com.example.myintent.base.BaseFragmentHolderActivity;

public class ProfileActivity extends BaseFragmentHolderActivity {

    ProfileFragment profileFragment;

    @Override
    protected void initializeFragment() {
        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("Email");
        String password = bundle.getString("Password");
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        profileFragment = new ProfileFragment(email, password);
        setCurrentFragment(profileFragment, false);
    }

}
