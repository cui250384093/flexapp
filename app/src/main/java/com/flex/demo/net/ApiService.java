package com.flex.demo.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * ClassName: ApiService
 * Package: com.flex.demo.net
 * Description:
 *
 * @author candk - 6/5/23 - 3:16 PM
 * @version v1.0
 */
public interface ApiService {

    @GET("int/{param}")
    Call<String> readInt(@Path("param") String param);

    @PUT("int/{param}/{value}")
    Call<String> writeInt(@Path("param") String param, @Path("value") String value);

    @GET("bool/{param}")
    Call<String> readBool(@Path("param") String param);

    @PUT("bool/{param}/{value}")
    Call<String> writeBool(@Path("param") String param, @Path("value") String value);

    @GET("float/{param}")
    Call<String> readFloat(@Path("param") String param);

    /**
     *
     * @param param
     * @param value
     * @return
     */
    @PUT("float/{param}/{value}")
    Call<String> writeFloat(@Path("param") String param, @Path("value") String value);
}
