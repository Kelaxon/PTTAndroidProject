package edu.gatech.cs6301.pttmobile.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import edu.gatech.cs6301.pttmobile.Data.ProjectData;
import edu.gatech.cs6301.pttmobile.R;

/**
 * Created by Andi Xu on 3/23/18.
 */

public class ProjectListAdapter extends RecyclerView.Adapter{


    public boolean multiSelect = false;
    public ArrayList<Integer> selectedItems = new ArrayList<Integer>();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return ProjectData.projectNames.size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mText;
        private TextView mEdit;
        private TextView mDelete;

        private ActionMode.Callback actionModeCallbacks = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                multiSelect = true;
                menu.add("Delete");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if(selectedItems.size()> 0){
                    for(int i=selectedItems.size()-1;i>=0;i--){
                        String name = ProjectData.projectNames.get(selectedItems.get(i));
                        ProjectData.projectNames.remove(name);
                    }
                }

                actionMode.finish();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                multiSelect = false;
                selectedItems.clear();
                notifyDataSetChanged();
            }
        };


        public ListViewHolder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.itemText);
            mEdit = itemView.findViewById(R.id.itemEdit);
            mDelete = itemView.findViewById(R.id.itemDelete);
        }

        public void bindView(final int position){
            mText.setText(ProjectData.projectNames.get(position));
            mEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), EditProjectActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("Name", getAdapterPosition());

                    intent.putExtras(bundle);
                    view.getContext().startActivity(intent);
                }
            });

            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(multiSelect){
                        selectItem(position);
                    }else{
                        ProjectData.projectNames.remove(position);
                        notifyDataSetChanged();
                        notifyItemChanged(position);
                    }

                }
            });

            mDelete.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {
                    ((AppCompatActivity)view.getContext()).startSupportActionMode(actionModeCallbacks);

                    if(!multiSelect){
                        selectItem(position);
                        return true;
                    }else{
                        return false;
                    }

                }
            });



        }

        public void selectItem(Integer item) {
            if (multiSelect) {
                if (selectedItems.contains(item)) {
                    selectedItems.remove(item);
                    mText.setTextColor(Color.GRAY);
                } else {
                    selectedItems.add(item);
                    mText.setTextColor(Color.BLUE);
                }
            }
        }

        @Override
        public void onClick(View view) {

        }
    }
}
