package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HelloController2 {
    @FXML
    private Label welcomeText;

    @FXML
    private ProgressBar progress1;

    @FXML
    private ProgressIndicator indikator1;

    private double value = 0;
    Timer tm ;
    ScheduledExecutorService executor;
    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Sziasztok!");
        //var value = progress1.getMaxWidth();
        System.out.println(value);
        progress1.setProgress(value);
        indikator1.setProgress(value);

        if(executor!=null) {
            executor.shutdown();
            executor.shutdownNow();

            return;
        }
        executor = Executors.newSingleThreadScheduledExecutor();
        long delay  = 1000L;
        long period = 1000L;
        executor.scheduleAtFixedRate(new subtimer(), delay, period, TimeUnit.MILLISECONDS);
        //executor.shutdownNow();
        //tm = new java.util.Timer();
        //tm.schedule(new subtimer(), 1000);
    }

    private class subtimer extends TimerTask {
        //run method
        @Override
        public void run() {
            Platform.runLater(() -> {
                String c;
                value += 0.1;
                progress1.setProgress(value);

            });
        }
    }
    private void valami(){

    }
}
