package com.lokesh.apiservice;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.lokesh.apiservice.database.dbhelper;
import com.lokesh.apiservice.service.SendDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView list_data;

    final  dbhelper databaseHelper = new dbhelper(MainActivity.this);
    FloatingActionButton user_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_data = findViewById(R.id.list_data);
        user_register = findViewById(R.id.user_register);
        startService(new Intent(MainActivity.this, SendDataService.class));

        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call <List<Model>> call = methods.getVehicleClass();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> data = response.body();
                ListAdapter listAdapter = new ListAdapter(getApplicationContext(), data);
                list_data.setAdapter(listAdapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });


        user_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.user_register);

                TextInputEditText plaza_id_input,login_name_input,first_name_input,
                        last_name_input,password_input,role_type_input;
                Button submit_btn;

                plaza_id_input = dialog.findViewById(R.id.plaza_id_input);
                login_name_input = dialog.findViewById(R.id.login_name_input);
                first_name_input = dialog.findViewById(R.id.first_name_input);
                last_name_input = dialog.findViewById(R.id.last_name_input);
                password_input = dialog.findViewById(R.id.password_input);
                role_type_input = dialog.findViewById(R.id.role_type_input);
                submit_btn = dialog.findViewById(R.id.submit_btn);
                submit_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String plazaIdText = plaza_id_input.getText().toString().trim();
                        int plaza_id =  Integer.parseInt(plazaIdText);
                        String login_name = login_name_input.getText().toString().trim();
                        String first_name = first_name_input.getText().toString().trim();
                        String last_name = last_name_input.getText().toString().trim();
                        String password = password_input.getText().toString().trim();
                        String roleTypeText = role_type_input.getText().toString().trim();

                        databaseHelper.insertUser(plaza_id,login_name,first_name,last_name,password, Integer.parseInt(roleTypeText),1);
                        dialog.dismiss();
//                        int roletype = Integer.parseInt(roleTypeText);
//                        UserRegister userRegister = new UserRegister();
//                        userRegister.setPlaza_id(plaza_id);
//                        userRegister.setFirst_name(first_name);
//                        userRegister.setLast_name(last_name);
//                        userRegister.setLogin_name(login_name);
//                        userRegister.setPassword(password);
//                        userRegister.setRoletype(roletype);

//                        Call<UserRegister> call = methods.postUserRegister(userRegister);
//
//                        call.enqueue(new Callback<UserRegister>() {
//                            @Override
//                            public void onResponse(Call<UserRegister> call, Response<UserRegister> response) {
//                                if(response.isSuccessful()){
//                                    UserRegister userRegister = response.body();
//                                    Log.d("Response Code", "onResponse: "+response.code());
//
//
//                                    Toast customToast = new Toast(getApplicationContext());
//
//                                    customToast.setText("created user");
//                                    customToast.setDuration(Toast.LENGTH_LONG);
//                                    customToast.setGravity(Gravity.CENTER,0,0);
//                                    customToast.show();
////                                    Toast.makeText(MainActivity.this, "created user", Toast.LENGTH_LONG).show();
//                                }
//                                else {
//
//                                    Toast customToast = new Toast(getApplicationContext());
//
//                                    customToast.setText("Data is not saved");
//                                    customToast.setDuration(Toast.LENGTH_LONG);
//                                    customToast.setGravity(Gravity.CENTER,0,0);
//                                    customToast.show();
////                                    Toast.makeText(MainActivity.this, "Data is not saved", Toast.LENGTH_LONG).show();
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<UserRegister> call, Throwable t) {
//
//                                Toast customToast = new Toast(getApplicationContext());
//                                customToast.setText("An error has occured");
//                                customToast.setDuration(Toast.LENGTH_LONG);
//                                customToast.setGravity(Gravity.CENTER,0,0);
//                                customToast.show();
////                                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
//
//                            }
//                        });
//                        dialog.dismiss();
//
//                    }
//                });





            }

        });
                dialog.show();









    }
});
    }
}