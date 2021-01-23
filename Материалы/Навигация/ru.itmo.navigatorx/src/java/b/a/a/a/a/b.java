/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import b.a.a.a.a.a;
import b.a.a.c;
import com.otaliastudios.zoom.ZoomMap;
import h.m.b.j;

public final class b
extends c.c.a.q.h.b<ZoomMap, Bitmap> {
    public final /* synthetic */ a.f h;

    public b(View view, a.f f2) {
        this.h = f2;
        super(view);
    }

    public void c(Object object, c.c.a.q.i.b b2) {
        Bitmap bitmap = (Bitmap)object;
        j.e((Object)bitmap, (String)"resource");
        ((ZoomMap)this.h.this.w0(c.zoom_layout)).setBackground(bitmap);
    }

    public void d(Drawable drawable) {
    }
}

