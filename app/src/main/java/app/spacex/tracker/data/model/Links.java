package app.spacex.tracker.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable {

    @SerializedName("mission_patch")
    private String missionPatch="";
    @SerializedName("mission_patch_small")
    private String missionPatchSmall="";
    @SerializedName("article_link")
    private String articleLink="";
    @SerializedName("presskit")
    private String pressKit="";

    protected Links(Parcel in) {
        missionPatch = in.readString();
        missionPatchSmall = in.readString();
        articleLink = in.readString();
        pressKit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(missionPatch);
        dest.writeString(missionPatchSmall);
        dest.writeString(articleLink);
        dest.writeString(pressKit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };
}
