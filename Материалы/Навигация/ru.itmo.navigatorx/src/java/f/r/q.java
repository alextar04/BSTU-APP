/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 */
package f.r;

import android.view.View;
import c.b.a.a.a;
import f.r.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class q {
    public final Map<String, Object> a = new HashMap();
    public View b;
    public final ArrayList<i> c = new ArrayList();

    @Deprecated
    public q() {
    }

    public q(View view) {
        this.b = view;
    }

    public boolean equals(Object object) {
        if (object instanceof q) {
            View view = this.b;
            q q2 = (q)object;
            if (view == q2.b && this.a.equals(q2.a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.b.hashCode() + this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("TransitionValues@");
        stringBuilder.append(Integer.toHexString((int)this.hashCode()));
        stringBuilder.append(":\n");
        String string = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string);
        stringBuilder2.append("    view = ");
        stringBuilder2.append((Object)this.b);
        stringBuilder2.append("\n");
        String string2 = a.j(stringBuilder2.toString(), "    values:");
        for (String string3 : this.a.keySet()) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string2);
            stringBuilder3.append("    ");
            stringBuilder3.append(string3);
            stringBuilder3.append(": ");
            stringBuilder3.append(this.a.get((Object)string3));
            stringBuilder3.append("\n");
            string2 = stringBuilder3.toString();
        }
        return string2;
    }
}

