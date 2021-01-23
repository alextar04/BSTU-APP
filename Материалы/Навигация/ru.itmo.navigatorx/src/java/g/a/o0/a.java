/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.q0.h.g
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package g.a.o0;

import g.a.b0;
import g.a.q0.h.g;

public class a
extends RuntimeException {
    public a(g g2, Throwable throwable) {
        StringBuilder stringBuilder = c.b.a.a.a.c("Realm was interrupted while downloading the latest changes from the server: ");
        stringBuilder.append(g2.c);
        super(stringBuilder.toString(), throwable);
    }
}

