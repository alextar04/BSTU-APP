/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.b0
 *  j.e
 *  j.g
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.net.IDN
 *  java.net.InetAddress
 *  java.net.Socket
 *  java.net.UnknownHostException
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.TimeZone
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.regex.Pattern
 */
package i.f0;

import i.b0;
import i.c0;
import i.q;
import i.r;
import i.t;
import j.e;
import j.g;
import j.h;
import j.w;
import j.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class c {
    public static final byte[] a;
    public static final String[] b;
    public static final c0 c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    public static final Charset i;
    public static final Charset j;
    public static final Charset k;
    public static final Charset l;
    public static final Charset m;
    public static final TimeZone n;
    public static final Comparator<String> o;
    public static final Method p;
    public static final Pattern q;

    public static {
        Method method;
        byte[] arrby = new byte[]{};
        a = arrby;
        b = new String[0];
        e e2 = new e();
        e2.J(arrby);
        long l2 = 0;
        method = null;
        c = new b0(null, l2, (g)e2);
        byte[] arrby2 = a;
        int n2 = arrby2.length;
        c.e(arrby2.length, l2, n2);
        d = h.b("efbbbf");
        e = h.b("feff");
        f = h.b("fffe");
        g = h.b("0000ffff");
        h = h.b("ffff0000");
        i = Charset.forName((String)"UTF-8");
        Charset.forName((String)"ISO-8859-1");
        j = Charset.forName((String)"UTF-16BE");
        k = Charset.forName((String)"UTF-16LE");
        l = Charset.forName((String)"UTF-32BE");
        m = Charset.forName((String)"UTF-32LE");
        n = TimeZone.getTimeZone((String)"GMT");
        o = new Comparator<String>(){

            public int compare(Object object, Object object2) {
                return ((String)object).compareTo((String)object2);
            }
        };
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        }
        catch (Exception exception) {}
        p = method;
        q = Pattern.compile((String)"([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static ThreadFactory A(String string, final boolean bl) {
        return new ThreadFactory(){

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, String.this);
                thread.setDaemon(bl);
                return thread;
            }
        };
    }

    public static q B(List<i.f0.h.c> list) {
        q.a a2 = new q.a();
        for (i.f0.h.c c2 : list) {
            i.f0.a.a.a(a2, c2.a.o(), c2.b.o());
        }
        return new q(a2);
    }

    public static String C(String string, int n2, int n3) {
        int n4 = c.y(string, n2, n3);
        return string.substring(n4, c.z(string, n4, n3));
    }

    public static AssertionError a(String string, Exception exception) {
        AssertionError assertionError;
        assertionError = new AssertionError((Object)string);
        try {
            assertionError.initCause((Throwable)exception);
        }
        catch (IllegalStateException illegalStateException) {}
        return assertionError;
    }

    public static Charset b(g g2, Charset charset) {
        if (g2.G(0L, d)) {
            g2.b((long)d.k());
            return i;
        }
        if (g2.G(0L, e)) {
            g2.b((long)e.k());
            return j;
        }
        if (g2.G(0L, f)) {
            g2.b((long)f.k());
            return k;
        }
        if (g2.G(0L, g)) {
            g2.b((long)g.k());
            return l;
        }
        if (g2.G(0L, h)) {
            g2.b((long)h.k());
            return m;
        }
        return charset;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String c(String string) {
        String string2;
        boolean bl;
        block16 : {
            int n2;
            block15 : {
                int n3;
                byte[] arrby;
                int n4;
                boolean bl2 = string.contains((CharSequence)":");
                n2 = -1;
                int n5 = 0;
                if (bl2) {
                    InetAddress inetAddress = string.startsWith("[") && string.endsWith("]") ? c.i(string, 1, string.length() - 1) : c.i(string, 0, string.length());
                    if (inetAddress == null) {
                        return null;
                    }
                    arrby = inetAddress.getAddress();
                    if (arrby.length != 16) {
                        throw new AssertionError((Object)c.b.a.a.a.k("Invalid IPv6 address: '", string, "'"));
                    }
                    n3 = 0;
                    n4 = 0;
                } else {
                    try {
                        string2 = IDN.toASCII((String)string).toLowerCase(Locale.US);
                        if (string2.isEmpty()) {
                            return null;
                        }
                        break block15;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        return null;
                    }
                }
                while (n3 < arrby.length) {
                    int n6;
                    for (n6 = n3; n6 < 16 && arrby[n6] == 0 && arrby[n6 + 1] == 0; n6 += 2) {
                    }
                    int n7 = n6 - n3;
                    if (n7 > n4 && n7 >= 4) {
                        n2 = n3;
                        n4 = n7;
                    }
                    n3 = n6 + 2;
                }
                e e2 = new e();
                do {
                    if (n5 >= arrby.length) {
                        return e2.v();
                    }
                    if (n5 == n2) {
                        e2.M(58);
                        if ((n5 += n4) != 16) continue;
                        e2.M(58);
                        continue;
                    }
                    if (n5 > 0) {
                        e2.M(58);
                    }
                    e2.N((long)((255 & arrby[n5]) << 8 | 255 & arrby[n5 + 1]));
                    n5 += 2;
                } while (true);
            }
            int n8 = 0;
            do {
                int n9;
                int n10 = string2.length();
                bl = false;
                if (n8 >= n10) break block16;
                char c2 = string2.charAt(n8);
                if (c2 <= '\u001f') return null;
                if (c2 >= '' || (n9 = " #%/:?@[\\]".indexOf((int)c2)) != n2) break;
                ++n8;
            } while (true);
            return null;
        }
        if (!bl) return string2;
        return null;
    }

    public static int d(String string, long l2, TimeUnit timeUnit) {
        long l3 = l2 LCMP 0L;
        if (l3 >= 0) {
            if (timeUnit != null) {
                long l4 = timeUnit.toMillis(l2);
                if (l4 <= Integer.MAX_VALUE) {
                    if (l4 == 0L && l3 > 0) {
                        throw new IllegalArgumentException(c.b.a.a.a.j(string, " too small."));
                    }
                    return (int)l4;
                }
                throw new IllegalArgumentException(c.b.a.a.a.j(string, " too large."));
            }
            throw new NullPointerException("unit == null");
        }
        throw new IllegalArgumentException(c.b.a.a.a.j(string, " < 0"));
    }

    public static void e(long l2, long l3, long l4) {
        if ((l3 | l4) >= 0L && l3 <= l2 && l2 - l3 >= l4) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /*
     * Exception decompiling
     */
    public static void f(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9.1 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public static void g(Socket var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl16.1 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int h(char n2) {
        if (n2 >= 48 && n2 <= 57) {
            return n2 - 48;
        }
        int n3 = 97;
        if (n2 >= n3 && n2 <= 102) {
            return 10 + (n2 - n3);
        }
        n3 = 65;
        if (n2 < n3) return -1;
        if (n2 > 70) return -1;
        return 10 + (n2 - n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static InetAddress i(String string, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        byte[] arrby;
        block18 : {
            int n7 = 16;
            arrby = new byte[n7];
            int n8 = -1;
            int n9 = n2;
            int n10 = n5 = n8;
            n4 = 0;
            while (n9 < n3) {
                int n11;
                if (n4 == n7) {
                    return null;
                }
                int n12 = n9 + 2;
                if (n12 <= n3 && string.regionMatches(n9, "::", 0, 2)) {
                    if (n5 != n8) {
                        return null;
                    }
                    n4 += 2;
                    if (n12 == n3) {
                        n6 = n7;
                        n5 = n4;
                        break block18;
                    }
                    n5 = n4;
                    n10 = n12;
                } else {
                    if (n4 != 0 && !string.regionMatches(n9, ":", 0, 1)) {
                        int n13;
                        if (!string.regionMatches(n9, ".", 0, 1)) return null;
                        int n14 = n13 = n4 - 2;
                        while (n10 < n3) {
                            int n15;
                            char c2;
                            if (n14 == n7 || n14 != n13 && string.charAt(n10) != '.') {
                                return null;
                            }
                            int n16 = 0;
                            for (n15 = ++n10; n15 < n3 && (c2 = string.charAt(n15)) >= '0' && c2 <= '9'; ++n15) {
                                if (n16 == 0 && n10 != n15 || (n16 = c2 + n16 * 10 - 48) > 255) return null;
                            }
                            if (n15 - n10 == 0) return null;
                            int n17 = n14 + 1;
                            arrby[n14] = (byte)n16;
                            n14 = n17;
                            n10 = n15;
                            n7 = 16;
                        }
                        if (n14 != n13 + 4) {
                            return null;
                        }
                        boolean bl = true;
                        if (!bl) {
                            return null;
                        }
                        n4 += 2;
                        n6 = 16;
                        break block18;
                    }
                    n10 = ++n9;
                }
                int n18 = 0;
                for (n9 = n10; n9 < n3 && (n11 = c.h(string.charAt(n9))) != -1; ++n9) {
                    n18 = n11 + (n18 << 4);
                }
                int n19 = n9 - n10;
                if (n19 == 0) return null;
                if (n19 > 4) {
                    return null;
                }
                int n20 = n4 + 1;
                arrby[n4] = (byte)(255 & n18 >>> 8);
                n4 = n20 + 1;
                arrby[n20] = (byte)(n18 & 255);
                n7 = 16;
                n8 = -1;
            }
            n6 = n7;
        }
        if (n4 != n6) {
            if (n5 == -1) {
                return null;
            }
            int n21 = n4 - n5;
            System.arraycopy((Object)arrby, (int)n5, (Object)arrby, (int)(16 - n21), (int)n21);
            Arrays.fill((byte[])arrby, (int)n5, (int)(n5 + (16 - n4)), (byte)0);
        }
        try {
            return InetAddress.getByAddress((byte[])arrby);
        }
        catch (UnknownHostException unknownHostException) {
            throw new AssertionError();
        }
    }

    public static int j(String string, int n2, int n3, char c2) {
        while (n2 < n3) {
            if (string.charAt(n2) == c2) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static int k(String string, int n2, int n3, String string2) {
        while (n2 < n3) {
            if (string2.indexOf((int)string.charAt(n2)) != -1) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static boolean l(w w2, int n2, TimeUnit timeUnit) {
        try {
            boolean bl = c.x(w2, n2, timeUnit);
            return bl;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static boolean m(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    public static /* varargs */ String n(String string, Object ... arrobject) {
        return String.format((Locale)Locale.US, (String)string, (Object[])arrobject);
    }

    public static String o(r r2, boolean bl) {
        String string = r2.d.contains((CharSequence)":") ? c.b.a.a.a.l(c.b.a.a.a.c("["), r2.d, "]") : r2.d;
        if (bl || r2.e != r.c(r2.a)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(":");
            stringBuilder.append(r2.e);
            string = stringBuilder.toString();
        }
        return string;
    }

    public static <T> List<T> p(List<T> list) {
        return Collections.unmodifiableList((List)new ArrayList(list));
    }

    public static /* varargs */ <T> List<T> q(T ... arrT) {
        return Collections.unmodifiableList((List)Arrays.asList((Object[])((Object[])arrT.clone())));
    }

    public static <K, V> Map<K, V> r(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap((Map)new LinkedHashMap(map));
    }

    public static int s(Comparator<String> comparator, String[] arrstring, String string) {
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (comparator.compare((Object)arrstring[i2], (Object)string) != 0) continue;
            return i2;
        }
        return -1;
    }

    public static int t(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 > '\u001f') {
                if (c2 < '') continue;
                return i2;
            }
            return i2;
        }
        return -1;
    }

    public static String[] u(Comparator<? super String> comparator, String[] arrstring, String[] arrstring2) {
        ArrayList arrayList = new ArrayList();
        block0 : for (String string : arrstring) {
            int n2 = arrstring2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (comparator.compare((Object)string, (Object)arrstring2[i2]) != 0) continue;
                arrayList.add((Object)string);
                continue block0;
            }
        }
        return (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
    }

    public static boolean v(AssertionError assertionError) {
        return assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains((CharSequence)"getsockname failed");
    }

    public static boolean w(Comparator<String> comparator, String[] arrstring, String[] arrstring2) {
        if (arrstring != null && arrstring2 != null && arrstring.length != 0) {
            if (arrstring2.length == 0) {
                return false;
            }
            for (String string : arrstring) {
                int n2 = arrstring2.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (comparator.compare((Object)string, (Object)arrstring2[i2]) != 0) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean x(w w2, int n2, TimeUnit timeUnit) {
        long l2 = System.nanoTime();
        long l3 = w2.d().e() ? w2.d().c() - l2 : Long.MAX_VALUE;
        w2.d().d(l2 + Math.min((long)l3, (long)timeUnit.toNanos((long)n2)));
        try {
            e e2 = new e();
            while (w2.n(e2, 8192L) != -1L) {
                e2.c();
            }
        }
        catch (Throwable throwable) {
            long l4 = l3 LCMP Long.MAX_VALUE;
            x x2 = w2.d();
            if (l4 == false) {
                x2.a();
            } else {
                x2.d(l2 + l3);
            }
            throw throwable;
        }
        catch (InterruptedIOException interruptedIOException) {
            long l5 = l3 LCMP Long.MAX_VALUE;
            x x3 = w2.d();
            if (l5 == false) {
                x3.a();
                return false;
            }
            x3.d(l2 + l3);
            return false;
        }
        long l6 = l3 LCMP Long.MAX_VALUE;
        x x4 = w2.d();
        if (l6 == false) {
            x4.a();
            return true;
        }
        x4.d(l2 + l3);
        return true;
    }

    public static int y(String string, int n2, int n3) {
        while (n2 < n3) {
            char c2 = string.charAt(n2);
            if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static int z(String string, int n2, int n3) {
        for (int i2 = n3 - 1; i2 >= n2; --i2) {
            char c2 = string.charAt(i2);
            if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') continue;
            return i2 + 1;
        }
        return n2;
    }

}

