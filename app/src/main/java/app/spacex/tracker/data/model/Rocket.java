package app.spacex.tracker.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class Rocket implements Parcelable {

    @SerializedName("rocket_id")
    private String rocketId="";
    @SerializedName("rocket_name")
    private String rocketName="";
    @SerializedName("rocket_type")
    private String rocketType="";

    protected Rocket(Parcel in) {
        rocketId = in.readString();
        rocketName = in.readString();
        rocketType = in.readString();
    }

    public static final Creator<Rocket> CREATOR = new Creator<Rocket>() {
        @Override
        public Rocket createFromParcel(Parcel in) {
            return new Rocket(in);
        }

        @Override
        public Rocket[] newArray(int size) {
            return new Rocket[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(rocketId);
        parcel.writeString(rocketName);
        parcel.writeString(rocketType);
    }
}
