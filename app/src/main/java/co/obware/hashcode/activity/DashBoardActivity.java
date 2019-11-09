package co.obware.hashcode.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import co.obware.hashcode.R;

public class DashBoardActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );
        toolbar = findViewById( R.id.tb_dashboard );
        tvUsername = findViewById( R.id.tv_dash_username );

        setSupportActionBar( toolbar );
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle( "DashBoard" );
        }

        SharedPreferences preferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
        final String DEFAULT_VALUE = "N/A";

        tvUsername.setText(preferences.getString("username", DEFAULT_VALUE));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.edit_action_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.edit_profile_icons) {
            change_lab();
        }
        return true;
    }

    private void change_lab() {
        Intent intent = new Intent( DashBoardActivity.this, EditProfile.class );
        startActivity( intent );
    }

    public void CardComplaints(View view) {
        Intent intent = new Intent( this, ComplaintActivity.class );
        startActivity( intent );
    }

    public void CardView(View view) {
        Intent intent = new Intent( this, ViewComplaintActivity.class );
        startActivity( intent );
    }

    public void CardNotice(View view) {
        Intent intent = new Intent( this, EnoticeActivity.class );
        startActivity( intent );
    }

    public void CardSip(View view) {
        Intent intent = new Intent( this, SipActivity.class );
        startActivity( intent );
    }

    public void CardColt(View view) {
        Intent intent = new Intent( this, ColtActivity.class );
        startActivity( intent );
    }

    public void CardLibrary(View view) {
        Intent intent = new Intent( this, LibraryActivity.class );
        startActivity( intent );
    }

    public void fbSnack(View view) {
        Snackbar snackbar = Snackbar
                .make(view, "Currently Unavailable", Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
