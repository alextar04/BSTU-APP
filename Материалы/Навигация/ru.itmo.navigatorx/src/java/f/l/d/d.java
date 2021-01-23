/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  f.l.d.k
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.l.d;

import android.view.View;
import androidx.fragment.app.Fragment;
import f.l.d.k;

public class d
extends k {
    public final /* synthetic */ Fragment a;

    public d(Fragment fragment) {
        this.a = fragment;
    }

    public View d(int n2) {
        View view = this.a.J;
        if (view != null) {
            return view.findViewById(n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append((Object)this);
        stringBuilder.append(" does not have a view");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean e() {
        return this.a.J != null;
    }
}

