package co.hackcancer.hackcancer.network;

import co.hackcancer.hackcancer.network.response.UserResponse;
import retrofit.RestAdapter;
import rx.Observable;

public class HackCancerApi {

    private static final String ENDPOINT = "https://sheetsu.com/";
    private HackCancerService service;

    private static HackCancerApi ourInstance = new HackCancerApi();

    public static HackCancerApi getInstance() {
        return ourInstance;
    }

    public HackCancerApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        service = restAdapter.create(HackCancerService.class);
    }

    public Observable<UserResponse> getUser() {
        return service.getUser();
    }

}
