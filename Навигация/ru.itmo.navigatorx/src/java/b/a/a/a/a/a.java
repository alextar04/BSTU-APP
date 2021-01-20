/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextWatcher
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.LinearInterpolator
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.Fragment
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$l
 *  b.a.a.a.a.a$i$a
 *  b.a.a.a.a.a$j
 *  b.a.a.a.a.a$k
 *  b.a.a.a.a.a$m$a
 *  b.a.a.a.a.j.a
 *  b.a.a.a.a.j.a$a
 *  b.a.a.a.a.j.d
 *  b.a.a.a.a.k.a
 *  b.a.a.b.d$a
 *  b.a.a.b.d$c
 *  b.a.a.b.d$e
 *  b.a.a.d.d
 *  b.a.a.d.h$a
 *  b.a.a.d.h$b
 *  b.a.a.d.j$a
 *  c.a.a.c
 *  c.c.a.h
 *  c.c.a.i
 *  c.c.a.q.e
 *  c.c.a.q.h.e
 *  c.c.a.r.a
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.textfield.TextInputEditText
 *  d.a.l1.e
 *  f.b.k.h
 *  f.l.d.e
 *  f.n.d0
 *  f.n.h0
 *  f.n.m
 *  f.n.n
 *  f.p.d.b
 *  f.p.d.m
 *  f.p.d.m$b
 *  f.p.d.m$c
 *  f.p.d.m$d
 *  f.p.d.m$e
 *  f.p.d.m$f
 *  f.p.d.s
 *  h.a
 *  h.h
 *  h.i.h
 *  h.k.d
 *  h.k.i.a
 *  h.k.j.a.e
 *  h.m.a.a
 *  h.m.a.l
 *  h.m.a.p
 *  h.m.b.f
 *  h.m.b.j
 *  h.m.b.o
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package b.a.a.a.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.a.a;
import b.a.a.a.a.j.a;
import b.a.a.b.d;
import b.a.a.d.h;
import b.a.a.d.j;
import b.a.a.d.k.b;
import c.a.a.c;
import c.a.a.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.otaliastudios.zoom.ZoomMap;
import d.a.x;
import f.b.k.h;
import f.n.d0;
import f.n.h0;
import f.p.d.m;
import f.p.d.s;
import h.m.a.p;
import h.m.b.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
extends Fragment
implements b.a.a.a.a.j.b,
b.a.a.a.a.k.b {
    public final h.a Z;
    public BottomSheetBehavior<ConstraintLayout> a0;
    public BottomSheetBehavior<ConstraintLayout> b0;
    public BottomSheetBehavior<ConstraintLayout> c0;
    public TextView d0;
    public AppCompatImageView e0;
    public b.a.a.a.a.j.a f0;
    public b.a.a.a.a.k.a g0;
    public final b.a.a.a.a.i h0;
    public final b.a.a.d.k.b<j.a> i0;
    public HashMap j0;

    public a() {
        this.X = 2131427380;
        this.Z = h.i.Q(this, o.a(b.a.a.d.d.class), (h.m.a.a<? extends h0>)new h.m.a.a<h0>(){

            public Object a() {
                f.l.d.e e2 = this.l0();
                h.m.b.j.b((Object)e2, (String)"requireActivity()");
                h0 h02 = e2.g();
                h.m.b.j.b((Object)h02, (String)"requireActivity().viewModelStore");
                return h02;
            }
        }, (h.m.a.a<? extends d0>)new h.m.a.a<d0>(){

            public Object a() {
                f.l.d.e e2 = this.l0();
                h.m.b.j.b((Object)e2, (String)"requireActivity()");
                d0 d02 = e2.k();
                h.m.b.j.b((Object)d02, (String)"requireActivity().defaultViewModelProviderFactory");
                return d02;
            }
        });
        this.h0 = new b.a.a.a.a.i();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        h.p.e e2 = b.a.a.a.a.c.l;
        h.m.a.l<List<? extends b.a.a.d.i>, h.h> l2 = new h.m.a.l<List<? extends b.a.a.d.i>, h.h>(){

            public Object f(Object object) {
                List list = (List)object;
                if (list == null) {
                    c.a.a.c c2 = ((ZoomMap)this.w0((int)b.a.a.c.zoom_layout)).f;
                    c2.m.clear();
                    c2.invalidateDrawable(c2.getDrawable());
                } else {
                    c.a.a.c c3 = ((ZoomMap)this.w0((int)b.a.a.c.zoom_layout)).f;
                    c3.m.clear();
                    c3.invalidateDrawable(c3.getDrawable());
                    for (b.a.a.d.i i2 : list) {
                        ZoomMap zoomMap = (ZoomMap)this.w0(b.a.a.c.zoom_layout);
                        if (this.h0 != null) {
                            h.m.b.j.e((Object)i2, (String)"path");
                            List<b.a.a.b.e> list2 = i2.a;
                            ArrayList arrayList = new ArrayList(h.i.x(list2, 10));
                            for (b.a.a.b.e e2 : list2) {
                                arrayList.add((Object)new c.a(e2.b, e2.c));
                            }
                            int n2 = zoomMap.i;
                            h.m.b.j.e((Object)arrayList, (String)"path");
                            c.a.a.c c4 = zoomMap.f;
                            ArrayList arrayList2 = new ArrayList(h.i.x(arrayList, 10));
                            for (c.a a2 : arrayList) {
                                arrayList2.add((Object)new c.a(a2.a - (float)((zoomMap.k - zoomMap.g) / 2), a2.b - (float)((zoomMap.l - zoomMap.h) / 2)));
                            }
                            if (c4 != null) {
                                h.m.b.j.e((Object)arrayList2, (String)"pathPoints");
                                Path path = new Path();
                                path.moveTo(((c.a)arrayList2.get((int)0)).a, ((c.a)arrayList2.get((int)0)).b);
                                int n3 = arrayList2.size();
                                for (int i3 = 1; i3 < n3; ++i3) {
                                    path.lineTo(((c.a)arrayList2.get((int)i3)).a, ((c.a)arrayList2.get((int)i3)).b);
                                }
                                c4.n.setPath(path, false);
                                float f2 = c4.n.getLength();
                                c4.m.add((Object)new c.b(path, f2, n2));
                                c4.invalidateDrawable(c4.getDrawable());
                                continue;
                            }
                            throw null;
                        }
                        throw null;
                    }
                    ZoomMap zoomMap = (ZoomMap)this.w0(b.a.a.c.zoom_layout);
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)zoomMap.f, (String)"pathProgress", (float[])new float[]{0.0f, 1.0f});
                    objectAnimator.setDuration(zoomMap.j);
                    objectAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
                    objectAnimator.start();
                }
                return h.h.a;
            }
        };
        b.a.a.d.k.a a2 = b.a.a.d.k.a.f;
        h.m.b.j.e((Object)e2, (String)"accessor");
        h.m.b.j.e((Object)a2, (String)"diff");
        h.m.b.j.e((Object)l2, (String)"callback");
        arrayList.add(new b.a(e2, l2, a2));
        h.p.e e3 = b.a.a.a.a.d.l;
        h.p.e e4 = b.a.a.a.a.e.l;
        h.m.b.j.e((Object)e3, (String)"$this$or");
        h.m.b.j.e((Object)e4, (String)"f");
        h.m.b.j.e((Object)e3, (String)"$this$or");
        h.m.b.j.e((Object)e4, (String)"f");
        b.a.a.d.k.d d2 = new b.a.a.d.k.d(e3, e4);
        h.m.a.l<j.a, h.h> l3 = new h.m.a.l<j.a, h.h>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public Object f(Object object) {
                j.a a2 = object;
                h.m.b.j.e((Object)a2, (String)"it");
                List<Integer> list = a2.c.i;
                int n2 = a2.d - 1;
                h.m.b.j.e(list, (String)"$this$getOrNull");
                Object object2 = n2 >= 0 && n2 <= h.i.i0(list) ? list.get(n2) : null;
                Integer n3 = (Integer)object2;
                if (n3 == null) return h.h.a;
                int n4 = n3;
                b.a.a.a.a.b b2 = new b.a.a.a.a.b((View)((ZoomMap)this.w0(b.a.a.c.zoom_layout)), this);
                c.c.a.i i2 = c.c.a.b.d(this.m0());
                if (i2 == null) throw null;
                c.c.a.h h2 = new c.c.a.h(i2.e, i2, Bitmap.class, i2.f).o((c.c.a.q.a)c.c.a.i.p);
                h2.J = n4;
                h2.M = true;
                c.c.a.m.m m2 = c.c.a.r.a.c((Context)h2.E);
                c.c.a.h h3 = h2.o((c.c.a.q.a)((c.c.a.q.e)new c.c.a.q.e().j(m2)));
                if (h3 == null) throw null;
                ((c.c.a.h)h3.i(c.c.a.m.w.g.i.b, Boolean.TRUE)).o(new c.c.a.q.e().f(2048, 2048)).q((c.c.a.q.h.e)b2);
                return h.h.a;
            }
        };
        h.m.b.j.e((Object)d2, (String)"$this$invoke");
        h.m.b.j.e((Object)l3, (String)"callback");
        h.m.b.j.e((Object)d2, (String)"$this$invoke");
        h.m.b.j.e((Object)l3, (String)"callback");
        b.a.a.d.k.c c2 = b.a.a.d.k.c.f;
        h.m.b.j.e((Object)c2, (String)"accessor");
        h.m.b.j.e((Object)d2, (String)"diff");
        h.m.b.j.e((Object)l3, (String)"callback");
        arrayList.add(new b.a(c2, l3, d2));
        h.p.e e5 = b.a.a.a.a.f.l;
        h.m.a.l<List<? extends b.a.a.a.a.j.c>, h.h> l4 = new h.m.a.l<List<? extends b.a.a.a.a.j.c>, h.h>(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public Object f(Object var1_1) {
                var2_2 = (List)var1_1;
                h.m.b.j.e((Object)var2_2, (String)"markers");
                var3_3 = this.f0;
                if (var3_3 == null) {
                    h.m.b.j.j((String)"markerAdapter");
                    throw null;
                }
                h.m.b.j.e((Object)var2_2, (String)"value");
                var4_4 = new b.a.a.a.a.j.d(var3_3.c, var2_2);
                var3_3.c = var2_2;
                var5_5 = var4_4.a.size();
                var6_6 = var4_4.b.size();
                var7_7 = new ArrayList();
                var8_8 = new ArrayList();
                var8_8.add((Object)new m.e(0, var5_5, 0, var6_6));
                var10_9 = var5_5 + var6_6 + Math.abs((int)(var5_5 - var6_6));
                var11_10 = var10_9 * 2;
                var12_11 = new int[var11_10];
                var13_12 = new int[var11_10];
                var14_13 = new ArrayList();
                do {
                    block52 : {
                        block46 : {
                            block51 : {
                                block50 : {
                                    block48 : {
                                        block49 : {
                                            block47 : {
                                                block33 : {
                                                    block34 : {
                                                        if (var8_8.isEmpty()) break;
                                                        var58_20 = (m.e)var8_8.remove(var8_8.size() - 1);
                                                        var59_21 = var58_20.a;
                                                        var60_22 = var58_20.b;
                                                        var61_23 = var58_20.c;
                                                        var62_24 = var58_20.d;
                                                        var63_25 = var60_22 - var59_21;
                                                        var64_26 = var62_24 - var61_23;
                                                        if (var63_25 >= 1 && var64_26 >= 1) break block34;
                                                        var65_27 = var3_3;
                                                        var66_28 = var14_13;
                                                        var67_29 = var8_8;
                                                        var68_30 = var7_7;
                                                        var69_31 = var58_20;
                                                        var70_32 = null;
                                                        break block33;
                                                    }
                                                    var93_51 = var63_25 - var64_26;
                                                    var94_52 = (1 + (var63_25 + var64_26)) / 2;
                                                    var95_53 = -1 + (var10_9 - var94_52);
                                                    var96_54 = var10_9 + var94_52;
                                                    var65_27 = var3_3;
                                                    var97_55 = var96_54 + 1;
                                                    var67_29 = var8_8;
                                                    Arrays.fill((int[])var12_11, (int)var95_53, (int)var97_55, (int)0);
                                                    Arrays.fill((int[])var13_12, (int)(var95_53 + var93_51), (int)(var97_55 + var93_51), (int)var63_25);
                                                    var98_56 = var93_51 % 2 != 0;
                                                    var99_57 = 0;
                                                    while (var99_57 <= var94_52) {
                                                        var100_58 = -var99_57;
                                                        var101_59 = var94_52;
                                                        for (var102_60 = var100_58; var102_60 <= var99_57; var102_60 += 2) {
                                                            block40 : {
                                                                block31 : {
                                                                    block39 : {
                                                                        block38 : {
                                                                            block35 : {
                                                                                block37 : {
                                                                                    block36 : {
                                                                                        if (var102_60 == var100_58) break block35;
                                                                                        if (var102_60 == var99_57) break block36;
                                                                                        var130_16 = var10_9 + var102_60;
                                                                                        var131_17 = var130_16 - 1;
                                                                                        var66_28 = var14_13;
                                                                                        var132_18 = var12_11[var131_17];
                                                                                        var121_78 = true;
                                                                                        var133_19 = var130_16 + 1;
                                                                                        var69_31 = var58_20;
                                                                                        if (var132_18 >= var12_11[var133_19]) break block37;
                                                                                        break block38;
                                                                                    }
                                                                                    var66_28 = var14_13;
                                                                                    var69_31 = var58_20;
                                                                                    var121_78 = true;
                                                                                }
                                                                                var120_77 = 1 + var12_11[-1 + (var10_9 + var102_60)];
                                                                                break block39;
                                                                            }
                                                                            var66_28 = var14_13;
                                                                            var69_31 = var58_20;
                                                                        }
                                                                        var120_77 = var12_11[1 + (var10_9 + var102_60)];
                                                                        var121_78 = false;
                                                                    }
                                                                    var122_79 = var121_78;
                                                                    var123_80 = var120_77 - var102_60;
                                                                    var68_30 = var7_7;
                                                                    for (var124_81 = var123_80; var120_77 < var63_25 && var124_81 < var64_26; ++var120_77, ++var124_81) {
                                                                        var125_82 = var63_25;
                                                                        var129_15 = var59_21 + var120_77;
                                                                        var126_83 = var64_26;
                                                                        if (var4_4.b(var129_15, var61_23 + var124_81)) {
                                                                            var63_25 = var125_82;
                                                                            var64_26 = var126_83;
                                                                            continue;
                                                                        }
                                                                        break block31;
                                                                    }
                                                                    var125_82 = var63_25;
                                                                    var126_83 = var64_26;
                                                                }
                                                                var127_84 = var10_9 + var102_60;
                                                                var12_11[var127_84] = var120_77;
                                                                if (!var98_56 || var102_60 < 1 + (var93_51 - var99_57) || var102_60 > -1 + (var93_51 + var99_57) || var12_11[var127_84] < var13_12[var127_84]) break block40;
                                                                var70_32 = new m.f();
                                                                var70_32.a = var128_14 = var13_12[var127_84];
                                                                var70_32.b = var128_14 - var102_60;
                                                                var70_32.c = var12_11[var127_84] - var13_12[var127_84];
                                                                var70_32.d = var122_79;
                                                                var114_71 = false;
                                                                ** GOTO lbl153
                                                            }
                                                            var7_7 = var68_30;
                                                            var63_25 = var125_82;
                                                            var14_13 = var66_28;
                                                            var58_20 = var69_31;
                                                            var64_26 = var126_83;
                                                        }
                                                        var66_28 = var14_13;
                                                        var68_30 = var7_7;
                                                        var69_31 = var58_20;
                                                        var103_61 = var63_25;
                                                        var104_62 = var64_26;
                                                        for (var105_63 = var100_58; var105_63 <= var99_57; var105_63 += 2) {
                                                            block45 : {
                                                                block32 : {
                                                                    block44 : {
                                                                        block41 : {
                                                                            block43 : {
                                                                                block42 : {
                                                                                    var107_64 = var105_63 + var93_51;
                                                                                    if (var107_64 == var99_57 + var93_51) break block41;
                                                                                    if (var107_64 == var100_58 + var93_51) break block42;
                                                                                    var118_75 = var10_9 + var107_64;
                                                                                    var119_76 = var13_12[var118_75 - 1];
                                                                                    var117_74 = 1;
                                                                                    if (var119_76 >= var13_12[var118_75 + var117_74]) break block43;
                                                                                    break block41;
                                                                                }
                                                                                var117_74 = 1;
                                                                            }
                                                                            var108_65 = -1 + var13_12[var117_74 + (var10_9 + var107_64)];
                                                                            var109_66 = true;
                                                                            break block44;
                                                                        }
                                                                        var108_65 = var13_12[-1 + (var10_9 + var107_64)];
                                                                        var109_66 = false;
                                                                    }
                                                                    for (var110_67 = var108_65 - var107_64; var108_65 > 0 && var110_67 > 0; --var108_65, --var110_67) {
                                                                        var115_72 = -1 + (var59_21 + var108_65);
                                                                        var116_73 = var61_23 + var110_67;
                                                                        var111_68 = var93_51;
                                                                        if (var4_4.b(var115_72, var116_73 - 1)) {
                                                                            var93_51 = var111_68;
                                                                            continue;
                                                                        }
                                                                        break block32;
                                                                    }
                                                                    var111_68 = var93_51;
                                                                }
                                                                var112_69 = var10_9 + var107_64;
                                                                var13_12[var112_69] = var108_65;
                                                                if (var98_56 || var107_64 < var100_58 || var107_64 > var99_57 || var12_11[var112_69] < var13_12[var112_69]) break block45;
                                                                var70_32 = new m.f();
                                                                var70_32.a = var113_70 = var13_12[var112_69];
                                                                var70_32.b = var113_70 - var107_64;
                                                                var70_32.c = var12_11[var112_69] - var13_12[var112_69];
                                                                var70_32.d = var109_66;
                                                                var114_71 = true;
lbl153: // 2 sources:
                                                                var70_32.e = var114_71;
                                                                break block33;
                                                            }
                                                            var93_51 = var111_68;
                                                        }
                                                        ++var99_57;
                                                        var94_52 = var101_59;
                                                        var7_7 = var68_30;
                                                        var63_25 = var103_61;
                                                        var14_13 = var66_28;
                                                        var58_20 = var69_31;
                                                        var64_26 = var104_62;
                                                    }
                                                    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
                                                }
                                                if (var70_32 == null) break block46;
                                                if (var70_32.c > 0) {
                                                    var72_34 = var68_30;
                                                    var72_34.add(var70_32);
                                                } else {
                                                    var72_34 = var68_30;
                                                }
                                                var75_36 = var70_32.a;
                                                var76_37 = var69_31;
                                                var70_32.a = var75_36 + var76_37.a;
                                                var70_32.b += var76_37.c;
                                                if (var66_28.isEmpty()) {
                                                    var77_38 = new m.e();
                                                    var73_35 = var66_28;
                                                } else {
                                                    var91_50 = -1 + var66_28.size();
                                                    var73_35 = var66_28;
                                                    var77_38 = (m.e)var73_35.remove(var91_50);
                                                }
                                                var77_38.a = var76_37.a;
                                                var77_38.c = var76_37.c;
                                                if (!var70_32.e) break block47;
                                                var90_49 = var70_32.a;
                                                var78_39 = 1;
                                                ** GOTO lbl196
                                            }
                                            if (var70_32.d) {
                                                var89_48 = var70_32.a;
                                                var78_39 = 1;
                                                var90_49 = var89_48 - var78_39;
lbl196: // 2 sources:
                                                var77_38.b = var90_49;
                                                var79_40 = var70_32.b;
                                            } else {
                                                var78_39 = 1;
                                                var77_38.b = var70_32.a;
                                                var79_40 = var70_32.b - var78_39;
                                            }
                                            var77_38.d = var79_40;
                                            var71_33 = var67_29;
                                            var71_33.add((Object)var77_38);
                                            if (!var70_32.e) break block48;
                                            if (!var70_32.d) break block49;
                                            var88_47 = var70_32.a;
                                            var82_42 = var70_32.c;
                                            var83_43 = var78_39 + (var88_47 + var82_42);
                                            break block50;
                                        }
                                        var86_45 = var70_32.a;
                                        var87_46 = var70_32.c;
                                        var76_37.a = var86_45 + var87_46;
                                        var84_44 = var78_39 + (var87_46 + var70_32.b);
                                        break block51;
                                    }
                                    var81_41 = var70_32.a;
                                    var82_42 = var70_32.c;
                                    var83_43 = var81_41 + var82_42;
                                }
                                var76_37.a = var83_43;
                                var84_44 = var82_42 + var70_32.b;
                            }
                            var76_37.c = var84_44;
                            var71_33.add((Object)var76_37);
                            break block52;
                        }
                        var71_33 = var67_29;
                        var72_34 = var68_30;
                        var73_35 = var66_28;
                        var73_35.add((Object)var69_31);
                    }
                    var14_13 = var73_35;
                    var8_8 = var71_33;
                    var7_7 = var72_34;
                    var3_3 = var65_27;
                } while (true);
                var15_85 = var3_3;
                Collections.sort((List)var7_7, (Comparator)f.p.d.m.a);
                var16_86 = new m.c((m.b)var4_4, (List)var7_7, var12_11, var13_12, false);
                h.m.b.j.d((Object)var16_86, (String)"DiffUtil.calculateDiff(diffCallback, false)");
                var17_87 = var15_85.b;
                var18_88 = var17_87 instanceof f.p.d.b != false ? (f.p.d.b)var17_87 : new f.p.d.b((s)var17_87);
                var19_89 = new ArrayList();
                var20_90 = var16_86.e;
                var21_91 = var16_86.f;
                var22_92 = -1 + var16_86.a.size();
                do {
                    block53 : {
                        block54 : {
                            if (var22_92 < 0) {
                                var18_88.e();
                                return h.h.a;
                            }
                            var23_93 = (m.f)var16_86.a.get(var22_92);
                            var24_94 = var23_93.c;
                            var25_95 = var24_94 + var23_93.a;
                            var26_96 = var24_94 + var23_93.b;
                            var27_97 = 8;
                            var28_98 = 4;
                            if (var25_95 >= var20_90) break block53;
                            var43_110 = var20_90 - var25_95;
                            if (var16_86.g) break block54;
                            var18_88.a(var25_95, var43_110);
                            break block53;
                        }
                        for (var44_111 = var43_110 - 1; var44_111 >= 0; --var44_111) {
                            block57 : {
                                block55 : {
                                    block56 : {
                                        var45_112 = var16_86.b;
                                        var46_113 = var25_95 + var44_111;
                                        var47_114 = 31 & var45_112[var46_113];
                                        if (var47_114 == 0) break block55;
                                        if (var47_114 == var28_98 || var47_114 == var27_97) break block56;
                                        if (var47_114 != 16) {
                                            var55_122 = c.b.a.a.a.d("unknown flag for pos ", var46_113, " ");
                                            var55_122.append(Long.toBinaryString((long)var47_114));
                                            throw new IllegalStateException(var55_122.toString());
                                        }
                                        var19_89.add((Object)new m.d(var46_113, var46_113, true));
                                        var48_115 = var24_94;
                                        break block57;
                                    }
                                    var52_119 = m.c.b((List)var19_89, (int)(var16_86.b[var46_113] >> 5), (boolean)false);
                                    var53_120 = var52_119.b;
                                    var48_115 = var24_94;
                                    var18_88.c(var46_113, var53_120 - 1);
                                    if (var47_114 != 4) break block57;
                                    var54_121 = var52_119.b - 1;
                                    if (var16_86.d == null) throw null;
                                    var18_88.d(var54_121, 1, null);
                                    break block57;
                                }
                                var48_115 = var24_94;
                                var49_116 = 1;
                                var18_88.a(var46_113, var49_116);
                                for (m.d var51_118 : var19_89) {
                                    var51_118.b -= var49_116;
                                    var49_116 = 1;
                                }
                            }
                            var27_97 = 8;
                            var28_98 = 4;
                            var24_94 = var48_115;
                        }
                    }
                    var29_99 = var24_94;
                    if (var26_96 < var21_91) {
                        var33_103 = var21_91 - var26_96;
                        if (!var16_86.g) {
                            var18_88.b(var25_95, var33_103);
                        } else {
                            while (--var33_103 >= 0) {
                                var34_104 = var16_86.c;
                                var35_105 = var26_96 + var33_103;
                                var36_106 = 31 & var34_104[var35_105];
                                if (var36_106 != 0) {
                                    if (var36_106 != 4 && var36_106 != 8) {
                                        if (var36_106 != 16) {
                                            var40_123 = c.b.a.a.a.d("unknown flag for pos ", var35_105, " ");
                                            var40_123.append(Long.toBinaryString((long)var36_106));
                                            throw new IllegalStateException(var40_123.toString());
                                        }
                                        var19_89.add((Object)new m.d(var35_105, var25_95, false));
                                        continue;
                                    }
                                    var18_88.c(m.c.b((List)var19_89, (int)(var16_86.c[var35_105] >> 5), (boolean)true).b, var25_95);
                                    if (var36_106 != 4) continue;
                                    if (var16_86.d == null) throw null;
                                    var18_88.d(var25_95, 1, null);
                                    continue;
                                }
                                var37_107 = 1;
                                var18_88.b(var25_95, var37_107);
                                for (m.d var39_109 : var19_89) {
                                    var39_109.b = var37_107 + var39_109.b;
                                    var37_107 = 1;
                                }
                            }
                        }
                    }
                    var30_100 = var29_99;
                    while (--var30_100 >= 0) {
                        var31_101 = var16_86.b;
                        var32_102 = var30_100 + var23_93.a;
                        if ((31 & var31_101[var32_102]) != 2) continue;
                        if (var16_86.d == null) throw null;
                        var18_88.d(var32_102, 1, null);
                    }
                    var20_90 = var23_93.a;
                    var21_91 = var23_93.b;
                    --var22_92;
                } while (true);
            }
        };
        b.a.a.d.k.a a3 = b.a.a.d.k.a.f;
        h.m.b.j.e((Object)e5, (String)"accessor");
        h.m.b.j.e((Object)a3, (String)"diff");
        h.m.b.j.e((Object)l4, (String)"callback");
        arrayList.add(new b.a(e5, l4, a3));
        this.i0 = new b.a.a.d.k.b((List)arrayList, (Map)hashMap, null);
    }

    public static final /* synthetic */ AppCompatImageView A0(a a2) {
        AppCompatImageView appCompatImageView = a2.e0;
        if (appCompatImageView != null) {
            return appCompatImageView;
        }
        h.m.b.j.j((String)"roomPickerImage");
        throw null;
    }

    public static final /* synthetic */ TextView B0(a a2) {
        TextView textView = a2.d0;
        if (textView != null) {
            return textView;
        }
        h.m.b.j.j((String)"roomPickerRoomInfo");
        throw null;
    }

    public static final /* synthetic */ b.a.a.d.d C0(a a2) {
        return a2.D0();
    }

    public static final /* synthetic */ BottomSheetBehavior x0(a a2) {
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = a2.a0;
        if (bottomSheetBehavior != null) {
            return bottomSheetBehavior;
        }
        h.m.b.j.j((String)"navigationBottomSheetBehavior");
        throw null;
    }

    public static final /* synthetic */ BottomSheetBehavior y0(a a2) {
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = a2.b0;
        if (bottomSheetBehavior != null) {
            return bottomSheetBehavior;
        }
        h.m.b.j.j((String)"roomInfoBottomSheetBehavior");
        throw null;
    }

    public static final /* synthetic */ BottomSheetBehavior z0(a a2) {
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = a2.c0;
        if (bottomSheetBehavior != null) {
            return bottomSheetBehavior;
        }
        h.m.b.j.j((String)"roomPickerBottomSheetBehavior");
        throw null;
    }

    public final b.a.a.d.d D0() {
        return (b.a.a.d.d)this.Z.getValue();
    }

    public void R() {
        this.H = true;
        HashMap hashMap = this.j0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override
    public void d(b.a.a.b.d d2) {
        h.m.b.j.e((Object)d2, (String)"marker");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRoomPicked: marker: ");
        stringBuilder.append((Object)d2);
        Log.d((String)"MapFragment", (String)stringBuilder.toString());
        b.a.a.d.d d3 = this.D0();
        if (d3 != null) {
            h.m.b.j.e((Object)d2, (String)"marker");
            b.a.a.d.j j2 = (b.a.a.d.j)d3.e.getValue();
            if (j2 instanceof j.a) {
                j.a a2 = j2;
                b.a.a.d.h h2 = a2.a;
                if (h2 instanceof h.b) {
                    if ((h2).a == h.a.e) {
                        d3.e(a2, d2, a2.f);
                        return;
                    }
                    d3.e(a2, a2.e, d2);
                }
            }
            return;
        }
        throw null;
    }

    public void e0(View view, Bundle bundle) {
        h.m.b.j.e((Object)view, (String)"view");
        this.f0 = new b.a.a.a.a.j.a((List)h.i.h.e, (b.a.a.a.a.j.b)this);
        ZoomMap zoomMap = (ZoomMap)this.w0(b.a.a.c.zoom_layout);
        b.a.a.a.a.j.a a2 = this.f0;
        if (a2 != null) {
            zoomMap.setAdapter((c.a.a.m<n>)a2);
            this.g0 = new b.a.a.a.a.k.a((List)h.i.h.e, (b.a.a.a.a.k.b)this);
            this.m0();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1, false);
            RecyclerView recyclerView = (RecyclerView)this.w0(b.a.a.c.room_picker_recycler_view);
            b.a.a.a.a.k.a a3 = this.g0;
            if (a3 != null) {
                recyclerView.setAdapter((RecyclerView.d)a3);
                recyclerView.setLayoutManager((RecyclerView.l)linearLayoutManager);
                view.post(new Runnable(this){
                    public final /* synthetic */ a e;
                    {
                        this.e = a2;
                    }

                    public final void run() {
                        ZoomMap zoomMap = (ZoomMap)this.e.w0(b.a.a.c.zoom_layout);
                        java.lang.Float f2 = java.lang.Float.valueOf((float)1.0f);
                        c.a.a.a a2 = zoomMap.q;
                        if (a2 != null) {
                            float f3;
                            if (f2 != null) {
                                float f4 = f2.floatValue();
                                c.a.a.o.e.c c2 = a2.h;
                                float f5 = c2.d() / c2.b;
                                c.a.a.o.e.c c3 = a2.h;
                                f3 = h.i.v(f4, f5, c3.c() / c3.b);
                            } else {
                                f3 = a2.g();
                            }
                            float f6 = f3 * a2.h.b;
                            c.a.a.o.d.a a3 = a2.i;
                            float f7 = a3.f / f6 / 2.0f;
                            float f8 = a3.g / f6 / 2.0f;
                            float f9 = a2.e() / 2.0f;
                            float f10 = a2.d() / 2.0f;
                            float f11 = f9 - f7;
                            float f12 = f10 - f8;
                            a2.h(f3, -f11, -f12, false);
                            return;
                        }
                        throw null;
                    }
                });
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.I((View)((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_room_info)));
                h.m.b.j.d((Object)bottomSheetBehavior, (String)"BottomSheetBehavior.from(bottom_sheet_room_info)");
                this.b0 = bottomSheetBehavior;
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.I((View)((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_navigation)));
                bottomSheetBehavior2.y = false;
                h.m.b.j.d((Object)bottomSheetBehavior2, (String)"BottomSheetBehavior.from\u2026aggable = false\n        }");
                this.a0 = bottomSheetBehavior2;
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.I((View)((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_room_picker_info)));
                bottomSheetBehavior3.x = true;
                h.m.b.j.d((Object)bottomSheetBehavior3, (String)"BottomSheetBehavior.from\u2026ollapsed = true\n        }");
                this.c0 = bottomSheetBehavior3;
                ((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_room_info)).setOnClickListener((View.OnClickListener)a.f);
                ((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_navigation)).setOnClickListener((View.OnClickListener)a.g);
                ((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_room_picker_info)).setOnClickListener((View.OnClickListener)a.h);
                ((ZoomMap)this.w0(b.a.a.c.zoom_layout)).setOnOutsideClickListener(new View.OnClickListener(8, this){
                    public final /* synthetic */ int e;
                    public final /* synthetic */ Object f;
                    {
                        this.e = n2;
                        this.f = object;
                    }

                    public final void onClick(View view) {
                        h.a a2 = h.a.f;
                        switch (this.e) {
                            default: {
                                throw null;
                            }
                            case 8: {
                                a.C0((a)this.f).h();
                                return;
                            }
                            case 7: {
                                b.a.a.d.d d2 = a.C0((a)this.f);
                                b.a.a.d.j j2 = (b.a.a.d.j)d2.e.getValue();
                                if (j2 instanceof j.a) {
                                    j.a a3 = j2;
                                    if (a3.d != 1) {
                                        d.a.l1.d d3 = d2.d;
                                        b.a.a.d.h$c c2 = b.a.a.d.h$c.a;
                                        List<b.a.a.b.d> list = d2.i.b.getValue().a;
                                        ArrayList arrayList = new ArrayList();
                                        for (Object object : list) {
                                            b.a.a.b.d d4 = (b.a.a.b.d)object;
                                            boolean bl = d4.f == a3.c && d4.e == a3.d - 1;
                                            if (!bl) continue;
                                            arrayList.add(object);
                                        }
                                        ArrayList arrayList2 = new ArrayList(h.i.x(arrayList, 10));
                                        for (b.a.a.b.d d5 : arrayList) {
                                            String string;
                                            String string2;
                                            b.a.a.b.d d6;
                                            Map<String, b.a.a.d.i$a> map;
                                            b.a.a.d.b b2 = a3.g;
                                            b.a.a.d.i$a a4 = b2 != null && (map = b2.b) != null ? (b.a.a.d.i$a)((Object)map.get((Object)d5.a)) : null;
                                            String string3 = d2.g(a4);
                                            String string4 = d5.a;
                                            b.a.a.b.d d7 = a3.e;
                                            String string5 = d7 != null ? d7.a : null;
                                            boolean bl = h.m.b.j.a((Object)string4, (Object)string5) || h.m.b.j.a((Object)(string2 = d5.a), (Object)(string = (d6 = a3.f) != null ? d6.a : null));
                                            b.a.a.a.a.j.c c3 = new b.a.a.a.a.j.c(d5, false, bl, string3, 2);
                                            arrayList2.add((Object)c3);
                                        }
                                        int n2 = a3.d;
                                        int n3 = n2 - 1;
                                        b.a.a.d.b b3 = a3.g;
                                        List list2 = null;
                                        if (b3 != null) {
                                            Map<Integer, List<b.a.a.d.i>> map = b3.a;
                                            list2 = null;
                                            if (map != null) {
                                                list2 = (List)map.get((Object)(n2 - 1));
                                            }
                                        }
                                        d3.setValue(j.a.b(a3, (b.a.a.d.h)c2, (List)arrayList2, null, (int)n3, null, null, null, list2, (int)116));
                                    }
                                }
                                return;
                            }
                            case 6: {
                                b.a.a.d.d d8 = a.C0((a)this.f);
                                b.a.a.d.j j3 = (b.a.a.d.j)d8.e.getValue();
                                if (j3 instanceof j.a) {
                                    j.a a5 = j3;
                                    if (a5.d != a5.c.h) {
                                        d.a.l1.d d9 = d8.d;
                                        b.a.a.d.h$c c4 = b.a.a.d.h$c.a;
                                        List<b.a.a.b.d> list = d8.i.b.getValue().a;
                                        ArrayList arrayList = new ArrayList();
                                        for (Object object : list) {
                                            b.a.a.b.d d10 = (b.a.a.b.d)object;
                                            boolean bl = d10.f == a5.c && d10.e == 1 + a5.d;
                                            if (!bl) continue;
                                            arrayList.add(object);
                                        }
                                        ArrayList arrayList3 = new ArrayList(h.i.x(arrayList, 10));
                                        for (b.a.a.b.d d11 : arrayList) {
                                            b.a.a.b.d d12;
                                            Map<String, b.a.a.d.i$a> map;
                                            String string;
                                            String string6;
                                            b.a.a.d.b b4 = a5.g;
                                            b.a.a.d.i$a a6 = b4 != null && (map = b4.b) != null ? (b.a.a.d.i$a)((Object)map.get((Object)d11.a)) : null;
                                            String string7 = d8.g(a6);
                                            String string8 = d11.a;
                                            b.a.a.b.d d13 = a5.e;
                                            String string9 = d13 != null ? d13.a : null;
                                            boolean bl = h.m.b.j.a((Object)string8, (Object)string9) || h.m.b.j.a((Object)(string = d11.a), (Object)(string6 = (d12 = a5.f) != null ? d12.a : null));
                                            b.a.a.a.a.j.c c5 = new b.a.a.a.a.j.c(d11, false, bl, string7, 2);
                                            arrayList3.add((Object)c5);
                                        }
                                        int n4 = 1 + a5.d;
                                        b.a.a.d.b b5 = a5.g;
                                        List list3 = null;
                                        if (b5 != null) {
                                            Map<Integer, List<b.a.a.d.i>> map = b5.a;
                                            list3 = null;
                                            if (map != null) {
                                                list3 = (List)map.get((Object)n4);
                                            }
                                        }
                                        d9.setValue(j.a.b(a5, (b.a.a.d.h)c4, (List)arrayList3, null, (int)n4, null, null, null, list3, (int)116));
                                    }
                                }
                                return;
                            }
                            case 5: {
                                b.a.a.a.b.d d14 = new b.a.a.a.b.d();
                                f.l.d.e e2 = ((a)this.f).l0();
                                h.m.b.j.d((Object)e2, (String)"requireActivity()");
                                f.l.d.r r2 = e2.m();
                                String string = d14.B;
                                d14.l0 = false;
                                d14.m0 = true;
                                if (r2 != null) {
                                    f.l.d.a a7 = new f.l.d.a(r2);
                                    a7.d(0, (Fragment)d14, string, 1);
                                    a7.c();
                                    return;
                                }
                                throw null;
                            }
                            case 4: {
                                b.a.a.d.d d15 = a.C0((a)this.f);
                                b.a.a.d.j j4 = (b.a.a.d.j)d15.e.getValue();
                                if (j4 instanceof j.a) {
                                    j.a a8 = j4;
                                    b.a.a.d.h h2 = a8.a;
                                    if (h2 instanceof h.b) {
                                        b.a.a.d.h$c c6;
                                        int n5;
                                        d.a.l1.d d16 = d15.d;
                                        if ((h2).a == a2) {
                                            c6 = b.a.a.d.h$c.a;
                                            n5 = 222;
                                        } else {
                                            c6 = b.a.a.d.h$c.a;
                                            n5 = 238;
                                        }
                                        d16.setValue(j.a.b(a8, (b.a.a.d.h)c6, null, null, (int)0, null, null, null, null, (int)n5));
                                    }
                                }
                                return;
                            }
                            case 3: {
                                b.a.a.d.d d17 = a.C0((a)this.f);
                                b.a.a.d.j j5 = (b.a.a.d.j)d17.e.getValue();
                                if (j5 instanceof j.a) {
                                    j.a a9 = j5;
                                    b.a.a.d.h h3 = a9.a;
                                    if (h3 instanceof h.a) {
                                        d17.e(a9, (h3).a, a9.f);
                                    }
                                }
                                return;
                            }
                            case 2: {
                                b.a.a.d.d d18 = a.C0((a)this.f);
                                b.a.a.d.j j6 = (b.a.a.d.j)d18.e.getValue();
                                if (j6 instanceof j.a) {
                                    j.a a10 = j6;
                                    b.a.a.d.h h4 = a10.a;
                                    if (h4 instanceof h.a) {
                                        d18.e(a10, a10.e, (h4).a);
                                    }
                                }
                                return;
                            }
                            case 1: {
                                b.a.a.d.d d19 = a.C0((a)this.f);
                                b.a.a.d.j j7 = (b.a.a.d.j)d19.e.getValue();
                                if (j7 instanceof j.a) {
                                    d.a.l1.d d20 = d19.d;
                                    j.a a11 = j7;
                                    d20.setValue(j.a.b(a11, (b.a.a.d.h)new /* Unavailable Anonymous Inner Class!! */, null, null, (int)0, null, null, null, null, (int)254));
                                }
                                return;
                            }
                            case 0: 
                        }
                        b.a.a.d.d d21 = a.C0((a)this.f);
                        b.a.a.d.j j8 = (b.a.a.d.j)d21.e.getValue();
                        if (j8 instanceof j.a) {
                            d.a.l1.d d22 = d21.d;
                            j.a a12 = j8;
                            d22.setValue(j.a.b(a12, (b.a.a.d.h)new /* Unavailable Anonymous Inner Class!! */, null, null, (int)0, null, null, null, null, (int)254));
                        }
                    }
                });
                View view2 = ((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_room_info)).findViewById(2131230934);
                h.m.b.j.d((Object)view2, (String)"bottom_sheet_room_info.f\u2026iewById(R.id.marker_text)");
                this.d0 = (TextView)view2;
                View view3 = ((ConstraintLayout)this.w0(b.a.a.c.bottom_sheet_room_info)).findViewById(2131231011);
                h.m.b.j.d((Object)view3, (String)"bottom_sheet_room_info.f\u2026ViewById(R.id.room_image)");
                this.e0 = (AppCompatImageView)view3;
                View view4 = this.w0(b.a.a.c.room_info_place);
                h.m.b.j.d((Object)view4, (String)"room_info_place");
                ((ImageView)view4.findViewById(b.a.a.c.room_description_image)).setImageResource(2131165297);
                View view5 = this.w0(b.a.a.c.room_info_department);
                h.m.b.j.d((Object)view5, (String)"room_info_department");
                ((ImageView)view5.findViewById(b.a.a.c.room_description_image)).setImageResource(2131165295);
                View view6 = this.w0(b.a.a.c.room_info_description);
                h.m.b.j.d((Object)view6, (String)"room_info_description");
                ((ImageView)view6.findViewById(b.a.a.c.room_description_image)).setImageResource(2131165296);
                h.i.O0((x)f.n.n.a((f.n.m)this), null, null, (p)new p<x, h.k.d<? super h.h>, Object>(this, null){
                    public x i;
                    public Object j;
                    public Object k;
                    public int l;
                    public final /* synthetic */ a m;
                    {
                        this.m = a2;
                        super(2, (h.k.d<Object>)d2);
                    }

                    public final Object c(Object object, Object object2) {
                        h.k.d d2 = (h.k.d)object2;
                        h.m.b.j.e((Object)d2, (String)"completion");
                        p<x, h.k.d<? super h.h>, Object> p2 = new /* invalid duplicate definition of identical inner class */;
                        p2.i = (x)object;
                        return p2.i((Object)h.h.a);
                    }

                    @Override
                    public final h.k.d<h.h> g(Object object, h.k.d<?> d2) {
                        h.m.b.j.e(d2, (String)"completion");
                        p<x, h.k.d<? super h.h>, Object> p2 = new /* invalid duplicate definition of identical inner class */;
                        p2.i = (x)object;
                        return p2;
                    }

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    @Override
                    public final Object i(Object object) {
                        h.k.i.a a2 = h.k.i.a.e;
                        int n2 = this.l;
                        if (n2 != 0) {
                            if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            (d.a.l1.a)this.k;
                            (x)this.j;
                            h.i.O1(object);
                            return h.h.a;
                        } else {
                            h.i.O1(object);
                            x x2 = this.i;
                            d.a.l1.e e2 = a.C0((a)this.m).g;
                            a a3 = new a(this);
                            this.j = x2;
                            this.k = e2;
                            this.l = 1;
                            if (e2.b(a3, this) != a2) return h.h.a;
                            return a2;
                        }
                    }
                }, 3, null);
                h.i.O0((x)f.n.n.a((f.n.m)this), null, null, (p)new p<x, h.k.d<? super h.h>, Object>(this, null){
                    public x i;
                    public Object j;
                    public Object k;
                    public int l;
                    public final /* synthetic */ a m;
                    {
                        this.m = a2;
                        super(2, (h.k.d<Object>)d2);
                    }

                    public final Object c(Object object, Object object2) {
                        h.k.d d2 = (h.k.d)object2;
                        h.m.b.j.e((Object)d2, (String)"completion");
                        p<x, h.k.d<? super h.h>, Object> p2 = new /* invalid duplicate definition of identical inner class */;
                        p2.i = (x)object;
                        return p2.i((Object)h.h.a);
                    }

                    @Override
                    public final h.k.d<h.h> g(Object object, h.k.d<?> d2) {
                        h.m.b.j.e(d2, (String)"completion");
                        p<x, h.k.d<? super h.h>, Object> p2 = new /* invalid duplicate definition of identical inner class */;
                        p2.i = (x)object;
                        return p2;
                    }

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    @Override
                    public final Object i(Object object) {
                        h.k.i.a a2 = h.k.i.a.e;
                        int n2 = this.l;
                        if (n2 != 0) {
                            if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            (d.a.l1.a)this.k;
                            (x)this.j;
                            h.i.O1(object);
                            return h.h.a;
                        } else {
                            h.i.O1(object);
                            x x2 = this.i;
                            d.a.l1.i i2 = a.C0((a)this.m).e;
                            a a3 = new a(this);
                            this.j = x2;
                            this.k = i2;
                            this.l = 1;
                            if (i2.b(a3, this) != a2) return h.h.a;
                            return a2;
                        }
                    }
                }, 3, null);
                BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior4 = this.b0;
                if (bottomSheetBehavior4 != null) {
                    BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior5;
                    j j2 = new j(this);
                    if (!bottomSheetBehavior4.J.contains((Object)j2)) {
                        bottomSheetBehavior4.J.add((Object)j2);
                    }
                    if ((bottomSheetBehavior5 = this.c0) != null) {
                        k k2 = new k(this);
                        if (!bottomSheetBehavior5.J.contains((Object)k2)) {
                            bottomSheetBehavior5.J.add((Object)k2);
                        }
                        ((TextView)this.w0(b.a.a.c.input_departure_room)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        ((TextView)this.w0(b.a.a.c.input_destination_room)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        ((FrameLayout)this.w0(b.a.a.c.button_select_as_destination)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        ((FrameLayout)this.w0(b.a.a.c.button_select_as_departure)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        TextInputEditText textInputEditText = (TextInputEditText)this.w0(b.a.a.c.input_room);
                        h.m.b.j.d((Object)textInputEditText, (String)"input_room");
                        textInputEditText.addTextChangedListener(new TextWatcher(this){
                            public final /* synthetic */ a e;
                            {
                                this.e = a2;
                            }

                            public void afterTextChanged(android.text.Editable editable) {
                                String string;
                                b.a.a.d.d d2 = a.C0(this.e);
                                if (editable == null || (string = editable.toString()) == null) {
                                    string = "";
                                }
                                if (d2 != null) {
                                    h.m.b.j.e((Object)string, (String)"matchText");
                                    b.a.a.d.j j2 = (b.a.a.d.j)d2.e.getValue();
                                    if (j2 instanceof j.a) {
                                        j.a a2 = j2;
                                        b.a.a.d.h h2 = a2.a;
                                        if (h2 instanceof h.b) {
                                            d.a.l1.d d3 = d2.d;
                                            h.b b2 = h2;
                                            List list = d2.d(string, a2.c.e);
                                            h.a a3 = b2.a;
                                            h.m.b.j.e((Object)((Object)a3), (String)"pickType");
                                            h.m.b.j.e((Object)list, (String)"filteredRooms");
                                            d3.setValue(j.a.b(a2, (b.a.a.d.h)new /* Unavailable Anonymous Inner Class!! */, null, null, (int)0, null, null, null, null, (int)254));
                                        }
                                    }
                                    return;
                                }
                                throw null;
                            }

                            public void beforeTextChanged(java.lang.CharSequence charSequence, int n2, int n3, int n4) {
                            }

                            public void onTextChanged(java.lang.CharSequence charSequence, int n2, int n3, int n4) {
                            }
                        });
                        ((MaterialButton)this.w0(b.a.a.c.picker_cancel_button)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        ((Toolbar)this.w0(b.a.a.c.toolbar)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        ((ImageView)this.w0(b.a.a.c.up_floor_arrow)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        ((ImageView)this.w0(b.a.a.c.down_floor_arrow)).setOnClickListener(new /* invalid duplicate definition of identical inner class */);
                        return;
                    }
                    h.m.b.j.j((String)"roomPickerBottomSheetBehavior");
                    throw null;
                }
                h.m.b.j.j((String)"roomInfoBottomSheetBehavior");
                throw null;
            }
            h.m.b.j.j((String)"roomPickerAdapter");
            throw null;
        }
        h.m.b.j.j((String)"markerAdapter");
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void f(b.a.a.b.d d2) {
        b.a.a.d.d d3;
        b.a.a.d.j j2;
        block8 : {
            block7 : {
                block6 : {
                    h.m.b.j.e((Object)d2, (String)"marker");
                    if (!(d2 instanceof d.c) && !(d2 instanceof d.e) && !(d2 instanceof d.a)) break block6;
                    d3 = this.D0();
                    if (d3 == null) {
                        throw null;
                    }
                    h.m.b.j.e((Object)d2, (String)"marker");
                    j2 = (b.a.a.d.j)d3.e.getValue();
                    if (!(j2 instanceof j.a)) break block7;
                    break block8;
                }
                this.D0().h();
            }
            return;
        }
        d.a.l1.d d4 = d3.d;
        j.a a2 = j2;
        h.a a3 = new h.a(d2);
        List list = a2.b;
        ArrayList arrayList = new ArrayList(h.i.x(list, 10));
        Iterator iterator = list.iterator();
        do {
            b.a.a.a.a.j.c c2;
            block11 : {
                boolean bl;
                block10 : {
                    block9 : {
                        if (!iterator.hasNext()) {
                            d4.setValue(j.a.b(a2, (b.a.a.d.h)a3, (List)arrayList, null, (int)0, null, null, null, null, (int)252));
                            return;
                        }
                        c2 = (b.a.a.a.a.j.c)iterator.next();
                        if (!h.m.b.j.a((Object)c2.a.a, (Object)d2.a)) break block9;
                        bl = true;
                        break block10;
                    }
                    if (!c2.b) break block11;
                    bl = false;
                }
                boolean bl2 = bl;
                c2 = b.a.a.a.a.j.c.a(c2, null, bl2, false, null, 13);
            }
            arrayList.add((Object)c2);
        } while (true);
    }

    public View w0(int n2) {
        View view;
        if (this.j0 == null) {
            this.j0 = new HashMap();
        }
        if ((view = (View)this.j0.get((Object)n2)) == null) {
            View view2 = this.J;
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(n2);
            this.j0.put((Object)n2, (Object)view);
        }
        return view;
    }

}

