/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 */
package c.e.a.a.v;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.e.a.a.v.a;
import c.e.a.a.v.w;
import f.h.k.b;
import java.util.Collection;

public interface d<S>
extends Parcelable {
    public S c();

    public String f(Context var1);

    public int h(Context var1);

    public Collection<b<Long, Long>> j();

    public boolean p();

    public void s(long var1);

    public View u(LayoutInflater var1, ViewGroup var2, Bundle var3, a var4, w<S> var5);

    public Collection<Long> v();
}

