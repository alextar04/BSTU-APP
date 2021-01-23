/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.util.List
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package i;

import i.b;
import i.f;
import i.f0.c;
import i.i;
import i.m;
import i.r;
import i.v;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {
    public final r a;
    public final m b;
    public final SocketFactory c;
    public final b d;
    public final List<v> e;
    public final List<i> f;
    public final ProxySelector g;
    public final Proxy h;
    public final SSLSocketFactory i;
    public final HostnameVerifier j;
    public final f k;

    public a(String string, int n2, m m2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f f2, b b2, Proxy proxy, List<v> list, List<i> list2, ProxySelector proxySelector) {
        String string2;
        block14 : {
            r.a a2;
            String string3;
            block13 : {
                block12 : {
                    a2 = new r.a();
                    string3 = "https";
                    string2 = sSLSocketFactory != null ? string3 : "http";
                    if (!string2.equalsIgnoreCase("http")) break block12;
                    string3 = "http";
                    break block13;
                }
                if (!string2.equalsIgnoreCase(string3)) break block14;
            }
            a2.a = string3;
            if (string != null) {
                String string4 = r.a.b(string, 0, string.length());
                if (string4 != null) {
                    a2.d = string4;
                    if (n2 > 0 && n2 <= 65535) {
                        a2.e = n2;
                        this.a = a2.a();
                        if (m2 != null) {
                            this.b = m2;
                            if (socketFactory != null) {
                                this.c = socketFactory;
                                if (b2 != null) {
                                    this.d = b2;
                                    if (list != null) {
                                        this.e = c.p(list);
                                        if (list2 != null) {
                                            this.f = c.p(list2);
                                            if (proxySelector != null) {
                                                this.g = proxySelector;
                                                this.h = proxy;
                                                this.i = sSLSocketFactory;
                                                this.j = hostnameVerifier;
                                                this.k = f2;
                                                return;
                                            }
                                            throw new NullPointerException("proxySelector == null");
                                        }
                                        throw new NullPointerException("connectionSpecs == null");
                                    }
                                    throw new NullPointerException("protocols == null");
                                }
                                throw new NullPointerException("proxyAuthenticator == null");
                            }
                            throw new NullPointerException("socketFactory == null");
                        }
                        throw new NullPointerException("dns == null");
                    }
                    throw new IllegalArgumentException(c.b.a.a.a.b("unexpected port: ", n2));
                }
                throw new IllegalArgumentException(c.b.a.a.a.j("unexpected host: ", string));
            }
            throw new NullPointerException("host == null");
        }
        throw new IllegalArgumentException(c.b.a.a.a.j("unexpected scheme: ", string2));
    }

    public boolean a(a a2) {
        return this.b.equals((Object)a2.b) && this.d.equals((Object)a2.d) && this.e.equals(a2.e) && this.f.equals(a2.f) && this.g.equals((Object)a2.g) && c.m((Object)this.h, (Object)a2.h) && c.m((Object)this.i, (Object)a2.i) && c.m((Object)this.j, (Object)a2.j) && c.m(this.k, a2.k) && this.a.e == a2.a.e;
    }

    public boolean equals(Object object) {
        if (object instanceof a) {
            r r2 = this.a;
            a a2 = (a)object;
            if (r2.equals(a2.a) && this.a(a2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.d.hashCode()) + this.e.hashCode()) + this.f.hashCode()) + this.g.hashCode());
        Proxy proxy = this.h;
        int n3 = proxy != null ? proxy.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        SSLSocketFactory sSLSocketFactory = this.i;
        int n5 = sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0;
        int n6 = 31 * (n4 + n5);
        HostnameVerifier hostnameVerifier = this.j;
        int n7 = hostnameVerifier != null ? hostnameVerifier.hashCode() : 0;
        int n8 = 31 * (n6 + n7);
        f f2 = this.k;
        int n9 = 0;
        if (f2 != null) {
            n9 = f2.hashCode();
        }
        return n8 + n9;
    }

    public String toString() {
        Proxy proxy;
        StringBuilder stringBuilder = c.b.a.a.a.c("Address{");
        stringBuilder.append(this.a.d);
        stringBuilder.append(":");
        stringBuilder.append(this.a.e);
        if (this.h != null) {
            stringBuilder.append(", proxy=");
            proxy = this.h;
        } else {
            stringBuilder.append(", proxySelector=");
            proxy = this.g;
        }
        stringBuilder.append((Object)proxy);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

