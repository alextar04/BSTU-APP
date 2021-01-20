/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.c.a.m;

import c.b.a.a.a;
import java.io.IOException;

public final class e
extends IOException {
    public e(int n2) {
        super(a.b("Http request failed with status code: ", n2), null);
    }

    public e(String string) {
        super(string, null);
    }

    public e(String string, int n2) {
        super(string, null);
    }
}

