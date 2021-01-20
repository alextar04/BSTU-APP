/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  c.c.a.m.o
 *  c.c.a.m.r
 *  c.c.a.m.w.g.c
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 */
package c.c.a.m.w.g;

import android.util.Log;
import c.c.a.m.o;
import c.c.a.m.r;
import c.c.a.m.u.w;
import c.c.a.m.w.g.c;
import c.c.a.m.w.g.g;
import c.c.a.s.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d
implements r<c> {
    public boolean a(Object object, File file, o o2) {
        c c2 = (c)((w)object).b();
        try {
            a.d(c2.e.a.a.g().asReadOnlyBuffer(), file);
            return true;
        }
        catch (IOException iOException) {
            if (Log.isLoggable((String)"GifEncoder", (int)5)) {
                Log.w((String)"GifEncoder", (String)"Failed to encode GIF drawable data", (Throwable)iOException);
            }
            return false;
        }
    }

    public c.c.a.m.c b(o o2) {
        return c.c.a.m.c.e;
    }
}

