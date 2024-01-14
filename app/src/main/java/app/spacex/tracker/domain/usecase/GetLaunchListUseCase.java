package app.spacex.tracker.domain.usecase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.spacex.tracker.data.model.SpaceXLaunchModelResponse;
import app.spacex.tracker.data.repository.datasource.remote.LaunchDetailsRemoteDataSource;

public class GetLaunchListUseCase {

    private LaunchDetailsRemoteDataSource launchDetailsRemoteDataSource;

    public GetLaunchListUseCase(LaunchDetailsRemoteDataSource launchDetailsRemoteDataSource){
        this.launchDetailsRemoteDataSource = launchDetailsRemoteDataSource;
    }

    public List<SpaceXLaunchModelResponse> getLaunchList(){
        try{
            return launchDetailsRemoteDataSource.getLaunchList();
        }catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
