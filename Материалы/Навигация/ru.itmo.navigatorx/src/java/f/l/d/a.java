/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$b
 *  f.l.d.n
 *  f.l.d.r
 *  f.l.d.r$e
 *  f.l.d.z
 *  f.l.d.z$a
 *  f.n.g
 *  f.n.g$b
 *  java.io.PrintWriter
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.concurrent.atomic.AtomicInteger
 */
package f.l.d;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import f.l.d.n;
import f.l.d.o;
import f.l.d.r;
import f.l.d.z;
import f.n.g;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
extends z
implements r.e {
    public final r q;
    public boolean r;
    public int s;

    public a(r r2) {
        n n2 = r2.K();
        o o2 = r2.n;
        ClassLoader classLoader = o2 != null ? o2.f.getClassLoader() : null;
        super(n2, classLoader);
        this.s = -1;
        this.q = r2;
    }

    public static boolean l(z.a a2) {
        Fragment fragment = a2.b;
        boolean bl = false;
        if (fragment != null) {
            boolean bl2 = fragment.o;
            bl = false;
            if (bl2) {
                View view = fragment.J;
                bl = false;
                if (view != null) {
                    boolean bl3 = fragment.D;
                    bl = false;
                    if (!bl3) {
                        boolean bl4 = fragment.C;
                        bl = false;
                        if (!bl4) {
                            Fragment.b b2 = fragment.M;
                            boolean bl5 = b2 == null ? false : b2.p;
                            bl = false;
                            if (bl5) {
                                bl = true;
                            }
                        }
                    }
                }
            }
        }
        return bl;
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (r.M((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Run: ");
            stringBuilder.append((Object)this);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        arrayList.add((Object)this);
        arrayList2.add((Object)Boolean.FALSE);
        if (this.g) {
            r r2 = this.q;
            if (r2.d == null) {
                r2.d = new ArrayList();
            }
            r2.d.add((Object)this);
        }
        return true;
    }

    public int c() {
        return this.f(false);
    }

    public void d(int n2, Fragment fragment, String string, int n3) {
        super.d(n2, fragment, string, n3);
        fragment.v = this.q;
    }

    public void e(int n2) {
        if (!this.g) {
            return;
        }
        if (r.M((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bump nesting in ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" by ");
            stringBuilder.append(n2);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        int n3 = this.a.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            z.a a2 = (z.a)this.a.get(i2);
            Fragment fragment = a2.b;
            if (fragment == null) continue;
            fragment.u = n2 + fragment.u;
            if (!r.M((int)2)) continue;
            StringBuilder stringBuilder = c.b.a.a.a.c("Bump nesting of ");
            stringBuilder.append((Object)a2.b);
            stringBuilder.append(" to ");
            stringBuilder.append(a2.b.u);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
    }

    public int f(boolean bl) {
        if (!this.r) {
            if (r.M((int)2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Commit: ");
                stringBuilder.append((Object)this);
                Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                PrintWriter printWriter = new PrintWriter((Writer)new f.h.k.a("FragmentManager"));
                this.g("  ", printWriter, true);
                printWriter.close();
            }
            this.r = true;
            int n2 = this.g ? this.q.i.getAndIncrement() : -1;
            this.s = n2;
            this.q.z((r.e)this, bl);
            return this.s;
        }
        throw new IllegalStateException("commit already called");
    }

    public void g(String string, PrintWriter printWriter, boolean bl) {
        if (bl) {
            printWriter.print(string);
            printWriter.print("mName=");
            printWriter.print(this.h);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f != 0) {
                printWriter.print(string);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString((int)this.f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(string);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString((int)this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString((int)this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(string);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString((int)this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString((int)this.e));
            }
            if (this.i != 0 || this.j != null) {
                printWriter.print(string);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString((int)this.i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println((Object)this.j);
            }
            if (this.k != 0 || this.l != null) {
                printWriter.print(string);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString((int)this.k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println((Object)this.l);
            }
        }
        if (!this.a.isEmpty()) {
            printWriter.print(string);
            printWriter.println("Operations:");
            int n2 = this.a.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                String string2;
                z.a a2 = (z.a)this.a.get(i2);
                switch (a2.a) {
                    default: {
                        StringBuilder stringBuilder = c.b.a.a.a.c("cmd=");
                        stringBuilder.append(a2.a);
                        string2 = stringBuilder.toString();
                        break;
                    }
                    case 10: {
                        string2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    }
                    case 9: {
                        string2 = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 8: {
                        string2 = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 7: {
                        string2 = "ATTACH";
                        break;
                    }
                    case 6: {
                        string2 = "DETACH";
                        break;
                    }
                    case 5: {
                        string2 = "SHOW";
                        break;
                    }
                    case 4: {
                        string2 = "HIDE";
                        break;
                    }
                    case 3: {
                        string2 = "REMOVE";
                        break;
                    }
                    case 2: {
                        string2 = "REPLACE";
                        break;
                    }
                    case 1: {
                        string2 = "ADD";
                        break;
                    }
                    case 0: {
                        string2 = "NULL";
                    }
                }
                printWriter.print(string);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(string2);
                printWriter.print(" ");
                printWriter.println((Object)a2.b);
                if (!bl) continue;
                if (a2.c != 0 || a2.d != 0) {
                    printWriter.print(string);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString((int)a2.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString((int)a2.d));
                }
                if (a2.e == 0 && a2.f == 0) continue;
                printWriter.print(string);
                printWriter.print("popEnterAnim=#");
                printWriter.print(Integer.toHexString((int)a2.e));
                printWriter.print(" popExitAnim=#");
                printWriter.println(Integer.toHexString((int)a2.f));
            }
        }
    }

    public void h() {
        int n2 = this.a.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            z.a a2 = (z.a)this.a.get(i2);
            Fragment fragment = a2.b;
            if (fragment != null) {
                int n3 = this.f;
                if (fragment.M != null || n3 != 0) {
                    fragment.j();
                    fragment.M.e = n3;
                }
            }
            switch (a2.a) {
                default: {
                    StringBuilder stringBuilder = c.b.a.a.a.c("Unknown cmd: ");
                    stringBuilder.append(a2.a);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                case 10: {
                    this.q.e0(fragment, a2.h);
                    break;
                }
                case 9: {
                    this.q.f0(null);
                    break;
                }
                case 8: {
                    this.q.f0(fragment);
                    break;
                }
                case 7: {
                    fragment.s0(a2.c);
                    this.q.d0(fragment, false);
                    this.q.d(fragment);
                    break;
                }
                case 6: {
                    fragment.s0(a2.d);
                    this.q.i(fragment);
                    break;
                }
                case 5: {
                    fragment.s0(a2.c);
                    this.q.d0(fragment, false);
                    this.q.h0(fragment);
                    break;
                }
                case 4: {
                    fragment.s0(a2.d);
                    this.q.L(fragment);
                    break;
                }
                case 3: {
                    fragment.s0(a2.d);
                    this.q.X(fragment);
                    break;
                }
                case 1: {
                    fragment.s0(a2.c);
                    this.q.d0(fragment, false);
                    this.q.b(fragment);
                }
            }
            if (this.o || a2.a == 1 || fragment == null) continue;
            this.q.R(fragment);
        }
        if (!this.o) {
            r r2 = this.q;
            r2.S(r2.m, true);
        }
    }

    public void i(boolean bl) {
        for (int i2 = this.a.size() - 1; i2 >= 0; --i2) {
            z.a a2 = (z.a)this.a.get(i2);
            Fragment fragment = a2.b;
            if (fragment != null) {
                int n2 = this.f;
                int n3 = 8194;
                if (n2 != 4097) {
                    n3 = n2 != 4099 ? (n2 != n3 ? 0 : 4097) : 4099;
                }
                if (fragment.M != null || n3 != 0) {
                    fragment.j();
                    fragment.M.e = n3;
                }
            }
            switch (a2.a) {
                default: {
                    StringBuilder stringBuilder = c.b.a.a.a.c("Unknown cmd: ");
                    stringBuilder.append(a2.a);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                case 10: {
                    this.q.e0(fragment, a2.g);
                    break;
                }
                case 9: {
                    this.q.f0(fragment);
                    break;
                }
                case 8: {
                    this.q.f0(null);
                    break;
                }
                case 7: {
                    fragment.s0(a2.f);
                    this.q.d0(fragment, true);
                    this.q.i(fragment);
                    break;
                }
                case 6: {
                    fragment.s0(a2.e);
                    this.q.d(fragment);
                    break;
                }
                case 5: {
                    fragment.s0(a2.f);
                    this.q.d0(fragment, true);
                    this.q.L(fragment);
                    break;
                }
                case 4: {
                    fragment.s0(a2.e);
                    this.q.h0(fragment);
                    break;
                }
                case 3: {
                    fragment.s0(a2.e);
                    this.q.b(fragment);
                    break;
                }
                case 1: {
                    fragment.s0(a2.f);
                    this.q.d0(fragment, true);
                    this.q.X(fragment);
                }
            }
            if (this.o || a2.a == 3 || fragment == null) continue;
            this.q.R(fragment);
        }
        if (!this.o && bl) {
            r r2 = this.q;
            r2.S(r2.m, true);
        }
    }

    public boolean j(int n2) {
        int n3 = this.a.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            Fragment fragment = ((z.a)this.a.get((int)i2)).b;
            int n4 = fragment != null ? fragment.A : 0;
            if (n4 == 0 || n4 != n2) continue;
            return true;
        }
        return false;
    }

    public boolean k(ArrayList<a> arrayList, int n2, int n3) {
        if (n3 == n2) {
            return false;
        }
        int n4 = this.a.size();
        int n5 = -1;
        for (int i2 = 0; i2 < n4; ++i2) {
            Fragment fragment = ((z.a)this.a.get((int)i2)).b;
            int n6 = fragment != null ? fragment.A : 0;
            if (n6 == 0 || n6 == n5) continue;
            for (int i3 = n2; i3 < n3; ++i3) {
                a a2 = (a)((Object)arrayList.get(i3));
                int n7 = a2.a.size();
                for (int i4 = 0; i4 < n7; ++i4) {
                    Fragment fragment2 = ((z.a)a2.a.get((int)i4)).b;
                    int n8 = fragment2 != null ? fragment2.A : 0;
                    if (n8 != n6) continue;
                    return true;
                }
            }
            n5 = n6;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)((Object)this))));
        if (this.s >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.s);
        }
        if (this.h != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.h);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

