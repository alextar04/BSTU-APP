/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.util.Xml
 *  java.lang.Boolean
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  org.xmlpull.v1.XmlPullParser
 */
package f.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.util.Xml;
import f.f.c.j;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class a {
    public String a;
    public a b;
    public int c;
    public float d;
    public String e;
    public boolean f;
    public int g;

    public a(a a2, Object object) {
        this.a = a2.a;
        this.b = a2.b;
        this.b(object);
    }

    public a(String string, a a2, Object object) {
        this.a = string;
        this.b = a2;
        this.b(object);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void a(Context var0, XmlPullParser var1_1, HashMap<String, a> var2_2) {
        var3_3 = a.k;
        var4_4 = var0.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)var1_1), j.CustomAttribute);
        var5_5 = var4_4.getIndexCount();
        var6_6 = null;
        var7_7 = null;
        var8_8 = null;
        for (var9_9 = 0; var9_9 < var5_5; ++var9_9) {
            block16 : {
                block15 : {
                    block14 : {
                        block13 : {
                            block12 : {
                                block11 : {
                                    var11_10 = var4_4.getIndex(var9_9);
                                    if (var11_10 == j.CustomAttribute_attributeName) {
                                        var6_6 = var4_4.getString(var11_10);
                                        if (var6_6 == null || var6_6.length() <= 0) continue;
                                        var17_19 = new StringBuilder();
                                        var17_19.append(Character.toUpperCase((char)var6_6.charAt(0)));
                                        var17_19.append(var6_6.substring(1));
                                        var6_6 = var17_19.toString();
                                        continue;
                                    }
                                    if (var11_10 == j.CustomAttribute_customBoolean) {
                                        var7_7 = var4_4.getBoolean(var11_10, false);
                                        var8_8 = a.j;
                                        continue;
                                    }
                                    if (var11_10 != j.CustomAttribute_customColorValue) break block11;
                                    var12_11 = a.g;
                                    break block12;
                                }
                                if (var11_10 != j.CustomAttribute_customColorDrawableValue) break block13;
                                var12_11 = a.h;
                            }
                            var15_17 = var4_4.getColor(var11_10, 0);
                            ** GOTO lbl49
                        }
                        if (var11_10 != j.CustomAttribute_customPixelDimension) break block14;
                        var16_18 = TypedValue.applyDimension((int)1, (float)var4_4.getDimension(var11_10, 0.0f), (DisplayMetrics)var0.getResources().getDisplayMetrics());
                        break block15;
                    }
                    if (var11_10 != j.CustomAttribute_customDimension) break block16;
                    var16_18 = var4_4.getDimension(var11_10, 0.0f);
                }
                var7_7 = Float.valueOf((float)var16_18);
                var8_8 = var3_3;
                continue;
            }
            if (var11_10 == j.CustomAttribute_customFloatValue) {
                var12_11 = a.f;
                var13_13 = Float.valueOf((float)var4_4.getFloat(var11_10, Float.NaN));
            } else if (var11_10 == j.CustomAttribute_customIntegerValue) {
                var12_11 = a.e;
                var15_17 = var4_4.getInteger(var11_10, -1);
lbl49: // 2 sources:
                var13_14 = var15_17;
            } else {
                if (var11_10 != j.CustomAttribute_customStringValue) continue;
                var12_11 = a.i;
                var13_15 = var4_4.getString(var11_10);
            }
            var14_16 = var13_12;
            var8_8 = var12_11;
            var7_7 = var14_16;
        }
        if (var6_6 != null && var7_7 != null) {
            var2_2.put((Object)var6_6, (Object)new a(var6_6, var8_8, (Object)var7_7));
        }
        var4_4.recycle();
    }

    public void b(Object object) {
        switch (this.b.ordinal()) {
            default: {
                return;
            }
            case 5: {
                this.f = (Boolean)object;
                return;
            }
            case 4: {
                this.e = (String)object;
                return;
            }
            case 1: 
            case 6: {
                this.d = ((Float)object).floatValue();
                return;
            }
            case 0: {
                this.c = (Integer)object;
                return;
            }
            case 2: 
            case 3: 
        }
        this.g = (Integer)object;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* synthetic */ a[] l;

        public static {
            a a2;
            e = new a();
            f = new a();
            g = new a();
            h = new a();
            i = new a();
            j = new a();
            k = a2 = new a();
            a[] arra = new a[]{e, f, g, h, i, j, a2};
            l = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])l.clone();
        }
    }

}

