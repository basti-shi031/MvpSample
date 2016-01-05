package com.basti.mvpmode.model;

/**
 * 具体实现
 * Created by SHIBW-PC on 2016/1/5.
 */
public class UserImpl implements IUser{
    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("123".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.loginSuccess(user);
                } else
                {
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }

    @Override
    public void search(final String username, final OnSearchListener onSearchListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("123".equals(username))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword("");
                    user.setInfo("测试账号");
                    onSearchListener.searchSuccess(user);
                } else
                {
                    onSearchListener.searchFailed();
                }
            }
        }.start();
    }
}
