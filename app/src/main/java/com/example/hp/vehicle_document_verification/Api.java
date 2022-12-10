package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 12-09-2022.
 */
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api
{
    String BASE_URL = "https://bastardized-casualt.000webhostapp.com/APIV/";


    @POST("Insert_signup.php")
    Call<IsExist> signup_page(
            @Query("f1") String str_name,
            @Query("f2") String str_email,
            @Query("f3") String str_mno,
            @Query("f4") String str_city,
            @Query("f5") String str_addr,
            @Query("f6") String str_pass
    );

    @GET("https://bastardized-casualt.000webhostapp.com/APIV/get_user_profile.php")
    Call<List<UserAccountArray>> getUserdetails(@Query("f1") String str_shr_umno);

    @POST("Update_user_account.php")
    Call<IsExist> updatepage(
            @Query("f1") String usr_name,
            @Query("f2") String usr_email,
            @Query("f3") String usr_mno,
            @Query("f4") String usr_city,
            @Query("f5") String usr_addr,
            @Query("f6") String usr_pass
    );

    @GET("https://bastardized-casualt.000webhostapp.com/APIV/Fetch_drivinglicense.php")
    Call<List<VehicleArray>> getvehicle(@Query("f1") String str_shr);

    @GET("https://bastardized-casualt.000webhostapp.com/APIV/Fetch_vehicledocument.php")
    Call<List<DocumentArray>> getdocument(@Query("f1") String str_shr);



    @GET("https://bastardized-casualt.000webhostapp.com/APIV/Fetch_insurance.php")
    Call<List<InsuranceArray>> getinsurance(@Query("f1") String str_shr);

    @GET("https://bastardized-casualt.000webhostapp.com/APIV/Fetch_emissiontesting.php")
    Call<List<EmmissionArray>> getemmission(@Query("f1") String str_shr);

    @GET("https://bastardized-casualt.000webhostapp.com/APIV/Fetch_vehiclemissing.php")
    Call<List<MissingArray>> getmissing(@Query("f1") String str_shr);


}
