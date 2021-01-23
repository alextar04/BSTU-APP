/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  f.b.p.f
 *  f.b.p.y
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Method
 */
package f.b.k;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import f.b.p.d;
import f.b.p.f;
import f.b.p.g;
import f.b.p.q;
import f.b.p.y;
import f.e.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class p {
    public static final Class<?>[] b = new Class[]{Context.class, AttributeSet.class};
    public static final int[] c = new int[]{16843375};
    public static final String[] d = new String[]{"android.widget.", "android.view.", "android.webkit."};
    public static final h<String, Constructor<? extends View>> e = new h();
    public final Object[] a = new Object[2];

    public d a(Context context, AttributeSet attributeSet) {
        return new d(context, attributeSet);
    }

    public f b(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    public g c(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    public q d(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet, f.b.a.radioButtonStyle);
    }

    public y e(Context context, AttributeSet attributeSet) {
        return new y(context, attributeSet);
    }

    public View f() {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final View g(Context context, String string, String string2) {
        Constructor constructor = e.getOrDefault(string, null);
        if (constructor == null) {
            String string3;
            if (string2 != null) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(string);
                    string3 = stringBuilder.toString();
                }
                catch (Exception exception) {
                    return null;
                }
            } else {
                string3 = string;
            }
            constructor = Class.forName((String)string3, (boolean)false, (ClassLoader)context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            e.put(string, (Constructor<? extends View>)constructor);
        }
        constructor.setAccessible(true);
        return (View)constructor.newInstance(this.a);
    }

    public final void h(View view, String string) {
        if (view != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(" asked to inflate view for <");
        stringBuilder.append(string);
        stringBuilder.append(">, but returned null");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static class a
    implements View.OnClickListener {
        public final View e;
        public final String f;
        public Method g;
        public Context h;

        public a(View view, String string) {
            this.e = view;
            this.f = string;
        }

        /*
         * Exception decompiling
         */
        public void onClick(View var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl34.1 : ALOAD : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
    }

}

