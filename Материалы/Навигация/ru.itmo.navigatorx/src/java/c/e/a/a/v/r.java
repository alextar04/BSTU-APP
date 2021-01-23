/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.v;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import c.e.a.a.v.d;
import c.e.a.a.v.r;
import c.e.a.a.v.w;
import c.e.a.a.v.x;

public final class r<S>
extends x<S> {
    public d<S> a0;
    public c.e.a.a.v.a b0;

    public void M(Bundle bundle) {
        Fragment.super.M(bundle);
        if (bundle == null) {
            bundle = this.j;
        }
        this.a0 = (d)bundle.getParcelable("DATE_SELECTOR_KEY");
        this.b0 = (c.e.a.a.v.a)bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.a0.u(layoutInflater, viewGroup, bundle, this.b0, new w<S>(this){
            public final /* synthetic */ r a;
            {
                this.a = r2;
            }

            public void a(S s2) {
                java.util.Iterator iterator = this.a.Z.iterator();
                while (iterator.hasNext()) {
                    ((w)iterator.next()).a(s2);
                }
            }
        });
    }

    public void b0(Bundle bundle) {
        bundle.putParcelable("DATE_SELECTOR_KEY", this.a0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", (Parcelable)this.b0);
    }
}

