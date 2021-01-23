/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.b.e0.a$a
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 */
package c.e.b.e0;

import c.e.b.c0.q;
import c.e.b.e0.a;
import c.e.b.e0.b;
import c.e.b.e0.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class a
implements Closeable {
    public static final char[] t = ")]}'\n".toCharArray();
    public final Reader e;
    public boolean f = false;
    public final char[] g = new char[1024];
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public long m;
    public int n;
    public String o;
    public int[] p;
    public int q;
    public String[] r;
    public int[] s;

    public static {
        q.a = new a();
    }

    public a(Reader reader) {
        int[] arrn = new int[32];
        this.p = arrn;
        this.q = 0;
        this.q = 0 + 1;
        arrn[0] = 6;
        this.r = new String[32];
        this.s = new int[32];
        if (reader != null) {
            this.e = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public String B() {
        int n2 = 1 + this.j;
        int n3 = 1 + (this.h - this.k);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" at line ");
        stringBuilder.append(n2);
        stringBuilder.append(" column ");
        stringBuilder.append(n3);
        stringBuilder.append(" path ");
        stringBuilder.append(this.u());
        return stringBuilder.toString();
    }

    public boolean J() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        if (n2 == 5) {
            this.l = 0;
            int[] arrn = this.s;
            int n3 = this.q - 1;
            arrn[n3] = 1 + arrn[n3];
            return true;
        }
        if (n2 == 6) {
            this.l = 0;
            int[] arrn = this.s;
            int n4 = this.q - 1;
            arrn[n4] = 1 + arrn[n4];
            return false;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected a boolean but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public double K() {
        block5 : {
            String string;
            block8 : {
                int n2;
                block6 : {
                    block7 : {
                        block4 : {
                            n2 = this.l;
                            if (n2 == 0) {
                                n2 = this.j();
                            }
                            if (n2 == 15) {
                                this.l = 0;
                                int[] arrn = this.s;
                                int n3 = -1 + this.q;
                                arrn[n3] = 1 + arrn[n3];
                                return this.m;
                            }
                            if (n2 != 16) break block4;
                            this.o = new String(this.g, this.h, this.n);
                            this.h += this.n;
                            break block5;
                        }
                        if (n2 == 8 || n2 == 9) break block6;
                        if (n2 != 10) break block7;
                        string = this.S();
                        break block8;
                    }
                    if (n2 != 11) {
                        StringBuilder stringBuilder = c.b.a.a.a.c("Expected a double but was ");
                        stringBuilder.append((Object)this.T());
                        stringBuilder.append(this.B());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    break block5;
                }
                char c2 = n2 == 8 ? (char)'\'' : '\"';
                string = this.Q(c2);
            }
            this.o = string;
        }
        this.l = 11;
        double d2 = Double.parseDouble((String)this.o);
        if (!this.f && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d2);
            stringBuilder.append(this.B());
            throw new d(stringBuilder.toString());
        }
        this.o = null;
        this.l = 0;
        int[] arrn = this.s;
        int n4 = -1 + this.q;
        arrn[n4] = 1 + arrn[n4];
        return d2;
    }

    /*
     * Exception decompiling
     */
    public int L() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl161.1 : ALOAD_0 : trying to set 1 previously set to 0
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
    public long M() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl132.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public String N() {
        block8 : {
            String string;
            block5 : {
                char c2;
                block7 : {
                    int n2;
                    block6 : {
                        block4 : {
                            n2 = this.l;
                            if (n2 == 0) {
                                n2 = this.j();
                            }
                            if (n2 != 14) break block4;
                            string = this.S();
                            break block5;
                        }
                        if (n2 != 12) break block6;
                        c2 = '\'';
                        break block7;
                    }
                    if (n2 != 13) break block8;
                    c2 = '\"';
                }
                string = this.Q(c2);
            }
            this.l = 0;
            this.r[-1 + this.q] = string;
            return string;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected a name but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final int O(boolean var1_1) {
        var2_2 = this.g;
        block0 : do {
            var3_3 = this.h;
            do {
                var4_4 = this.i;
                do {
                    var5_5 = 1;
                    if (var3_3 == var4_4) {
                        this.h = var3_3;
                        if (!this.s(var5_5)) {
                            if (!var1_1) {
                                return -1;
                            }
                            var16_15 = c.b.a.a.a.c("End of input");
                            var16_15.append(this.B());
                            throw new EOFException(var16_15.toString());
                        }
                        var3_3 = this.h;
                        var4_4 = this.i;
                    }
                    var6_6 = var3_3 + 1;
                    var7_7 = var2_2[var3_3];
                    if (var7_7 == '\n') {
                        this.j = var5_5 + this.j;
                        this.k = var6_6;
                    } else if (var7_7 != ' ' && var7_7 != '\r' && var7_7 != '\t') {
                        if (var7_7 == '/') {
                            this.h = var6_6;
                            if (var6_6 == var4_4) {
                                this.h = var6_6 - 1;
                                var15_14 = this.s(2);
                                this.h = var5_5 + this.h;
                                if (!var15_14) {
                                    return var7_7;
                                }
                            }
                            this.h();
                            var8_8 = this.h;
                            var9_9 = var2_2[var8_8];
                            if (var9_9 == '*') break;
                            if (var9_9 != '/') {
                                return var7_7;
                            }
                            this.h = var8_8 + 1;
                        } else {
                            this.h = var6_6;
                            if (var7_7 != '#') return var7_7;
                            this.h();
                        }
                        this.X();
                        continue block0;
                    }
                    var3_3 = var6_6;
                } while (true);
                this.h = var8_8 + 1;
                block3 : do {
                    block18 : {
                        if (2 + this.h > this.i && !this.s(2)) {
                            var5_5 = 0;
                            break;
                        }
                        var10_10 = this.g;
                        var11_11 = this.h;
                        var12_12 = var10_10[var11_11];
                        if (var12_12 != '\n') break block18;
                        this.j = var5_5 + this.j;
                        this.k = var11_11 + 1;
                        ** GOTO lbl63
                    }
                    for (var13_13 = 0; var13_13 < 2; ++var13_13) {
                        if (this.g[var13_13 + this.h] == "*/".charAt(var13_13)) continue;
lbl63: // 2 sources:
                        this.h = var5_5 + this.h;
                        continue block3;
                    }
                    break;
                } while (true);
                if (var5_5 == 0) {
                    this.Z("Unterminated comment");
                    throw null;
                }
                var3_3 = 2 + this.h;
            } while (true);
            break;
        } while (true);
    }

    public void P() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        if (n2 == 7) {
            this.l = 0;
            int[] arrn = this.s;
            int n3 = -1 + this.q;
            arrn[n3] = 1 + arrn[n3];
            return;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected null but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final String Q(char c2) {
        char[] arrc = this.g;
        StringBuilder stringBuilder = null;
        block0 : do {
            int n2 = this.h;
            int n3 = this.i;
            int n4 = n2;
            while (n2 < n3) {
                int n5 = n2 + 1;
                char c3 = arrc[n2];
                if (c3 == c2) {
                    this.h = n5;
                    int n6 = n5 - n4 - 1;
                    if (stringBuilder == null) {
                        return new String(arrc, n4, n6);
                    }
                    stringBuilder.append(arrc, n4, n6);
                    return stringBuilder.toString();
                }
                if (c3 == '\\') {
                    this.h = n5;
                    int n7 = n5 - n4 - 1;
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder(Math.max((int)(2 * (n7 + 1)), (int)16));
                    }
                    stringBuilder.append(arrc, n4, n7);
                    stringBuilder.append(this.V());
                    continue block0;
                }
                if (c3 == '\n') {
                    this.j = 1 + this.j;
                    this.k = n5;
                }
                n2 = n5;
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(Math.max((int)(2 * (n2 - n4)), (int)16));
            }
            stringBuilder.append(arrc, n4, n2 - n4);
            this.h = n2;
            if (!this.s(1)) break;
        } while (true);
        this.Z("Unterminated string");
        throw null;
    }

    public String R() {
        block11 : {
            String string;
            block5 : {
                int n2;
                block10 : {
                    block9 : {
                        block8 : {
                            char c2;
                            block7 : {
                                block6 : {
                                    block4 : {
                                        n2 = this.l;
                                        if (n2 == 0) {
                                            n2 = this.j();
                                        }
                                        if (n2 != 10) break block4;
                                        string = this.S();
                                        break block5;
                                    }
                                    if (n2 != 8) break block6;
                                    c2 = '\'';
                                    break block7;
                                }
                                if (n2 != 9) break block8;
                                c2 = '\"';
                            }
                            string = this.Q(c2);
                            break block5;
                        }
                        if (n2 != 11) break block9;
                        string = this.o;
                        this.o = null;
                        break block5;
                    }
                    if (n2 != 15) break block10;
                    string = Long.toString((long)this.m);
                    break block5;
                }
                if (n2 != 16) break block11;
                string = new String(this.g, this.h, this.n);
                this.h += this.n;
            }
            this.l = 0;
            int[] arrn = this.s;
            int n3 = -1 + this.q;
            arrn[n3] = 1 + arrn[n3];
            return string;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected a string but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Exception decompiling
     */
    public final String S() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
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

    public b T() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        switch (n2) {
            default: {
                throw new AssertionError();
            }
            case 17: {
                return b.n;
            }
            case 15: 
            case 16: {
                return b.k;
            }
            case 12: 
            case 13: 
            case 14: {
                return b.i;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return b.j;
            }
            case 7: {
                return b.m;
            }
            case 5: 
            case 6: {
                return b.l;
            }
            case 4: {
                return b.f;
            }
            case 3: {
                return b.e;
            }
            case 2: {
                return b.h;
            }
            case 1: 
        }
        return b.g;
    }

    public final void U(int n2) {
        int n3 = this.q;
        int[] arrn = this.p;
        if (n3 == arrn.length) {
            int n4 = n3 * 2;
            this.p = Arrays.copyOf((int[])arrn, (int)n4);
            this.s = Arrays.copyOf((int[])this.s, (int)n4);
            this.r = (String[])Arrays.copyOf((Object[])this.r, (int)n4);
        }
        int[] arrn2 = this.p;
        int n5 = this.q;
        this.q = n5 + 1;
        arrn2[n5] = n2;
    }

    public final char V() {
        char c2;
        block7 : {
            int n2;
            block6 : {
                block8 : {
                    block9 : {
                        block10 : {
                            block11 : {
                                block12 : {
                                    block13 : {
                                        int n3;
                                        if (this.h == this.i && !this.s(1)) {
                                            this.Z("Unterminated escape sequence");
                                            throw null;
                                        }
                                        char[] arrc = this.g;
                                        int n4 = this.h;
                                        this.h = n2 = n4 + 1;
                                        c2 = arrc[n4];
                                        if (c2 == '\n') break block6;
                                        if (c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\') break block7;
                                        if (c2 == 'b') break block8;
                                        if (c2 == 'f') break block9;
                                        if (c2 == 'n') break block10;
                                        if (c2 == 'r') break block11;
                                        if (c2 == 't') break block12;
                                        if (c2 != 'u') break block13;
                                        if (n2 + 4 > this.i && !this.s(4)) {
                                            this.Z("Unterminated escape sequence");
                                            throw null;
                                        }
                                        char c3 = '\u0000';
                                        int n5 = n3 + 4;
                                        for (n3 = this.h; n3 < n5; ++n3) {
                                            block18 : {
                                                char c4;
                                                int n6;
                                                block15 : {
                                                    int n7;
                                                    block17 : {
                                                        char c5;
                                                        block16 : {
                                                            block14 : {
                                                                c5 = this.g[n3];
                                                                c4 = (char)(c3 << 4);
                                                                if (c5 < '0' || c5 > '9') break block14;
                                                                n6 = c5 - 48;
                                                                break block15;
                                                            }
                                                            if (c5 < 'a' || c5 > 'f') break block16;
                                                            n7 = c5 - 97;
                                                            break block17;
                                                        }
                                                        if (c5 < 'A' || c5 > 'F') break block18;
                                                        n7 = c5 - 65;
                                                    }
                                                    n6 = n7 + 10;
                                                }
                                                c3 = (char)(n6 + c4);
                                                continue;
                                            }
                                            StringBuilder stringBuilder = c.b.a.a.a.c("\\u");
                                            stringBuilder.append(new String(this.g, this.h, 4));
                                            throw new NumberFormatException(stringBuilder.toString());
                                        }
                                        this.h = 4 + this.h;
                                        return c3;
                                    }
                                    this.Z("Invalid escape sequence");
                                    throw null;
                                }
                                return '\t';
                            }
                            return '\r';
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            this.j = 1 + this.j;
            this.k = n2;
        }
        return c2;
    }

    public final void W(char c2) {
        char[] arrc = this.g;
        block0 : do {
            int n2 = this.h;
            int n3 = this.i;
            while (n2 < n3) {
                int n4 = n2 + 1;
                char c3 = arrc[n2];
                if (c3 == c2) {
                    this.h = n4;
                    return;
                }
                if (c3 == '\\') {
                    this.h = n4;
                    this.V();
                    continue block0;
                }
                if (c3 == '\n') {
                    this.j = 1 + this.j;
                    this.k = n4;
                }
                n2 = n4;
            }
            this.h = n2;
            if (!this.s(1)) break;
        } while (true);
        this.Z("Unterminated string");
        throw null;
    }

    public final void X() {
        while (this.h < this.i || this.s(1)) {
            int n2;
            char[] arrc = this.g;
            int n3 = this.h;
            this.h = n2 = n3 + 1;
            char c2 = arrc[n3];
            if (c2 == '\n') {
                this.j = 1 + this.j;
                this.k = n2;
                return;
            }
            if (c2 != '\r') continue;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void Y() {
        var1_1 = 0;
        do {
            block12 : {
                block14 : {
                    block17 : {
                        block15 : {
                            block16 : {
                                block13 : {
                                    block11 : {
                                        block10 : {
                                            block9 : {
                                                if ((var2_2 = this.l) == 0) {
                                                    var2_2 = this.j();
                                                }
                                                if (var2_2 != 3) break block9;
                                                this.U(1);
                                                break block10;
                                            }
                                            if (var2_2 != 1) break block11;
                                            this.U(3);
                                        }
                                        ++var1_1;
                                        break block12;
                                    }
                                    if (var2_2 != 4 && var2_2 != 2) break block13;
                                    --this.q;
                                    --var1_1;
                                    break block12;
                                }
                                if (var2_2 == 14 || var2_2 == 10) break block14;
                                if (var2_2 == 8 || var2_2 == 12) break block15;
                                if (var2_2 == 9 || var2_2 == 13) break block16;
                                if (var2_2 == 16) {
                                    this.h += this.n;
                                }
                                break block12;
                            }
                            var9_6 = 34;
                            break block17;
                        }
                        var9_6 = 39;
                    }
                    this.W((char)var9_6);
                    break block12;
                }
                block5 : do {
                    var3_3 = 0;
                    block6 : while ((var4_4 = var3_3 + this.h) < this.i) {
                        block18 : {
                            var8_5 = this.g[var4_4];
                            if (var8_5 == '\t' || var8_5 == '\n' || var8_5 == '\f' || var8_5 == '\r' || var8_5 == ' ') break block18;
                            if (var8_5 == '#') ** GOTO lbl-1000
                            if (var8_5 == ',') break block18;
                            if (var8_5 == '/' || var8_5 == '=') ** GOTO lbl-1000
                            if (var8_5 == '{' || var8_5 == '}' || var8_5 == ':') break block18;
                            if (var8_5 == ';') ** GOTO lbl-1000
                            switch (var8_5) {
                                default: {
                                    ++var3_3;
                                    continue block6;
                                }
                                case '\\': lbl-1000: // 4 sources:
                                {
                                    this.h();
                                }
                                case '[': 
                                case ']': 
                            }
                        }
                        this.h = var3_3 + this.h;
                        break block5;
                    }
                    this.h = var4_4;
                } while (this.s(1));
            }
            this.l = 0;
        } while (var1_1 != 0);
        var5_7 = this.s;
        var6_8 = this.q;
        var7_9 = var6_8 - 1;
        var5_7[var7_9] = 1 + var5_7[var7_9];
        this.r[var6_8 - 1] = "null";
    }

    public final IOException Z(String string) {
        StringBuilder stringBuilder = c.b.a.a.a.c(string);
        stringBuilder.append(this.B());
        throw new d(stringBuilder.toString());
    }

    public void c() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        if (n2 == 3) {
            this.U(1);
            this.s[this.q - 1] = 0;
            this.l = 0;
            return;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void close() {
        this.l = 0;
        this.p[0] = 8;
        this.q = 1;
        this.e.close();
    }

    public void f() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        if (n2 == 1) {
            this.U(3);
            this.l = 0;
            return;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void h() {
        if (this.f) {
            return;
        }
        this.Z("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int j() {
        block54 : {
            block44 : {
                block46 : {
                    block47 : {
                        block55 : {
                            block48 : {
                                block49 : {
                                    block50 : {
                                        block53 : {
                                            block51 : {
                                                block52 : {
                                                    block36 : {
                                                        block34 : {
                                                            block41 : {
                                                                block45 : {
                                                                    block38 : {
                                                                        block42 : {
                                                                            block43 : {
                                                                                block40 : {
                                                                                    block39 : {
                                                                                        block37 : {
                                                                                            block35 : {
                                                                                                var1_1 = this.p;
                                                                                                var2_2 = this.q;
                                                                                                var3_3 = var1_1[var2_2 - 1];
                                                                                                var4_4 = 1;
                                                                                                if (var3_3 != var4_4) break block35;
                                                                                                var1_1[var2_2 - var4_4] = 2;
                                                                                                break block36;
                                                                                            }
                                                                                            if (var3_3 != 2) break block37;
                                                                                            var56_5 = this.O((boolean)var4_4);
                                                                                            if (var56_5 != 44) {
                                                                                                if (var56_5 != 59) {
                                                                                                    if (var56_5 == 93) {
                                                                                                        this.l = 4;
                                                                                                        return 4;
                                                                                                    }
                                                                                                    this.Z("Unterminated array");
                                                                                                    throw null;
                                                                                                }
                                                                                                this.h();
                                                                                            }
                                                                                            break block36;
                                                                                        }
                                                                                        if (var3_3 == 3 || var3_3 == 5) break block38;
                                                                                        if (var3_3 != 4) break block39;
                                                                                        var1_1[var2_2 - var4_4] = 5;
                                                                                        var52_6 = this.O((boolean)var4_4);
                                                                                        if (var52_6 != 58) {
                                                                                            if (var52_6 != 61) {
                                                                                                this.Z("Expected ':'");
                                                                                                throw null;
                                                                                            }
                                                                                            this.h();
                                                                                            if ((this.h < this.i || this.s(var4_4)) && (var54_7 = this.g)[var55_8 = this.h] == '>') {
                                                                                                this.h = var55_8 + var4_4;
                                                                                            }
                                                                                        }
                                                                                        break block36;
                                                                                    }
                                                                                    if (var3_3 != 6) break block40;
                                                                                    if (!this.f) break block34;
                                                                                    this.O((boolean)var4_4);
                                                                                    this.h = var48_9 = this.h - var4_4;
                                                                                    var49_10 = a.t;
                                                                                    if (var48_9 + var49_10.length > this.i && !this.s(var49_10.length)) break block34;
                                                                                    break block41;
                                                                                }
                                                                                if (var3_3 != 7) break block42;
                                                                                if (this.O(false) != -1) break block43;
                                                                                var7_13 = 17;
                                                                                break block44;
                                                                            }
                                                                            this.h();
                                                                            this.h -= var4_4;
                                                                            break block36;
                                                                        }
                                                                        if (var3_3 == 8) throw new IllegalStateException("JsonReader is closed");
                                                                        break block36;
                                                                    }
                                                                    this.p[this.q - 1] = 4;
                                                                    if (var3_3 == 5) {
                                                                        var10_44 = this.O(true);
                                                                        if (var10_44 != 44) {
                                                                            if (var10_44 != 59) {
                                                                                if (var10_44 == 125) {
                                                                                    this.l = 2;
                                                                                    return 2;
                                                                                }
                                                                                this.Z("Unterminated object");
                                                                                throw null;
                                                                            }
                                                                            this.h();
                                                                        }
                                                                        var5_45 = 1;
                                                                    } else {
                                                                        var5_45 = 1;
                                                                    }
                                                                    var6_46 = this.O((boolean)var5_45);
                                                                    if (var6_46 == 34) break block45;
                                                                    if (var6_46 == 39) ** GOTO lbl84
                                                                    if (var6_46 != 125) {
                                                                        this.h();
                                                                        this.h -= var5_45;
                                                                        if (!this.x((char)var6_46)) {
                                                                            this.Z("Expected name");
                                                                            throw null;
                                                                        }
                                                                        var7_13 = 14;
                                                                    } else {
                                                                        if (var3_3 != 5) {
                                                                            this.l = 2;
                                                                            return 2;
                                                                        }
                                                                        this.Z("Expected name");
                                                                        throw null;
lbl84: // 1 sources:
                                                                        this.h();
                                                                        var7_13 = 12;
                                                                    }
                                                                    break block44;
                                                                }
                                                                var7_13 = 13;
                                                                break block44;
                                                            }
                                                            for (var50_11 = 0; var50_11 < (var51_12 = a.t).length; ++var50_11) {
                                                                if (this.g[var50_11 + this.h] == var51_12[var50_11]) {
                                                                    continue;
                                                                }
                                                                break block34;
                                                            }
                                                            this.h += var51_12.length;
                                                        }
                                                        this.p[this.q - var4_4] = 7;
                                                    }
                                                    var12_14 = this.O((boolean)var4_4);
                                                    if (var12_14 == 34) break block46;
                                                    if (var12_14 == 39) break block47;
                                                    if (var12_14 == 44 || var12_14 == 59) break block48;
                                                    if (var12_14 == 91) {
                                                        this.l = 3;
                                                        return 3;
                                                    }
                                                    if (var12_14 == 93) break block49;
                                                    if (var12_14 == 123) break block50;
                                                    this.h = var15_15 = this.h - var4_4;
                                                    var16_16 = this.g[var15_15];
                                                    if (var16_16 == 't' || var16_16 == 'T') break block51;
                                                    if (var16_16 == 'f' || var16_16 == 'F') break block52;
                                                    if (var16_16 != 'n' && var16_16 != 'N') ** GOTO lbl-1000
                                                    var17_17 = "null";
                                                    var18_18 = "NULL";
                                                    var19_19 = 7;
                                                    break block53;
                                                }
                                                var17_17 = "false";
                                                var18_18 = "FALSE";
                                                var19_19 = 6;
                                                break block53;
                                            }
                                            var17_17 = "true";
                                            var18_18 = "TRUE";
                                            var19_19 = 5;
                                        }
                                        var20_20 = var17_17.length();
                                        break block54;
                                    }
                                    var7_13 = var4_4;
                                    break block44;
                                }
                                var13_43 = var4_4;
                                if (var3_3 == var13_43) {
                                    this.l = 4;
                                    return 4;
                                }
                                break block55;
                            }
                            var13_43 = var4_4;
                        }
                        if (var3_3 != var13_43 && var3_3 != 2) {
                            this.Z("Unexpected value");
                            throw null;
                        }
                        this.h();
                        this.h -= var13_43;
                        var7_13 = 7;
                        break block44;
                    }
                    this.h();
                    var7_13 = 8;
                    break block44;
                }
                var7_13 = 9;
            }
lbl155: // 2 sources:
            do {
                this.l = var7_13;
                return var7_13;
                break;
            } while (true);
        }
        for (var21_21 = var4_4; var21_21 < var20_20; ++var21_21) {
            if (!(var21_21 + this.h >= this.i && !this.s(var21_21 + 1) || (var46_22 = this.g[var21_21 + this.h]) != var17_17.charAt(var21_21) && var46_22 != var18_18.charAt(var21_21))) {
                continue;
            }
            ** GOTO lbl-1000
        }
        if ((var20_20 + this.h < this.i || this.s(var20_20 + 1)) && this.x(this.g[var20_20 + this.h])) lbl-1000: // 3 sources:
        {
            var19_19 = 0;
        } else {
            this.h = var20_20 + this.h;
            this.l = var19_19;
        }
        if (var19_19 != 0) {
            return var19_19;
        }
        var22_23 = this.g;
        var23_24 = this.h;
        var24_25 = this.i;
        var25_26 = var4_4;
        var26_27 = 0;
        var27_28 = 0;
        var28_29 = false;
        var29_30 = 0L;
        block3 : do {
            block68 : {
                block71 : {
                    block60 : {
                        block61 : {
                            block72 : {
                                block62 : {
                                    block63 : {
                                        block70 : {
                                            block69 : {
                                                block59 : {
                                                    block64 : {
                                                        block67 : {
                                                            block65 : {
                                                                block66 : {
                                                                    block56 : {
                                                                        block57 : {
                                                                            block58 : {
                                                                                if (var23_24 + var26_27 != var24_25) break block56;
                                                                                if (var26_27 == var22_23.length) break block57;
                                                                                if (this.s(var26_27 + 1)) break block58;
                                                                                var36_41 = var26_27;
                                                                                break block59;
                                                                            }
                                                                            var23_24 = this.h;
                                                                            var24_25 = this.i;
                                                                            break block56;
                                                                        }
lbl189: // 8 sources:
                                                                        do {
                                                                            var34_40 = 0;
                                                                            break block3;
                                                                            break;
                                                                        } while (true);
                                                                    }
                                                                    if ((var31_31 = var22_23[var23_24 + var26_27]) == '+') break block60;
                                                                    if (var31_31 == 'E' || var31_31 == 'e') break block61;
                                                                    if (var31_31 == '-') break block62;
                                                                    if (var31_31 == '.') break block63;
                                                                    if (var31_31 < '0' || var31_31 > '9') break block64;
                                                                    if (var27_28 == var4_4 || var27_28 == 0) break block65;
                                                                    if (var27_28 != 2) break block66;
                                                                    if (var29_30 == 0L) ** GOTO lbl189
                                                                    var39_35 = 10L * var29_30;
                                                                    var41_36 = var31_31 - 48;
                                                                    var38_34 = var26_27;
                                                                    var42_37 = var39_35 - (long)var41_36;
                                                                    var44_38 = var29_30 LCMP -922337203685477580L;
                                                                    var45_39 = var44_38 <= 0 && (var44_38 != false || var42_37 >= var29_30) ? 0 : 1;
                                                                    var25_26 &= var45_39;
                                                                    var29_30 = var42_37;
                                                                    break block67;
                                                                }
                                                                var38_34 = var26_27;
                                                                if (var27_28 == 3) {
                                                                    var27_28 = 4;
                                                                } else if (var27_28 == 5 || var27_28 == 6) {
                                                                    var27_28 = 7;
                                                                }
                                                                break block67;
                                                            }
                                                            var38_34 = var26_27;
                                                            var29_30 = -(var31_31 - 48);
                                                            var27_28 = 2;
                                                        }
                                                        var32_32 = var38_34;
                                                        break block68;
                                                    }
                                                    var36_41 = var26_27;
                                                    if (this.x(var31_31)) ** GOTO lbl189
                                                }
                                                if (var27_28 != 2 || var25_26 == 0 || var29_30 == Long.MIN_VALUE && !var28_29 || var29_30 == 0L && var28_29) break block69;
                                                if (!var28_29) {
                                                    var29_30 = -var29_30;
                                                }
                                                this.m = var29_30;
                                                this.h = var36_41 + this.h;
                                                var37_42 = 15;
                                                break block70;
                                            }
                                            if (var27_28 != 2 && var27_28 != 4 && var27_28 != 7) ** GOTO lbl189
                                            this.n = var36_41;
                                            var37_42 = 16;
                                        }
                                        this.l = var34_40 = var37_42;
                                        break;
                                    }
                                    var32_32 = var26_27;
                                    if (var27_28 != 2) ** GOTO lbl189
                                    var33_33 = 3;
                                    break block71;
                                }
                                var32_32 = var26_27;
                                var33_33 = 6;
                                if (var27_28 != 0) break block72;
                                var27_28 = 1;
                                var28_29 = true;
                                break block68;
                            }
                            if (var27_28 != 5) ** GOTO lbl189
                            break block71;
                        }
                        var32_32 = var26_27;
                        if (var27_28 != 2 && var27_28 != 4) ** GOTO lbl189
                        var27_28 = 5;
                        break block68;
                    }
                    var32_32 = var26_27;
                    if (var27_28 != 5) ** continue;
                    var33_33 = 6;
                }
                var27_28 = var33_33;
            }
            var26_27 = var32_32 + 1;
            var4_4 = 1;
        } while (true);
        if (var34_40 != 0) {
            return var34_40;
        }
        if (!this.x(this.g[this.h])) {
            this.Z("Expected value");
            throw null;
        }
        this.h();
        var7_13 = 10;
        ** while (true)
    }

    public void m() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        if (n2 == 4) {
            int n3;
            this.q = n3 = -1 + this.q;
            int[] arrn = this.s;
            int n4 = n3 - 1;
            arrn[n4] = 1 + arrn[n4];
            this.l = 0;
            return;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void p() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        if (n2 == 2) {
            int n3;
            this.q = n3 = -1 + this.q;
            this.r[n3] = null;
            int[] arrn = this.s;
            int n4 = n3 - 1;
            arrn[n4] = 1 + arrn[n4];
            this.l = 0;
            return;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final boolean s(int n2) {
        Reader reader;
        int n3;
        int n4;
        char[] arrc = this.g;
        int n5 = this.k;
        int n6 = this.h;
        this.k = n5 - n6;
        int n7 = this.i;
        if (n7 != n6) {
            int n8;
            this.i = n8 = n7 - n6;
            System.arraycopy((Object)arrc, (int)n6, (Object)arrc, (int)0, (int)n8);
        } else {
            this.i = 0;
        }
        this.h = 0;
        while ((n4 = (reader = this.e).read(arrc, n3 = this.i, arrc.length - n3)) != -1) {
            int n9;
            int n10;
            this.i = n10 = n4 + this.i;
            if (this.j == 0 && (n9 = this.k) == 0 && n10 > 0 && arrc[0] == '\ufeff') {
                this.h = 1 + this.h;
                this.k = n9 + 1;
                ++n2;
            }
            if (this.i < n2) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(this.B());
        return stringBuilder.toString();
    }

    public String u() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        int n2 = this.q;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.p[i2];
            if (n3 != 1 && n3 != 2) {
                if (n3 != 3 && n3 != 4 && n3 != 5) continue;
                stringBuilder.append('.');
                String[] arrstring = this.r;
                if (arrstring[i2] == null) continue;
                stringBuilder.append(arrstring[i2]);
                continue;
            }
            stringBuilder.append('[');
            stringBuilder.append(this.s[i2]);
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    public boolean v() {
        int n2 = this.l;
        if (n2 == 0) {
            n2 = this.j();
        }
        return n2 != 2 && n2 != 4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean x(char var1_1) {
        if (var1_1 == '\t') return false;
        if (var1_1 == '\n') return false;
        if (var1_1 == '\f') return false;
        if (var1_1 == '\r') return false;
        if (var1_1 == ' ') return false;
        if (var1_1 == '#') ** GOTO lbl-1000
        if (var1_1 == ',') return false;
        if (var1_1 == '/' || var1_1 == '=') ** GOTO lbl-1000
        if (var1_1 == '{') return false;
        if (var1_1 == '}') return false;
        if (var1_1 == ':') return false;
        if (var1_1 == ';') ** GOTO lbl-1000
        switch (var1_1) {
            default: {
                return true;
            }
            case '\\': lbl-1000: // 4 sources:
            {
                this.h();
            }
            case '[': 
            case ']': 
        }
        return false;
    }
}

