/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 */
package i;

import i.f0.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class q {
    public final String[] a;

    public q(a a2) {
        List<String> list = a2.a;
        this.a = (String[])list.toArray((Object[])new String[list.size()]);
    }

    public static void a(String string) {
        if (string != null) {
            if (!string.isEmpty()) {
                int n2 = string.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    char c2 = string.charAt(i2);
                    if (c2 > ' ' && c2 < '') {
                        continue;
                    }
                    Object[] arrobject = new Object[]{(int)c2, i2, string};
                    throw new IllegalArgumentException(c.n("Unexpected char %#04x at %d in header name: %s", arrobject));
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    public static void b(String string, String string2) {
        if (string != null) {
            int n2 = string.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string.charAt(i2);
                if ((c2 > '\u001f' || c2 == '\t') && c2 < '') {
                    continue;
                }
                Object[] arrobject = new Object[]{(int)c2, i2, string2, string};
                throw new IllegalArgumentException(c.n("Unexpected char %#04x at %d in %s value: %s", arrobject));
            }
            return;
        }
        throw new NullPointerException(c.b.a.a.a.k("value for name ", string2, " == null"));
    }

    public String c(String string) {
        String[] arrstring = this.a;
        int n2 = arrstring.length;
        while ((n2 -= 2) >= 0) {
            if (!string.equalsIgnoreCase(arrstring[n2])) continue;
            return arrstring[n2 + 1];
        }
        return null;
    }

    public String d(int n2) {
        return this.a[n2 * 2];
    }

    public a e() {
        a a2 = new a();
        Collections.addAll(a2.a, (Object[])this.a);
        return a2;
    }

    public boolean equals(Object object) {
        return object instanceof q && Arrays.equals((Object[])((q)object).a, (Object[])this.a);
    }

    public int f() {
        return this.a.length / 2;
    }

    public String g(int n2) {
        return this.a[1 + n2 * 2];
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])this.a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = this.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(this.d(i2));
            stringBuilder.append(": ");
            stringBuilder.append(this.g(i2));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static final class a {
        public final List<String> a = new ArrayList(20);

        public a a(String string, String string2) {
            this.a.add((Object)string);
            this.a.add((Object)string2.trim());
            return this;
        }

        public a b(String string) {
            for (int i2 = 0; i2 < this.a.size(); i2 += 2) {
                if (!string.equalsIgnoreCase((String)this.a.get(i2))) continue;
                this.a.remove(i2);
                this.a.remove(i2);
                i2 -= 2;
            }
            return this;
        }
    }

}

