package co.hackcancer.hackcancer.network;

import co.hackcancer.hackcancer.network.response.CheersResponse;
import co.hackcancer.hackcancer.network.response.PackagesResponse;
import co.hackcancer.hackcancer.network.response.SupportersResponse;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface HackCancerService {

    @GET("/users/{user_id}/cheers")
    Observable<CheersResponse> getCheers(@Path("user_id") int userId);

    @GET("/users/{user_id}/packages")
    Observable<PackagesResponse> getPackages(@Path("user_id") int userId);

    @GET("/users/{user_id}/supporters")
    Observable<SupportersResponse> getSupporters(@Path("user_id") int userId);

}
