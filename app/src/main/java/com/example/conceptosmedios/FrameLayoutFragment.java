package com.example.conceptosmedios;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.conceptosmedios.databinding.FragmentFrameLayoutBinding;

public class FrameLayoutFragment extends Fragment {

    private FragmentFrameLayoutBinding binding;
    private ImageView img_v1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFrameLayoutBinding.inflate(inflater, container, false);
        img_v1 = (ImageView) binding.imgV1;
        binding.btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide();
            }
        });
        return binding.getRoot();
    }

    public void hide() {
        binding.btnHide.setVisibility(View.INVISIBLE);
        img_v1.setVisibility(View.VISIBLE);
    }
}