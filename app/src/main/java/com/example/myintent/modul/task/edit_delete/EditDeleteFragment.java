package com.example.myintent.modul.task.edit_delete;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.myintent.R;
import com.example.myintent.base.BaseFragment;
import com.example.myintent.modul.profile.ProfileActivity;
import com.example.myintent.modul.task.input.InputActivity;
import com.example.myintent.modul.task.list.ListActivity;

/**
 * Created by fahrul on 13/03/19.
 */

public class EditDeleteFragment extends BaseFragment<EditDeleteActivity, EditDeleteContract.Presenter> implements EditDeleteContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnUpdate;
    Button btnDelete;

    public EditDeleteFragment() {}

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_edit_delete, container, false);
        mPresenter = new EditDeletePresenter(this);
        mPresenter.start();
        etEmail = fragmentView.findViewById(R.id.et_email);
        etPassword = fragmentView.findViewById(R.id.et_password);
        btnLogin = fragmentView.findViewById(R.id.bt_login);
        btnUpdate = fragmentView.findViewById(R.id.buttonUpdate);
        btnDelete = fragmentView.findViewById(R.id.buttonDelete);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToList();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToList();
            }
        });
        setTitle("My Edit/Delete View");

        return fragmentView;
    }

    public void setBtLoginClick(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.performLogin(email,password);
    }

    public void backToList() {
        Intent intent = new Intent(activity, ListActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void setPresenter(EditDeleteContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToProfile(String email, String password) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(activity, ProfileActivity.class);
        bundle.putString("Email", email);
        bundle.putString("Password", password);
        intent.putExtras(bundle);
        startActivity(intent);
        activity.finish();
    }

}
