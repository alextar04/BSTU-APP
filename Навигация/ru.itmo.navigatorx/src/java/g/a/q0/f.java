/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.objectstore.OsAppCredentials
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.q0;

import io.realm.internal.objectstore.OsAppCredentials;

public class f {
    public OsAppCredentials a;

    public f(OsAppCredentials osAppCredentials, a a2) {
        this.a = osAppCredentials;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* synthetic */ a[] o;
        public final String e;

        public static {
            a a2;
            f = new a("anon-user");
            g = new a("api-key");
            h = new a("oauth2-apple");
            i = new a("custom-function");
            j = new a("local-userpass");
            k = new a("oauth2-facebook");
            l = new a("oauth2-google");
            m = new a("jwt");
            n = a2 = new a("");
            a[] arra = new a[]{f, g, h, i, j, k, l, m, a2};
            o = arra;
        }

        public a(String string2) {
            this.e = string2;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])o.clone();
        }
    }

}

