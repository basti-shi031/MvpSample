package com.basti.mvpmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.basti.mvpmode.model.User;
import com.basti.mvpmode.presenter.UserLoginPresenter;
import com.basti.mvpmode.view.IUserLoginView;

/**
 * Created by SHIBW-PC on 2016/1/5.
 */
public class MainActivity extends AppCompatActivity implements IUserLoginView {

    private AppCompatEditText et_UserName,et_Password;
    private Button bt_Login,bt_Clear,bt_Search;
    private ProgressBar pb_login;
    private AppCompatTextView tv_Info;
    private UserLoginPresenter userLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        initEvents();

        userLoginPresenter = new UserLoginPresenter(this);
    }

    private void initEvents() {

        bt_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });

        bt_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });

        bt_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.search();
            }
        });
    }

    private void initView() {
        et_UserName = (AppCompatEditText) findViewById(R.id.username);
        et_Password = (AppCompatEditText) findViewById(R.id.password);

        bt_Login = (Button) findViewById(R.id.login);
        bt_Clear = (Button) findViewById(R.id.clear);
        bt_Search = (Button) findViewById(R.id.search);

        tv_Info = (AppCompatTextView) findViewById(R.id.info);

        pb_login = (ProgressBar) findViewById(R.id.login_progress);
    }

    @Override
    public String getUserName() {
        return et_UserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_Password.getText().toString();
    }

    @Override
    public void showInfo(User user) {
        tv_Info.setText(user.toString());
    }

    @Override
    public void showSearchError() {
        Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        et_UserName.setText("");
    }

    @Override
    public void clearPassword() {
        et_Password.setText("");
    }

    @Override
    public void showLoading() {
        pb_login.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb_login.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
    }
}
