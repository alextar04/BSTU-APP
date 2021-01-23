/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package c.c.a.m;

import c.c.a.m.l;
import com.bumptech.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;

public class g
implements l {
    public final /* synthetic */ ByteBuffer a;

    public g(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
        return imageHeaderParser.a(this.a);
    }
}

