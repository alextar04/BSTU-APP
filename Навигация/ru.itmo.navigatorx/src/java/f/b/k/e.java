/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  f.l.d.e
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.WeakHashMap
 */
package f.b.k;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import f.b.k.a;
import f.b.k.f;
import f.b.k.g;
import f.b.k.h;
import f.b.o.a;
import f.b.p.b1;
import f.b.p.j;
import f.b.p.m0;
import f.h.d.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class e
extends f.l.d.e
implements f,
f.h.d.f {
    public g r;
    public Resources s;

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.q().c(view, layoutParams);
    }

    /*
     * Exception decompiling
     */
    public void attachBaseContext(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl527 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public void closeOptionsMenu() {
        this.r();
        if (this.getWindow().hasFeature(0)) {
            Activity.super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        this.r();
        return d.super.dispatchKeyEvent(keyEvent);
    }

    @Override
    public Intent e() {
        return h.i.r0((Activity)this);
    }

    @Override
    public void f(f.b.o.a a2) {
    }

    public <T extends View> T findViewById(int n2) {
        h h2 = (h)this.q();
        h2.z();
        return (T)h2.i.findViewById(n2);
    }

    public MenuInflater getMenuInflater() {
        h h2 = (h)this.q();
        if (h2.m == null) {
            h2.F();
            a a2 = h2.l;
            Context context = a2 != null ? a2.d() : h2.h;
            h2.m = new f.b.o.f(context);
        }
        return h2.m;
    }

    public Resources getResources() {
        Resources resources;
        if (this.s == null) {
            b1.a();
        }
        if ((resources = this.s) == null) {
            resources = Activity.super.getResources();
        }
        return resources;
    }

    @Override
    public void h(f.b.o.a a2) {
    }

    @Override
    public f.b.o.a i(a.a a2) {
        return null;
    }

    public void invalidateOptionsMenu() {
        this.q().g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.s != null) {
            DisplayMetrics displayMetrics = Activity.super.getResources().getDisplayMetrics();
            this.s.updateConfiguration(configuration, displayMetrics);
        }
        h h2 = (h)this.q();
        if (h2.D && h2.x) {
            h2.F();
            a a2 = h2.l;
            if (a2 != null) {
                a2.e(configuration);
            }
        }
        j j2 = j.a();
        Context context = h2.h;
        j j3 = j2;
        synchronized (j3) {
            m0 m02;
            m0 m03 = m02 = j2.a;
            synchronized (m03) {
                f.e.e e2 = (f.e.e)m02.d.get((Object)context);
                if (e2 != null) {
                    e2.b();
                }
            }
        }
        h2.q(false);
    }

    public void onContentChanged() {
    }

    public void onCreate(Bundle bundle) {
        g g2 = this.q();
        g2.f();
        g2.h(bundle);
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.q().i();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        Window window;
        boolean bl = Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers((int)keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey((int)keyEvent.getKeyCode()) && (window = this.getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
        if (bl) {
            return true;
        }
        return Activity.super.onKeyDown(n2, keyEvent);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean onMenuItemSelected(int n2, MenuItem menuItem) {
        if (super.onMenuItemSelected(n2, menuItem)) {
            return true;
        }
        a a2 = this.r();
        if (menuItem.getItemId() == 16908332 && a2 != null && (4 & a2.c()) != 0) {
            ArrayList arrayList;
            Intent intent = h.i.r0((Activity)this);
            if (intent == null) {
                return false;
            }
            if (!this.shouldUpRecreateTask(intent)) {
                this.navigateUpTo(intent);
                return true;
            }
            arrayList = new ArrayList();
            Intent intent2 = this.e();
            if (intent2 == null) {
                intent2 = h.i.r0((Activity)this);
            }
            if (intent2 != null) {
                ComponentName componentName = intent2.getComponent();
                if (componentName == null) {
                    componentName = intent2.resolveActivity(this.getPackageManager());
                }
                int n3 = arrayList.size();
                try {
                    Intent intent3;
                    while ((intent3 = h.i.s0((Context)this, componentName)) != null) {
                        arrayList.add(n3, (Object)intent3);
                        componentName = intent3.getComponent();
                    }
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    Log.e((String)"TaskStackBuilder", (String)"Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException((Throwable)nameNotFoundException);
                }
                arrayList.add((Object)intent2);
            }
            this.t();
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] arrintent = (Intent[])arrayList.toArray((Object[])new Intent[arrayList.size()]);
            arrintent[0] = new Intent(arrintent[0]).addFlags(268484608);
            f.h.e.a.d((Context)this, arrintent, null);
            try {
                f.h.d.a.e((Activity)this);
                return true;
            }
            catch (IllegalStateException illegalStateException) {
                this.finish();
                return true;
            }
        }
        return false;
    }

    public boolean onMenuOpened(int n2, Menu menu) {
        return Activity.super.onMenuOpened(n2, menu);
    }

    public void onPanelClosed(int n2, Menu menu) {
        super.onPanelClosed(n2, menu);
    }

    public void onPostCreate(Bundle bundle) {
        Activity.super.onPostCreate(bundle);
        ((h)this.q()).z();
    }

    public void onPostResume() {
        super.onPostResume();
        h h2 = (h)this.q();
        h2.F();
        a a2 = h2.l;
        if (a2 != null) {
            a2.h(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if ((h)this.q() != null) {
            return;
        }
        throw null;
    }

    public void onStart() {
        super.onStart();
        h h2 = (h)this.q();
        h2.O = true;
        h2.p();
    }

    public void onStop() {
        super.onStop();
        h h2 = (h)this.q();
        h2.O = false;
        h2.F();
        a a2 = h2.l;
        if (a2 != null) {
            a2.h(false);
        }
    }

    public void onTitleChanged(CharSequence charSequence, int n2) {
        Activity.super.onTitleChanged(charSequence, n2);
        this.q().o(charSequence);
    }

    public void openOptionsMenu() {
        this.r();
        if (this.getWindow().hasFeature(0)) {
            Activity.super.openOptionsMenu();
        }
    }

    public void p() {
        this.q().g();
    }

    public g q() {
        if (this.r == null) {
            this.r = g.d((Activity)this, this);
        }
        return this.r;
    }

    public a r() {
        h h2 = (h)this.q();
        h2.F();
        return h2.l;
    }

    public void s() {
    }

    public void setContentView(int n2) {
        this.q().l(n2);
    }

    public void setContentView(View view) {
        this.q().m(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.q().n(view, layoutParams);
    }

    public void setTheme(int n2) {
        Activity.super.setTheme(n2);
        ((h)this.q()).R = n2;
    }

    public void t() {
    }
}

