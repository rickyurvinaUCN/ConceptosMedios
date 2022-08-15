package com.example.conceptosmedios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conceptosmedios.databinding.FragmentTableLayoutBinding;

public class TableLayoutFragment extends Fragment {

    private FragmentTableLayoutBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTableLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}