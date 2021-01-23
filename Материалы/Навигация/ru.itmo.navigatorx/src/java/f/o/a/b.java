/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.n.a0
 *  f.n.d0
 *  f.n.g0
 *  f.n.h0
 *  f.n.m
 *  f.n.t
 *  f.o.a.a
 *  f.o.a.b$a
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.HashMap
 */
package f.o.a;

import f.b.k.h;
import f.e.i;
import f.n.a0;
import f.n.d0;
import f.n.e0;
import f.n.g0;
import f.n.h0;
import f.n.m;
import f.n.t;
import f.o.a.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

public class b
extends f.o.a.a {
    public final m a;
    public final c b;

    public b(m m2, h0 h02) {
        this.a = m2;
        d0 d02 = c.d;
        String string = c.class.getCanonicalName();
        if (string != null) {
            String string2 = c.b.a.a.a.j("androidx.lifecycle.ViewModelProvider.DefaultKey:", string);
            a0 a02 = (a0)h02.a.get((Object)string2);
            if (c.class.isInstance((Object)a02)) {
                if (d02 instanceof g0) {
                    ((g0)d02).b(a02);
                }
            } else {
                c c2 = d02 instanceof e0 ? ((e0)d02).c(string2, c.class) : (d02).a(c.class);
                a02 = c2;
                a0 a03 = (a0)h02.a.put((Object)string2, (Object)a02);
                if (a03 != null) {
                    a03.b();
                }
            }
            this.b = (c)a02;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Deprecated
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        c c2 = this.b;
        if (c2.c.i() > 0) {
            printWriter.print(string);
            printWriter.println("Loaders:");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("    ");
            String string2 = stringBuilder.toString();
            if (c2.c.i() <= 0) {
                return;
            }
            a a2 = c2.c.j(0);
            printWriter.print(string);
            printWriter.print("  #");
            printWriter.print(c2.c.f(0));
            printWriter.print(": ");
            printWriter.println(a2.toString());
            printWriter.print(string2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println(null);
            printWriter.print(string2);
            printWriter.print("mLoader=");
            printWriter.println(null);
            throw null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)((Object)this))));
        stringBuilder.append(" in ");
        h.i.h((Object)this.a, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public static class b<D>
    implements t<D> {
    }

    public static class c
    extends a0 {
        public static final d0 d = new d0(){

            public <T extends a0> T a(Class<T> class_) {
                return (T)((Object)new c());
            }
        };
        public i<f.o.a.b$a> c = new i(10);

        public void b() {
            if (this.c.i() > 0) {
                this.c.j(0);
                throw null;
            }
            i<f.o.a.b$a> i2 = this.c;
            int n2 = i2.h;
            Object[] arrobject = i2.g;
            for (int i3 = 0; i3 < n2; ++i3) {
                arrobject[i3] = null;
            }
            i2.h = 0;
            i2.e = false;
        }

    }

}

