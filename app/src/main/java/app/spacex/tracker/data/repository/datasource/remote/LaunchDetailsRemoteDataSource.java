package app.spacex.tracker.data.repository.datasource.remote;

import java.io.IOException;
import java.util.List;

import app.spacex.tracker.data.model.SpaceXLaunchModel;
import app.spacex.tracker.data.model.SpaceXLaunchModelResponse;
import retrofit2.Response;

public interface LaunchDetailsRemoteDataSource {

    List<SpaceXLaunchModelResponse> getLaunchList() throws IOException;

    SpaceXLaunchModel getLaunchDetails();
}
