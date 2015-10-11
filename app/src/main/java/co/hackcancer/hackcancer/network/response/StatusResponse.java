package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StatusResponse {
    @SerializedName("supporters")
    @Expose
    public List<Status> statuses = new ArrayList<>();
}
