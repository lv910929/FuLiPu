package com.lv.fulipu.net;

import com.lv.fulipu.model.HttpResult;
import com.lv.fulipu.model.Meizi;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * 接口调用的工具类
 */
public interface APIService {

    //http://gank.io/api/data/Android/10/1
    @GET("data/{type}/{count}/{pageIndex}")
    Observable<HttpResult<List<Meizi>>> getMeiziData(@Path("type") String type,
                                                     @Path("count") int count,
                                                     @Path("pageIndex") int pageIndex);

}
