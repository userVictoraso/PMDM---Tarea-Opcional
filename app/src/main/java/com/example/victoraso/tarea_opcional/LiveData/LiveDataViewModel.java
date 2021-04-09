package com.example.victoraso.tarea_opcional.LiveData;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {

    private MutableLiveData<Boolean> finished = new MutableLiveData<Boolean>();
    private MutableLiveData<Long> millis = new MutableLiveData<Long>();
    private MutableLiveData<Integer> seconds = new MutableLiveData<Integer>();
    private CountDownTimer timer;

    public void startTimer() {
        finished.setValue(false);
        timer = new CountDownTimer(millis.getValue(), 1000) {
            @Override
            public void onTick(long l) {
                long timeLeft = l / 1000;
                seconds.setValue((int) timeLeft);
            }

            @Override
            public void onFinish() {
                finished.setValue(true);
            }
        };
        timer.start();
    }

    public void stopTimer() {
        timer.cancel();
        finished.setValue(true);
    }

    public void setMillis(long millis) {
        this.millis.setValue(millis);
    }

    public LiveData<Integer> getSeconds() {
        return seconds;
    }

    public LiveData<Boolean> getFinished() {
        return finished;
    }

}
