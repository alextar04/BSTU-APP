/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  java.lang.Object
 */
package c.c.a.m.u.c0;

import android.graphics.Bitmap;
import c.c.a.m.u.c0.d;

public class e
implements d {
    @Override
    public void a(int n2) {
    }

    @Override
    public Bitmap b(int n2, int n3, Bitmap.Config config) {
        return Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)config);
    }

    @Override
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override
    public void d() {
    }

    @Override
    public Bitmap e(int n2, int n3, Bitmap.Config config) {
        return Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)config);
    }
}

