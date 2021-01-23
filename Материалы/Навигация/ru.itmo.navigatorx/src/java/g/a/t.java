/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package g.a;

import java.util.Locale;

public interface t {

    public static class a {
        public final int a;
        public final int b;

        public a(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        public String toString() {
            Locale locale = Locale.ENGLISH;
            Object[] arrobject = new Object[]{this.a, this.b};
            return String.format((Locale)locale, (String)"startIndex: %d, length: %d", (Object[])arrobject);
        }
    }

}

