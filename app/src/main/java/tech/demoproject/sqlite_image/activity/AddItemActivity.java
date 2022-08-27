package tech.demoproject.sqlite_image.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import tech.demoproject.sqlite_image.R;

public class AddItemActivity extends AppCompatActivity {

    ImageView imgViewNoPhoto;
    ImageButton imgBtnCamera, imgBtnFolder;
    EditText edtNameItem, edtDescription;
    Button btnAdd, btnCancel;

//    private int REQUEST_CODE_CAMERA = 3;
    private int REQUEST_CODE_FOLDER = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Mapping();
        // set onClick button Camera
        imgBtnCamera.setOnClickListener(View -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });
        // set onClick button Folder
        imgBtnFolder.setOnClickListener(View -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_FOLDER);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            imgViewNoPhoto.setImageBitmap(bitmap);
//        }
        if(requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgViewNoPhoto.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void Mapping() {
        imgViewNoPhoto = findViewById(R.id.imageViewNoPhoto);
        imgBtnCamera = findViewById(R.id.imgBtnCamera);
        imgBtnFolder = findViewById(R.id.imgBtnFolder);
        edtNameItem = findViewById(R.id.editTextNameItem);
        edtDescription = findViewById(R.id.editTextDescription);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
    }
}