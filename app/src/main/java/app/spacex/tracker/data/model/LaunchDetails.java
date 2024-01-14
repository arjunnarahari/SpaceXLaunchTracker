package app.spacex.tracker.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class LaunchDetails implements Parcelable {

    @SerializedName("site_name")
    private String launchSiteName="";

    protected LaunchDetails(Parcel in) {
        launchSiteName = in.readString();
    }

    public static final Creator<LaunchDetails> CREATOR = new Creator<LaunchDetails>() {
        @Override
        public LaunchDetails createFromParcel(Parcel in) {
            return new LaunchDetails(in);
        }

        @Override
        public LaunchDetails[] newArray(int size) {
            return new LaunchDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(launchSiteName);
    }
}
