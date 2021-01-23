/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  c.c.a.m.w.e.b
 *  java.lang.Class
 *  java.lang.Math
 */
package c.c.a.m.w.e;

import android.graphics.drawable.Drawable;
import c.c.a.m.w.e.b;

public final class c
extends b<Drawable> {
    public c(Drawable drawable) {
        super(drawable);
    }

    public int c() {
        return Math.max((int)1, (int)(4 * (this.e.getIntrinsicWidth() * this.e.getIntrinsicHeight())));
    }

    public Class<Drawable> d() {
        return this.e.getClass();
    }

    public void e() {
    }
}

