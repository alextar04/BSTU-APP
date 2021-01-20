/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package h;

import h.m.b.j;
import java.io.Serializable;

public final class d<T>
implements Serializable {
    public static final Throwable a(Object object) {
        if (object instanceof a) {
            return ((a)object).e;
        }
        return null;
    }

    public static final class a
    implements Serializable {
        public final Throwable e;

        public a(Throwable throwable) {
            j.e((Object)throwable, "exception");
            this.e = throwable;
        }

        public boolean equals(Object object) {
            return object instanceof a && j.a((Object)this.e, (Object)((a)object).e);
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = c.b.a.a.a.c("Failure(");
            stringBuilder.append((Object)this.e);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

}

