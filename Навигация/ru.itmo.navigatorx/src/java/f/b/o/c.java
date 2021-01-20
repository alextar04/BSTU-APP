/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.view.LayoutInflater
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package f.b.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import f.b.i;

public class c
extends ContextWrapper {
    public int a;
    public Resources.Theme b;
    public LayoutInflater c;
    public Configuration d;
    public Resources e;

    public c() {
        super(null);
    }

    public c(Context context, int n2) {
        super(context);
        this.a = n2;
    }

    public c(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }

    public void a(Configuration configuration) {
        if (this.e == null) {
            if (this.d == null) {
                this.d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        boolean bl = this.b == null;
        if (bl) {
            this.b = this.getResources().newTheme();
            Resources.Theme theme = this.getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.a, true);
    }

    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    public Resources getResources() {
        if (this.e == null) {
            Configuration configuration = this.d;
            Resources resources = configuration == null ? super.getResources() : this.createConfigurationContext(configuration).getResources();
            this.e = resources;
        }
        return this.e;
    }

    public Object getSystemService(String string) {
        if ("layout_inflater".equals((Object)string)) {
            if (this.c == null) {
                this.c = LayoutInflater.from((Context)this.getBaseContext()).cloneInContext((Context)this);
            }
            return this.c;
        }
        return this.getBaseContext().getSystemService(string);
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = i.Theme_AppCompat_Light;
        }
        this.b();
        return this.b;
    }

    public void setTheme(int n2) {
        if (this.a != n2) {
            this.a = n2;
            this.b();
        }
    }
}

