/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.animation.DecelerateInterpolator
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Runnable
 */
package f.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import f.b.b;
import f.b.d;
import f.b.j;
import f.b.k.a;

public class p0
extends HorizontalScrollView
implements AdapterView.OnItemSelectedListener {
    public Runnable e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;

    public static {
        new DecelerateInterpolator();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.e;
        if (runnable != null) {
            this.post(runnable);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Context context = this.getContext();
        TypedArray typedArray = context.obtainStyledAttributes(null, j.ActionBar, f.b.a.actionBarStyle, 0);
        int n2 = typedArray.getLayoutDimension(j.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!context.getResources().getBoolean(b.abc_action_bar_embed_tabs)) {
            n2 = Math.min((int)n2, (int)resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        typedArray.recycle();
        this.setContentHeight(n2);
        this.h = context.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.e;
        if (runnable != null) {
            this.removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int n2, long l2) {
        ((a)view).e.a();
    }

    public void onMeasure(int n2, int n3) {
        boolean bl = View.MeasureSpec.getMode((int)n2) == 1073741824;
        this.setFillViewport(bl);
        throw null;
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean bl) {
        this.f = bl;
    }

    public void setContentHeight(int n2) {
        this.i = n2;
        this.requestLayout();
    }

    public void setTabSelected(int n2) {
        this.j = n2;
        throw null;
    }

    public class a
    extends LinearLayout {
        public a.c e;
        public final /* synthetic */ p0 f;

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)"androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName((CharSequence)"androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int n2, int n3) {
            int n4;
            int n5;
            super.onMeasure(n2, n3);
            if (this.f.g > 0 && (n5 = this.getMeasuredWidth()) > (n4 = this.f.g)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)n4, (int)1073741824), n3);
            }
        }

        public void setSelected(boolean bl) {
            boolean bl2 = this.isSelected() != bl;
            super.setSelected(bl);
            if (bl2 && bl) {
                this.sendAccessibilityEvent(4);
            }
        }
    }

}

