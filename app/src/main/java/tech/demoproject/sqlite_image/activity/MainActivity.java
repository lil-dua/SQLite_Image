 package tech.demoproject.sqlite_image.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tech.demoproject.sqlite_image.R;
import tech.demoproject.sqlite_image.activity.AddItemActivity;
import tech.demoproject.sqlite_image.database.Database;

 public class MainActivity extends AppCompatActivity {

    Button btnAddItem;
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Database*/
        Database database = new Database(this,"ManagePicture.sqlite",null,1);
        //create a table
        database.QueryData("CREATE TABLE IF NOT EXISTS Item(Id INTEGER PRIMARY KEY AUTOINCREMENT, ItemName VARCHAR(150), Description VARCHAR(250), Image BLOB)");

        /**Mapping*/
        btnAddItem = findViewById(R.id.btnAddItem);
        // Set button add item onClick
        btnAddItem.setOnClickListener(View -> {
            Intent intent = new Intent(this,AddItemActivity.class);
            startActivity(intent);
        });
    }
}