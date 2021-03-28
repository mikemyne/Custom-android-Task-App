package com.e.mynepyne;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {





    // RECYCLER VIEW CODE

    RecyclerView recyclerView;
    ArrayList<datamodel> dataholder;



    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }









    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {





//RECYCLER VIEW CODE
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        recyclerView = view.findViewById(R.id.rvProgram);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder = new ArrayList<>();

        datamodel ob1 = new datamodel(R.drawable.account,  "Account", "Privacy, Security, Change email" );
        dataholder.add(ob1);

        datamodel ob2 = new datamodel(R.drawable.task,  "Tasks", "Task history" );
        dataholder.add(ob2);

        datamodel ob3 = new datamodel(R.drawable.calendar,  "Calendar-settings", "Calendar Format, Expiry" );
        dataholder.add(ob3);

        datamodel ob4 = new datamodel(R.drawable.cycle,  "Storage data", "Network Usage, auto-download" );
        dataholder.add(ob4);

        datamodel ob5 = new datamodel(R.drawable.theme,  "Theme", "Dark, Light" );
        dataholder.add(ob5);

        datamodel ob6 = new datamodel(R.drawable.help,  "Help", "Help center, contact us, privacy policy" );
        dataholder.add(ob6);

        datamodel ob7 = new datamodel(R.drawable.invite,  "Invite a friend", "Share app link" );
        dataholder.add(ob7);

        datamodel ob8 = new datamodel(R.drawable.money,  "Financial Support", "Donate to us" );
        dataholder.add(ob8);

        datamodel ob9 = new datamodel(R.drawable.ad,  "Ads", "Remove ads" );
        dataholder.add(ob9);

        datamodel ob10 = new datamodel(R.drawable.black, " ", " ");
        dataholder.add(ob10);

        recyclerView.setAdapter(new AppAdapter(dataholder));

        return view;






    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

}