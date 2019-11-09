package co.obware.hashcode.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.obware.hashcode.R;

public class ForgetActivity extends AppCompatActivity {

    EditText etEmail;
    Button btnForget;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_forget );

        etEmail = findViewById( R.id.et_forget );
        toolbar = findViewById( R.id.tb_forget );
        btnForget = findViewById( R.id.btn_forget );

        setSupportActionBar( toolbar );
        if (toolbar != null) {
            getSupportActionBar().setTitle( R.string.forget_password );
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
        }
    }
}
