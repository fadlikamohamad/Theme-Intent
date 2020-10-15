package com.example.myintent.modul.task.list;

/**
 * Created by fahrul on 13/03/19.
 */

public class ListPresenter implements ListContract.Presenter{

    private final ListContract.View view;

    public ListPresenter(ListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin(final String email, final String password){
        view.redirectToProfile(email, password);
    }

}
