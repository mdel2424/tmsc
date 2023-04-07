package com.example.wiki;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import java.util.Random;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    private String[] dataArray;
    private Button button;
    private String randomElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.wikipedia);
        dataArray = getResources().getStringArray(R.array.data);
        setRandomElement();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomElement();
                String url = randomElement;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    private void setRandomElement() {
        Random random = new Random();
        int randomIndex = random.nextInt(dataArray.length);
        randomElement = dataArray[randomIndex];
    }
}
