package co.obware.hashcode.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.List;

import co.obware.hashcode.MVP.ViewComplaintType;
import co.obware.hashcode.R;
import co.obware.hashcode.adapter.ViewComplaintAdapter;
import ir.alirezabdn.wp7progress.WP10ProgressBar;

public class ViewComplaintActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    WP10ProgressBar progressBar;
    List<ViewComplaintType> locatorTypeList;
    ViewComplaintAdapter requestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_view_complaint );

        recyclerView = findViewById( R.id.rv_view_complaint );
        toolbar = findViewById( R.id.tb_V_complaint );
        progressBar = findViewById( R.id.progress_view_complaint );

        setSupportActionBar( toolbar );
        progressBar.showProgressBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle( "Reported Complaints" );
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
        }

    }

//    @Override
//    public void showLoading() {
//
//    }
//
//    @Override
//    public void hideLoading() {
//
//    }
//
//    @Override
//    public void onGetResult(List<ViewComplaintType> list) {
//        requestAdapter = new ViewComplaintAdapter( this, list );
//        requestAdapter.notifyDataSetChanged();
//        recyclerView.setAdapter( requestAdapter );
//        locatorTypeList = list;
//        progressBar.hideProgressBar();
//    }
//
//    @SuppressLint("Assert")
//    @Override
//    public void onErrorLoading(String message) {
//        Toast.makeText( this, "Error", Toast.LENGTH_SHORT ).show();
//        View view = null;
//        progressBar.hideProgressBar();
//        assert false;
//    }
}
