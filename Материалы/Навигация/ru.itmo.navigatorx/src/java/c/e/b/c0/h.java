/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 */
package c.e.b.c0;

import c.b.a.a.a;
import c.e.b.c0.g;
import c.e.b.c0.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class h
implements t<T> {
    public final /* synthetic */ Constructor a;

    public h(g g2, Constructor constructor) {
        this.a = constructor;
    }

    @Override
    public T a() {
        Object object;
        try {
            object = this.a.newInstance(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError((Object)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            StringBuilder stringBuilder = a.c("Failed to invoke ");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(" with no args");
            throw new RuntimeException(stringBuilder.toString(), invocationTargetException.getTargetException());
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = a.c("Failed to invoke ");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(" with no args");
            throw new RuntimeException(stringBuilder.toString(), (Throwable)instantiationException);
        }
        return (T)object;
    }
}

