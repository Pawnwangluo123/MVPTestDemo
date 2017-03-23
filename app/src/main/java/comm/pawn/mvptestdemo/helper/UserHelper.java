package comm.pawn.mvptestdemo.helper;

import comm.pawn.mvptestdemo.bean.User;

/**
 * 模仿正式登陆环境
 * Created by vcube on 2017/3/23.
 */

public class UserHelper implements LoginHelper {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作；
        new Thread() {
            @Override
            public void run() {
                super.run();

                try {

                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("wang".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else
                    loginListener.loginError();
            }
        }.start();
    }
}
