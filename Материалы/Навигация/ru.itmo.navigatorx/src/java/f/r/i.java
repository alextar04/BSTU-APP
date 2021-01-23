/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  f.h.l.l
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
package f.r;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListAdapter;
import android.widget.ListView;
import f.e.h;
import f.h.l.l;
import f.r.e;
import f.r.f0;
import f.r.i;
import f.r.j;
import f.r.k;
import f.r.n;
import f.r.o;
import f.r.q;
import f.r.r;
import f.r.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class i
implements Cloneable {
    public static final int[] J = new int[]{2, 1, 3, 4};
    public static final e K = new e(){

        public android.graphics.Path a(float f2, float f3, float f4, float f5) {
            android.graphics.Path path = new android.graphics.Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    public static ThreadLocal<f.e.a<Animator, b>> L = new ThreadLocal();
    public ArrayList<Animator> A = new ArrayList();
    public int B = 0;
    public boolean C = false;
    public boolean D = false;
    public ArrayList<d> E = null;
    public ArrayList<Animator> F = new ArrayList();
    public n G;
    public c H;
    public e I = K;
    public String e = this.getClass().getName();
    public long f = -1L;
    public long g = -1L;
    public TimeInterpolator h = null;
    public ArrayList<Integer> i = new ArrayList();
    public ArrayList<View> j = new ArrayList();
    public ArrayList<String> k = null;
    public ArrayList<Class<?>> l = null;
    public ArrayList<Integer> m = null;
    public ArrayList<View> n = null;
    public ArrayList<Class<?>> o = null;
    public ArrayList<String> p = null;
    public ArrayList<Integer> q = null;
    public ArrayList<View> r = null;
    public ArrayList<Class<?>> s = null;
    public r t = new r();
    public r u = new r();
    public o v = null;
    public int[] w = J;
    public ArrayList<q> x;
    public ArrayList<q> y;
    public boolean z = false;

    public static void c(r r2, View view, q q2) {
        ListView listView;
        String string;
        r2.a.put(view, q2);
        int n2 = view.getId();
        if (n2 >= 0) {
            if (r2.b.indexOfKey(n2) >= 0) {
                r2.b.put(n2, null);
            } else {
                r2.b.put(n2, (Object)view);
            }
        }
        if ((string = l.t((View)view)) != null) {
            boolean bl = r2.d.e(string) >= 0;
            if (bl) {
                r2.d.put(string, null);
            } else {
                r2.d.put(string, view);
            }
        }
        if (view.getParent() instanceof ListView && (listView = (ListView)view.getParent()).getAdapter().hasStableIds()) {
            long l2 = listView.getItemIdAtPosition(listView.getPositionForView(view));
            f.e.e<View> e2 = r2.c;
            if (e2.e) {
                e2.d();
            }
            if (f.e.d.b(e2.f, e2.h, l2) >= 0) {
                View view2 = r2.c.e(l2);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    r2.c.g(l2, null);
                    return;
                }
            } else {
                view.setHasTransientState(true);
                r2.c.g(l2, view);
            }
        }
    }

    public static f.e.a<Animator, b> p() {
        f.e.a a2 = (f.e.a)L.get();
        if (a2 == null) {
            a2 = new f.e.a();
            L.set(a2);
        }
        return a2;
    }

    public static boolean u(q q2, q q3, String string) {
        Object object = q2.a.get((Object)string);
        Object object2 = q3.a.get((Object)string);
        boolean bl = true;
        if (object == null && object2 == null) {
            return false;
        }
        if (object != null) {
            if (object2 == null) {
                return bl;
            }
            bl ^= object.equals(object2);
        }
        return bl;
    }

    public i A(long l2) {
        this.g = l2;
        return this;
    }

    public void B(c c2) {
        this.H = c2;
    }

    public i C(TimeInterpolator timeInterpolator) {
        this.h = timeInterpolator;
        return this;
    }

    public void D(e e2) {
        if (e2 == null) {
            e2 = K;
        }
        this.I = e2;
    }

    public void E(n n2) {
        this.G = n2;
    }

    public i F(long l2) {
        this.f = l2;
        return this;
    }

    public void G() {
        if (this.B == 0) {
            ArrayList<d> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList)this.E.clone();
                int n2 = arrayList2.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((d)arrayList2.get(i2)).c(this);
                }
            }
            this.D = false;
        }
        this.B = 1 + this.B;
    }

    public String H(String string) {
        StringBuilder stringBuilder = c.b.a.a.a.c(string);
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString((int)this.hashCode()));
        stringBuilder.append(": ");
        String string2 = stringBuilder.toString();
        if (this.g != -1L) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("dur(");
            stringBuilder2.append(this.g);
            stringBuilder2.append(") ");
            string2 = stringBuilder2.toString();
        }
        if (this.f != -1L) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string2);
            stringBuilder3.append("dly(");
            stringBuilder3.append(this.f);
            stringBuilder3.append(") ");
            string2 = stringBuilder3.toString();
        }
        if (this.h != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string2);
            stringBuilder4.append("interp(");
            stringBuilder4.append((Object)this.h);
            stringBuilder4.append(") ");
            string2 = stringBuilder4.toString();
        }
        if (this.i.size() > 0 || this.j.size() > 0) {
            String string3 = c.b.a.a.a.j(string2, "tgts(");
            if (this.i.size() > 0) {
                for (int i2 = 0; i2 < this.i.size(); ++i2) {
                    if (i2 > 0) {
                        string3 = c.b.a.a.a.j(string3, ", ");
                    }
                    StringBuilder stringBuilder5 = c.b.a.a.a.c(string3);
                    stringBuilder5.append(this.i.get(i2));
                    string3 = stringBuilder5.toString();
                }
            }
            int n2 = this.j.size();
            if (n2 > 0) {
                for (int i3 = 0; i3 < this.j.size(); ++i3) {
                    if (i3 > 0) {
                        string3 = c.b.a.a.a.j(string3, ", ");
                    }
                    StringBuilder stringBuilder6 = c.b.a.a.a.c(string3);
                    stringBuilder6.append(this.j.get(i3));
                    string3 = stringBuilder6.toString();
                }
            }
            string2 = c.b.a.a.a.j(string3, ")");
        }
        return string2;
    }

    public i a(d d2) {
        if (this.E == null) {
            this.E = new ArrayList();
        }
        this.E.add((Object)d2);
        return this;
    }

    public i b(View view) {
        this.j.add((Object)view);
        return this;
    }

    public void d() {
        for (int i2 = -1 + this.A.size(); i2 >= 0; --i2) {
            ((Animator)this.A.get(i2)).cancel();
        }
        ArrayList<d> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList)this.E.clone();
            int n2 = arrayList2.size();
            for (int i3 = 0; i3 < n2; ++i3) {
                ((d)arrayList2.get(i3)).d(this);
            }
        }
    }

    public abstract void e(q var1);

    public final void f(View view, boolean bl) {
        if (view == null) {
            return;
        }
        int n2 = view.getId();
        ArrayList<Integer> arrayList = this.m;
        if (arrayList != null && arrayList.contains((Object)n2)) {
            return;
        }
        ArrayList<View> arrayList2 = this.n;
        if (arrayList2 != null && arrayList2.contains((Object)view)) {
            return;
        }
        ArrayList<Class<?>> arrayList3 = this.o;
        int n3 = 0;
        if (arrayList3 != null) {
            int n4 = arrayList3.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                if (!((Class)this.o.get(i2)).isInstance((Object)view)) continue;
                return;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            q q2 = new q(view);
            if (bl) {
                this.h(q2);
            } else {
                this.e(q2);
            }
            q2.c.add((Object)this);
            this.g(q2);
            r r2 = bl ? this.t : this.u;
            i.c(r2, view, q2);
        }
        if (view instanceof ViewGroup) {
            ArrayList<Integer> arrayList4 = this.q;
            if (arrayList4 != null && arrayList4.contains((Object)n2)) {
                return;
            }
            ArrayList<View> arrayList5 = this.r;
            if (arrayList5 != null && arrayList5.contains((Object)view)) {
                return;
            }
            ArrayList<Class<?>> arrayList6 = this.s;
            if (arrayList6 != null) {
                int n5 = arrayList6.size();
                for (int i3 = 0; i3 < n5; ++i3) {
                    if (!((Class)this.s.get(i3)).isInstance((Object)view)) continue;
                    return;
                }
            }
            ViewGroup viewGroup = (ViewGroup)view;
            while (n3 < viewGroup.getChildCount()) {
                this.f(viewGroup.getChildAt(n3), bl);
                ++n3;
            }
        }
    }

    public void g(q q2) {
    }

    public abstract void h(q var1);

    public void i(ViewGroup viewGroup, boolean bl) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        this.j(bl);
        if (this.i.size() <= 0 && this.j.size() <= 0 || (arrayList2 = this.k) != null && !arrayList2.isEmpty() || (arrayList = this.l) != null && !arrayList.isEmpty()) {
            this.f((View)viewGroup, bl);
            return;
        }
        int n2 = 0;
        do {
            int n3 = this.i.size();
            if (n2 >= n3) break;
            View view = viewGroup.findViewById(((Integer)this.i.get(n2)).intValue());
            if (view != null) {
                q q2 = new q(view);
                if (bl) {
                    this.h(q2);
                } else {
                    this.e(q2);
                }
                q2.c.add((Object)this);
                this.g(q2);
                r r2 = bl ? this.t : this.u;
                i.c(r2, view, q2);
            }
            ++n2;
        } while (true);
        for (int i2 = 0; i2 < this.j.size(); ++i2) {
            View view = (View)this.j.get(i2);
            q q3 = new q(view);
            if (bl) {
                this.h(q3);
            } else {
                this.e(q3);
            }
            q3.c.add((Object)this);
            this.g(q3);
            r r3 = bl ? this.t : this.u;
            i.c(r3, view, q3);
        }
    }

    public void j(boolean bl) {
        r r2;
        if (bl) {
            this.t.a.clear();
            this.t.b.clear();
            r2 = this.t;
        } else {
            this.u.a.clear();
            this.u.b.clear();
            r2 = this.u;
        }
        r2.c.b();
    }

    public i k() {
        try {
            i i2 = (i)super.clone();
            i2.F = new ArrayList();
            i2.t = new r();
            i2.u = new r();
            i2.x = null;
            i2.y = null;
            return i2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public Animator l(ViewGroup viewGroup, q q2, q q3) {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void m(ViewGroup viewGroup, r r2, r r3, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        f.e.a<Animator, b> a2 = i.p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int n2 = arrayList.size();
        int n3 = 0;
        do {
            int n4;
            block14 : {
                q q2;
                View view;
                Animator animator;
                block16 : {
                    View view2;
                    Animator animator2;
                    q q3;
                    block8 : {
                        int n5;
                        Animator animator3;
                        block15 : {
                            block9 : {
                                q q4;
                                Animator animator4;
                                block11 : {
                                    block12 : {
                                        block13 : {
                                            block10 : {
                                                if (n3 >= n2) break block9;
                                                q4 = (q)arrayList.get(n3);
                                                q q5 = (q)arrayList2.get(n3);
                                                if (q4 != null && !q4.c.contains((Object)this)) {
                                                    q4 = null;
                                                }
                                                if (q5 != null && !q5.c.contains((Object)this)) {
                                                    q5 = null;
                                                }
                                                if (q4 == null && q5 == null) break block10;
                                                boolean bl = q4 == null || q5 == null || this.s(q4, q5);
                                                if (!bl || (animator4 = this.l(viewGroup, q4, q5)) == null) break block10;
                                                if (q5 == null) break block11;
                                                view2 = q5.b;
                                                String[] arrstring = this.q();
                                                if (arrstring == null || arrstring.length <= 0) break block12;
                                                q3 = new q(view2);
                                                q q6 = (q)r3.a.get((Object)view2);
                                                if (q6 == null) break block13;
                                                for (int i2 = 0; i2 < arrstring.length; ++i2) {
                                                    Map<String, Object> map = q3.a;
                                                    Animator animator5 = animator4;
                                                    String string = arrstring[i2];
                                                    int n6 = n2;
                                                    Map<String, Object> map2 = q6.a;
                                                    q q7 = q6;
                                                    map.put((Object)string, map2.get((Object)arrstring[i2]));
                                                    animator4 = animator5;
                                                    n2 = n6;
                                                    q6 = q7;
                                                }
                                                break block13;
                                            }
                                            n4 = n2;
                                            break block14;
                                        }
                                        animator3 = animator4;
                                        n4 = n2;
                                        n5 = a2.g;
                                        break block15;
                                    }
                                    Animator animator6 = animator4;
                                    n4 = n2;
                                    animator2 = animator6;
                                    q3 = null;
                                    break block8;
                                }
                                Animator animator7 = animator4;
                                n4 = n2;
                                view = q4.b;
                                animator = animator7;
                                q2 = null;
                                break block16;
                            }
                            if (sparseIntArray.size() != 0) {
                                for (int i3 = 0; i3 < sparseIntArray.size(); ++i3) {
                                    int n7 = sparseIntArray.keyAt(i3);
                                    Animator animator8 = (Animator)this.F.get(n7);
                                    animator8.setStartDelay((long)sparseIntArray.valueAt(i3) - Long.MAX_VALUE + animator8.getStartDelay());
                                }
                            }
                            return;
                        }
                        for (int i4 = 0; i4 < n5; ++i4) {
                            b b2 = (b)a2.get((Object)((Animator)a2.h(i4)));
                            if (b2.c == null || b2.a != view2 || !b2.b.equals((Object)this.e) || !b2.c.equals(q3)) continue;
                            animator2 = null;
                            break block8;
                        }
                        animator2 = animator3;
                    }
                    view = view2;
                    animator = animator2;
                    q2 = q3;
                }
                if (animator != null) {
                    b b3 = new b(view, this.e, this, v.c((View)viewGroup), q2);
                    a2.put(animator, b3);
                    this.F.add((Object)animator);
                }
            }
            ++n3;
            n2 = n4;
        } while (true);
    }

    public void n() {
        int n2;
        this.B = n2 = this.B - 1;
        if (n2 == 0) {
            ArrayList<d> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList)this.E.clone();
                int n3 = arrayList2.size();
                for (int i2 = 0; i2 < n3; ++i2) {
                    ((d)arrayList2.get(i2)).e(this);
                }
            }
            for (int i3 = 0; i3 < this.t.c.h(); ++i3) {
                View view = this.t.c.i(i3);
                if (view == null) continue;
                l.Y((View)view, (boolean)false);
            }
            for (int i4 = 0; i4 < this.u.c.h(); ++i4) {
                View view = this.u.c.i(i4);
                if (view == null) continue;
                l.Y((View)view, (boolean)false);
            }
            this.D = true;
        }
    }

    public q o(View view, boolean bl) {
        o o2 = this.v;
        if (o2 != null) {
            return o2.o(view, bl);
        }
        ArrayList<q> arrayList = bl ? this.x : this.y;
        if (arrayList == null) {
            return null;
        }
        int n2 = arrayList.size();
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            q q2 = (q)arrayList.get(i2);
            if (q2 == null) {
                return null;
            }
            if (q2.b != view) continue;
            n3 = i2;
            break;
        }
        q q3 = null;
        if (n3 >= 0) {
            ArrayList<q> arrayList2 = bl ? this.y : this.x;
            q3 = (q)arrayList2.get(n3);
        }
        return q3;
    }

    public String[] q() {
        return null;
    }

    public q r(View view, boolean bl) {
        o o2 = this.v;
        if (o2 != null) {
            return o2.r(view, bl);
        }
        r r2 = bl ? this.t : this.u;
        return r2.a.getOrDefault((Object)view, null);
    }

    public boolean s(q q2, q q3) {
        boolean bl;
        block6 : {
            bl = false;
            if (q2 != null) {
                bl = false;
                if (q3 != null) {
                    block7 : {
                        String[] arrstring = this.q();
                        if (arrstring != null) {
                            int n2 = arrstring.length;
                            int n3 = 0;
                            do {
                                bl = false;
                                if (n3 >= n2) break block6;
                                if (!i.u(q2, q3, arrstring[n3])) {
                                    ++n3;
                                    continue;
                                }
                                break block7;
                                break;
                            } while (true);
                        }
                        Iterator iterator = q2.a.keySet().iterator();
                        do {
                            boolean bl2 = iterator.hasNext();
                            bl = false;
                            if (!bl2) break block6;
                        } while (!i.u(q2, q3, (String)iterator.next()));
                    }
                    bl = true;
                }
            }
        }
        return bl;
    }

    public boolean t(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int n2 = view.getId();
        ArrayList<Integer> arrayList3 = this.m;
        if (arrayList3 != null && arrayList3.contains((Object)n2)) {
            return false;
        }
        ArrayList<View> arrayList4 = this.n;
        if (arrayList4 != null && arrayList4.contains((Object)view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.o;
        if (arrayList5 != null) {
            int n3 = arrayList5.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                if (!((Class)this.o.get(i2)).isInstance((Object)view)) continue;
                return false;
            }
        }
        if (this.p != null && l.t((View)view) != null && this.p.contains((Object)view.getTransitionName())) {
            return false;
        }
        if (this.i.size() == 0 && this.j.size() == 0 && ((arrayList = this.l) == null || arrayList.isEmpty()) && ((arrayList2 = this.k) == null || arrayList2.isEmpty())) {
            return true;
        }
        if (!this.i.contains((Object)n2)) {
            if (this.j.contains((Object)view)) {
                return true;
            }
            ArrayList<String> arrayList6 = this.k;
            if (arrayList6 != null && arrayList6.contains((Object)l.t((View)view))) {
                return true;
            }
            if (this.l != null) {
                for (int i3 = 0; i3 < this.l.size(); ++i3) {
                    if (!((Class)this.l.get(i3)).isInstance((Object)view)) continue;
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public String toString() {
        return this.H("");
    }

    public void v(View view) {
        if (!this.D) {
            f.e.a<Animator, b> a2 = i.p();
            int n2 = a2.g;
            f0 f02 = v.c(view);
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                b b2 = (b)a2.l(i2);
                if (b2.a == null || !f02.equals((Object)b2.d)) continue;
                ((Animator)a2.h(i2)).pause();
            }
            ArrayList<d> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList)this.E.clone();
                int n3 = arrayList2.size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    ((d)arrayList2.get(i3)).a(this);
                }
            }
            this.C = true;
        }
    }

    public i w(d d2) {
        ArrayList<d> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove((Object)d2);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    public i x(View view) {
        this.j.remove((Object)view);
        return this;
    }

    public void y(View view) {
        if (this.C) {
            if (!this.D) {
                f.e.a<Animator, b> a2 = i.p();
                int n2 = a2.g;
                f0 f02 = v.c(view);
                for (int i2 = n2 - 1; i2 >= 0; --i2) {
                    b b2 = (b)a2.l(i2);
                    if (b2.a == null || !f02.equals((Object)b2.d)) continue;
                    ((Animator)a2.h(i2)).resume();
                }
                ArrayList<d> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList)this.E.clone();
                    int n3 = arrayList2.size();
                    for (int i3 = 0; i3 < n3; ++i3) {
                        ((d)arrayList2.get(i3)).b(this);
                    }
                }
            }
            this.C = false;
        }
    }

    public void z() {
        this.G();
        f.e.a<Animator, b> a2 = i.p();
        for (Animator animator : this.F) {
            TimeInterpolator timeInterpolator;
            long l2;
            if (!a2.containsKey((Object)animator)) continue;
            this.G();
            if (animator == null) continue;
            animator.addListener((Animator.AnimatorListener)new j(this, a2));
            long l3 = this.g;
            if (l3 >= 0L) {
                animator.setDuration(l3);
            }
            if ((l2 = this.f) >= 0L) {
                animator.setStartDelay(l2 + animator.getStartDelay());
            }
            if ((timeInterpolator = this.h) != null) {
                animator.setInterpolator(timeInterpolator);
            }
            animator.addListener((Animator.AnimatorListener)new k(this));
            animator.start();
        }
        this.F.clear();
        this.n();
    }

    public static class b {
        public View a;
        public String b;
        public q c;
        public f0 d;
        public i e;

        public b(View view, String string, i i2, f0 f02, q q2) {
            this.a = view;
            this.b = string;
            this.c = q2;
            this.d = f02;
            this.e = i2;
        }
    }

    public static abstract class c {
    }

    public static interface d {
        public void a(i var1);

        public void b(i var1);

        public void c(i var1);

        public void d(i var1);

        public void e(i var1);
    }

}

