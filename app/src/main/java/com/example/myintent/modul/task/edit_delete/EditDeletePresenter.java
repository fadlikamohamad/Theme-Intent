package com.example.myintent.modul.task.edit_delete;

/**
 * Created by fahrul on 13/03/19.
 */

public class EditDeletePresenter implements EditDeleteContract.Presenter{

    private final EditDeleteContract.View view;

    public EditDeletePresenter(EditDeleteContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin(final String email, final String password){
        view.redirectToProfile(email, password);
    }

}
