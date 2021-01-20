/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  f.h.l.l
 *  f.l.d.l0
 *  f.r.d$c
 *  f.r.f
 *  f.r.h
 *  f.r.i
 *  f.r.i$c
 *  f.r.i$d
 *  f.r.m
 *  f.r.m$a
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package f.r;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import f.h.l.l;
import f.l.d.l0;
import f.r.d;
import f.r.f;
import f.r.h;
import f.r.i;
import f.r.m;
import f.r.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressLint(value={"RestrictedApi"})
public class d
extends l0 {
    public static boolean x(i i2) {
        return !l0.k((List)i2.i) || !l0.k((List)i2.k) || !l0.k((List)i2.l);
        {
        }
    }

    public void a(Object object, View view) {
        if (object != null) {
            ((i)object).b(view);
        }
    }

    public void b(Object object, ArrayList<View> arrayList) {
        block4 : {
            int n2;
            i i2;
            block3 : {
                i2 = (i)object;
                if (i2 == null) {
                    return;
                }
                boolean bl = i2 instanceof o;
                if (!bl) break block3;
                o o2 = (o)i2;
                int n3 = o2.M.size();
                for (n2 = 0; n2 < n3; ++n2) {
                    this.b((Object)o2.J(n2), arrayList);
                }
                break block4;
            }
            if (d.x(i2) || !l0.k((List)i2.j)) break block4;
            int n4 = arrayList.size();
            while (n2 < n4) {
                i2.b((View)arrayList.get(n2));
                ++n2;
            }
        }
    }

    public void c(ViewGroup viewGroup, Object object) {
        i i2 = (i)object;
        if (!m.c.contains((Object)viewGroup) && l.A((View)viewGroup)) {
            m.c.add((Object)viewGroup);
            i i3 = i2.k();
            ArrayList arrayList = m.a().getOrDefault((Object)viewGroup, null);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    ((i)iterator.next()).v((View)viewGroup);
                }
            }
            if (i3 != null) {
                i3.i(viewGroup, true);
            }
            if ((h)viewGroup.getTag(f.transition_current_scene) == null) {
                viewGroup.setTag(f.transition_current_scene, null);
                if (i3 != null) {
                    m.a a2 = new m.a(i3, viewGroup);
                    viewGroup.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)a2);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)a2);
                    return;
                }
            } else {
                throw null;
            }
        }
    }

    public boolean e(Object object) {
        return object instanceof i;
    }

    public Object g(Object object) {
        if (object != null) {
            return ((i)object).k();
        }
        return null;
    }

    public Object l(Object object, Object object2, Object object3) {
        Object object4 = (i)object;
        i i2 = (i)object2;
        i i3 = (i)object3;
        if (object4 != null && i2 != null) {
            o o2 = new o();
            o2.I((i)object4);
            o2.I(i2);
            o2.K(1);
            object4 = o2;
        } else if (object4 == null) {
            object4 = i2 != null ? i2 : null;
        }
        if (i3 != null) {
            o o3 = new o();
            if (object4 != null) {
                o3.I((i)object4);
            }
            o3.I(i3);
            return o3;
        }
        return object4;
    }

    public Object m(Object object, Object object2, Object object3) {
        o o2 = new o();
        if (object != null) {
            o2.I((i)object);
        }
        if (object2 != null) {
            o2.I((i)object2);
        }
        if (object3 != null) {
            o2.I((i)object3);
        }
        return o2;
    }

    public void n(Object object, View view) {
        if (object != null) {
            ((i)object).x(view);
        }
    }

    public void o(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        block6 : {
            int n2;
            int n3;
            ArrayList arrayList3;
            i i2;
            block5 : {
                i2 = (i)object;
                boolean bl = i2 instanceof o;
                if (!bl) break block5;
                o o2 = (o)i2;
                int n4 = o2.M.size();
                for (n3 = 0; n3 < n4; ++n3) {
                    this.o((Object)o2.J(n3), arrayList, arrayList2);
                }
                break block6;
            }
            if (d.x(i2) || (arrayList3 = i2.j).size() != arrayList.size() || !arrayList3.containsAll(arrayList)) break block6;
            if (arrayList2 == null) {
                n2 = 0;
                n3 = 0;
            } else {
                n2 = arrayList2.size();
            }
            while (n3 < n2) {
                i2.b((View)arrayList2.get(n3));
                ++n3;
            }
            int n5 = arrayList.size();
            while (--n5 >= 0) {
                i2.x((View)arrayList.get(n5));
            }
        }
    }

    public void p(Object object, final View view, final ArrayList<View> arrayList) {
        ((i)object).a(new i.d(this){

            public void a(i i2) {
            }

            public void b(i i2) {
            }

            public void c(i i2) {
            }

            public void d(i i2) {
            }

            public void e(i i2) {
                i2.w((i.d)this);
                view.setVisibility(8);
                int n2 = arrayList.size();
                for (int i3 = 0; i3 < n2; ++i3) {
                    ((View)arrayList.get(i3)).setVisibility(0);
                }
            }
        });
    }

    public void q(Object object, Object object2, ArrayList<View> arrayList, Object object3, ArrayList<View> arrayList2, Object object4, ArrayList<View> arrayList3) {
        i i2 = (i)object;
        c c2 = new c(this, object2, arrayList, object3, arrayList2, object4, arrayList3);
        i2.a((i.d)c2);
    }

    public void r(Object object, Rect rect) {
        if (object != null) {
            ((i)object).B(new i.c(this, rect){});
        }
    }

    public void s(Object object, View view) {
        if (view != null) {
            i i2 = (i)object;
            Rect rect = new Rect();
            this.j(view, rect);
            i2.B(new i.c(this, rect){});
        }
    }

    public void u(Object object, View view, ArrayList<View> arrayList) {
        o o2 = (o)((Object)object);
        ArrayList arrayList2 = o2.j;
        arrayList2.clear();
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            l0.d((List)arrayList2, (View)((View)arrayList.get(i2)));
        }
        arrayList2.add((Object)view);
        arrayList.add((Object)view);
        this.b((Object)o2, arrayList);
    }

    public void v(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        o o2 = (o)((Object)object);
        if (o2 != null) {
            o2.j.clear();
            o2.j.addAll(arrayList2);
            this.o((Object)o2, arrayList, arrayList2);
        }
    }

    public Object w(Object object) {
        if (object == null) {
            return null;
        }
        o o2 = new o();
        o2.I((i)object);
        return o2;
    }

}

