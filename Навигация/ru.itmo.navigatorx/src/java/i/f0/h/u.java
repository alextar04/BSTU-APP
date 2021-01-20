/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package i.f0.h;

import i.f0.h.b;
import java.io.IOException;

public final class u
extends IOException {
    public final b e;

    public u(b b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream was reset: ");
        stringBuilder.append((Object)b2);
        super(stringBuilder.toString());
        this.e = b2;
    }
}

