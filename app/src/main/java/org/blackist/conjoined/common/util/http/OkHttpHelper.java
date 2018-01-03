package org.blackist.conjoined.common.util.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * TODO
 *
 * @author LiangLiang.Dong <1075512174@qq.com>.
 * @Date 2018/1/3 10:00.
 */
public class OkHttpHelper {

    public static final MediaType TEXT_JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static final MediaType TEXT_PLAIN
            = MediaType.parse("text/plain; charset=utf-8");

    /**
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * @param data
     * @return
     * @throws IOException
     */
    public static String getWithHeader(String[] data) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Request request = new Request.Builder()
                .url(data[0])
                .header(data[1], data[2])
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * @param data
     * @return
     * @throws IOException
     */
    public static String postPlain(String[] data) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        RequestBody body;
        Request request;
        body = RequestBody.create(TEXT_PLAIN, data[1]);
        request = new Request.Builder()
                .url(data[0])
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * @param data
     * @return
     * @throws IOException
     */
    public static String postPlainWithHeader(String[] data) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        RequestBody body = RequestBody.create(TEXT_PLAIN, data[3]);
        Request request = new Request.Builder()
                .url(data[0])
                .header(data[1], data[2])
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * @param url
     * @param data
     * @return
     * @throws IOException
     */
    public static String postJSON(String url, String data) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        FormBody.Builder builder = new FormBody.Builder();
        JSONObject jsonBody = null;
        try {
            jsonBody = new JSONObject(data);
            Iterator<String> keys = jsonBody.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                builder.add(key, jsonBody.get(key).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private static String bodyToString(final Request request) {

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
