/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  javax.net.ssl.SSLSocketFactory
 */
package i;

import i.a;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.net.ssl.SSLSocketFactory;

public final class d0 {
    public final a a;
    public final Proxy b;
    public final InetSocketAddress c;

    public d0(a a2, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (a2 != null) {
            if (inetSocketAddress != null) {
                this.a = a2;
                this.b = proxy;
                this.c = inetSocketAddress;
                return;
            }
            throw new NullPointerException("inetSocketAddress == null");
        }
        throw new NullPointerException("address == null");
    }

    public boolean a() {
        return this.a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object object) {
        if (object instanceof d0) {
            d0 d02 = (d0)object;
            if (d02.a.equals(this.a) && d02.b.equals((Object)this.b) && d02.c.equals((Object)this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Route{");
        stringBuilder.append((Object)this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

