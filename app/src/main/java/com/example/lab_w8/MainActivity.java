package com.example.lab_w8;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 初始化 Activity

        Button btn = findViewById(R.id.button); // 连接 Button 作为变量
        btn.setOnClickListener(new View.OnClickListener() { // Button 的事件
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder dialog = new AlertDialog.Builder( MainActivity.this);
                dialog.setMessage("请在下方选择你想要的执行操作");

                dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "dialog关闭", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("自定义Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast();
                    }
                });

                dialog.setPositiveButton("显示list", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showListDialog();
                    }
                });
                dialog.show();
            }
        });
    }

    private void showToast() {
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_root));
        toast.setView(layout);
        toast.show();
    }

    private void showListDialog() {
        final String[] list = {"message1", "message2", "message3", "message4", "message5"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("消息列表");
        dialog_list.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "你选择了" + list[i], Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();
    }

}