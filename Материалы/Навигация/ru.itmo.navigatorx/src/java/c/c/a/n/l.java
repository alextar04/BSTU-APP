/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.app.FragmentTransaction
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  androidx.fragment.app.Fragment
 *  c.c.a.i
 *  c.c.a.n.a
 *  c.c.a.n.b
 *  c.c.a.n.g
 *  c.c.a.n.l$a
 *  c.c.a.n.o
 *  f.l.d.a
 *  f.l.d.e
 *  f.l.d.r
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package c.c.a.n;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c.c.a.i;
import c.c.a.n.g;
import c.c.a.n.h;
import c.c.a.n.k;
import c.c.a.n.l;
import c.c.a.n.m;
import c.c.a.n.o;
import c.c.a.s.j;
import f.l.d.e;
import f.l.d.r;
import java.util.HashMap;
import java.util.Map;

public class l
implements Handler.Callback {
    public static final b f = new a();
    public volatile i a;
    public final Map<FragmentManager, k> b = new HashMap();
    public final Map<r, o> c = new HashMap();
    public final Handler d;
    public final b e;

    public l(b b2) {
        new Bundle();
        if (b2 == null) {
            b2 = f;
        }
        this.e = b2;
        this.d = new Handler(Looper.getMainLooper(), (Handler.Callback)this);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity)context;
        }
        if (context instanceof ContextWrapper) {
            return l.a(((ContextWrapper)context).getBaseContext());
        }
        return null;
    }

    public static boolean e(Context context) {
        Activity activity = l.a(context);
        return activity == null || !activity.isFinishing();
        {
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public i b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (j.j() && !(context instanceof Application)) {
            ContextWrapper contextWrapper;
            if (context instanceof e) {
                e e2 = (e)context;
                if (j.i()) {
                    return this.b(e2.getApplicationContext());
                }
                if (e2.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                o o2 = this.d(e2.m(), null, l.e((Context)e2));
                i i2 = o2.d0;
                if (i2 != null) {
                    return i2;
                }
                c.c.a.b b2 = c.c.a.b.b((Context)e2);
                b b3 = this.e;
                c.c.a.n.a a2 = o2.Z;
                m m2 = o2.a0;
                if ((a)b3 != null) {
                    i i3;
                    o2.d0 = i3 = new i(b2, (h)a2, m2, (Context)e2);
                    return i3;
                }
                throw null;
            }
            if (context instanceof Activity) {
                Activity activity = (Activity)context;
                if (j.i()) {
                    return this.b(activity.getApplicationContext());
                }
                if (activity.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                k k2 = this.c(activity.getFragmentManager(), null, l.e((Context)activity));
                i i4 = k2.h;
                if (i4 != null) {
                    return i4;
                }
                c.c.a.b b4 = c.c.a.b.b((Context)activity);
                b b5 = this.e;
                c.c.a.n.a a3 = k2.e;
                m m3 = k2.f;
                if ((a)b5 != null) {
                    i i5;
                    k2.h = i5 = new i(b4, (h)a3, m3, (Context)activity);
                    return i5;
                }
                throw null;
            }
            if (context instanceof ContextWrapper && (contextWrapper = (ContextWrapper)context).getBaseContext().getApplicationContext() != null) {
                return this.b(contextWrapper.getBaseContext());
            }
        }
        if (this.a == null) {
            l l2 = this;
            synchronized (l2) {
                if (this.a == null) {
                    c.c.a.b b6 = c.c.a.b.b(context.getApplicationContext());
                    b b7 = this.e;
                    c.c.a.n.b b8 = new c.c.a.n.b();
                    g g2 = new g();
                    Context context2 = context.getApplicationContext();
                    if ((a)b7 == null) {
                        throw null;
                    }
                    this.a = new i(b6, (h)b8, (m)g2, context2);
                }
            }
        }
        return this.a;
    }

    public final k c(FragmentManager fragmentManager, Fragment fragment, boolean bl) {
        k k2 = (k)fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (k2 == null && (k2 = (k)((Object)this.b.get((Object)fragmentManager))) == null) {
            k2 = new k();
            k2.j = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                k2.a(fragment.getActivity());
            }
            if (bl) {
                k2.e.d();
            }
            this.b.put((Object)fragmentManager, (Object)k2);
            fragmentManager.beginTransaction().add((Fragment)k2, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(1, (Object)fragmentManager).sendToTarget();
        }
        return k2;
    }

    public final o d(r r2, androidx.fragment.app.Fragment fragment, boolean bl) {
        o o2 = (o)r2.H("com.bumptech.glide.manager");
        if (o2 == null && (o2 = (o)this.c.get((Object)r2)) == null) {
            o2 = new o();
            o2.e0 = fragment;
            if (fragment != null && fragment.o() != null) {
                androidx.fragment.app.Fragment fragment2;
                androidx.fragment.app.Fragment fragment3 = fragment;
                while ((fragment2 = fragment3.y) != null) {
                    fragment3 = fragment2;
                }
                r r3 = fragment3.v;
                if (r3 != null) {
                    o2.x0(fragment.o(), r3);
                }
            }
            if (bl) {
                o2.Z.d();
            }
            this.c.put((Object)r2, (Object)o2);
            f.l.d.a a2 = new f.l.d.a(r2);
            a2.d(0, (androidx.fragment.app.Fragment)o2, "com.bumptech.glide.manager", 1);
            a2.f(true);
            this.d.obtainMessage(2, (Object)r2).sendToTarget();
        }
        return o2;
    }

    public boolean handleMessage(Message message) {
        FragmentManager fragmentManager;
        Object object;
        int n2;
        block3 : {
            FragmentManager fragmentManager2;
            Map<FragmentManager, k> map;
            block4 : {
                block1 : {
                    block2 : {
                        int n3 = message.what;
                        n2 = 1;
                        if (n3 == n2) break block1;
                        if (n3 == 2) break block2;
                        object = null;
                        n2 = 0;
                        fragmentManager = null;
                        break block3;
                    }
                    fragmentManager2 = (r)message.obj;
                    map = this.c;
                    break block4;
                }
                fragmentManager2 = (FragmentManager)message.obj;
                map = this.b;
            }
            Object object2 = map.remove((Object)fragmentManager2);
            FragmentManager fragmentManager3 = fragmentManager2;
            object = object2;
            fragmentManager = fragmentManager3;
        }
        if (n2 && object == null && Log.isLoggable((String)"RMRetriever", (int)5)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to remove expected request manager fragment, manager: ");
            stringBuilder.append((Object)fragmentManager);
            Log.w((String)"RMRetriever", (String)stringBuilder.toString());
        }
        return (boolean)n2;
    }

    public static interface b {
    }

}

