/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.util.TypedValue
 *  android.util.Xml
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.constraintlayout.widget.Barrier
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$a
 *  f.f.b.i.a
 *  f.f.c.e$a
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.Set
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package f.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.c.e;
import f.f.c.j;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d {
    public static final int[] d;
    public static SparseIntArray e;
    public HashMap<String, f.f.c.a> a = new HashMap();
    public boolean b = true;
    public HashMap<Integer, a> c = new HashMap();

    public static {
        SparseIntArray sparseIntArray;
        d = new int[]{0, 4, 8};
        e = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(j.Constraint_layout_constraintLeft_toLeftOf, 25);
        e.append(j.Constraint_layout_constraintLeft_toRightOf, 26);
        e.append(j.Constraint_layout_constraintRight_toLeftOf, 29);
        e.append(j.Constraint_layout_constraintRight_toRightOf, 30);
        e.append(j.Constraint_layout_constraintTop_toTopOf, 36);
        e.append(j.Constraint_layout_constraintTop_toBottomOf, 35);
        e.append(j.Constraint_layout_constraintBottom_toTopOf, 4);
        e.append(j.Constraint_layout_constraintBottom_toBottomOf, 3);
        e.append(j.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        e.append(j.Constraint_layout_editor_absoluteX, 6);
        e.append(j.Constraint_layout_editor_absoluteY, 7);
        e.append(j.Constraint_layout_constraintGuide_begin, 17);
        e.append(j.Constraint_layout_constraintGuide_end, 18);
        e.append(j.Constraint_layout_constraintGuide_percent, 19);
        e.append(j.Constraint_android_orientation, 27);
        e.append(j.Constraint_layout_constraintStart_toEndOf, 32);
        e.append(j.Constraint_layout_constraintStart_toStartOf, 33);
        e.append(j.Constraint_layout_constraintEnd_toStartOf, 10);
        e.append(j.Constraint_layout_constraintEnd_toEndOf, 9);
        e.append(j.Constraint_layout_goneMarginLeft, 13);
        e.append(j.Constraint_layout_goneMarginTop, 16);
        e.append(j.Constraint_layout_goneMarginRight, 14);
        e.append(j.Constraint_layout_goneMarginBottom, 11);
        e.append(j.Constraint_layout_goneMarginStart, 15);
        e.append(j.Constraint_layout_goneMarginEnd, 12);
        e.append(j.Constraint_layout_constraintVertical_weight, 40);
        e.append(j.Constraint_layout_constraintHorizontal_weight, 39);
        e.append(j.Constraint_layout_constraintHorizontal_chainStyle, 41);
        e.append(j.Constraint_layout_constraintVertical_chainStyle, 42);
        e.append(j.Constraint_layout_constraintHorizontal_bias, 20);
        e.append(j.Constraint_layout_constraintVertical_bias, 37);
        e.append(j.Constraint_layout_constraintDimensionRatio, 5);
        e.append(j.Constraint_layout_constraintLeft_creator, 82);
        e.append(j.Constraint_layout_constraintTop_creator, 82);
        e.append(j.Constraint_layout_constraintRight_creator, 82);
        e.append(j.Constraint_layout_constraintBottom_creator, 82);
        e.append(j.Constraint_layout_constraintBaseline_creator, 82);
        e.append(j.Constraint_android_layout_marginLeft, 24);
        e.append(j.Constraint_android_layout_marginRight, 28);
        e.append(j.Constraint_android_layout_marginStart, 31);
        e.append(j.Constraint_android_layout_marginEnd, 8);
        e.append(j.Constraint_android_layout_marginTop, 34);
        e.append(j.Constraint_android_layout_marginBottom, 2);
        e.append(j.Constraint_android_layout_width, 23);
        e.append(j.Constraint_android_layout_height, 21);
        e.append(j.Constraint_android_visibility, 22);
        e.append(j.Constraint_android_alpha, 43);
        e.append(j.Constraint_android_elevation, 44);
        e.append(j.Constraint_android_rotationX, 45);
        e.append(j.Constraint_android_rotationY, 46);
        e.append(j.Constraint_android_rotation, 60);
        e.append(j.Constraint_android_scaleX, 47);
        e.append(j.Constraint_android_scaleY, 48);
        e.append(j.Constraint_android_transformPivotX, 49);
        e.append(j.Constraint_android_transformPivotY, 50);
        e.append(j.Constraint_android_translationX, 51);
        e.append(j.Constraint_android_translationY, 52);
        e.append(j.Constraint_android_translationZ, 53);
        e.append(j.Constraint_layout_constraintWidth_default, 54);
        e.append(j.Constraint_layout_constraintHeight_default, 55);
        e.append(j.Constraint_layout_constraintWidth_max, 56);
        e.append(j.Constraint_layout_constraintHeight_max, 57);
        e.append(j.Constraint_layout_constraintWidth_min, 58);
        e.append(j.Constraint_layout_constraintHeight_min, 59);
        e.append(j.Constraint_layout_constraintCircle, 61);
        e.append(j.Constraint_layout_constraintCircleRadius, 62);
        e.append(j.Constraint_layout_constraintCircleAngle, 63);
        e.append(j.Constraint_animate_relativeTo, 64);
        e.append(j.Constraint_transitionEasing, 65);
        e.append(j.Constraint_drawPath, 66);
        e.append(j.Constraint_transitionPathRotate, 67);
        e.append(j.Constraint_motionStagger, 79);
        e.append(j.Constraint_android_id, 38);
        e.append(j.Constraint_motionProgress, 68);
        e.append(j.Constraint_layout_constraintWidth_percent, 69);
        e.append(j.Constraint_layout_constraintHeight_percent, 70);
        e.append(j.Constraint_chainUseRtl, 71);
        e.append(j.Constraint_barrierDirection, 72);
        e.append(j.Constraint_barrierMargin, 73);
        e.append(j.Constraint_constraint_referenced_ids, 74);
        e.append(j.Constraint_barrierAllowsGoneWidgets, 75);
        e.append(j.Constraint_pathMotionArc, 76);
        e.append(j.Constraint_layout_constraintTag, 77);
        e.append(j.Constraint_visibilityMode, 78);
        e.append(j.Constraint_layout_constrainedWidth, 80);
        e.append(j.Constraint_layout_constrainedHeight, 81);
    }

    public static int a(TypedArray typedArray, int n2, int n3) {
        int n4 = typedArray.getResourceId(n2, n3);
        if (n4 == -1) {
            n4 = typedArray.getInt(n2, -1);
        }
        return n4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void b(Context var1_1, int var2_2) {
        var3_3 = this;
        var4_4 = (ConstraintLayout)LayoutInflater.from((Context)var1_1).inflate(var2_2, null);
        var5_5 = var4_4.getChildCount();
        var3_3.c.clear();
        var6_6 = 0;
        while (var6_6 < var5_5) {
            var7_7 = var4_4.getChildAt(var6_6);
            var8_8 = (ConstraintLayout.a)var7_7.getLayoutParams();
            var9_9 = var7_7.getId();
            if (var3_3.b) {
                if (var9_9 == -1) throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!var3_3.c.containsKey((Object)var9_9)) {
                var3_3.c.put((Object)var9_9, (Object)new a());
            }
            var10_10 = (a)var3_3.c.get((Object)var9_9);
            var11_11 = var3_3.a;
            var12_12 = new HashMap();
            var13_13 = var7_7.getClass();
            for (String var21_21 : var11_11.keySet()) {
                block17 : {
                    block16 : {
                        block15 : {
                            block18 : {
                                var22_22 = (f.f.c.a)var11_11.get((Object)var21_21);
                                if (!var21_21.equals((Object)"BackgroundColor")) break block18;
                                var26_32 = new f.f.c.a(var22_22, ((ColorDrawable)var7_7.getBackground()).getColor());
                                ** GOTO lbl31
                            }
                            var28_33 = new StringBuilder();
                            var28_33.append("getMap");
                            var28_33.append(var21_21);
                            var31_34 = var28_33.toString();
                            try {
                                var26_32 = new f.f.c.a(var22_22, var13_13.getMethod(var31_34, new Class[0]).invoke((Object)var7_7, new Object[0]));
lbl31: // 2 sources:
                                var12_12.put((Object)var21_21, (Object)var26_32);
                                continue;
                            }
                            catch (InvocationTargetException var25_30) {
                                break block15;
                            }
                            catch (IllegalAccessException var24_27) {
                                break block16;
                            }
                            catch (NoSuchMethodException var23_24) {
                                break block17;
                            }
                            catch (InvocationTargetException var25_31) {
                                // empty catch block
                            }
                        }
                        var25_29.printStackTrace();
                        continue;
                        catch (IllegalAccessException var24_28) {
                            // empty catch block
                        }
                    }
                    var24_26.printStackTrace();
                    continue;
                    catch (NoSuchMethodException var23_25) {
                        // empty catch block
                    }
                }
                var23_23.printStackTrace();
            }
            var10_10.f = var12_12;
            var10_10.b(var9_9, var8_8);
            var10_10.b.b = var7_7.getVisibility();
            var10_10.b.d = var7_7.getAlpha();
            var10_10.e.b = var7_7.getRotation();
            var10_10.e.c = var7_7.getRotationX();
            var10_10.e.d = var7_7.getRotationY();
            var10_10.e.e = var7_7.getScaleX();
            var10_10.e.f = var7_7.getScaleY();
            var15_15 = var7_7.getPivotX();
            var16_16 = var7_7.getPivotY();
            if ((double)var15_15 != 0.0 || (double)var16_16 != 0.0) {
                var17_17 = var10_10.e;
                var17_17.g = var15_15;
                var17_17.h = var16_16;
            }
            var10_10.e.i = var7_7.getTranslationX();
            var10_10.e.j = var7_7.getTranslationY();
            var10_10.e.k = var7_7.getTranslationZ();
            var18_18 = var10_10.e;
            if (var18_18.l) {
                var18_18.m = var7_7.getElevation();
            }
            if (var7_7 instanceof Barrier) {
                var19_19 = (Barrier)var7_7;
                var20_20 = var10_10.d;
                var20_20.j0 = var19_19.n.i0;
                var20_20.e0 = var19_19.getReferencedIds();
                var10_10.d.b0 = var19_19.getType();
                var10_10.d.c0 = var19_19.getMargin();
            }
            ++var6_6;
            var3_3 = this;
        }
    }

    /*
     * Exception decompiling
     */
    public final int[] c(View var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl34 : ILOAD : trying to set 1 previously set to 0
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

    public final a d(Context context, AttributeSet attributeSet) {
        a a2 = new a();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.Constraint);
        int n2 = typedArray.getIndexCount();
        block84 : for (int i2 = 0; i2 < n2; ++i2) {
            StringBuilder stringBuilder;
            String string;
            int n3 = typedArray.getIndex(i2);
            if (n3 != j.Constraint_android_id && j.Constraint_android_layout_marginStart != n3 && j.Constraint_android_layout_marginEnd != n3) {
                a2.c.a = true;
                a2.d.b = true;
                a2.b.a = true;
                a2.e.a = true;
            }
            switch (e.get(n3)) {
                default: {
                    stringBuilder = new StringBuilder();
                    string = "Unknown attribute 0x";
                    break;
                }
                case 82: {
                    stringBuilder = new StringBuilder();
                    string = "unused attribute 0x";
                    break;
                }
                case 81: {
                    b b2 = a2.d;
                    b2.i0 = typedArray.getBoolean(n3, b2.i0);
                    continue block84;
                }
                case 80: {
                    b b3 = a2.d;
                    b3.h0 = typedArray.getBoolean(n3, b3.h0);
                    continue block84;
                }
                case 79: {
                    c c2 = a2.c;
                    c2.f = typedArray.getFloat(n3, c2.f);
                    continue block84;
                }
                case 78: {
                    d d2 = a2.b;
                    d2.c = typedArray.getInt(n3, d2.c);
                    continue block84;
                }
                case 77: {
                    a2.d.g0 = typedArray.getString(n3);
                    continue block84;
                }
                case 76: {
                    c c3 = a2.c;
                    c3.d = typedArray.getInt(n3, c3.d);
                    continue block84;
                }
                case 75: {
                    b b4 = a2.d;
                    b4.j0 = typedArray.getBoolean(n3, b4.j0);
                    continue block84;
                }
                case 74: {
                    a2.d.f0 = typedArray.getString(n3);
                    continue block84;
                }
                case 73: {
                    b b5 = a2.d;
                    b5.c0 = typedArray.getDimensionPixelSize(n3, b5.c0);
                    continue block84;
                }
                case 72: {
                    b b6 = a2.d;
                    b6.b0 = typedArray.getInt(n3, b6.b0);
                    continue block84;
                }
                case 71: {
                    Log.e((String)"ConstraintSet", (String)"CURRENTLY UNSUPPORTED");
                    continue block84;
                }
                case 70: {
                    a2.d.a0 = typedArray.getFloat(n3, 1.0f);
                    continue block84;
                }
                case 69: {
                    a2.d.Z = typedArray.getFloat(n3, 1.0f);
                    continue block84;
                }
                case 68: {
                    d d3 = a2.b;
                    d3.e = typedArray.getFloat(n3, d3.e);
                    continue block84;
                }
                case 67: {
                    c c4 = a2.c;
                    c4.g = typedArray.getFloat(n3, c4.g);
                    continue block84;
                }
                case 66: {
                    a2.c.e = typedArray.getInt(n3, 0);
                    continue block84;
                }
                case 65: {
                    c c5;
                    String string2;
                    if (typedArray.peekValue((int)n3).type == 3) {
                        c5 = a2.c;
                        string2 = typedArray.getString(n3);
                    } else {
                        c5 = a2.c;
                        string2 = f.f.a.a.a.a[typedArray.getInteger(n3, 0)];
                    }
                    c5.c = string2;
                    continue block84;
                }
                case 64: {
                    c c6 = a2.c;
                    int n4 = typedArray.getResourceId(n3, c6.b);
                    if (n4 == -1) {
                        n4 = typedArray.getInt(n3, -1);
                    }
                    c6.b = n4;
                    continue block84;
                }
                case 63: {
                    b b7 = a2.d;
                    b7.z = typedArray.getFloat(n3, b7.z);
                    continue block84;
                }
                case 62: {
                    b b8 = a2.d;
                    b8.y = typedArray.getDimensionPixelSize(n3, b8.y);
                    continue block84;
                }
                case 61: {
                    b b9 = a2.d;
                    int n5 = typedArray.getResourceId(n3, b9.x);
                    if (n5 == -1) {
                        n5 = typedArray.getInt(n3, -1);
                    }
                    b9.x = n5;
                    continue block84;
                }
                case 60: {
                    e e2 = a2.e;
                    e2.b = typedArray.getFloat(n3, e2.b);
                    continue block84;
                }
                case 59: {
                    b b10 = a2.d;
                    b10.Y = typedArray.getDimensionPixelSize(n3, b10.Y);
                    continue block84;
                }
                case 58: {
                    b b11 = a2.d;
                    b11.X = typedArray.getDimensionPixelSize(n3, b11.X);
                    continue block84;
                }
                case 57: {
                    b b12 = a2.d;
                    b12.W = typedArray.getDimensionPixelSize(n3, b12.W);
                    continue block84;
                }
                case 56: {
                    b b13 = a2.d;
                    b13.V = typedArray.getDimensionPixelSize(n3, b13.V);
                    continue block84;
                }
                case 55: {
                    b b14 = a2.d;
                    b14.U = typedArray.getInt(n3, b14.U);
                    continue block84;
                }
                case 54: {
                    b b15 = a2.d;
                    b15.T = typedArray.getInt(n3, b15.T);
                    continue block84;
                }
                case 53: {
                    e e3 = a2.e;
                    e3.k = typedArray.getDimension(n3, e3.k);
                    continue block84;
                }
                case 52: {
                    e e4 = a2.e;
                    e4.j = typedArray.getDimension(n3, e4.j);
                    continue block84;
                }
                case 51: {
                    e e5 = a2.e;
                    e5.i = typedArray.getDimension(n3, e5.i);
                    continue block84;
                }
                case 50: {
                    e e6 = a2.e;
                    e6.h = typedArray.getDimension(n3, e6.h);
                    continue block84;
                }
                case 49: {
                    e e7 = a2.e;
                    e7.g = typedArray.getDimension(n3, e7.g);
                    continue block84;
                }
                case 48: {
                    e e8 = a2.e;
                    e8.f = typedArray.getFloat(n3, e8.f);
                    continue block84;
                }
                case 47: {
                    e e9 = a2.e;
                    e9.e = typedArray.getFloat(n3, e9.e);
                    continue block84;
                }
                case 46: {
                    e e10 = a2.e;
                    e10.d = typedArray.getFloat(n3, e10.d);
                    continue block84;
                }
                case 45: {
                    e e11 = a2.e;
                    e11.c = typedArray.getFloat(n3, e11.c);
                    continue block84;
                }
                case 44: {
                    e e12 = a2.e;
                    e12.l = true;
                    e12.m = typedArray.getDimension(n3, e12.m);
                    continue block84;
                }
                case 43: {
                    d d4 = a2.b;
                    d4.d = typedArray.getFloat(n3, d4.d);
                    continue block84;
                }
                case 42: {
                    b b16 = a2.d;
                    b16.S = typedArray.getInt(n3, b16.S);
                    continue block84;
                }
                case 41: {
                    b b17 = a2.d;
                    b17.R = typedArray.getInt(n3, b17.R);
                    continue block84;
                }
                case 40: {
                    b b18 = a2.d;
                    b18.P = typedArray.getFloat(n3, b18.P);
                    continue block84;
                }
                case 39: {
                    b b19 = a2.d;
                    b19.Q = typedArray.getFloat(n3, b19.Q);
                    continue block84;
                }
                case 38: {
                    a2.a = typedArray.getResourceId(n3, a2.a);
                    continue block84;
                }
                case 37: {
                    b b20 = a2.d;
                    b20.v = typedArray.getFloat(n3, b20.v);
                    continue block84;
                }
                case 36: {
                    b b21 = a2.d;
                    int n6 = typedArray.getResourceId(n3, b21.l);
                    if (n6 == -1) {
                        n6 = typedArray.getInt(n3, -1);
                    }
                    b21.l = n6;
                    continue block84;
                }
                case 35: {
                    b b22 = a2.d;
                    int n7 = typedArray.getResourceId(n3, b22.m);
                    if (n7 == -1) {
                        n7 = typedArray.getInt(n3, -1);
                    }
                    b22.m = n7;
                    continue block84;
                }
                case 34: {
                    b b23 = a2.d;
                    b23.F = typedArray.getDimensionPixelSize(n3, b23.F);
                    continue block84;
                }
                case 33: {
                    b b24 = a2.d;
                    int n8 = typedArray.getResourceId(n3, b24.r);
                    if (n8 == -1) {
                        n8 = typedArray.getInt(n3, -1);
                    }
                    b24.r = n8;
                    continue block84;
                }
                case 32: {
                    b b25 = a2.d;
                    int n9 = typedArray.getResourceId(n3, b25.q);
                    if (n9 == -1) {
                        n9 = typedArray.getInt(n3, -1);
                    }
                    b25.q = n9;
                    continue block84;
                }
                case 31: {
                    b b26 = a2.d;
                    b26.I = typedArray.getDimensionPixelSize(n3, b26.I);
                    continue block84;
                }
                case 30: {
                    b b27 = a2.d;
                    int n10 = typedArray.getResourceId(n3, b27.k);
                    if (n10 == -1) {
                        n10 = typedArray.getInt(n3, -1);
                    }
                    b27.k = n10;
                    continue block84;
                }
                case 29: {
                    b b28 = a2.d;
                    int n11 = typedArray.getResourceId(n3, b28.j);
                    if (n11 == -1) {
                        n11 = typedArray.getInt(n3, -1);
                    }
                    b28.j = n11;
                    continue block84;
                }
                case 28: {
                    b b29 = a2.d;
                    b29.E = typedArray.getDimensionPixelSize(n3, b29.E);
                    continue block84;
                }
                case 27: {
                    b b30 = a2.d;
                    b30.C = typedArray.getInt(n3, b30.C);
                    continue block84;
                }
                case 26: {
                    b b31 = a2.d;
                    int n12 = typedArray.getResourceId(n3, b31.i);
                    if (n12 == -1) {
                        n12 = typedArray.getInt(n3, -1);
                    }
                    b31.i = n12;
                    continue block84;
                }
                case 25: {
                    b b32 = a2.d;
                    int n13 = typedArray.getResourceId(n3, b32.h);
                    if (n13 == -1) {
                        n13 = typedArray.getInt(n3, -1);
                    }
                    b32.h = n13;
                    continue block84;
                }
                case 24: {
                    b b33 = a2.d;
                    b33.D = typedArray.getDimensionPixelSize(n3, b33.D);
                    continue block84;
                }
                case 23: {
                    b b34 = a2.d;
                    b34.c = typedArray.getLayoutDimension(n3, b34.c);
                    continue block84;
                }
                case 22: {
                    d d5 = a2.b;
                    d5.b = typedArray.getInt(n3, d5.b);
                    d d6 = a2.b;
                    d6.b = d[d6.b];
                    continue block84;
                }
                case 21: {
                    b b35 = a2.d;
                    b35.d = typedArray.getLayoutDimension(n3, b35.d);
                    continue block84;
                }
                case 20: {
                    b b36 = a2.d;
                    b36.u = typedArray.getFloat(n3, b36.u);
                    continue block84;
                }
                case 19: {
                    b b37 = a2.d;
                    b37.g = typedArray.getFloat(n3, b37.g);
                    continue block84;
                }
                case 18: {
                    b b38 = a2.d;
                    b38.f = typedArray.getDimensionPixelOffset(n3, b38.f);
                    continue block84;
                }
                case 17: {
                    b b39 = a2.d;
                    b39.e = typedArray.getDimensionPixelOffset(n3, b39.e);
                    continue block84;
                }
                case 16: {
                    b b40 = a2.d;
                    b40.K = typedArray.getDimensionPixelSize(n3, b40.K);
                    continue block84;
                }
                case 15: {
                    b b41 = a2.d;
                    b41.O = typedArray.getDimensionPixelSize(n3, b41.O);
                    continue block84;
                }
                case 14: {
                    b b42 = a2.d;
                    b42.L = typedArray.getDimensionPixelSize(n3, b42.L);
                    continue block84;
                }
                case 13: {
                    b b43 = a2.d;
                    b43.J = typedArray.getDimensionPixelSize(n3, b43.J);
                    continue block84;
                }
                case 12: {
                    b b44 = a2.d;
                    b44.N = typedArray.getDimensionPixelSize(n3, b44.N);
                    continue block84;
                }
                case 11: {
                    b b45 = a2.d;
                    b45.M = typedArray.getDimensionPixelSize(n3, b45.M);
                    continue block84;
                }
                case 10: {
                    b b46 = a2.d;
                    int n14 = typedArray.getResourceId(n3, b46.s);
                    if (n14 == -1) {
                        n14 = typedArray.getInt(n3, -1);
                    }
                    b46.s = n14;
                    continue block84;
                }
                case 9: {
                    b b47 = a2.d;
                    int n15 = typedArray.getResourceId(n3, b47.t);
                    if (n15 == -1) {
                        n15 = typedArray.getInt(n3, -1);
                    }
                    b47.t = n15;
                    continue block84;
                }
                case 8: {
                    b b48 = a2.d;
                    b48.H = typedArray.getDimensionPixelSize(n3, b48.H);
                    continue block84;
                }
                case 7: {
                    b b49 = a2.d;
                    b49.B = typedArray.getDimensionPixelOffset(n3, b49.B);
                    continue block84;
                }
                case 6: {
                    b b50 = a2.d;
                    b50.A = typedArray.getDimensionPixelOffset(n3, b50.A);
                    continue block84;
                }
                case 5: {
                    a2.d.w = typedArray.getString(n3);
                    continue block84;
                }
                case 4: {
                    b b51 = a2.d;
                    int n16 = typedArray.getResourceId(n3, b51.n);
                    if (n16 == -1) {
                        n16 = typedArray.getInt(n3, -1);
                    }
                    b51.n = n16;
                    continue block84;
                }
                case 3: {
                    b b52 = a2.d;
                    int n17 = typedArray.getResourceId(n3, b52.o);
                    if (n17 == -1) {
                        n17 = typedArray.getInt(n3, -1);
                    }
                    b52.o = n17;
                    continue block84;
                }
                case 2: {
                    b b53 = a2.d;
                    b53.G = typedArray.getDimensionPixelSize(n3, b53.G);
                    continue block84;
                }
                case 1: {
                    b b54 = a2.d;
                    int n18 = typedArray.getResourceId(n3, b54.p);
                    if (n18 == -1) {
                        n18 = typedArray.getInt(n3, -1);
                    }
                    b54.p = n18;
                    continue block84;
                }
            }
            stringBuilder.append(string);
            stringBuilder.append(Integer.toHexString((int)n3));
            stringBuilder.append("   ");
            stringBuilder.append(e.get(n3));
            Log.w((String)"ConstraintSet", (String)stringBuilder.toString());
        }
        typedArray.recycle();
        return a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void e(Context var1_1, int var2_2) {
        var3_3 = var1_1.getResources().getXml(var2_2);
        try {
            var6_4 = var3_3.getEventType();
            ** GOTO lbl20
        }
        catch (IOException var5_7) {
            var5_7.printStackTrace();
            return;
        }
        catch (XmlPullParserException var4_8) {
            var4_8.printStackTrace();
            return;
        }
        {
            var8_5 = var3_3.getName();
            var9_6 = this.d(var1_1, Xml.asAttributeSet((XmlPullParser)var3_3));
            if (var8_5.equalsIgnoreCase("Guideline")) {
                var9_6.d.a = true;
            }
            this.c.put((Object)var9_6.a, (Object)var9_6);
            ** GOTO lbl18
            {
                var3_3.getName();
lbl18: // 2 sources:
                do {
                    var6_4 = var3_3.next();
lbl20: // 2 sources:
                    if (var6_4 == 1) return;
                    if (var6_4 == 0) continue block4;
                    if (var6_4 == 2) continue block3;
                } while (true);
            }
        }
    }

    public static class a {
        public int a;
        public final d b = new d();
        public final c c = new c();
        public final b d = new b();
        public final e e = new e();
        public HashMap<String, f.f.c.a> f = new HashMap();

        public void a(ConstraintLayout.a a2) {
            b b2 = this.d;
            a2.d = b2.h;
            a2.e = b2.i;
            a2.f = b2.j;
            a2.g = b2.k;
            a2.h = b2.l;
            a2.i = b2.m;
            a2.j = b2.n;
            a2.k = b2.o;
            a2.l = b2.p;
            a2.p = b2.q;
            a2.q = b2.r;
            a2.r = b2.s;
            a2.s = b2.t;
            a2.leftMargin = b2.D;
            a2.rightMargin = b2.E;
            a2.topMargin = b2.F;
            a2.bottomMargin = b2.G;
            a2.x = b2.O;
            a2.y = b2.N;
            a2.u = b2.K;
            a2.w = b2.M;
            a2.z = b2.u;
            a2.A = b2.v;
            a2.m = b2.x;
            a2.n = b2.y;
            a2.o = b2.z;
            a2.B = b2.w;
            a2.P = b2.A;
            a2.Q = b2.B;
            a2.E = b2.P;
            a2.D = b2.Q;
            a2.G = b2.S;
            a2.F = b2.R;
            a2.S = b2.h0;
            a2.T = b2.i0;
            a2.H = b2.T;
            a2.I = b2.U;
            a2.L = b2.V;
            a2.M = b2.W;
            a2.J = b2.X;
            a2.K = b2.Y;
            a2.N = b2.Z;
            a2.O = b2.a0;
            a2.R = b2.C;
            a2.c = b2.g;
            a2.a = b2.e;
            a2.b = b2.f;
            a2.width = b2.c;
            a2.height = b2.d;
            String string = b2.g0;
            if (string != null) {
                a2.U = string;
            }
            a2.setMarginStart(this.d.I);
            a2.setMarginEnd(this.d.H);
            a2.a();
        }

        public final void b(int n2, ConstraintLayout.a a2) {
            this.a = n2;
            b b2 = this.d;
            b2.h = a2.d;
            b2.i = a2.e;
            b2.j = a2.f;
            b2.k = a2.g;
            b2.l = a2.h;
            b2.m = a2.i;
            b2.n = a2.j;
            b2.o = a2.k;
            b2.p = a2.l;
            b2.q = a2.p;
            b2.r = a2.q;
            b2.s = a2.r;
            b2.t = a2.s;
            b2.u = a2.z;
            b2.v = a2.A;
            b2.w = a2.B;
            b2.x = a2.m;
            b2.y = a2.n;
            b2.z = a2.o;
            b2.A = a2.P;
            b2.B = a2.Q;
            b2.C = a2.R;
            b2.g = a2.c;
            b2.e = a2.a;
            b2.f = a2.b;
            b2.c = a2.width;
            b2.d = a2.height;
            b2.D = a2.leftMargin;
            b2.E = a2.rightMargin;
            b2.F = a2.topMargin;
            b2.G = a2.bottomMargin;
            b2.P = a2.E;
            b2.Q = a2.D;
            b2.S = a2.G;
            b2.R = a2.F;
            b2.h0 = a2.S;
            b2.i0 = a2.T;
            b2.T = a2.H;
            b2.U = a2.I;
            b2.V = a2.L;
            b2.W = a2.M;
            b2.X = a2.J;
            b2.Y = a2.K;
            b2.Z = a2.N;
            b2.a0 = a2.O;
            b2.g0 = a2.U;
            b2.K = a2.u;
            b2.M = a2.w;
            b2.J = a2.t;
            b2.L = a2.v;
            b2.O = a2.x;
            b2.N = a2.y;
            b2.H = a2.getMarginEnd();
            this.d.I = a2.getMarginStart();
        }

        public final void c(int n2, e.a a2) {
            this.b(n2, (ConstraintLayout.a)a2);
            this.b.d = a2.n0;
            e e2 = this.e;
            e2.b = a2.q0;
            e2.c = a2.r0;
            e2.d = a2.s0;
            e2.e = a2.t0;
            e2.f = a2.u0;
            e2.g = a2.v0;
            e2.h = a2.w0;
            e2.i = a2.x0;
            e2.j = a2.y0;
            e2.k = a2.z0;
            e2.m = a2.p0;
            e2.l = a2.o0;
        }

        public Object clone() {
            a a2 = new a();
            b b2 = a2.d;
            b b3 = this.d;
            if (b2 != null) {
                b2.a = b3.a;
                b2.c = b3.c;
                b2.b = b3.b;
                b2.d = b3.d;
                b2.e = b3.e;
                b2.f = b3.f;
                b2.g = b3.g;
                b2.h = b3.h;
                b2.i = b3.i;
                b2.j = b3.j;
                b2.k = b3.k;
                b2.l = b3.l;
                b2.m = b3.m;
                b2.n = b3.n;
                b2.o = b3.o;
                b2.p = b3.p;
                b2.q = b3.q;
                b2.r = b3.r;
                b2.s = b3.s;
                b2.t = b3.t;
                b2.u = b3.u;
                b2.v = b3.v;
                b2.w = b3.w;
                b2.x = b3.x;
                b2.y = b3.y;
                b2.z = b3.z;
                b2.A = b3.A;
                b2.B = b3.B;
                b2.C = b3.C;
                b2.D = b3.D;
                b2.E = b3.E;
                b2.F = b3.F;
                b2.G = b3.G;
                b2.H = b3.H;
                b2.I = b3.I;
                b2.J = b3.J;
                b2.K = b3.K;
                b2.L = b3.L;
                b2.M = b3.M;
                b2.N = b3.N;
                b2.O = b3.O;
                b2.P = b3.P;
                b2.Q = b3.Q;
                b2.R = b3.R;
                b2.S = b3.S;
                b2.T = b3.T;
                b2.U = b3.U;
                b2.V = b3.V;
                b2.W = b3.W;
                b2.X = b3.X;
                b2.Y = b3.Y;
                b2.Z = b3.Z;
                b2.a0 = b3.a0;
                b2.b0 = b3.b0;
                b2.c0 = b3.c0;
                b2.d0 = b3.d0;
                b2.g0 = b3.g0;
                int[] arrn = b3.e0;
                b2.e0 = arrn != null ? Arrays.copyOf((int[])arrn, (int)arrn.length) : null;
                b2.f0 = b3.f0;
                b2.h0 = b3.h0;
                b2.i0 = b3.i0;
                b2.j0 = b3.j0;
                c c2 = a2.c;
                c c3 = this.c;
                if (c2 != null) {
                    c2.a = c3.a;
                    c2.b = c3.b;
                    c2.c = c3.c;
                    c2.d = c3.d;
                    c2.e = c3.e;
                    c2.g = c3.g;
                    c2.f = c3.f;
                    d d2 = a2.b;
                    d d3 = this.b;
                    if (d2 != null) {
                        d2.a = d3.a;
                        d2.b = d3.b;
                        d2.d = d3.d;
                        d2.e = d3.e;
                        d2.c = d3.c;
                        e e2 = a2.e;
                        e e3 = this.e;
                        if (e2 != null) {
                            e2.a = e3.a;
                            e2.b = e3.b;
                            e2.c = e3.c;
                            e2.d = e3.d;
                            e2.e = e3.e;
                            e2.f = e3.f;
                            e2.g = e3.g;
                            e2.h = e3.h;
                            e2.i = e3.i;
                            e2.j = e3.j;
                            e2.k = e3.k;
                            e2.l = e3.l;
                            e2.m = e3.m;
                            a2.a = this.a;
                            return a2;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
    }

    public static class b {
        public static SparseIntArray k0;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;
        public boolean a = false;
        public float a0 = 1.0f;
        public boolean b = false;
        public int b0 = -1;
        public int c;
        public int c0 = 0;
        public int d;
        public int d0 = -1;
        public int e = -1;
        public int[] e0;
        public int f = -1;
        public String f0;
        public float g = -1.0f;
        public String g0;
        public int h = -1;
        public boolean h0 = false;
        public int i = -1;
        public boolean i0 = false;
        public int j = -1;
        public boolean j0 = true;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = 0.0f;

        public static {
            SparseIntArray sparseIntArray;
            k0 = sparseIntArray = new SparseIntArray();
            sparseIntArray.append(j.Layout_layout_constraintLeft_toLeftOf, 24);
            k0.append(j.Layout_layout_constraintLeft_toRightOf, 25);
            k0.append(j.Layout_layout_constraintRight_toLeftOf, 28);
            k0.append(j.Layout_layout_constraintRight_toRightOf, 29);
            k0.append(j.Layout_layout_constraintTop_toTopOf, 35);
            k0.append(j.Layout_layout_constraintTop_toBottomOf, 34);
            k0.append(j.Layout_layout_constraintBottom_toTopOf, 4);
            k0.append(j.Layout_layout_constraintBottom_toBottomOf, 3);
            k0.append(j.Layout_layout_constraintBaseline_toBaselineOf, 1);
            k0.append(j.Layout_layout_editor_absoluteX, 6);
            k0.append(j.Layout_layout_editor_absoluteY, 7);
            k0.append(j.Layout_layout_constraintGuide_begin, 17);
            k0.append(j.Layout_layout_constraintGuide_end, 18);
            k0.append(j.Layout_layout_constraintGuide_percent, 19);
            k0.append(j.Layout_android_orientation, 26);
            k0.append(j.Layout_layout_constraintStart_toEndOf, 31);
            k0.append(j.Layout_layout_constraintStart_toStartOf, 32);
            k0.append(j.Layout_layout_constraintEnd_toStartOf, 10);
            k0.append(j.Layout_layout_constraintEnd_toEndOf, 9);
            k0.append(j.Layout_layout_goneMarginLeft, 13);
            k0.append(j.Layout_layout_goneMarginTop, 16);
            k0.append(j.Layout_layout_goneMarginRight, 14);
            k0.append(j.Layout_layout_goneMarginBottom, 11);
            k0.append(j.Layout_layout_goneMarginStart, 15);
            k0.append(j.Layout_layout_goneMarginEnd, 12);
            k0.append(j.Layout_layout_constraintVertical_weight, 38);
            k0.append(j.Layout_layout_constraintHorizontal_weight, 37);
            k0.append(j.Layout_layout_constraintHorizontal_chainStyle, 39);
            k0.append(j.Layout_layout_constraintVertical_chainStyle, 40);
            k0.append(j.Layout_layout_constraintHorizontal_bias, 20);
            k0.append(j.Layout_layout_constraintVertical_bias, 36);
            k0.append(j.Layout_layout_constraintDimensionRatio, 5);
            k0.append(j.Layout_layout_constraintLeft_creator, 76);
            k0.append(j.Layout_layout_constraintTop_creator, 76);
            k0.append(j.Layout_layout_constraintRight_creator, 76);
            k0.append(j.Layout_layout_constraintBottom_creator, 76);
            k0.append(j.Layout_layout_constraintBaseline_creator, 76);
            k0.append(j.Layout_android_layout_marginLeft, 23);
            k0.append(j.Layout_android_layout_marginRight, 27);
            k0.append(j.Layout_android_layout_marginStart, 30);
            k0.append(j.Layout_android_layout_marginEnd, 8);
            k0.append(j.Layout_android_layout_marginTop, 33);
            k0.append(j.Layout_android_layout_marginBottom, 2);
            k0.append(j.Layout_android_layout_width, 22);
            k0.append(j.Layout_android_layout_height, 21);
            k0.append(j.Layout_layout_constraintCircle, 61);
            k0.append(j.Layout_layout_constraintCircleRadius, 62);
            k0.append(j.Layout_layout_constraintCircleAngle, 63);
            k0.append(j.Layout_layout_constraintWidth_percent, 69);
            k0.append(j.Layout_layout_constraintHeight_percent, 70);
            k0.append(j.Layout_chainUseRtl, 71);
            k0.append(j.Layout_barrierDirection, 72);
            k0.append(j.Layout_barrierMargin, 73);
            k0.append(j.Layout_constraint_referenced_ids, 74);
            k0.append(j.Layout_barrierAllowsGoneWidgets, 75);
        }

        /*
         * Exception decompiling
         */
        public void a(Context var1_1, AttributeSet var2_2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [51[CASE], 1[CASE], 43[CASE]], but top level block is 55[SWITCH]
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
    }

    public static class c {
        public static SparseIntArray h;
        public boolean a = false;
        public int b = -1;
        public String c = null;
        public int d = -1;
        public int e = 0;
        public float f = Float.NaN;
        public float g = Float.NaN;

        public static {
            SparseIntArray sparseIntArray;
            h = sparseIntArray = new SparseIntArray();
            sparseIntArray.append(j.Motion_motionPathRotate, 1);
            h.append(j.Motion_pathMotionArc, 2);
            h.append(j.Motion_transitionEasing, 3);
            h.append(j.Motion_drawPath, 4);
            h.append(j.Motion_animate_relativeTo, 5);
            h.append(j.Motion_motionStagger, 6);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.Motion);
            this.a = true;
            int n2 = typedArray.getIndexCount();
            block8 : for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = typedArray.getIndex(i2);
                switch (h.get(n3)) {
                    default: {
                        continue block8;
                    }
                    case 6: {
                        this.f = typedArray.getFloat(n3, this.f);
                        continue block8;
                    }
                    case 5: {
                        this.b = d.a(typedArray, n3, this.b);
                        continue block8;
                    }
                    case 4: {
                        this.e = typedArray.getInt(n3, 0);
                        continue block8;
                    }
                    case 3: {
                        String string = typedArray.peekValue((int)n3).type == 3 ? typedArray.getString(n3) : f.f.a.a.a.a[typedArray.getInteger(n3, 0)];
                        this.c = string;
                        continue block8;
                    }
                    case 2: {
                        this.d = typedArray.getInt(n3, this.d);
                        continue block8;
                    }
                    case 1: {
                        this.g = typedArray.getFloat(n3, this.g);
                    }
                }
            }
            typedArray.recycle();
        }
    }

    public static class d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.PropertySet);
            this.a = true;
            int n2 = typedArray.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = typedArray.getIndex(i2);
                if (n3 == j.PropertySet_android_alpha) {
                    this.d = typedArray.getFloat(n3, this.d);
                    continue;
                }
                if (n3 == j.PropertySet_android_visibility) {
                    int n4;
                    this.b = n4 = typedArray.getInt(n3, this.b);
                    this.b = d.d[n4];
                    continue;
                }
                if (n3 == j.PropertySet_visibilityMode) {
                    this.c = typedArray.getInt(n3, this.c);
                    continue;
                }
                if (n3 != j.PropertySet_motionProgress) continue;
                this.e = typedArray.getFloat(n3, this.e);
            }
            typedArray.recycle();
        }
    }

    public static class e {
        public static SparseIntArray n;
        public boolean a = false;
        public float b = 0.0f;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public float i = 0.0f;
        public float j = 0.0f;
        public float k = 0.0f;
        public boolean l = false;
        public float m = 0.0f;

        public static {
            SparseIntArray sparseIntArray;
            n = sparseIntArray = new SparseIntArray();
            sparseIntArray.append(j.Transform_android_rotation, 1);
            n.append(j.Transform_android_rotationX, 2);
            n.append(j.Transform_android_rotationY, 3);
            n.append(j.Transform_android_scaleX, 4);
            n.append(j.Transform_android_scaleY, 5);
            n.append(j.Transform_android_transformPivotX, 6);
            n.append(j.Transform_android_transformPivotY, 7);
            n.append(j.Transform_android_translationX, 8);
            n.append(j.Transform_android_translationY, 9);
            n.append(j.Transform_android_translationZ, 10);
            n.append(j.Transform_android_elevation, 11);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.Transform);
            this.a = true;
            int n2 = typedArray.getIndexCount();
            block13 : for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = typedArray.getIndex(i2);
                switch (n.get(n3)) {
                    default: {
                        continue block13;
                    }
                    case 11: {
                        this.l = true;
                        this.m = typedArray.getDimension(n3, this.m);
                        continue block13;
                    }
                    case 10: {
                        this.k = typedArray.getDimension(n3, this.k);
                        continue block13;
                    }
                    case 9: {
                        this.j = typedArray.getDimension(n3, this.j);
                        continue block13;
                    }
                    case 8: {
                        this.i = typedArray.getDimension(n3, this.i);
                        continue block13;
                    }
                    case 7: {
                        this.h = typedArray.getDimension(n3, this.h);
                        continue block13;
                    }
                    case 6: {
                        this.g = typedArray.getDimension(n3, this.g);
                        continue block13;
                    }
                    case 5: {
                        this.f = typedArray.getFloat(n3, this.f);
                        continue block13;
                    }
                    case 4: {
                        this.e = typedArray.getFloat(n3, this.e);
                        continue block13;
                    }
                    case 3: {
                        this.d = typedArray.getFloat(n3, this.d);
                        continue block13;
                    }
                    case 2: {
                        this.c = typedArray.getFloat(n3, this.c);
                        continue block13;
                    }
                    case 1: {
                        this.b = typedArray.getFloat(n3, this.b);
                    }
                }
            }
            typedArray.recycle();
        }
    }

}

