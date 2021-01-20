/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  c.c.a.m.o
 *  com.bumptech.glide.load.ImageHeaderParser
 *  java.lang.Object
 *  java.util.List
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import c.c.a.m.q;
import c.c.a.m.u.c0.b;
import c.c.a.m.u.w;
import c.c.a.m.w.c.j;
import c.c.a.m.w.c.o;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.List;

public final class r
implements q<ParcelFileDescriptor, Bitmap> {
    public final j a;

    public r(j j2) {
        this.a = j2;
    }

    @Override
    public w a(Object object, int n2, int n3, c.c.a.m.o o2) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)object;
        j j2 = this.a;
        return j2.a(new o.b(parcelFileDescriptor, j2.d, j2.c), n2, n3, o2, j.k);
    }

    @Override
    public boolean b(Object object, c.c.a.m.o o2) {
        (ParcelFileDescriptor)object;
        if (this.a != null) {
            return true;
        }
        throw null;
    }
}

