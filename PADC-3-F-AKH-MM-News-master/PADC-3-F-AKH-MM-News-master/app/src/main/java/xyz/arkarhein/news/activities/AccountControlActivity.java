package xyz.arkarhein.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import xyz.arkarhein.news.R;
import xyz.arkarhein.news.fragments.LoginFragment;
import xyz.arkarhein.news.fragments.RegisterFragment;
/**
 * Created by Acer on 1/20/2018.
 */

public class AccountControlActivity extends AppCompatActivity {
    private static final String IE_SCREEN_TYPE ="IE_SCREEN_TYPE";
    private static final int SCREEN_TYPE_LOGIN =1;
    private static final int SCREEN_TYPE_REGISTER =2;


    public static Intent newIntentLogin(Context context){
        Intent intent = new Intent(context,AccountControlActivity.class);
        intent.putExtra(IE_SCREEN_TYPE,SCREEN_TYPE_LOGIN);
        return intent;
    }
    public static Intent newIntentRegister(Context context){
        Intent intent = new Intent(context,AccountControlActivity.class);
        intent.putExtra(IE_SCREEN_TYPE,SCREEN_TYPE_REGISTER);
        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_account_control);

        int screenType = getIntent().getIntExtra(IE_SCREEN_TYPE,-1);
        if (screenType == SCREEN_TYPE_LOGIN){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container,new LoginFragment()).commit();
        }
        else if (screenType == SCREEN_TYPE_REGISTER){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container,new RegisterFragment()).commit();

        }



    }


}
