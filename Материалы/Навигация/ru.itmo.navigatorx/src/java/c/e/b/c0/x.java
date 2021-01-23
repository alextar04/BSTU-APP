/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 */
package c.e.b.c0;

import c.e.b.c0.y;

public class x
extends y {
    @Override
    public <T> T b(Class<T> class_) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot allocate ");
        stringBuilder.append(class_);
        throw new UnsupportedOperationException(stringBuilder.toString());
    }
}

