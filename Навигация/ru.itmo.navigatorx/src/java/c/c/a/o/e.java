/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.o.c
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 */
package c.c.a.o;

import c.b.a.a.a;
import c.c.a.o.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Deprecated
public final class e {
    public static c a(String string) {
        Class class_;
        Object object;
        try {
            class_ = Class.forName((String)string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", (Throwable)classNotFoundException);
        }
        try {
            object = class_.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (InvocationTargetException invocationTargetException) {
            e.b(class_, (Exception)((Object)invocationTargetException));
            throw null;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            e.b(class_, (Exception)((Object)noSuchMethodException));
            throw null;
        }
        catch (IllegalAccessException illegalAccessException) {
            e.b(class_, (Exception)((Object)illegalAccessException));
            throw null;
        }
        catch (InstantiationException instantiationException) {
            e.b(class_, (Exception)((Object)instantiationException));
            throw null;
        }
        if (object instanceof c) {
            return (c)object;
        }
        throw new RuntimeException(a.i("Expected instanceof GlideModule, but found: ", object));
    }

    public static void b(Class<?> class_, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to instantiate GlideModule implementation for ");
        stringBuilder.append(class_);
        throw new RuntimeException(stringBuilder.toString(), (Throwable)exception);
    }
}

