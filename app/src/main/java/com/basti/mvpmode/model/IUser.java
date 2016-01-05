package com.basti.mvpmode.model;

/**
 * Created by SHIBW-PC on 2016/1/5.
 */
public interface IUser {

    void login(String username,String password,OnLoginListener onLoginListener);

    void search(String username,OnSearchListener onSearchListener);
}
