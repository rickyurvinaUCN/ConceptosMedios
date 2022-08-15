package com.example.conceptosmedios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conceptosmedios.databinding.FragmentLinearLayoutBinding;

public class LinearLayoutFragment extends Fragment {

    private FragmentLinearLayoutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLinearLayoutBinding.inflate(inflater, container, false);
        binding.btnToTableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LinearLayoutFragment.this)
                        .navigate(R.id.action_linearLayoutFragment_to_tableLayoutFragment);
            }
        });

        return binding.getRoot();
    }
}