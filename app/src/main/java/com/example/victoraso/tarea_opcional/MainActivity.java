package com.example.victoraso.tarea_opcional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.victoraso.tarea_opcional.LiveData.LiveDataActivity;
import com.example.victoraso.tarea_opcional.LiveData.LiveDataViewModel;
import com.example.victoraso.tarea_opcional.ViewModel.ViewModelActivity;
import com.example.victoraso.tarea_opcional.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("TAREA OPCIONAL");
    }

    public void ejercicioUno(View v) {
        startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
    }

    public void ejercicioDos(View v) {
        startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
    }
}