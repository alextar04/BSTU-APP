/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.net.SocketAddress
 *  java.net.URI
 *  java.util.Collections
 *  java.util.List
 */
package i.f0.j;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

public class a
extends ProxySelector {
    public void connectFailed(URI uRI, SocketAddress socketAddress, IOException iOException) {
    }

    public List<Proxy> select(URI uRI) {
        if (uRI != null) {
            return Collections.singletonList((Object)Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null");
    }
}

