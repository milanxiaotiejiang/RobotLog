package com.robot.seabreeze;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.robot.seabreeze.log.Logger;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;

    private Button mPrint_normal_message;
    private Button mPrint_normal_object;
    private Button mPrint_bundle_object;
    private Button mPrint_collection_object;
    private Button mPrint_intent_object;
    private Button mPrint_map_object;
    private Button mPrint_reference_object;
    private Button mPrint_throwable_object;
    private Button mPrint_json_message;
    private Button mPrint_xml_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
        }

        mPrint_normal_message = (Button) findViewById(R.id.print_normal_message);
        mPrint_normal_object = (Button) findViewById(R.id.print_normal_object);
        mPrint_bundle_object = (Button) findViewById(R.id.print_bundle_object);
        mPrint_collection_object = (Button) findViewById(R.id.print_collection_object);
        mPrint_intent_object = (Button) findViewById(R.id.print_intent_object);
        mPrint_map_object = (Button) findViewById(R.id.print_map_object);
        mPrint_reference_object = (Button) findViewById(R.id.print_reference_object);
        mPrint_throwable_object = (Button) findViewById(R.id.print_throwable_object);
        mPrint_json_message = (Button) findViewById(R.id.print_json_message);
        mPrint_xml_message = (Button) findViewById(R.id.print_xml_message);

        mPrint_normal_message.setOnClickListener(this);
        mPrint_normal_object.setOnClickListener(this);
        mPrint_bundle_object.setOnClickListener(this);
        mPrint_collection_object.setOnClickListener(this);
        mPrint_intent_object.setOnClickListener(this);
        mPrint_map_object.setOnClickListener(this);
        mPrint_reference_object.setOnClickListener(this);
        mPrint_throwable_object.setOnClickListener(this);
        mPrint_json_message.setOnClickListener(this);
        mPrint_xml_message.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.print_normal_message:
//                Logger.v("message", "test message");
//                Logger.v("test message");
                Logger.e("adsd");
                break;
            case R.id.print_normal_object:
                Logger.i(new Boolean(true));
                break;
            case R.id.print_bundle_object:
                Logger.d(new Bundle());
                break;
            case R.id.print_collection_object:
                printList();
                break;
            case R.id.print_intent_object:
                Logger.w(new Intent());
                break;
            case R.id.print_map_object:
                printMap();
                break;
            case R.id.print_reference_object:
                Logger.wtf(new SoftReference(0));
                break;
            case R.id.print_throwable_object:
                Logger.e(new NullPointerException("this object is null!"));
                break;
            case R.id.print_json_message:
                printJson();
                break;
            case R.id.print_xml_message:
                printXml();
                break;
            default:
                break;
        }
    }

    private void printXml() {
        String xml = "<xyy><test1><test2>key</test2></test1><test3>name</test3><test4>value</test4></xyy>";
        Logger.xml(xml);
    }

    private void printJson() {
        String json = "{'xyy1':[{'test1':'test1'},{'test2':'test2'}],'xyy2':{'test3':'test3'," +
                "'test4':'test4'}}";
        Logger.json(json);
    }

    private void printList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("test" + i);
        }
        Logger.i(list);
    }

    private void printMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("xyy" + i, "test" + i);
        }
        Logger.d(map);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "权限添加", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "请手动给权限", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
}
