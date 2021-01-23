/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package k.a.z0;

public final class p0 {
    public final boolean a;
    public final String b;
    public final String c;
    public final int d;

    public p0(b b2, a a2) {
        this.a = b2.a;
        String string = b2.b;
        if (string == null) {
            string = System.getProperty((String)"line.separator");
        }
        this.b = string;
        this.c = b2.c;
        this.d = b2.d;
    }

    public static final class b {
        public boolean a;
        public String b = System.getProperty((String)"line.separator");
        public String c = "  ";
        public int d;

        public b(a a2) {
        }
    }

}

