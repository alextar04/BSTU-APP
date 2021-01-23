/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.Window
 *  androidx.fragment.app.Fragment
 *  f.l.d.a
 *  f.l.d.c$a
 *  f.l.d.c$b
 *  f.l.d.c$c
 *  f.l.d.e
 *  f.l.d.r
 *  f.l.d.r$e
 *  f.l.d.r$f
 *  f.l.d.z
 *  f.l.d.z$a
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.l.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.Fragment;
import f.l.d.c;
import f.l.d.e;
import f.l.d.r;
import f.l.d.z;

public class c
extends Fragment
implements DialogInterface.OnCancelListener,
DialogInterface.OnDismissListener {
    public Handler Z;
    public Runnable a0 = new a(this);
    public DialogInterface.OnCancelListener b0 = new b(this);
    public DialogInterface.OnDismissListener c0 = new c(this);
    public int d0 = 0;
    public int e0 = 0;
    public boolean f0 = true;
    public boolean g0 = true;
    public int h0 = -1;
    public boolean i0;
    public Dialog j0;
    public boolean k0;
    public boolean l0;
    public boolean m0;

    public void A0(Dialog dialog, int n2) {
        if (n2 != 1 && n2 != 2) {
            if (n2 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void G(Bundle bundle) {
        this.H = true;
        if (!this.g0) {
            return;
        }
        View view = this.J;
        if (this.j0 != null) {
            Bundle bundle2;
            e e2;
            if (view != null) {
                if (view.getParent() == null) {
                    this.j0.setContentView(view);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            if ((e2 = this.l()) != null) {
                this.j0.setOwnerActivity((Activity)e2);
            }
            this.j0.setCancelable(this.f0);
            this.j0.setOnCancelListener(this.b0);
            this.j0.setOnDismissListener(this.c0);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.j0.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void J(Context context) {
        super.J(context);
        if (!this.m0) {
            this.l0 = false;
        }
    }

    public void M(Bundle bundle) {
        super.M(bundle);
        this.Z = new Handler();
        boolean bl = this.A == 0;
        this.g0 = bl;
        if (bundle != null) {
            this.d0 = bundle.getInt("android:style", 0);
            this.e0 = bundle.getInt("android:theme", 0);
            this.f0 = bundle.getBoolean("android:cancelable", true);
            this.g0 = bundle.getBoolean("android:showsDialog", this.g0);
            this.h0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public void R() {
        this.H = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            this.k0 = true;
            dialog.setOnDismissListener(null);
            this.j0.dismiss();
            if (!this.l0) {
                this.onDismiss((DialogInterface)this.j0);
            }
            this.j0 = null;
        }
    }

    public void S() {
        this.H = true;
        if (!this.m0 && !this.l0) {
            this.l0 = true;
        }
    }

    public LayoutInflater T(Bundle bundle) {
        LayoutInflater layoutInflater = this.t();
        if (this.g0) {
            if (this.i0) {
                return layoutInflater;
            }
            try {
                Dialog dialog;
                this.i0 = true;
                this.j0 = dialog = this.y0(bundle);
                this.A0(dialog, this.d0);
                return layoutInflater.cloneInContext(this.z0().getContext());
            }
            finally {
                this.i0 = false;
            }
        }
        return layoutInflater;
    }

    public void b0(Bundle bundle) {
        boolean bl;
        int n2;
        int n3;
        boolean bl2;
        int n4;
        Dialog dialog = this.j0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
        }
        if ((n4 = this.d0) != 0) {
            bundle.putInt("android:style", n4);
        }
        if ((n2 = this.e0) != 0) {
            bundle.putInt("android:theme", n2);
        }
        if (!(bl = this.f0)) {
            bundle.putBoolean("android:cancelable", bl);
        }
        if (!(bl2 = this.g0)) {
            bundle.putBoolean("android:showsDialog", bl2);
        }
        if ((n3 = this.h0) != -1) {
            bundle.putInt("android:backStackId", n3);
        }
    }

    public void c0() {
        this.H = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            this.k0 = false;
            dialog.show();
        }
    }

    public void d0() {
        this.H = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.k0) {
            this.w0(true, true);
        }
    }

    public final void w0(boolean bl, boolean bl2) {
        if (this.l0) {
            return;
        }
        this.l0 = true;
        this.m0 = false;
        Dialog dialog = this.j0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.j0.dismiss();
            if (!bl2) {
                if (Looper.myLooper() == this.Z.getLooper()) {
                    this.onDismiss((DialogInterface)this.j0);
                } else {
                    this.Z.post(this.a0);
                }
            }
        }
        this.k0 = true;
        if (this.h0 >= 0) {
            r r2 = this.v();
            int n2 = this.h0;
            if (n2 >= 0) {
                r2.z((r.e)new r.f(r2, null, n2, 1), false);
                this.h0 = -1;
                return;
            }
            throw new IllegalArgumentException(c.b.a.a.a.b("Bad id: ", n2));
        }
        f.l.d.a a2 = new f.l.d.a(this.v());
        r r3 = this.v;
        if (r3 != null && r3 != a2.q) {
            StringBuilder stringBuilder = c.b.a.a.a.c("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            stringBuilder.append(this.toString());
            stringBuilder.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(stringBuilder.toString());
        }
        a2.b(new z.a(3, (Fragment)this));
        if (bl) {
            a2.f(true);
            return;
        }
        a2.c();
    }

    public int x0() {
        return this.e0;
    }

    public Dialog y0(Bundle bundle) {
        return new Dialog(this.m0(), this.x0());
    }

    public final Dialog z0() {
        Dialog dialog = this.j0;
        if (dialog != null) {
            return dialog;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DialogFragment ");
        stringBuilder.append((Object)this);
        stringBuilder.append(" does not have a Dialog.");
        throw new IllegalStateException(stringBuilder.toString());
    }
}

