package comm.pawn.mvptestdemo.biz;

import comm.pawn.mvptestdemo.bean.User;

/**
 * 监听是否成功同时是否返回值
 * Created by vcube on 2017/3/23.
 */

public interface OnLoginListener {

    void loginSuccess(User user);
    void loginError();
}
