/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.w.c.i$a
 *  c.c.a.m.w.c.i$b
 *  c.c.a.m.w.c.i$c
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.w.c;

import c.c.a.m.n;
import c.c.a.m.w.c.i;

/*
 * Exception performing whole class analysis.
 */
public abstract class i {
    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final n<i> e;
    public static final boolean f;

    public static {
        i i2;
        a = new /* Unavailable Anonymous Inner Class!! */;
        b = new /* Unavailable Anonymous Inner Class!! */;
        c = new /* Unavailable Anonymous Inner Class!! */;
        d = i2 = b;
        e = n.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", i2);
        f = true;
    }

    public abstract d a(int var1, int var2, int var3, int var4);

    public abstract float b(int var1, int var2, int var3, int var4);

    public static final class d
    extends Enum<d> {
        public static final /* enum */ d e;
        public static final /* enum */ d f;
        public static final /* synthetic */ d[] g;

        public static {
            d d2;
            e = new d();
            f = d2 = new d();
            d[] arrd = new d[]{e, d2};
            g = arrd;
        }

        public static d valueOf(String string) {
            return (d)Enum.valueOf(d.class, (String)string);
        }

        public static d[] values() {
            return (d[])g.clone();
        }
    }

}

