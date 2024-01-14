package app.spacex.tracker.data.api;

import java.util.List;

import app.spacex.tracker.data.model.SpaceXLaunchModelResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SpaceXLaunchApi {

    @GET("v3/launches")
    Call<List<SpaceXLaunchModelResponse>> getLaunchList();
}
