/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.e.b;

import c.e.b.c;

public abstract class c
extends Enum<c>
implements c.e.b.d {
    public static final /* enum */ c e;
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    public static final /* enum */ c h;
    public static final /* enum */ c i;
    public static final /* enum */ c j;
    public static final /* synthetic */ c[] k;

    public static {
        c c2;
        e = new c(){

            public String a(java.lang.reflect.Field field) {
                return field.getName();
            }
        };
        f = new c(){

            public String a(java.lang.reflect.Field field) {
                return c.c(field.getName());
            }
        };
        g = new c(){

            public String a(java.lang.reflect.Field field) {
                return c.c(c.b(field.getName(), " "));
            }
        };
        h = new c(){

            public String a(java.lang.reflect.Field field) {
                return c.b(field.getName(), "_").toLowerCase(java.util.Locale.ENGLISH);
            }
        };
        i = new c(){

            public String a(java.lang.reflect.Field field) {
                return c.b(field.getName(), "-").toLowerCase(java.util.Locale.ENGLISH);
            }
        };
        j = c2 = new c(){

            public String a(java.lang.reflect.Field field) {
                return c.b(field.getName(), ".").toLowerCase(java.util.Locale.ENGLISH);
            }
        };
        c[] arrc = new c[]{e, f, g, h, i, c2};
        k = arrc;
    }

    public c(a a2) {
    }

    public static String b(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (Character.isUpperCase((char)c2) && stringBuilder.length() != 0) {
                stringBuilder.append(string2);
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static String c(String string) {
        int n2;
        int n3 = string.length() - 1;
        for (n2 = 0; !Character.isLetter((char)string.charAt(n2)) && n2 < n3; ++n2) {
        }
        char c2 = string.charAt(n2);
        if (Character.isUpperCase((char)c2)) {
            return string;
        }
        char c3 = Character.toUpperCase((char)c2);
        if (n2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c3);
            stringBuilder.append(string.substring(1));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, n2));
        stringBuilder.append(c3);
        stringBuilder.append(string.substring(n2 + 1));
        return stringBuilder.toString();
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])k.clone();
    }
}

