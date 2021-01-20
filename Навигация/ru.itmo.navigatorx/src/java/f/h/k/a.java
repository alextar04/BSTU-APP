/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.Writer
 *  java.lang.Deprecated
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.h.k;

import android.util.Log;
import java.io.Writer;

@Deprecated
public class a
extends Writer {
    public final String e;
    public StringBuilder f = new StringBuilder(128);

    public a(String string) {
        this.e = string;
    }

    public final void c() {
        if (this.f.length() > 0) {
            Log.d((String)this.e, (String)this.f.toString());
            StringBuilder stringBuilder = this.f;
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    public void close() {
        this.c();
    }

    public void flush() {
        this.c();
    }

    public void write(char[] arrc, int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            char c2 = arrc[n2 + i2];
            if (c2 == '\n') {
                this.c();
                continue;
            }
            this.f.append(c2);
        }
    }
}

