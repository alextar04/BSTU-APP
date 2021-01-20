/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  f.b.k.h
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.Iterator
 */
package f.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import f.b.k.f;
import f.b.k.h;
import f.e.c;
import f.e.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class g {
    public static final c<WeakReference<g>> e = new c();
    public static final Object f = new Object();

    public static g d(Activity activity, f f2) {
        return new h((Context)activity, null, f2, (Object)activity);
    }

    public static g e(Dialog dialog, f f2) {
        return new h(dialog.getContext(), dialog.getWindow(), f2, (Object)dialog);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void j(g g2) {
        Object object;
        Object object2 = object = f;
        synchronized (object2) {
            Iterator<WeakReference<g>> iterator = e.iterator();
            g.a a2;
            while ((a2 = (g.a)iterator).hasNext()) {
                g g3 = (g)((WeakReference)a2.next()).get();
                if (g3 != g2 && g3 != null) continue;
                a2.remove();
            }
            return;
        }
    }

    public abstract void c(View var1, ViewGroup.LayoutParams var2);

    public abstract void f();

    public abstract void g();

    public abstract void h(Bundle var1);

    public abstract void i();

    public abstract boolean k(int var1);

    public abstract void l(int var1);

    public abstract void m(View var1);

    public abstract void n(View var1, ViewGroup.LayoutParams var2);

    public abstract void o(CharSequence var1);
}

