/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package k.a.z0;

public final class s
extends Enum<s> {
    @Deprecated
    public static final /* enum */ s e;
    public static final /* enum */ s f;
    public static final /* enum */ s g;
    public static final /* enum */ s h;
    public static final /* synthetic */ s[] i;

    public static {
        s s2;
        e = new s();
        f = new s();
        g = new s();
        h = s2 = new s();
        s[] arrs = new s[]{e, f, g, s2};
        i = arrs;
    }

    public static s valueOf(String string) {
        return (s)Enum.valueOf(s.class, (String)string);
    }

    public static s[] values() {
        return (s[])i.clone();
    }
}

