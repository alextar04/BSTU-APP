/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.ActionProvider
 *  android.view.KeyCharacterMap
 *  android.view.KeyCharacterMap$KeyData
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewConfiguration
 *  f.h.l.p
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package f.b.o.i;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionProvider;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import f.b.o.i.i;
import f.b.o.i.j;
import f.b.o.i.m;
import f.b.o.i.r;
import f.h.l.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g
implements f.h.g.a.a {
    public static final int[] z = new int[]{1, 4, 5, 3, 2, 0};
    public final Context a;
    public final Resources b;
    public boolean c;
    public boolean d;
    public a e;
    public ArrayList<i> f;
    public ArrayList<i> g;
    public boolean h;
    public ArrayList<i> i;
    public ArrayList<i> j;
    public boolean k;
    public int l = 0;
    public CharSequence m;
    public Drawable n;
    public View o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public ArrayList<i> u = new ArrayList();
    public CopyOnWriteArrayList<WeakReference<m>> v = new CopyOnWriteArrayList();
    public i w;
    public boolean x = false;
    public boolean y;

    public g(Context context) {
        this.a = context;
        this.b = context.getResources();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = true;
        int n2 = this.b.getConfiguration().keyboard;
        boolean bl = false;
        if (n2 != 1) {
            boolean bl2 = p.d((ViewConfiguration)ViewConfiguration.get((Context)this.a), (Context)this.a);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        this.d = bl;
    }

    public MenuItem a(int n2, int n3, int n4, CharSequence charSequence) {
        int[] arrn;
        int n5 = (-65536 & n4) >> 16;
        if (n5 >= 0 && n5 < (arrn = z).length) {
            ArrayList<i> arrayList;
            int n6;
            i i2;
            block2 : {
                int n7 = arrn[n5] << 16 | 65535 & n4;
                int n8 = this.l;
                i2 = new i(this, n2, n3, n4, n7, charSequence, n8);
                arrayList = this.f;
                int n9 = arrayList.size();
                while (--n9 >= 0) {
                    if (((i)arrayList.get((int)n9)).d > n7) continue;
                    n6 = n9 + 1;
                    break block2;
                }
                n6 = 0;
            }
            arrayList.add(n6, (Object)i2);
            this.q(true);
            return i2;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public MenuItem add(int n2) {
        return this.a(0, 0, 0, this.b.getString(n2));
    }

    public MenuItem add(int n2, int n3, int n4, int n5) {
        return this.a(n2, n3, n4, this.b.getString(n5));
    }

    public MenuItem add(int n2, int n3, int n4, CharSequence charSequence) {
        return this.a(n2, n3, n4, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return this.a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int n2, int n3, int n4, ComponentName componentName, Intent[] arrintent, Intent intent, int n5, MenuItem[] arrmenuItem) {
        PackageManager packageManager = this.a.getPackageManager();
        List list = packageManager.queryIntentActivityOptions(componentName, arrintent, intent, 0);
        int n6 = list != null ? list.size() : 0;
        int n7 = n5 & 1;
        int n8 = 0;
        if (n7 == 0) {
            this.removeGroup(n2);
        }
        while (n8 < n6) {
            int n9;
            ResolveInfo resolveInfo = (ResolveInfo)list.get(n8);
            int n10 = resolveInfo.specificIndex;
            Intent intent2 = n10 < 0 ? intent : arrintent[n10];
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem menuItem = this.a(n2, n3, n4, resolveInfo.loadLabel(packageManager));
            Drawable drawable = resolveInfo.loadIcon(packageManager);
            i i2 = (i)menuItem;
            i2.setIcon(drawable);
            i2.setIntent(intent3);
            if (arrmenuItem != null && (n9 = resolveInfo.specificIndex) >= 0) {
                arrmenuItem[n9] = i2;
            }
            ++n8;
        }
        return n6;
    }

    public SubMenu addSubMenu(int n2) {
        return this.addSubMenu(0, 0, 0, this.b.getString(n2));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, int n5) {
        return this.addSubMenu(n2, n3, n4, this.b.getString(n5));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, CharSequence charSequence) {
        r r2;
        i i2 = (i)this.a(n2, n3, n4, charSequence);
        i2.o = r2 = new r(this.a, this, i2);
        r2.setHeaderTitle(i2.e);
        return r2;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m m2, Context context) {
        this.v.add((Object)new WeakReference((Object)m2));
        m2.d(context, this);
        this.k = true;
    }

    public final void c(boolean bl) {
        if (this.t) {
            return;
        }
        this.t = true;
        for (WeakReference weakReference : this.v) {
            m m2 = (m)weakReference.get();
            if (m2 == null) {
                this.v.remove((Object)weakReference);
                continue;
            }
            m2.a(this, bl);
        }
        this.t = false;
    }

    public void clear() {
        i i2 = this.w;
        if (i2 != null) {
            this.d(i2);
        }
        this.f.clear();
        this.q(true);
    }

    public void clearHeader() {
        this.n = null;
        this.m = null;
        this.o = null;
        this.q(false);
    }

    public void close() {
        this.c(true);
    }

    public boolean d(i i2) {
        boolean bl = this.v.isEmpty();
        boolean bl2 = false;
        if (!bl) {
            if (this.w != i2) {
                return false;
            }
            this.z();
            for (WeakReference weakReference : this.v) {
                m m2 = (m)weakReference.get();
                if (m2 == null) {
                    this.v.remove((Object)weakReference);
                    continue;
                }
                bl2 = m2.e(this, i2);
                if (!bl2) continue;
            }
            this.y();
            if (bl2) {
                this.w = null;
            }
        }
        return bl2;
    }

    public boolean e(g g2, MenuItem menuItem) {
        a a2 = this.e;
        return a2 != null && a2.a(g2, menuItem);
    }

    public boolean f(i i2) {
        boolean bl = this.v.isEmpty();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        this.z();
        for (WeakReference weakReference : this.v) {
            m m2 = (m)weakReference.get();
            if (m2 == null) {
                this.v.remove((Object)weakReference);
                continue;
            }
            bl2 = m2.g(this, i2);
            if (!bl2) continue;
        }
        this.y();
        if (bl2) {
            this.w = i2;
        }
        return bl2;
    }

    public MenuItem findItem(int n2) {
        int n3 = this.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            MenuItem menuItem;
            i i3 = (i)this.f.get(i2);
            if (i3.a == n2) {
                return i3;
            }
            if (!i3.hasSubMenu() || (menuItem = i3.o.findItem(n2)) == null) continue;
            return menuItem;
        }
        return null;
    }

    public i g(int n2, KeyEvent keyEvent) {
        ArrayList<i> arrayList = this.u;
        arrayList.clear();
        this.h((List<i>)arrayList, n2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int n3 = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int n4 = arrayList.size();
        if (n4 == 1) {
            return (i)arrayList.get(0);
        }
        boolean bl = this.n();
        for (int i2 = 0; i2 < n4; ++i2) {
            i i3 = (i)arrayList.get(i2);
            char c2 = bl ? i3.j : i3.h;
            if (!(c2 == keyData.meta[0] && (n3 & 2) == 0 || c2 == keyData.meta[2] && (n3 & 2) != 0) && (!bl || c2 != '\b' || n2 != 67)) continue;
            return i3;
        }
        return null;
    }

    public MenuItem getItem(int n2) {
        return (MenuItem)this.f.get(n2);
    }

    public void h(List<i> list, int n2, KeyEvent keyEvent) {
        boolean bl = this.n();
        int n3 = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && n2 != 67) {
            return;
        }
        int n4 = this.f.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            char[] arrc;
            i i3 = (i)this.f.get(i2);
            if (i3.hasSubMenu()) {
                i3.o.h(list, n2, keyEvent);
            }
            char c2 = bl ? i3.j : i3.h;
            int n5 = bl ? i3.k : i3.i;
            boolean bl2 = (n3 & 69647) == (n5 & 69647);
            if (!bl2 || c2 == '\u0000' || c2 != (arrc = keyData.meta)[0] && c2 != arrc[2] && (!bl || c2 != '\b' || n2 != 67) || !i3.isEnabled()) continue;
            list.add((Object)i3);
        }
    }

    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((i)this.f.get(i2)).isVisible()) continue;
            return true;
        }
        return false;
    }

    public void i() {
        ArrayList<i> arrayList = this.l();
        if (!this.k) {
            return;
        }
        Iterator iterator = this.v.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            WeakReference weakReference = (WeakReference)iterator.next();
            m m2 = (m)weakReference.get();
            if (m2 == null) {
                this.v.remove((Object)weakReference);
                continue;
            }
            bl |= m2.c();
        }
        if (bl) {
            this.i.clear();
            this.j.clear();
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                i i3 = (i)arrayList.get(i2);
                ArrayList<i> arrayList2 = i3.g() ? this.i : this.j;
                arrayList2.add((Object)i3);
            }
        } else {
            this.i.clear();
            this.j.clear();
            this.j.addAll(this.l());
        }
        this.k = false;
    }

    public boolean isShortcutKey(int n2, KeyEvent keyEvent) {
        return this.g(n2, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public g k() {
        return this;
    }

    public ArrayList<i> l() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int n2 = this.f.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = (i)this.f.get(i2);
            if (!i3.isVisible()) continue;
            this.g.add((Object)i3);
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean m() {
        return this.x;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.d;
    }

    public void p() {
        this.k = true;
        this.q(true);
    }

    public boolean performIdentifierAction(int n2, int n3) {
        return this.r(this.findItem(n2), n3);
    }

    public boolean performShortcut(int n2, KeyEvent keyEvent, int n3) {
        i i2 = this.g(n2, keyEvent);
        boolean bl = i2 != null ? this.s(i2, null, n3) : false;
        if ((n3 & 2) != 0) {
            this.c(true);
        }
        return bl;
    }

    public void q(boolean bl) {
        if (!this.p) {
            if (bl) {
                this.h = true;
                this.k = true;
            }
            if (this.v.isEmpty()) {
                return;
            }
            this.z();
            for (WeakReference weakReference : this.v) {
                m m2 = (m)weakReference.get();
                if (m2 == null) {
                    this.v.remove((Object)weakReference);
                    continue;
                }
                m2.j(bl);
            }
            this.y();
            return;
        }
        this.q = true;
        if (bl) {
            this.r = true;
        }
    }

    public boolean r(MenuItem menuItem, int n2) {
        return this.s(menuItem, null, n2);
    }

    public void removeGroup(int n2) {
        int n3;
        block4 : {
            int n4 = this.size();
            for (n3 = 0; n3 < n4; ++n3) {
                if (((i)this.f.get((int)n3)).b != n2) {
                    continue;
                }
                break block4;
            }
            n3 = -1;
        }
        if (n3 >= 0) {
            int n5 = this.f.size() - n3;
            int n6 = 0;
            do {
                int n7 = n6 + 1;
                if (n6 >= n5 || ((i)this.f.get((int)n3)).b != n2) break;
                this.t(n3, false);
                n6 = n7;
            } while (true);
            this.q(true);
        }
    }

    public void removeItem(int n2) {
        int n3;
        block2 : {
            int n4 = this.size();
            for (n3 = 0; n3 < n4; ++n3) {
                if (((i)this.f.get((int)n3)).a != n2) {
                    continue;
                }
                break block2;
            }
            n3 = -1;
        }
        this.t(n3, true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean s(MenuItem var1_1, m var2_2, int var3_3) {
        block17 : {
            var4_4 = (i)var1_1;
            if (var4_4 == null) return false;
            if (!var4_4.isEnabled()) {
                return false;
            }
            var5_5 = var4_4.p;
            if (var5_5 != null && var5_5.onMenuItemClick((MenuItem)var4_4) || (var6_6 = var4_4.n).e(var6_6, var4_4)) ** GOTO lbl-1000
            var7_7 = var4_4.g;
            if (var7_7 == null) break block17;
            try {
                var4_4.n.a.startActivity(var7_7);
                ** GOTO lbl-1000
            }
            catch (ActivityNotFoundException var21_8) {
                Log.e((String)"MenuItemImpl", (String)"Can't find activity to handle intent; ignoring", (Throwable)var21_8);
            }
        }
        if ((var8_9 = var4_4.A) != null && ((j.a)var8_9).b.onPerformDefaultAction()) lbl-1000: // 3 sources:
        {
            var9_10 = true;
        } else {
            var9_10 = false;
        }
        var10_11 = var4_4.A;
        var11_12 = var10_11 != null && ((j.a)var10_11).b.hasSubMenu() != false;
        if (var4_4.f()) {
            if ((var9_10 |= var4_4.expandActionView()) == false) return var9_10;
        } else if (!var4_4.hasSubMenu() && !var11_12) {
            if ((var3_3 & 1) != 0) return var9_10;
        } else {
            if ((var3_3 & 4) == 0) {
                this.c(false);
            }
            if (!var4_4.hasSubMenu()) {
                var4_4.o = var12_13 = new r(this.a, this, var4_4);
                var12_13.setHeaderTitle(var4_4.e);
            }
            var14_14 = var4_4.o;
            if (var11_12) {
                var20_15 = (j.a)var10_11;
                var20_15.b.onPrepareSubMenu(var20_15.c.d(var14_14));
            }
            if (this.v.isEmpty()) {
                var15_16 = false;
            } else {
                var15_16 = false;
                if (var2_2 != null) {
                    var15_16 = var2_2.i(var14_14);
                }
                for (WeakReference var17_18 : this.v) {
                    var18_19 = (m)var17_18.get();
                    if (var18_19 == null) {
                        this.v.remove((Object)var17_18);
                        continue;
                    }
                    if (var15_16) continue;
                    var15_16 = var18_19.i(var14_14);
                }
            }
            if ((var9_10 |= var15_16) != false) return var9_10;
        }
        this.c(true);
        return var9_10;
    }

    public void setGroupCheckable(int n2, boolean bl, boolean bl2) {
        int n3 = this.f.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            i i3 = (i)this.f.get(i2);
            if (i3.b != n2) continue;
            int n4 = -5 & i3.x;
            int n5 = bl2 ? 4 : 0;
            i3.x = n4 | n5;
            i3.setCheckable(bl);
        }
    }

    public void setGroupDividerEnabled(boolean bl) {
        this.x = bl;
    }

    public void setGroupEnabled(int n2, boolean bl) {
        int n3 = this.f.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            i i3 = (i)this.f.get(i2);
            if (i3.b != n2) continue;
            i3.setEnabled(bl);
        }
    }

    public void setGroupVisible(int n2, boolean bl) {
        int n3 = this.f.size();
        boolean bl2 = false;
        for (int i2 = 0; i2 < n3; ++i2) {
            i i3 = (i)this.f.get(i2);
            if (i3.b != n2 || !i3.l(bl)) continue;
            bl2 = true;
        }
        if (bl2) {
            this.q(true);
        }
    }

    public void setQwertyMode(boolean bl) {
        this.c = bl;
        this.q(false);
    }

    public int size() {
        return this.f.size();
    }

    public final void t(int n2, boolean bl) {
        if (n2 >= 0) {
            if (n2 >= this.f.size()) {
                return;
            }
            this.f.remove(n2);
            if (bl) {
                this.q(true);
            }
        }
    }

    public void u(m m2) {
        for (WeakReference weakReference : this.v) {
            m m3 = (m)weakReference.get();
            if (m3 != null && m3 != m2) continue;
            this.v.remove((Object)weakReference);
        }
    }

    public void v(Bundle bundle) {
        MenuItem menuItem;
        if (bundle == null) {
            return;
        }
        SparseArray sparseArray = bundle.getSparseParcelableArray(this.j());
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            MenuItem menuItem2 = this.getItem(i2);
            View view = menuItem2.getActionView();
            if (view != null && view.getId() != -1) {
                view.restoreHierarchyState(sparseArray);
            }
            if (!menuItem2.hasSubMenu()) continue;
            ((r)menuItem2.getSubMenu()).v(bundle);
        }
        int n3 = bundle.getInt("android:menu:expandedactionview");
        if (n3 > 0 && (menuItem = this.findItem(n3)) != null) {
            menuItem.expandActionView();
        }
    }

    public void w(Bundle bundle) {
        int n2 = this.size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            MenuItem menuItem = this.getItem(i2);
            View view = menuItem.getActionView();
            if (view != null && view.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                view.saveHierarchyState(sparseArray);
                if (menuItem.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", menuItem.getItemId());
                }
            }
            if (!menuItem.hasSubMenu()) continue;
            ((r)menuItem.getSubMenu()).w(bundle);
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(this.j(), sparseArray);
        }
    }

    public final void x(int n2, CharSequence charSequence, int n3, Drawable drawable, View view) {
        Resources resources = this.b;
        if (view != null) {
            this.o = view;
            this.m = null;
            this.n = null;
        } else {
            if (n2 > 0) {
                this.m = resources.getText(n2);
            } else if (charSequence != null) {
                this.m = charSequence;
            }
            if (n3 > 0) {
                this.n = f.h.e.a.c(this.a, n3);
            } else if (drawable != null) {
                this.n = drawable;
            }
            this.o = null;
        }
        this.q(false);
    }

    public void y() {
        this.p = false;
        if (this.q) {
            this.q = false;
            this.q(this.r);
        }
    }

    public void z() {
        if (!this.p) {
            this.p = true;
            this.q = false;
            this.r = false;
        }
    }

}

