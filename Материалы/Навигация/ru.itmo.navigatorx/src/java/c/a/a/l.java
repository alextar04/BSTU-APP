/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  java.lang.Object
 */
package c.a.a;

import android.graphics.Matrix;
import c.a.a.a;
import com.otaliastudios.zoom.ZoomMap;
import h.m.b.j;

public final class l
implements a.c {
    public final /* synthetic */ ZoomMap a;

    public l() {
        this.a = var1_1;
    }

    @Override
    public void a(a a2) {
        j.e(a2, "engine");
    }

    @Override
    public void b(a a2, Matrix matrix) {
        j.e(a2, "engine");
        j.e((Object)matrix, "matrix");
        ZoomMap.a(this.a);
    }
}

