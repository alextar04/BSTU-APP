/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package c.d.a;

import c.b.a.a.a;
import java.util.Arrays;

public class b
extends RuntimeException {
    public b(String string, String[] arrstring, String[] arrstring2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find '");
        stringBuilder.append(string);
        stringBuilder.append("'. Looked for: ");
        stringBuilder.append(Arrays.toString((Object[])arrstring));
        stringBuilder.append(", but only found: ");
        super(a.l(stringBuilder, Arrays.toString((Object[])arrstring2), "."));
    }
}

