package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PackagesResponse {

    @SerializedName("packages")
    @Expose
    public List<Package> packages = new ArrayList<>();

}
