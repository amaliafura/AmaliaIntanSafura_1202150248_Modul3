package com.example.android.amaliaintansafura_1202150248_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private ImageView level;
    private String txtIndicator;
    private TextView levelIndicator;
    private int minimalLevel = 0;
    private int currentLevel = 0;
    private int maksimalLevel = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent intent = getIntent();
        TextView title = (TextView) findViewById(R.id.titleDetail);
        levelIndicator = (TextView) findViewById(R.id.mineralIndicator);
        String iTitle = intent.getStringExtra("title");
        title.setText(iTitle);

        level = (ImageView) findViewById(R.id.mineralLevel);
        Log.d("level ", "level: "+txtIndicator);
    }


    public void tambahLevel(View view) { //method untuk proses penambahan air pada botol berdasarkan level
        currentLevel+=1;
        if (currentLevel<=maksimalLevel){
            level.setImageLevel(currentLevel+=1);
            levelIndicator.setText(currentLevel+"L");

            if (currentLevel==maksimalLevel){
                //agar muncul toast di saat air sudah penuh/full
                Toast.makeText(this, "Air telah full", Toast.LENGTH_SHORT).show();
            }
            Log.d("current level", "Current Level: "+currentLevel);
        }else{
            currentLevel=maksimalLevel;
            txtIndicator=currentLevel+"L";
        }
    }

    public void kurangiLevel(View view) { //method untuk proses pengurangan pada gambar botol
        currentLevel-=1;
        if (currentLevel>=minimalLevel){
            level.setImageLevel(currentLevel-=1);
            levelIndicator.setText(currentLevel+"L");

            //if untuk menampilkan toast jika air di botol sudah dibatas minimum level
            if  (currentLevel==minimalLevel){
                Toast.makeText(this, "Air sedikit", Toast.LENGTH_SHORT).show();

            }

        }else{ //else untuk proses agar saat penguranagn tidak melebihin batas minimum level air pada botol
            currentLevel=minimalLevel;
            txtIndicator=currentLevel+"L";;

        }
    }
}
