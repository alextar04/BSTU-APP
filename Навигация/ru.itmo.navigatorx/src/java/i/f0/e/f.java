/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.ProxySelector
 *  java.net.SocketAddress
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.Set
 */
package i.f0.e;

import i.d0;
import i.e;
import i.f0.c;
import i.f0.e.d;
import i.n;
import i.r;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class f {
    public final i.a a;
    public final d b;
    public final e c;
    public final n d;
    public List<Proxy> e = Collections.emptyList();
    public int f;
    public List<InetSocketAddress> g = Collections.emptyList();
    public final List<d0> h = new ArrayList();

    public f(i.a a2, d d2, e e2, n n2) {
        Object object;
        this.a = a2;
        this.b = d2;
        this.c = e2;
        this.d = n2;
        r r2 = a2.a;
        Proxy proxy = a2.h;
        if (proxy != null) {
            object = Collections.singletonList((Object)proxy);
        } else {
            List list = a2.g.select(r2.o());
            if (list != null && !list.isEmpty()) {
                object = c.p(list);
            } else {
                Proxy[] arrproxy = new Proxy[]{Proxy.NO_PROXY};
                object = c.q(arrproxy);
            }
        }
        this.e = object;
        this.f = 0;
    }

    public void a(d0 d02, IOException iOException) {
        d d2;
        if (d02.b.type() != Proxy.Type.DIRECT) {
            i.a a2 = this.a;
            ProxySelector proxySelector = a2.g;
            if (proxySelector != null) {
                proxySelector.connectFailed(a2.a.o(), d02.b.address(), iOException);
            }
        }
        d d3 = d2 = this.b;
        synchronized (d3) {
            d2.a.add((Object)d02);
            return;
        }
    }

    public boolean b() {
        return this.c() || !this.h.isEmpty();
        {
        }
    }

    public final boolean c() {
        return this.f < this.e.size();
    }

    public static final class a {
        public final List<d0> a;
        public int b = 0;

        public a(List<d0> list) {
            this.a = list;
        }

        public boolean a() {
            return this.b < this.a.size();
        }
    }

}

