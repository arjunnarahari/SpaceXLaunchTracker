package app.spacex.tracker.data.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class SpaceXLaunchModel implements Parcelable {

    @SerializedName("mission_name")
    private String missionName="";
    @SerializedName("launch_date_local")
    private String launchDate="";
    @SerializedName("launch_success")
    private Boolean launchSuccess=false;
    private String launchStatus="";
    @SerializedName("launch_window")
    private long launchWindow=0;
    @SerializedName("details")
    private String details="";
    @SerializedName("upcoming")
    private Boolean upcoming=false;
    @SerializedName("rocket")
    private Rocket rocket;
    @SerializedName("launch_site")
    private LaunchDetails launchDetails;
    @SerializedName("launch_failure_details")
    private FailureDetails failureDetails;
    @SerializedName("links")
    private Links links;

    public SpaceXLaunchModel(){

    }


    protected SpaceXLaunchModel(Parcel in) {
        missionName = in.readString();
        launchDate = in.readString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            launchSuccess = in.readBoolean();
        }
        launchStatus = in.readString();
        launchWindow = in.readLong();
        details = in.readString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            upcoming = in.readBoolean();
        }
        rocket = in.readParcelable(Rocket.class.getClassLoader());
        launchDetails = in.readParcelable(LaunchDetails.class.getClassLoader());
        failureDetails = in.readParcelable(FailureDetails.class.getClassLoader());
        links = in.readParcelable(Links.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(missionName);
        dest.writeString(launchDate);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            dest.writeBoolean(launchSuccess);
        }
        dest.writeString(launchStatus);
        dest.writeLong(launchWindow);
        dest.writeString(details);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            dest.writeBoolean(upcoming);
        }
        dest.writeParcelable(rocket, flags);
        dest.writeParcelable(launchDetails, flags);
        dest.writeParcelable(failureDetails, flags);
        dest.writeParcelable(links, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SpaceXLaunchModel> CREATOR = new Creator<SpaceXLaunchModel>() {
        @Override
        public SpaceXLaunchModel createFromParcel(Parcel in) {
            return new SpaceXLaunchModel(in);
        }

        @Override
        public SpaceXLaunchModel[] newArray(int size) {
            return new SpaceXLaunchModel[size];
        }
    };

    public String getMissionName() {
        if(null==missionName)
            return "";
        else
            return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getLaunchDate() {
        if(null==launchDate)
            return "";
        else
            return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public boolean isLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public String getLaunchStatus() {
        if(null==launchStatus)
            return "";
        else
            return launchStatus;
    }

    public void setLaunchStatus(String launchStatus) {
        this.launchStatus = launchStatus;
    }

    public long getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(long launchWindow) {
        this.launchWindow = launchWindow;
    }

    public String getDetails() {
        if(null==details)
            return "";
        else
            return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isUpcoming() {
        return upcoming;
    }

    public void setUpcoming(boolean upcoming) {
        this.upcoming = upcoming;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public LaunchDetails getLaunchDetails() {
        return launchDetails;
    }

    public void setLaunchDetails(LaunchDetails launchDetails) {
        this.launchDetails = launchDetails;
    }

    public FailureDetails getFailureDetails() {
        return failureDetails;
    }

    public void setFailureDetails(FailureDetails failureDetails) {
        this.failureDetails = failureDetails;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
