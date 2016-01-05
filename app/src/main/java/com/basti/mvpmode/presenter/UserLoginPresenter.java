package com.basti.mvpmode.presenter;

import android.os.Handler;

import com.basti.mvpmode.model.OnLoginListener;
import com.basti.mvpmode.model.OnSearchListener;
import com.basti.mvpmode.model.User;
import com.basti.mvpmode.model.UserImpl;
import com.basti.mvpmode.view.IUserLoginView;

/**
 * Created by SHIBW-PC on 2016/1/5.
 */
public class UserLoginPresenter {

    private UserImpl mUserImpl;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView){
        mUserImpl = new UserImpl();
        this.userLoginView = userLoginView;
    }

    public void login(){
        userLoginView.showLoading();

        mUserImpl.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

    public void search(){
        userLoginView.showLoading();
        mUserImpl.search(userLoginView.getUserName(), new OnSearchListener() {
            @Override
            public void searchSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.showInfo(user);
                    }
                });
            }

            @Override
            public void searchFailed() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.showSearchError();
                    }
                });

            }
        });
    }
}
