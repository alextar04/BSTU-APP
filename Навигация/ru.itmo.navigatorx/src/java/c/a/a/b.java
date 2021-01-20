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

import c.b.a.a.a;
import h.m.b.j;

public final class b {
    public float a;
    public float b;

    public b() {
        this(0.0f, 0.0f, 3);
    }

    public b(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    public /* synthetic */ b(float f2, float f3, int n2) {
        if ((n2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((n2 & 2) != 0) {
            f3 = 0.0f;
        }
        this(f2, f3);
    }

    public final b a(b b2) {
        j.e((Object)b2, (String)"absolutePoint");
        return new b(this.a - b2.a, this.b - b2.b);
    }

    public final b b(b b2) {
        j.e((Object)b2, (String)"absolutePoint");
        return new b(this.a + b2.a, this.b + b2.b);
    }

    public final void c(b b2) {
        j.e((Object)b2, (String)"p");
        this.d((Number)Float.valueOf((float)b2.a), (Number)Float.valueOf((float)b2.b));
    }

    public final void d(Number number, Number number2) {
        j.e((Object)number, (String)"x");
        j.e((Object)number2, (String)"y");
        this.a = number.floatValue();
        this.b = number2.floatValue();
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof b)) break block3;
                b b2 = (b)object;
                if (Float.compare((float)this.a, (float)b2.a) == 0 && Float.compare((float)this.b, (float)b2.b) == 0) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 31 * Float.floatToIntBits((float)this.a) + Float.floatToIntBits((float)this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("AbsolutePoint(x=");
        stringBuilder.append(this.a);
        stringBuilder.append(", y=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

