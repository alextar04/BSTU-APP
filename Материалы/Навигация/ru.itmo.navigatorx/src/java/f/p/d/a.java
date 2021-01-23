/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$w
 *  f.p.d.a$a
 *  f.p.d.a$b
 *  f.p.d.t
 *  f.p.d.t$a
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package f.p.d;

import androidx.recyclerview.widget.RecyclerView;
import f.h.k.c;
import f.h.k.d;
import f.p.d.a;
import f.p.d.t;
import f.p.d.y;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class a
implements t.a {
    public c<b> a;
    public final ArrayList<b> b;
    public final ArrayList<b> c;
    public final a d;
    public final boolean e;
    public final t f;
    public int g;

    public a(a a2) {
        this.a = new d<b>(30);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.g = 0;
        this.d = a2;
        this.e = false;
        this.f = new t((t.a)this);
    }

    public final boolean a(int n2) {
        int n3 = this.c.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4;
            b b2 = this.c.get(i2);
            int n5 = b2.a;
            if (n5 == 8) {
                if (this.f(b2.d, i2 + 1) != n2) continue;
                return true;
            }
            if (n5 != 1) continue;
            int n6 = n4 + b2.d;
            for (n4 = b2.b; n4 < n6; ++n4) {
                if (this.f(n4, i2 + 1) != n2) continue;
                return true;
            }
        }
        return false;
    }

    public void b() {
        int n2 = this.c.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            a a2 = this.d;
            b b2 = this.c.get(i2);
            ((y)a2).a(b2);
        }
        this.l((List<b>)this.c);
        this.g = 0;
    }

    public void c() {
        this.b();
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            b b2 = this.b.get(i2);
            int n3 = b2.a;
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 4) {
                        if (n3 != 8) continue;
                        ((y)this.d).a(b2);
                        a a2 = this.d;
                        int n4 = b2.b;
                        int n5 = b2.d;
                        ((y)a2).e(n4, n5);
                        continue;
                    }
                    ((y)this.d).a(b2);
                    a a3 = this.d;
                    int n6 = b2.b;
                    int n7 = b2.d;
                    Object object = b2.c;
                    ((y)a3).c(n6, n7, object);
                    continue;
                }
                ((y)this.d).a(b2);
                a a4 = this.d;
                int n8 = b2.b;
                int n9 = b2.d;
                y y2 = (y)a4;
                y2.a.S(n8, n9, true);
                RecyclerView recyclerView = y2.a;
                recyclerView.m0 = true;
                RecyclerView.w w2 = recyclerView.j0;
                w2.c = n9 + w2.c;
                continue;
            }
            ((y)this.d).a(b2);
            a a5 = this.d;
            int n10 = b2.b;
            int n11 = b2.d;
            ((y)a5).d(n10, n11);
        }
        this.l((List<b>)this.b);
        this.g = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void d(b b2) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7 = b2.a;
        if (n7 != 1 && n7 != 8) {
            n5 = this.m(b2.b, n7);
            n3 = b2.b;
            int n8 = b2.a;
            if (n8 != 2) {
                if (n8 != 4) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("op should be remove or update.");
                    stringBuilder.append((Object)b2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                n2 = 1;
            } else {
                n2 = 0;
            }
            n6 = n4 = 1;
        } else {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        while (n4 < b2.d) {
            int n9 = this.m(b2.b + n2 * n4, b2.a);
            int n10 = b2.a;
            boolean bl = n10 != 2 ? n10 == 4 && n9 == n5 + 1 : n9 == n5;
            if (bl) {
                ++n6;
            } else {
                b b3 = this.h(b2.a, n5, n6, b2.c);
                this.e(b3, n3);
                if (!this.e) {
                    b3.c = null;
                    this.a.a(b3);
                }
                if (b2.a == 4) {
                    n3 += n6;
                }
                n6 = 1;
                n5 = n9;
            }
            ++n4;
        }
        Object object = b2.c;
        if (!this.e) {
            b2.c = null;
            this.a.a(b2);
        }
        if (n6 > 0) {
            b b4 = this.h(b2.a, n5, n6, object);
            this.e(b4, n3);
            if (!this.e) {
                b4.c = null;
                this.a.a(b4);
            }
        }
    }

    public void e(b b2, int n2) {
        ((y)this.d).a(b2);
        int n3 = b2.a;
        if (n3 != 2) {
            if (n3 == 4) {
                a a2 = this.d;
                int n4 = b2.d;
                Object object = b2.c;
                ((y)a2).c(n2, n4, object);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        a a3 = this.d;
        int n5 = b2.d;
        y y2 = (y)a3;
        y2.a.S(n2, n5, true);
        RecyclerView recyclerView = y2.a;
        recyclerView.m0 = true;
        RecyclerView.w w2 = recyclerView.j0;
        w2.c = n5 + w2.c;
    }

    public int f(int n2, int n3) {
        int n4 = this.c.size();
        while (n3 < n4) {
            b b2 = this.c.get(n3);
            int n5 = b2.a;
            if (n5 == 8) {
                int n6 = b2.b;
                if (n6 == n2) {
                    n2 = b2.d;
                } else {
                    if (n6 < n2) {
                        --n2;
                    }
                    if (b2.d <= n2) {
                        ++n2;
                    }
                }
            } else {
                int n7 = b2.b;
                if (n7 <= n2) {
                    if (n5 == 2) {
                        int n8 = b2.d;
                        if (n2 < n7 + n8) {
                            return -1;
                        }
                        n2 -= n8;
                    } else if (n5 == 1) {
                        n2 += b2.d;
                    }
                }
            }
            ++n3;
        }
        return n2;
    }

    public boolean g() {
        return this.b.size() > 0;
    }

    public b h(int n2, int n3, int n4, Object object) {
        b b2 = this.a.b();
        if (b2 == null) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        b2.a = n2;
        b2.b = n3;
        b2.d = n4;
        b2.c = object;
        return b2;
    }

    public final void i(b b2) {
        this.c.add((Object)b2);
        int n2 = b2.a;
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 4) {
                    if (n2 == 8) {
                        a a2 = this.d;
                        int n3 = b2.b;
                        int n4 = b2.d;
                        ((y)a2).e(n3, n4);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown update op type for ");
                    stringBuilder.append((Object)b2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                a a3 = this.d;
                int n5 = b2.b;
                int n6 = b2.d;
                Object object = b2.c;
                ((y)a3).c(n5, n6, object);
                return;
            }
            a a4 = this.d;
            int n7 = b2.b;
            int n8 = b2.d;
            y y2 = (y)a4;
            y2.a.S(n7, n8, false);
            y2.a.m0 = true;
            return;
        }
        a a5 = this.d;
        int n9 = b2.b;
        int n10 = b2.d;
        ((y)a5).d(n9, n10);
    }

    /*
     * Exception decompiling
     */
    public void j() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: CONTINUE without a while class org.benf.cfr.reader.b.a.b.e.e
        // org.benf.cfr.reader.b.a.b.e.p.k(GotoStatement.java:87)
        // org.benf.cfr.reader.b.a.b.e.r.f(IfStatement.java:103)
        // org.benf.cfr.reader.b.a.a.i.z(Op03SimpleStatement.java:503)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:598)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public void k(b b2) {
        if (!this.e) {
            b2.c = null;
            this.a.a(b2);
        }
    }

    public void l(List<b> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.k(list.get(i2));
        }
        list.clear();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int m(int n2, int n3) {
        for (int i2 = this.c.size() - 1; i2 >= 0; --i2) {
            int n4;
            b b2;
            int n5;
            block19 : {
                int n6;
                block20 : {
                    block27 : {
                        int n7;
                        block26 : {
                            int n8;
                            block25 : {
                                block21 : {
                                    block24 : {
                                        int n9;
                                        block23 : {
                                            block22 : {
                                                b2 = this.c.get(i2);
                                                n4 = b2.a;
                                                if (n4 != 8) break block19;
                                                int n10 = b2.b;
                                                int n11 = b2.d;
                                                if (n10 >= n11) {
                                                    int n12 = n11;
                                                    n11 = n10;
                                                    n10 = n12;
                                                }
                                                if (n2 < n10 || n2 > n11) break block20;
                                                n8 = b2.b;
                                                if (n10 != n8) break block21;
                                                if (n3 != 1) break block22;
                                                n9 = 1 + b2.d;
                                                break block23;
                                            }
                                            if (n3 != 2) break block24;
                                            n9 = b2.d - 1;
                                        }
                                        b2.d = n9;
                                    }
                                    ++n2;
                                    continue;
                                }
                                if (n3 != 1) break block25;
                                n7 = n8 + 1;
                                break block26;
                            }
                            if (n3 != 2) break block27;
                            n7 = n8 - 1;
                        }
                        b2.b = n7;
                    }
                    --n2;
                    continue;
                }
                int n13 = b2.b;
                if (n2 >= n13) continue;
                if (n3 == 1) {
                    b2.b = n13 + 1;
                    n6 = 1 + b2.d;
                } else {
                    if (n3 != 2) continue;
                    b2.b = n13 - 1;
                    n6 = b2.d - 1;
                }
                b2.d = n6;
                continue;
            }
            int n14 = b2.b;
            if (n14 <= n2) {
                if (n4 == 1) {
                    n2 -= b2.d;
                    continue;
                }
                if (n4 != 2) continue;
                n2 += b2.d;
                continue;
            }
            if (n3 == 1) {
                n5 = n14 + 1;
            } else {
                if (n3 != 2) continue;
                n5 = n14 - 1;
            }
            b2.b = n5;
        }
        int n15 = this.c.size() - 1;
        do {
            block29 : {
                b b3;
                block30 : {
                    block28 : {
                        if (n15 < 0) {
                            return n2;
                        }
                        b3 = this.c.get(n15);
                        if (b3.a != 8) break block28;
                        int n16 = b3.d;
                        if (n16 != b3.b && n16 >= 0) break block29;
                        this.c.remove(n15);
                        if (this.e) break block29;
                        break block30;
                    }
                    if (b3.d > 0) break block29;
                    this.c.remove(n15);
                    if (this.e) break block29;
                }
                b3.c = null;
                this.a.a(b3);
            }
            --n15;
        } while (true);
    }
}

