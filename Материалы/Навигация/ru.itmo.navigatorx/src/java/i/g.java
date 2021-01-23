/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Comparator
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package i;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class g {
    public static final Comparator<String> b = new Comparator<String>(){

        /*
         * Enabled aggressive block sorting
         */
        public int compare(Object object, Object object2) {
            int n2;
            String string = (String)object;
            String string2 = (String)object2;
            int n3 = Math.min((int)string.length(), (int)string2.length());
            for (int i2 = 4; i2 < n3; ++i2) {
                char c2;
                char c3 = string.charAt(i2);
                if (c3 == (c2 = string2.charAt(i2))) continue;
                if (c3 >= c2) return 1;
                return -1;
            }
            int n4 = string.length();
            if (n4 == (n2 = string2.length())) {
                return 0;
            }
            if (n4 < n2) return -1;
            return 1;
        }
    };
    public static final Map<String, g> c = new LinkedHashMap();
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    public static final g h;
    public static final g i;
    public static final g j;
    public static final g k;
    public static final g l;
    public static final g m;
    public static final g n;
    public static final g o;
    public static final g p;
    public static final g q;
    public static final g r;
    public static final g s;
    public static final g t;
    public static final g u;
    public final String a;

    public static {
        g.b("SSL_RSA_WITH_NULL_MD5");
        g.b("SSL_RSA_WITH_NULL_SHA");
        g.b("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        g.b("SSL_RSA_WITH_RC4_128_MD5");
        g.b("SSL_RSA_WITH_RC4_128_SHA");
        g.b("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        g.b("SSL_RSA_WITH_DES_CBC_SHA");
        d = g.b("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        g.b("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        g.b("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        g.b("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        g.b("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        g.b("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        g.b("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        g.b("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        g.b("SSL_DH_anon_WITH_RC4_128_MD5");
        g.b("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        g.b("SSL_DH_anon_WITH_DES_CBC_SHA");
        g.b("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        g.b("TLS_KRB5_WITH_DES_CBC_SHA");
        g.b("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        g.b("TLS_KRB5_WITH_RC4_128_SHA");
        g.b("TLS_KRB5_WITH_DES_CBC_MD5");
        g.b("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        g.b("TLS_KRB5_WITH_RC4_128_MD5");
        g.b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        g.b("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        g.b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        g.b("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        e = g.b("TLS_RSA_WITH_AES_128_CBC_SHA");
        g.b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        g.b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        g.b("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        f = g.b("TLS_RSA_WITH_AES_256_CBC_SHA");
        g.b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        g.b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        g.b("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        g.b("TLS_RSA_WITH_NULL_SHA256");
        g.b("TLS_RSA_WITH_AES_128_CBC_SHA256");
        g.b("TLS_RSA_WITH_AES_256_CBC_SHA256");
        g.b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        g.b("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        g.b("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        g.b("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        g.b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        g.b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        g.b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        g.b("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        g.b("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        g.b("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        g.b("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        g.b("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        g.b("TLS_PSK_WITH_RC4_128_SHA");
        g.b("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        g.b("TLS_PSK_WITH_AES_128_CBC_SHA");
        g.b("TLS_PSK_WITH_AES_256_CBC_SHA");
        g.b("TLS_RSA_WITH_SEED_CBC_SHA");
        g = g.b("TLS_RSA_WITH_AES_128_GCM_SHA256");
        h = g.b("TLS_RSA_WITH_AES_256_GCM_SHA384");
        g.b("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        g.b("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        g.b("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        g.b("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        g.b("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        g.b("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        g.b("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        g.b("TLS_FALLBACK_SCSV");
        g.b("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        g.b("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        g.b("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        g.b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        g.b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        g.b("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        g.b("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        g.b("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        g.b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        g.b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        g.b("TLS_ECDH_RSA_WITH_NULL_SHA");
        g.b("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        g.b("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        g.b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        g.b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        g.b("TLS_ECDHE_RSA_WITH_NULL_SHA");
        g.b("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        g.b("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        i = g.b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        j = g.b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        g.b("TLS_ECDH_anon_WITH_NULL_SHA");
        g.b("TLS_ECDH_anon_WITH_RC4_128_SHA");
        g.b("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        g.b("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        g.b("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        g.b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        g.b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        g.b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        g.b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        g.b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        g.b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        g.b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        g.b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        k = g.b("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        l = g.b("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        g.b("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        g.b("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        m = g.b("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        n = g.b("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        g.b("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        g.b("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        g.b("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        g.b("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        o = g.b("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        p = g.b("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        g.b("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        g.b("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        q = g.b("TLS_AES_128_GCM_SHA256");
        r = g.b("TLS_AES_256_GCM_SHA384");
        s = g.b("TLS_CHACHA20_POLY1305_SHA256");
        t = g.b("TLS_AES_128_CCM_SHA256");
        u = g.b("TLS_AES_256_CCM_8_SHA256");
    }

    public g(String string) {
        if (string != null) {
            this.a = string;
            return;
        }
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static g a(String string) {
        Class<g> class_ = g.class;
        synchronized (g.class) {
            g g2 = (g)c.get((Object)string);
            if (g2 == null) {
                g2 = (g)c.get((Object)g.c(string));
                if (g2 == null) {
                    g2 = new g(string);
                }
                c.put((Object)string, (Object)g2);
            }
            // ** MonitorExit[var4_1] (shouldn't be in output)
            return g2;
        }
    }

    public static g b(String string) {
        g g2 = new g(string);
        c.put((Object)string, (Object)g2);
        return g2;
    }

    public static String c(String string) {
        if (string.startsWith("TLS_")) {
            StringBuilder stringBuilder = c.b.a.a.a.c("SSL_");
            stringBuilder.append(string.substring(4));
            return stringBuilder.toString();
        }
        if (string.startsWith("SSL_")) {
            StringBuilder stringBuilder = c.b.a.a.a.c("TLS_");
            stringBuilder.append(string.substring(4));
            string = stringBuilder.toString();
        }
        return string;
    }

    public String toString() {
        return this.a;
    }

}

