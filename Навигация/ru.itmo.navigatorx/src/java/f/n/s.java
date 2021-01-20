/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.LiveData$a
 *  java.lang.Object
 *  java.lang.String
 */
package f.n;

import androidx.lifecycle.LiveData;

public class s<T>
extends LiveData<T> {
    public void g(T t2) {
        LiveData.a((String)"setValue");
        this.f = 1 + this.f;
        this.d = t2;
        this.c(null);
    }
}

