/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package f.b.k;

public class q {
    public static q d;
    public long a;
    public long b;
    public int c;

    /*
     * Enabled aggressive block sorting
     */
    public void a(long l2, double d2, double d3) {
        double d4;
        double d5;
        long l3;
        block6 : {
            block5 : {
                block4 : {
                    float f2 = (float)(l2 - 946728000000L) / 8.64E7f;
                    float f3 = 6.24006f + 0.01720197f * f2;
                    double d6 = f3;
                    double d7 = 3.141592653589793 + (1.796593063 + (d6 + 0.03341960161924362 * Math.sin((double)d6) + 3.4906598739326E-4 * Math.sin((double)(2.0f * f3)) + 5.236000106378924E-6 * Math.sin((double)(f3 * 3.0f))));
                    double d8 = -d3 / 360.0;
                    d5 = d8 + (double)(9.0E-4f + (float)Math.round((double)((double)(f2 - 9.0E-4f) - d8))) + 0.0053 * Math.sin((double)d6) + -0.0069 * Math.sin((double)(2.0 * d7));
                    double d9 = Math.asin((double)(Math.sin((double)d7) * Math.sin((double)0.4092797040939331)));
                    double d10 = 0.01745329238474369 * d2;
                    d4 = (Math.sin((double)-0.10471975803375244) - Math.sin((double)d10) * Math.sin((double)d9)) / (Math.cos((double)d10) * Math.cos((double)d9));
                    if (!(d4 >= 1.0)) break block4;
                    this.c = 1;
                    break block5;
                }
                if (!(d4 <= -1.0)) break block6;
                this.c = 0;
            }
            this.a = -1L;
            this.b = -1L;
            return;
        }
        double d11 = (float)(Math.acos((double)d4) / 6.283185307179586);
        this.a = 946728000000L + Math.round((double)(8.64E7 * (d5 + d11)));
        this.b = l3 = 946728000000L + Math.round((double)(8.64E7 * (d5 - d11)));
        if (l3 < l2 && this.a > l2) {
            this.c = 0;
            return;
        }
        this.c = 1;
    }
}

