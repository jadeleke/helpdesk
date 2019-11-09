package co.obware.hashcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.obware.hashcode.MVP.RegisterType;
import co.obware.hashcode.R;
import co.obware.hashcode.api.ApiClient;
import co.obware.hashcode.api.ApiInterface;
import co.obware.hashcode.helpers.Validation;
import ir.alirezabdn.wp7progress.WP10ProgressBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText etFullName, etIndex, etEmail, etPassword, etConfirmPassword, etNumber;
    Button btnRegister;
    ApiInterface apiInterface;
    CheckBox cbFemale, cbMale;
    String checkBox;
    String strApiKey;
    WP10ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        toolbar = findViewById( R.id.tb_register );
        etFullName = findViewById( R.id.etFullName );
        etIndex = findViewById( R.id.etIndex );
        etEmail = findViewById( R.id.etEmail );
        etNumber = findViewById( R.id.etPhone );
        etConfirmPassword = findViewById( R.id.etCustomerConfirmPassword );
        etPassword = findViewById( R.id.etCustomerPassword );
        cbFemale = findViewById( R.id.cbFemale );
        cbMale = findViewById( R.id.cbMale );
        progressBar = findViewById( R.id.register_progressBar );

        setSupportActionBar( toolbar );
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle( "Sign Up" );
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
        }
        cbMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    checkBox="Male";
                    cbFemale.setChecked( false );
            }
        });

        cbFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    checkBox="Female";
                    cbMale.setChecked( false );
            }
        });
    }

    public void btnCustomer(View view) {
        progressBar.showProgressBar();
        final String strFullName = etFullName.getText().toString();
        final String strIndex = etIndex.getText().toString();
        final String strEmail = etEmail.getText().toString();
        final String strConfirmPassword = etConfirmPassword.getText().toString();
        final String strPassword = etPassword.getText().toString();
        final String strNumber = etNumber.getText().toString();
        final String strGender = checkBox;

        if (strIndex.isEmpty() && strFullName.isEmpty() && strEmail.isEmpty() && strConfirmPassword.isEmpty() && strPassword.isEmpty()) {
            Toast.makeText( this, "Fields cannot be empty", Toast.LENGTH_SHORT ).show();
        } else if (Validation.nameValidation( strFullName )) {
            Toast.makeText( this, "Enter your full name", Toast.LENGTH_SHORT ).show();
        } else if (Validation.IndexValidation( strIndex )) {
            Toast.makeText( this, "Username starts with a capital letter and maximum length is 10", Toast.LENGTH_SHORT ).show();
        } else if (Validation.numberValidation( strNumber )) {
            Toast.makeText( this, "Telephone number cannot be empty", Toast.LENGTH_SHORT ).show();
        } else if (Validation.emailValidation( strEmail )) {
            Toast.makeText( this, "Enter your valid email", Toast.LENGTH_SHORT ).show();
        } else if (Validation.passwordValidation( strPassword )) {
            Toast.makeText( this, R.string.password_error, Toast.LENGTH_SHORT ).show();
        } else if (!strConfirmPassword.equals( strPassword )) {
            etConfirmPassword.setError( "Passwords do not match" );
        }
        else if (checkBox==null) {
            Toast.makeText( this, "Gender CheckBox cannot be unchecked", Toast.LENGTH_SHORT ).show();
        }
        else {
            Customer( strFullName, strIndex, strNumber, strEmail, strPassword, strGender );
        }
    }

    private void Customer(final String strFullName, final String strIndex, final String strNumber, final String strEmail, final String strPassword, final String strGender) {
        apiInterface = ApiClient.getApiClient().create( ApiInterface.class );
        Call<RegisterType> call = apiInterface.getRegister( strFullName, strIndex, strNumber, strEmail, strPassword, strGender );

        call.enqueue( new Callback<RegisterType>() {
            @SuppressWarnings("NullableProblems")
            @Override
            public void onResponse(Call<RegisterType> call, Response<RegisterType> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getStatus();
                    strApiKey = response.body().getApikey();

                    if (success) {
                        SharedPreferences sharedPreferences = getSharedPreferences( "user_data", MODE_PRIVATE );
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean( "loggedIn", true );
                        editor.putString( "index", strIndex );
                        editor.putString( "password", strPassword );
                        editor.putString( "email", strEmail );
                        editor.putString( "username", strFullName );
                        editor.putString( "gender", strGender );
                        editor.putString( "telephone",  strNumber);
                        editor.putString( "api_key", strApiKey );
                        editor.apply();
                        start();

                        progressBar.hideProgressBar();
                    } else {
                        failure();
                    }
                }
            }

            @SuppressWarnings("NullableProblems")
            @Override
            public void onFailure(Call<RegisterType> call, Throwable t) {
                Toast.makeText( RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT ).show();
                progressBar.hideProgressBar();
            }
        } );
    }

    private void failure() {
        Toast.makeText( this, R.string.check_connection, Toast.LENGTH_SHORT ).show();
    }

    private void start() {
        Intent intent = new Intent( this, DashBoardActivity.class );
        startActivity( intent );
        finish();
    }

}
