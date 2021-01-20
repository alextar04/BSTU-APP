/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.f
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.a;

import d.a.a.p;
import h.m.b.f;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class k<E> {
    public static final AtomicReferenceFieldUpdater e;
    public static final AtomicLongFieldUpdater f;
    public static final p g;
    public static final a h;
    public volatile Object _next;
    public volatile long _state;
    public final int a;
    public AtomicReferenceArray b;
    public final int c;
    public final boolean d;

    public static {
        h = new a(null);
        g = new p("REMOVE_FROZEN");
        e = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, (String)"_next");
        f = AtomicLongFieldUpdater.newUpdater(k.class, (String)"_state");
    }

    public k(int n2, boolean bl) {
        this.c = n2;
        this.d = bl;
        int n3 = 1;
        this.a = n2 - n3;
        this._next = null;
        this._state = 0L;
        this.b = new AtomicReferenceArray(this.c);
        int n4 = this.a <= 1073741823 ? n3 : 0;
        if (n4 != 0) {
            if ((this.c & this.a) != 0) {
                n3 = 0;
            }
            if (n3 != 0) {
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final int a(E var1_1) {
        do lbl-1000: // 3 sources:
        {
            var2_2 = this._state;
            var4_3 = 0x3000000000000000L & var2_2 LCMP 0L;
            var5_4 = 1;
            if (var4_3 != false) {
                if ((var2_2 & 0x2000000000000000L) == 0L) return var5_4;
                return 2;
            }
            var8_7 = this.a;
            var7_6 = (int)((1152921503533105152L & var2_2) >> 30);
            var6_5 = (int)((0x3FFFFFFFL & var2_2) >> 0);
            if ((var8_7 & var7_6 + 2) == (var6_5 & var8_7)) {
                return var5_4;
            }
            if (this.d || this.b.get(var7_6 & var8_7) == null) continue;
            var12_9 = this.c;
            if (var12_9 < 1024) return var5_4;
            if ((1073741823 & var7_6 - var6_5) <= var12_9 >> 1) ** GOTO lbl-1000
            return var5_4;
        } while (!k.f.compareAndSet((Object)this, var2_2, -1152921503533105153L & var2_2 | (long)(var9_8 = 1073741823 & var7_6 + 1) << 30));
        this.b.set(var7_6 & var8_7, var1_1);
        var10_10 = this;
        do {
            if ((0x1000000000000000L & var10_10._state) == 0L) {
                return 0;
            }
            var10_10 = var10_10.d();
            var11_11 = var10_10.b.get(var7_6 & var10_10.a);
            if (var11_11 instanceof b && ((b)var11_11).a == var7_6) {
                var10_10.b.set(var7_6 & var10_10.a, var1_1);
            } else {
                var10_10 = null;
            }
            if (var10_10 == null) return 0;
        } while (true);
    }

    public final boolean b() {
        long l2;
        long l3;
        do {
            if (((l2 = this._state) & 0x2000000000000000L) != 0L) {
                return true;
            }
            if ((0x1000000000000000L & l2) == 0L) continue;
            return false;
        } while (!f.compareAndSet((Object)this, l2, l3 = l2 | 0x2000000000000000L));
        return true;
    }

    public final boolean c() {
        long l2 = this._state;
        int n2 = (int)((0x3FFFFFFFL & l2) >> 0);
        int n3 = (int)((l2 & 1152921503533105152L) >> 30);
        boolean bl = false;
        if (n2 == n3) {
            bl = true;
        }
        return bl;
    }

    public final k<E> d() {
        long l2;
        while (((l2 = this._state) & 0x1000000000000000L) == 0L) {
            long l3 = l2 | 0x1000000000000000L;
            if (!f.compareAndSet((Object)this, l2, l3)) continue;
            l2 = l3;
            break;
        }
        k k2;
        while ((k2 = (k)this._next) == null) {
            int n2;
            int n3;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            k<E> k3 = new k<E>(2 * this.c, this.d);
            int n4 = (int)((0x3FFFFFFFL & l2) >> 0);
            int n5 = (int)((1152921503533105152L & l2) >> 30);
            while ((n3 = n4 & (n2 = this.a)) != (n2 & n5)) {
                Object object = this.b.get(n3);
                if (object == null) {
                    object = new b(n4);
                }
                k3.b.set(n4 & k3.a, object);
                ++n4;
            }
            k3._state = -1152921504606846977L & l2;
            atomicReferenceFieldUpdater.compareAndSet((Object)this, null, k3);
        }
        return k2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final Object e() {
        do lbl-1000: // 3 sources:
        {
            block7 : {
                if (((var1_1 = this._state) & 0x1000000000000000L) != 0L) {
                    return k.g;
                }
                var4_3 = (int)((1152921503533105152L & var1_1) >> 30);
                var5_4 = this.a;
                var6_5 = var4_3 & var5_4;
                var3_2 = (int)((var1_1 & 0x3FFFFFFFL) >> 0);
                var7_6 = var5_4 & var3_2;
                if (var6_5 == var7_6) {
                    return null;
                }
                var8_7 = this.b.get(var7_6);
                if (var8_7 != null) break block7;
                if (!this.d) ** GOTO lbl-1000
                return null;
            }
            if (var8_7 instanceof b) {
                return null;
            }
            var10_9 = k.f;
            var11_10 = var1_1 & -1073741824L;
            var9_8 = 1073741823 & var3_2 + 1;
            var13_11 = (long)var9_8 << 0;
            if (!var10_9.compareAndSet((Object)this, var1_1, var11_10 | var13_11)) continue;
            this.b.set(var3_2 & this.a, null);
            return var8_7;
        } while (!this.d);
        var15_12 = this;
        do {
            var16_13 = var15_12._state;
            var18_14 = (int)((var16_13 & 0x3FFFFFFFL) >> 0);
            if ((var16_13 & 0x1000000000000000L) != 0L) {
                var15_12 = var15_12.d();
            } else {
                var19_15 = k.f;
                var20_16 = var13_11 | var16_13 & -1073741824L;
                if (!var19_15.compareAndSet(var15_12, var16_13, var20_16)) continue;
                var15_12.b.set(var18_14 & var15_12.a, null);
                var15_12 = null;
            }
            if (var15_12 == null) return var8_7;
        } while (true);
    }

    public static final class a {
        public a(f f2) {
        }
    }

    public static final class b {
        public final int a;

        public b(int n2) {
            this.a = n2;
        }
    }

}

