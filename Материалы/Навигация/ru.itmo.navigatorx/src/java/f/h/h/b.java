/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
package f.h.h;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class b {
    public static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class[] arrclass = new Class[]{Long.TYPE};
                Trace.class.getMethod("isTagEnabled", arrclass);
                Class[] arrclass2 = new Class[]{Long.TYPE, String.class, Integer.TYPE};
                Trace.class.getMethod("asyncTraceBegin", arrclass2);
                Class[] arrclass3 = new Class[]{Long.TYPE, String.class, Integer.TYPE};
                Trace.class.getMethod("asyncTraceEnd", arrclass3);
                Class[] arrclass4 = new Class[]{Long.TYPE, String.class, Integer.TYPE};
                Trace.class.getMethod("traceCounter", arrclass4);
            }
            catch (Exception exception) {
                Log.i((String)"TraceCompat", (String)"Unable to initialize via reflection.", (Throwable)exception);
            }
        }
    }

    public static void a(String string) {
        Trace.beginSection((String)string);
    }

    public static void b() {
        Trace.endSection();
    }
}

