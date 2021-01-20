/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.util.Log
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.c.a.m.t;

import android.content.res.AssetManager;
import android.util.Log;
import c.c.a.e;
import c.c.a.m.a;
import c.c.a.m.t.d;
import java.io.IOException;

public abstract class b<T>
implements d<T> {
    public final String e;
    public final AssetManager f;
    public T g;

    public b(AssetManager assetManager, String string) {
        this.f = assetManager;
        this.e = string;
    }

    @Override
    public void b() {
        T t2 = this.g;
        if (t2 == null) {
            return;
        }
        try {
            this.d(t2);
        }
        catch (IOException iOException) {}
    }

    @Override
    public a c() {
        return a.e;
    }

    @Override
    public void cancel() {
    }

    public abstract void d(T var1);

    @Override
    public void e(e e2, d.a<? super T> a2) {
        T t2;
        try {
            t2 = this.f(this.f, this.e);
            this.g = t2;
        }
        catch (IOException iOException) {
            if (Log.isLoggable((String)"AssetPathFetcher", (int)3)) {
                Log.d((String)"AssetPathFetcher", (String)"Failed to load data from asset manager", (Throwable)iOException);
            }
            a2.d((Exception)iOException);
            return;
        }
        a2.f(t2);
    }

    public abstract T f(AssetManager var1, String var2);
}

