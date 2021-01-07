package com.example.flast_light;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;

    android.hardware.Camera camera ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=findViewById(R.id.togglebtn);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {


                if (isChecked) {


                   camera= Camera.open();
                   Camera.Parameters p=camera.getParameters();
                   p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                   camera.setParameters(p);
                   camera.startPreview();
                    

                } else {
                    camera.stopPreview();
                    camera.release();

                }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error not working", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
