/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  f.i.a.a
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package f.i.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import f.i.a.a;

public abstract class c
extends a {
    public int m;
    public int n;
    public LayoutInflater o;

    @Deprecated
    public c(Context context, int n2, Cursor cursor, boolean bl) {
        super(context, null, bl);
        this.n = n2;
        this.m = n2;
        this.o = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.o.inflate(this.m, viewGroup, false);
    }
}

