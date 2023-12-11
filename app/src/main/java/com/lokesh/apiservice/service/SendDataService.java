package com.lokesh.apiservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.lokesh.apiservice.Methods;
import com.lokesh.apiservice.RetrofitClient;
import com.lokesh.apiservice.UserRegister;
import com.lokesh.apiservice.database.dbhelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendDataService extends Service {
//    private DataChangeObserver dataChangeObserver;


    private boolean isConnected;


    private dbhelper db;
    public SendDataService() {
    }
    @Override
    public void onCreate() {
        Log.d("SendDataService", "onCreate called");
        db = new dbhelper(this);
//        dataChangeObserver = new DataChangeObserver(new Handler(), this);
//        getContentResolver().registerContentObserver(Uri.parse("content://com.lokesh.apiservice.Appdatabase/userdetail"), true, dataChangeObserver);

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Perform your background task here
        isConnected = true;
        Log.d("SendDataService", "onStartCommand called");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isConnected) {
                    sendDataToApi();
                }
            }
        }).start();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Not used for started services
        return null;
    }

    public void sendDataToApi() {
        // Implement your logic to send data to the API
        // Use a separate thread or AsyncTask for network operations
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                List<UserRegister> userRegisters = db.getUsersSendToServer();
                if(userRegisters.size()>0) {
                    userRegisters.forEach(userRegister -> {
                        Call<UserRegister> call = methods.postUserRegister(userRegister);

                        call.enqueue(new Callback<UserRegister>() {
                            @Override
                            public void onResponse(Call<UserRegister> call, Response<UserRegister> response) {
                                if (response.isSuccessful()) {
                                    db.updateserverId(userRegister.getPlaza_id(), userRegister.getLogin_name(), 0);
                                    Log.d("Response Code", "onResponse: " + response.code());
                                    Log.d("Response Code", "onResponse: " + response.code());
                                } else {


                                }
                            }

                            @Override
                            public void onFailure(Call<UserRegister> call, Throwable t) {


                            }
                        });
                    });
                }

                }
    }


