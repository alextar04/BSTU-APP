/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextPaint
 *  c.e.a.a.a0.i$a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package c.e.a.a.a0;

import android.text.TextPaint;
import c.e.a.a.a0.i;
import c.e.a.a.c0.d;
import java.lang.ref.WeakReference;

public class i {
    public final TextPaint a = new TextPaint(1);
    public final d b = new a(this);
    public float c;
    public boolean d = true;
    public WeakReference<b> e = new WeakReference(null);
    public c.e.a.a.c0.b f;

    public i(b b2) {
        this.e = new WeakReference((Object)b2);
    }

    public float a(String string) {
        if (!this.d) {
            return this.c;
        }
        float f2 = string == null ? 0.0f : this.a.measureText((CharSequence)string, 0, string.length());
        this.c = f2;
        this.d = false;
        return f2;
    }

    public static interface b {
        public void a();

        public int[] getState();

        public boolean onStateChange(int[] var1);
    }

}

