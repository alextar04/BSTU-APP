/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j.a
 *  j.b
 *  j.c
 *  j.f
 *  j.g
 *  j.n
 *  j.o$a
 *  j.p
 *  j.q
 *  j.r
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.util.logging.Logger
 */
package j;

import j.b;
import j.c;
import j.f;
import j.g;
import j.n;
import j.o;
import j.p;
import j.q;
import j.r;
import j.v;
import j.w;
import j.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class o {
    public static final Logger a = Logger.getLogger((String)o.class.getName());

    public static f a(v v2) {
        return new q(v2);
    }

    public static g b(w w2) {
        return new r(w2);
    }

    public static boolean c(AssertionError assertionError) {
        return assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains((CharSequence)"getsockname failed");
    }

    public static v d(Socket socket) {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                p p2 = new p(socket);
                OutputStream outputStream = socket.getOutputStream();
                if (outputStream != null) {
                    return new j.a((c)p2, (v)new n((x)p2, outputStream));
                }
                throw new IllegalArgumentException("out == null");
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static w e(InputStream inputStream, x x2) {
        if (inputStream != null) {
            return new a(x2, inputStream);
        }
        throw new IllegalArgumentException("in == null");
    }

    public static w f(Socket socket) {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                p p2 = new p(socket);
                return new b((c)p2, o.e(socket.getInputStream(), (x)p2));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }
}

