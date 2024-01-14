package app.spacex.tracker.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class FailureDetails implements Parcelable {

    @SerializedName("time")
    private long time=0;
    @SerializedName("altitude")
    private long altitude=0;
    @SerializedName("reason")
    private String reason="";

    protected FailureDetails(Parcel in) {
        time = in.readLong();
        altitude = in.readLong();
        reason = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeLong(altitude);
        dest.writeString(reason);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FailureDetails> CREATOR = new Creator<FailureDetails>() {
        @Override
        public FailureDetails createFromParcel(Parcel in) {
            return new FailureDetails(in);
        }

        @Override
        public FailureDetails[] newArray(int size) {
            return new FailureDetails[size];
        }
    };
}
