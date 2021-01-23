/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  b.a.a.a.a.j.a
 *  b.a.a.a.a.j.e
 *  c.a.a.c
 *  c.a.a.l
 *  c.a.a.o.e.b
 *  c.a.a.o.e.c
 *  h.m.b.j
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.otaliastudios.zoom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.a.a.a.a.j.f;
import c.a.a.a;
import c.a.a.b;
import c.a.a.c;
import c.a.a.e;
import c.a.a.g;
import c.a.a.h;
import c.a.a.i;
import c.a.a.j;
import c.a.a.l;
import c.a.a.m;
import c.a.a.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class ZoomMap
extends FrameLayout
implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final String r = ZoomMap.class.getSimpleName();
    public m<n> e;
    public final c f;
    public int g;
    public int h;
    public int i;
    public long j;
    public int k;
    public int l;
    public final List<a> m;
    public final HashMap<Integer, HashSet<n>> n;
    public boolean o;
    public View.OnClickListener p;
    public final c.a.a.a q;

    public ZoomMap(Context context, AttributeSet attributeSet) {
        c.a.a.a a2 = new c.a.a.a(context);
        h.m.b.j.e((Object)context, (String)"context");
        h.m.b.j.e((Object)a2, (String)"engine");
        super(context, attributeSet, 0);
        this.q = a2;
        this.i = -16777216;
        this.j = 500L;
        this.m = new ArrayList();
        this.n = new HashMap();
        this.o = true;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, h.ZoomEngine, 0, 0);
        h.m.b.j.d((Object)typedArray, (String)"context.theme.obtainStyl\u2026mEngine, defStyleAttr, 0)");
        boolean bl = typedArray.getBoolean(h.ZoomEngine_overScrollHorizontal, true);
        boolean bl2 = typedArray.getBoolean(h.ZoomEngine_overScrollVertical, true);
        boolean bl3 = typedArray.getBoolean(h.ZoomEngine_horizontalPanEnabled, true);
        boolean bl4 = typedArray.getBoolean(h.ZoomEngine_verticalPanEnabled, true);
        boolean bl5 = typedArray.getBoolean(h.ZoomEngine_overPinchable, true);
        boolean bl6 = typedArray.getBoolean(h.ZoomEngine_zoomEnabled, true);
        boolean bl7 = typedArray.getBoolean(h.ZoomEngine_flingEnabled, true);
        boolean bl8 = typedArray.getBoolean(h.ZoomEngine_scrollEnabled, true);
        boolean bl9 = typedArray.getBoolean(h.ZoomEngine_oneFingerScrollEnabled, true);
        boolean bl10 = typedArray.getBoolean(h.ZoomEngine_twoFingersScrollEnabled, true);
        boolean bl11 = typedArray.getBoolean(h.ZoomEngine_threeFingersScrollEnabled, true);
        boolean bl12 = typedArray.getBoolean(h.ZoomEngine_allowFlingInOverscroll, true);
        float f2 = typedArray.getFloat(h.ZoomEngine_minZoom, 0.8f);
        float f3 = typedArray.getFloat(h.ZoomEngine_maxZoom, 2.5f);
        int n2 = typedArray.getInteger(h.ZoomEngine_minZoomType, 0);
        int n3 = typedArray.getInteger(h.ZoomEngine_maxZoomType, 0);
        int n4 = typedArray.getInteger(h.ZoomEngine_transformation, 0);
        int n5 = typedArray.getInt(h.ZoomEngine_transformationGravity, 0);
        int n6 = typedArray.getInt(h.ZoomEngine_alignment, 51);
        long l2 = typedArray.getInt(h.ZoomEngine_animationDuration, (int)280L);
        int n7 = typedArray.getResourceId(h.ZoomEngine_background, 0);
        this.i = typedArray.getColor(h.ZoomEngine_pathColor, -16777216);
        this.g = typedArray.getInt(h.ZoomEngine_mapWidth, 0);
        this.h = typedArray.getInt(h.ZoomEngine_mapHeight, 0);
        this.k = typedArray.getInt(h.ZoomEngine_virtualMapWidth, 10000);
        this.l = typedArray.getInt(h.ZoomEngine_virtualMapHeight, 10000);
        this.j = typedArray.getInt(h.ZoomEngine_pathAnimationDuration, 500);
        typedArray.recycle();
        c.a.a.a a3 = this.q;
        if (a3 != null) {
            h.m.b.j.e((Object)((Object)this), (String)"container");
            a3.c = this;
            this.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new j(a3));
            c.a.a.a a4 = this.q;
            l l3 = new l(this);
            if (a4 != null) {
                h.m.b.j.e((Object)l3, (String)"listener");
                c.a.a.o.b b2 = a4.e;
                if (b2 != null) {
                    h.m.b.j.e((Object)l3, (String)"listener");
                    if (!b2.a.contains((Object)l3)) {
                        b2.a.add((Object)l3);
                    }
                    c.a.a.a a5 = this.q;
                    a5.a = n4;
                    a5.b = n5;
                    this.setAlignment(n6);
                    this.setOverScrollHorizontal(bl);
                    this.setOverScrollVertical(bl2);
                    this.setHorizontalPanEnabled(bl3);
                    this.setVerticalPanEnabled(bl4);
                    this.setOverPinchable(bl5);
                    this.setZoomEnabled(bl6);
                    this.setFlingEnabled(bl7);
                    this.setScrollEnabled(bl8);
                    this.setOneFingerScrollEnabled(bl9);
                    this.setTwoFingersScrollEnabled(bl10);
                    this.setThreeFingersScrollEnabled(bl11);
                    this.setAllowFlingInOverscroll(bl12);
                    this.setAnimationDuration(l2);
                    this.q.l(f2, n2);
                    this.q.k(f3, n3);
                    c c2 = new c(context, null, 0, 6);
                    c2.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                    c2.setOnClickListener(this.p);
                    c2.setMapWidth(this.g);
                    c2.setMapHeight(this.h);
                    this.f = c2;
                    this.setBackground(n7);
                    this.addView((View)this.f);
                    this.setWillNotDraw(false);
                    this.onGlobalLayout();
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static final /* synthetic */ void a(ZoomMap zoomMap) {
        zoomMap.e();
    }

    public final float b(float f2) {
        int n2 = this.k;
        int n3 = this.g;
        return (f2 - (float)(n2 - n3) / 2.0f) / (float)n3 * (this.q.e() - (float)this.getPaddingStart() - (float)this.getPaddingEnd());
    }

    public final float c(float f2) {
        int n2 = this.l;
        int n3 = this.h;
        return (f2 - (float)(n2 - n3) / 2.0f) / (float)n3 * (this.q.d() - (float)this.getPaddingTop() - (float)this.getPaddingBottom());
    }

    public int computeHorizontalScrollOffset() {
        return (int)(-this.q.i.a.left);
    }

    public int computeHorizontalScrollRange() {
        return (int)this.q.i.g();
    }

    public int computeVerticalScrollOffset() {
        return (int)(-this.q.i.a.top);
    }

    public int computeVerticalScrollRange() {
        return (int)this.q.i.f();
    }

    public final n d(m<? extends n> m2, int n2) {
        HashSet hashSet = (HashSet)this.n.get((Object)n2);
        if (hashSet != null) {
            Iterator iterator;
            List list;
            h.m.b.j.d((Object)hashSet, (String)"typedViewsCache");
            h.m.b.j.e((Object)hashSet, (String)"$this$firstOrNull");
            Object object = hashSet instanceof List ? ((list = (List)hashSet).isEmpty() ? null : list.get(0)) : (!(iterator = hashSet.iterator()).hasNext() ? null : iterator.next());
            n n3 = (n)object;
            if (n3 != null) {
                hashSet.remove((Object)n3);
                return n3;
            }
        }
        return m2.b((ViewGroup)this, n2);
    }

    public final void e() {
        c c2 = this.f;
        c2.setPivotX(0.0f);
        c2.setPivotY(0.0f);
        c2.setTranslationX(this.q.i.a.left);
        c2.setTranslationY(this.q.i.a.top);
        c2.setScaleX(this.q.f());
        c2.setScaleY(this.q.f());
        float f2 = 0.15f + 0.65f * ((this.q.g() - this.getMinZoom()) / (this.getMaxZoom() - this.getMinZoom()));
        Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            b.a.a.a.a.j.e e2;
            block7 : {
                block6 : {
                    block5 : {
                        n n2 = ((a)iterator.next()).a;
                        float f3 = this.getScaledPanX();
                        e2 = (b.a.a.a.a.j.e)n2;
                        float f4 = f3 - (float)e2.a.getWidth() / 2.0f + this.b(e2.e) * this.q.f();
                        float f5 = this.getScaledPanY() - (float)e2.b.getBottom() + this.c(e2.f) * this.q.f();
                        View view = n2.a;
                        view.setTranslationX(f4);
                        view.setTranslationY(f5);
                        if (!e2.j) break block5;
                        if (e2.h) continue;
                        break block6;
                    }
                    if (e2.h || !(f2 >= e2.g)) break block7;
                }
                e2.c();
                continue;
            }
            if (!e2.h || !(f2 < e2.g - 0.02f)) continue;
            View view = e2.a;
            view.clearAnimation();
            view.setVisibility(0);
            view.setAlpha(1.0f);
            view.animate().setDuration((long)e2.a.getResources().getInteger(2131296258)).alpha(0.0f).withEndAction((Runnable)new f(e2)).start();
            e2.h = false;
        }
        if ((this.isHorizontalScrollBarEnabled() || this.isVerticalScrollBarEnabled()) && !this.awakenScrollBars()) {
            this.invalidate();
        }
    }

    public final void f(a a2) {
        HashSet hashSet;
        if (!this.n.containsKey((Object)a2.b)) {
            this.n.put((Object)a2.b, (Object)new HashSet());
        }
        if ((hashSet = (HashSet)this.n.get((Object)a2.b)) != null) {
            hashSet.add((Object)a2.a);
        }
    }

    public final m<n> getAdapter() {
        return this.e;
    }

    public final int getDefaultPathColor() {
        return this.i;
    }

    public final c.a.a.a getEngine() {
        return this.q;
    }

    public final int getMapHeight() {
        return this.h;
    }

    public final int getMapWidth() {
        return this.g;
    }

    public float getMaxZoom() {
        return this.q.h.e;
    }

    public int getMaxZoomType() {
        return this.q.h.f;
    }

    public float getMinZoom() {
        return this.q.h.c;
    }

    public int getMinZoomType() {
        return this.q.h.d;
    }

    public b getPan() {
        b b2 = this.q.i.i();
        return new b(b2.a, b2.b);
    }

    public float getPanX() {
        return this.q.i.j();
    }

    public float getPanY() {
        return this.q.i.k();
    }

    public final long getPathAnimationDuration() {
        return this.j;
    }

    public float getRealZoom() {
        return this.q.f();
    }

    public i getScaledPan() {
        i i2 = this.q.i.l();
        return new i(i2.a, i2.b);
    }

    public float getScaledPanX() {
        return this.q.i.a.left;
    }

    public float getScaledPanY() {
        return this.q.i.a.top;
    }

    public final int getVirtualHeight() {
        return this.l;
    }

    public final int getVirtualWidth() {
        return this.k;
    }

    public float getZoom() {
        return this.q.g();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    public void onGlobalLayout() {
        c.a.a.a.j(this.q, (float)this.f.getMeasuredWidth() + (float)this.getPaddingStart() + (float)this.getPaddingEnd(), (float)this.f.getMeasuredHeight() + (float)this.getPaddingTop() + (float)this.getPaddingBottom(), false, 4, null);
        if (this.f.isLaidOut() && this.o && this.q.g() != Float.POSITIVE_INFINITY) {
            this.o = false;
            this.e();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        block2 : {
            block3 : {
                boolean bl;
                block5 : {
                    block4 : {
                        h.m.b.j.e((Object)motionEvent, (String)"ev");
                        c.a.a.a a2 = this.q;
                        if (a2 == null) break block2;
                        h.m.b.j.e((Object)motionEvent, (String)"ev");
                        c.a.a.o.a a3 = a2.f;
                        if (a3 == null) break block3;
                        h.m.b.j.e((Object)motionEvent, (String)"ev");
                        boolean bl2 = a3.b(motionEvent) > 1;
                        if (bl2) break block4;
                        boolean bl3 = super.onInterceptTouchEvent(motionEvent);
                        bl = false;
                        if (!bl3) break block5;
                    }
                    bl = true;
                }
                return bl;
            }
            throw null;
        }
        throw null;
    }

    public void onMeasure(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getMode((int)n3);
        if (n4 != 0 && n5 != 0) {
            this.setMeasuredDimension(View.MeasureSpec.getSize((int)n2), View.MeasureSpec.getSize((int)n3));
            int n6 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            this.measureChildren(n6, n6);
            return;
        }
        throw new RuntimeException(c.b.a.a.a.l(new StringBuilder(), r, " must be used with fixed dimensions (e.g. match_parent)"));
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h.m.b.j.e((Object)motionEvent, (String)"ev");
        c.a.a.a a2 = this.q;
        if (a2 != null) {
            h.m.b.j.e((Object)motionEvent, (String)"ev");
            c.a.a.o.a a3 = a2.f;
            if (a3 != null) {
                h.m.b.j.e((Object)motionEvent, (String)"ev");
                int n2 = a3.b(motionEvent);
                boolean bl = true;
                boolean bl2 = n2 > 0 ? bl : false;
                if (!bl2) {
                    if (super.onTouchEvent(motionEvent)) {
                        return bl;
                    }
                    bl = false;
                }
                return bl;
            }
            throw null;
        }
        throw null;
    }

    public final void setAdapter(m<n> m2) {
        m<n> m3;
        this.e = m2;
        if (m2 != null) {
            h.m.b.j.e((Object)((Object)this), (String)"view");
            m2.a = this;
        }
        if ((m3 = this.e) != null) {
            this.removeAllViews();
            this.addView((View)this.f);
            for (a a2 : this.m) {
                b.a.a.a.a.j.e e2 = (b.a.a.a.a.j.e)a2.a;
                h.m.b.j.e((Object)e2, (String)"viewHolder");
                e2.i = null;
                this.f(a2);
            }
            this.m.clear();
            int n2 = ((b.a.a.a.a.j.a)m3).c.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = m3.c(i2);
                n n4 = this.d(m3, n3);
                m3.a(n4, i2, n3);
                this.m.add((Object)new a(n4, n3));
                this.addView(n4.a);
            }
            this.o = true;
        }
    }

    public void setAlignment(int n2) {
        this.q.g.f = n2;
    }

    public void setAllowFlingInOverscroll(boolean bl) {
        this.q.j.n = bl;
    }

    public void setAnimationDuration(long l2) {
        this.q.i.j = l2;
    }

    public final void setBackground(int n2) {
        this.f.setImageResource(n2);
    }

    public final void setBackground(Bitmap bitmap) {
        h.m.b.j.e((Object)bitmap, (String)"bitmap");
        this.f.setImageBitmap(bitmap);
    }

    public final void setDefaultPathColor(int n2) {
        this.i = n2;
    }

    public void setFlingEnabled(boolean bl) {
        this.q.j.i = bl;
    }

    public void setHorizontalPanEnabled(boolean bl) {
        this.q.g.d = bl;
    }

    public void setMaxZoom(float f2) {
        this.q.k(f2, 0);
    }

    public void setMinZoom(float f2) {
        this.q.l(f2, 0);
    }

    public final void setOnOutsideClickListener(View.OnClickListener onClickListener) {
        h.m.b.j.e((Object)onClickListener, (String)"clickListener");
        this.p = onClickListener;
        this.f.setOnClickListener(onClickListener);
    }

    public void setOneFingerScrollEnabled(boolean bl) {
        this.q.j.k = bl;
    }

    public void setOverPanRange(e e2) {
        h.m.b.j.e((Object)e2, (String)"provider");
        c.a.a.a a2 = this.q;
        if (a2 != null) {
            h.m.b.j.e((Object)e2, (String)"provider");
            c.a.a.o.e.b b2 = a2.g;
            if (b2 != null) {
                h.m.b.j.e((Object)e2, (String)"<set-?>");
                b2.g = e2;
                return;
            }
            throw null;
        }
        throw null;
    }

    public void setOverPinchable(boolean bl) {
        this.q.h.i = bl;
    }

    public void setOverScrollHorizontal(boolean bl) {
        this.q.g.b = bl;
    }

    public void setOverScrollVertical(boolean bl) {
        this.q.g.c = bl;
    }

    public void setOverZoomRange(g g2) {
        h.m.b.j.e((Object)g2, (String)"provider");
        c.a.a.a a2 = this.q;
        if (a2 != null) {
            h.m.b.j.e((Object)g2, (String)"provider");
            c.a.a.o.e.c c2 = a2.h;
            if (c2 != null) {
                h.m.b.j.e((Object)g2, (String)"<set-?>");
                c2.g = g2;
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void setPathAnimationDuration(long l2) {
        this.j = l2;
    }

    public void setScrollEnabled(boolean bl) {
        this.q.j.j = bl;
    }

    public void setThreeFingersScrollEnabled(boolean bl) {
        this.q.j.m = bl;
    }

    public void setTransformation(int n2) {
        this.q.m(n2, 0);
    }

    public void setTwoFingersScrollEnabled(boolean bl) {
        this.q.j.l = bl;
    }

    public void setVerticalPanEnabled(boolean bl) {
        this.q.g.e = bl;
    }

    public void setZoomEnabled(boolean bl) {
        this.q.h.h = bl;
    }

    public static final class a {
        public final n a;
        public final int b;

        public a(n n2, int n3) {
            h.m.b.j.e((Object)n2, (String)"viewHolder");
            this.a = n2;
            this.b = n3;
        }
    }

}

