/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package c.e.a.a.l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import c.e.a.a.l.a;

public class h {
    public long a = 0L;
    public long b = 300L;
    public TimeInterpolator c = null;
    public int d = 0;
    public int e = 1;

    public h(long l2, long l3) {
        this.a = l2;
        this.b = l3;
    }

    public h(long l2, long l3, TimeInterpolator timeInterpolator) {
        this.a = l2;
        this.b = l3;
        this.c = timeInterpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.a);
        animator.setDuration(this.b);
        animator.setInterpolator(this.b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator)animator;
            valueAnimator.setRepeatCount(this.d);
            valueAnimator.setRepeatMode(this.e);
        }
    }

    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.c;
        if (timeInterpolator != null) {
            return timeInterpolator;
        }
        return a.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof h)) {
            return false;
        }
        h h2 = (h)object;
        if (this.a != h2.a) {
            return false;
        }
        if (this.b != h2.b) {
            return false;
        }
        if (this.d != h2.d) {
            return false;
        }
        if (this.e != h2.e) {
            return false;
        }
        return this.b().getClass().equals((Object)h2.b().getClass());
    }

    public int hashCode() {
        long l2 = this.a;
        int n2 = 31 * (int)(l2 ^ l2 >>> 32);
        long l3 = this.b;
        return 31 * (31 * (31 * (n2 + (int)(l3 ^ l3 >>> 32)) + this.b().getClass().hashCode()) + this.d) + this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(h.class.getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)this)));
        stringBuilder.append(" delay: ");
        stringBuilder.append(this.a);
        stringBuilder.append(" duration: ");
        stringBuilder.append(this.b);
        stringBuilder.append(" interpolator: ");
        stringBuilder.append((Object)this.b().getClass());
        stringBuilder.append(" repeatCount: ");
        stringBuilder.append(this.d);
        stringBuilder.append(" repeatMode: ");
        stringBuilder.append(this.e);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

