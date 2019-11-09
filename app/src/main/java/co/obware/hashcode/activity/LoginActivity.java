package co.obware.hashcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.obware.hashcode.MVP.LoginType;
import co.obware.hashcode.R;
import co.obware.hashcode.api.ApiClient;
import co.obware.hashcode.api.ApiInterface;
import co.obware.hashcode.helpers.Validation;
import ir.alirezabdn.wp7progress.WP10ProgressBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etIndex, etPassword;
    TextView signUpTv;
    ApiInterface apiInterface;
    WP10ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        Toolbar toolbar = findViewById( R.id.login_action_bar );
        setSupportActionBar( toolbar );
        progressBar = findViewById( R.id.ir_progressBar );
        progressBar.setIndicatorRadius( 5 );

        setSupportActionBar( toolbar );
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle( "Login" );
        }
        etIndex = findViewById( R.id.index_et );
        etPassword = findViewById( R.id.password_et );
    }

    public void Login(View view) {
        String strIndex = etIndex.getText().toString();
        String strPassword = etPassword.getText().toString();

        if (strIndex.isEmpty() && strPassword.isEmpty()) {
            Toast.makeText( this, "Enter your username and password", Toast.LENGTH_SHORT ).show();
        } else if (Validation.IndexValidation( strIndex )) {
            Toast.makeText( this, "Enter your username", Toast.LENGTH_SHORT ).show();
        } else if (Validation.passwordValidation( strPassword )) {
            Toast.makeText( this, "Enter your Password", Toast.LENGTH_SHORT ).show();
        } else {
            Save( strPassword, strIndex );
        }
    }

    private void Save(final String strPassword, final String strIndex) {
        apiInterface = ApiClient.getApiClient().create( ApiInterface.class );

        Call<LoginType> call = apiInterface.getLoginType( strIndex, strPassword );
        call.enqueue( new Callback<LoginType>() {

            @Override
            public void onResponse(@NonNull Call<LoginType> call, @NonNull Response<LoginType> response) {

                progressBar.hideProgressBar();

                if (response.isSuccessful() && response.body() != null) {
                    String success = response.body().getSuccess();
                    String gender = response.body().getGender();
                    String phone = response.body().getPhone();
                    String email = response.body().getEmail();
                    String key = response.body().getKey();
                    String name = response.body().getName();

                    if (success == "Active") {
                        SharedPreferences mPreferences = getSharedPreferences( "user_data", MODE_PRIVATE );
                        SharedPreferences.Editor mEditor = mPreferences.edit();
                        mEditor.putBoolean( "loggedIn", true );
                        mEditor.putString( "index number", strIndex );
                        mEditor.putString( "password", strPassword );
                        mEditor.putString( "email", email );
                        mEditor.putString( "username", name );
                        mEditor.putString( "gender", gender );
                        mEditor.putString( "key", key );
                        mEditor.putString( "telephone", phone );

                        mEditor.apply();
                        startPage();
                    } else if (success.equals( "true" )) {
                        SharedPreferences mPreferences = getSharedPreferences( "user_data", MODE_PRIVATE );
                        SharedPreferences.Editor mEditor = mPreferences.edit();
                        mEditor.putBoolean( "loggedIn", true );
                        mEditor.putString( "index number", strIndex );
                        mEditor.putString( "password", strPassword );
                        mEditor.putString( "email", email );
                        mEditor.putString( "username", name );
                        mEditor.putString( "gender", gender );
                        mEditor.putString( "key", key );
                        mEditor.putString( "telephone", phone );

                        mEditor.apply();
                        startPage();
                    } else {
                        failure();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginType> call, @NonNull Throwable t) {
                progressBar.setVisibility( View.GONE );
                progressBar.hideProgressBar();
                failureToast();
            }
        } );
    }

    private void failure() {
        Toast.makeText( this, R.string.error_credentials, Toast.LENGTH_SHORT ).show();
    }

    private void failureToast() {
        Toast.makeText( this, R.string.check_connection, Toast.LENGTH_SHORT ).show();
    }

    private void startPage() {
        Intent intent = new Intent( this, DashBoardActivity.class );
        startActivity( intent );
        finish();
    }

    public void Register(View view) {
        Intent intent = new Intent( this, RegisterActivity.class );
        startActivity( intent );
    }


}

