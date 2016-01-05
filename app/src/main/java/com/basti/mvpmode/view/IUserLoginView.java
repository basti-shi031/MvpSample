package com.basti.mvpmode.view;

import com.basti.mvpmode.model.User;

/**
 * Created by SHIBW-PC on 2016/1/5.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void showInfo(User user);

    void showSearchError();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
