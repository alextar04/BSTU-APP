/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.MenuItem
 *  android.view.View
 *  c.b.a.a.a
 *  f.b.o.i.j
 *  f.b.o.i.j$a
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.h.l;

import android.content.Context;
import android.util.Log;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import f.b.o.i.j;

public abstract class b {
    public a a;

    public b(Context context) {
    }

    public boolean a() {
        return true;
    }

    public View b(MenuItem menuItem) {
        return ((j.a)this).b.onCreateActionView();
    }

    public boolean c() {
        return false;
    }

    public void d(a a2) {
        if (this.a != null) {
            StringBuilder stringBuilder = c.b.a.a.a.c((String)"setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(" instance while it is still in use somewhere else?");
            Log.w((String)"ActionProvider(support)", (String)stringBuilder.toString());
        }
        this.a = a2;
    }

    public static interface a {
    }

}

