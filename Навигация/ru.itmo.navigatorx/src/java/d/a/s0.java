/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.r0
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 */
package d.a;

import d.a.r0;
import h.m.b.j;
import java.util.concurrent.CancellationException;

public final class s0
extends CancellationException
implements Object<s0> {
    public final r0 e;

    public s0(String string, Throwable throwable, r0 r02) {
        super(string);
        this.e = r02;
        if (throwable != null) {
            this.initCause(throwable);
        }
    }

    public boolean equals(Object object) {
        s0 s02;
        return object == this || object instanceof s0 && j.a((Object)(s02 = (s0)object).getMessage(), (Object)this.getMessage()) && j.a((Object)s02.e, (Object)this.e) && j.a((Object)s02.getCause(), (Object)this.getCause());
        {
        }
    }

    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String string = this.getMessage();
        j.c((Object)string);
        int n2 = 31 * (31 * string.hashCode() + this.e.hashCode());
        Throwable throwable = this.getCause();
        int n3 = throwable != null ? throwable.hashCode() : 0;
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("; job=");
        stringBuilder.append((Object)this.e);
        return stringBuilder.toString();
    }
}

