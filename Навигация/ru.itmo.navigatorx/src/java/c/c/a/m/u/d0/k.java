/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.u.d0.k$a
 *  c.c.a.m.u.d0.k$b
 *  f.b.k.h
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 */
package c.c.a.m.u.d0;

import c.c.a.m.m;
import c.c.a.m.u.d0.k;
import c.c.a.s.g;
import c.c.a.s.j;
import f.b.k.h;
import f.h.k.c;
import java.security.MessageDigest;

public class k {
    public final g<m, String> a = new g(1000L);
    public final c<b> b = c.c.a.s.k.a.a(10, new a(this));

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public String a(m m2) {
        g<m, String> g2;
        String string;
        g<m, String> g3;
        g<m, String> g4 = g3 = this.a;
        // MONITORENTER : g4
        string = this.a.a(m2);
        // MONITOREXIT : g4
        if (string == null) {
            b b2 = this.b.b();
            h.i.p(b2, "Argument must not be null");
            b b3 = b2;
            try {
                m2.a(b3.e);
                string = j.l(b3.e.digest());
            }
            finally {
                this.b.a(b3);
            }
        }
        g<m, String> g5 = g2 = this.a;
        // MONITORENTER : g5
        this.a.d(m2, string);
        // MONITOREXIT : g5
        return string;
    }
}

