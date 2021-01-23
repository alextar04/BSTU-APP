/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Arrays
 */
package h.m.b;

import c.b.a.a.a;
import h.g;
import java.util.Arrays;

public class j {
    public static boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static void b(Object object, String string) {
        if (object != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(a.j(string, " must not be null"));
        j.h(illegalStateException);
        throw illegalStateException;
    }

    public static void c(Object object) {
        if (object != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        j.h(nullPointerException);
        throw nullPointerException;
    }

    public static void d(Object object, String string) {
        if (object != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(a.j(string, " must not be null"));
        j.h(nullPointerException);
        throw nullPointerException;
    }

    public static void e(Object object, String string) {
        if (object != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(j.g(string));
        j.h(nullPointerException);
        throw nullPointerException;
    }

    public static void f(Object object, String string) {
        if (object != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(j.g(string));
        j.h(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static String g(String string) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String string2 = stackTraceElement.getClassName();
        String string3 = stackTraceElement.getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        stringBuilder.append(string3);
        stringBuilder.append(", parameter ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static <T extends Throwable> T h(T t2) {
        j.i(t2, j.class.getName());
        return t2;
    }

    public static <T extends Throwable> T i(T t2, String string) {
        Object[] arrobject = t2.getStackTrace();
        int n2 = arrobject.length;
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.equals((Object)arrobject[i2].getClassName())) continue;
            n3 = i2;
        }
        t2.setStackTrace((StackTraceElement[])Arrays.copyOfRange((Object[])arrobject, (int)(n3 + 1), (int)n2));
        return t2;
    }

    public static void j(String string) {
        g g2 = new g(a.k("lateinit property ", string, " has not been initialized"));
        j.h(g2);
        throw g2;
    }
}

