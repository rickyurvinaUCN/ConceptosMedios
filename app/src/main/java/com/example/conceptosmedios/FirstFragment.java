package com.example.conceptosmedios;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.conceptosmedios.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private EditText txt_email, txt_name, txt_info;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_email = (EditText) binding.txtEmail;
        txt_name = (EditText) binding.txtName;
        txt_info = (EditText) binding.txtInfo;

        SharedPreferences pref = getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String email = pref.getString("email", "empty");
        txt_email.setText(email);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        binding.btnSaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInfo();
            }
        });
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
    }

    public void save() {
        SharedPreferences pref = getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor edt = pref.edit();
        edt.putString("email", txt_email.getText().toString());
        edt.commit();
        getActivity().finish();
    }

    public void saveInfo() {
        String name = txt_name.getText().toString();
        String info = txt_info.getText().toString();
        SharedPreferences preferences = getActivity().getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(name, info);
        obj_editor.commit();
        Toast.makeText(this.getActivity(), "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
    }

    public void search() {
        String name = txt_name.getText().toString();
        SharedPreferences preferences = getActivity().getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String info = preferences.getString(name, "");

        if (info.length() == 0) {
            Toast.makeText(getActivity(), "No se encontro ningun registro", Toast.LENGTH_LONG).show();
        } else {
            txt_info.setText(info);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}