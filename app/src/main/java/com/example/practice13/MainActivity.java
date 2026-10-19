package com.example.practice13;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private User validateAndGetUser() {
        EditText nameText = findViewById(R.id.name);
        EditText companyText = findViewById(R.id.company);
        EditText ageText = findViewById(R.id.age);
        EditText phoneText = findViewById(R.id.phone);

        String name = nameText.getText().toString().trim();
        String company = companyText.getText().toString().trim();
        String ageStr = ageText.getText().toString().trim();
        String phone = phoneText.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(company) || TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Заполните обязательные поля (Имя, Организация, Телефон)", Toast.LENGTH_SHORT).show();
            return null;
        }

        int age = 0;
        if (!TextUtils.isEmpty(ageStr)) {
            age = Integer.parseInt(ageStr);
        }

        return new User(name, company, age, phone);
    }

    public void sendViaPutExtra(View v) {
        User user = validateAndGetUser();
        if (user == null) return;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("method", "putExtra");
        intent.putExtra("name", user.getName());
        intent.putExtra("company", user.getCompany());
        intent.putExtra("age", user.getAge());
        intent.putExtra("phone", user.getPhone());
        startActivity(intent);
    }

    public void sendViaSerializable(View v) {
        User user = validateAndGetUser();
        if (user == null) return;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("method", "serializable");
        intent.putExtra("user_data", (java.io.Serializable) user);
        startActivity(intent);
    }

    public void sendViaParcelable(View v) {
        User user = validateAndGetUser();
        if (user == null) return;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("method", "parcelable");
        intent.putExtra("user_data", (android.os.Parcelable) user);
        startActivity(intent);
    }
}