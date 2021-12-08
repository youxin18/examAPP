package com.examapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RealQuestionAdapter extends RecyclerView.Adapter<RealQuestionAdapter.ViewHolder> {
    private List<RealQuestion>realQuestionList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        View box;
        public ViewHolder(View view){
            super(view);
            box=view;
          title=view.findViewById(R.id.real_question_title);
        }
    }
    public RealQuestionAdapter(List<RealQuestion>realQuestions){
        realQuestionList=realQuestions;

    }
    @NonNull
    @Override
    public RealQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.real_question_item,parent,false);
      final ViewHolder holder=new ViewHolder(view);
        Context context=view.getContext();
        holder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                RealQuestion realQuestion=realQuestionList.get(position);

            }
        });
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RealQuestionAdapter.ViewHolder holder, int position) {
        RealQuestion title=realQuestionList.get(position);
        holder.title.setText(title.getTitle());

    }

    @Override
    public int getItemCount() {
        return realQuestionList.size();
    }
}
