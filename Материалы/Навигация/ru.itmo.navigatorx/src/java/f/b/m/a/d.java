/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.StateSet
 *  java.lang.Object
 */
package f.b.m.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import f.b.m.a.b;

@SuppressLint(value={"RestrictedAPI"})
public class d
extends b {
    public a q;
    public boolean r;

    public d(a a2) {
    }

    public d(a a2, Resources resources) {
        this.f(new a(a2, this, resources));
        this.onStateChange(this.getState());
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        this.onStateChange(this.getState());
    }

    @Override
    public void f(b.c c2) {
        super.f(c2);
        if (c2 instanceof a) {
            this.q = (a)c2;
        }
    }

    public a g() {
        return new a(this.q, this, null);
    }

    public boolean isStateful() {
        return true;
    }

    @Override
    public Drawable mutate() {
        if (!this.r) {
            super.mutate();
            if (this == this) {
                this.q.e();
                this.r = true;
            }
        }
        return this;
    }

    @Override
    public boolean onStateChange(int[] arrn) {
        boolean bl = super.onStateChange(arrn);
        int n2 = this.q.g(arrn);
        if (n2 < 0) {
            n2 = this.q.g(StateSet.WILD_CARD);
        }
        return this.e(n2) || bl;
        {
        }
    }

    public static class a
    extends b.c {
        public int[][] J;

        public a(a a2, d d2, Resources resources) {
            super(a2, d2, resources);
            if (a2 != null) {
                this.J = a2.J;
                return;
            }
            this.J = new int[this.g.length][];
        }

        @Override
        public void e() {
            int[][] arrn = this.J;
            int[][] arrarrn = new int[arrn.length][];
            for (int i2 = -1 + arrn.length; i2 >= 0; --i2) {
                int[][] arrn2 = this.J;
                int[] arrn3 = arrn2[i2] != null ? (int[])arrn2[i2].clone() : null;
                arrarrn[i2] = arrn3;
            }
            this.J = arrarrn;
        }

        public int g(int[] arrn) {
            int[][] arrn2 = this.J;
            int n2 = this.h;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!StateSet.stateSetMatches((int[])arrn2[i2], (int[])arrn)) continue;
                return i2;
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new d(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

}

