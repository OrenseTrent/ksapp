package com.cloversoft.ks.config;

import com.cloversoft.ks.vendor.android.java.security.SecurityLayer;



public class Url extends SecurityLayer {
    public static final String PRODUCTION_URL = decrypt("https://m.ks881000.com/kspwa/");
    public static final String DEBUG_URL = decrypt("https://m.ks881000.com/kspwa/");

    public static final String APP = App.production ? PRODUCTION_URL : DEBUG_URL;


    public static final String getCenter(){ return "center.php"; }
    public static final String getCenterV2(){return "centerv2.php";}

    public static final String getPlay(){
        return "center.php";
    }

    public static final String getAjax(){
        return "ajax_data.php";
    }

}
