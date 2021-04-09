package com.example.victoraso.tarea_opcional.LiveData;

/**EJERCICIO 2 OPCIONAL - VICTOR PAREJA RAMIREZ**/

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.victoraso.tarea_opcional.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends AppCompatActivity {
    ActivityLiveDataBinding binding;
    LiveDataViewModel liveDataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Live Data");

        liveDataViewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);

        //set observer
        setObserver();
        //set buttons
        startTimer();
        stopTimer();
    }

    public void setObserver() {
        liveDataViewModel.getSeconds().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                binding.number.setText(i.toString());
            }
        });

        liveDataViewModel.getFinished().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean b) {
                if (b) {
                    Toast.makeText(getApplicationContext(), "Finished", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void startTimer() {
        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.time.getText().length() < 4) {
                    Toast.makeText(getApplicationContext(), "Número incorrecto", Toast.LENGTH_LONG).show();
                }else{
                    liveDataViewModel.setMillis(Long.parseLong(binding.time.getText().toString()));
                    liveDataViewModel.startTimer();
                }

            }
        });
    }

    public void stopTimer() {
        binding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.number.setText("0");
                liveDataViewModel.stopTimer();
            }
        });
    }
}