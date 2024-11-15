package dev.md19303.demoasm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText txtEmail, txtPass;
    Button btnSignIn;
    TextView tvSignUp;
    private FirebaseAuth mAthu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignUp = findViewById(R.id.tvSignUp);

        mAthu = FirebaseAuth.getInstance();

        tvSignUp.setOnClickListener(v -> {
            startActivities(new Intent[]{new Intent(MainActivity.this, registerActivity.class)});
        });


        btnSignIn.setOnClickListener(v -> {
            String email = txtEmail.getText().toString();
            String pass = txtPass.getText().toString();

            if(email.isEmpty() || pass.isEmpty()){
                txtEmail.setError("Vui lòng nhập email");
                txtPass.setError("Vui lòng nhập mật khẩu");
            }
            else{
                mAthu.signInWithEmailAndPassword(email,pass).addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        startActivities(new Intent[]{new Intent(MainActivity.this, HomeActivity.class)});
                        Toast.makeText(this, "DN Thanh cong", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "DN that bai", Toast.LENGTH_SHORT).show();
                    }
                });
                    }
                });
            }
        }


