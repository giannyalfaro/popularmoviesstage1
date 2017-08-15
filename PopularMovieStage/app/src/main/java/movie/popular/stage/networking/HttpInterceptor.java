package movie.popular.stage.networking;


import android.content.Context;
import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class HttpInterceptor implements Interceptor {
    private final String CONTENT_TYPE_LABEL = "Content-Type";
    private final String CONTENT_TYPE_VALUE_JSON = "application/json";
    private Context context;

    @Inject
    public HttpInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!NetworkUtil.isOnline(context)) {
            throw new NetworkConnectionException();
        }

        Request request = chain.request().newBuilder()
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE_JSON)
                .build();

        Log.i(getClass().getSimpleName(), request.url().toString());

        return chain.proceed(request);
    }

}
