/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.text.TextPaint
 */
package c.e.a.a.c0;

import android.graphics.Typeface;
import android.text.TextPaint;
import c.e.a.a.c0.b;
import c.e.a.a.c0.d;

public class c
extends d {
    public final /* synthetic */ TextPaint a;
    public final /* synthetic */ d b;
    public final /* synthetic */ b c;

    public c(b b2, TextPaint textPaint, d d2) {
        this.c = b2;
        this.a = textPaint;
        this.b = d2;
    }

    @Override
    public void a(int n2) {
        this.b.a(n2);
    }

    @Override
    public void b(Typeface typeface, boolean bl) {
        this.c.d(this.a, typeface);
        this.b.b(typeface, bl);
    }
}

