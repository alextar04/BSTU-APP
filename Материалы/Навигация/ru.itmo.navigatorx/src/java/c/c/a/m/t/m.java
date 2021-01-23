/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  c.c.a.m.t.b
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.t;

import android.content.res.AssetManager;
import c.c.a.m.t.b;
import java.io.InputStream;

public class m
extends b<InputStream> {
    public m(AssetManager assetManager, String string) {
        super(assetManager, string);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void d(Object object) {
        ((InputStream)object).close();
    }

    public Object f(AssetManager assetManager, String string) {
        return assetManager.open(string);
    }
}

