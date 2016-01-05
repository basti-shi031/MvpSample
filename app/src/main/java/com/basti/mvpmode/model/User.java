package com.basti.mvpmode.model;

/**
 * Created by SHIBW-PC on 2016/1/5.
 */
public class User {

    private String username ;
    private String password ;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    @Override
    public String toString() {
        return "userName:"+getUsername()+" passWord:"+getPassword()+" info:"+getInfo();
    }
}
