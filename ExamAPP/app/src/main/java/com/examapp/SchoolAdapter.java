package com.examapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {
    private List<schoolName>schoolNameList;
   static class ViewHolder extends RecyclerView.ViewHolder{
       TextView name;
       public ViewHolder(View view){
           super(view);
           name=view.findViewById(R.id.school_name);
       }
    }
    public SchoolAdapter(List<schoolName>schoolNames){
       schoolNameList=schoolNames;
    }
    @NonNull
    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.school_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.ViewHolder holder, int position) {
       schoolName schoolName=schoolNameList.get(position);
       holder.name.setText(schoolName.getName());

    }

    @Override
    public int getItemCount() {
        return schoolNameList.size();
    }
}
