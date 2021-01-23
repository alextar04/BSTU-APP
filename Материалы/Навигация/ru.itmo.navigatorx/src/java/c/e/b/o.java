/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.b.t
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.e.b;

import c.e.b.e0.c;
import c.e.b.t;
import c.e.b.z;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class o {
    public t b() {
        if (this instanceof t) {
            return (t)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a JSON Primitive: ");
        stringBuilder.append((Object)this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c c2 = new c((Writer)stringWriter);
            c2.i = true;
            c.e.b.c0.z.o.X.b(c2, this);
            String string = stringWriter.toString();
            return string;
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)iOException);
        }
    }
}

