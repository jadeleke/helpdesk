package co.obware.hashcode.activity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.obware.hashcode.MVP.NoticeType;
import co.obware.hashcode.R;
import co.obware.hashcode.adapter.NoticeAdapter;
import ir.alirezabdn.wp7progress.WP10ProgressBar;

public class EnoticeActivity extends AppCompatActivity
        //implements NoticeView
{

    Toolbar toolbar;
    RecyclerView recyclerview;
    private List<NoticeType> locatorTypeList;
    NoticeAdapter requestAdapter;
    WP10ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_enotice );
        toolbar = findViewById( R.id.tb_enotice );
        progressBar = findViewById( R.id.notice_progressBar );
        recyclerview  = findViewById( R.id.rv_enotice );

        progressBar.showProgressBar();
        setSupportActionBar( toolbar );
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle( "E-Notice" );
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
        }


//        recyclerview.setLayoutManager( new LinearLayoutManager( this ) );
        requestAdapter = new NoticeAdapter(locatorTypeList );
        recyclerview.setHasFixedSize( true );
        recyclerview.setAdapter(requestAdapter);
        recyclerview = findViewById( R.id.rv_enotice );

        locatorTypeList = new ArrayList<>(  );
        locatorTypeList.add( new NoticeType( R.drawable.logo, "", "The Quick brown jumped over the lazy dogs", "2019 August 2019" ) );
        locatorTypeList.add( new NoticeType( R.drawable.logo, "", "The Quick brown jumped over the lazy dogs", "2019 August 2019" ) );
        locatorTypeList.add( new NoticeType( R.drawable.logo, "", "The Quick brown jumped over the lazy dogs", "2019 August 2019" ) );
        locatorTypeList.add( new NoticeType( R.drawable.logo, "", "The Quick brown jumped over the lazy dogs", "2019 August 2019" ) );

    }

//    @Override
//    public void showLoading() {
//        progressBar.showProgressBar();
//    }
//
//    @Override
//    public void hideLoading() {
//        progressBar.hideProgressBar();
//    }
//
//    @Override
//    public void onGetResult(List<NoticeType> list) {
//        requestAdapter = new NoticeAdapter( this, list );
//        requestAdapter.notifyDataSetChanged();
//        recyclerview.setAdapter( requestAdapter );
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
