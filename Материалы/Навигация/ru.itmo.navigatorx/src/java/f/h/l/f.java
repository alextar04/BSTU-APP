/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 *  f.b.k.h
 *  f.h.l.h
 *  java.lang.AbstractMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package f.h.l;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import f.b.k.h;
import f.h.l.g;
import f.h.l.h;

public class f {
    public ViewParent a;
    public ViewParent b;
    public final View c;
    public boolean d;
    public int[] e;

    public f(View view) {
        this.c = view;
    }

    public boolean a(float f2, float f3, boolean bl) {
        ViewParent viewParent;
        if (this.d && (viewParent = this.g(0)) != null) {
            return h.i.g1(viewParent, this.c, f2, f3, bl);
        }
        return false;
    }

    public boolean b(float f2, float f3) {
        ViewParent viewParent;
        if (this.d && (viewParent = this.g(0)) != null) {
            return h.i.h1(viewParent, this.c, f2, f3);
        }
        return false;
    }

    public boolean c(int n2, int n3, int[] arrn, int[] arrn2, int n4) {
        boolean bl;
        block11 : {
            block13 : {
                int n5;
                int n6;
                ViewParent viewParent;
                block12 : {
                    boolean bl2 = this.d;
                    bl = false;
                    if (!bl2) break block11;
                    viewParent = this.g(n4);
                    if (viewParent == null) {
                        return false;
                    }
                    if (n2 != 0 || n3 != 0) break block12;
                    bl = false;
                    if (arrn2 != null) {
                        arrn2[0] = 0;
                        arrn2[1] = 0;
                        return false;
                    }
                    break block11;
                }
                if (arrn2 != null) {
                    this.c.getLocationInWindow(arrn2);
                    int n7 = arrn2[0];
                    int n8 = arrn2[1];
                    n6 = n7;
                    n5 = n8;
                } else {
                    n6 = 0;
                    n5 = 0;
                }
                if (arrn == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    arrn = this.e;
                }
                arrn[0] = 0;
                arrn[1] = 0;
                h.i.i1(viewParent, this.c, n2, n3, arrn, n4);
                if (arrn2 != null) {
                    this.c.getLocationInWindow(arrn2);
                    arrn2[0] = arrn2[0] - n6;
                    arrn2[1] = arrn2[1] - n5;
                }
                if (arrn[0] != 0) break block13;
                int n9 = arrn[1];
                bl = false;
                if (n9 == 0) break block11;
            }
            bl = true;
        }
        return bl;
    }

    public void d(int n2, int n3, int n4, int n5, int[] arrn, int n6, int[] arrn2) {
        this.f(n2, n3, n4, n5, null, n6, arrn2);
    }

    public boolean e(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.f(n2, n3, n4, n5, arrn, 0, null);
    }

    public final boolean f(int n2, int n3, int n4, int n5, int[] arrn, int n6, int[] arrn2) {
        if (this.d) {
            ViewParent viewParent = this.g(n6);
            if (viewParent == null) {
                return false;
            }
            if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0) {
                if (arrn != null) {
                    arrn[0] = 0;
                    arrn[1] = 0;
                    return false;
                }
            } else {
                int[] arrn3;
                int n7;
                int n8;
                if (arrn != null) {
                    this.c.getLocationInWindow(arrn);
                    int n9 = arrn[0];
                    int n10 = arrn[1];
                    n8 = n9;
                    n7 = n10;
                } else {
                    n8 = 0;
                    n7 = 0;
                }
                if (arrn2 == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    int[] arrn4 = this.e;
                    arrn4[0] = 0;
                    arrn4[1] = 0;
                    arrn3 = arrn4;
                } else {
                    arrn3 = arrn2;
                }
                View view = this.c;
                if (viewParent instanceof h) {
                    ((h)viewParent).m(view, n2, n3, n4, n5, n6, arrn3);
                } else {
                    arrn3[0] = n4 + arrn3[0];
                    arrn3[1] = n5 + arrn3[1];
                    if (viewParent instanceof g) {
                        ((g)viewParent).n(view, n2, n3, n4, n5, n6);
                    } else if (n6 == 0) {
                        try {
                            viewParent.onNestedScroll(view, n2, n3, n4, n5);
                        }
                        catch (AbstractMethodError abstractMethodError) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("ViewParent ");
                            stringBuilder.append((Object)viewParent);
                            stringBuilder.append(" does not implement interface method onNestedScroll");
                            Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
                        }
                    }
                }
                if (arrn != null) {
                    this.c.getLocationInWindow(arrn);
                    arrn[0] = arrn[0] - n8;
                    arrn[1] = arrn[1] - n7;
                }
                return true;
            }
        }
        return false;
    }

    public final ViewParent g(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                return null;
            }
            return this.b;
        }
        return this.a;
    }

    public boolean h(int n2) {
        return this.g(n2) != null;
    }

    public boolean i(int n2, int n3) {
        boolean bl = this.g(n3) != null;
        if (bl) {
            return true;
        }
        if (this.d) {
            View view = this.c;
            for (ViewParent viewParent = this.c.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
                boolean bl2;
                boolean bl3;
                block16 : {
                    View view2 = this.c;
                    bl3 = viewParent instanceof g;
                    if (bl3) {
                        bl2 = ((g)viewParent).o(view, view2, n2, n3);
                    } else {
                        if (n3 == 0) {
                            try {
                                bl2 = viewParent.onStartNestedScroll(view, view2, n2);
                                break block16;
                            }
                            catch (AbstractMethodError abstractMethodError) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("ViewParent ");
                                stringBuilder.append((Object)viewParent);
                                stringBuilder.append(" does not implement interface method onStartNestedScroll");
                                Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
                            }
                        }
                        bl2 = false;
                    }
                }
                if (bl2) {
                    if (n3 != 0) {
                        if (n3 == 1) {
                            this.b = viewParent;
                        }
                    } else {
                        this.a = viewParent;
                    }
                    View view3 = this.c;
                    if (bl3) {
                        ((g)viewParent).d(view, view3, n2, n3);
                        return true;
                    }
                    if (n3 == 0) {
                        try {
                            viewParent.onNestedScrollAccepted(view, view3, n2);
                            return true;
                        }
                        catch (AbstractMethodError abstractMethodError) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("ViewParent ");
                            stringBuilder.append((Object)viewParent);
                            stringBuilder.append(" does not implement interface method onNestedScrollAccepted");
                            Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
                        }
                    }
                    return true;
                }
                if (!(viewParent instanceof View)) continue;
                view = (View)viewParent;
            }
        }
        return false;
    }

    public void j(int n2) {
        ViewParent viewParent = this.g(n2);
        if (viewParent != null) {
            View view = this.c;
            if (viewParent instanceof g) {
                ((g)viewParent).i(view, n2);
            } else if (n2 == 0) {
                try {
                    viewParent.onStopNestedScroll(view);
                }
                catch (AbstractMethodError abstractMethodError) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append((Object)viewParent);
                    stringBuilder.append(" does not implement interface method onStopNestedScroll");
                    Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
                }
            }
            if (n2 != 0) {
                if (n2 != 1) {
                    return;
                }
                this.b = null;
                return;
            }
            this.a = null;
        }
    }
}

