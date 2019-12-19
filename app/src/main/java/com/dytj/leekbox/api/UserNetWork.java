package com.dytj.leekbox.api;

import com.dytj.leekbox.api.baseFile.BaseNetWork;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.LunBoTuEntity;
import com.dytj.leekbox.model.MessageEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.model.TradeSimpleResult;
import com.dytj.leekbox.model.UserRechargeWay;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by zeng on 2019/4/9.
 */

public class UserNetWork extends BaseNetWork {

    protected final NetService service = getRetrofit().create(NetService.class);
    protected final NetService service2 = getRetrofit2().create(NetService.class);

    private interface NetService {

        /**
         * 用户登录
         */
        @FormUrlEncoded
        @POST("api/login")
        Observable<LoginEntity> userLogin(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 用户注册
         */
        @FormUrlEncoded
        @POST("api/register")
        Observable<RegisterEntity> userRegister(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 获取验证码
         * @return
         */
        @FormUrlEncoded
        @POST("api/register")
        Observable<TradeSimpleResult> userGetSms(@FieldMap HashMap<String,Object> modificationPassWordEntryMap);

        //获取消息列表
        @GET("api/AppPrivate/get_messages")
        Observable<MessageEntity> toGetMessageEntity(@QueryMap HashMap<String, Object> modificationPassWordEntryMap);

        //查询app充值和提现用原生还是H5页
        @GET("public/dialog?")
        Observable<UserRechargeWay> getUserRechargeWay(@QueryMap HashMap<String, Object> modificationPassWordEntryMap);

        //获取首页轮播图
        @GET("api/AppPubilc/get_lunbotu")
        Observable<LunBoTuEntity> toGetLunBoTuEntity();

        //获取首页轮播图
        @GET("api/AppPubilc/get_lunbotu")
        Observable<LunBoTuEntity> toGetLunBoTuEntity2();

        //刷新token
        @FormUrlEncoded
        @POST("directlink/user/active/record")
        Observable<TradeSimpleResult> getUserRecordEntity(@FieldMap HashMap<String, Object> paramMap);
    }

    //登录
    public void userLogin(HashMap<String, Object> paramMap, Observer<LoginEntity> observer) {
        setSubscribe(service.userLogin(paramMap), observer);
    }

    //注册
    public void userRegister(HashMap<String, Object> paramMap, Observer<RegisterEntity> observer) {
        setSubscribe(service.userRegister(paramMap), observer);
    }

    //获取验证码
    public void usergetSms(HashMap<String, Object> paramMap, Observer<TradeSimpleResult> observer) {
        setSubscribe(service.userGetSms(paramMap), observer);
    }

    //获取消息列表
    public void toGetMessageEntity(HashMap<String, Object> paramMap, Observer<MessageEntity> observer) {
        setSubscribe(service.toGetMessageEntity(paramMap), observer);
    }

    //查询app充值和提现用原生还是H5页
    public void getUserRechargeWay(HashMap<String, Object> paramMap, Observer<UserRechargeWay> observer) {
        setSubscribe(service.getUserRechargeWay(paramMap), observer);
    }

    //首页轮播图
    public void toGetLunBoTuEntity(Observer<LunBoTuEntity> observer) {
        setSubscribe(service.toGetLunBoTuEntity(), observer);
    }

    //首页轮播图
    public void toGetLunBoTuEntity2(Observer<LunBoTuEntity> observer) {
        setSubscribe(service2.toGetLunBoTuEntity2(), observer);
    }

    //刷新token
    public void getUserRecordEntity(HashMap<String, Object> paramMap, Observer<TradeSimpleResult> observer) {
        setSubscribe(service.getUserRecordEntity(paramMap), observer);
    }
}
