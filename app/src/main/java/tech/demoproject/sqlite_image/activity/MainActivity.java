 package tech.demoproject.sqlite_image.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tech.demoproject.sqlite_image.R;
import tech.demoproject.sqlite_image.activity.AddItemActivity;

 public class MainActivity extends AppCompatActivity {

    Button btnAddItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapping
        btnAddItem = findViewById(R.id.btnAddItem);
        // Set button add item onClick
        btnAddItem.setOnClickListener(View -> {
            Intent intent = new Intent(this,AddItemActivity.class);
            startActivity(intent);
        });
    }
}