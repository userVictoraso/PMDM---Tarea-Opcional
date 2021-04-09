package com.example.victoraso.tarea_opcional.ViewModel;

/**EJERCICIO 1 OPCIONAL - VICTOR PAREJA RAMIREZ**/

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.victoraso.tarea_opcional.databinding.ActivityViewModelBinding;

public class ViewModelActivity extends AppCompatActivity {

    private ActivityViewModelBinding binding;
    ViewModelClass viewModelClass;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewModelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("View Model");


        viewModelClass = new ViewModelProvider(this).get(ViewModelClass.class);

        //Set button
        addNumber();
    }

    public void addNumber() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelClass.add();
                number = viewModelClass.getNumber();
                binding.number.setText(Integer.toString(number));
            }
        });
    }
}