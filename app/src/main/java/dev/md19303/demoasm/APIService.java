package dev.md19303.demoasm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {
    String DOMMAIN = "http://10.82.1.44:3000/";

    @GET("/api/list")
    Call<List<carModel>> getList();

    @POST("/api/add_xe")
    Call<List<carModel>> addCar(carModel car);

    @PUT("/api/update_xe")
    Call<carModel> updateCar(carModel car);

    @DELETE("/api/delete_xe")
    Call<carModel> deleteCar(carModel car);
}
