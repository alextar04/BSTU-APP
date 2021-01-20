/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  c.e.a.a.i0.p
 *  f.b.p.j0
 *  java.lang.Object
 */
package c.e.a.a.i0;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.e.a.a.i0.p;
import f.b.p.e0;
import f.b.p.j0;

public class o
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ p e;

    public o(p p2) {
        this.e = p2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onItemClick(AdapterView<?> adapterView, View object, int n2, long l2) {
        int n3;
        j0 j02;
        p p2 = this.e;
        Object object2 = n3 < 0 ? (!(j02 = p2.h).b() ? null : j02.g.getSelectedItem()) : p2.getAdapter().getItem(n3);
        p.a((p)this.e, (Object)object2);
        AdapterView.OnItemClickListener onItemClickListener = this.e.getOnItemClickListener();
        if (onItemClickListener != null) {
            long l3;
            void var2_3;
            if (object == null || n3 < 0) {
                j0 j03 = this.e.h;
                if (!j03.b()) {
                    Object var2_4 = null;
                } else {
                    View view = j03.g.getSelectedView();
                }
                j0 j04 = this.e.h;
                int n4 = !j04.b() ? -1 : j04.g.getSelectedItemPosition();
                n3 = n4;
                j0 j05 = this.e.h;
                l3 = !j05.b() ? Long.MIN_VALUE : j05.g.getSelectedItemId();
            }
            void var13_13 = var2_3;
            void var14_14 = n3;
            void var15_15 = l3;
            onItemClickListener.onItemClick((AdapterView)this.e.h.g, (View)var13_13, (int)var14_14, (long)var15_15);
        }
        this.e.h.dismiss();
    }
}

