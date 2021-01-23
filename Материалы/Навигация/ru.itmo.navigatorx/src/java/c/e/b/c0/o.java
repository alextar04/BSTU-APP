/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package c.e.b.c0;

import c.e.b.a0;
import c.e.b.b0.d;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.z;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class o
implements a0,
Cloneable {
    public static final o j = new o();
    public double e = -1.0;
    public int f = 136;
    public boolean g = true;
    public List<c.e.b.a> h = Collections.emptyList();
    public List<c.e.b.a> i = Collections.emptyList();

    @Override
    public <T> z<T> a(final j j2, final c.e.b.d0.a<T> a2) {
        Class class_ = a2.a;
        boolean bl = this.b(class_);
        final boolean bl2 = bl || this.c(class_, true);
        final boolean bl3 = bl || this.c(class_, false);
        if (!bl2 && !bl3) {
            return null;
        }
        z z2 = new z<T>(){
            public z<T> a;

            @Override
            public T a(c.e.b.e0.a a22) {
                if (bl3) {
                    a22.Y();
                    return null;
                }
                z<T> z2 = this.a;
                if (z2 == null) {
                    z2 = j2.c(o.this, a2);
                    this.a = z2;
                }
                return z2.a(a22);
            }

            @Override
            public void b(c c2, T t2) {
                if (bl2) {
                    c2.u();
                    return;
                }
                z<T> z2 = this.a;
                if (z2 == null) {
                    z2 = j2.c(o.this, a2);
                    this.a = z2;
                }
                z2.b(c2, t2);
            }
        };
        return z2;
    }

    public final boolean b(Class<?> class_) {
        if (this.e != -1.0 && !this.f((c.e.b.b0.c)class_.getAnnotation(c.e.b.b0.c.class), (d)class_.getAnnotation(d.class))) {
            return true;
        }
        if (!this.g && this.e(class_)) {
            return true;
        }
        return this.d(class_);
    }

    public final boolean c(Class<?> class_, boolean bl) {
        List<c.e.b.a> list = bl ? this.h : this.i;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!((c.e.b.a)iterator.next()).a(class_)) continue;
            return true;
        }
        return false;
    }

    public Object clone() {
        try {
            o o2 = (o)super.clone();
            return o2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public final boolean d(Class<?> class_) {
        return !Enum.class.isAssignableFrom(class_) && (class_.isAnonymousClass() || class_.isLocalClass());
    }

    public final boolean e(Class<?> class_) {
        boolean bl;
        return class_.isMemberClass() && !(bl = (8 & class_.getModifiers()) != 0);
    }

    public final boolean f(c.e.b.b0.c c2, d d2) {
        boolean bl = c2 == null || !(c2.value() > this.e);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = d2 == null || !(d2.value() <= this.e);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

}

