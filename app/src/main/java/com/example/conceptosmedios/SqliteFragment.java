package com.example.conceptosmedios;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conceptosmedios.databinding.FragmentSqliteBinding;

import java.sql.SQLInput;


public class SqliteFragment extends Fragment {

    private FragmentSqliteBinding binding;

    private EditText txt_code, txt_description, txt_price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSqliteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt_code = (EditText) binding.txtCode;
        txt_description = (EditText) binding.txtDescription;
        txt_price = (EditText) binding.txtPrice;

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        binding.btnSearchP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        binding.btnToLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SqliteFragment.this)
                        .navigate(R.id.action_sqliteFragment_to_tableLayoutFragment);
            }
        });

    }

    public void save(){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this.getActivity(),"administration",null,1);
        SQLiteDatabase database= admin.getWritableDatabase();

        String code= txt_code.getText().toString();
        String description = txt_description.getText().toString();
        String price = txt_price.getText().toString();
        if (!code.isEmpty() && !description.isEmpty() && !price.isEmpty()) {
            ContentValues register= new ContentValues();
            register.put("code",code);
            register.put("description",description);
            register.put("price",price);
            database.insert("products",null,register);
            database.close();
            cleanForm();
            Toast.makeText(this.getActivity(),"Almacenado Exitosamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getActivity(),"Completar los datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void cleanForm() {
        txt_code.setText("");
        txt_description.setText("");
        txt_price.setText("");
    }
}