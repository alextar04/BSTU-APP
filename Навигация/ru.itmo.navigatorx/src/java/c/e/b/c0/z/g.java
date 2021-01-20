/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Properties
 *  java.util.Set
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.z.e;
import c.e.b.c0.z.f;
import c.e.b.c0.z.n;
import c.e.b.e0.a;
import c.e.b.e0.b;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.l;
import c.e.b.o;
import c.e.b.p;
import c.e.b.q;
import c.e.b.r;
import c.e.b.t;
import c.e.b.w;
import c.e.b.z;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class g
implements a0 {
    public final c.e.b.c0.g e;
    public final boolean f;

    public g(c.e.b.c0.g g2, boolean bl) {
        this.e = g2;
        this.f = bl;
    }

    @Override
    public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
        Type type;
        Type type2 = a2.b;
        if (!Map.class.isAssignableFrom(a2.a)) {
            return null;
        }
        Class<?> class_ = c.e.b.c0.a.e(type2);
        Type[] arrtype = type2 == Properties.class ? new Type[]{String.class, String.class} : ((type = c.e.b.c0.a.f(type2, class_, Map.class)) instanceof ParameterizedType ? ((ParameterizedType)type).getActualTypeArguments() : new Type[]{Object.class, Object.class});
        Type type3 = arrtype[0];
        z<Object> z2 = type3 != Boolean.TYPE && type3 != Boolean.class ? j2.b(new c.e.b.d0.a(type3)) : c.e.b.c0.z.o.f;
        z<Boolean> z3 = z2;
        z z4 = j2.b(new c.e.b.d0.a(arrtype[1]));
        c.e.b.c0.t<T> t2 = this.e.a(a2);
        a a3 = new a(j2, arrtype[0], z3, arrtype[1], z4, t2);
        return a3;
    }

    public final class a<K, V>
    extends z<Map<K, V>> {
        public final z<K> a;
        public final z<V> b;
        public final c.e.b.c0.t<? extends Map<K, V>> c;

        public a(j j2, Type type, z<K> z2, Type type2, z<V> z3, c.e.b.c0.t<? extends Map<K, V>> t2) {
            this.a = new n<K>(j2, z2, type);
            this.b = new n<V>(j2, z3, type2);
            this.c = t2;
        }

        @Override
        public Object a(c.e.b.e0.a a2) {
            Map<K, V> map;
            block9 : {
                block8 : {
                    b b2 = a2.T();
                    if (b2 == b.m) {
                        a2.P();
                        return null;
                    }
                    map = this.c.a();
                    if (b2 != b.e) break block8;
                    a2.c();
                    while (a2.v()) {
                        a2.c();
                        K k2 = this.a.a(a2);
                        if (map.put(k2, this.b.a(a2)) == null) {
                            a2.m();
                            continue;
                        }
                        throw new w(c.b.a.a.a.i("duplicate key: ", k2));
                    }
                    a2.m();
                    break block9;
                }
                a2.f();
                while (a2.v()) {
                    block10 : {
                        block16 : {
                            block12 : {
                                int n2;
                                block14 : {
                                    int n3;
                                    block15 : {
                                        block13 : {
                                            block11 : {
                                                if (c.e.b.c0.q.a == null) break block10;
                                                if (!(a2 instanceof e)) break block11;
                                                e e2 = (e)a2;
                                                e2.a0(b.i);
                                                Map.Entry entry = (Map.Entry)((Iterator)e2.b0()).next();
                                                e2.d0(entry.getValue());
                                                e2.d0(new t((String)entry.getKey()));
                                                break block12;
                                            }
                                            n3 = a2.l;
                                            if (n3 == 0) {
                                                n3 = a2.j();
                                            }
                                            if (n3 != 13) break block13;
                                            n2 = 9;
                                            break block14;
                                        }
                                        if (n3 != 12) break block15;
                                        n2 = 8;
                                        break block14;
                                    }
                                    if (n3 != 14) break block16;
                                    n2 = 10;
                                }
                                a2.l = n2;
                            }
                            K k3 = this.a.a(a2);
                            if (map.put(k3, this.b.a(a2)) == null) continue;
                            throw new w(c.b.a.a.a.i("duplicate key: ", k3));
                        }
                        StringBuilder stringBuilder = c.b.a.a.a.c("Expected a name but was ");
                        stringBuilder.append((Object)a2.T());
                        stringBuilder.append(a2.B());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    throw null;
                }
                a2.p();
            }
            return map;
        }

        @Override
        public void b(c c2, Object object) {
            block17 : {
                Map map;
                block16 : {
                    map = (Map)object;
                    if (map == null) {
                        c2.u();
                        return;
                    }
                    if (g.this.f) break block16;
                    c2.h();
                    for (Map.Entry entry : map.entrySet()) {
                        c2.s(String.valueOf((Object)entry.getKey()));
                        this.b.b(c2, entry.getValue());
                    }
                    break block17;
                }
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                Iterator iterator = map.entrySet().iterator();
                int n2 = 0;
                boolean bl = false;
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry)iterator.next();
                    z<K> z2 = this.a;
                    Object object2 = entry.getKey();
                    if (z2 != null) {
                        f f2;
                        block15 : {
                            o o2;
                            try {
                                f2 = new f();
                                z2.b(f2, object2);
                                if (!f2.n.isEmpty()) break block15;
                                o2 = f2.p;
                            }
                            catch (IOException iOException) {
                                throw new p(iOException);
                            }
                            arrayList.add((Object)o2);
                            arrayList2.add(entry.getValue());
                            if (o2 != null) {
                                boolean bl2 = o2 instanceof l || o2 instanceof r;
                                bl |= bl2;
                                continue;
                            }
                            throw null;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Expected one JSON element but was ");
                        stringBuilder.append(f2.n);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    throw null;
                }
                if (bl) {
                    c2.f();
                    int n3 = arrayList.size();
                    while (n2 < n3) {
                        c2.f();
                        o o3 = (o)arrayList.get(n2);
                        c.e.b.c0.z.o.X.b(c2, o3);
                        this.b.b(c2, arrayList2.get(n2));
                        c2.m();
                        ++n2;
                    }
                    c2.m();
                    return;
                }
                c2.h();
                int n4 = arrayList.size();
                while (n2 < n4) {
                    block18 : {
                        block24 : {
                            String string;
                            block21 : {
                                o o4;
                                block19 : {
                                    block23 : {
                                        t t2;
                                        Object object3;
                                        block22 : {
                                            block20 : {
                                                o4 = (o)arrayList.get(n2);
                                                if (o4 == null) break block18;
                                                if (!(o4 instanceof t)) break block19;
                                                t2 = o4.b();
                                                object3 = t2.a;
                                                if (!(object3 instanceof Number)) break block20;
                                                string = String.valueOf((Object)t2.d());
                                                break block21;
                                            }
                                            if (!(object3 instanceof Boolean)) break block22;
                                            string = Boolean.toString((boolean)t2.c());
                                            break block21;
                                        }
                                        if (!(object3 instanceof String)) break block23;
                                        string = t2.e();
                                        break block21;
                                    }
                                    throw new AssertionError();
                                }
                                if (!(o4 instanceof q)) break block24;
                                string = "null";
                            }
                            c2.s(string);
                            this.b.b(c2, arrayList2.get(n2));
                            ++n2;
                            continue;
                        }
                        throw new AssertionError();
                    }
                    throw null;
                }
            }
            c2.p();
        }
    }

}

