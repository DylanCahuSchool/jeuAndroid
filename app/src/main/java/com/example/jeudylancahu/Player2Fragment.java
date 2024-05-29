package com.example.jeudylancahu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jeudylancahu.model.Player;


public class Player2Fragment extends Fragment {
    private int level;
    private EditText playerName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_player2, container, false);

        playerName = view.findViewById(R.id.player_name);

        Button button = view.findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name = playerName.getText().toString();
                if (!name.isEmpty()) {
                    Player player = new Player();
                    player.Name = name;
                    player.Level = level;
                    ((MainActivity)getActivity()).player2 = player;
                }
            }
        });

        return view;
    }

    public void radioButtonhandler(View view){
        boolean checked = ((RadioButton) view).isChecked();

        if (checked) {
            if (view.getId() == R.id.level_easy) {
                level = 1;
            } else if (view.getId() == R.id.level_medium) {
                level = 2;
            } else if (view.getId() == R.id.level_hard) {
                level = 3;
            }
        }
    }
}