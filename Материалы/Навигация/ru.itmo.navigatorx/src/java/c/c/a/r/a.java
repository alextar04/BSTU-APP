/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  java.lang.Object
 *  java.nio.ByteBuffer
 *  java.security.MessageDigest
 */
package c.c.a.r;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import c.c.a.m.m;
import c.c.a.r.b;
import c.c.a.s.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class a
implements m {
    public final int b;
    public final m c;

    public a(int n2, m m2) {
        this.b = n2;
        this.c = m2;
    }

    public static m c(Context context) {
        m m2 = b.a(context);
        return new a(48 & context.getResources().getConfiguration().uiMode, m2);
    }

    @Override
    public void a(MessageDigest messageDigest) {
        this.c.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate((int)4).putInt(this.b).array());
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object instanceof a;
        boolean bl2 = false;
        if (bl) {
            a a2 = (a)object;
            int n2 = this.b;
            int n3 = a2.b;
            bl2 = false;
            if (n2 == n3) {
                boolean bl3 = this.c.equals(a2.c);
                bl2 = false;
                if (bl3) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    @Override
    public int hashCode() {
        return j.h(this.c, this.b);
    }
}

