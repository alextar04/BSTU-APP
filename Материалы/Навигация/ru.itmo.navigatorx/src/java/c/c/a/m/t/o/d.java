/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  com.bumptech.glide.load.ImageHeaderParser
 *  java.lang.Object
 *  java.util.List
 */
package c.c.a.m.t.o;

import android.content.ContentResolver;
import c.c.a.m.t.o.a;
import c.c.a.m.t.o.c;
import c.c.a.m.u.c0.b;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.List;

public class d {
    public static final a f = new a();
    public final a a;
    public final c b;
    public final b c;
    public final ContentResolver d;
    public final List<ImageHeaderParser> e;

    public d(List<ImageHeaderParser> list, c c2, b b2, ContentResolver contentResolver) {
        a a2 = f;
        this.a = a2;
        this.b = c2;
        this.c = b2;
        this.d = contentResolver;
        this.e = list;
    }
}

