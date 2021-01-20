/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.n.a0
 *  f.n.d0
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package f.n;

import f.n.a0;
import f.n.d0;

public class f0
implements d0 {
    public <T extends a0> T a(Class<T> class_) {
        a0 a02;
        try {
            a02 = (a0)class_.newInstance();
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(class_);
            throw new RuntimeException(stringBuilder.toString(), (Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(class_);
            throw new RuntimeException(stringBuilder.toString(), (Throwable)instantiationException);
        }
        return (T)a02;
    }
}

