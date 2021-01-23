/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.ParsePosition
 *  java.util.Date
 *  java.util.TimeZone
 */
package c.e.b.c0.z.t;

import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

public class a {
    public static final TimeZone a = TimeZone.getTimeZone((String)"UTC");

    public static boolean a(String string, int n2, char c2) {
        return n2 < string.length() && string.charAt(n2) == c2;
    }

    /*
     * Exception decompiling
     */
    public static Date b(String var0, ParsePosition var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 9[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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
    public static int c(String string, int n2, int n3) {
        if (n2 >= 0 && n3 <= string.length() && n2 <= n3) {
            int n4;
            int n5;
            if (n2 < n3) {
                n4 = n2 + 1;
                int n6 = Character.digit((char)string.charAt(n2), (int)10);
                if (n6 < 0) {
                    StringBuilder stringBuilder = c.b.a.a.a.c("Invalid number: ");
                    stringBuilder.append(string.substring(n2, n3));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n5 = -n6;
            } else {
                n5 = 0;
                n4 = n2;
            }
            do {
                if (n4 >= n3) {
                    return -n5;
                }
                int n7 = n4 + 1;
                int n8 = Character.digit((char)string.charAt(n4), (int)10);
                if (n8 < 0) {
                    StringBuilder stringBuilder = c.b.a.a.a.c("Invalid number: ");
                    stringBuilder.append(string.substring(n2, n3));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n5 = n5 * 10 - n8;
                n4 = n7;
            } while (true);
        }
        throw new NumberFormatException(string);
    }
}

