/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.n.a0
 *  f.n.d0
 *  f.n.g0
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package f.n;

import f.n.a0;
import f.n.d0;
import f.n.g0;

public abstract class e0
extends g0
implements d0 {
    public <T extends a0> T a(Class<T> class_) {
        throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }

    public abstract <T extends a0> T c(String var1, Class<T> var2);
}

