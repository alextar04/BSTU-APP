/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  d.a.j1.a
 *  d.a.j1.b
 *  f.b.k.h
 *  h.d
 *  h.d$a
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.NoSuchMethodException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Method
 */
package d.a.j1;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import d.a.j1.a;
import d.a.j1.b;
import f.b.k.h;
import h.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class c {
    public static {
        Object object;
        try {
            object = new a(c.a(Looper.getMainLooper(), true), null, false);
        }
        catch (Throwable throwable) {
            object = h.i.K(throwable);
        }
        Object object2 = object instanceof d.a ? null : object;
        (b)object2;
    }

    public static final Handler a(Looper looper, boolean bl) {
        if (bl) {
            Constructor constructor;
            if (Build.VERSION.SDK_INT >= 28) {
                Object object = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{looper});
                if (object != null) {
                    return (Handler)object;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
            }
            try {
                Class[] arrclass = new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE};
                constructor = Handler.class.getDeclaredConstructor(arrclass);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                return new Handler(looper);
            }
            Object[] arrobject = new Object[]{looper, null, Boolean.TRUE};
            return (Handler)constructor.newInstance(arrobject);
        }
        return new Handler(looper);
    }
}

