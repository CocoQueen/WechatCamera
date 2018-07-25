package com.coco.wechatcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {

    private Button btn;
    private ImageView img;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);
        tv = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {

            private Intent intent;

            @Override
            public void onClick(View v) {
                intent = new Intent(TwoActivity.this, MainActivity.class);
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 10) {
                String url = data.getStringExtra("url");
                tv.setText(url);
                Bitmap bitmap = data.getParcelableExtra("bitmap");
                img.setImageBitmap(bitmap);
            }
        }
    }
}
