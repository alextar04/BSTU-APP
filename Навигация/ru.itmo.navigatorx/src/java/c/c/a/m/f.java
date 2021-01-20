/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  java.io.InputStream
 *  java.lang.Object
 */
package c.c.a.m;

import c.c.a.m.l;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.InputStream;

public class f
implements l {
    public final /* synthetic */ InputStream a;

    public f(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
        try {
            ImageHeaderParser.ImageType imageType = imageHeaderParser.c(this.a);
            return imageType;
        }
        finally {
            this.a.reset();
        }
    }
}

