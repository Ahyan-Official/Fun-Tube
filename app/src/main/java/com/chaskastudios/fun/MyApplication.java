package com.chaskastudios.fun;

import android.app.Application;

import com.facebook.ads.AudienceNetworkAds;
import com.onesignal.OneSignal;

public class MyApplication extends Application {



    private static MyApplication mInstense;




    public MyApplication(){


        mInstense = this;

    }


    @Override
    public void onCreate() {
        super.onCreate();

        mInstense = this;
        try {
            AudienceNetworkAds.initialize(this);
            AudienceNetworkAds.isInAdsProcess(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //MobileAds.initialize(this);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }



    public static synchronized  MyApplication getmInstense(){

        return mInstense;
    }





}
