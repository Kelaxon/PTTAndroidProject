package edu.gatech.cs6301.pttmobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.cs6301.pttmobile.Data.ProjectData;
import edu.gatech.cs6301.pttmobile.R;

public class CreateProjectActivity extends AppCompatActivity {
    AutoCompleteTextView mProjNameView;
    Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        mProjNameView = findViewById(R.id.proj_name_add);
        mSaveButton = findViewById(R.id.proj_name_add_button);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proj_name = "";
                proj_name = mProjNameView.getText().toString();
                addProject(proj_name);
                startActivity(new Intent(CreateProjectActivity.this, ProjectActivity.class));
                finish();
            }
        });
    }

    //
    private void addProject(String proj_name){
        ProjectData.addProjects(proj_name);
    }
}
