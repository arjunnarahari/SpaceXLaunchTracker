package app.spacex.tracker.domain.repository;

import java.io.IOException;
import java.util.List;

import app.spacex.tracker.data.model.SpaceXLaunchModel;
import app.spacex.tracker.data.model.SpaceXLaunchModelResponse;

public interface LaunchDetailsRepository {

    public List<SpaceXLaunchModelResponse> getLaunchList() throws IOException;

    public SpaceXLaunchModel getLaunchDetails();

}
