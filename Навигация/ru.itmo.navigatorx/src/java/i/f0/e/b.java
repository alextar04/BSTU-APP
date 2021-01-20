/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.u$a
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.UnknownServiceException
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 */
package i.f0.e;

import i.f0.a;
import i.f0.c;
import i.g;
import i.i;
import i.u;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class b {
    public final List<i> a;
    public int b = 0;
    public boolean c;
    public boolean d;

    public b(List<i> list) {
        this.a = list;
    }

    public i a(SSLSocket sSLSocket) {
        i i2;
        block11 : {
            int n2 = this.a.size();
            for (int i3 = this.b; i3 < n2; ++i3) {
                i2 = (i)this.a.get(i3);
                if (!i2.a(sSLSocket)) continue;
                this.b = i3 + 1;
                break block11;
            }
            i2 = null;
        }
        if (i2 != null) {
            boolean bl;
            block12 : {
                for (int i4 = this.b; i4 < this.a.size(); ++i4) {
                    if (!((i)this.a.get(i4)).a(sSLSocket)) continue;
                    bl = true;
                    break block12;
                }
                bl = false;
            }
            this.c = bl;
            a a2 = a.a;
            boolean bl2 = this.d;
            if ((u.a)a2 != null) {
                boolean bl3;
                String[] arrstring = i2.c != null ? c.u(g.b, sSLSocket.getEnabledCipherSuites(), i2.c) : sSLSocket.getEnabledCipherSuites();
                String[] arrstring2 = i2.d != null ? c.u(c.o, sSLSocket.getEnabledProtocols(), i2.d) : sSLSocket.getEnabledProtocols();
                String[] arrstring3 = sSLSocket.getSupportedCipherSuites();
                int n3 = c.s(g.b, arrstring3, "TLS_FALLBACK_SCSV");
                if (bl2 && n3 != -1) {
                    String string = arrstring3[n3];
                    int n4 = 1 + arrstring.length;
                    String[] arrstring4 = new String[n4];
                    System.arraycopy((Object)arrstring, (int)0, (Object)arrstring4, (int)0, (int)arrstring.length);
                    arrstring4[n4 - 1] = string;
                    arrstring = arrstring4;
                }
                if (bl3 = i2.a) {
                    if (arrstring.length != 0) {
                        String[] arrstring5 = (String[])arrstring.clone();
                        if (bl3) {
                            if (arrstring2.length != 0) {
                                String[] arrstring6 = (String[])arrstring2.clone();
                                if (arrstring6 != null) {
                                    sSLSocket.setEnabledProtocols(arrstring6);
                                }
                                if (arrstring5 != null) {
                                    sSLSocket.setEnabledCipherSuites(arrstring5);
                                }
                                return i2;
                            }
                            throw new IllegalArgumentException("At least one TLS version is required");
                        }
                        throw new IllegalStateException("no TLS versions for cleartext connections");
                    }
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            throw null;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Unable to find acceptable protocols. isFallback=");
        stringBuilder.append(this.d);
        stringBuilder.append(", modes=");
        stringBuilder.append(this.a);
        stringBuilder.append(", supported protocols=");
        stringBuilder.append(Arrays.toString((Object[])sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(stringBuilder.toString());
    }
}

