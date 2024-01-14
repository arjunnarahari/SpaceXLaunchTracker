package app.spacex.tracker.presentation.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import app.spacex.tracker.domain.usecase.GetLaunchListUseCase;
import app.spacex.tracker.presentation.ServiceLocator;

public class SpaceXViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    private ServiceLocator serviceLocator;

        public SpaceXViewModelFactory(ServiceLocator serviceLocator) {
            this.serviceLocator = serviceLocator;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(SpaceXLaunchViewModel.class)) {
                return (T) new SpaceXLaunchViewModel(
                        new GetLaunchListUseCase(
                                serviceLocator.getLaunchDetailsRemoteDataSource()
                        )
                );
            }
            throw new IllegalArgumentException("unknown model class $modelClass");
        }
}
