package co.hackcancer.hackcancer.network;

import co.hackcancer.hackcancer.network.response.UserResponse;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;

public class MockHackCancerApi {

    private HackCancerService service;

    private static MockHackCancerApi ourInstance = new MockHackCancerApi();

    public static MockHackCancerApi getInstance() {
        return ourInstance;
    }

    public MockHackCancerApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        service = mockRestAdapter.create(HackCancerService.class, new MockHackCancerService());
    }

    private Observable<UserResponse> getUser() {
        return service.getUser();
    }

    private class MockHackCancerService implements HackCancerService {

        @Override
        public Observable<UserResponse> getUser() {
            return Observable.create(new Observable.OnSubscribe<UserResponse>() {
                @Override
                public void call(Subscriber<? super UserResponse> subscriber) {
                    //TODO mock response
                }
            });
        }
    }

}
