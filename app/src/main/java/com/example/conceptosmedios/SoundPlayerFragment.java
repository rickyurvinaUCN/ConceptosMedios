package com.example.conceptosmedios;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.conceptosmedios.databinding.FragmentSoundPlayerBinding;


public class SoundPlayerFragment extends Fragment {

    private FragmentSoundPlayerBinding binding;

    Button play;
    SoundPool sp;
    int sound;
    boolean loaded;
    int soundId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSoundPlayerBinding.inflate(inflater, container, false);

        binding.btnSoundLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        binding.btnShortSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return binding.getRoot();
    }

}