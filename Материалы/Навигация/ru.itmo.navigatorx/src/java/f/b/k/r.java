/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationManager
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package f.b.k;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class r {
    public static r d;
    public final Context a;
    public final LocationManager b;
    public final a c = new a();

    public r(Context context, LocationManager locationManager) {
        this.a = context;
        this.b = locationManager;
    }

    public final Location a(String string) {
        try {
            if (this.b.isProviderEnabled(string)) {
                Location location = this.b.getLastKnownLocation(string);
                return location;
            }
        }
        catch (Exception exception) {
            Log.d((String)"TwilightManager", (String)"Failed to get last known location", (Throwable)exception);
        }
        return null;
    }

    public static class a {
        public boolean a;
        public long b;
    }

}

