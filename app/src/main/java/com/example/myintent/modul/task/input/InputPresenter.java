package com.example.myintent.modul.task.input;

/**
 * Created by fahrul on 13/03/19.
 */

public class InputPresenter implements InputContract.Presenter{

    private final InputContract.View view;

    public InputPresenter(InputContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin(final String email, final String password){
        view.redirectToProfile(email, password);
    }

}
