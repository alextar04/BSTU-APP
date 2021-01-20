/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.q.i.a
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 */
package c.c.a;

import c.c.a.q.i.a;
import c.c.a.q.i.c;

public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType>
implements Cloneable {
    public c<? super TranscodeType> e = a.b;

    public final CHILD a() {
        j j2;
        try {
            j2 = (j)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
        return (CHILD)j2;
    }

    public Object clone() {
        try {
            j j2 = (j)super.clone();
            return j2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
    }
}

