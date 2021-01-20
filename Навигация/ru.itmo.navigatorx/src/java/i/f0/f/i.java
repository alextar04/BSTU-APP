/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package i.f0.f;

import c.b.a.a.a;
import i.v;
import java.net.ProtocolException;

public final class i {
    public final v a;
    public final int b;
    public final String c;

    public i(v v2, int n2, String string) {
        this.a = v2;
        this.b = n2;
        this.c = string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static i a(String string) {
        int n2;
        int n3;
        String string2;
        int n4;
        v v2 = v.f;
        boolean bl = string.startsWith("HTTP/1.");
        int n5 = 9;
        if (bl) {
            if (string.length() < n5 || string.charAt(8) != ' ') throw new ProtocolException(a.j("Unexpected status line: ", string));
            int n6 = -48 + string.charAt(7);
            if (n6 != 0) {
                if (n6 != 1) throw new ProtocolException(a.j("Unexpected status line: ", string));
                v2 = v.g;
            }
        } else {
            if (!string.startsWith("ICY ")) throw new ProtocolException(a.j("Unexpected status line: ", string));
            n5 = 4;
        }
        if ((n3 = string.length()) < (n4 = n5 + 3)) throw new ProtocolException(a.j("Unexpected status line: ", string));
        try {
            n2 = Integer.parseInt((String)string.substring(n5, n4));
        }
        catch (NumberFormatException numberFormatException) {
            throw new ProtocolException(a.j("Unexpected status line: ", string));
        }
        if (string.length() > n4) {
            if (string.charAt(n4) != ' ') throw new ProtocolException(a.j("Unexpected status line: ", string));
            string2 = string.substring(n5 + 4);
            return new i(v2, n2, string2);
        } else {
            string2 = "";
        }
        return new i(v2, n2, string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.a == v.f ? "HTTP/1.0" : "HTTP/1.1";
        stringBuilder.append(string);
        stringBuilder.append(' ');
        stringBuilder.append(this.b);
        if (this.c != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.c);
        }
        return stringBuilder.toString();
    }
}

