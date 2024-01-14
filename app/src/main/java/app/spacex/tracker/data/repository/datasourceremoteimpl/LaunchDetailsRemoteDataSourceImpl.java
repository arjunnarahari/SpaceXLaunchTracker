package app.spacex.tracker.data.repository.datasourceremoteimpl;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


import app.spacex.tracker.BuildConfig;
import app.spacex.tracker.data.api.SpaceXLaunchApi;
import app.spacex.tracker.data.model.SpaceXLaunchModel;
import app.spacex.tracker.data.model.SpaceXLaunchModelResponse;
import app.spacex.tracker.data.repository.datasource.remote.LaunchDetailsRemoteDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaunchDetailsRemoteDataSourceImpl implements LaunchDetailsRemoteDataSource {

    private SpaceXLaunchApi spaceXLaunchApi = new Retrofit.Builder()
            .baseUrl(BuildConfig.baseUrl)
            .addConverterFactory(
                    GsonConverterFactory.create(
                            new GsonBuilder()
                                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                                    .create()
                    )
            )
            .build()
            .create(SpaceXLaunchApi.class);

    @Override
    public List<SpaceXLaunchModelResponse> getLaunchList() throws IOException {
        final List<SpaceXLaunchModelResponse>[] resp = new List[]{Collections.emptyList()};
        spaceXLaunchApi.getLaunchList().enqueue(new Callback<List<SpaceXLaunchModelResponse>>() {
            @Override
            public void onResponse(Call<List<SpaceXLaunchModelResponse>> call, Response<List<SpaceXLaunchModelResponse>> response) {
                if(response.isSuccessful()){
                    resp[0] = response.body();
                    Log.i("response",""+response.body());
                }else{
                    Log.i("error",""+response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<SpaceXLaunchModelResponse>> call, Throwable t) {
                Log.i("error",""+t.getMessage());
            }
        });

        return resp[0];
    }

    @Override
    public SpaceXLaunchModel getLaunchDetails() {
        return null;
    }
}
