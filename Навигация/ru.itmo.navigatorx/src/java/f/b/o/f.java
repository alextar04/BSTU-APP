/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.InflateException
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  c.b.a.a.a
 *  f.b.o.i.i
 *  f.b.o.i.j
 *  f.b.o.i.j$a
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Method
 *  org.xmlpull.v1.XmlPullParser
 */
package f.b.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionProvider;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import f.b.j;
import f.b.o.i.i;
import f.b.o.i.j;
import f.b.p.d0;
import f.b.p.w0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class f
extends MenuInflater {
    public static final Class<?>[] e;
    public static final Class<?>[] f;
    public final Object[] a;
    public final Object[] b;
    public Context c;
    public Object d;

    public static {
        Class[] arrclass = new Class[]{Context.class};
        e = arrclass;
        f = arrclass;
    }

    public f(Context context) {
        super(context);
        this.c = context;
        Object[] arrobject = new Object[]{context};
        this.a = arrobject;
        this.b = arrobject;
    }

    public final Object a(Object object) {
        if (object instanceof Activity) {
            return object;
        }
        if (object instanceof ContextWrapper) {
            object = this.a((Object)((ContextWrapper)object).getBaseContext());
        }
        return object;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b b2 = new b(menu);
        int n2 = xmlPullParser.getEventType();
        do {
            if (n2 != 2) continue;
            String string = xmlPullParser.getName();
            if (string.equals((Object)"menu")) {
                n2 = xmlPullParser.next();
                break;
            }
            throw new RuntimeException(c.b.a.a.a.j((String)"Expecting menu, got ", (String)string));
        } while ((n2 = xmlPullParser.next()) != 1);
        String string = null;
        boolean bl = false;
        boolean bl2 = false;
        while (!bl) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        String string2 = xmlPullParser.getName();
                        if (bl2 && string2.equals(string)) {
                            bl2 = false;
                            string = null;
                        } else if (string2.equals((Object)"group")) {
                            b2.b = 0;
                            b2.c = 0;
                            b2.d = 0;
                            b2.e = 0;
                            b2.f = true;
                            b2.g = true;
                        } else if (string2.equals((Object)"item")) {
                            if (!b2.h) {
                                f.h.l.b b3 = b2.A;
                                if (b3 != null && ((j.a)b3).b.hasSubMenu()) {
                                    b2.a();
                                } else {
                                    b2.h = true;
                                    b2.c(b2.a.add(b2.b, b2.i, b2.j, b2.k));
                                }
                            }
                        } else if (string2.equals((Object)"menu")) {
                            bl = true;
                        }
                    }
                } else if (!bl2) {
                    String string3 = xmlPullParser.getName();
                    if (string3.equals((Object)"group")) {
                        TypedArray typedArray = b2.f.this.c.obtainStyledAttributes(attributeSet, j.MenuGroup);
                        b2.b = typedArray.getResourceId(j.MenuGroup_android_id, 0);
                        b2.c = typedArray.getInt(j.MenuGroup_android_menuCategory, 0);
                        b2.d = typedArray.getInt(j.MenuGroup_android_orderInCategory, 0);
                        b2.e = typedArray.getInt(j.MenuGroup_android_checkableBehavior, 0);
                        b2.f = typedArray.getBoolean(j.MenuGroup_android_visible, true);
                        b2.g = typedArray.getBoolean(j.MenuGroup_android_enabled, true);
                        typedArray.recycle();
                    } else if (string3.equals((Object)"item")) {
                        String string4;
                        w0 w02 = w0.p(b2.f.this.c, attributeSet, j.MenuItem);
                        b2.i = w02.l(j.MenuItem_android_id, 0);
                        int n3 = w02.j(j.MenuItem_android_menuCategory, b2.c);
                        int n4 = w02.j(j.MenuItem_android_orderInCategory, b2.d);
                        b2.j = n3 & -65536 | n4 & 65535;
                        b2.k = w02.n(j.MenuItem_android_title);
                        b2.l = w02.n(j.MenuItem_android_titleCondensed);
                        b2.m = w02.l(j.MenuItem_android_icon, 0);
                        String string5 = w02.m(j.MenuItem_android_alphabeticShortcut);
                        char c2 = string5 == null ? (char)'\u0000' : string5.charAt(0);
                        b2.n = c2;
                        b2.o = w02.j(j.MenuItem_alphabeticModifiers, 4096);
                        String string6 = w02.m(j.MenuItem_android_numericShortcut);
                        char c3 = string6 == null ? (char)'\u0000' : string6.charAt(0);
                        b2.p = c3;
                        b2.q = w02.j(j.MenuItem_numericModifiers, 4096);
                        int n5 = w02.o(j.MenuItem_android_checkable) ? (int)(w02.a(j.MenuItem_android_checkable, false) ? 1 : 0) : b2.e;
                        b2.r = n5;
                        b2.s = w02.a(j.MenuItem_android_checked, false);
                        b2.t = w02.a(j.MenuItem_android_visible, b2.f);
                        b2.u = w02.a(j.MenuItem_android_enabled, b2.g);
                        b2.v = w02.j(j.MenuItem_showAsAction, -1);
                        b2.z = w02.m(j.MenuItem_android_onClick);
                        b2.w = w02.l(j.MenuItem_actionLayout, 0);
                        b2.x = w02.m(j.MenuItem_actionViewClass);
                        b2.y = string4 = w02.m(j.MenuItem_actionProviderClass);
                        boolean bl3 = string4 != null;
                        if (bl3 && b2.w == 0 && b2.x == null) {
                            b2.A = (f.h.l.b)b2.b(b2.y, f, b2.f.this.b);
                        } else {
                            if (bl3) {
                                Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            b2.A = null;
                        }
                        b2.B = w02.n(j.MenuItem_contentDescription);
                        b2.C = w02.n(j.MenuItem_tooltipText);
                        b2.E = w02.o(j.MenuItem_iconTintMode) ? d0.c(w02.j(j.MenuItem_iconTintMode, -1), b2.E) : null;
                        b2.D = w02.o(j.MenuItem_iconTint) ? w02.c(j.MenuItem_iconTint) : null;
                        w02.b.recycle();
                        b2.h = false;
                    } else if (string3.equals((Object)"menu")) {
                        this.b(xmlPullParser, attributeSet, (Menu)b2.a());
                    } else {
                        string = string3;
                        bl2 = true;
                    }
                }
                n2 = xmlPullParser.next();
                continue;
            }
            throw new RuntimeException("Unexpected end of document");
        }
    }

    /*
     * Exception decompiling
     */
    public void inflate(int var1_1, Menu var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 1[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public static class a
    implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] c = new Class[]{MenuItem.class};
        public Object a;
        public Method b;

        public a(Object object, String string) {
            this.a = object;
            Class class_ = object.getClass();
            try {
                this.b = class_.getMethod(string, c);
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(string);
                stringBuilder.append(" in class ");
                stringBuilder.append(class_.getName());
                InflateException inflateException = new InflateException(stringBuilder.toString());
                inflateException.initCause((Throwable)exception);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return (Boolean)this.b.invoke(this.a, new Object[]{menuItem});
                }
                this.b.invoke(this.a, new Object[]{menuItem});
                return true;
            }
            catch (Exception exception) {
                throw new RuntimeException((Throwable)exception);
            }
        }
    }

    public class b {
        public f.h.l.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;
        public Menu a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.a = menu;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        public SubMenu a() {
            this.h = true;
            SubMenu subMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            this.c(subMenu.getItem());
            return subMenu;
        }

        public final <T> T b(String string, Class<?>[] arrclass, Object[] arrobject) {
            Object object;
            try {
                Constructor constructor = Class.forName((String)string, (boolean)false, (ClassLoader)f.this.c.getClassLoader()).getConstructor(arrclass);
                constructor.setAccessible(true);
                object = constructor.newInstance(arrobject);
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot instantiate class: ");
                stringBuilder.append(string);
                Log.w((String)"SupportMenuInflater", (String)stringBuilder.toString(), (Throwable)exception);
                return null;
            }
            return (T)object;
        }

        public final void c(MenuItem menuItem) {
            int n2;
            f.h.l.b b2;
            ColorStateList colorStateList;
            MenuItem menuItem2 = menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u);
            boolean bl = this.r >= 1;
            menuItem2.setCheckable(bl).setTitleCondensed(this.l).setIcon(this.m);
            int n3 = this.v;
            if (n3 >= 0) {
                menuItem.setShowAsAction(n3);
            }
            if (this.z != null) {
                if (!f.this.c.isRestricted()) {
                    f f2 = f.this;
                    if (f2.d == null) {
                        f2.d = f2.a((Object)f2.c);
                    }
                    menuItem.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new a(f2.d, this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    i i2 = (i)menuItem;
                    i2.x = 4 | -5 & i2.x;
                } else if (menuItem instanceof f.b.o.i.j) {
                    f.b.o.i.j j2 = (f.b.o.i.j)menuItem;
                    try {
                        if (j2.e == null) {
                            Class class_ = j2.d.getClass();
                            Class[] arrclass = new Class[]{Boolean.TYPE};
                            j2.e = class_.getDeclaredMethod("setExclusiveCheckable", arrclass);
                        }
                        Method method = j2.e;
                        f.h.g.a.b b3 = j2.d;
                        Object[] arrobject = new Object[]{Boolean.TRUE};
                        method.invoke((Object)b3, arrobject);
                    }
                    catch (Exception exception) {
                        Log.w((String)"MenuItemWrapper", (String)"Error while calling setExclusiveCheckable", (Throwable)exception);
                    }
                }
            }
            String string = this.x;
            boolean bl2 = false;
            if (string != null) {
                menuItem.setActionView((View)this.b(string, f.e, f.this.a));
                bl2 = true;
            }
            if ((n2 = this.w) > 0) {
                if (!bl2) {
                    menuItem.setActionView(n2);
                } else {
                    Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if ((b2 = this.A) != null) {
                if (menuItem instanceof f.h.g.a.b) {
                    ((f.h.g.a.b)menuItem).a(b2);
                } else {
                    Log.w((String)"MenuItemCompat", (String)"setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.B;
            boolean bl3 = menuItem instanceof f.h.g.a.b;
            if (bl3) {
                ((f.h.g.a.b)menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (bl3) {
                ((f.h.g.a.b)menuItem).setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.n;
            int n4 = this.o;
            if (bl3) {
                ((f.h.g.a.b)menuItem).setAlphabeticShortcut(c2, n4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, n4);
            }
            char c3 = this.p;
            int n5 = this.q;
            if (bl3) {
                ((f.h.g.a.b)menuItem).setNumericShortcut(c3, n5);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c3, n5);
            }
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                if (bl3) {
                    ((f.h.g.a.b)menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            if ((colorStateList = this.D) != null) {
                if (bl3) {
                    ((f.h.g.a.b)menuItem).setIconTintList(colorStateList);
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintList(colorStateList);
                }
            }
        }
    }

}

