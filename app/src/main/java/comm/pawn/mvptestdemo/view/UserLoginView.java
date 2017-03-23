package comm.pawn.mvptestdemo.view;

import comm.pawn.mvptestdemo.bean.User;

/**
 * view类
 * Created by vcube on 2017/3/23.
 */

public interface UserLoginView {

    String getUserName();

    String getPassWord();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
