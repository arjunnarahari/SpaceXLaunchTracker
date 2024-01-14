package app.spacex.tracker.presentation;

import app.spacex.tracker.data.repository.datasourceremoteimpl.LaunchDetailsRemoteDataSourceImpl;

public interface ServiceLocator {

    LaunchDetailsRemoteDataSourceImpl getLaunchDetailsRemoteDataSource();
}
