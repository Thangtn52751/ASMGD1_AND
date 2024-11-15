package dev.md19303.demoasm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextInputEditText txtEmail, txtPass, txtRe_pass;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        txtRe_pass = findViewById(R.id.txtRe_pass);
        btnSignUp = findViewById(R.id.btnSignUp);
        mAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(v -> {
            String email = txtEmail.getText().toString();
            String pass = txtPass.getText().toString();
            String re_pass = txtRe_pass.getText().toString();

            if(email.isEmpty() || pass.isEmpty() || re_pass.isEmpty()){
                txtEmail.setError("Vui lòng nhập email");
                txtPass.setError("Vui lòng nhập mật khẩu");
                txtRe_pass.setError("Vui lòng nhập lại mật khẩu");
            }
            else if(!pass.equals(re_pass)){
                txtRe_pass.setError("Mật khẩu không khớp");
            }
            else{
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(task -> {
                   if(task.isSuccessful()){
                       Toast.makeText(this, "Tao TK thanh cong", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(this, "Tao TK that bai", Toast.LENGTH_SHORT).show();
                   }
                });
            }
        });

    }
}