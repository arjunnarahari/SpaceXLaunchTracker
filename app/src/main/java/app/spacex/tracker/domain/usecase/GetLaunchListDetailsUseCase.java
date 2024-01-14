package app.spacex.tracker.domain.usecase;

import java.util.Collections;

import app.spacex.tracker.data.model.SpaceXLaunchModel;
import app.spacex.tracker.data.model.SpaceXLaunchModelResponse;
import app.spacex.tracker.domain.repository.LaunchDetailsRepository;

public class GetLaunchListDetailsUseCase {

    private LaunchDetailsRepository launchDetailsRepository;

    public GetLaunchListDetailsUseCase(LaunchDetailsRepository launchDetailsRepository){
        this.launchDetailsRepository = launchDetailsRepository;
    }

    public SpaceXLaunchModel getLaunchListDetails(){
        try{
            return launchDetailsRepository.getLaunchDetails();
        }catch (Exception e){
            e.printStackTrace();
            return new SpaceXLaunchModel();
        }
    }
}
