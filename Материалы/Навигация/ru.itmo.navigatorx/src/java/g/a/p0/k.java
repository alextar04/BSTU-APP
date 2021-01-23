/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.List
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package g.a.p0;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class k<T extends b> {
    public List<T> a = new CopyOnWriteArrayList();
    public boolean b = false;

    public void a(T t2) {
        if (!this.a.contains(t2)) {
            this.a.add(t2);
            ((b)t2).c = false;
        }
        if (this.b) {
            this.b = false;
        }
    }

    public void b(a<T> a2) {
        for (b b2 : this.a) {
            if (this.b) {
                return;
            }
            Object object = b2.a.get();
            if (object == null) {
                this.a.remove((Object)b2);
                continue;
            }
            if (b2.c) continue;
            a2.a(b2, object);
        }
    }

    public boolean c() {
        return this.a.isEmpty();
    }

    public <S, U> void d(S s2, U u2) {
        for (b b2 : this.a) {
            if (s2 != b2.a.get() || !u2.equals(b2.b)) continue;
            b2.c = true;
            this.a.remove((Object)b2);
            break;
        }
    }

    public void e(Object object) {
        for (b b2 : this.a) {
            Object object2 = b2.a.get();
            if (object2 != null && object2 != object) continue;
            b2.c = true;
            this.a.remove((Object)b2);
        }
    }

    public static interface a<T extends b> {
        public void a(T var1, Object var2);
    }

    public static abstract class b<T, S> {
        public final WeakReference<T> a;
        public final S b;
        public boolean c = false;

        public b(T t2, S s2) {
            this.b = s2;
            this.a = new WeakReference(t2);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof b) {
                b b2 = (b)object;
                return this.b.equals(b2.b) && this.a.get() == b2.a.get();
            }
            return false;
        }

        public int hashCode() {
            Object object = this.a.get();
            int n2 = object != null ? object.hashCode() : 0;
            int n3 = 31 * (527 + n2);
            S s2 = this.b;
            int n4 = 0;
            if (s2 != null) {
                n4 = s2.hashCode();
            }
            return n3 + n4;
        }
    }

}

