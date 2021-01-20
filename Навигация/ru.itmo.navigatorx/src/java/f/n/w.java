/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  f.n.d
 *  f.n.g
 *  f.n.g$a
 *  f.n.x
 *  f.n.x$a
 *  java.lang.Runnable
 */
package f.n;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import f.n.d;
import f.n.g;
import f.n.o;
import f.n.v;
import f.n.x;

public class w
extends d {
    public final /* synthetic */ v this$0;

    public w(v v2) {
        this.this$0 = v2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            x.c((Activity)activity).e = this.this$0.l;
        }
    }

    public void onActivityPaused(Activity activity) {
        int n2;
        v v2 = this.this$0;
        v2.f = n2 = -1 + v2.f;
        if (n2 == 0) {
            v2.i.postDelayed(v2.k, 700L);
        }
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new d(){

            public void onActivityPostResumed(Activity activity) {
                w.this.this$0.d();
            }

            public void onActivityPostStarted(Activity activity) {
                w.this.this$0.e();
            }
        });
    }

    public void onActivityStopped(Activity activity) {
        int n2;
        v v2 = this.this$0;
        v2.e = n2 = v2.e - 1;
        if (n2 == 0 && v2.g) {
            v2.j.d(g.a.ON_STOP);
            v2.h = true;
        }
    }

}

