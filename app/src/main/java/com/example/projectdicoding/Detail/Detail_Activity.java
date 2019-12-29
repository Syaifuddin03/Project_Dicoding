package com.example.projectdicoding.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectdicoding.R;

public class Detail_Activity extends AppCompatActivity {

    TextView tv_text, tv_desc, tv_rating, tv_lokasi;
    ImageView tv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);

        getSupportActionBar().setTitle("Deskripsi Wisata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_text = findViewById(R.id.get_judul);
        tv_desc = findViewById(R.id.get_desc);
        tv_image = findViewById(R.id.image_get);
        tv_rating = findViewById(R.id.get_rating);
        tv_lokasi = findViewById(R.id.get_lokasi);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String judul = extras.getString("nama_wisata");
        String desc = extras.getString("deskripsi_wisata");
        String rate = extras.getString("rating_wisata");
        String lok = extras.getString("lokasi_wisata");
        int image = extras.getInt("image_wisata");

        tv_text.setText(judul);
        tv_desc.setText(desc);
        tv_rating.setText(rate);
        tv_lokasi.setText(lok);
        tv_image.setImageResource(image);
    }

    public void Favorite(View view) {
        Toast.makeText(this, "Add Favorite Success", Toast.LENGTH_SHORT).show();
    }

    public void Share(View view) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Explore Pasuruan");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Explore Pasuruan");
        shareIntent.setType("text/plain");
        startActivity(shareIntent);
    }
}
