/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 */
package c.c.a.m;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface m {
    public static final Charset a = Charset.forName((String)"UTF-8");

    public void a(MessageDigest var1);

    public boolean equals(Object var1);

    public int hashCode();
}

