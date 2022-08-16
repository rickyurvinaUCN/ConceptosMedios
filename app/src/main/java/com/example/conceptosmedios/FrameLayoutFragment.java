package com.example.conceptosmedios;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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

        binding.imgSandia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgPina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgPera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgMelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgManzana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgMango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgFresas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgCerezas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });
        binding.imgBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(view);
            }
        });

        return binding.getRoot();
    }

    public void hide() {
        binding.btnHide.setVisibility(View.INVISIBLE);
        img_v1.setVisibility(View.VISIBLE);
    }

    public void selected(View view) {
        switch (view.getId()) {
            case R.id.img_banana:
                Toast.makeText(this.getActivity(), "Bananas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_cerezas:
                Toast.makeText(this.getActivity(), "Cerezas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_fresas:
                Toast.makeText(this.getActivity(), "Fresas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_mango:
                Toast.makeText(this.getActivity(), "Mango", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_manzana:
                Toast.makeText(this.getActivity(), "Manzana", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_melon:
                Toast.makeText(this.getActivity(), "Melon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_sandia:
                Toast.makeText(this.getActivity(), "Sandia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_pera:
                Toast.makeText(this.getActivity(), "Pera", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_pina:
                Toast.makeText(this.getActivity(), "Pina", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}