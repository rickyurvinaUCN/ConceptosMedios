package com.example.conceptosmedios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conceptosmedios.databinding.FragmentTableLayoutBinding;

public class TableLayoutFragment extends Fragment {

    private FragmentTableLayoutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTableLayoutBinding.inflate(inflater, container, false);
        binding.btnToFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TableLayoutFragment.this)
                        .navigate(R.id.action_tableLayoutFragment_to_frameLayoutFragment);
            }
        });
        return binding.getRoot();
    }
}