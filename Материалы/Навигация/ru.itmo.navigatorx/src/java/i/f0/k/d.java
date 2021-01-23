/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateParsingException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLException
 *  javax.net.ssl.SSLSession
 */
package i.f0.k;

import i.f0.c;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class d
implements HostnameVerifier {
    public static final d a = new d();

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> list = d.b(x509Certificate, 7);
        List<String> list2 = d.b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List<String> b(X509Certificate x509Certificate, int n2) {
        ArrayList arrayList = new ArrayList();
        try {
            Collection collection = x509Certificate.getSubjectAlternativeNames();
            if (collection == null) {
                return Collections.emptyList();
            }
            Iterator iterator = collection.iterator();
            do {
                Integer n3;
                String string;
                if (!iterator.hasNext()) {
                    return arrayList;
                }
                List list = (List)iterator.next();
                if (list == null || list.size() < 2 || (n3 = (Integer)list.get(0)) == null || n3 != n2 || (string = (String)list.get(1)) == null) continue;
                arrayList.add((Object)string);
            } while (true);
        }
        catch (CertificateParsingException certificateParsingException) {
            return Collections.emptyList();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c(String string, X509Certificate x509Certificate) {
        boolean bl;
        if (c.q.matcher((CharSequence)string).matches()) {
            List<String> list = d.b(x509Certificate, 7);
            int n2 = list.size();
            int n3 = 0;
            while (n3 < n2) {
                if (string.equalsIgnoreCase((String)list.get(n3))) {
                    return true;
                }
                ++n3;
            }
            return false;
        }
        String string2 = string.toLowerCase(Locale.US);
        Iterator iterator = d.b(x509Certificate, 2).iterator();
        do {
            if (!iterator.hasNext()) return false;
            String string3 = (String)iterator.next();
            if (!(string2 == null || string2.length() == 0 || string2.startsWith(".") || string2.endsWith("..") || string3 == null || string3.length() == 0 || string3.startsWith(".") || string3.endsWith(".."))) {
                String string4;
                String string5;
                String string6;
                if (!string2.endsWith(".")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append('.');
                    string5 = stringBuilder.toString();
                } else {
                    string5 = string2;
                }
                if (!string3.endsWith(".")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append('.');
                    string3 = stringBuilder.toString();
                }
                if (!(string6 = string3.toLowerCase(Locale.US)).contains((CharSequence)"*")) {
                    bl = string5.equals((Object)string6);
                    continue;
                }
                if (string6.startsWith("*.") && string6.indexOf(42, 1) == -1 && string5.length() >= string6.length() && !"*.".equals((Object)string6) && string5.endsWith(string4 = string6.substring(1))) {
                    int n4 = string5.length() - string4.length();
                    if (n4 <= 0) return true;
                    if (string5.lastIndexOf(46, n4 - 1) == -1) return true;
                }
            }
            bl = false;
        } while (!bl);
        return true;
    }

    public boolean verify(String string, SSLSession sSLSession) {
        try {
            boolean bl = this.c(string, (X509Certificate)sSLSession.getPeerCertificates()[0]);
            return bl;
        }
        catch (SSLException sSLException) {
            return false;
        }
    }
}

