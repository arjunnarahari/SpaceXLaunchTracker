package app.spacex.tracker.data.model;

import java.util.List;

public class SpaceXLaunchModelResponse {

    private List<SpaceXLaunchModel> spaceXLaunchModelList;

    public List<SpaceXLaunchModel> getSpaceXLaunchModelList() {
        return spaceXLaunchModelList;
    }

    public void setSpaceXLaunchModelList(List<SpaceXLaunchModel> spaceXLaunchModelList) {
        this.spaceXLaunchModelList = spaceXLaunchModelList;
    }
}
