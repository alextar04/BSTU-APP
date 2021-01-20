/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow
 *  androidx.appcompat.widget.ActionBarContextView
 *  f.b.k.h
 *  f.b.k.l$a
 *  f.h.l.l
 *  f.h.l.q
 *  f.h.l.r
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 */
package f.b.k;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import f.b.k.h;
import f.b.k.l;
import f.h.l.q;
import f.h.l.r;
import java.lang.ref.WeakReference;

public class l
implements Runnable {
    public final /* synthetic */ h e;

    public l(h h2) {
        this.e = h2;
    }

    public void run() {
        h h2 = this.e;
        h2.t.showAtLocation((View)h2.s, 55, 0, 0);
        this.e.y();
        if (this.e.L()) {
            this.e.s.setAlpha(0.0f);
            h h3 = this.e;
            q q2 = f.h.l.l.a((View)h3.s);
            q2.a(1.0f);
            h3.v = q2;
            q q3 = this.e.v;
            a a2 = new a(this);
            View view = (View)q3.a.get();
            if (view != null) {
                q3.e(view, (r)a2);
                return;
            }
        } else {
            this.e.s.setAlpha(1.0f);
            this.e.s.setVisibility(0);
        }
    }
}

