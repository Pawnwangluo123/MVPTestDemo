package comm.pawn.mvptestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import comm.pawn.mvptestdemo.bean.User;
import comm.pawn.mvptestdemo.presenter.UserLoginPresenter;
import comm.pawn.mvptestdemo.view.UserLoginView;

/**
 * 这个activity就相当于是view的实现类，，在MVP中View其实就是Activity
 */
public class MainActivity extends AppCompatActivity implements UserLoginView {


    private EditText user_name_id;
    private EditText user_password_id;
    private Button btn_login;
    private Button clear_id;

    private ProgressBar PB_id;


    private UserLoginPresenter userLoginpresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        user_name_id = (EditText) findViewById(R.id.user_name_id);
        user_password_id = (EditText) findViewById(R.id.user_password_id);


        btn_login = (Button) findViewById(R.id.btn_login);
        clear_id = (Button) findViewById(R.id.clear_id);

        PB_id = (ProgressBar) findViewById(R.id.PB_id);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userLoginpresenter.login();
            }
        });

        clear_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginpresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return user_name_id.getText().toString();
    }

    @Override
    public String getPassWord() {
        return user_password_id.getText().toString();
    }

    @Override
    public void clearUserName() {
        user_name_id.setText("");
    }

    @Override
    public void clearPassword() {
        user_password_id.setText("");
    }

    @Override
    public void showLoading() {
        PB_id.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        PB_id.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
