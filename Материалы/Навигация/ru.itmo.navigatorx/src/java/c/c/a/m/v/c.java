/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 */
package c.c.a.m.v;

import android.util.Log;
import c.c.a.m.d;
import c.c.a.m.o;
import c.c.a.s.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c
implements d<ByteBuffer> {
    @Override
    public boolean a(Object object, File file, o o2) {
        ByteBuffer byteBuffer = (ByteBuffer)object;
        try {
            a.d(byteBuffer, file);
            return true;
        }
        catch (IOException iOException) {
            if (Log.isLoggable((String)"ByteBufferEncoder", (int)3)) {
                Log.d((String)"ByteBufferEncoder", (String)"Failed to write data", (Throwable)iOException);
            }
            return false;
        }
    }
}

