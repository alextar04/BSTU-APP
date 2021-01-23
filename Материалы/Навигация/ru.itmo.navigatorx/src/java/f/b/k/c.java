/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$b
 *  f.b.k.n
 *  java.lang.Object
 */
package f.b.k;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
import f.b.k.n;

public class c
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController e;
    public final /* synthetic */ AlertController.b f;

    public c(AlertController.b b2, AlertController alertController) {
        this.f = b2;
        this.e = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
        this.f.m.onClick((DialogInterface)this.e.b, n2);
        if (!this.f.o) {
            this.e.b.dismiss();
        }
    }
}

