/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 */
package i.f0.e;

import java.io.IOException;

public final class e
extends RuntimeException {
    public IOException e;
    public IOException f;

    public e(IOException iOException) {
        super((Throwable)iOException);
        this.e = iOException;
        this.f = iOException;
    }
}

