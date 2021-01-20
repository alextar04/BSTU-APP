/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package i;

import i.f0.f.e;
import i.q;
import java.util.concurrent.TimeUnit;

public final class d {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    public static {
        TimeUnit.SECONDS.toSeconds((long)Integer.MAX_VALUE);
    }

    public d(boolean bl, boolean bl2, int n2, int n3, boolean bl3, boolean bl4, boolean bl5, int n4, int n5, boolean bl6, boolean bl7, boolean bl8, String string) {
        this.a = bl;
        this.b = bl2;
        this.c = n2;
        this.d = n3;
        this.e = bl3;
        this.f = bl4;
        this.g = bl5;
        this.h = n4;
        this.i = n5;
        this.j = bl6;
        this.k = bl7;
        this.l = bl8;
        this.m = string;
    }

    public static d a(q q2) {
        q q3 = q2;
        int n2 = q2.f();
        boolean bl = true;
        String string = null;
        boolean bl2 = false;
        boolean bl3 = false;
        int n3 = -1;
        int n4 = -1;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        int n5 = -1;
        int n6 = -1;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            block35 : {
                String string2;
                block34 : {
                    block33 : {
                        String string3;
                        block32 : {
                            string3 = q3.d(i2);
                            string2 = q3.g(i2);
                            if (!string3.equalsIgnoreCase("Cache-Control")) break block32;
                            if (string != null) break block33;
                            string = string2;
                            break block34;
                        }
                        if (!string3.equalsIgnoreCase("Pragma")) break block35;
                    }
                    bl = false;
                }
                int n7 = 0;
                while (n7 < string2.length()) {
                    String string4;
                    int n8;
                    int n9 = e.e(string2, n7, "=,;");
                    String string5 = string2.substring(n7, n9).trim();
                    if (n9 != string2.length() && string2.charAt(n9) != ',' && string2.charAt(n9) != ';') {
                        char c2;
                        while (++n9 < string2.length() && ((c2 = string2.charAt(n9)) == ' ' || c2 == '\t')) {
                        }
                        if (n9 < string2.length() && string2.charAt(n9) == '\"') {
                            int n10 = n9 + 1;
                            int n11 = e.e(string2, n10, "\"");
                            string4 = string2.substring(n10, n11);
                            n8 = n11 + 1;
                        } else {
                            n8 = e.e(string2, n9, ",;");
                            string4 = string2.substring(n9, n8).trim();
                        }
                    } else {
                        n8 = n9 + 1;
                        string4 = null;
                    }
                    if ("no-cache".equalsIgnoreCase(string5)) {
                        bl2 = true;
                    } else if ("no-store".equalsIgnoreCase(string5)) {
                        bl3 = true;
                    } else if ("max-age".equalsIgnoreCase(string5)) {
                        n3 = e.c(string4, -1);
                    } else if ("s-maxage".equalsIgnoreCase(string5)) {
                        n4 = e.c(string4, -1);
                    } else if ("private".equalsIgnoreCase(string5)) {
                        bl4 = true;
                    } else if ("public".equalsIgnoreCase(string5)) {
                        bl5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(string5)) {
                        bl6 = true;
                    } else if ("max-stale".equalsIgnoreCase(string5)) {
                        n5 = e.c(string4, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(string5)) {
                        n6 = e.c(string4, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(string5)) {
                        bl7 = true;
                    } else if ("no-transform".equalsIgnoreCase(string5)) {
                        bl8 = true;
                    } else if ("immutable".equalsIgnoreCase(string5)) {
                        bl9 = true;
                    }
                    n7 = n8;
                }
            }
            q3 = q2;
        }
        String string6 = !bl ? null : string;
        d d2 = new d(bl2, bl3, n3, n4, bl4, bl5, bl6, n5, n6, bl7, bl8, bl9, string6);
        return d2;
    }

    public String toString() {
        String string;
        String string2 = this.m;
        if (string2 != null) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a) {
            stringBuilder.append("no-cache, ");
        }
        if (this.b) {
            stringBuilder.append("no-store, ");
        }
        if (this.c != -1) {
            stringBuilder.append("max-age=");
            stringBuilder.append(this.c);
            stringBuilder.append(", ");
        }
        if (this.d != -1) {
            stringBuilder.append("s-maxage=");
            stringBuilder.append(this.d);
            stringBuilder.append(", ");
        }
        if (this.e) {
            stringBuilder.append("private, ");
        }
        if (this.f) {
            stringBuilder.append("public, ");
        }
        if (this.g) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.h != -1) {
            stringBuilder.append("max-stale=");
            stringBuilder.append(this.h);
            stringBuilder.append(", ");
        }
        if (this.i != -1) {
            stringBuilder.append("min-fresh=");
            stringBuilder.append(this.i);
            stringBuilder.append(", ");
        }
        if (this.j) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.k) {
            stringBuilder.append("no-transform, ");
        }
        if (this.l) {
            stringBuilder.append("immutable, ");
        }
        if (stringBuilder.length() == 0) {
            string = "";
        } else {
            stringBuilder.delete(-2 + stringBuilder.length(), stringBuilder.length());
            string = stringBuilder.toString();
        }
        this.m = string;
        return string;
    }
}

