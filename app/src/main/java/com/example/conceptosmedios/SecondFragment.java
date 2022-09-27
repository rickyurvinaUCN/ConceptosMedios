package com.example.conceptosmedios;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.conceptosmedios.databinding.FragmentSecondBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText txt_file;
    private String fileName = "bitacora.txt";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_file = (EditText) binding.txtFile;

        String files[] = getActivity().fileList();
        if (fileExist(files, fileName)) {
            try {
                InputStreamReader file = new InputStreamReader(getActivity().openFileInput(fileName));
                BufferedReader br = new BufferedReader(file);
                String line = br.readLine();
                String bitacoraCompleta = "";
                while (line != null) {
                    bitacoraCompleta = bitacoraCompleta + line + "\n";
                    line = br.readLine();
                }
                br.close();
                file.close();
                txt_file.setText(bitacoraCompleta);
            } catch (IOException e) {
                Toast.makeText(this.getActivity(), "Error de archivos", Toast.LENGTH_SHORT).show();
            }
        }


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.btnSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        binding.btnToFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_sqliteFragment);
            }
        });
    }

    private boolean fileExist(String files[], String fileName) {
        for (int i = 0; i < files.length; i++)
            if (fileName.equals(files[i]))
                return true;
        return false;
    }

    public void save() {
        try {
            OutputStreamWriter file = new OutputStreamWriter(getActivity().openFileOutput(fileName, Activity.MODE_PRIVATE));
            file.write(txt_file.getText().toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            Toast.makeText(this.getActivity(), "Error al obtener el archivo", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this.getActivity(), "Guardado exitosamente", Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}