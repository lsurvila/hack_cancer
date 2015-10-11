package co.hackcancer.hackcancer.network;

import co.hackcancer.hackcancer.network.response.CheersResponse;
import co.hackcancer.hackcancer.network.response.PackagesResponse;
import retrofit.RestAdapter;
import rx.Observable;

public class HackCancerApi {

    private static HackCancerApi ourInstance;

    private static final String ENDPOINT = "https://secure-ravine-7447.herokuapp.com/";
    private HackCancerService service;

    public static HackCancerApi getInstance() {
        if (ourInstance == null) {
            ourInstance = new HackCancerApi();
        }
        return ourInstance;
    }

    public HackCancerApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        service = restAdapter.create(HackCancerService.class);
    }

    public Observable<CheersResponse> getCheers(int userId) {
        return service.getCheers(userId);
    }

    public Observable<PackagesResponse> getPackages(int userId) {
        return service.getPackages(userId);
    }

}
