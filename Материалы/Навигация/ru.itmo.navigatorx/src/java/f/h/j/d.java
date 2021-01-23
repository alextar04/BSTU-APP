/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.h.j.d$a
 *  f.h.j.d$d
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package f.h.j;

import f.h.j.c;
import f.h.j.d;

/*
 * Exception performing whole class analysis.
 */
public final class d {
    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;

    public static {
        a = new /* Unavailable Anonymous Inner Class!! */;
        b = new /* Unavailable Anonymous Inner Class!! */;
        c = new /* Unavailable Anonymous Inner Class!! */;
        d = new /* Unavailable Anonymous Inner Class!! */;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(int n2) {
        if (n2 == 0) return 1;
        if (n2 == 1 || n2 == 2) return 0;
        switch (n2) {
            default: {
                return 2;
            }
            case 16: 
            case 17: {
                return 0;
            }
            case 14: 
            case 15: 
        }
        return 1;
    }

    public static interface b {
        public int a(CharSequence var1, int var2, int var3);
    }

}

