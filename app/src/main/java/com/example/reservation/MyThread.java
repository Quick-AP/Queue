package com.example.reservation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

/***
 * @Author jianghanchen
 * @Date 21:49 2022/11/18
 ***/


public class MyThread implements Runnable{

        private View v;
        private String res;
        private String phoneNumber;

        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
        }
        public void setView(View v){
            this.v = v;
        }
        public String getRes(){
            return res;
        }
        public void run(){
            res = GetPostUtil.sendPost("http://10.0.2.2:8081/queue/register?phoneNumber=" + phoneNumber, null);
        }

}

