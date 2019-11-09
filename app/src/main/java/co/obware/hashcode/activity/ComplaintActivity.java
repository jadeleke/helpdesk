package co.obware.hashcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import co.obware.hashcode.MVP.CategoryType;
import co.obware.hashcode.MVP.ComplaintType;
import co.obware.hashcode.R;
import co.obware.hashcode.api.ApiClient;
import co.obware.hashcode.api.ApiInterface;
import ir.alirezabdn.wp7progress.WP10ProgressBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplaintActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public ArrayList<CategoryType> goodModelArrayList;
    WP10ProgressBar progressBar;
    Spinner spinner;
    EditText etComplaint;
    String[] country = {"FACULTY Of Engineering", "Exams and Records"};
    Toolbar toolbar;
    ApiInterface apiInterface;
    String strSpinner;
    private ArrayList<String> playerNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_complaint );
        spinner = findViewById( R.id.spinner );
        etComplaint = findViewById( R.id.et_complaint );
        progressBar = findViewById( R.id.ir_progressBarComplaint );
        toolbar = findViewById( R.id.tb_complaint );
        spinner.setOnItemSelectedListener( this );

        setSupportActionBar( toolbar );
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
            getSupportActionBar().setTitle( "Complaint" );
        }
        ArrayAdapter<String> aa = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, country );
        aa.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinner.setAdapter( aa );
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
        strSpinner = country[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void btnComplaint(View view) {
        String index;

        SharedPreferences preferences = this.getSharedPreferences( "user_data", MODE_PRIVATE );
        final String DEFAULT_VALUE = "No Index";
        index = preferences.getString( "index", DEFAULT_VALUE );
        String strComplaint = etComplaint.getText().toString();
        String StrSpinner;
        StrSpinner = "1";

        if (strComplaint.isEmpty()) {
            Toast.makeText( this, "Compliant field cannot be empty", Toast.LENGTH_SHORT ).show();
        } else {
            Save( strComplaint, strSpinner, index );
        }

    }

    private void Save(final String strComplaint, final String strSpinner, final String index) {

        apiInterface = ApiClient.getApiClient().create( ApiInterface.class );
        Call<ComplaintType> call = apiInterface.getComplaint( index, strSpinner, strComplaint );
        progressBar.showProgressBar();

        call.enqueue( new Callback<ComplaintType>() {

            @Override
            public void onResponse(@NonNull retrofit2.Call<ComplaintType> call, @NonNull Response<ComplaintType> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();

                    if (success) {
                        startPage();
                        progressBar.hideProgressBar();
                    } else {
                        failure();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<ComplaintType> call, @NonNull Throwable t) {
                failureToast();
                progressBar.showProgressBar();
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
}
