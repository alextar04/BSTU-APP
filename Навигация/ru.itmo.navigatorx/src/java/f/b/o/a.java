/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package f.b.o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class a {
    public Object e;
    public boolean f;

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public abstract CharSequence h();

    public abstract void i();

    public abstract boolean j();

    public abstract void k(View var1);

    public abstract void l(int var1);

    public abstract void m(CharSequence var1);

    public abstract void n(int var1);

    public abstract void o(CharSequence var1);

    public abstract void p(boolean var1);

    public static interface a {
        public boolean a(a var1, Menu var2);

        public boolean b(a var1, MenuItem var2);

        public boolean c(a var1, Menu var2);

        public void d(a var1);
    }

}

