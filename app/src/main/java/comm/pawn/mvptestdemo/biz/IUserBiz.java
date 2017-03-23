package comm.pawn.mvptestdemo.biz;

/**
 * Created by vcube on 2017/3/23.
 */

public interface IUserBiz {

    public void login(String username,String password,OnLoginListener loginListener);

}
