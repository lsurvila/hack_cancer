package co.hackcancer.hackcancer.network;

import android.content.Context;

import co.hackcancer.hackcancer.helper.JsonHelper;
import co.hackcancer.hackcancer.network.response.CheersResponse;
import co.hackcancer.hackcancer.network.response.UserResponse;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.http.Path;
import rx.Observable;
import rx.Subscriber;

public class MockHackCancerApi {

    private HackCancerService service;

    private static MockHackCancerApi ourInstance;

    public static MockHackCancerApi getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new MockHackCancerApi(context);
        }
        return ourInstance;
    }

    public MockHackCancerApi(Context context) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("mock")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        service = mockRestAdapter.create(HackCancerService.class, new MockHackCancerService(context));
    }

    public Observable<UserResponse> getUsers() {
        return service.getUsers();
    }

    public Observable<CheersResponse> getCheers(int userId) {
        return service.getCheers(userId);
    }

    private class MockHackCancerService implements HackCancerService {

        private Context context;

        public MockHackCancerService(Context context) {
            this.context = context;
        }

        @Override
        public Observable<UserResponse> getUsers() {
            return Observable.create(new Observable.OnSubscribe<UserResponse>() {
                @Override
                public void call(Subscriber<? super UserResponse> subscriber) {
                    subscriber.onNext(JsonHelper.getJsonAsObjectFromAssetsFile(context, "users_response.json", UserResponse.class));
                    subscriber.onCompleted();
                }
            });
        }

        @Override
        public Observable<CheersResponse> getCheers(@Path("user_id") int userId) {
            return Observable.create(new Observable.OnSubscribe<CheersResponse>() {
                @Override
                public void call(Subscriber<? super CheersResponse> subscriber) {
                    subscriber.onNext(JsonHelper.getJsonAsObjectFromAssetsFile(context, "cheers_response.json", CheersResponse.class));
                    subscriber.onCompleted();
                }
            });
        }
    }

}
