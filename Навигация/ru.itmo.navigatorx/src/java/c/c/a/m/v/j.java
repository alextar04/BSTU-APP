/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package c.c.a.m.v;

import android.text.TextUtils;
import c.c.a.m.v.h;
import c.c.a.m.v.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j
implements h {
    public final Map<String, List<i>> b;
    public volatile Map<String, String> c;

    public j(Map<String, List<i>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Map<String, String> a() {
        if (this.c != null) return this.c;
        j j2 = this;
        synchronized (j2) {
            if (this.c != null) return this.c;
            this.c = Collections.unmodifiableMap(this.b());
            return this.c;
        }
    }

    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.b.entrySet()) {
            List list = (List)entry.getValue();
            StringBuilder stringBuilder = new StringBuilder();
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                String string = ((i)list.get(i2)).a();
                if (TextUtils.isEmpty((CharSequence)string)) continue;
                stringBuilder.append(string);
                if (i2 == -1 + list.size()) continue;
                stringBuilder.append(',');
            }
            String string = stringBuilder.toString();
            if (TextUtils.isEmpty((CharSequence)string)) continue;
            hashMap.put(entry.getKey(), (Object)string);
        }
        return hashMap;
    }

    public boolean equals(Object object) {
        if (object instanceof j) {
            j j2 = (j)object;
            return this.b.equals(j2.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("LazyHeaders{headers=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static final class b
    implements i {
        public final String a;

        public b(String string) {
            this.a = string;
        }

        @Override
        public String a() {
            return this.a;
        }

        public boolean equals(Object object) {
            if (object instanceof b) {
                b b2 = (b)object;
                return this.a.equals((Object)b2.a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = c.b.a.a.a.c("StringHeaderFactory{value='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

}

