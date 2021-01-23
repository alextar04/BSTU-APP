/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package c.e.a.a.l;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import c.e.a.a.l.a;
import c.e.a.a.l.h;
import java.util.ArrayList;
import java.util.List;

public class g {
    public final f.e.h<String, h> a = new f.e.h();
    public final f.e.h<String, PropertyValuesHolder[]> b = new f.e.h();

    public static g a(Context context, TypedArray typedArray, int n2) {
        int n3;
        if (typedArray.hasValue(n2) && (n3 = typedArray.getResourceId(n2, 0)) != 0) {
            return g.b(context, n3);
        }
        return null;
    }

    public static g b(Context context, int n2) {
        block4 : {
            Animator animator;
            try {
                animator = AnimatorInflater.loadAnimator((Context)context, (int)n2);
                if (animator instanceof AnimatorSet) {
                    return g.c((List<Animator>)((AnimatorSet)animator).getChildAnimations());
                }
                if (animator == null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = c.b.a.a.a.c("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString((int)n2));
                Log.w((String)"MotionSpec", (String)stringBuilder.toString(), (Throwable)exception);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)animator);
            g g2 = g.c((List<Animator>)arrayList);
            return g2;
        }
        return null;
    }

    public static g c(List<Animator> list) {
        g g2 = new g();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Animator animator = (Animator)list.get(i2);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator)animator;
                String string = objectAnimator.getPropertyName();
                PropertyValuesHolder[] arrpropertyValuesHolder = objectAnimator.getValues();
                g2.b.put(string, arrpropertyValuesHolder);
                String string2 = objectAnimator.getPropertyName();
                long l2 = objectAnimator.getStartDelay();
                long l3 = objectAnimator.getDuration();
                TimeInterpolator timeInterpolator = objectAnimator.getInterpolator();
                if (!(timeInterpolator instanceof AccelerateDecelerateInterpolator) && timeInterpolator != null) {
                    if (timeInterpolator instanceof AccelerateInterpolator) {
                        timeInterpolator = a.c;
                    } else if (timeInterpolator instanceof DecelerateInterpolator) {
                        timeInterpolator = a.d;
                    }
                } else {
                    timeInterpolator = a.b;
                }
                h h2 = new h(l2, l3, timeInterpolator);
                h2.d = objectAnimator.getRepeatCount();
                h2.e = objectAnimator.getRepeatMode();
                g2.a.put(string2, h2);
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animator must be an ObjectAnimator: ");
            stringBuilder.append((Object)animator);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return g2;
    }

    public h d(String string) {
        boolean bl = this.a.getOrDefault(string, null) != null;
        if (bl) {
            return this.a.getOrDefault(string, null);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof g)) {
            return false;
        }
        g g2 = (g)object;
        return this.a.equals(g2.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(g.class.getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)this)));
        stringBuilder.append(" timings: ");
        stringBuilder.append(this.a);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

