//package com.lokesh.apiservice.service;
//
//
//import android.database.ContentObserver;
//import android.os.Handler;
//
//public class DataChangeObserver extends ContentObserver {
//    private SendDataService sendDataService;
//
//    public DataChangeObserver(Handler handler, SendDataService sendDataService) {
//        super(handler);
//        this.sendDataService = sendDataService;
//    }
//
//    @Override
//    public void onChange(boolean selfChange) {
//        super.onChange(selfChange);
//        // Handle the data change, for example, trigger the service to send data
//        if (sendDataService != null) {
//            sendDataService.sendDataToApi();
//        }
//    }
//}
//
