/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package f.t;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import f.t.b;
import f.t.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {
    public final f.e.a<String, Method> a;
    public final f.e.a<String, Method> b;
    public final f.e.a<String, Class> c;

    public a(f.e.a<String, Method> a2, f.e.a<String, Method> a3, f.e.a<String, Class> a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public abstract void a();

    public abstract a b();

    public final Class c(Class<? extends c> class_) {
        Class class_2 = this.c.getOrDefault(class_.getName(), null);
        if (class_2 == null) {
            String string = class_.getPackage().getName();
            Object[] arrobject = new Object[]{string, class_.getSimpleName()};
            class_2 = Class.forName((String)String.format((String)"%s.%sParcelizer", (Object[])arrobject), (boolean)false, (ClassLoader)class_.getClassLoader());
            this.c.put(class_.getName(), class_2);
        }
        return class_2;
    }

    public final Method d(String string) {
        Method method = this.a.getOrDefault(string, null);
        if (method == null) {
            System.currentTimeMillis();
            method = Class.forName((String)string, (boolean)true, (ClassLoader)a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{a.class});
            this.a.put(string, method);
        }
        return method;
    }

    public final Method e(Class class_) {
        Method method = this.b.getOrDefault(class_.getName(), null);
        if (method == null) {
            Class class_2 = this.c((Class<? extends c>)class_);
            System.currentTimeMillis();
            method = class_2.getDeclaredMethod("write", new Class[]{class_, a.class});
            this.b.put(class_.getName(), method);
        }
        return method;
    }

    public boolean f(boolean bl, int n2) {
        if (!this.h(n2)) {
            return bl;
        }
        return ((b)this).e.readInt() != 0;
    }

    public CharSequence g(CharSequence charSequence, int n2) {
        if (!this.h(n2)) {
            return charSequence;
        }
        b b2 = (b)this;
        return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(b2.e);
    }

    public abstract boolean h(int var1);

    public int i(int n2, int n3) {
        if (!this.h(n3)) {
            return n2;
        }
        return ((b)this).e.readInt();
    }

    public <T extends Parcelable> T j(T t2, int n2) {
        if (!this.h(n2)) {
            return t2;
        }
        return (T)((b)this).e.readParcelable(b.class.getClassLoader());
    }

    public <T extends c> T k() {
        c c2;
        String string = ((b)this).e.readString();
        if (string == null) {
            return null;
        }
        a a2 = this.b();
        try {
            c2 = (c)this.d(string).invoke(null, new Object[]{a2});
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", (Throwable)classNotFoundException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", (Throwable)noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof RuntimeException) {
                throw (RuntimeException)invocationTargetException.getCause();
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", (Throwable)illegalAccessException);
        }
        return (T)c2;
    }

    public abstract void l(int var1);

    public void m(int n2, int n3) {
        this.l(n3);
        ((b)this).e.writeInt(n2);
    }

    public void n(Parcelable parcelable, int n2) {
        this.l(n2);
        ((b)this).e.writeParcelable(parcelable, 0);
    }

    public void o(c c2) {
        Class class_;
        if (c2 == null) {
            ((b)this).e.writeString(null);
            return;
        }
        try {
            class_ = this.c((Class<? extends c>)c2.getClass());
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c2.getClass().getSimpleName());
            stringBuilder.append(" does not have a Parcelizer");
            throw new RuntimeException(stringBuilder.toString(), (Throwable)classNotFoundException);
        }
        String string = class_.getName();
        ((b)this).e.writeString(string);
        a a2 = this.b();
        try {
            this.e(c2.getClass()).invoke(null, new Object[]{c2, a2});
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", (Throwable)classNotFoundException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", (Throwable)noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof RuntimeException) {
                throw (RuntimeException)invocationTargetException.getCause();
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", (Throwable)illegalAccessException);
        }
        a2.a();
        return;
    }
}

