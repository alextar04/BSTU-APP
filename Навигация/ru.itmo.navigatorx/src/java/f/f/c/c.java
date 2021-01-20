/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.Xml
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package f.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.c.d;
import f.f.c.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    public SparseArray<a> a = new SparseArray();
    public SparseArray<d> b = new SparseArray();

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public c(Context var1_1, ConstraintLayout var2_2, int var3_3) {
        super();
        var4_4 = var1_1.getResources().getXml(var3_3);
        try {
            var7_5 = var4_4.getEventType();
            var8_6 = null;
            ** GOTO lbl59
        }
        catch (IOException var6_11) {
            var6_11.printStackTrace();
            return;
        }
        catch (XmlPullParserException var5_12) {
            var5_12.printStackTrace();
            return;
        }
        {
            var10_7 = var4_4.getName();
            var11_8 = -1;
            switch (var10_7.hashCode()) {
                case 1901439077: {
                    if (!var10_7.equals((Object)"Variant")) break;
                    var11_8 = 3;
                    break;
                }
                case 1657696882: {
                    if (!var10_7.equals((Object)"layoutDescription")) break;
                    var11_8 = 0;
                    break;
                }
                case 1382829617: {
                    if (!var10_7.equals((Object)"StateSet")) break;
                    var11_8 = 1;
                    break;
                }
                case 80204913: {
                    if (!var10_7.equals((Object)"State")) break;
                    var11_8 = 2;
                    break;
                }
                case -1349929691: {
                    if (!var10_7.equals((Object)"ConstraintSet")) break;
                    var11_8 = 4;
                    break;
                }
            }
            if (var11_8 == 0 || var11_8 == 1) ** GOTO lbl57
            if (var11_8 != 2) {
                if (var11_8 != 3) {
                    if (var11_8 != 4) {
                        var14_10 = new StringBuilder();
                        var14_10.append("unknown tag ");
                        var14_10.append(var10_7);
                        Log.v((String)"ConstraintLayoutStates", (String)var14_10.toString());
                    } else {
                        this.a(var1_1, (XmlPullParser)var4_4);
                    }
                } else {
                    var12_9 = new b(var1_1, (XmlPullParser)var4_4);
                    if (var8_6 != null) {
                        var8_6.b.add((Object)var12_9);
                    }
                }
            } else {
                var8_6 = new a(var1_1, (XmlPullParser)var4_4);
                this.a.put(var8_6.a, (Object)var8_6);
            }
            ** GOTO lbl57
            {
                var4_4.getName();
lbl57: // 6 sources:
                do {
                    var7_5 = var4_4.next();
lbl59: // 2 sources:
                    if (var7_5 == 1) return;
                    if (var7_5 == 0) continue block11;
                    if (var7_5 == 2) continue block10;
                } while (true);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final void a(Context var1_1, XmlPullParser var2_2) {
        block41 : {
            block40 : {
                block42 : {
                    var3_3 = new d();
                    var4_4 = var2_2.getAttributeCount();
                    var5_5 = 0;
                    while (var5_5 < var4_4) {
                        if (!"id".equals((Object)var2_2.getAttributeName(var5_5))) ** GOTO lbl21
                        var6_6 = var2_2.getAttributeValue(var5_5);
                        if (var6_6.contains((CharSequence)"/")) {
                            var35_7 = var6_6.substring(1 + var6_6.indexOf(47));
                            var7_8 = var1_1.getResources().getIdentifier(var35_7, "id", var1_1.getPackageName());
                        } else {
                            var7_8 = -1;
                        }
                        if (var7_8 == -1) {
                            if (var6_6.length() > 1) {
                                var7_8 = Integer.parseInt((String)var6_6.substring(1));
                            } else {
                                Log.e((String)"ConstraintLayoutStates", (String)"error in parsing id");
                            }
                        }
                        var10_9 = var2_2.getEventType();
                        var11_10 = null;
                        ** break block39
lbl21: // 1 sources:
                        ++var5_5;
                    }
                    return;
lbl-1000: // 1 sources:
                    {
                        
lbl25: // 2 sources:
                        while (var10_9 != 1) {
                            block43 : {
                                if (var10_9 == 0) ** GOTO lbl72
                                var13_12 = 3;
                                if (var10_9 != 2) {
                                    if (var10_9 != var13_12) break block40;
                                    var32_11 = var2_2.getName();
                                    if (!"ConstraintSet".equals((Object)var32_11)) {
                                        if (var32_11.equalsIgnoreCase("Constraint")) {
                                            var3_3.c.put((Object)var11_10.a, (Object)var11_10);
                                            var11_10 = null;
                                            ** GOTO lbl142
                                        } else {
                                            ** GOTO lbl37
                                        }
                                    }
                                    break block41;
lbl37: // 2 sources:
                                    break block40;
                                }
                                var14_13 = var2_2.getName();
                                switch (var14_13.hashCode()) {
                                    case 1803088381: {
                                        if (!var14_13.equals((Object)"Constraint")) break;
                                        var13_12 = 0;
                                        break block43;
                                    }
                                    case 1791837707: {
                                        if (!var14_13.equals((Object)"CustomAttribute")) break;
                                        var13_12 = 7;
                                        break block43;
                                    }
                                    case 1331510167: {
                                        if (!var14_13.equals((Object)"Barrier")) break;
                                        var13_12 = 2;
                                        break block43;
                                    }
                                    case -71750448: {
                                        if (!var14_13.equals((Object)"Guideline")) break;
                                        var13_12 = 1;
                                        break block43;
                                    }
                                    case -1238332596: {
                                        if (!var14_13.equals((Object)"Transform")) break;
                                        var13_12 = 4;
                                        break block43;
                                    }
                                    case -1269513683: {
                                        if (!var14_13.equals((Object)"PropertySet")) break;
                                        break block43;
                                    }
                                    case -1984451626: {
                                        if (!var14_13.equals((Object)"Motion")) break;
                                        var13_12 = 6;
                                        break block43;
                                    }
                                    case -2025855158: {
                                        var15_14 = var14_13.equals((Object)"Layout");
                                        if (!var15_14) break;
                                        var13_12 = 5;
                                        break block43;
                                    }
lbl72: // 1 sources:
                                    var2_2.getName();
                                    break block40;
                                }
                                var13_12 = -1;
                            }
                            switch (var13_12) {
                                default: {
                                    break block40;
                                }
                                case 7: {
                                    if (var11_10 != null) {
                                        f.f.c.a.a(var1_1, var2_2, var11_10.f);
                                        break block40;
                                    }
                                    var29_16 = new StringBuilder();
                                    var29_16.append("XML parser error must be within a Constraint ");
                                    var29_16.append(var2_2.getLineNumber());
                                    throw new RuntimeException(var29_16.toString());
                                }
                                case 6: {
                                    if (var11_10 == null) {
                                        var26_17 = new StringBuilder();
                                        var26_17.append("XML parser error must be within a Constraint ");
                                        var26_17.append(var2_2.getLineNumber());
                                        throw new RuntimeException(var26_17.toString());
                                    }
                                    var11_10.c.a(var1_1, Xml.asAttributeSet((XmlPullParser)var2_2));
                                    break block40;
                                }
                                case 5: {
                                    if (var11_10 == null) {
                                        var23_18 = new StringBuilder();
                                        var23_18.append("XML parser error must be within a Constraint ");
                                        var23_18.append(var2_2.getLineNumber());
                                        throw new RuntimeException(var23_18.toString());
                                    }
                                    var11_10.d.a(var1_1, Xml.asAttributeSet((XmlPullParser)var2_2));
                                    break block40;
                                }
                                case 4: {
                                    if (var11_10 == null) {
                                        var20_19 = new StringBuilder();
                                        var20_19.append("XML parser error must be within a Constraint ");
                                        var20_19.append(var2_2.getLineNumber());
                                        throw new RuntimeException(var20_19.toString());
                                    }
                                    var11_10.e.a(var1_1, Xml.asAttributeSet((XmlPullParser)var2_2));
                                    break block40;
                                }
                                case 3: {
                                    if (var11_10 == null) {
                                        var17_20 = new StringBuilder();
                                        var17_20.append("XML parser error must be within a Constraint ");
                                        var17_20.append(var2_2.getLineNumber());
                                        throw new RuntimeException(var17_20.toString());
                                    }
                                    var11_10.b.a(var1_1, Xml.asAttributeSet((XmlPullParser)var2_2));
                                    break block40;
                                }
                                case 2: {
                                    var16_15 = var3_3.d(var1_1, Xml.asAttributeSet((XmlPullParser)var2_2));
                                    var16_15.d.d0 = 1;
                                    ** break;
                                }
                                case 1: {
                                    var16_15 = var3_3.d(var1_1, Xml.asAttributeSet((XmlPullParser)var2_2));
                                    var16_15.d.a = true;
                                    var16_15.d.b = true;
                                    ** break;
                                }
                                case 0: {
                                    var16_15 = var3_3.d(var1_1, Xml.asAttributeSet((XmlPullParser)var2_2));
                                    ** break;
lbl131: // 3 sources:
                                    break;
                                }
                            }
                            break block42;
                        }
                        break block41;
                    }
                    catch (IOException var9_21) {
                        var9_21.printStackTrace();
                        break block41;
                    }
                    catch (XmlPullParserException var8_22) {
                        var8_22.printStackTrace();
                        break block41;
                    }
                }
                var11_10 = var16_15;
            }
            var10_9 = var2_2.next();
            ** GOTO lbl25
        }
        this.b.put(var7_8, (Object)var3_3);
    }

    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList();
        public int c = -1;
        public d d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray typedArray = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), j.State);
            int n2 = typedArray.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                d d2;
                int n3 = typedArray.getIndex(i2);
                if (n3 == j.State_android_id) {
                    this.a = typedArray.getResourceId(n3, this.a);
                    continue;
                }
                if (n3 != j.State_constraints) continue;
                this.c = typedArray.getResourceId(n3, this.c);
                String string = context.getResources().getResourceTypeName(this.c);
                context.getResources().getResourceName(this.c);
                if (!"layout".equals((Object)string)) continue;
                this.d = d2 = new d();
                d2.b(context, this.c);
            }
            typedArray.recycle();
        }
    }

    public static class b {
        public float a = Float.NaN;
        public float b = Float.NaN;
        public float c = Float.NaN;
        public float d = Float.NaN;
        public int e = -1;
        public d f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray typedArray = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), j.Variant);
            int n2 = typedArray.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = typedArray.getIndex(i2);
                if (n3 == j.Variant_constraints) {
                    d d2;
                    this.e = typedArray.getResourceId(n3, this.e);
                    String string = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if (!"layout".equals((Object)string)) continue;
                    this.f = d2 = new d();
                    d2.b(context, this.e);
                    continue;
                }
                if (n3 == j.Variant_region_heightLessThan) {
                    this.d = typedArray.getDimension(n3, this.d);
                    continue;
                }
                if (n3 == j.Variant_region_heightMoreThan) {
                    this.b = typedArray.getDimension(n3, this.b);
                    continue;
                }
                if (n3 == j.Variant_region_widthLessThan) {
                    this.c = typedArray.getDimension(n3, this.c);
                    continue;
                }
                if (n3 == j.Variant_region_widthMoreThan) {
                    this.a = typedArray.getDimension(n3, this.a);
                    continue;
                }
                Log.v((String)"ConstraintLayoutStates", (String)"Unknown tag");
            }
            typedArray.recycle();
        }
    }

}

