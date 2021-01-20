/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package f.b.p;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import f.b.f;
import f.b.g;
import f.b.i;

public class a1 {
    public final Context a;
    public final View b;
    public final TextView c;
    public final WindowManager.LayoutParams d = new WindowManager.LayoutParams();
    public final Rect e = new Rect();
    public final int[] f = new int[2];
    public final int[] g = new int[2];

    public a1(Context context) {
        View view;
        this.a = context;
        this.b = view = LayoutInflater.from((Context)context).inflate(g.abc_tooltip, null);
        this.c = (TextView)view.findViewById(f.message);
        this.d.setTitle((CharSequence)a1.class.getSimpleName());
        this.d.packageName = this.a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a() {
        boolean bl = this.b.getParent() != null;
        if (!bl) {
            return;
        }
        ((WindowManager)this.a.getSystemService("window")).removeView(this.b);
    }
}

