/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  f.b.p.v0
 *  java.lang.Object
 */
package f.b.p;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import f.b.p.b1;
import f.b.p.v0;

public class t0
extends ContextWrapper {
    public static final Object a = new Object();

    public static Context a(Context context) {
        if (!(context instanceof t0) && !(context.getResources() instanceof v0)) {
            if (context.getResources() instanceof b1) {
                return context;
            }
            b1.a();
        }
        return context;
    }
}

