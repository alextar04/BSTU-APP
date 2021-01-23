/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Method
 */
package c.e.b.c0;

import c.e.b.c0.y;
import java.lang.reflect.Method;

public class v
extends y {
    public final /* synthetic */ Method a;
    public final /* synthetic */ int b;

    public v(Method method, int n2) {
        this.a = method;
        this.b = n2;
    }

    @Override
    public <T> T b(Class<T> class_) {
        y.a(class_);
        Method method = this.a;
        Object[] arrobject = new Object[]{class_, this.b};
        return (T)method.invoke(null, arrobject);
    }
}

