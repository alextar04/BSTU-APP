/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  f.b.k.h
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package c.a.a;

import android.util.Log;
import f.b.k.h;
import h.m.b.f;
import h.m.b.j;
import java.util.Arrays;

public final class k {
    public final String a;

    public k(String string, f f2) {
        this.a = string;
    }

    public final /* varargs */ void a(Object ... arrobject) {
        j.e((Object)arrobject, (String)"data");
        String string = this.c(1, Arrays.copyOf((Object[])arrobject, (int)arrobject.length));
        j.e((Object)string, (String)"message");
        if (this.b(1)) {
            Log.i((String)this.a, (String)string);
        }
    }

    public final boolean b(int n2) {
        return 3 <= n2;
    }

    public final /* varargs */ String c(int n2, Object ... arrobject) {
        boolean bl = this.b(n2);
        String string = "";
        if (bl) {
            j.e((Object)arrobject, (String)"$this$joinToString");
            j.e((Object)" ", (String)"separator");
            j.e((Object)string, (String)"prefix");
            j.e((Object)string, (String)"postfix");
            j.e((Object)"...", (String)"truncated");
            StringBuilder stringBuilder = new StringBuilder();
            j.e((Object)arrobject, (String)"$this$joinTo");
            j.e((Object)stringBuilder, (String)"buffer");
            j.e((Object)" ", (String)"separator");
            j.e((Object)string, (String)"prefix");
            j.e((Object)string, (String)"postfix");
            j.e((Object)"...", (String)"truncated");
            stringBuilder.append((CharSequence)string);
            int n3 = arrobject.length;
            int n4 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                Object object = arrobject[i2];
                if (++n4 > 1) {
                    stringBuilder.append((CharSequence)" ");
                }
                h.i.b((Appendable)stringBuilder, object, null);
            }
            stringBuilder.append((CharSequence)string);
            string = stringBuilder.toString();
            j.d((Object)string, (String)"joinTo(StringBuilder(), \u2026ed, transform).toString()");
        }
        return string;
    }

    public final /* varargs */ void d(Object ... arrobject) {
        j.e((Object)arrobject, (String)"data");
        String string = this.c(0, Arrays.copyOf((Object[])arrobject, (int)arrobject.length));
        j.e((Object)string, (String)"message");
        if (this.b(1)) {
            Log.i((String)this.a, (String)string);
        }
    }

    public final void e(String string) {
        j.e((Object)string, (String)"message");
        if (this.b(2)) {
            Log.w((String)this.a, (String)string);
        }
    }
}

