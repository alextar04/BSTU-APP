/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Layout
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextPaint
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.widget.TextView
 *  f.b.p.z$a
 *  f.b.p.z$b
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.ConcurrentHashMap
 */
package f.b.p;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import f.b.p.k;
import f.b.p.z;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Exception performing whole class analysis.
 */
public class z {
    public static final RectF l;
    public static ConcurrentHashMap<String, Method> m;
    public static ConcurrentHashMap<String, Field> n;
    public int a;
    public boolean b;
    public float c;
    public float d;
    public float e;
    public int[] f;
    public boolean g;
    public TextPaint h;
    public final TextView i;
    public final Context j;
    public final c k;

    public static {
        l = new RectF();
        m = new ConcurrentHashMap();
        n = new ConcurrentHashMap();
    }

    public z(TextView textView) {
        this.a = 0;
        this.b = false;
        this.c = -1.0f;
        this.d = -1.0f;
        this.e = -1.0f;
        this.f = new int[0];
        this.g = false;
        this.i = textView;
        this.j = textView.getContext();
        Object object = Build.VERSION.SDK_INT >= 29 ? new /* Unavailable Anonymous Inner Class!! */ : new /* Unavailable Anonymous Inner Class!! */;
        this.k = object;
    }

    public static Method d(String string) {
        Method method;
        block4 : {
            try {
                method = (Method)m.get((Object)string);
                if (method != null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to retrieve TextView#");
                stringBuilder.append(string);
                stringBuilder.append("() method");
                Log.w((String)"ACTVAutoSizeHelper", (String)stringBuilder.toString(), (Throwable)exception);
                return null;
            }
            method = TextView.class.getDeclaredMethod(string, new Class[0]);
            if (method == null) break block4;
            method.setAccessible(true);
            m.put((Object)string, (Object)method);
        }
        return method;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> T e(Object object, String string, T t2) {
        Object object2;
        try {
            object2 = z.d(string).invoke(object, new Object[0]);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to invoke TextView#");
            stringBuilder.append(string);
            stringBuilder.append("() method");
            Log.w((String)"ACTVAutoSizeHelper", (String)stringBuilder.toString(), (Throwable)exception);
            return t2;
        }
        return (T)object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        if (!this.i()) return;
        if (this.a == 0) return;
        boolean bl = true;
        if (!bl) {
            return;
        }
        if (this.b) {
            RectF rectF;
            if (this.i.getMeasuredHeight() <= 0) return;
            if (this.i.getMeasuredWidth() <= 0) {
                return;
            }
            int n2 = this.k.b(this.i) ? 1048576 : this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft() - this.i.getTotalPaddingRight();
            int n3 = this.i.getHeight() - this.i.getCompoundPaddingBottom() - this.i.getCompoundPaddingTop();
            if (n2 <= 0) return;
            if (n3 <= 0) {
                return;
            }
            RectF rectF2 = rectF = l;
            synchronized (rectF2) {
                l.setEmpty();
                z.l.right = n2;
                z.l.bottom = n3;
                float f2 = this.c(l);
                if (f2 != this.i.getTextSize()) {
                    this.f(0, f2);
                }
            }
        }
        this.b = true;
    }

    public final int[] b(int[] arrn) {
        int n2 = arrn.length;
        if (n2 == 0) {
            return arrn;
        }
        Arrays.sort((int[])arrn);
        ArrayList arrayList = new ArrayList();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = arrn[i2];
            if (n4 <= 0 || Collections.binarySearch((List)arrayList, (Object)n4) >= 0) continue;
            arrayList.add((Object)n4);
        }
        if (n2 == arrayList.size()) {
            return arrn;
        }
        int n5 = arrayList.size();
        int[] arrn2 = new int[n5];
        while (n3 < n5) {
            arrn2[n3] = (Integer)arrayList.get(n3);
            ++n3;
        }
        return arrn2;
    }

    /*
     * Exception decompiling
     */
    public final int c(RectF var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl143 : ALOAD : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(int n2, float f2) {
        Context context = this.j;
        Resources resources = context == null ? Resources.getSystem() : context.getResources();
        float f3 = TypedValue.applyDimension((int)n2, (float)f2, (DisplayMetrics)resources.getDisplayMetrics());
        if (f3 != this.i.getPaint().getTextSize()) {
            this.i.getPaint().setTextSize(f3);
            boolean bl = this.i.isInLayout();
            if (this.i.getLayout() != null) {
                this.b = false;
                try {
                    Method method = z.d("nullLayouts");
                    if (method != null) {
                        method.invoke((Object)this.i, new Object[0]);
                    }
                }
                catch (Exception exception) {
                    Log.w((String)"ACTVAutoSizeHelper", (String)"Failed to invoke TextView#nullLayouts() method", (Throwable)exception);
                }
                if (!bl) {
                    this.i.requestLayout();
                } else {
                    this.i.forceLayout();
                }
                this.i.invalidate();
            }
        }
    }

    public final boolean g() {
        boolean bl = this.i();
        if (bl && this.a == 1) {
            if (!this.g || this.f.length == 0) {
                int n2 = 1 + (int)Math.floor((double)((this.e - this.d) / this.c));
                int[] arrn = new int[n2];
                for (int i2 = 0; i2 < n2; ++i2) {
                    arrn[i2] = Math.round((float)(this.d + (float)i2 * this.c));
                }
                this.f = this.b(arrn);
            }
            this.b = true;
        } else {
            this.b = false;
        }
        return this.b;
    }

    public final boolean h() {
        int n2 = this.f.length;
        boolean bl = n2 > 0;
        this.g = bl;
        if (bl) {
            this.a = 1;
            int[] arrn = this.f;
            this.d = arrn[0];
            this.e = arrn[n2 - 1];
            this.c = -1.0f;
        }
        return this.g;
    }

    public final boolean i() {
        return true ^ this.i instanceof k;
    }

    public final void j(float f2, float f3, float f4) {
        if (!(f2 <= 0.0f)) {
            if (!(f3 <= f2)) {
                if (!(f4 <= 0.0f)) {
                    this.a = 1;
                    this.d = f2;
                    this.e = f3;
                    this.c = f4;
                    this.g = false;
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The auto-size step granularity (");
                stringBuilder.append(f4);
                stringBuilder.append("px) is less or equal to (0px)");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Maximum auto-size text size (");
            stringBuilder.append(f3);
            stringBuilder.append("px) is less or equal to minimum auto-size text size (");
            stringBuilder.append(f2);
            stringBuilder.append("px)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Minimum auto-size text size (");
        stringBuilder.append(f2);
        stringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static class c {
        public abstract void a(StaticLayout.Builder var1, TextView var2);

        public boolean b(TextView textView) {
            return z.e((Object)textView, "getHorizontallyScrolling", Boolean.FALSE);
        }
    }

}

