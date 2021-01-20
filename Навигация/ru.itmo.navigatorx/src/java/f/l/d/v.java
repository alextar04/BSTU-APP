/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.fragment.app.Fragment
 *  f.l.d.r
 *  f.n.a0
 *  f.n.d0
 *  f.n.h0
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Set
 */
package f.l.d;

import android.util.Log;
import androidx.fragment.app.Fragment;
import f.l.d.r;
import f.n.a0;
import f.n.d0;
import f.n.h0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class v
extends a0 {
    public static final d0 i = new d0(){

        public <T extends a0> T a(Class<T> class_) {
            return (T)((Object)new v(true));
        }
    };
    public final HashMap<String, Fragment> c = new HashMap();
    public final HashMap<String, v> d = new HashMap();
    public final HashMap<String, h0> e = new HashMap();
    public final boolean f;
    public boolean g = false;
    public boolean h = false;

    public v(boolean bl) {
        this.f = bl;
    }

    public void b() {
        if (r.M((int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onCleared called for ");
            stringBuilder.append((Object)this);
            Log.d((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.g = true;
    }

    public boolean d(Fragment fragment) {
        if (!this.c.containsKey((Object)fragment.i)) {
            return true;
        }
        if (this.f) {
            return this.g;
        }
        return true ^ this.h;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (v.class != object.getClass()) {
                return false;
            }
            v v2 = (v)((Object)object);
            return this.c.equals(v2.c) && this.d.equals(v2.d) && this.e.equals(v2.e);
        }
        return false;
    }

    public int hashCode() {
        return 31 * (31 * this.c.hashCode() + this.d.hashCode()) + this.e.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FragmentManagerViewModel{");
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)((Object)this))));
        stringBuilder.append("} Fragments (");
        Iterator iterator = this.c.values().iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(") Child Non Config (");
        Iterator iterator2 = this.d.keySet().iterator();
        while (iterator2.hasNext()) {
            stringBuilder.append((String)iterator2.next());
            if (!iterator2.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(") ViewModelStores (");
        Iterator iterator3 = this.e.keySet().iterator();
        while (iterator3.hasNext()) {
            stringBuilder.append((String)iterator3.next());
            if (!iterator3.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

}

