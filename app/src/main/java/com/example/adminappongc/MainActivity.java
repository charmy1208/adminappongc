package com.example.adminappongc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.adminappongc.notice.DeleteNoticeActivity;
import com.example.adminappongc.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice,addpdf,addGalleryImage,deleteNotice,logout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.getString("isLogin", "false").equals("false")){
            openLogin();
        }

        uploadNotice=findViewById(R.id.addNotice);
        addpdf=findViewById(R.id.addpdf);
        addGalleryImage=findViewById(R.id.addGalleryImage);
        deleteNotice=findViewById(R.id.deleteNotice);

        logout=findViewById(R.id.logout);



        uploadNotice.setOnClickListener(this);
        addpdf.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        logout.setOnClickListener(this);
    }


    private void openLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.addNotice:
                Intent intent= new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addpdf:
                Intent intent1= new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(intent1);
                break;
            case R.id.addGalleryImage:
                Intent intent2= new Intent(MainActivity.this,UploadImage.class);
                startActivity(intent2);
                break;
            case R.id.deleteNotice:
                Intent intent3= new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent3);
                break;
            case R.id.logout:
                editor.putString("isLogin", "false");
                editor.commit();

                openLogin();
                break;



        }

    }
}