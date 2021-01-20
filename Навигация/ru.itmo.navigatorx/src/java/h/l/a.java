/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package h.l;

import h.m.b.j;
import java.lang.reflect.Method;

public class a {
    public void a(Throwable throwable, Throwable throwable2) {
        j.e((Object)throwable, "cause");
        j.e((Object)throwable2, "exception");
        Method method = a.a;
        if (method != null) {
            method.invoke((Object)throwable, new Object[]{throwable2});
        }
    }

    public static final class a {
        public static final Method a;

        public static {
            Method method;
            Method[] arrmethod = Throwable.class.getMethods();
            j.d(arrmethod, "throwableMethods");
            int n2 = arrmethod.length;
            int n3 = 0;
            int n4 = 0;
            do {
                int n5;
                Method method2;
                block8 : {
                    block7 : {
                        method = null;
                        if (n4 >= n2) break;
                        method2 = arrmethod[n4];
                        j.d((Object)method2, "it");
                        boolean bl = j.a(method2.getName(), "addSuppressed");
                        n5 = 1;
                        if (!bl) break block7;
                        Class[] arrclass = method2.getParameterTypes();
                        j.d(arrclass, "it.parameterTypes");
                        j.e(arrclass, "$this$singleOrNull");
                        int n6 = arrclass.length;
                        Class class_ = null;
                        if (n6 == n5) {
                            class_ = arrclass[0];
                        }
                        if (j.a(class_, Throwable.class)) break block8;
                    }
                    n5 = 0;
                }
                if (n5 != 0) {
                    method = method2;
                    break;
                }
                ++n4;
            } while (true);
            a = method;
            int n7 = arrmethod.length;
            while (n3 < n7) {
                Method method3 = arrmethod[n3];
                j.d((Object)method3, "it");
                if (j.a(method3.getName(), "getSuppressed")) break;
                ++n3;
            }
        }
    }

}

