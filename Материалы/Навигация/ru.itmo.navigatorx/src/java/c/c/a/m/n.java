/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  c.c.a.m.n$a
 *  f.b.k.h
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 */
package c.c.a.m;

import android.text.TextUtils;
import c.c.a.m.n;
import f.b.k.h;
import java.security.MessageDigest;

public final class n<T> {
    public static final b<Object> e = new a();
    public final T a;
    public final b<T> b;
    public final String c;
    public volatile byte[] d;

    public n(String string, T t2, b<T> b2) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.c = string;
            this.a = t2;
            h.i.p(b2, "Argument must not be null");
            this.b = b2;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T> n<T> a(String string, T t2) {
        return new n<Object>(string, t2, e);
    }

    public boolean equals(Object object) {
        if (object instanceof n) {
            n n2 = (n)object;
            return this.c.equals((Object)n2.c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Option{key='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static interface b<T> {
        public void a(byte[] var1, T var2, MessageDigest var3);
    }

}

