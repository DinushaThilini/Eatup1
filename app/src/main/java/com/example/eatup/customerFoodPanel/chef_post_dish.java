 package com.example.eatup.customerFoodPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eatup.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

 public class chef_post_dish extends AppCompatActivity {

    ImageButton;
    Button post_dish;
    Spinner Dishes;
    TextInputLayout desc,qty,pri;
    String desdription,quantity,price,dishes;
    Uri imageuri;
    private Uri mcropimageuri;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,data;
    FirebaseAuth Fauth;
    StorageReference ref;
    String ChefId,RandomUID,State,City,Area;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_post_dish);

        storage=FirebaseStorage.getInstance();
        storageReference= storage.getReference();
        Dishes=(Spinner) findViewById(R.id.dishes);
        desc =(TextInputLayout)findViewById(R.id.description);
        qty=(TextInputLayout)findViewById(R.id.description);
        pri = (TextInputLayout) findViewById(R.id.price);
        post_dish = (Button) findViewById(R.id.post);
        Fauth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getInstance().getReference("FoodDetails");

        try {
            String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            data = firebaseDatabase.getInstance().getReference("Chef").child(userid);
            data.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    chef  cheff=snapshot.getValue(cheff.class);
                    State =cheff.getState();
                    Area=cheff.getArea();
                    ImageButton =(ImageButton) findViewById(R.id.image_upload);

                    ImageButton.setOn(new View.onClickListener(){
                        @Override
                        public void onClick(view v ){
                            onSelectImageclick(v);
                        }
                    });
                    post_dish.setOnClickListener(new View.OnClickListener())
                }

                @Override
                public void onClick(View v){
                    dishes= Dishes.getSelectedItem().toString().trim();
                    description = desc.getEditText().getText().toString().trim();
                    quantity =qty.getEditText().getText().toString().trim();
                    price = pri.getEditText().getText().toString().trim();

                    if(isValid()){
                        uploadImage();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }catch (Exception e){
            Log.e("Error: ",e.getMessage());
        }

    }

     private void uploadImage() {
        if(imageuri= null){
            final ProgressDialog = new ProgressDialog( context:chef_post_dish.this);
            progressDialog.setTitle("Uploading.....");
            progressDialog.show();
            RandomUID = UUID.randomUUID().toString();
            ref = storageReference.child(RandomUID);
            chefID = FirebaseAuth.getInstance().getCurrentUser().getUid();
            ref.putfile(imageuri).addOnSuccessListner(new OnSuccessListner<UploadTask.TaskSnapshot>{

                @Override
                        public void onSuccess(UploadTask, UploadTask.TaskSnapshot tasksnapshot;
                tasksnapshot){
                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

                        @Override
                        public void onSuccess(Uri uri) {
                            Food_detail info = new Food_detail(dishes,quantity,price,description,String.valueof(uri),RandomID,ChefID);
                            firebaseDatabase.getInstance().getReference(path: "FoodDetails").child(State).child(city).child(Area).child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomID)
                                    .setValue(info).addOnCompleListener(new OnCompleteListner<Void>(){
                                        @Override
                                        public void oncomplete(@NonNull Task<void> task){

                                            progressDialog.dismiss();
                                            Toast.makeText( context:chef_post_dish.this,"Dish posted Successfully!",Toast.LENGTH_SHORT),show();
                                        }
                                    })

                        }
                    })
                }
            }).addonFailureListner(new onFailureListner(){
                @Override
                public void onFailure(@Nonull Exeption e){
                    progressDialog.dissmiss();
                    Toast.makeText(chef_postDish.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                }
            }).addOnProgressListner(new onProgressListner<uploadTask, UploadTask.TaskSnapshot>(){
                @Override
                public Void onProgress(@NonNull uploadTask, UploadTask.TaskSnapshot taskSnapshot){
                    double progress =(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploaded "+(int) progress+ "%");
                    progressDialog.setCancelesonTouchOutside(false);

                }
            })
        }
     }

     private boolean isValid() {

        desc.setErrorEnabled(false);
        desc.setError("");
        qty.setErrorEnabled(false);
        qty.setError();
        pri.setErrorEnabled(false);
        pri.setError();

        boolean isValidDescription = false,isValidPrice= false,isValidQuantity= false,isValid=false;
        if(TextUtils.isEmpty(desdription)){
            desc.setErrorEnabled(true);
            desc.setError("Description is Required");

        }else{
            desc.setError(null);
            isValidDescription=true;
        }
        if(TextUtils.isEmpty(quantity)){
            qty.setErrorEnabled(true);
            qty.setError("Enter number of Plates or Items");
        }else{
            isValidQuantity=true;
        }
        if(TextUtils.isEmpty(price)){
            pri.setErrorEnabled(true);
            pri.setError("Please Mention Price");
        }else{
            isValidPrice=true;
        }
        isValid=(isValidDescription && isValidQuantity && isValidPrice)?true:false;
        return isValid;

     }
     private void startCropImageActivity(Uri imageuri){
     Cropimage.activity(imageuri)
             .setGuidelines(CropImageView.Guidelines.ON)
             .setMultiTouchEnabled(true)
             .start(activity:this);

 }
     private void onSelectImageclick(View v){
     CropImage.startPickImageActivity(this);
     }

     @Override
      public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissons, @NonNull int[] grantResultys){
     if(mcropimageuri !=null && grantResultys.length>0 && grantResultys[0]== PackageManager,PERMISSION_GRANTED){
         startCropImageActivity(mcropimageuri);
         }else{
             Toast.makeText(this,"Cancelling! Permission Not Granted",Toast.LENGTH_SHORT).show();
         }
     }
     @Override
     @SuppressLint("NewApi")
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

         if(requestCode==CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode== Activity.RESULT_OK){
             imageuri = CropImage.getPickImageResultUri(this,data);
             if(CropImage.isReadExternalStoragePermissionsRequired(this,imageuri)){
                 mcropimageuri = imageuri;
                 requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
             }else{
                 startCropImageActivity(imageuri);
             }
         }
         if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
             CropImage.ActivityResult result = CropImage.getActivityResult(data);
             if(resultCode==RESULT_OK){
                 ((ImageButton) findViewById(R.id.image_upload)).setImageURI(result.getUri());
                 Toast.makeText(this,"Cropped Successfully!",Toast.LENGTH_SHORT).show();
             }else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                 Toast.makeText(this,"Failed To Crop"+result.getError(),Toast.LENGTH_SHORT).show();

             }
         }

         super.onActivityResult(requestCode, resultCode, data);

