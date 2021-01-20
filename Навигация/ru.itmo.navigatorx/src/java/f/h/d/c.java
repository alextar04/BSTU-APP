/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package f.h.d;

import android.util.Log;
import f.h.d.b;
import java.lang.reflect.Method;

public class c
implements Runnable {
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public c(Object object, Object object2) {
        this.e = object;
        this.f = object2;
    }

    public void run() {
        try {
            if (b.d != null) {
                Method method = b.d;
                Object object = this.e;
                Object[] arrobject = new Object[]{this.f, Boolean.FALSE, "AppCompat recreation"};
                method.invoke(object, arrobject);
                return;
            }
            Method method = b.e;
            Object object = this.e;
            Object[] arrobject = new Object[]{this.f, Boolean.FALSE};
            method.invoke(object, arrobject);
            return;
        }
        catch (Throwable throwable) {
            Log.e((String)"ActivityRecreator", (String)"Exception while invoking performStopActivity", (Throwable)throwable);
            return;
        }
        catch (RuntimeException runtimeException) {
            if (runtimeException.getClass() == RuntimeException.class && runtimeException.getMessage() != null) {
                if (!runtimeException.getMessage().startsWith("Unable to stop")) {
                    return;
                }
                throw runtimeException;
            }
            return;
        }
    }
}

