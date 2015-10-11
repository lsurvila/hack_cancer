package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chris on 11/10/2015.
 */
public class Status {
    @SerializedName("status")
    @Expose
    public String status;
}
