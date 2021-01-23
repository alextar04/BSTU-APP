/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.util.Log
 *  c.c.a.n.c
 *  f.b.k.h
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.c.a.n;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import c.c.a.n.c;
import c.c.a.n.e;
import f.b.k.h;

public final class e
implements c {
    public final Context e;
    public final c.a f;
    public boolean g;
    public boolean h;
    public final BroadcastReceiver i = new BroadcastReceiver(this){
        public final /* synthetic */ e a;
        {
            this.a = e2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public void onReceive(Context context, Intent intent) {
            c.c.a.i i2;
            e e2 = this.a;
            boolean bl = e2.g;
            e2.g = e2.l(context);
            if (bl == this.a.g) return;
            if (Log.isLoggable((String)"ConnectivityMonitor", (int)3)) {
                java.lang.StringBuilder stringBuilder = c.b.a.a.a.c("connectivity changed, isConnected: ");
                stringBuilder.append(this.a.g);
                Log.d((String)"ConnectivityMonitor", (String)stringBuilder.toString());
            }
            e e3 = this.a;
            c.a a2 = e3.f;
            boolean bl2 = e3.g;
            c.c.a.i$b b2 = (c.c.a.i$b)a2;
            if (b2 == null) throw null;
            if (!bl2) return;
            c.c.a.i i3 = i2 = b2.b;
            // MONITORENTER : i3
            c.c.a.n.n n2 = b2.a;
            java.util.Iterator iterator = ((java.util.ArrayList)c.c.a.s.j.f(n2.a)).iterator();
            do {
                if (!iterator.hasNext()) {
                    // MONITOREXIT : i3
                    return;
                }
                c.c.a.q.b b3 = (c.c.a.q.b)iterator.next();
                if (b3.c() || b3.d()) continue;
                b3.clear();
                if (!n2.c) {
                    b3.b();
                    continue;
                }
                n2.b.add((Object)b3);
            } while (true);
        }
    };

    public e(Context context, c.a a2) {
        this.e = context.getApplicationContext();
        this.f = a2;
    }

    public void e() {
        if (!this.h) {
            return;
        }
        this.e.unregisterReceiver(this.i);
        this.h = false;
    }

    public void i() {
        if (this.h) {
            return;
        }
        this.g = this.l(this.e);
        try {
            this.e.registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.h = true;
            return;
        }
        catch (SecurityException securityException) {
            if (Log.isLoggable((String)"ConnectivityMonitor", (int)5)) {
                Log.w((String)"ConnectivityMonitor", (String)"Failed to register", (Throwable)securityException);
            }
            return;
        }
    }

    public void k() {
    }

    @SuppressLint(value={"MissingPermission"})
    public boolean l(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        h.i.p(connectivityManager, "Argument must not be null");
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        catch (RuntimeException runtimeException) {
            if (Log.isLoggable((String)"ConnectivityMonitor", (int)5)) {
                Log.w((String)"ConnectivityMonitor", (String)"Failed to determine connectivity status when connectivity changed", (Throwable)runtimeException);
            }
            return true;
        }
        return networkInfo != null && networkInfo.isConnected();
    }
}

