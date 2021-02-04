package com.cloversoft.ks.vendor.android.java;

import android.util.Log;

import com.cloversoft.ks.config.Keys;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

public class JavaUtils {

    static public String getTime() {
        String time = "";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        time = (new Timestamp(System.currentTimeMillis())).toString();
        return timestamp.getTime() + "";
    }

    static public String md5() {
        String timestamp = JavaUtils.getTime();
        StringBuilder var10000 = new StringBuilder();
        Intrinsics.checkExpressionValueIsNotNull(timestamp, "timestamp");
        String timeKey = var10000.append(StringsKt.take(timestamp, 7)).append(Keys.API_KEY).toString();
        String md5 = "MD5";
        String res = null;

        try {
            MessageDigest var12 = MessageDigest.getInstance(md5);
            Intrinsics.checkExpressionValueIsNotNull(var12, "MessageDigest.getInstance(md5)");
            MessageDigest msgDigest = var12;
            Charset var7 = Charsets.UTF_8;
            boolean var8 = false;
            if (timeKey == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else {
                byte[] var13 = timeKey.getBytes(var7);
                Intrinsics.checkExpressionValueIsNotNull(var13, "(this as java.lang.String).getBytes(charset)");
                byte[] var10 = var13;
                msgDigest.update(var10);
                byte[] msg = msgDigest.digest();
                BigInteger hash = new BigInteger(1, msg);
                String var14 = hash.toString(16);
                Intrinsics.checkExpressionValueIsNotNull(var14, "hash.toString(16)");

                for(res = var14; res.length() < 32; res = '0' + res) {
                }

                return res;
            }
        } catch (NoSuchAlgorithmException var11) {
            var11.printStackTrace();
            Log.d("md5_util", String.valueOf(Unit.INSTANCE));

            return "";
        }
    }
}
