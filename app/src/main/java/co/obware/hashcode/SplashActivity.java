package co.obware.hashcode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import co.obware.hashcode.activity.DashBoardActivity;
import co.obware.hashcode.activity.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private final static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences( "user_data",
                        MODE_PRIVATE );
                boolean status = sharedPreferences.getBoolean( "loggedIn", false );
                if (status) {
                    startActivity( new Intent( SplashActivity.this, DashBoardActivity.class ) );
                    finish();
                } else {
                    startActivity( new Intent( SplashActivity.this, LoginActivity.class ) );
                    finish();
                }
            }
        }, SPLASH_TIME_OUT );


    }


}

