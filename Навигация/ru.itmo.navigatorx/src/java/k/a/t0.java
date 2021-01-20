/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  k.a.a
 *  k.a.f
 *  k.a.r0
 *  k.a.s0
 *  k.a.w0.f0
 *  k.a.y0.f
 */
package k.a;

import f.b.k.h;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import k.a.a;
import k.a.c0;
import k.a.f;
import k.a.i0;
import k.a.k0;
import k.a.n0;
import k.a.r0;
import k.a.s0;
import k.a.w0.f0;
import k.a.w0.l0;
import k.a.w0.n1.b;
import k.a.w0.n1.d;
import k.a.w0.o0;

public final class t0 {
    public static final d a;

    public static {
        b[] arrb = new b[]{new f0()};
        a = h.i.Y(arrb);
    }

    public static k0 a(byte[] arrby, f f2) {
        i0 i02 = f2.g;
        if (i02 != i0.i && i02 != i0.j) {
            return (k0)a.a(f0.a((i0)i02)).b((c0)f2, o0.a().a());
        }
        int n2 = ((k.a.y0.f)f2.j).h();
        k.a.y0.f f3 = (k.a.y0.f)f2.j;
        if (f3 != null) {
            int n3 = f3.e.a();
            int n4 = ((k.a.y0.f)f2.j).m();
            f3.f();
            f3.e.a.position(n3);
            f2.c0();
            if (f2.g == i0.i) {
                return new s0(arrby, n2, n4);
            }
            return new r0(arrby, n2, n4);
        }
        throw null;
    }
}

