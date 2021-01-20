/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  c.c.a.r.d
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.UUID
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentMap
 */
package c.c.a.r;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import c.b.a.a.a;
import c.c.a.m.m;
import c.c.a.r.d;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b {
    public static final ConcurrentMap<String, m> a = new ConcurrentHashMap();

    public static m a(Context context) {
        String string = context.getPackageName();
        m m2 = (m)a.get((Object)string);
        if (m2 == null) {
            PackageInfo packageInfo;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                StringBuilder stringBuilder = a.c("Cannot resolve info for");
                stringBuilder.append(context.getPackageName());
                Log.e((String)"AppVersionSignature", (String)stringBuilder.toString(), (Throwable)nameNotFoundException);
                packageInfo = null;
            }
            String string2 = packageInfo != null ? String.valueOf((int)packageInfo.versionCode) : UUID.randomUUID().toString();
            d d2 = new d((Object)string2);
            m m3 = (m)a.putIfAbsent((Object)string, (Object)d2);
            if (m3 == null) {
                return d2;
            }
            m2 = m3;
        }
        return m2;
    }
}

