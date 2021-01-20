/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  c.c.a.a
 *  c.c.a.m.u.l
 *  c.c.a.q.e
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.List
 *  java.util.Map
 */
package c.c.a;

import android.content.Context;
import android.content.ContextWrapper;
import c.c.a.a;
import c.c.a.b;
import c.c.a.g;
import c.c.a.j;
import c.c.a.m.u.c0.b;
import c.c.a.m.u.l;
import c.c.a.q.e;
import c.c.a.q.h.c;
import java.util.List;
import java.util.Map;

public class d
extends ContextWrapper {
    public static final j<?, ?> j = new a();
    public final b a;
    public final g b;
    public final b.a c;
    public final List<c.c.a.q.d<Object>> d;
    public final Map<Class<?>, j<?, ?>> e;
    public final l f;
    public final boolean g;
    public final int h;
    public e i;

    public d(Context context, b b2, g g2, c c2, b.a a2, Map<Class<?>, j<?, ?>> map, List<c.c.a.q.d<Object>> list, l l2, boolean bl, int n2) {
        super(context.getApplicationContext());
        this.a = b2;
        this.b = g2;
        this.c = a2;
        this.d = list;
        this.e = map;
        this.f = l2;
        this.g = bl;
        this.h = n2;
    }
}

