/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewOverlay
 *  android.view.ViewParent
 *  f.h.l.l
 *  f.r.b$a
 *  f.r.b$b
 *  f.r.b$c
 *  f.r.b$d
 *  f.r.b$e
 *  f.r.b$f
 *  f.r.b$g
 *  f.r.b$h
 *  f.r.b$i
 *  f.r.b$j
 *  f.r.b$k
 *  f.r.b0
 *  f.r.e
 *  f.r.g
 *  f.r.i
 *  f.r.i$d
 *  f.r.p
 *  f.r.q
 *  f.r.s
 *  f.r.v
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package f.r;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import f.b.k.h;
import f.h.l.l;
import f.r.b;
import f.r.b0;
import f.r.i;
import f.r.p;
import f.r.q;
import f.r.s;
import f.r.v;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public class b
extends f.r.i {
    public static final String[] P;
    public static final Property<Drawable, PointF> Q;
    public static final Property<k, PointF> R;
    public static final Property<k, PointF> S;
    public static final Property<View, PointF> T;
    public static final Property<View, PointF> U;
    public static final Property<View, PointF> V;
    public static f.r.g W;
    public int[] M;
    public boolean N;
    public boolean O;

    public static {
        P = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
        Q = new b(PointF.class, "boundsOrigin");
        R = new c(PointF.class, "topLeft");
        S = new d(PointF.class, "bottomRight");
        T = new e(PointF.class, "bottomRight");
        U = new f(PointF.class, "topLeft");
        V = new g(PointF.class, "position");
        W = new f.r.g();
    }

    public b() {
        this.M = new int[2];
        this.N = false;
        this.O = false;
    }

    public final void I(q q2) {
        View view = q2.b;
        if (l.A((View)view) || view.getWidth() != 0 || view.getHeight() != 0) {
            q2.a.put((Object)"android:changeBounds:bounds", (Object)new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            q2.a.put((Object)"android:changeBounds:parent", (Object)q2.b.getParent());
            if (this.O) {
                q2.b.getLocationInWindow(this.M);
                q2.a.put((Object)"android:changeBounds:windowX", (Object)this.M[0]);
                q2.a.put((Object)"android:changeBounds:windowY", (Object)this.M[1]);
            }
            if (this.N) {
                q2.a.put((Object)"android:changeBounds:clip", (Object)view.getClipBounds());
            }
        }
    }

    public void e(q q2) {
        this.I(q2);
    }

    public void h(q q2) {
        this.I(q2);
    }

    public Animator l(ViewGroup viewGroup, q q2, q q3) {
        block15 : {
            block16 : {
                int n2;
                View view;
                int n3;
                int n4;
                int n5;
                block24 : {
                    block18 : {
                        block17 : {
                            ObjectAnimator objectAnimator;
                            View view2;
                            block23 : {
                                ObjectAnimator objectAnimator2;
                                int n6;
                                Rect rect;
                                int n7;
                                int n8;
                                int n9;
                                int n10;
                                Rect rect2;
                                int n11;
                                int n12;
                                int n13;
                                int n14;
                                int n15;
                                ObjectAnimator objectAnimator3;
                                block19 : {
                                    Path path;
                                    Property<View, PointF> property;
                                    block22 : {
                                        int n16;
                                        int n17;
                                        block20 : {
                                            block21 : {
                                                q q4;
                                                int n18;
                                                if (q2 == null || q3 == null) break block15;
                                                Map map = q2.a;
                                                Map map2 = q3.a;
                                                ViewGroup viewGroup2 = (ViewGroup)map.get((Object)"android:changeBounds:parent");
                                                ViewGroup viewGroup3 = (ViewGroup)map2.get((Object)"android:changeBounds:parent");
                                                if (viewGroup2 == null || viewGroup3 == null) break block16;
                                                view = q3.b;
                                                boolean bl = !this.O || ((q4 = this.o((View)viewGroup2, true)) == null ? viewGroup2 == viewGroup3 : viewGroup3 == q4.b);
                                                if (!bl) break block17;
                                                Rect rect3 = (Rect)q2.a.get((Object)"android:changeBounds:bounds");
                                                Rect rect4 = (Rect)q3.a.get((Object)"android:changeBounds:bounds");
                                                n8 = rect3.left;
                                                n14 = rect4.left;
                                                n6 = rect3.top;
                                                n9 = rect4.top;
                                                n17 = rect3.right;
                                                n15 = rect4.right;
                                                n16 = rect3.bottom;
                                                n12 = rect4.bottom;
                                                n10 = n17 - n8;
                                                n13 = n16 - n6;
                                                n11 = n15 - n14;
                                                n7 = n12 - n9;
                                                rect2 = (Rect)q2.a.get((Object)"android:changeBounds:clip");
                                                rect = (Rect)q3.a.get((Object)"android:changeBounds:clip");
                                                if (n10 != 0 && n13 != 0 || n11 != 0 && n7 != 0) {
                                                    n18 = n8 == n14 && n6 == n9 ? 0 : 1;
                                                    if (n17 != n15 || n16 != n12) {
                                                        ++n18;
                                                    }
                                                } else {
                                                    n18 = 0;
                                                }
                                                if (rect2 != null && !rect2.equals((Object)rect) || rect2 == null && rect != null) {
                                                    ++n18;
                                                }
                                                if (n18 <= 0) break block18;
                                                if (this.N) break block19;
                                                view2 = view;
                                                v.d((View)view2, (int)n8, (int)n6, (int)n17, (int)n16);
                                                if (n18 != 2) break block20;
                                                if (n10 != n11 || n13 != n7) break block21;
                                                path = this.I.a((float)n8, (float)n6, (float)n14, (float)n9);
                                                property = V;
                                                break block22;
                                            }
                                            k k2 = new /* Unavailable Anonymous Inner Class!! */;
                                            Path path2 = this.I.a((float)n8, (float)n6, (float)n14, (float)n9);
                                            ObjectAnimator objectAnimator4 = h.i.e1(k2, R, path2);
                                            Path path3 = this.I.a((float)n17, (float)n16, (float)n15, (float)n12);
                                            ObjectAnimator objectAnimator5 = h.i.e1(k2, S, path3);
                                            objectAnimator = new AnimatorSet();
                                            objectAnimator.playTogether(new Animator[]{objectAnimator4, objectAnimator5});
                                            objectAnimator.addListener((Animator.AnimatorListener)new h(this, k2));
                                            break block23;
                                        }
                                        if (n8 == n14 && n6 == n9) {
                                            path = this.I.a((float)n17, (float)n16, (float)n15, (float)n12);
                                            property = T;
                                        } else {
                                            path = this.I.a((float)n8, (float)n6, (float)n14, (float)n9);
                                            property = U;
                                        }
                                    }
                                    objectAnimator = h.i.e1(view2, property, path);
                                    break block23;
                                }
                                view2 = view;
                                int n19 = Math.max((int)n10, (int)n11);
                                int n20 = Math.max((int)n13, (int)n7);
                                v.d((View)view2, (int)n8, (int)n6, (int)(n19 + n8), (int)(n20 + n6));
                                if (n8 == n14 && n6 == n9) {
                                    objectAnimator2 = null;
                                } else {
                                    Path path = this.I.a((float)n8, (float)n6, (float)n14, (float)n9);
                                    objectAnimator2 = h.i.e1(view2, V, path);
                                }
                                Rect rect5 = rect2 == null ? new Rect(0, 0, n10, n13) : rect2;
                                Rect rect6 = rect == null ? new Rect(0, 0, n11, n7) : rect;
                                if (!rect5.equals((Object)rect6)) {
                                    l.W((View)view2, (Rect)rect5);
                                    ObjectAnimator objectAnimator6 = ObjectAnimator.ofObject((Object)view2, (String)"clipBounds", (TypeEvaluator)W, (Object[])new Object[]{rect5, rect6});
                                    i i2 = new i(this, view2, rect, n14, n9, n15, n12);
                                    objectAnimator6.addListener((Animator.AnimatorListener)i2);
                                    objectAnimator3 = objectAnimator6;
                                } else {
                                    objectAnimator3 = null;
                                }
                                objectAnimator = p.b((Animator)objectAnimator2, objectAnimator3);
                            }
                            if (view2.getParent() instanceof ViewGroup) {
                                ViewGroup viewGroup4 = (ViewGroup)view2.getParent();
                                s.a((ViewGroup)viewGroup4, (boolean)true);
                                this.a((i.d)new j(this, viewGroup4));
                            }
                            return objectAnimator;
                        }
                        n2 = (Integer)q2.a.get((Object)"android:changeBounds:windowX");
                        n5 = (Integer)q2.a.get((Object)"android:changeBounds:windowY");
                        n4 = (Integer)q3.a.get((Object)"android:changeBounds:windowX");
                        n3 = (Integer)q3.a.get((Object)"android:changeBounds:windowY");
                        if (n2 != n4 || n5 != n3) break block24;
                    }
                    return null;
                }
                viewGroup.getLocationInWindow(this.M);
                Bitmap bitmap = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(bitmap));
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                float f2 = v.b((View)view);
                v.a.e(view, 0.0f);
                viewGroup.getOverlay().add((Drawable)bitmapDrawable);
                f.r.e e2 = this.I;
                int[] arrn = this.M;
                Path path = e2.a((float)(n2 - arrn[0]), (float)(n5 - arrn[1]), (float)(n4 - arrn[0]), (float)(n3 - arrn[1]));
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder((Object)bitmapDrawable, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(Q, null, (Path)path)});
                a a2 = new a(this, viewGroup, bitmapDrawable, view, f2);
                objectAnimator.addListener((Animator.AnimatorListener)a2);
                return objectAnimator;
            }
            return null;
        }
        return null;
    }

    public String[] q() {
        return P;
    }
}

