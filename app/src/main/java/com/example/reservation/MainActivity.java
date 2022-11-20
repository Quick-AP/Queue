package com.example.reservation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int count = 1;
    String phoneNumber = "123456";
    View V = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void leoClick(View view){


//        final View popupView = getLayoutInflater().inflate(R.layout.popup_view, null);

//        Button btn1 = popupView.findViewById(R.id.btn1);
//        Button btn2 = popupView.findViewById(R.id.btn2);
//        Button btn3 = popupView.findViewById(R.id.btn3);
//        Button btn4 = popupView.findViewById(R.id.btn4);
//        final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);

        V = view;
        MyThread myThread = new MyThread();
        myThread.setView(view);
        myThread.setPhoneNumber(phoneNumber);
        Thread thread = new Thread(myThread);
        thread.start();
        try{
            thread.join();
        }catch (Exception ignore){
            System.out.println();
        }
        String res1 = myThread.getRes();
        System.out.println(res1);
//                new Thread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        String res = GetPostUtil.sendPost("http://10.0.2.2:8081/queue/query?phoneNumber=" + phoneNumber, null);
//                        View successView = getLayoutInflater().inflate(R.layout.success, null);
//                        TextView text = successView.findViewById(R.id.text);
//                        text.setText("排号成功："+res);
////                count++;
//                        PopupWindow sucessWindow = new PopupWindow(successView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
////                sucessWindow.showAsDropDown(v,200,-2000);
//                        sucessWindow.showAsDropDown(V,(int)(0.75*V.getWidth()),2*V.getHeight());
//                        popupWindow.dismiss();
//                    }
//
//                }).start();
//                String res = GetPostUtil.sendPost("http://10.0.2.2:8081/queue/query?phoneNumber=" + phoneNumber, null);
        View successView = getLayoutInflater().inflate(R.layout.success, null);
        TextView text = successView.findViewById(R.id.text);
        text.setText("排号成功："+res1);
//                count++;
        PopupWindow sucessWindow = new PopupWindow(successView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
//                sucessWindow.showAsDropDown(v,200,-2000);
        sucessWindow.showAsDropDown(V,(int)(0.75*V.getWidth()),2*V.getHeight());
//        popupWindow.dismiss();
//        popupWindow.showAsDropDown(view,view.getWidth(),-view.getHeight());
//        popupWindow.showAsDropDown(view,800,-100);

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                V = v;
//
//                MyThread myThread = new MyThread();
//                myThread.setView(v);
//                myThread.setPhoneNumber(phoneNumber);
//                Thread thread = new Thread(myThread);
//                thread.start();
//                try{
//                    thread.join();
//                }catch (Exception ignore){
//                    System.out.println();
//                }
//                String res1 = myThread.getRes();
//                System.out.println(res1);
////                new Thread(new Runnable() {
////
////                    @Override
////                    public void run() {
////                        String res = GetPostUtil.sendPost("http://10.0.2.2:8081/queue/query?phoneNumber=" + phoneNumber, null);
////                        View successView = getLayoutInflater().inflate(R.layout.success, null);
////                        TextView text = successView.findViewById(R.id.text);
////                        text.setText("排号成功："+res);
//////                count++;
////                        PopupWindow sucessWindow = new PopupWindow(successView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
//////                sucessWindow.showAsDropDown(v,200,-2000);
////                        sucessWindow.showAsDropDown(V,(int)(0.75*V.getWidth()),2*V.getHeight());
////                        popupWindow.dismiss();
////                    }
////
////                }).start();
////                String res = GetPostUtil.sendPost("http://10.0.2.2:8081/queue/query?phoneNumber=" + phoneNumber, null);
//                View successView = getLayoutInflater().inflate(R.layout.success, null);
//                TextView text = successView.findViewById(R.id.text);
//                text.setText("排号成功："+res1);
////                count++;
//                PopupWindow sucessWindow = new PopupWindow(successView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
////                sucessWindow.showAsDropDown(v,200,-2000);
//                sucessWindow.showAsDropDown(V,(int)(0.75*V.getWidth()),2*V.getHeight());
//                popupWindow.dismiss();
//
//
//
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

}
