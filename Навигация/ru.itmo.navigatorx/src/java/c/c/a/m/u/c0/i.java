/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.NavigableMap
 *  java.util.TreeMap
 */
package c.c.a.m.u.c0;

import android.util.Log;
import c.c.a.m.u.c0.c;
import c.c.a.m.u.c0.f;
import c.c.a.m.u.c0.g;
import c.c.a.m.u.c0.h;
import c.c.a.m.u.c0.l;
import f.b.k.h;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class i
implements c.c.a.m.u.c0.b {
    public final g<a, Object> a = new g();
    public final b b = new b();
    public final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
    public final Map<Class<?>, c.c.a.m.u.c0.a<?>> d = new HashMap();
    public final int e;
    public int f;

    public i(int n2) {
        this.e = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(int n2) {
        i i2 = this;
        synchronized (i2) {
            if (n2 >= 40) {
                i2 = this;
                synchronized (i2) {
                    this.c(0);
                }
            } else if (n2 >= 20 || n2 == 15) {
                this.c(this.e / 2);
            }
            return;
        }
    }

    public final void b(int n2, Class<?> class_) {
        NavigableMap<Integer, Integer> navigableMap = this.j(class_);
        Integer n3 = (Integer)navigableMap.get((Object)n2);
        if (n3 != null) {
            int n4 = n3;
            Integer n5 = n2;
            if (n4 == 1) {
                navigableMap.remove((Object)n5);
                return;
            }
            navigableMap.put((Object)n5, (Object)(n3 - 1));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tried to decrement empty size, size: ");
        stringBuilder.append(n2);
        stringBuilder.append(", this: ");
        stringBuilder.append((Object)this);
        throw new NullPointerException(stringBuilder.toString());
    }

    public final void c(int n2) {
        while (this.f > n2) {
            Object object = this.a.c();
            h.i.p(object, "Argument must not be null");
            c.c.a.m.u.c0.a<Object> a2 = this.h(object.getClass());
            this.f -= a2.b(object) * a2.c();
            this.b(a2.b(object), object.getClass());
            if (!Log.isLoggable((String)a2.a(), (int)2)) continue;
            String string = a2.a();
            StringBuilder stringBuilder = c.b.a.a.a.c("evicted: ");
            stringBuilder.append(a2.b(object));
            Log.v((String)string, (String)stringBuilder.toString());
        }
    }

    @Override
    public void d() {
        i i2 = this;
        synchronized (i2) {
            this.c(0);
            return;
        }
    }

    @Override
    public <T> T e(int n2, Class<T> class_) {
        i i2 = this;
        synchronized (i2) {
            a a2 = (a)this.b.b();
            a2.b = n2;
            a2.c = class_;
            T t2 = this.i(a2, class_);
            return t2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public <T> void f(T t2) {
        i i2 = this;
        synchronized (i2) {
            Class class_ = t2.getClass();
            c.c.a.m.u.c0.a<T> a2 = this.h(class_);
            int n2 = a2.b(t2);
            int n3 = n2 * a2.c();
            int n4 = this.e / 2;
            int n5 = 1;
            if (n3 > n4) return;
            int n6 = n5;
            if (n6 == 0) {
                return;
            }
            a a3 = this.b.d(n2, class_);
            this.a.b(a3, t2);
            NavigableMap<Integer, Integer> navigableMap = this.j(class_);
            Integer n7 = (Integer)navigableMap.get((Object)a3.b);
            Integer n8 = a3.b;
            if (n7 != null) {
                n5 += n7.intValue();
            }
            navigableMap.put((Object)n8, (Object)n5);
            this.f = n3 + this.f;
            this.c(this.e);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public <T> T g(int n2, Class<T> class_) {
        i i2 = this;
        synchronized (i2) {
            boolean bl;
            a a2;
            Integer n3;
            block8 : {
                block7 : {
                    n3 = (Integer)this.j(class_).ceilingKey((Object)n2);
                    bl = true;
                    if (n3 == null) break block7;
                    int n4 = this.f;
                    boolean bl2 = n4 != 0 && this.e / n4 < 2 ? false : bl;
                    if (bl2 || n3 <= n2 * 8) break block8;
                }
                bl = false;
            }
            if (bl) {
                a2 = this.b.d(n3, class_);
            } else {
                a a3 = (a)this.b.b();
                a3.b = n2;
                a3.c = class_;
                a2 = a3;
            }
            T t2 = this.i(a2, class_);
            return t2;
        }
    }

    public final <T> c.c.a.m.u.c0.a<T> h(Class<T> class_) {
        c.c.a.m.u.c0.a a2;
        block2 : {
            block5 : {
                c.c.a.m.u.c0.a<int[]> a3;
                block4 : {
                    block3 : {
                        a2 = (c.c.a.m.u.c0.a)this.d.get(class_);
                        if (a2 != null) break block2;
                        if (!class_.equals(int[].class)) break block3;
                        a3 = new h();
                        break block4;
                    }
                    if (!class_.equals(byte[].class)) break block5;
                    a3 = new f();
                }
                this.d.put(class_, (Object)a3);
                return a3;
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("No array pool found for: ");
            stringBuilder.append(class_.getSimpleName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return a2;
    }

    public final <T> T i(a a2, Class<T> class_) {
        c.c.a.m.u.c0.a<Object> a3 = this.h(class_);
        Object object = this.a.a(a2);
        if (object != null) {
            this.f -= a3.b(object) * a3.c();
            this.b(a3.b(object), class_);
        }
        if (object == null) {
            if (Log.isLoggable((String)a3.a(), (int)2)) {
                String string = a3.a();
                StringBuilder stringBuilder = c.b.a.a.a.c("Allocated ");
                stringBuilder.append(a2.b);
                stringBuilder.append(" bytes");
                Log.v((String)string, (String)stringBuilder.toString());
            }
            object = a3.newArray(a2.b);
        }
        return (T)object;
    }

    public final NavigableMap<Integer, Integer> j(Class<?> class_) {
        NavigableMap navigableMap = (NavigableMap)this.c.get(class_);
        if (navigableMap == null) {
            navigableMap = new TreeMap();
            this.c.put(class_, (Object)navigableMap);
        }
        return navigableMap;
    }

    public static final class a
    implements l {
        public final b a;
        public int b;
        public Class<?> c;

        public a(b b2) {
            this.a = b2;
        }

        @Override
        public void a() {
            this.a.c(this);
        }

        public boolean equals(Object object) {
            boolean bl = object instanceof a;
            boolean bl2 = false;
            if (bl) {
                a a2 = (a)object;
                int n2 = this.b;
                int n3 = a2.b;
                bl2 = false;
                if (n2 == n3) {
                    Class<?> class_ = this.c;
                    Class<?> class_2 = a2.c;
                    bl2 = false;
                    if (class_ == class_2) {
                        bl2 = true;
                    }
                }
            }
            return bl2;
        }

        public int hashCode() {
            int n2 = 31 * this.b;
            Class<?> class_ = this.c;
            int n3 = class_ != null ? class_.hashCode() : 0;
            return n2 + n3;
        }

        public String toString() {
            StringBuilder stringBuilder = c.b.a.a.a.c("Key{size=");
            stringBuilder.append(this.b);
            stringBuilder.append("array=");
            stringBuilder.append(this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static final class b
    extends c<a> {
        @Override
        public l a() {
            return new a(this);
        }

        public a d(int n2, Class<?> class_) {
            a a2 = (a)this.b();
            a2.b = n2;
            a2.c = class_;
            return a2;
        }
    }

}

