/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 */
package c.c.a.k;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public final class c {
    public static final Charset a = Charset.forName((String)"US-ASCII");

    public static {
        Charset.forName((String)"UTF-8");
    }

    public static void a(File file) {
        File[] arrfile = file.listFiles();
        if (arrfile != null) {
            for (File file2 : arrfile) {
                if (file2.isDirectory()) {
                    c.a(file2);
                }
                if (file2.delete()) {
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to delete file: ");
                stringBuilder.append((Object)file2);
                throw new IOException(stringBuilder.toString());
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not a readable directory: ");
        stringBuilder.append((Object)file);
        throw new IOException(stringBuilder.toString());
    }
}

