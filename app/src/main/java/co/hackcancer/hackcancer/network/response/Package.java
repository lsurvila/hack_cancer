package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Package {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("packageId")
    @Expose
    public long packageId;

}
