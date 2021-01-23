/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.AssetManager
 *  android.os.ParcelFileDescriptor
 *  c.c.a.m.t.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.t;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import c.c.a.m.t.b;

public class h
extends b<ParcelFileDescriptor> {
    public h(AssetManager assetManager, String string) {
        super(assetManager, string);
    }

    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    public void d(Object object) {
        ((ParcelFileDescriptor)object).close();
    }

    public Object f(AssetManager assetManager, String string) {
        return assetManager.openFd(string).getParcelFileDescriptor();
    }
}

