/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  g.a.p0.v.a.a
 *  g.a.p0.v.a.b
 *  g.a.p0.v.a.c
 *  g.a.p0.v.a.e
 *  g.a.q0.d$b$a
 *  g.a.q0.d$b$b
 *  g.a.x
 *  io.realm.internal.Util
 *  io.realm.mongodb.sync.SyncSession
 *  io.realm.mongodb.sync.SyncSession$b
 *  io.realm.mongodb.sync.SyncSession$c
 *  java.io.File
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.TimeUnit
 *  java.util.regex.Pattern
 *  k.a.w0.c1
 *  k.a.w0.f0
 *  k.a.w0.m1
 *  k.a.w0.n1.c
 *  k.a.w0.r0
 *  k.a.w0.y0
 *  k.a.x0.f
 */
package g.a.q0;

import android.content.Context;
import f.b.k.h;
import g.a.p0.v.a.c;
import g.a.p0.v.a.e;
import g.a.q0.d;
import g.a.q0.f;
import g.a.x;
import io.realm.internal.Util;
import io.realm.mongodb.sync.SyncSession;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k.a.w0.c1;
import k.a.w0.f0;
import k.a.w0.m1;
import k.a.w0.r0;
import k.a.w0.y0;

public class d {
    public static final k.a.w0.n1.d n;
    public static final Map<String, g.a.p0.v.a.d> o;
    public final String a;
    public final String b;
    public final String c;
    public final URL d;
    public final SyncSession.c e;
    public final SyncSession.b f;
    public final byte[] g;
    public final long h;
    public final String i;
    public final Map<String, String> j;
    public final File k;
    public final k.a.w0.n1.d l;
    public final g.a.q0.g.a.a m;

    public static {
        Object[] arrobject = new k.a.w0.n1.d[1];
        k.a.w0.n1.b[] arrb = new k.a.w0.n1.b[]{new m1(), new f0(), new r0(), new y0(), new c1()};
        arrobject[0] = h.i.Y(arrb);
        List list = Arrays.asList((Object[])arrobject);
        ArrayList arrayList = new ArrayList();
        for (k.a.w0.n1.d d2 : list) {
            k.a.w0.n1.b b2 = d2 instanceof k.a.w0.n1.b ? (k.a.w0.n1.b)((Object)d2) : new k.a.w0.n1.c(d2);
            arrayList.add((Object)b2);
        }
        n = new k.a.x0.f((List)arrayList);
        HashMap hashMap = new HashMap();
        String string = f.a.g.e;
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)Pattern.compile((String)"((\"key\"):(\\s?\".+?\"))"), (Object)"\"key\":\"***\"");
        hashMap.put((Object)string, (Object)new g.a.p0.v.a.a((Map)hashMap2));
        hashMap.put((Object)f.a.h.e, (Object)e.a());
        String string2 = f.a.i.e;
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)Pattern.compile((String)"\\{(.+?),\"options\":"), (Object)"{\"functionArgs\":\"***\",\"options\":");
        hashMap.put((Object)string2, (Object)new g.a.p0.v.a.b((Map)hashMap3));
        String string3 = f.a.j.e;
        HashMap hashMap4 = new HashMap();
        hashMap4.put((Object)Pattern.compile((String)"((\"email\"):(\".+?\"))"), (Object)"\"email\":\"***\"");
        hashMap4.put((Object)Pattern.compile((String)"((\"username\"):(\".+?\"))"), (Object)"\"username\":\"***\"");
        hashMap4.put((Object)Pattern.compile((String)"((\"password\"):(\".+?\"))"), (Object)"\"password\":\"***\"");
        hashMap.put((Object)string3, (Object)new c((Map)hashMap4));
        hashMap.put((Object)f.a.k.e, (Object)e.a());
        hashMap.put((Object)f.a.l.e, (Object)e.a());
        hashMap.put((Object)f.a.m.e, (Object)e.a());
        o = hashMap;
    }

    public d(String string, String string2, String string3, URL uRL, SyncSession.c c2, SyncSession.b b2, byte[] arrby, long l2, String string4, Map map, File file, k.a.w0.n1.d d2, g.a.q0.g.a.a a2, a a3) {
        this.a = string;
        this.b = null;
        this.c = null;
        this.d = uRL;
        this.e = c2;
        this.f = b2;
        this.g = null;
        this.h = l2;
        String string5 = !Util.d(null) ? null : "Authorization";
        this.i = string5;
        this.j = Collections.unmodifiableMap((Map)map);
        this.k = file;
        this.l = d2;
        this.m = a2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (d.class != object.getClass()) {
                return false;
            }
            d d2 = (d)object;
            if (this.h != d2.h) {
                return false;
            }
            if (!this.a.equals((Object)d2.a)) {
                return false;
            }
            String string = this.b;
            if (string != null ? !string.equals((Object)d2.b) : d2.b != null) {
                return false;
            }
            String string2 = this.c;
            if (string2 != null ? !string2.equals((Object)d2.c) : d2.c != null) {
                return false;
            }
            if (!this.d.toString().equals((Object)d2.d.toString())) {
                return false;
            }
            if (!this.e.equals((Object)d2.e)) {
                return false;
            }
            if (!Arrays.equals((byte[])this.g, (byte[])d2.g)) {
                return false;
            }
            if (!this.i.equals((Object)d2.i)) {
                return false;
            }
            if (!this.j.equals(d2.j)) {
                return false;
            }
            if (!this.k.equals((Object)d2.k)) {
                return false;
            }
            if (!this.l.equals((Object)d2.l)) {
                return false;
            }
            g.a.q0.g.a.a a2 = this.m;
            g.a.q0.g.a.a a3 = d2.m;
            if (a2 != null) {
                return a2.equals(a3);
            }
            return a3 == null;
        }
        return false;
    }

    public int hashCode() {
        int n2 = 31 * this.a.hashCode();
        String string = this.b;
        int n3 = string != null ? string.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        String string2 = this.c;
        int n5 = string2 != null ? string2.hashCode() : 0;
        int n6 = 31 * (31 * (31 * (31 * (n4 + n5) + this.d.toString().hashCode()) + this.e.hashCode()) + Arrays.hashCode((byte[])this.g));
        long l2 = this.h;
        int n7 = 31 * (31 * (31 * (31 * (31 * (n6 + (int)(l2 ^ l2 >>> 32)) + this.i.hashCode()) + this.j.hashCode()) + this.k.hashCode()) + this.l.hashCode());
        g.a.q0.g.a.a a2 = this.m;
        int n8 = 0;
        if (a2 != null) {
            n8 = a2.hashCode();
        }
        return n7 + n8;
    }

    public static class g.a.q0.d$b {
        public String a;
        public URL b;
        public SyncSession.c c;
        public SyncSession.b d;
        public long e;
        public Map<String, String> f;
        public File g;
        public k.a.w0.n1.d h;
        public g.a.q0.g.a.a i;

        public g.a.q0.d$b(String string) {
            URL uRL;
            try {}
            catch (MalformedURLException malformedURLException) {
                throw new IllegalArgumentException("https://realm.mongodb.com");
            }
            this.b = uRL = new URL("https://realm.mongodb.com");
            this.c = new a(this);
            this.d = new b(this);
            this.e = TimeUnit.MILLISECONDS.convert(60L, TimeUnit.SECONDS);
            this.f = new HashMap();
            this.h = d.n;
            this.i = new g.a.q0.g.a.a("providers", d.o);
            if (!Util.d((String)string)) {
                this.a = string;
                Context context = x.s();
                if (context != null) {
                    File file = new File(context.getFilesDir(), "mongodb-realm");
                    if (!file.exists() && !file.mkdir()) {
                        StringBuilder stringBuilder = c.b.a.a.a.c("Could not create Sync root dir: ");
                        stringBuilder.append(file.getAbsolutePath());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    this.g = file;
                    return;
                }
                throw new IllegalStateException("Call `Realm.init(Context)` before calling this method.");
            }
            throw new IllegalArgumentException("Non-empty 'appId' required.");
        }
    }

}

