package comm.pawn.mvptestdemo.presenter;


import android.os.Handler;

import comm.pawn.mvptestdemo.bean.User;
import comm.pawn.mvptestdemo.helper.LoginHelper;
import comm.pawn.mvptestdemo.helper.OnLoginListener;
import comm.pawn.mvptestdemo.helper.UserHelper;
import comm.pawn.mvptestdemo.view.UserLoginView;

/**
 * Created by vcube on 2017/3/23.
 */

public class UserLoginPresenter {

    private LoginHelper userBiz;
    private UserLoginView userLoginView;

    private Handler handler = new Handler();

    public UserLoginPresenter(UserLoginView userLoginView){
        this.userLoginView = userLoginView;
        this.userBiz = new UserHelper();
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行的
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginError() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

}
