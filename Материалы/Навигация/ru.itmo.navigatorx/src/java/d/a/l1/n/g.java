/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.l1.n.e
 *  d.a.r0$a
 *  f.b.k.h
 *  h.d
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.f$b
 *  h.k.h
 *  h.k.i.a
 *  h.m.a.l
 *  h.m.a.p
 *  h.m.a.q
 *  h.m.b.j
 *  h.q.b
 *  h.q.d
 *  h.r.a
 *  h.r.c
 *  h.r.d
 *  h.r.e
 *  java.lang.Appendable
 *  java.lang.ArithmeticException
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.CancellationException
 */
package d.a.l1.n;

import d.a.l1.b;
import d.a.l1.n.d;
import d.a.l1.n.e;
import d.a.l1.n.h;
import d.a.l1.n.i;
import d.a.r0;
import f.b.k.h;
import h.k.f;
import h.k.j.a.c;
import h.m.a.l;
import h.m.a.p;
import h.m.a.q;
import h.m.b.j;
import h.m.b.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

public final class g<T>
extends c
implements b<T> {
    public final int h;
    public f i;
    public h.k.d<? super h.h> j;
    public final b<T> k = null;
    public final f l;

    public g(b<? super T> b2, f f2) {
        super((h.k.d<Object>)e.f, (f)h.k.h.e);
        this.l = f2;
        this.h = ((Number)f2.fold((Object)0, (p)a.f)).intValue();
    }

    @Override
    public f d() {
        f f2;
        h.k.d<? super h.h> d2 = this.j;
        if (d2 != null && (f2 = d2.d()) != null) {
            return f2;
        }
        return h.k.h.e;
    }

    @Override
    public Object f(T t2, h.k.d<? super h.h> d2) {
        h.k.i.a a2;
        Object object;
        block3 : {
            a2 = h.k.i.a.e;
            try {
                object = this.k(d2, t2);
                if (object != a2) break block3;
            }
            catch (Throwable throwable) {
                this.i = new d(throwable);
                throw throwable;
            }
            j.e(d2, (String)"frame");
        }
        if (object == a2) {
            return object;
        }
        return h.h.a;
    }

    @Override
    public Object i(Object object) {
        h.k.d<? super h.h> d2;
        Throwable throwable = h.d.a((Object)object);
        if (throwable != null) {
            this.i = new d(throwable);
        }
        if ((d2 = this.j) != null) {
            d2.e(object);
        }
        return h.k.i.a.e;
    }

    @Override
    public void j() {
        super.j();
    }

    public final Object k(h.k.d<? super h.h> d2, T t2) {
        block22 : {
            f f2;
            block23 : {
                Comparable comparable;
                f2 = d2.d();
                r0 r02 = (r0)f2.get((f.b)r0.d);
                if (r02 != null && !r02.c()) {
                    throw r02.m();
                }
                f f3 = this.i;
                if (f3 == f2) break block22;
                boolean bl = f3 instanceof d;
                int n2 = 0;
                if (!bl) break block23;
                d d3 = (d)f3;
                StringBuilder stringBuilder = c.b.a.a.a.c("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                stringBuilder.append((Object)d3.f);
                stringBuilder.append(", but then emission attempt of value '");
                stringBuilder.append(t2);
                stringBuilder.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                String string = stringBuilder.toString();
                j.e((Object)string, (String)"$this$trimIndent");
                j.e((Object)string, (String)"$this$replaceIndent");
                j.e((Object)"", (String)"newIndent");
                j.e((Object)string, (String)"$this$lines");
                j.e((Object)string, (String)"$this$lineSequence");
                String[] arrstring = new String[]{"\r\n", "\n", "\r"};
                j.e((Object)string, (String)"$this$splitToSequence");
                j.e((Object)arrstring, (String)"delimiters");
                h.r.a a2 = new h.r.a((CharSequence)string, 0, 0, (p)new h.r.d(h.i.d(arrstring), false));
                h.r.e e2 = new h.r.e((CharSequence)string);
                j.e((Object)a2, (String)"$this$map");
                j.e((Object)e2, (String)"transform");
                List list = h.i.R1(new h.q.d((h.q.b)a2, (l)e2));
                ArrayList arrayList = new ArrayList();
                for (Object object : list) {
                    if (!(true ^ h.r.c.g((CharSequence)((String)object)))) continue;
                    arrayList.add(object);
                }
                ArrayList arrayList2 = new ArrayList(h.i.x(arrayList, 10));
                for (String string2 : arrayList) {
                    int n3;
                    block21 : {
                        int n4 = string2.length();
                        for (n3 = 0; n3 < n4; ++n3) {
                            if (!(true ^ h.i.M0(string2.charAt(n3)))) {
                                continue;
                            }
                            break block21;
                        }
                        n3 = -1;
                    }
                    if (n3 == -1) {
                        n3 = string2.length();
                    }
                    arrayList2.add((Object)n3);
                }
                j.e((Object)arrayList2, (String)"$this$minOrNull");
                Iterator iterator = arrayList2.iterator();
                if (!iterator.hasNext()) {
                    comparable = null;
                } else {
                    comparable = (Comparable)iterator.next();
                    while (iterator.hasNext()) {
                        Comparable comparable2 = (Comparable)iterator.next();
                        if (comparable.compareTo((Object)comparable2) <= 0) continue;
                        comparable = comparable2;
                    }
                }
                Integer n5 = (Integer)comparable;
                int n6 = n5 != null ? n5 : 0;
                int n7 = string.length() + 0 * list.size();
                int n8 = h.i.i0(list);
                ArrayList arrayList3 = new ArrayList();
                Iterator iterator2 = list.iterator();
                int n9 = 0;
                while (iterator2.hasNext()) {
                    block24 : {
                        block27 : {
                            String string3;
                            int n10;
                            block26 : {
                                String string4;
                                block25 : {
                                    Object object = iterator2.next();
                                    n10 = n9 + 1;
                                    if (n9 < 0) break block24;
                                    string4 = (String)object;
                                    if (n9 != 0 && n9 != n8 || !h.r.c.g((CharSequence)string4)) break block25;
                                    string3 = null;
                                    break block26;
                                }
                                j.e((Object)string4, (String)"$this$drop");
                                boolean bl2 = n6 >= 0;
                                if (!bl2) break block27;
                                int n11 = string4.length();
                                if (n6 <= n11) {
                                    n11 = n6;
                                }
                                string3 = string4.substring(n11);
                                j.d((Object)string3, (String)"(this as java.lang.String).substring(startIndex)");
                                j.e((Object)string3, (String)"line");
                            }
                            if (string3 != null) {
                                arrayList3.add(string3);
                            }
                            n9 = n10;
                            continue;
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Requested character count ");
                        stringBuilder2.append(n6);
                        stringBuilder2.append(" is less than zero.");
                        throw new IllegalArgumentException(stringBuilder2.toString().toString());
                    }
                    throw new ArithmeticException("Index overflow has happened.");
                }
                StringBuilder stringBuilder3 = new StringBuilder(n7);
                j.e((Object)arrayList3, (String)"$this$joinTo");
                j.e((Object)stringBuilder3, (String)"buffer");
                j.e((Object)"\n", (String)"separator");
                j.e((Object)"", (String)"prefix");
                j.e((Object)"", (String)"postfix");
                j.e((Object)"...", (String)"truncated");
                stringBuilder3.append((CharSequence)"");
                for (Object object : arrayList3) {
                    if (++n2 > 1) {
                        stringBuilder3.append((CharSequence)"\n");
                    }
                    h.i.b((Appendable)stringBuilder3, object, null);
                }
                stringBuilder3.append((CharSequence)"");
                String string5 = stringBuilder3.toString();
                j.d((Object)string5, (String)"mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
                throw new IllegalStateException(string5.toString());
            }
            if (((Number)f2.fold((Object)0, (p)new i(this))).intValue() == this.h) {
                this.i = f2;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Flow invariant is violated:\n");
                stringBuilder.append("\t\tFlow was collected in ");
                stringBuilder.append((Object)this.l);
                stringBuilder.append(",\n");
                stringBuilder.append("\t\tbut emission happened in ");
                stringBuilder.append((Object)f2);
                throw new IllegalStateException(c.b.a.a.a.l(stringBuilder, ".\n", "\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
        }
        this.j = d2;
        q<b<Object>, Object, h.k.d<? super h.h>, Object> q2 = h.a;
        b<T> b2 = this.k;
        if (b2 != null) {
            return q2.a(b2, t2, (Object)this);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
    }

}

