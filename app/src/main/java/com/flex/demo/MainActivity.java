package com.flex.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.flex.demo.databinding.ActivityMainBinding;
import com.flex.demo.net.ApiService;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author candk
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Retrofit retrofit;

    private final String BASE_URL = "http://192.168.31.126:8080/";
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build();
        apiService = retrofit.create(ApiService.class);

        event();
    }

    private void event() {
        binding.btnIntRead.setOnClickListener(v -> {

            new Thread(() -> {
                try {
                    Response<String> response = apiService.readInt("V2000").execute();
                    binding.tvInt.setText(response.body());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });

        binding.btnBoolRead.setOnClickListener(v -> {

            new Thread(() -> {
                try {
                    Response<String> response = apiService.readBool("V2002.0").execute();
                    binding.tvBool.setText(response.body());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });

        binding.btnFloatRead.setOnClickListener(v -> {

            new Thread(() -> {
                try {
                    Response<String> response = apiService.readFloat("V2008").execute();
                    binding.tvFloat.setText(response.body());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });

        binding.btnIntWrite.setOnClickListener(v -> {

            new Thread(() -> {
                try {
                    Response<String> response = apiService.writeInt("V2000", "110").execute();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });

        binding.btnBoolWrite.setOnClickListener(v -> {

            new Thread(() -> {
                try {
                    Response<String> response = apiService.writeBool("V2002.0", "true").execute();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });

        binding.btnFloatWrite.setOnClickListener(v -> {

            new Thread(() -> {
                try {
                    Response<String> response = apiService.writeFloat("V2008", "210.1").execute();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });
    }
}