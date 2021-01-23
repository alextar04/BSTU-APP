/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ImageHeaderParser
 *  java.io.InputStream
 *  java.lang.Object
 */
package c.c.a.m;

import c.c.a.m.k;
import c.c.a.m.u.c0.b;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.InputStream;

public class i
implements k {
    public final /* synthetic */ InputStream a;
    public final /* synthetic */ b b;

    public i(InputStream inputStream, b b2) {
        this.a = inputStream;
        this.b = b2;
    }

    @Override
    public int a(ImageHeaderParser imageHeaderParser) {
        try {
            int n2 = imageHeaderParser.b(this.a, this.b);
            return n2;
        }
        finally {
            this.a.reset();
        }
    }
}

