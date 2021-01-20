/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  c.c.a.m.o
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.s.j;

public final class w
implements q<Bitmap, Bitmap> {
    @Override
    public c.c.a.m.u.w a(Object object, int n2, int n3, o o2) {
        return new a((Bitmap)object);
    }

    @Override
    public boolean b(Object object, o o2) {
        (Bitmap)object;
        return true;
    }

    public static final class a
    implements c.c.a.m.u.w<Bitmap> {
        public final Bitmap e;

        public a(Bitmap bitmap) {
            this.e = bitmap;
        }

        @Override
        public Object b() {
            return this.e;
        }

        @Override
        public int c() {
            return j.e(this.e);
        }

        @Override
        public Class<Bitmap> d() {
            return Bitmap.class;
        }

        @Override
        public void e() {
        }
    }

}

