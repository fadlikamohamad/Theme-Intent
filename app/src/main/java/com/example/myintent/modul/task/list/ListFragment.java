package com.example.myintent.modul.task.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.myintent.R;
import com.example.myintent.base.BaseFragment;
import com.example.myintent.modul.profile.ProfileActivity;
import com.example.myintent.modul.task.edit_delete.EditDeleteActivity;
import com.example.myintent.modul.task.input.InputActivity;

/**
 * Created by fahrul on 13/03/19.
 */

public class ListFragment extends BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnAdd;
    ListView lvDetail;

    public ListFragment() {}

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        mPresenter = new ListPresenter(this);
        mPresenter.start();
        etEmail = fragmentView.findViewById(R.id.et_email);
        etPassword = fragmentView.findViewById(R.id.et_password);
        btnLogin = fragmentView.findViewById(R.id.bt_login);
        lvDetail = fragmentView.findViewById(R.id.listView);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });
        btnAdd = fragmentView.findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToInput();
            }
        });
        lvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetail();
            }
        });
        setTitle("My List View");

        return fragmentView;
    }

    public void setBtLoginClick(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.performLogin(email,password);
    }

    public void moveToInput() {
        Intent intent = new Intent(activity, InputActivity.class);
        startActivity(intent);
        activity.finish();
    }

    public void showDetail() {
        Intent intent = new Intent(activity, EditDeleteActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void setPresenter(ListContract.Presenter presenter) {
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
