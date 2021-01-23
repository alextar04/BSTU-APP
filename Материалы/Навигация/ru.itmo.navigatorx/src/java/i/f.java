/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package i;

import i.f0.k.c;
import j.h;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class f {
    public static final f c = new f((Set<a>)new LinkedHashSet((Collection)new ArrayList()), null);
    public final Set<a> a;
    public final c b;

    public f(Set<a> set, c c2) {
        this.a = set;
        this.b = c2;
    }

    public static String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = c.b.a.a.a.c("sha256/");
            stringBuilder.append(h.h(((X509Certificate)certificate).getPublicKey().getEncoded()).d("SHA-256").a());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public void a(String string, List<Certificate> list) {
        List list2 = Collections.emptyList();
        Iterator iterator = this.a.iterator();
        if (!iterator.hasNext()) {
            if (list2.isEmpty()) {
                return;
            }
            c c2 = this.b;
            if (c2 != null) {
                list = c2.a(list, string);
            }
            int n2 = list.size();
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                X509Certificate x509Certificate = (X509Certificate)list.get(i2);
                int n4 = list2.size();
                h h2 = null;
                h h3 = null;
                for (int i3 = 0; i3 < n4; ++i3) {
                    a a2 = (a)list2.get(i3);
                    if (a2.b.equals((Object)"sha256/")) {
                        if (h2 == null) {
                            h2 = h.h(x509Certificate.getPublicKey().getEncoded()).d("SHA-256");
                        }
                        if (!a2.c.equals(h2)) continue;
                        return;
                    }
                    if (a2.b.equals((Object)"sha1/")) {
                        if (h3 == null) {
                            h3 = h.h(x509Certificate.getPublicKey().getEncoded()).d("SHA-1");
                        }
                        if (!a2.c.equals(h3)) continue;
                        return;
                    }
                    StringBuilder stringBuilder = c.b.a.a.a.c("unsupported hashAlgorithm: ");
                    stringBuilder.append(a2.b);
                    throw new AssertionError((Object)stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Certificate pinning failure!");
            stringBuilder.append("\n  Peer certificate chain:");
            int n5 = list.size();
            for (int i4 = 0; i4 < n5; ++i4) {
                X509Certificate x509Certificate = (X509Certificate)list.get(i4);
                stringBuilder.append("\n    ");
                stringBuilder.append(f.b((Certificate)x509Certificate));
                stringBuilder.append(": ");
                stringBuilder.append(x509Certificate.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ");
            stringBuilder.append(string);
            stringBuilder.append(":");
            int n6 = list2.size();
            while (n3 < n6) {
                a a3 = (a)list2.get(n3);
                stringBuilder.append("\n    ");
                stringBuilder.append((Object)a3);
                ++n3;
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
        (a)iterator.next();
        throw null;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof f) {
            c c2 = this.b;
            f f2 = (f)object;
            if (i.f0.c.m(c2, f2.b) && this.a.equals(f2.a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        c c2 = this.b;
        int n2 = c2 != null ? c2.hashCode() : 0;
        return n2 * 31 + this.a.hashCode();
    }

    public static final class a {
        public final String a;
        public final String b;
        public final h c;

        public boolean equals(Object object) {
            if (!(object instanceof a)) {
                return false;
            }
            throw null;
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            new StringBuilder().append(null);
            throw null;
        }
    }

}

