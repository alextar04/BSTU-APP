/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package g.a.p0.y;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b
extends BroadcastReceiver {
    public static List<a> a = new CopyOnWriteArrayList();

    public static void a(a a2) {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            a.remove((Object)a2);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return;
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean bl;
        block5 : {
            block4 : {
                NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnectedOrConnecting()) break block4;
                boolean bl2 = Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains((CharSequence)"google_sdk") || Build.MODEL.contains((CharSequence)"Emulator") || Build.MODEL.contains((CharSequence)"Android SDK built for x86") || Build.MANUFACTURER.contains((CharSequence)"Genymotion") || Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic") || "google_sdk".equals((Object)Build.PRODUCT);
                bl = false;
                if (!bl2) break block5;
            }
            bl = true;
        }
        Iterator iterator = a.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).a(bl);
        }
    }

    public static interface a {
        public void a(boolean var1);
    }

}

