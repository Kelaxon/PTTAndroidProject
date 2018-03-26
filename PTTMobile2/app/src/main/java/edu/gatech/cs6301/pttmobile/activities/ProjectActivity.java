package edu.gatech.cs6301.pttmobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import edu.gatech.cs6301.pttmobile.Data.ProjectData;
import edu.gatech.cs6301.pttmobile.R;

public class ProjectActivity extends AppCompatActivity {
    ImageView mProjAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        mProjAddButton = findViewById(R.id.proj_add_button);

        mProjAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProjectActivity.this, CreateProjectActivity.class));
                finish();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.project_recycler_view);
        ProjectListAdapter projectListAdapter = new ProjectListAdapter();
        projectListAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(projectListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}
