/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.w.f;

import f.b.k.h;
import java.io.File;

public class b
extends b<File> {
    public final T e;

    public b(File file) {
        h.i.p(file, "Argument must not be null");
        this.e = file;
    }

    public final Object b() {
        return this.e;
    }

    public final int c() {
        return 1;
    }

    public Class d() {
        return this.e.getClass();
    }

    public void e() {
    }
}

