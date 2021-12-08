package com.examapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {
    private List<Information>informationList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView content;
        View box;
        public ViewHolder(View view){
            super(view);
            box=view;
            title=view.findViewById(R.id.title_text);
            content=view.findViewById(R.id.content);
        }
    }
    public InformationAdapter(List<Information>minformationList){
        informationList=minformationList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.information_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);

      /*  holder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Information information=informationList.get(position);
                Intent intent=new Intent(context,DetailActivity1.class);
                context.startActivity(intent);
            }
        });*/
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull InformationAdapter.ViewHolder holder, int position) {
        Information information=informationList.get(position);
        holder.title.setText(information.getTitle());
        holder.content.setText(information.getContent());
        Context context=holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(context,DetailActivity1.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(context,DetailActivity2.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent1);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }
}
