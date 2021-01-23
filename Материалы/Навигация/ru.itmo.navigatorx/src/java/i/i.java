/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 */
package i;

import i.e0;
import i.f0.c;
import i.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class i {
    public static final g[] e;
    public static final g[] f;
    public static final i g;
    public static final i h;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    public static {
        e0 e02 = e0.i;
        e0 e03 = e0.g;
        e0 e04 = e0.f;
        g[] arrg = new g[]{g.q, g.r, g.s, g.t, g.u, g.k, g.m, g.l, g.n, g.p, g.o};
        e = arrg;
        g[] arrg2 = new g[]{g.q, g.r, g.s, g.t, g.u, g.k, g.m, g.l, g.n, g.p, g.o, g.i, g.j, g.g, g.h, g.e, g.f, g.d};
        f = arrg2;
        a a2 = new a(true);
        a2.b(e);
        a2.e(e04, e03);
        a2.c(true);
        a a3 = new a(true);
        a3.b(f);
        e0[] arre0 = new e0[]{e04, e03, e0.h, e02};
        a3.e(arre0);
        a3.c(true);
        g = new i(a3);
        a a4 = new a(true);
        a4.b(f);
        a4.e(e02);
        a4.c(true);
        h = new i(new a(false));
    }

    public i(a a2) {
        this.a = a2.a;
        this.c = a2.b;
        this.d = a2.c;
        this.b = a2.d;
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.a) {
            return false;
        }
        String[] arrstring = this.d;
        if (arrstring != null && !c.w(c.o, arrstring, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] arrstring2 = this.c;
        return arrstring2 == null || c.w(g.b, arrstring2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean equals(Object object) {
        if (!(object instanceof i)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        i i2 = (i)object;
        boolean bl = this.a;
        if (bl != i2.a) {
            return false;
        }
        if (bl) {
            if (!Arrays.equals((Object[])this.c, (Object[])i2.c)) {
                return false;
            }
            if (!Arrays.equals((Object[])this.d, (Object[])i2.d)) {
                return false;
            }
            if (this.b != i2.b) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.a) {
            return 31 * (31 * (527 + Arrays.hashCode((Object[])this.c)) + Arrays.hashCode((Object[])this.d)) + (true ^ this.b);
        }
        return 17;
    }

    public String toString() {
        String string;
        if (!this.a) {
            return "ConnectionSpec()";
        }
        String[] arrstring = this.c;
        int n2 = 0;
        String string2 = "[all enabled]";
        if (arrstring != null) {
            List list;
            if (arrstring != null) {
                ArrayList arrayList = new ArrayList(arrstring.length);
                int n3 = arrstring.length;
                for (int i2 = 0; i2 < n3; ++i2) {
                    arrayList.add((Object)g.a(arrstring[i2]));
                }
                list = Collections.unmodifiableList((List)arrayList);
            } else {
                list = null;
            }
            string = list.toString();
        } else {
            string = string2;
        }
        String[] arrstring2 = this.d;
        if (arrstring2 != null) {
            List list = null;
            if (arrstring2 != null) {
                ArrayList arrayList = new ArrayList(arrstring2.length);
                int n4 = arrstring2.length;
                while (n2 < n4) {
                    arrayList.add((Object)e0.a(arrstring2[n2]));
                    ++n2;
                }
                list = Collections.unmodifiableList((List)arrayList);
            }
            string2 = list.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionSpec(cipherSuites=");
        stringBuilder.append(string);
        stringBuilder.append(", tlsVersions=");
        stringBuilder.append(string2);
        stringBuilder.append(", supportsTlsExtensions=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static final class a {
        public boolean a;
        public String[] b;
        public String[] c;
        public boolean d;

        public a(boolean bl) {
            this.a = bl;
        }

        public /* varargs */ a a(String ... arrstring) {
            if (this.a) {
                if (arrstring.length != 0) {
                    this.b = (String[])arrstring.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public /* varargs */ a b(g ... arrg) {
            if (this.a) {
                String[] arrstring = new String[arrg.length];
                for (int i2 = 0; i2 < arrg.length; ++i2) {
                    arrstring[i2] = arrg[i2].a;
                }
                this.a(arrstring);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a c(boolean bl) {
            if (this.a) {
                this.d = bl;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public /* varargs */ a d(String ... arrstring) {
            if (this.a) {
                if (arrstring.length != 0) {
                    this.c = (String[])arrstring.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public /* varargs */ a e(e0 ... arre0) {
            if (this.a) {
                String[] arrstring = new String[arre0.length];
                for (int i2 = 0; i2 < arre0.length; ++i2) {
                    arrstring[i2] = arre0[i2].e;
                }
                this.d(arrstring);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

}

