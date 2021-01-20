/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package f.f.b.i;

import f.f.b.c;
import f.f.b.i.d;
import java.util.ArrayList;

public class k
extends d {
    public ArrayList<d> f0 = new ArrayList();

    public void E() {
        ArrayList<d> arrayList = this.f0;
        if (arrayList == null) {
            return;
        }
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)this.f0.get(i2);
            if (!(d2 instanceof k)) continue;
            ((k)d2).E();
        }
    }

    @Override
    public void u() {
        this.f0.clear();
        super.u();
    }

    @Override
    public void v(c c2) {
        super.v(c2);
        int n2 = this.f0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((d)this.f0.get(i2)).v(c2);
        }
    }
}

