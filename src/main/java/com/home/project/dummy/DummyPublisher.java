package com.home.project.dummy;



import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DummyPublisher {


    private String[] dummies = {
        "{\"publisherID\":11,\"time\":\"32:12\",\"readings\":23}",
            "{\"publisherID\":12,\"time\":\"12:12\",\"readings\":123}",
            "{\"publisherID\":13,\"time\":\"05:12\",\"readings\":24}",
            "{\"publisherID\":14,\"time\":\"03:56\",\"readings\":25}",
            "{\"publisherID\":15,\"time\":\"09:12\",\"readings\":999}",
            "{\"publisherID\":16,\"time\":\"10:10\",\"readings\":9}",
            "{\"publisherID\":17,\"time\":\"11:12\",\"readings\":4}",
            "{\"publisherID\":18,\"time\":\"13:14\",\"readings\":89}",
            "{\"publisherID\":19,\"time\":\"15:16\",\"readings\":14}"
    };

    public void addPublisher() throws IOException {

        for(int i=0;i<dummies.length;i++) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, dummies[i]);
            Request request = new Request.Builder()
                    .url("http://localhost:8080/v1/publisherevent/")
                    .method("POST", body)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
        }
    }
}
