/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j.e
 *  java.lang.Character
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 */
package i;

import i.f0.c;
import j.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class r {
    public static final char[] j = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final List<String> f;
    public final List<String> g;
    public final String h;
    public final String i;

    public r(a a2) {
        this.a = a2.a;
        this.b = r.k(a2.b, false);
        this.c = r.k(a2.c, false);
        this.d = a2.d;
        int n2 = a2.e;
        if (n2 == -1) {
            n2 = r.c(a2.a);
        }
        this.e = n2;
        this.f = this.l(a2.f, false);
        List<String> list = a2.g;
        List<String> list2 = list != null ? this.l(list, true) : null;
        this.g = list2;
        String string = a2.h;
        String string2 = null;
        if (string != null) {
            string2 = r.j(string, 0, string.length(), false);
        }
        this.h = string2;
        this.i = a2.toString();
    }

    public static String a(String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset) {
        int n4;
        for (int i2 = n2; i2 < n3; i2 += Character.charCount((int)n4)) {
            n4 = string.codePointAt(i2);
            if (!(n4 < 32 || n4 == 127 || n4 >= 128 && bl4 || string2.indexOf(n4) != -1 || n4 == 37 && (!bl || bl2 && !r.m(string, i2, n3)) || n4 == 43 && bl3)) {
                continue;
            }
            e e2 = new e();
            e2.R(string, n2, i2);
            e e3 = null;
            while (i2 < n3) {
                int n5 = string.codePointAt(i2);
                if (!bl || n5 != 9 && n5 != 10 && n5 != 12 && n5 != 13) {
                    if (n5 == 43 && bl3) {
                        String string3 = bl ? "+" : "%2B";
                        e2.Q(string3);
                    } else if (!(n5 < 32 || n5 == 127 || n5 >= 128 && bl4 || string2.indexOf(n5) != -1 || n5 == 37 && (!bl || bl2 && !r.m(string, i2, n3)))) {
                        e2.S(n5);
                    } else {
                        if (e3 == null) {
                            e3 = new e();
                        }
                        e3.S(n5);
                        while (!e3.C()) {
                            int n6 = 255 & e3.readByte();
                            e2.M(37);
                            e2.M((int)j[15 & n6 >> 4]);
                            e2.M((int)j[n6 & 15]);
                        }
                    }
                }
                i2 += Character.charCount((int)n5);
            }
            return e2.v();
        }
        return string.substring(n2, n3);
    }

    public static String b(String string, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return r.a(string, 0, string.length(), string2, bl, bl2, bl3, bl4, null);
    }

    public static int c(String string) {
        if (string.equals((Object)"http")) {
            return 80;
        }
        if (string.equals((Object)"https")) {
            return 443;
        }
        return -1;
    }

    public static void i(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            String string = (String)list.get(i2);
            String string2 = (String)list.get(i2 + 1);
            if (i2 > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(string);
            if (string2 == null) continue;
            stringBuilder.append('=');
            stringBuilder.append(string2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static String j(String var0, int var1_1, int var2_2, boolean var3_3) {
        block5 : {
            var4_4 = var1_1;
            while (var4_4 < var2_2) {
                var5_5 = var0.charAt(var4_4);
                if (!(var5_5 == '%' || var5_5 == '+' && var3_3)) {
                    ++var4_4;
                    continue;
                }
                break block5;
            }
            return var0.substring(var1_1, var2_2);
        }
        var6_6 = new e();
        var6_6.R(var0, var1_1, var4_4);
        while (var4_4 < var2_2) {
            block7 : {
                block6 : {
                    var8_7 = var0.codePointAt(var4_4);
                    if (var8_7 != 37 || (var11_8 = var4_4 + 2) >= var2_2) break block6;
                    var12_9 = c.h(var0.charAt(var4_4 + 1));
                    var13_10 = c.h(var0.charAt(var11_8));
                    if (var12_9 == -1 || var13_10 == -1) ** GOTO lbl-1000
                    var6_6.M(var13_10 + (var12_9 << 4));
                    var4_4 = var11_8;
                    break block7;
                }
                if (var8_7 == 43 && var3_3) {
                    var6_6.M(32);
                } else lbl-1000: // 2 sources:
                {
                    var6_6.S(var8_7);
                }
            }
            var4_4 += Character.charCount((int)var8_7);
        }
        return var6_6.v();
    }

    public static String k(String string, boolean bl) {
        return r.j(string, 0, string.length(), bl);
    }

    public static boolean m(String string, int n2, int n3) {
        int n4 = n2 + 2;
        return n4 < n3 && string.charAt(n2) == '%' && c.h(string.charAt(n2 + 1)) != -1 && c.h(string.charAt(n4)) != -1;
    }

    public static List<String> n(String string) {
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        while (n2 <= string.length()) {
            String string2;
            int n3;
            int n4 = string.indexOf(38, n2);
            if (n4 == -1) {
                n4 = string.length();
            }
            if ((n3 = string.indexOf(61, n2)) != -1 && n3 <= n4) {
                arrayList.add((Object)string.substring(n2, n3));
                string2 = string.substring(n3 + 1, n4);
            } else {
                arrayList.add((Object)string.substring(n2, n4));
                string2 = null;
            }
            arrayList.add(string2);
            n2 = n4 + 1;
        }
        return arrayList;
    }

    public String d() {
        if (this.c.isEmpty()) {
            return "";
        }
        int n2 = 1 + this.i.indexOf(58, 3 + this.a.length());
        int n3 = this.i.indexOf(64);
        return this.i.substring(n2, n3);
    }

    public String e() {
        int n2 = this.i.indexOf(47, 3 + this.a.length());
        String string = this.i;
        int n3 = c.k(string, n2, string.length(), "?#");
        return this.i.substring(n2, n3);
    }

    public boolean equals(Object object) {
        return object instanceof r && ((r)object).i.equals((Object)this.i);
    }

    public List<String> f() {
        int n2 = this.i.indexOf(47, 3 + this.a.length());
        String string = this.i;
        int n3 = c.k(string, n2, string.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (n2 < n3) {
            int n4 = n2 + 1;
            int n5 = c.j(this.i, n4, n3, '/');
            arrayList.add((Object)this.i.substring(n4, n5));
            n2 = n5;
        }
        return arrayList;
    }

    public String g() {
        if (this.g == null) {
            return null;
        }
        int n2 = 1 + this.i.indexOf(63);
        String string = this.i;
        int n3 = c.j(string, n2, string.length(), '#');
        return this.i.substring(n2, n3);
    }

    public String h() {
        if (this.b.isEmpty()) {
            return "";
        }
        int n2 = 3 + this.a.length();
        String string = this.i;
        int n3 = c.k(string, n2, string.length(), ":@");
        return this.i.substring(n2, n3);
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public final List<String> l(List<String> list, boolean bl) {
        int n2 = list.size();
        ArrayList arrayList = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = (String)list.get(i2);
            String string2 = string != null ? r.j(string, 0, string.length(), bl) : null;
            arrayList.add(string2);
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    public URI o() {
        String string;
        String string2;
        a a2 = new a();
        a2.a = this.a;
        a2.b = this.h();
        a2.c = this.d();
        a2.d = this.d;
        int n2 = this.e != r.c(this.a) ? this.e : -1;
        a2.e = n2;
        a2.f.clear();
        a2.f.addAll(this.f());
        a2.c(this.g());
        if (this.h == null) {
            string2 = null;
        } else {
            int n3 = 1 + this.i.indexOf(35);
            string2 = this.i.substring(n3);
        }
        a2.h = string2;
        int n4 = a2.f.size();
        int n5 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            String string3 = (String)a2.f.get(i2);
            a2.f.set(i2, (Object)r.b(string3, "[]", true, true, false, true));
        }
        List<String> list = a2.g;
        if (list != null) {
            int n6 = list.size();
            while (n5 < n6) {
                String string4 = (String)a2.g.get(n5);
                if (string4 != null) {
                    a2.g.set(n5, (Object)r.b(string4, "\\^`{|}", true, true, true, true));
                }
                ++n5;
            }
        }
        if ((string = a2.h) != null) {
            a2.h = r.b(string, " \"#<>\\^`{|}", true, true, false, false);
        }
        String string5 = a2.toString();
        try {
            URI uRI = new URI(string5);
            return uRI;
        }
        catch (URISyntaxException uRISyntaxException) {
            try {
                URI uRI = URI.create((String)string5.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                return uRI;
            }
            catch (Exception exception) {
                throw new RuntimeException((Throwable)uRISyntaxException);
            }
        }
    }

    public String toString() {
        return this.i;
    }

    public static final class a {
        public String a;
        public String b = "";
        public String c = "";
        public String d;
        public int e = -1;
        public final List<String> f;
        public List<String> g;
        public String h;

        public a() {
            ArrayList arrayList;
            this.f = arrayList = new ArrayList();
            arrayList.add((Object)"");
        }

        public static String b(String string, int n2, int n3) {
            return c.c(r.j(string, n2, n3, false));
        }

        public r a() {
            if (this.a != null) {
                if (this.d != null) {
                    return new r(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public a c(String string) {
            List<String> list = string != null ? r.n(r.b(string, " \"'<>#", true, false, true, true)) : null;
            this.g = list;
            return this;
        }

        /*
         * Exception decompiling
         */
        public a d(r var1, String var2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
            // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
            // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
            // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        public String toString() {
            String string;
            String string2;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = this.a;
            if (string3 != null) {
                stringBuilder.append(string3);
                string = "://";
            } else {
                string = "//";
            }
            stringBuilder.append(string);
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                stringBuilder.append(this.b);
                if (!this.c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.c);
                }
                stringBuilder.append('@');
            }
            if ((string2 = this.d) != null) {
                if (string2.indexOf(58) != -1) {
                    stringBuilder.append('[');
                    stringBuilder.append(this.d);
                    stringBuilder.append(']');
                } else {
                    stringBuilder.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int n2 = this.e;
                if (n2 == -1) {
                    n2 = r.c(this.a);
                }
                String string4 = this.a;
                if (string4 == null || n2 != r.c(string4)) {
                    stringBuilder.append(':');
                    stringBuilder.append(n2);
                }
            }
            List<String> list = this.f;
            int n3 = list.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                stringBuilder.append('/');
                stringBuilder.append((String)list.get(i2));
            }
            if (this.g != null) {
                stringBuilder.append('?');
                r.i(stringBuilder, this.g);
            }
            if (this.h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.h);
            }
            return stringBuilder.toString();
        }
    }

}

