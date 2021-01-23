/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.a.a.b;

import f.b.k.h;
import java.util.List;

public final class b
extends Enum<b> {
    public static final /* enum */ b k;
    public static final /* synthetic */ b[] l;
    public final int e;
    public final String f;
    public final String g;
    public final int h;
    public final List<Integer> i;
    public final int j;

    public static {
        b b2;
        b b3;
        b[] arrb = new b[2];
        Integer[] arrinteger = new Integer[]{2131165316, 2131165317, 2131165318, 2131165319, 2131165320, 2131165321, 2131165322, 2131165323};
        k = b2 = new b(0, "\u0413\u043b\u0430\u0432\u043d\u044b\u0439 \u043a\u043e\u0440\u043f\u0443\u0441", "\u041a\u0440\u043e\u043d\u0432\u0435\u0440\u043a\u0441\u043a\u0438\u0439 \u043f\u0440\u043e\u0441\u043f\u0435\u043a\u0442, \u0434. 49", 8, h.i.S0(arrinteger), 2131165300);
        arrb[0] = b2;
        Integer[] arrinteger2 = new Integer[]{2131165324, 2131165325, 2131165326, 2131165327, 2131165328, 2131165329};
        arrb[1] = b3 = new b(1, "\u041a\u043e\u0440\u043f\u0443\u0441 \u043d\u0430 \u041b\u043e\u043c\u043e\u043d\u043e\u0441\u043e\u0432\u043e", "\u0423\u043b\u0438\u0446\u0430 \u041b\u043e\u043c\u043e\u043d\u043e\u0441\u043e\u0432\u0430, \u0434. 9", 6, h.i.S0(arrinteger2), 2131165301);
        l = arrb;
    }

    public b(int n3, String string2, String string3, int n4, List<Integer> list, int n5) {
        this.e = n3;
        this.f = string2;
        this.g = string3;
        this.h = n4;
        this.i = list;
        this.j = n5;
    }

    public static b valueOf(String string) {
        return (b)Enum.valueOf(b.class, (String)string);
    }

    public static b[] values() {
        return (b[])l.clone();
    }
}

