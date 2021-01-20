/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.Float
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.a.a;

import c.a.a.b;
import c.b.a.a.a;
import h.m.b.j;

public final class i {
    public float a;
    public float b;

    public i() {
        this(0.0f, 0.0f, 3);
    }

    public i(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    public /* synthetic */ i(float f2, float f3, int n2) {
        if ((n2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((n2 & 2) != 0) {
            f3 = 0.0f;
        }
        this(f2, f3);
    }

    public static b c(i i2, float f2, b b2, int n2) {
        b b3 = (n2 & 2) != 0 ? new b(0.0f, 0.0f, 3) : null;
        if (i2 != null) {
            j.e((Object)b3, (String)"outPoint");
            b3.d((Number)Float.valueOf((float)(i2.a / f2)), (Number)Float.valueOf((float)(i2.b / f2)));
            return b3;
        }
        throw null;
    }

    public final i a(i i2) {
        j.e((Object)i2, (String)"scaledPoint");
        return new i(this.a - i2.a, this.b - i2.b);
    }

    public final void b(Number number, Number number2) {
        j.e((Object)number, (String)"x");
        j.e((Object)number2, (String)"y");
        this.a = number.floatValue();
        this.b = number2.floatValue();
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof i)) break block3;
                i i2 = (i)object;
                if (Float.compare((float)this.a, (float)i2.a) == 0 && Float.compare((float)this.b, (float)i2.b) == 0) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 31 * Float.floatToIntBits((float)this.a) + Float.floatToIntBits((float)this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("ScaledPoint(x=");
        stringBuilder.append(this.a);
        stringBuilder.append(", y=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

