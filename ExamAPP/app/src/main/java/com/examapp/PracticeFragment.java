package com.examapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PracticeFragment extends Fragment {
    private final List<RealQuestion>realQuestionList;
    public PracticeFragment(List<RealQuestion>realQuestionList){
        this.realQuestionList=realQuestionList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.practice_fragment,container,false);
      RecyclerView recyclerView=view.findViewById(R.id.real_question);
       LinearLayout math=view.findViewById(R.id.math);
        //RelativeLayout box1=view.findViewById(R.id.box1);
      // LinearLayout thought=view.findViewById(R.id.thought);
       // LinearLayout write=view.findViewById(R.id.write);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RealQuestionAdapter adapter=new RealQuestionAdapter(realQuestionList);
        recyclerView.setAdapter(adapter);
        Context context=view.getContext();

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MathActivity.class);
                startActivity(intent);

            }
        });
       /* box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,OneZeroActivity.class);
                startActivity(intent);
            }
        });*/
      /*  thought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ThoughtActivity.class);
                startActivity(intent);
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,WriteActivity.class);
                startActivity(intent);
            }
        });*/
        return view;
    }

}
