/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package c.d.a;

import c.d.a.d;

public final class h
implements d {
    public String a(String string) {
        if (string.startsWith("lib") && string.endsWith(".so")) {
            return string;
        }
        return System.mapLibraryName((String)string);
    }
}

