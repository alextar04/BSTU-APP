/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a.o;

import android.view.MotionEvent;
import c.a.a.k;
import h.m.b.f;
import h.m.b.j;

public final class a {
    public static final String c = "a";
    public static final k d;
    public int a;
    public final a b;

    public static {
        String string = c;
        j.d((Object)string, (String)"TAG");
        j.e((Object)string, (String)"tag");
        d = new k(string, null);
    }

    public a(a a2) {
        j.e((Object)a2, (String)"callback");
        this.b = a2;
    }

    public final boolean a() {
        return this.c(0);
    }

    public final int b(MotionEvent motionEvent) {
        boolean bl;
        int n2;
        boolean bl2;
        d.d("processTouchEvent:", "start.");
        boolean bl3 = this.a == 3;
        if (bl3) {
            return 2;
        }
        boolean bl4 = this.b.c(motionEvent);
        k k2 = d;
        Object[] arrobject = new Object[]{"processTouchEvent:", "scaleResult:", bl4};
        k2.d(arrobject);
        boolean bl5 = this.a == 2;
        if (!bl5) {
            k k3 = d;
            Object[] arrobject2 = new Object[]{"processTouchEvent:", "flingResult:", bl4 |= this.b.g(motionEvent)};
            k3.d(arrobject2);
        }
        if ((bl2 = this.a == 1) && ((n2 = motionEvent.getActionMasked()) == 1 || n2 == 3)) {
            d.a("processTouchEvent:", "up event while scrolling, dispatching endScrollGesture.");
            this.b.b();
        }
        if (bl4 && !(bl = this.a == 0)) {
            d.d("processTouchEvent:", "returning: TOUCH_STEAL");
            return 2;
        }
        k k4 = d;
        if (bl4) {
            k4.d("processTouchEvent:", "returning: TOUCH_LISTEN");
            return 1;
        }
        k4.d("processTouchEvent:", "returning: TOUCH_NO");
        this.a();
        return 0;
    }

    public final boolean c(int n2) {
        boolean bl;
        k k2 = d;
        Object[] arrobject = new Object[]{"trySetState:", this.d(n2)};
        k2.d(arrobject);
        if (!this.b.e(n2)) {
            return false;
        }
        if (n2 == this.a && !(bl = n2 == 3)) {
            return true;
        }
        int n3 = this.a;
        if (n2 != 0) {
            if (n2 != 1 ? (n2 != 2 ? n2 == 4 && n3 == 3 : n3 == 3) : n3 == 2 || n3 == 3) {
                return false;
            }
        } else {
            this.b.f();
        }
        this.b.d(n3);
        k k3 = d;
        Object[] arrobject2 = new Object[]{"setState:", this.d(n2)};
        k3.a(arrobject2);
        this.a = n2;
        return true;
    }

    public final String d(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            return "";
                        }
                        return "FLINGING";
                    }
                    return "ANIMATING";
                }
                return "PINCHING";
            }
            return "SCROLLING";
        }
        return "IDLE";
    }

    public static interface a {
        public void b();

        public boolean c(MotionEvent var1);

        public void d(int var1);

        public boolean e(int var1);

        public void f();

        public boolean g(MotionEvent var1);
    }

}

