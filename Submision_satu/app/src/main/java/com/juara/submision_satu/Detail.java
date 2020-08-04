package com.juara.submision_satu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Detail extends AppCompatActivity {

    private TextView txtNama, txtGaji, txtDetail;
    private ImageView img;

    Integer Image;
    String nama, gaji, detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img = findViewById(R.id.img);
        txtNama = findViewById(R.id.txtNama);
        txtGaji = findViewById(R.id.txtGaji);
        txtDetail = findViewById(R.id.txtDetail);

        Bundle bundle = getIntent().getExtras();
        Image = bundle.getInt("image");
        nama = bundle.getString("name");
        gaji = bundle.getString("gaji");
        detail = bundle.getString("detail");

        txtNama.setText(nama);
        txtGaji.setText(gaji);
        txtDetail.setText(detail);
        Glide.with(Detail.this)
                .load(Image)
                .apply(new RequestOptions().override(370,370))
                .into(img);
    }
}