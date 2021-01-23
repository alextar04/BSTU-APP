/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.util.Log
 *  f.h.e.b.c
 *  f.h.e.b.e
 *  f.h.f.e
 *  f.h.f.f
 *  f.h.f.g
 *  f.h.f.h
 *  f.h.f.i
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 */
package f.h.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import f.h.e.b.c;
import f.h.f.e;
import f.h.f.f;
import f.h.f.g;
import f.h.f.h;
import f.h.f.i;
import f.h.f.j;
import f.h.i.a;
import f.h.i.b;
import java.lang.reflect.Method;

@SuppressLint(value={"NewApi"})
public class d {
    public static final j a;
    public static final f.e.f<String, Typeface> b;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static {
        block4 : {
            block6 : {
                block5 : {
                    block3 : {
                        var0 = Build.VERSION.SDK_INT;
                        if (var0 < 29) break block3;
                        var1_1 = new i();
                        break block4;
                    }
                    if (var0 < 28) break block5;
                    var1_1 = new h();
                    break block4;
                }
                if (var0 < 26) break block6;
                var1_1 = new g();
                break block4;
            }
            if (var0 < 24) ** GOTO lbl-1000
            if (f.d == null) {
                Log.w((String)"TypefaceCompatApi24Impl", (String)"Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (var2_2 = f.d != null) {
                var1_1 = new f();
            } else lbl-1000: // 2 sources:
            {
                var1_1 = new e();
            }
        }
        d.a = var1_1;
        d.b = new f.e.f<K, V>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int n2) {
        if (context != null) {
            return Typeface.create((Typeface)typeface, (int)n2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, f.h.e.b.b b2, Resources resources, int n2, int n3, f.h.e.b.g g2, Handler handler, boolean bl) {
        Typeface typeface;
        block11 : {
            block7 : {
                f.h.e.b.e e2;
                boolean bl2;
                block9 : {
                    block10 : {
                        block8 : {
                            if (!(b2 instanceof f.h.e.b.e)) break block7;
                            e2 = (f.h.e.b.e)b2;
                            if (!bl) break block8;
                            int n4 = e2.c;
                            bl2 = false;
                            if (n4 != 0) break block9;
                            break block10;
                        }
                        bl2 = false;
                        if (g2 != null) break block9;
                    }
                    bl2 = true;
                }
                int n5 = bl ? e2.b : -1;
                int n6 = n5;
                typeface = b.c(context, e2.a, g2, handler, bl2, n6, n3);
                break block11;
            }
            typeface = a.a(context, (c)b2, resources, n3);
            if (g2 != null) {
                if (typeface != null) {
                    g2.b(typeface, handler);
                } else {
                    g2.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            b.b(d.d(resources, n2, n3), typeface);
        }
        return typeface;
    }

    public static Typeface c(Context context, Resources resources, int n2, String string, int n3) {
        Typeface typeface = a.d(context, resources, n2, string, n3);
        if (typeface != null) {
            String string2 = d.d(resources, n2, n3);
            b.b(string2, typeface);
        }
        return typeface;
    }

    public static String d(Resources resources, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(n2));
        stringBuilder.append("-");
        stringBuilder.append(n2);
        stringBuilder.append("-");
        stringBuilder.append(n3);
        return stringBuilder.toString();
    }
}

