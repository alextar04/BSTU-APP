/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  f.b.p.j0
 *  java.lang.Object
 */
package f.b.p;

import android.view.View;
import android.widget.AdapterView;
import f.b.p.e0;
import f.b.p.j0;

public class i0
implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ j0 e;

    public i0(j0 j02) {
        this.e = j02;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int n2, long l2) {
        e0 e02;
        if (n2 != -1 && (e02 = this.e.g) != null) {
            e02.setListSelectionHidden(false);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

