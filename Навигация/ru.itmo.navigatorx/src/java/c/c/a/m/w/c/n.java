/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.m.w.c;

import android.os.Build;
import android.util.Log;
import java.io.File;

public final class n {
    public static final File f = new File("/proc/self/fd");
    public static volatile n g;
    public final boolean a;
    public final int b;
    public final int c;
    public int d;
    public boolean e;

    public n() {
        boolean bl;
        this.e = bl = true;
        String string = Build.MODEL;
        if (string != null && string.length() >= 7) {
            String string2 = Build.MODEL.substring(0, 7);
            int n2 = -1;
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case -1398222624: {
                    if (!string2.equals((Object)"SM-N935")) break;
                    n2 = 0;
                    break;
                }
                case -1398343746: {
                    if (!string2.equals((Object)"SM-J720")) break;
                    n2 = bl ? 1 : 0;
                    break;
                }
                case -1398431068: {
                    if (!string2.equals((Object)"SM-G965")) break;
                    n2 = 3;
                    break;
                }
                case -1398431073: {
                    if (!string2.equals((Object)"SM-G960")) break;
                    n2 = 2;
                    break;
                }
                case -1398431161: {
                    if (!string2.equals((Object)"SM-G935")) break;
                    n2 = 4;
                    break;
                }
                case -1398431166: {
                    if (!string2.equals((Object)"SM-G930")) break;
                    n2 = 5;
                    break;
                }
                case -1398613787: {
                    if (!string2.equals((Object)"SM-A520")) break;
                    n2 = 6;
                }
            }
            switch (n2) {
                default: {
                    break;
                }
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: {
                    if (Build.VERSION.SDK_INT != 26) break;
                    bl = false;
                }
            }
        }
        this.a = bl;
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.c = 0;
            return;
        }
        this.b = 700;
        this.c = 128;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static n a() {
        if (g != null) return g;
        Class<n> class_ = n.class;
        synchronized (n.class) {
            if (g != null) return g;
            g = new n();
            // ** MonitorExit[var1] (shouldn't be in output)
            return g;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean b(int n2, int n3, boolean bl, boolean bl2) {
        int n4;
        if (!bl) return false;
        if (!this.a) return false;
        if (Build.VERSION.SDK_INT < 26) return false;
        if (bl2) {
            return false;
        }
        int n5 = this.c;
        if (n2 < n5) return false;
        if (n3 < n5) return false;
        n n6 = this;
        // MONITORENTER : n6
        this.d = n4 = 1 + this.d;
        if (n4 >= 50) {
            this.d = 0;
            int n7 = f.list().length;
            boolean bl3 = n7 < this.b;
            this.e = bl3;
            if (!bl3 && Log.isLoggable((String)"Downsampler", (int)5)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                stringBuilder.append(n7);
                stringBuilder.append(", limit ");
                stringBuilder.append(this.b);
                Log.w((String)"Downsampler", (String)stringBuilder.toString());
            }
        }
        boolean bl4 = this.e;
        // MONITOREXIT : n6
        if (!bl4) return false;
        return true;
    }
}

