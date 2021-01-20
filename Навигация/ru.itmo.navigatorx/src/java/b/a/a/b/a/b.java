/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.c0
 *  g.a.g0
 *  g.a.p0.n
 *  g.a.s0
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 *  org.bson.types.ObjectId
 */
package b.a.a.b.a;

import b.a.a.b.a.c;
import g.a.c0;
import g.a.g0;
import g.a.p0.n;
import g.a.s0;
import h.m.b.j;
import org.bson.types.ObjectId;

public class b
extends g0
implements s0 {
    public ObjectId a;
    public int b;
    public double c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public int i;
    public double j;
    public double k;
    public c0<String> l;

    public b() {
        c0 c02 = new c0();
        j.e((Object)"", (String)"labelText");
        j.e((Object)"", (String)"text");
        j.e((Object)"", (String)"info");
        j.e((Object)c02, (String)"connectedIDs");
        ((n)this).l();
        this.y(0.0);
        this.v("");
        this.z("");
        this.t("");
        this.q(0);
        this.s(0);
        this.u(0);
        this.w(0.0);
        this.x(0.0);
        this.r(c02);
        this.p(new ObjectId());
        this.A(c.j.e);
        ((n)this).l();
        ((n)this).l();
    }

    public void A(int n2) {
        this.b = n2;
    }

    public String a() {
        return this.d;
    }

    public int b() {
        return this.h;
    }

    public int d() {
        return this.g;
    }

    public double e() {
        return this.j;
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.i;
    }

    public double h() {
        return this.c;
    }

    public String i() {
        return this.e;
    }

    public int j() {
        return this.b;
    }

    public double k() {
        return this.k;
    }

    public ObjectId m() {
        return this.a;
    }

    public c0 n() {
        return this.l;
    }

    public final c o() {
        c c22;
        block3 : {
            for (c c22 : c.values()) {
                boolean bl = c22.e == this.j();
                if (!bl) {
                    continue;
                }
                break block3;
            }
            c22 = null;
        }
        if (c22 != null) {
            return c22;
        }
        return c.j;
    }

    public void p(ObjectId objectId) {
        this.a = objectId;
    }

    public void q(int n2) {
        this.g = n2;
    }

    public void r(c0 c02) {
        this.l = c02;
    }

    public void s(int n2) {
        this.h = n2;
    }

    public void t(String string) {
        this.f = string;
    }

    public void u(int n2) {
        this.i = n2;
    }

    public void v(String string) {
        this.d = string;
    }

    public void w(double d2) {
        this.j = d2;
    }

    public void x(double d2) {
        this.k = d2;
    }

    public void y(double d2) {
        this.c = d2;
    }

    public void z(String string) {
        this.e = string;
    }
}

