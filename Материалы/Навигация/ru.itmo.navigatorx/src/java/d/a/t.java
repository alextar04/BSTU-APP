/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.v
 *  h.k.e
 *  h.k.e$a
 *  h.k.f
 *  h.k.f$a
 *  h.k.f$b
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d.a;

import d.a.a.q;
import d.a.c0;
import d.a.v;
import d.a.x;
import h.k.e;
import h.k.f;

public final class t {
    public static final boolean a;

    public static {
        String string;
        block5 : {
            boolean bl;
            block6 : {
                block2 : {
                    block3 : {
                        block4 : {
                            string = q.a("kotlinx.coroutines.scheduler");
                            if (string == null) break block2;
                            int n2 = string.hashCode();
                            if (n2 == 0) break block3;
                            if (n2 == 3551) break block4;
                            if (n2 != 109935 || !string.equals((Object)"off")) break block5;
                            bl = false;
                            break block6;
                        }
                        if (!string.equals((Object)"on")) break block5;
                        break block2;
                    }
                    if (!string.equals((Object)"")) break block5;
                }
                bl = true;
            }
            a = bl;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("System property 'kotlinx.coroutines.scheduler' has unrecognized value '");
        stringBuilder.append(string);
        stringBuilder.append('\'');
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public static final String a(f f2) {
        return null;
    }

    public static final f b(x x2, f f2) {
        f f3 = x2.s().plus(f2);
        if (f3 != c0.a && f3.get((f.b)e.b) == null) {
            f3 = f3.plus((f)c0.a);
        }
        return f3;
    }
}

