/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.Adapter
 *  android.widget.ArrayAdapter
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 *  android.widget.ThemedSpinnerAdapter
 *  f.b.p.j0
 *  f.b.p.u
 *  f.b.p.v$b
 *  f.b.p.v$d
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import f.b.g;
import f.b.j;
import f.b.p.g0;
import f.b.p.j0;
import f.b.p.r0;
import f.b.p.s0;
import f.b.p.u;
import f.b.p.v;
import f.b.p.w0;

/*
 * Exception performing whole class analysis.
 */
public class v
extends Spinner {
    public static final int[] m;
    public final f.b.p.e e;
    public final Context f;
    public g0 g;
    public SpinnerAdapter h;
    public final boolean i;
    public f j;
    public int k;
    public final Rect l;

    public static {
        m = new int[]{16843505};
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public v(Context context, AttributeSet attributeSet, int n2) {
        TypedArray typedArray;
        void var18_10;
        block18 : {
            TypedArray typedArray2;
            int n3;
            block20 : {
                TypedArray typedArray3;
                block17 : {
                    Exception exception;
                    block19 : {
                        super(context, attributeSet, n2);
                        this.l = new Rect();
                        r0.a((View)this, this.getContext());
                        typedArray2 = context.obtainStyledAttributes(attributeSet, j.Spinner, n2, 0);
                        this.e = new f.b.p.e((View)this);
                        int n4 = typedArray2.getResourceId(j.Spinner_popupTheme, 0);
                        this.f = n4 != 0 ? new f.b.o.c(context, n4) : context;
                        n3 = -1;
                        typedArray3 = context.obtainStyledAttributes(attributeSet, m, n2, 0);
                        try {
                            if (typedArray3.hasValue(0)) {
                                n3 = typedArray3.getInt(0, 0);
                            }
                            break block17;
                        }
                        catch (Throwable throwable) {
                            typedArray = typedArray3;
                            break block18;
                        }
                        catch (Exception exception2) {
                            break block19;
                        }
                        catch (Throwable throwable) {
                            typedArray = null;
                            break block18;
                        }
                        catch (Exception exception3) {
                            exception = exception3;
                            typedArray3 = null;
                        }
                    }
                    Log.i((String)"AppCompatSpinner", (String)"Could not read android:spinnerMode", (Throwable)exception);
                    if (typedArray3 == null) break block20;
                }
                typedArray3.recycle();
            }
            if (n3 != 0) {
                if (n3 == 1) {
                    d d2 = new /* Unavailable Anonymous Inner Class!! */;
                    w0 w02 = w0.q(this.f, attributeSet, j.Spinner, n2, 0);
                    this.k = w02.k(j.Spinner_android_dropDownWidth, -2);
                    Drawable drawable = w02.g(j.Spinner_android_popupBackground);
                    d2.F.setBackgroundDrawable(drawable);
                    d2.J = typedArray2.getString(j.Spinner_android_prompt);
                    w02.b.recycle();
                    this.j = d2;
                    this.g = new u(this, (View)this, d2);
                }
            } else {
                b b2 = new /* Unavailable Anonymous Inner Class!! */;
                this.j = b2;
                b2.l((CharSequence)typedArray2.getString(j.Spinner_android_prompt));
            }
            Object[] arrobject = typedArray2.getTextArray(j.Spinner_android_entries);
            if (arrobject != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, arrobject);
                arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
                this.setAdapter((SpinnerAdapter)arrayAdapter);
            }
            typedArray2.recycle();
            this.i = true;
            SpinnerAdapter spinnerAdapter = this.h;
            if (spinnerAdapter != null) {
                this.setAdapter(spinnerAdapter);
                this.h = null;
            }
            this.e.d(attributeSet, n2);
            return;
        }
        if (typedArray == null) throw var18_10;
        typedArray.recycle();
        throw var18_10;
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int n2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0);
        int n4 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0);
        int n5 = Math.max((int)0, (int)this.getSelectedItemPosition());
        int n6 = Math.min((int)spinnerAdapter.getCount(), (int)(n5 + 15));
        View view = null;
        int n7 = 0;
        for (int i2 = Math.max((int)0, (int)(n5 - (15 - (n6 - n5)))); i2 < n6; ++i2) {
            int n8 = spinnerAdapter.getItemViewType(i2);
            if (n8 != n2) {
                view = null;
                n2 = n8;
            }
            if ((view = spinnerAdapter.getView(i2, view, (ViewGroup)this)).getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(n3, n4);
            n7 = Math.max((int)n7, (int)view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.l);
            Rect rect = this.l;
            n7 += rect.left + rect.right;
        }
        return n7;
    }

    public void b() {
        this.j.d(this.getTextDirection(), this.getTextAlignment());
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        f.b.p.e e2 = this.e;
        if (e2 != null) {
            e2.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        f f2 = this.j;
        if (f2 != null) {
            return f2.c();
        }
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        f f2 = this.j;
        if (f2 != null) {
            return f2.g();
        }
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.j != null) {
            return this.k;
        }
        return super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.j;
    }

    public Drawable getPopupBackground() {
        f f2 = this.j;
        if (f2 != null) {
            return f2.i();
        }
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f;
    }

    public CharSequence getPrompt() {
        f f2 = this.j;
        if (f2 != null) {
            return f2.j();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        f.b.p.e e2 = this.e;
        if (e2 != null) {
            return e2.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f.b.p.e e2 = this.e;
        if (e2 != null) {
            return e2.c();
        }
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f f2 = this.j;
        if (f2 != null && f2.b()) {
            this.j.dismiss();
        }
    }

    public void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (this.j != null && View.MeasureSpec.getMode((int)n2) == Integer.MIN_VALUE) {
            this.setMeasuredDimension(Math.min((int)Math.max((int)this.getMeasuredWidth(), (int)this.a(this.getAdapter(), this.getBackground())), (int)View.MeasureSpec.getSize((int)n2)), this.getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        e e2 = (e)parcelable;
        super.onRestoreInstanceState(e2.getSuperState());
        if (e2.e && (viewTreeObserver = this.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver;
                    if (!v.this.getInternalPopup().b()) {
                        v.this.b();
                    }
                    if ((viewTreeObserver = v.this.getViewTreeObserver()) != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                    }
                }
            });
        }
    }

    public Parcelable onSaveInstanceState() {
        e e2 = new e(super.onSaveInstanceState());
        f f2 = this.j;
        boolean bl = f2 != null && f2.b();
        e2.e = bl;
        return e2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        g0 g02 = this.g;
        if (g02 != null && g02.onTouch((View)this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        f f2 = this.j;
        if (f2 != null) {
            if (!f2.b()) {
                this.b();
            }
            return true;
        }
        return super.performClick();
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.i) {
            this.h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.j != null) {
            Context context = this.f;
            if (context == null) {
                context = this.getContext();
            }
            this.j.o(new c(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f.b.p.e e2 = this.e;
        if (e2 != null) {
            e2.e();
        }
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        f.b.p.e e2 = this.e;
        if (e2 != null) {
            e2.f(n2);
        }
    }

    public void setDropDownHorizontalOffset(int n2) {
        f f2 = this.j;
        if (f2 != null) {
            f2.p(n2);
            this.j.a(n2);
            return;
        }
        super.setDropDownHorizontalOffset(n2);
    }

    public void setDropDownVerticalOffset(int n2) {
        f f2 = this.j;
        if (f2 != null) {
            f2.n(n2);
            return;
        }
        super.setDropDownVerticalOffset(n2);
    }

    public void setDropDownWidth(int n2) {
        if (this.j != null) {
            this.k = n2;
            return;
        }
        super.setDropDownWidth(n2);
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        f f2 = this.j;
        if (f2 != null) {
            f2.m(drawable);
            return;
        }
        super.setPopupBackgroundDrawable(drawable);
    }

    public void setPopupBackgroundResource(int n2) {
        this.setPopupBackgroundDrawable(f.b.l.a.a.b(this.getPopupContext(), n2));
    }

    public void setPrompt(CharSequence charSequence) {
        f f2 = this.j;
        if (f2 != null) {
            f2.l(charSequence);
            return;
        }
        super.setPrompt(charSequence);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f.b.p.e e2 = this.e;
        if (e2 != null) {
            e2.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f.b.p.e e2 = this.e;
        if (e2 != null) {
            e2.i(mode);
        }
    }

    public static class c
    implements ListAdapter,
    SpinnerAdapter {
        public SpinnerAdapter e;
        public ListAdapter f;

        public c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.e = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f = (ListAdapter)spinnerAdapter;
            }
            if (theme != null) {
                s0 s02;
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter)spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                } else if (spinnerAdapter instanceof s0 && (s02 = (s0)spinnerAdapter).getDropDownViewTheme() == null) {
                    s02.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.e;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.e;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(n2, view, viewGroup);
        }

        public Object getItem(int n2) {
            SpinnerAdapter spinnerAdapter = this.e;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(n2);
        }

        public long getItemId(int n2) {
            SpinnerAdapter spinnerAdapter = this.e;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(n2);
        }

        public int getItemViewType(int n2) {
            return 0;
        }

        public View getView(int n2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.e;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(n2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.e;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return this.getCount() == 0;
        }

        public boolean isEnabled(int n2) {
            ListAdapter listAdapter = this.f;
            if (listAdapter != null) {
                return listAdapter.isEnabled(n2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.e;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.e;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public static class e
    extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>(){

            public Object createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            public Object[] newArray(int n2) {
                return new e[n2];
            }
        };
        public boolean e;

        public e(Parcel parcel) {
            super(parcel);
            boolean bl = parcel.readByte() != 0;
            this.e = bl;
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeByte((byte)(this.e ? 1 : 0));
        }

    }

    public static interface f {
        public void a(int var1);

        public boolean b();

        public int c();

        public void d(int var1, int var2);

        public void dismiss();

        public int g();

        public Drawable i();

        public CharSequence j();

        public void l(CharSequence var1);

        public void m(Drawable var1);

        public void n(int var1);

        public void o(ListAdapter var1);

        public void p(int var1);
    }

}

