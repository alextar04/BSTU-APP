/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.LinearGradient
 *  android.graphics.RadialGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.SweepGradient
 *  android.util.AttributeSet
 *  android.util.Xml
 *  f.b.k.h
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package f.h.e.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import f.b.k.h;
import f.h.c;
import f.h.e.b.f;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
    public final Shader a;
    public final ColorStateList b;
    public int c;

    public a(Shader shader, ColorStateList colorStateList, int n2) {
        this.a = shader;
        this.b = colorStateList;
        this.c = n2;
    }

    public static a a(Resources resources, int n2, Resources.Theme theme) {
        block24 : {
            AttributeSet attributeSet;
            XmlResourceParser xmlResourceParser;
            block25 : {
                String string;
                block26 : {
                    String string2;
                    block27 : {
                        block30 : {
                            SweepGradient sweepGradient;
                            block29 : {
                                float f2;
                                float f3;
                                int n3;
                                f f4;
                                float f5;
                                block28 : {
                                    boolean bl;
                                    int n4;
                                    float f6;
                                    int n5;
                                    ArrayList arrayList;
                                    float f7;
                                    float f8;
                                    float f9;
                                    int n6;
                                    ArrayList arrayList2;
                                    int n7;
                                    block23 : {
                                        int n8;
                                        xmlResourceParser = resources.getXml(n2);
                                        attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                                        while ((n8 = xmlResourceParser.next()) != 2 && n8 != 1) {
                                        }
                                        if (n8 != 2) break block24;
                                        string = xmlResourceParser.getName();
                                        int n9 = -1;
                                        int n10 = string.hashCode();
                                        if (n10 != 89650992) {
                                            if (n10 == 1191572447 && string.equals((Object)"selector")) {
                                                n9 = 0;
                                            }
                                        } else if (string.equals((Object)"gradient")) {
                                            n9 = 1;
                                        }
                                        if (n9 == 0) break block25;
                                        if (n9 != 1) break block26;
                                        string2 = xmlResourceParser.getName();
                                        if (!string2.equals((Object)"gradient")) break block27;
                                        TypedArray typedArray = h.i.d1(resources, theme, attributeSet, c.GradientColor);
                                        f8 = h.i.l0(typedArray, (XmlPullParser)xmlResourceParser, "startX", c.GradientColor_android_startX, 0.0f);
                                        float f10 = h.i.l0(typedArray, (XmlPullParser)xmlResourceParser, "startY", c.GradientColor_android_startY, 0.0f);
                                        float f11 = h.i.l0(typedArray, (XmlPullParser)xmlResourceParser, "endX", c.GradientColor_android_endX, 0.0f);
                                        f6 = h.i.l0(typedArray, (XmlPullParser)xmlResourceParser, "endY", c.GradientColor_android_endY, 0.0f);
                                        f3 = h.i.l0(typedArray, (XmlPullParser)xmlResourceParser, "centerX", c.GradientColor_android_centerX, 0.0f);
                                        f5 = h.i.l0(typedArray, (XmlPullParser)xmlResourceParser, "centerY", c.GradientColor_android_centerY, 0.0f);
                                        n4 = h.i.m0(typedArray, (XmlPullParser)xmlResourceParser, "type", c.GradientColor_android_type, 0);
                                        n7 = h.i.j0(typedArray, (XmlPullParser)xmlResourceParser, "startColor", c.GradientColor_android_startColor, 0);
                                        bl = h.i.z0((XmlPullParser)xmlResourceParser, "centerColor");
                                        n5 = h.i.j0(typedArray, (XmlPullParser)xmlResourceParser, "centerColor", c.GradientColor_android_centerColor, 0);
                                        n6 = h.i.j0(typedArray, (XmlPullParser)xmlResourceParser, "endColor", c.GradientColor_android_endColor, 0);
                                        n3 = h.i.m0(typedArray, (XmlPullParser)xmlResourceParser, "tileMode", c.GradientColor_android_tileMode, 0);
                                        f2 = h.i.l0(typedArray, (XmlPullParser)xmlResourceParser, "gradientRadius", c.GradientColor_android_gradientRadius, 0.0f);
                                        typedArray.recycle();
                                        int n11 = 1 + xmlResourceParser.getDepth();
                                        arrayList2 = new ArrayList(20);
                                        arrayList = new ArrayList(20);
                                        Resources resources2 = resources;
                                        do {
                                            int n12 = xmlResourceParser.next();
                                            f9 = f11;
                                            if (n12 == 1) break;
                                            int n13 = xmlResourceParser.getDepth();
                                            f7 = f10;
                                            if (n13 >= n11 || n12 != 3) {
                                                if (n12 == 2) {
                                                    if (n13 <= n11) {
                                                        if (xmlResourceParser.getName().equals((Object)"item")) {
                                                            TypedArray typedArray2 = h.i.d1(resources2, theme, attributeSet, c.GradientColorItem);
                                                            boolean bl2 = typedArray2.hasValue(c.GradientColorItem_android_color);
                                                            boolean bl3 = typedArray2.hasValue(c.GradientColorItem_android_offset);
                                                            if (bl2 && bl3) {
                                                                int n14 = typedArray2.getColor(c.GradientColorItem_android_color, 0);
                                                                float f12 = typedArray2.getFloat(c.GradientColorItem_android_offset, 0.0f);
                                                                typedArray2.recycle();
                                                                arrayList.add((Object)n14);
                                                                arrayList2.add((Object)Float.valueOf((float)f12));
                                                            } else {
                                                                StringBuilder stringBuilder = new StringBuilder();
                                                                stringBuilder.append(xmlResourceParser.getPositionDescription());
                                                                stringBuilder.append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                                                                throw new XmlPullParserException(stringBuilder.toString());
                                                            }
                                                        }
                                                    } else {
                                                        resources2 = resources;
                                                    }
                                                }
                                                f11 = f9;
                                                f10 = f7;
                                                continue;
                                            }
                                            break block23;
                                            break;
                                        } while (true);
                                        f7 = f10;
                                    }
                                    if ((f4 = arrayList.size() > 0 ? new f((List<Integer>)arrayList, (List<Float>)arrayList2) : null) == null) {
                                        if (bl) {
                                            f4 = new f(n7, n5, n6);
                                        } else {
                                            f4(n7, n6);
                                        }
                                    }
                                    if (n4 == 1) break block28;
                                    if (n4 != 2) {
                                        int[] arrn = f4.a;
                                        float[] arrf = f4.b;
                                        Shader.TileMode tileMode = n3 != 1 ? (n3 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR) : Shader.TileMode.REPEAT;
                                        Shader.TileMode tileMode2 = tileMode;
                                        sweepGradient = new LinearGradient(f8, f7, f9, f6, arrn, arrf, tileMode2);
                                    } else {
                                        sweepGradient = new SweepGradient(f3, f5, f4.a, f4.b);
                                    }
                                    break block29;
                                }
                                if (f2 <= 0.0f) break block30;
                                int[] arrn = f4.a;
                                float[] arrf = f4.b;
                                Shader.TileMode tileMode = n3 != 1 ? (n3 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR) : Shader.TileMode.REPEAT;
                                Shader.TileMode tileMode3 = tileMode;
                                sweepGradient = new RadialGradient(f3, f5, f2, arrn, arrf, tileMode3);
                            }
                            return new a((Shader)sweepGradient, null, 0);
                        }
                        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(xmlResourceParser.getPositionDescription());
                    stringBuilder.append(": invalid gradient color tag ");
                    stringBuilder.append(string2);
                    throw new XmlPullParserException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(xmlResourceParser.getPositionDescription());
                stringBuilder.append(": unsupported complex color tag ");
                stringBuilder.append(string);
                throw new XmlPullParserException(stringBuilder.toString());
            }
            ColorStateList colorStateList = h.i.M(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme);
            return new a(null, colorStateList, colorStateList.getDefaultColor());
        }
        throw new XmlPullParserException("No start tag found");
    }

    public boolean b() {
        return this.a != null;
    }

    public boolean c() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean d(int[] arrn) {
        ColorStateList colorStateList;
        int n2;
        if (this.c() && (n2 = (colorStateList = this.b).getColorForState(arrn, colorStateList.getDefaultColor())) != this.c) {
            this.c = n2;
            return true;
        }
        return false;
    }
}

