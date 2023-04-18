package com.example.proyecto_final.Activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.bumptech.glide.Glide;
//import com.example.minimark_michael.clases.DataAnuncios;
import com.example.proyecto_final.clases.DataAnuncios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ActualizarAnuncios extends AppCompatActivity {
    ImageView updateImage;
    Button updateButton;
    EditText updateDesc, updateTitle2, updateLang;
    String title, desc, lang;
    String imageUrl;
    String key, oldImageURL;
    Uri uri;
    DatabaseReference databaseReference;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_anuncios);

        updateButton = findViewById(R.id.buttonActualizar);
        updateDesc = findViewById(R.id.actualizarDescripcion);
        updateImage = findViewById(R.id.imageViewActualizar);

        updateTitle2 = findViewById(R.id.actualizarTitulo);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            uri = data.getData();
                            updateImage.setImageURI(uri);
                        } else {
                            Toast.makeText(ActualizarAnuncios.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            Glide.with(ActualizarAnuncios.this).load(bundle.getString("Image")).into(updateImage);
            updateTitle2.setText(bundle.getString("Title"));
            updateDesc.setText(bundle.getString("Description"));
            key = bundle.getString("Key");
            oldImageURL = bundle.getString("Image");
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("Anuncios").child(key);
        updateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent intent = new Intent(ActualizarAnuncios.this, Rcyv_itemAnuncios.class);
                startActivity(intent);
            }
        });
    }
    public void saveData(){
        storageReference = FirebaseStorage.getInstance().getReference().child("Anuncios").child(uri.getLastPathSegment());
        AlertDialog.Builder builder = new AlertDialog.Builder(ActualizarAnuncios.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                updateData();
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
            }
        });
    }
    public void updateData(){
        title = updateTitle2.getText().toString().trim();
        desc = updateDesc.getText().toString().trim();
        DataAnuncios dataClass = new DataAnuncios(title, desc, imageUrl);
        databaseReference.setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    StorageReference reference = FirebaseStorage.getInstance().getReferenceFromUrl(oldImageURL);
                    reference.delete();
                    Toast.makeText(ActualizarAnuncios.this, "Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ActualizarAnuncios.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}