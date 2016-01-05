package com.basti.mvpmode.model;

/**
 * Created by SHIBW-PC on 2016/1/5.
 */
public interface OnLoginListener {

    void loginSuccess(User user);
    void loginFailed();
}
