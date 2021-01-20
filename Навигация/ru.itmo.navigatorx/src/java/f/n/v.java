/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  f.n.g
 *  f.n.g$a
 *  f.n.m
 *  f.n.v$a
 *  f.n.x
 *  f.n.x$a
 *  java.lang.Object
 *  java.lang.Runnable
 */
package f.n;

import android.os.Handler;
import f.n.g;
import f.n.m;
import f.n.o;
import f.n.v;
import f.n.x;

public class v
implements m {
    public static final v m = new v();
    public int e = 0;
    public int f = 0;
    public boolean g = true;
    public boolean h = true;
    public Handler i;
    public final o j = new o(this);
    public Runnable k = new a(this);
    public x.a l = new x.a(){};

    public g a() {
        return this.j;
    }

    public void d() {
        int n2;
        this.f = n2 = 1 + this.f;
        if (n2 == 1) {
            if (this.g) {
                this.j.d(g.a.ON_RESUME);
                this.g = false;
                return;
            }
            this.i.removeCallbacks(this.k);
        }
    }

    public void e() {
        int n2;
        this.e = n2 = 1 + this.e;
        if (n2 == 1 && this.h) {
            this.j.d(g.a.ON_START);
            this.h = false;
        }
    }

}

