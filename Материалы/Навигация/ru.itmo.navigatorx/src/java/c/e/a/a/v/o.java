/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.fragment.app.Fragment
 *  com.google.android.material.internal.CheckableImageButton
 *  f.h.l.l
 *  f.l.d.r
 *  f.l.d.r$e
 *  f.l.d.z
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 */
package c.e.a.a.v;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import c.e.a.a.e;
import c.e.a.a.f;
import c.e.a.a.f0.g;
import c.e.a.a.h;
import c.e.a.a.i;
import c.e.a.a.j;
import c.e.a.a.v.a;
import c.e.a.a.v.d;
import c.e.a.a.v.g;
import c.e.a.a.v.o;
import c.e.a.a.v.p;
import c.e.a.a.v.q;
import c.e.a.a.v.r;
import c.e.a.a.v.s;
import c.e.a.a.v.t;
import c.e.a.a.v.w;
import c.e.a.a.v.x;
import com.google.android.material.internal.CheckableImageButton;
import f.b.k.h;
import f.h.l.l;
import f.l.d.r;
import f.l.d.z;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class o<S>
extends f.l.d.c {
    public static final Object E0 = "CONFIRM_BUTTON_TAG";
    public static final Object F0 = "CANCEL_BUTTON_TAG";
    public static final Object G0 = "TOGGLE_BUTTON_TAG";
    public TextView A0;
    public CheckableImageButton B0;
    public c.e.a.a.f0.g C0;
    public Button D0;
    public final LinkedHashSet<q<? super S>> n0 = new LinkedHashSet();
    public final LinkedHashSet<View.OnClickListener> o0 = new LinkedHashSet();
    public final LinkedHashSet<DialogInterface.OnCancelListener> p0 = new LinkedHashSet();
    public final LinkedHashSet<DialogInterface.OnDismissListener> q0 = new LinkedHashSet();
    public int r0;
    public d<S> s0;
    public x<S> t0;
    public c.e.a.a.v.a u0;
    public g<S> v0;
    public int w0;
    public CharSequence x0;
    public boolean y0;
    public int z0;

    public static /* synthetic */ void B0(o o2) {
        o2.G0();
    }

    public static int C0(Context context) {
        Resources resources = context.getResources();
        int n2 = resources.getDimensionPixelOffset(c.e.a.a.d.mtrl_calendar_content_padding);
        int n3 = s.e().i;
        int n4 = resources.getDimensionPixelSize(c.e.a.a.d.mtrl_calendar_day_width);
        int n5 = resources.getDimensionPixelOffset(c.e.a.a.d.mtrl_calendar_month_horizontal_padding);
        return n2 * 2 + n4 * n3 + n5 * (n3 - 1);
    }

    public static boolean D0(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(h.i.t1(context, c.e.a.a.b.materialCalendarStyle, g.class.getCanonicalName()), new int[]{16843277});
        boolean bl = typedArray.getBoolean(0, false);
        typedArray.recycle();
        return bl;
    }

    public static long F0() {
        return s.e().k;
    }

    public final void E0() {
        x x2;
        d<S> d2 = this.s0;
        Context context = this.m0();
        int n2 = this.r0;
        if (n2 == 0) {
            n2 = this.s0.h(context);
        }
        c.e.a.a.v.a a2 = this.u0;
        g g2 = new g();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", n2);
        bundle.putParcelable("GRID_SELECTOR_KEY", d2);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", (Parcelable)a2);
        bundle.putParcelable("CURRENT_MONTH_KEY", (Parcelable)a2.g);
        g2.q0(bundle);
        this.v0 = g2;
        if (this.B0.isChecked()) {
            d<S> d3 = this.s0;
            c.e.a.a.v.a a3 = this.u0;
            x2 = new r();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("DATE_SELECTOR_KEY", d3);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", (Parcelable)a3);
            x2.q0(bundle2);
        } else {
            x2 = this.v0;
        }
        this.t0 = x2;
        this.G0();
        f.l.d.r r2 = this.n();
        if (r2 != null) {
            f.l.d.a a4 = new f.l.d.a(r2);
            int n3 = f.mtrl_calendar_frame;
            x<S> x3 = this.t0;
            if (n3 != 0) {
                a4.d(n3, x3, null, 2);
                if (!a4.g) {
                    a4.q.C((r.e)a4, false);
                    x<S> x4 = this.t0;
                    w w2 = new w<S>(this){
                        public final /* synthetic */ o a;
                        {
                            this.a = o2;
                        }

                        public void a(S s2) {
                            o.B0(this.a);
                            o o2 = this.a;
                            o2.D0.setEnabled(o2.s0.p());
                        }
                    };
                    x4.Z.add((Object)w2);
                    return;
                }
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        throw null;
    }

    public final void G0() {
        String string = this.s0.f(this.o());
        this.A0.setContentDescription((CharSequence)String.format((String)this.z(i.mtrl_picker_announce_current_selection), (Object[])new Object[]{string}));
        this.A0.setText((CharSequence)string);
    }

    public final void H0(CheckableImageButton checkableImageButton) {
        boolean bl = this.B0.isChecked();
        Context context = checkableImageButton.getContext();
        int n2 = bl ? i.mtrl_picker_toggle_to_calendar_input_mode : i.mtrl_picker_toggle_to_text_input_mode;
        String string = context.getString(n2);
        this.B0.setContentDescription((CharSequence)string);
    }

    @Override
    public final void M(Bundle bundle) {
        super.M(bundle);
        if (bundle == null) {
            bundle = this.j;
        }
        this.r0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.s0 = (d)bundle.getParcelable("DATE_SELECTOR_KEY");
        this.u0 = (c.e.a.a.v.a)bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.w0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.x0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.z0 = bundle.getInt("INPUT_MODE_KEY");
    }

    public final View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        int n2 = this.y0 ? h.mtrl_picker_fullscreen : h.mtrl_picker_dialog;
        View view = layoutInflater.inflate(n2, viewGroup);
        Context context = view.getContext();
        if (this.y0) {
            view.findViewById(f.mtrl_calendar_frame).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(o.C0(context), -2));
        } else {
            View view2 = view.findViewById(f.mtrl_calendar_main_pane);
            View view3 = view.findViewById(f.mtrl_calendar_frame);
            view2.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(o.C0(context), -1));
            Resources resources = this.m0().getResources();
            int n3 = resources.getDimensionPixelSize(c.e.a.a.d.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(c.e.a.a.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(c.e.a.a.d.mtrl_calendar_navigation_bottom_padding);
            int n4 = resources.getDimensionPixelSize(c.e.a.a.d.mtrl_calendar_days_of_week_height);
            int n5 = t.i * resources.getDimensionPixelSize(c.e.a.a.d.mtrl_calendar_day_height) + (-1 + t.i) * resources.getDimensionPixelOffset(c.e.a.a.d.mtrl_calendar_month_vertical_padding);
            view3.setMinimumHeight(resources.getDimensionPixelOffset(c.e.a.a.d.mtrl_calendar_bottom_padding) + (n5 + (n3 + n4)));
        }
        this.A0 = textView = (TextView)view.findViewById(f.mtrl_picker_header_selection_text);
        l.U((View)textView, (int)1);
        this.B0 = (CheckableImageButton)view.findViewById(f.mtrl_picker_header_toggle);
        TextView textView2 = (TextView)view.findViewById(f.mtrl_picker_title_text);
        CharSequence charSequence = this.x0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.w0);
        }
        this.B0.setTag((Object)"TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.B0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, f.b.l.a.a.b(context, e.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], f.b.l.a.a.b(context, e.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable((Drawable)stateListDrawable);
        CheckableImageButton checkableImageButton2 = this.B0;
        boolean bl = this.z0 != 0;
        checkableImageButton2.setChecked(bl);
        l.S((View)this.B0, null);
        this.H0(this.B0);
        this.B0.setOnClickListener((View.OnClickListener)new p(this));
        this.D0 = (Button)view.findViewById(f.confirm_button);
        if (this.s0.p()) {
            this.D0.setEnabled(true);
        } else {
            this.D0.setEnabled(false);
        }
        this.D0.setTag((Object)"CONFIRM_BUTTON_TAG");
        this.D0.setOnClickListener(new View.OnClickListener(this){
            public final /* synthetic */ o e;
            {
                this.e = o2;
            }

            public void onClick(View view) {
                Iterator iterator = this.e.n0.iterator();
                while (iterator.hasNext()) {
                    ((q)iterator.next()).a(this.e.s0.c());
                }
                this.e.w0(false, false);
            }
        });
        Button button = (Button)view.findViewById(f.cancel_button);
        button.setTag((Object)"CANCEL_BUTTON_TAG");
        button.setOnClickListener(new View.OnClickListener(this){
            public final /* synthetic */ o e;
            {
                this.e = o2;
            }

            public void onClick(View view) {
                Iterator iterator = this.e.o0.iterator();
                while (iterator.hasNext()) {
                    ((View.OnClickListener)iterator.next()).onClick(view);
                }
                this.e.w0(false, false);
            }
        });
        return view;
    }

    @Override
    public final void b0(Bundle bundle) {
        super.b0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.r0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.s0);
        a.b b2 = new a.b(this.u0);
        s s2 = this.v0.d0;
        if (s2 != null) {
            b2.c = s2.k;
        }
        if (b2.c == null) {
            long l2 = o.F0();
            if (b2.a > l2 || l2 > b2.b) {
                l2 = b2.a;
            }
            b2.c = l2;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", (Parcelable)b2.d);
        c.e.a.a.v.a a2 = new c.e.a.a.v.a(s.d(b2.a), s.d(b2.b), s.d(b2.c), (a.c)bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", (Parcelable)a2);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.w0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.x0);
    }

    @Override
    public void c0() {
        this.H = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            this.k0 = false;
            dialog.show();
        }
        Window window = this.z0().getWindow();
        if (this.y0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable((Drawable)this.C0);
        } else {
            window.setLayout(-2, -2);
            int n2 = this.w().getDimensionPixelOffset(c.e.a.a.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(n2, n2, n2, n2);
            InsetDrawable insetDrawable = new InsetDrawable((Drawable)this.C0, n2, n2, n2, n2);
            window.setBackgroundDrawable((Drawable)insetDrawable);
            window.getDecorView().setOnTouchListener((View.OnTouchListener)new c.e.a.a.w.a(this.z0(), rect));
        }
        this.E0();
    }

    @Override
    public void d0() {
        this.t0.Z.clear();
        this.H = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator iterator = this.p0.iterator();
        while (iterator.hasNext()) {
            ((DialogInterface.OnCancelListener)iterator.next()).onCancel(dialogInterface);
        }
    }

    @Override
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator iterator = this.q0.iterator();
        while (iterator.hasNext()) {
            ((DialogInterface.OnDismissListener)iterator.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup)this.J;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (!this.k0) {
            this.w0(true, true);
        }
    }

    @Override
    public final Dialog y0(Bundle bundle) {
        c.e.a.a.f0.g g2;
        Context context = this.m0();
        Context context2 = this.m0();
        int n2 = this.r0;
        if (n2 == 0) {
            n2 = this.s0.h(context2);
        }
        Dialog dialog = new Dialog(context, n2);
        Context context3 = dialog.getContext();
        this.y0 = o.D0(context3);
        int n3 = h.i.t1(context3, c.e.a.a.b.colorSurface, o.class.getCanonicalName());
        this.C0 = g2 = new c.e.a.a.f0.g(c.e.a.a.f0.j.b(context3, null, c.e.a.a.b.materialCalendarStyle, j.Widget_MaterialComponents_MaterialCalendar).a());
        g2.e.b = new c.e.a.a.x.a(context3);
        g2.x();
        this.C0.q(ColorStateList.valueOf((int)n3));
        this.C0.p(l.j((View)dialog.getWindow().getDecorView()));
        return dialog;
    }
}

