/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.System
 */
package d.a.a;

public final class q {
    public static final int a = Runtime.getRuntime().availableProcessors();

    public static final String a(String string) {
        try {
            String string2 = System.getProperty((String)string);
            return string2;
        }
        catch (SecurityException securityException) {
            return null;
        }
    }
}

