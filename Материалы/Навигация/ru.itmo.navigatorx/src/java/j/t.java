/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package j;

import j.s;

public final class t {
    public static s a;
    public static long b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(s s2) {
        if (s2.f == null && s2.g == null) {
            if (s2.d) {
                return;
            }
            Class<t> class_ = t.class;
            synchronized (t.class) {
                if (8192L + b > 65536L) {
                    // ** MonitorExit[var2_1] (shouldn't be in output)
                    return;
                }
                b = 8192L + b;
                s2.f = a;
                s2.c = 0;
                s2.b = 0;
                a = s2;
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static s b() {
        Class<t> class_ = t.class;
        synchronized (t.class) {
            if (a != null) {
                s s2 = a;
                a = s2.f;
                s2.f = null;
                b -= 8192L;
                // ** MonitorExit[var2] (shouldn't be in output)
                return s2;
            }
            // ** MonitorExit[var2] (shouldn't be in output)
            return new s();
        }
    }
}

