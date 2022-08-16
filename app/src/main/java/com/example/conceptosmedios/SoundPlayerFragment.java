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

//        binding.btnShortSound.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                shortSound();
//            }
//        });

        binding.btnSoundLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                largeSound();
            }
        });

        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        sound = R.raw.sound_short;
        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                loaded = true;
            }
        });
        soundId = sp.load(getActivity(), sound, 1);

        binding.btnShortSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loaded) {
                    sp.play(soundId, 1, 1, 0, 0, 1);
                }
            }
        });
        return binding.getRoot();
    }

    public void shortSound() {

        sp.play(sound, 1, 1, 1, 0, 0);
    }

    public void largeSound() {
        MediaPlayer mp=  MediaPlayer.create(this.getActivity(),R.raw.sound_long);
        mp.start();
    }

}