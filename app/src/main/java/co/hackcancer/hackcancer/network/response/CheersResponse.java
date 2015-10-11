package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CheersResponse {

    @SerializedName("cheers")
    @Expose
    public List<Cheer> cheers = new ArrayList<>();

}
