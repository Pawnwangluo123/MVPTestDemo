package comm.pawn.mvptestdemo.presenter;


import android.os.Handler;

import comm.pawn.mvptestdemo.bean.User;
import comm.pawn.mvptestdemo.biz.IUserBiz;
import comm.pawn.mvptestdemo.biz.OnLoginListener;
import comm.pawn.mvptestdemo.biz.UserBiz;
import comm.pawn.mvptestdemo.view.IUserLoginView;

/**
 * Created by vcube on 2017/3/23.
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;

    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
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
