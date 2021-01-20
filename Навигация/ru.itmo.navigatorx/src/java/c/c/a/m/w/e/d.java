/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  c.c.a.m.o
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 */
package c.c.a.m.w.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.w;
import c.c.a.m.w.e.a;
import c.c.a.m.w.e.c;
import java.util.List;

public class d
implements q<Uri, Drawable> {
    public final Context a;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override
    public boolean b(Object object, o o2) {
        return ((Uri)object).getScheme().equals((Object)"android.resource");
    }

    public w<Drawable> c(Uri uri, int n2, int n3, o o2) {
        PackageManager.NameNotFoundException nameNotFoundException2;
        block14 : {
            block17 : {
                int n4;
                block16 : {
                    List list;
                    block15 : {
                        block13 : {
                            String string = uri.getAuthority();
                            if (!string.equals((Object)this.a.getPackageName())) {
                                try {
                                    o2 = this.a.createPackageContext(string, 0);
                                    break block13;
                                }
                                catch (PackageManager.NameNotFoundException nameNotFoundException2) {
                                    if (!string.contains((CharSequence)this.a.getPackageName())) break block14;
                                }
                            }
                            o2 = this.a;
                        }
                        list = uri.getPathSegments();
                        if (list.size() != 2) break block15;
                        List list2 = uri.getPathSegments();
                        String string = uri.getAuthority();
                        String string2 = (String)list2.get(0);
                        String string3 = (String)list2.get(1);
                        n4 = o2.getResources().getIdentifier(string3, string2, string);
                        if (n4 == 0) {
                            n4 = Resources.getSystem().getIdentifier(string3, string2, "android");
                        }
                        if (n4 == 0) {
                            throw new IllegalArgumentException(c.b.a.a.a.g("Failed to find resource id for: ", uri));
                        }
                        break block16;
                    }
                    if (list.size() != 1) break block17;
                    List list3 = uri.getPathSegments();
                    try {
                        n4 = Integer.parseInt((String)((String)list3.get(0)));
                    }
                    catch (NumberFormatException numberFormatException) {
                        throw new IllegalArgumentException(c.b.a.a.a.g("Unrecognized Uri format: ", uri), (Throwable)numberFormatException);
                    }
                }
                Drawable drawable = a.a(this.a, (Context)o2, n4, null);
                c c2 = null;
                if (drawable != null) {
                    c2 = new c(drawable);
                }
                return c2;
            }
            throw new IllegalArgumentException(c.b.a.a.a.g("Unrecognized Uri format: ", uri));
        }
        throw new IllegalArgumentException(c.b.a.a.a.g("Failed to obtain context or unrecognized Uri format for: ", uri), (Throwable)nameNotFoundException2);
    }
}

