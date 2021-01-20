/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package g.a;

import g.a.b0;
import g.a.p0.j;
import g.a.z;
import java.io.File;

public class y
implements Runnable {
    public final /* synthetic */ File e;
    public final /* synthetic */ b0 f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ String h;

    public y(File file, b0 b02, boolean bl, String string) {
        this.e = file;
        this.f = b02;
        this.g = bl;
        this.h = string;
    }

    public void run() {
        File file = this.e;
        if (file != null) {
            z.a(this.f.d, file);
        }
        if (this.g) {
            File file2 = new File(j.getFacade(this.f.e()).getSyncServerCertificateFilePath(this.f));
            z.a(this.h, file2);
        }
    }
}

