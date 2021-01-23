/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowId
 *  f.r.f0
 *  java.lang.Object
 */
package f.r;

import android.view.View;
import android.view.WindowId;
import f.r.f0;

public class e0
implements f0 {
    public final WindowId a;

    public e0(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object object) {
        return object instanceof e0 && ((e0)object).a.equals((Object)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

