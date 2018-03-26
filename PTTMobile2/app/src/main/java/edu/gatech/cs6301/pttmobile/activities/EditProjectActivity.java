package edu.gatech.cs6301.pttmobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs6301.pttmobile.Data.ProjectData;
import edu.gatech.cs6301.pttmobile.R;

public class EditProjectActivity extends AppCompatActivity {

    TextView mOldProjNameView;
    AutoCompleteTextView mProjNameView;
    Button mSaveButton;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);

        Bundle bundle = this.getIntent().getExtras();

        position = bundle.getInt("Name");

        String old_proj_name = ProjectData.projectNames.get(position);


        mOldProjNameView = findViewById(R.id.old_proj_name_view);
        mOldProjNameView.setText(old_proj_name);
        mProjNameView = findViewById(R.id.proj_name_edit);
        mSaveButton = findViewById(R.id.proj_name_edit_button);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proj_name = "";
                proj_name = mProjNameView.getText().toString();
                EditProject(position, proj_name);
                startActivity(new Intent(EditProjectActivity.this, ProjectActivity.class));
                finish();
            }
        });


    }

    private void EditProject(int position, String proj_name){
        ProjectData.editProjects(position, proj_name);
    }
}
