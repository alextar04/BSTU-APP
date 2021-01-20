/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package f.f.b.i.l;

import f.f.b.i.l.d;
import f.f.b.i.l.g;
import f.f.b.i.l.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;
    public m d;
    public a e = a.e;
    public int f;
    public int g;
    public int h = 1;
    public g i = null;
    public boolean j = false;
    public List<d> k = new ArrayList();
    public List<f> l = new ArrayList();

    public f(m m2) {
        this.d = m2;
    }

    @Override
    public void a(d d2) {
        d d3;
        Iterator iterator = this.l.iterator();
        while (iterator.hasNext()) {
            if (((f)iterator.next()).j) continue;
            return;
        }
        this.c = true;
        d d4 = this.a;
        if (d4 != null) {
            d4.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        f f2 = null;
        int n2 = 0;
        for (f f3 : this.l) {
            if (f3 instanceof g) continue;
            ++n2;
            f2 = f3;
        }
        if (f2 != null && n2 == 1 && f2.j) {
            g g2 = this.i;
            if (g2 != null) {
                if (g2.j) {
                    this.f = this.h * g2.g;
                } else {
                    return;
                }
            }
            this.c(f2.g + this.f);
        }
        if ((d3 = this.a) != null) {
            d3.a(this);
        }
    }

    public void b() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int n2) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = n2;
        for (d d2 : this.k) {
            d2.a(d2);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.b.Y);
        stringBuilder.append(":");
        stringBuilder.append((Object)this.e);
        stringBuilder.append("(");
        String string = this.j ? Integer.valueOf((int)this.g) : "unresolved";
        stringBuilder.append((Object)string);
        stringBuilder.append(") <t=");
        stringBuilder.append(this.l.size());
        stringBuilder.append(":d=");
        stringBuilder.append(this.k.size());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

}

