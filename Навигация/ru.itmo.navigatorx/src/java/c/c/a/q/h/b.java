/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.WindowManager
 *  c.c.a.q.h.e
 *  f.b.k.h
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package c.c.a.q.h;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import c.c.a.f;
import c.c.a.q.h.d;
import c.c.a.q.h.e;
import f.b.k.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class b<T extends View, Z>
implements e<Z> {
    public static final int g = f.glide_custom_view_target_tag;
    public final a e;
    public final T f;

    public b(T t2) {
        h.i.p(t2, "Argument must not be null");
        this.f = t2;
        this.e = new Object((View)t2){
            public static Integer d;
            public final View a;
            public final List<d> b = new ArrayList();
            public a c;
            {
                this.a = view;
            }

            public void a() {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.c);
                }
                this.c = null;
                this.b.clear();
            }

            public final int b(int n2, int n3, int n4) {
                int n5 = n3 - n4;
                if (n5 > 0) {
                    return n5;
                }
                int n6 = n2 - n4;
                if (n6 > 0) {
                    return n6;
                }
                if (!this.a.isLayoutRequested() && n3 == -2) {
                    if (Log.isLoggable((String)"CustomViewTarget", (int)4)) {
                        Log.i((String)"CustomViewTarget", (String)"Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                    }
                    Context context = this.a.getContext();
                    if (d == null) {
                        WindowManager windowManager = (WindowManager)context.getSystemService("window");
                        h.i.p(windowManager, "Argument must not be null");
                        Display display = windowManager.getDefaultDisplay();
                        Point point = new Point();
                        display.getSize(point);
                        d = Math.max((int)point.x, (int)point.y);
                    }
                    return d;
                }
                return 0;
            }

            public final int c() {
                int n2 = this.a.getPaddingTop() + this.a.getPaddingBottom();
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                int n3 = layoutParams != null ? layoutParams.height : 0;
                return this.b(this.a.getHeight(), n3, n2);
            }

            public final int d() {
                int n2 = this.a.getPaddingLeft() + this.a.getPaddingRight();
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                int n3 = layoutParams != null ? layoutParams.width : 0;
                return this.b(this.a.getWidth(), n3, n2);
            }

            public final boolean e(int n2, int n3) {
                boolean bl = n2 > 0 || n2 == Integer.MIN_VALUE;
                boolean bl2 = false;
                if (bl) {
                    boolean bl3 = n3 > 0 || n3 == Integer.MIN_VALUE;
                    bl2 = false;
                    if (bl3) {
                        bl2 = true;
                    }
                }
                return bl2;
            }

            public static final class a
            implements ViewTreeObserver.OnPreDrawListener {
                public final WeakReference<a> e;

                public a(a a2) {
                    this.e = new WeakReference((Object)a2);
                }

                public boolean onPreDraw() {
                    a a2;
                    int n2;
                    int n3;
                    if (Log.isLoggable((String)"CustomViewTarget", (int)2)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("OnGlobalLayoutListener called attachStateListener=");
                        stringBuilder.append((Object)this);
                        Log.v((String)"CustomViewTarget", (String)stringBuilder.toString());
                    }
                    if ((a2 = this.e.get()) != null && !a2.b.isEmpty() && a2.e(n2 = a2.d(), n3 = a2.c())) {
                        Iterator iterator = new ArrayList(a2.b).iterator();
                        while (iterator.hasNext()) {
                            ((d)iterator.next()).e(n2, n3);
                        }
                        a2.a();
                    }
                    return true;
                }
            }

        };
    }

    public final void a(d d2) {
        this.e.b.remove((Object)d2);
    }

    public final void b(Drawable drawable) {
    }

    public void e() {
    }

    public final c.c.a.q.b f() {
        Object object = this.f.getTag(g);
        if (object != null) {
            if (object instanceof c.c.a.q.b) {
                return (c.c.a.q.b)object;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    public final void g(Drawable drawable) {
        this.e.a();
    }

    public final void h(d d2) {
        int n2;
        a a2 = this.e;
        int n3 = a2.d();
        if (a2.e(n3, n2 = a2.c())) {
            d2.e(n3, n2);
            return;
        }
        if (!a2.b.contains((Object)d2)) {
            a2.b.add((Object)d2);
        }
        if (a2.c == null) {
            a a3;
            ViewTreeObserver viewTreeObserver = a2.a.getViewTreeObserver();
            a2.c = a3 = new a(a2);
            viewTreeObserver.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)a3);
        }
    }

    public void i() {
    }

    public final void j(c.c.a.q.b b2) {
        this.f.setTag(g, (Object)b2);
    }

    public void k() {
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Target for: ");
        stringBuilder.append(this.f);
        return stringBuilder.toString();
    }

}

