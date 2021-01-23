/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.Object
 *  java.lang.String
 */
package c.d.a;

import c.d.a.f;
import java.io.File;
import java.io.FilenameFilter;

public class g
implements FilenameFilter {
    public final /* synthetic */ String a;

    public g(f f2, String string) {
        this.a = string;
    }

    public boolean accept(File file, String string) {
        return string.startsWith(this.a);
    }
}

