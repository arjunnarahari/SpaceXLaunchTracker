package app.spacex.tracker.app;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

public class ApplicationClass extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
