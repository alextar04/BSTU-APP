/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.o
 *  i.u$a
 *  i.w
 *  java.lang.Cloneable
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.security.GeneralSecurityException
 *  java.security.KeyStore
 *  java.security.SecureRandom
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 */
package i;

import i.f;
import i.f0.d.e;
import i.f0.i.f;
import i.f0.k.c;
import i.f0.k.d;
import i.h;
import i.i;
import i.k;
import i.l;
import i.m;
import i.n;
import i.o;
import i.s;
import i.u;
import i.v;
import i.w;
import i.x;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class u
implements Cloneable {
    public static final List<v> G;
    public static final List<i> H;
    public final boolean A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final l e;
    public final Proxy f;
    public final List<v> g;
    public final List<i> h;
    public final List<s> i;
    public final List<s> j;
    public final n.b k;
    public final ProxySelector l;
    public final k m;
    public final i.c n;
    public final e o;
    public final SocketFactory p;
    public final SSLSocketFactory q;
    public final c r;
    public final HostnameVerifier s;
    public final i.f t;
    public final i.b u;
    public final i.b v;
    public final h w;
    public final m x;
    public final boolean y;
    public final boolean z;

    public static {
        v[] arrv = new v[]{v.i, v.g};
        G = i.f0.c.q(arrv);
        i[] arri = new i[]{i.g, i.h};
        H = i.f0.c.q(arri);
        i.f0.a.a = new a();
    }

    public u() {
        this(new b());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public u(b b2) {
        Object[] arrobject;
        block13 : {
            boolean bl;
            c c2;
            this.e = b2.a;
            this.f = null;
            this.g = b2.b;
            this.h = b2.c;
            this.i = i.f0.c.p(b2.d);
            this.j = i.f0.c.p(b2.e);
            this.k = b2.f;
            this.l = b2.g;
            this.m = b2.h;
            this.n = null;
            this.o = null;
            this.p = b2.i;
            Iterator iterator = this.h.iterator();
            block5 : do {
                bl = false;
                while (iterator.hasNext()) {
                    i i2 = (i)iterator.next();
                    if (!bl && !i2.a) continue block5;
                    bl = true;
                }
                break;
            } while (true);
            if (!bl) {
                this.q = null;
                c2 = null;
            } else {
                SSLSocketFactory sSLSocketFactory;
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(null);
                arrobject = trustManagerFactory.getTrustManagers();
                if (arrobject.length != 1 || !(arrobject[0] instanceof X509TrustManager)) break block13;
                X509TrustManager x509TrustManager = (X509TrustManager)arrobject[0];
                SSLContext sSLContext = f.a.h();
                sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                this.q = sSLSocketFactory = sSLContext.getSocketFactory();
                c2 = f.a.c(x509TrustManager);
            }
            this.r = c2;
            SSLSocketFactory sSLSocketFactory = this.q;
            if (sSLSocketFactory != null) {
                f.a.e(sSLSocketFactory);
            }
            this.s = b2.j;
            i.f f2 = b2.k;
            c c3 = this.r;
            if (!i.f0.c.m(f2.b, c3)) {
                f2 = new i.f(f2.a, c3);
            }
            this.t = f2;
            this.u = b2.l;
            this.v = b2.m;
            this.w = b2.n;
            this.x = b2.o;
            this.y = b2.p;
            this.z = b2.q;
            this.A = b2.r;
            this.B = b2.s;
            this.C = b2.t;
            this.D = b2.u;
            this.E = b2.v;
            this.F = b2.w;
            if (this.i.contains(null)) {
                StringBuilder stringBuilder = c.b.a.a.a.c("Null interceptor: ");
                stringBuilder.append(this.i);
                throw new IllegalStateException(stringBuilder.toString());
            }
            if (!this.j.contains(null)) {
                return;
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("Null network interceptor: ");
            stringBuilder.append(this.j);
            throw new IllegalStateException(stringBuilder.toString());
            catch (GeneralSecurityException generalSecurityException) {
                throw i.f0.c.a("No System TLS", (Exception)((Object)generalSecurityException));
            }
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected default trust managers:");
            stringBuilder.append(Arrays.toString((Object[])arrobject));
            throw new IllegalStateException(stringBuilder.toString());
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw i.f0.c.a("No System TLS", (Exception)((Object)generalSecurityException));
        }
    }

    public i.e a(x x2) {
        w w2 = new w(this, x2, false);
        w2.h = ((o)this.k).a;
        return w2;
    }

    public static final class b {
        public l a = new l();
        public List<v> b = u.G;
        public List<i> c = u.H;
        public final List<s> d = new ArrayList();
        public final List<s> e = new ArrayList();
        public n.b f = new o(n.a);
        public ProxySelector g;
        public k h;
        public SocketFactory i;
        public HostnameVerifier j;
        public i.f k;
        public i.b l;
        public i.b m;
        public h n;
        public m o;
        public boolean p;
        public boolean q;
        public boolean r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;

        public b() {
            i.b b2;
            ProxySelector proxySelector;
            this.g = proxySelector = ProxySelector.getDefault();
            if (proxySelector == null) {
                this.g = new i.f0.j.a();
            }
            this.h = k.a;
            this.i = SocketFactory.getDefault();
            this.j = d.a;
            this.k = i.f.c;
            this.l = b2 = i.b.a;
            this.m = b2;
            this.n = new h(5, 5L, TimeUnit.MINUTES);
            this.o = m.a;
            this.p = true;
            this.q = true;
            this.r = true;
            this.s = 0;
            this.t = 10000;
            this.u = 10000;
            this.v = 10000;
            this.w = 0;
        }
    }

}

