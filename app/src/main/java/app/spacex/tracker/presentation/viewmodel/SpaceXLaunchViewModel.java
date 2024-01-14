package app.spacex.tracker.presentation.viewmodel;

import android.app.Application;

import java.util.List;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import app.spacex.tracker.data.model.SpaceXLaunchModel;
import app.spacex.tracker.data.model.SpaceXLaunchModelResponse;
import app.spacex.tracker.domain.usecase.GetLaunchListUseCase;
import app.spacex.tracker.data.utils.AppExecutors;

public class SpaceXLaunchViewModel extends ViewModel {

    /**
     * Use Case to get the list of rocket launches
     * **/
    private GetLaunchListUseCase launchListUseCase;
    public MutableLiveData<List<SpaceXLaunchModel>> launchListMutableLiveData =
            new MutableLiveData();
    private MutableLiveData<Boolean> shouldShowLoadingIndicator = new MutableLiveData<>();

    public SpaceXLaunchViewModel(GetLaunchListUseCase launchListUseCase){
        this.launchListUseCase = launchListUseCase;
    }

    /**
     * This function is used to get the list of rocket launches with its details
     * We have used AppExecutors to execute the loader on the main thread and
     * load the list in the background thread
     * **/
    public void getLaunchList(){
        new AppExecutors().mainThread().execute(() -> {
            shouldShowLoadingIndicator.setValue(true);

            new AppExecutors().networkIO().execute(() -> {
                try{
                    List<SpaceXLaunchModelResponse> response = launchListUseCase.getLaunchList();
                    launchListMutableLiveData.postValue(response.get(0).getSpaceXLaunchModelList());
                    new AppExecutors().mainThread().execute(() -> {
                        shouldShowLoadingIndicator.setValue(false);
                    });
                }catch (Exception e){
                    e.printStackTrace();
                    new AppExecutors().mainThread().execute(() -> {
                        shouldShowLoadingIndicator.setValue(false);
                    });
                }

            });
        });



    }
}
