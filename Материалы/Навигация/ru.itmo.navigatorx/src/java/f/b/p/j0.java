/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  f.h.l.l
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.reflect.Method
 */
package f.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import f.b.j;
import f.b.o.i.p;
import f.b.p.e0;
import f.b.p.o;
import f.h.l.l;
import java.lang.reflect.Method;

public class j0
implements p {
    public static Method G;
    public static Method H;
    public static Method I;
    public final a A = new Runnable(){

        public void run() {
            e0 e02 = j0.this.g;
            if (e02 != null) {
                e02.setListSelectionHidden(true);
                e02.requestLayout();
            }
        }
    };
    public final Handler B;
    public final Rect C = new Rect();
    public Rect D;
    public boolean E;
    public PopupWindow F;
    public Context e;
    public ListAdapter f;
    public e0 g;
    public int h = -2;
    public int i = -2;
    public int j;
    public int k;
    public int l = 1002;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p = 0;
    public boolean q = false;
    public boolean r = false;
    public int s = Integer.MAX_VALUE;
    public int t = 0;
    public DataSetObserver u;
    public View v;
    public AdapterView.OnItemClickListener w;
    public final e x = new Runnable(){

        public void run() {
            e0 e02 = j0.this.g;
            if (e02 != null && l.z((View)e02) && j0.this.g.getCount() > j0.this.g.getChildCount()) {
                int n2 = j0.this.g.getChildCount();
                j0 j02 = j0.this;
                if (n2 <= j02.s) {
                    j02.F.setInputMethodMode(2);
                    j0.this.f();
                }
            }
        }
    };
    public final d y = new View.OnTouchListener(){

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int n2 = motionEvent.getAction();
            int n3 = (int)motionEvent.getX();
            int n4 = (int)motionEvent.getY();
            if (n2 == 0 && (popupWindow = j0.this.F) != null && popupWindow.isShowing() && n3 >= 0 && n3 < j0.this.F.getWidth() && n4 >= 0 && n4 < j0.this.F.getHeight()) {
                j0 j02 = j0.this;
                j02.B.postDelayed((Runnable)j02.x, 250L);
            } else if (n2 == 1) {
                j0 j03 = j0.this;
                j03.B.removeCallbacks((Runnable)j03.x);
            }
            return false;
        }
    };
    public final c z = new AbsListView.OnScrollListener(){

        public void onScroll(AbsListView absListView, int n2, int n3, int n4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int n2) {
            int n3 = 1;
            if (n2 == n3) {
                if (j0.this.F.getInputMethodMode() != 2) {
                    n3 = 0;
                }
                if (n3 == 0 && j0.this.F.getContentView() != null) {
                    j0 j02 = j0.this;
                    j02.B.removeCallbacks((Runnable)j02.x);
                    j0.this.x.run();
                }
            }
        }
    };

    /*
     * Exception decompiling
     */
    public static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64 : RETURN : trying to set 0 previously set to 1
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

    public j0(Context context, AttributeSet attributeSet, int n2, int n3) {
        int n4;
        this.e = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, n2, n3);
        this.j = typedArray.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.k = n4 = typedArray.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (n4 != 0) {
            this.m = true;
        }
        typedArray.recycle();
        o o2 = new o(context, attributeSet, n2, n3);
        this.F = o2;
        o2.setInputMethodMode(1);
    }

    public void a(int n2) {
        this.j = n2;
    }

    @Override
    public boolean b() {
        return this.F.isShowing();
    }

    public int c() {
        return this.j;
    }

    @Override
    public void dismiss() {
        this.F.dismiss();
        this.F.setContentView(null);
        this.g = null;
        this.B.removeCallbacks((Runnable)this.x);
    }

    /*
     * Exception decompiling
     */
    @Override
    public void f() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl481 : ALOAD_0 : trying to set 1 previously set to 0
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

    public int g() {
        if (!this.m) {
            return 0;
        }
        return this.k;
    }

    public Drawable i() {
        return this.F.getBackground();
    }

    @Override
    public ListView k() {
        return this.g;
    }

    public void m(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public void n(int n2) {
        this.k = n2;
        this.m = true;
    }

    public void o(ListAdapter listAdapter) {
        e0 e02;
        DataSetObserver dataSetObserver = this.u;
        if (dataSetObserver == null) {
            this.u = new DataSetObserver(){

                public void onChanged() {
                    if (j0.this.b()) {
                        j0.this.f();
                    }
                }

                public void onInvalidated() {
                    j0.this.dismiss();
                }
            };
        } else {
            ListAdapter listAdapter2 = this.f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.u);
        }
        if ((e02 = this.g) != null) {
            e02.setAdapter(this.f);
        }
    }

    public e0 q(Context context, boolean bl) {
        return new e0(context, bl);
    }

    public void r(int n2) {
        Drawable drawable = this.F.getBackground();
        if (drawable != null) {
            drawable.getPadding(this.C);
            Rect rect = this.C;
            this.i = n2 + (rect.left + rect.right);
            return;
        }
        this.i = n2;
    }

    public void s(boolean bl) {
        this.E = bl;
        this.F.setFocusable(bl);
    }

}

