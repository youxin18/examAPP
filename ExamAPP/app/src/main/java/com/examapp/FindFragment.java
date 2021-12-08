package com.examapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FindFragment extends Fragment {
    private final List<Information>informationList;
    public  FindFragment(List<Information>informationList){
        this.informationList=informationList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.find_fragment,container,false);
      RecyclerView recyclerView=view.findViewById(R.id.recyclerview2);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        InformationAdapter adapter=new InformationAdapter(informationList);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
