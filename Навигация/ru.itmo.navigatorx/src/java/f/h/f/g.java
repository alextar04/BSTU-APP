/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.fonts.FontVariationAxis
 *  android.os.CancellationSignal
 *  android.util.Log
 *  f.h.e.b.c
 *  f.h.f.e
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.nio.ByteBuffer
 */
package f.h.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.util.Log;
import c.b.a.a.a;
import f.h.e.b.c;
import f.h.e.b.d;
import f.h.f.e;
import f.h.f.j;
import f.h.i.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class g
extends e {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public g() {
        Method method;
        Method method2;
        Class class_;
        Method method3;
        Method method4;
        Method method5;
        Constructor constructor;
        block3 : {
            void var2_12;
            class_ = null;
            try {
                Method method6;
                Class class_2 = Class.forName((String)"android.graphics.FontFamily");
                constructor = class_2.getConstructor(new Class[0]);
                method2 = this.o(class_2);
                method3 = this.p(class_2);
                method = class_2.getMethod("freeze", new Class[0]);
                method4 = class_2.getMethod("abortCreation", new Class[0]);
                method5 = method6 = this.q(class_2);
                class_ = class_2;
                break block3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            StringBuilder stringBuilder = a.c("Unable to collect necessary methods for class ");
            stringBuilder.append(var2_12.getClass().getName());
            Log.e((String)"TypefaceCompatApi26Impl", (String)stringBuilder.toString(), (Throwable)var2_12);
            method5 = null;
            method4 = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method = null;
        }
        this.g = class_;
        this.h = constructor;
        this.i = method2;
        this.j = method3;
        this.k = method;
        this.l = method4;
        this.m = method5;
    }

    private Object n() {
        try {
            Object object = this.h.newInstance(new Object[0]);
            return object;
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException throwable) {
            return null;
        }
    }

    public Typeface a(Context context, c c2, Resources resources, int n2) {
        if (!this.m()) {
            return super.a(context, c2, resources, n2);
        }
        Object object = this.n();
        if (object == null) {
            return null;
        }
        for (d d2 : c2.a) {
            if (this.j(context, object, d2.a, d2.e, d2.b, (int)d2.c, FontVariationAxis.fromFontVariationSettings((String)d2.d))) continue;
            this.i(object);
            return null;
        }
        if (!this.l(object)) {
            return null;
        }
        return this.k(object);
    }

    /*
     * Exception decompiling
     */
    public Typeface b(Context var1, CancellationSignal var2, b.f[] var3, int var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl145 : ILOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public Typeface d(Context context, Resources resources, int n2, String string, int n3) {
        if (!this.m()) {
            return j.super.d(context, resources, n2, string, n3);
        }
        Object object = this.n();
        if (object == null) {
            return null;
        }
        if (!this.j(context, object, string, 0, -1, -1, null)) {
            this.i(object);
            return null;
        }
        if (!this.l(object)) {
            return null;
        }
        return this.k(object);
    }

    public final void i(Object object) {
        try {
            this.l.invoke(object, new Object[0]);
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {}
    }

    public final boolean j(Context context, Object object, String string, int n2, int n3, int n4, FontVariationAxis[] arrfontVariationAxis) {
        try {
            Method method = this.i;
            Object[] arrobject = new Object[]{context.getAssets(), string, 0, Boolean.FALSE, n2, n3, n4, arrfontVariationAxis};
            boolean bl = (Boolean)method.invoke(object, arrobject);
            return bl;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return false;
        }
    }

    public Typeface k(Object object) {
        try {
            Object object2 = Array.newInstance(this.g, (int)1);
            Array.set((Object)object2, (int)0, (Object)object);
            Method method = this.m;
            Object[] arrobject = new Object[]{object2, -1, -1};
            Typeface typeface = (Typeface)method.invoke(null, arrobject);
            return typeface;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return null;
        }
    }

    public final boolean l(Object object) {
        try {
            boolean bl = (Boolean)this.k.invoke(object, new Object[0]);
            return bl;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return false;
        }
    }

    public final boolean m() {
        if (this.i == null) {
            Log.w((String)"TypefaceCompatApi26Impl", (String)"Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    public Method o(Class<?> class_) {
        Class class_2 = Integer.TYPE;
        Class[] arrclass = new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, class_2, class_2, class_2, FontVariationAxis[].class};
        return class_.getMethod("addFontFromAssetManager", arrclass);
    }

    public Method p(Class<?> class_) {
        Class class_2 = Integer.TYPE;
        Class[] arrclass = new Class[]{ByteBuffer.class, class_2, FontVariationAxis[].class, class_2, class_2};
        return class_.getMethod("addFontFromBuffer", arrclass);
    }

    public Method q(Class<?> class_) {
        Class class_2;
        Object object = Array.newInstance(class_, (int)1);
        Class[] arrclass = new Class[]{object.getClass(), class_2 = Integer.TYPE, class_2};
        Method method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arrclass);
        method.setAccessible(true);
        return method;
    }
}

