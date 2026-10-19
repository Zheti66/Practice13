package com.example.practice13;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(22);
        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            String method = arguments.getString("method", "unknown");
            String resultText = "Метод передачи: " + method + "\n\n";

            if ("putExtra".equals(method)) {
                String name = arguments.getString("name");
                String company = arguments.getString("company");
                int age = arguments.getInt("age");
                String phone = arguments.getString("phone");

                resultText += "Имя: " + name +
                        "\nОрганизация: " + company +
                        "\nВозраст: " + age +
                        "\nТелефон: " + phone;

            } else if ("serializable".equals(method)) {
                User user = (User) arguments.getSerializable("user_data");
                if (user != null) {
                    resultText += "Имя: " + user.getName() +
                            "\nОрганизация: " + user.getCompany() +
                            "\nВозраст: " + user.getAge() +
                            "\nТелефон: " + user.getPhone();
                }

            } else if ("parcelable".equals(method)) {
                User user = arguments.getParcelable("user_data");
                if (user != null) {
                    resultText += "Имя: " + user.getName() +
                            "\nОрганизация: " + user.getCompany() +
                            "\nВозраст: " + user.getAge() +
                            "\nТелефон: " + user.getPhone();
                }
            }

            textView.setText(resultText);
        }

        setContentView(textView);
    }
}