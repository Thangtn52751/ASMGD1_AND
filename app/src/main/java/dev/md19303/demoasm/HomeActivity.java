package dev.md19303.demoasm;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    ListView lvCar;
    List<carModel> listCar;

    CarAdapter adapter;
    Button fab_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        lvCar = findViewById(R.id.lv_car);
        fab_add = findViewById(R.id.fab_add);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<List<carModel>> call = apiService.getList();

        call.enqueue(new Callback<List<carModel>>() {
            @Override
            public void onResponse(Call<List<carModel>> call, Response<List<carModel>> response) {
                if(response.isSuccessful()){
                    listCar = response.body();

                    adapter = new CarAdapter(getApplicationContext(),listCar);
                    lvCar.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<carModel>> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });

        fab_add.setOnClickListener(v -> {
            carModel xe = new carModel("Xe 4",2023,"Toyota",1000000);
            Call<List<carModel>> callAddXe = apiService.addCar(xe);

            callAddXe.enqueue(new Callback<List<carModel>>() {
                @Override
                public void onResponse(Call<List<carModel>> call, Response<List<carModel>> response) {
                    if(response.isSuccessful()){
                        listCar.clear();
                        listCar.addAll(response.body());
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<List<carModel>> call, Throwable t) {
                    Log.e("Error",t.getMessage());
                }
            });
        });
    }
}