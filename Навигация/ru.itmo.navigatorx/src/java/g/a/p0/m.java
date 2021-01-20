/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.p0;

import android.content.Context;
import c.d.a.e;
import c.d.a.f;
import java.io.File;

public class m {
    public static final String a = File.separator;
    public static final String b = File.pathSeparator;
    public static boolean c = false;

    public static void a(Context context) {
        Class<m> class_ = m.class;
        synchronized (m.class) {
            block4 : {
                boolean bl = c;
                if (!bl) break block4;
                return;
            }
            new f().c(context, "realm-jni", "10.0.0", null);
            c = true;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return;
        }
    }
}

