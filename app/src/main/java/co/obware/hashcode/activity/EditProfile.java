package co.obware.hashcode.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;

import co.obware.hashcode.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class EditProfile extends AppCompatActivity implements View.OnClickListener {
    CircleImageView profileImage;
    TextView usernameTv, emailTv, passwordTv, phoneTv, indexTv;
    FloatingActionButton changeImage;
    CardView usernameCard, emailCard, passwordCard, telephoneCard;
    private Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.edit_profile );

        Toolbar toolbar = findViewById( R.id.edit_toolbar );
        setSupportActionBar( toolbar );
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayShowHomeEnabled(  true);
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setTitle( "Edit Profile" );
        }
        profileImage = findViewById(R.id.profile_image);

         indexTv = findViewById(R.id.tv_index);
        usernameTv = findViewById(R.id.tv_username);
        emailTv = findViewById(R.id.tv_email);
        passwordTv = findViewById(R.id.tv_password);
        phoneTv = findViewById(R.id.tv_phone);

        usernameCard = findViewById(R.id.user_card_view);
        emailCard = findViewById(R.id.email_card_view);
        passwordCard = findViewById(R.id.password_card_view);
        telephoneCard = findViewById(R.id.phone_card_view);

        usernameCard.setOnClickListener(this);
        passwordCard.setOnClickListener(this);
        emailCard.setOnClickListener(this);
        telephoneCard.setOnClickListener(this);

        SharedPreferences preferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
        final String DEFAULT_VALUE = "N/A";

        usernameTv.setText(preferences.getString("username", DEFAULT_VALUE));

        passwordTv.setText(preferences.getString("gender", DEFAULT_VALUE));
        emailTv.setText(preferences.getString("email", DEFAULT_VALUE));
//        usernameTv.setText(preferences.getString("index number", DEFAULT_VALUE));
        phoneTv.setText(preferences.getString("telephone", DEFAULT_VALUE));
        indexTv.setText(preferences.getString("index", DEFAULT_VALUE));

        this.getIntent().getParcelableExtra("bitmap");
        try {
            bitmap = BitmapFactory.decodeStream(this.openFileInput("profile_image"));
            profileImage.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onResume() {
        this.getIntent().getParcelableExtra("bitmap");
        try {
            bitmap = BitmapFactory.decodeStream(this.openFileInput("profile_image"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        profileImage.setImageBitmap(bitmap);
        SharedPreferences results = this.getSharedPreferences("status",
                Context.MODE_PRIVATE);
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.user_card_view:
                Toast.makeText(this, "Username Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.email_card_view:
                Toast.makeText(this, "Email Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.password_card_view:
                Toast.makeText(this, "Password Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.phone_card_view:
                Toast.makeText(this, "Telephone Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
