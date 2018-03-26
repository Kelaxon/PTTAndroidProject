package edu.gatech.cs6301.pttmobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs6301.pttmobile.R;

public class MainActivity extends AppCompatActivity {

    Button mShowListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowListButton = findViewById(R.id.show_proj_list_button);
        mShowListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProjectActivity.class));
                finish();
            }
        });
    }
}
