/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Bundle
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.FrameLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  c.e.a.a.p.c$b
 *  c.e.a.a.p.c$d
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$d
 *  f.b.k.n
 *  f.h.l.l
 */
package c.e.a.a.p;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.e.a.a.f;
import c.e.a.a.h;
import c.e.a.a.j;
import c.e.a.a.p.c;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import f.b.k.n;
import f.h.l.l;

public class c
extends n {
    public BottomSheetBehavior<FrameLayout> g;
    public FrameLayout h;
    public boolean i;
    public boolean j;
    public boolean k;
    public BottomSheetBehavior.d l;

    public c(Context context, int n2) {
        if (n2 == 0) {
            TypedValue typedValue = new TypedValue();
            n2 = context.getTheme().resolveAttribute(c.e.a.a.b.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : j.Theme_Design_Light_BottomSheetDialog;
        }
        super(context, n2);
        this.i = true;
        this.j = true;
        this.l = new d(this);
        this.c(1);
    }

    public void cancel() {
        this.e();
        Dialog.super.cancel();
    }

    public final FrameLayout d() {
        if (this.h == null) {
            BottomSheetBehavior bottomSheetBehavior;
            FrameLayout frameLayout;
            this.h = frameLayout = (FrameLayout)View.inflate((Context)this.getContext(), (int)h.design_bottom_sheet_dialog, null);
            this.g = bottomSheetBehavior = BottomSheetBehavior.I((View)((FrameLayout)frameLayout.findViewById(f.design_bottom_sheet)));
            bottomSheetBehavior.C(this.l);
            this.g.K(this.i);
        }
        return this.h;
    }

    public BottomSheetBehavior<FrameLayout> e() {
        if (this.g == null) {
            this.d();
        }
        return this.g;
    }

    public final View g(int n2, View view, ViewGroup.LayoutParams layoutParams) {
        this.d();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)this.h.findViewById(f.coordinator);
        if (n2 != 0 && view == null) {
            view = this.getLayoutInflater().inflate(n2, (ViewGroup)coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout)this.h.findViewById(f.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f.touch_outside).setOnClickListener(new View.OnClickListener(this){
            public final /* synthetic */ c e;
            {
                this.e = c2;
            }

            public void onClick(View view) {
                c c2 = this.e;
                if (c2.i && c2.isShowing()) {
                    c c3 = this.e;
                    if (!c3.k) {
                        android.content.res.TypedArray typedArray = c3.getContext().obtainStyledAttributes(new int[]{16843611});
                        c3.j = typedArray.getBoolean(0, true);
                        typedArray.recycle();
                        c3.k = true;
                    }
                    if (c3.j) {
                        this.e.cancel();
                    }
                }
            }
        });
        l.S((View)frameLayout, (f.h.l.a)new b(this));
        frameLayout.setOnTouchListener(new View.OnTouchListener(this){

            public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                return true;
            }
        });
        return this.h;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = this.getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    public void onStart() {
        Dialog.super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.g;
        if (bottomSheetBehavior != null && bottomSheetBehavior.z == 5) {
            bottomSheetBehavior.M(4);
        }
    }

    public void setCancelable(boolean bl) {
        Dialog.super.setCancelable(bl);
        if (this.i != bl) {
            this.i = bl;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.g;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.K(bl);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean bl) {
        Dialog.super.setCanceledOnTouchOutside(bl);
        if (bl && !this.i) {
            this.i = true;
        }
        this.j = bl;
        this.k = true;
    }

    public void setContentView(int n2) {
        super.setContentView(this.g(n2, null, null));
    }

    public void setContentView(View view) {
        super.setContentView(this.g(0, view, null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(this.g(0, view, layoutParams));
    }
}

