/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package g.a;

public final class n
extends Enum<n> {
    public static final /* enum */ n e;
    public static final /* synthetic */ n[] f;

    public static {
        n n2;
        e = n2 = new n();
        f = new n[]{n2};
    }

    public static n valueOf(String string) {
        return (n)Enum.valueOf(n.class, (String)string);
    }

    public static n[] values() {
        return (n[])f.clone();
    }
}

