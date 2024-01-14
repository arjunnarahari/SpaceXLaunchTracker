package app.spacex.tracker.presentation;

import android.app.Application;

import app.spacex.tracker.data.repository.datasourceremoteimpl.LaunchDetailsRemoteDataSourceImpl;

public class DefaultServiceLocator implements ServiceLocator {

    private static DefaultServiceLocator instance;

    private Application application;
    private LaunchDetailsRemoteDataSourceImpl launchDetailsRemoteDataSource;

    public static DefaultServiceLocator getInstance(Application application) {
        if (instance == null) {
            instance = new DefaultServiceLocator(application);
        }
        return instance;
    }

    public DefaultServiceLocator(Application application) {
        this.application = application;
    }

    @Override
    public LaunchDetailsRemoteDataSourceImpl getLaunchDetailsRemoteDataSource() {
        if (launchDetailsRemoteDataSource == null) {
            launchDetailsRemoteDataSource = new LaunchDetailsRemoteDataSourceImpl();
        }
        return launchDetailsRemoteDataSource;
    }

}
