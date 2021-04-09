package com.example.victoraso.tarea_opcional.ViewModel;

import androidx.lifecycle.ViewModel;

public class ViewModelClass extends ViewModel {
    private int number;

    public void add() {
        number++;
    }

    public int getNumber() {
        return this.number;
    }
}
