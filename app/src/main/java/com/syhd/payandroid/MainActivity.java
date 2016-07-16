package com.syhd.payandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syhd.payandroid.alipay.client.Alipay;
import com.syhd.payandroid.alipay.server.AlipayServer;
import com.syhd.payandroid.net.HttpUtils;
import com.syhd.payandroid.net.StringCallback;
import com.syhd.payandroid.weixin.WXPay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private TextView alipayBtn;
    private Button wxpayBtn;
    String url = "http://218.17.158.113:13001/servlet/json?funcNo=407222&match_id=2&user_id=69";
    String urlpost = "http://218.17.158.113:13001/servlet/json?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 支付宝支付
         */
        alipayBtn = (TextView) findViewById(R.id.alipay);

        wxpayBtn = (Button) findViewById(R.id.wxpay);
        wxpayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("funcNo", "407222");
                map.put("match_id", "2");
                map.put("user_id", "69");
                HttpUtils.httpPost(
                        MainActivity.this, urlpost, map, new StringCallback() {
                            @Override
                            public void onError(String request) {

                            }

                            @Override
                            public void onResponse(String response) {
                                Log.i(TAG, response);
                                alipayBtn.setText(response);
                            }
                        }
                );
           /*     HttpUtils.httpGet(MainActivity.this, url, new StringCallback() {
                    @Override
                    public void onError(String request) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response);
                        alipayBtn.setText(response);
                    }

                });*/


            }
        });
    }
}