/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.text.DateFormat
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.List
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package i;

import i.f0.c;
import i.f0.f.d;
import i.q;
import i.r;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j {
    public static final Pattern j = Pattern.compile((String)"(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile((String)"(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile((String)"(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile((String)"(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public j(String string, String string2, long l2, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.a = string;
        this.b = string2;
        this.c = l2;
        this.d = string3;
        this.e = string4;
        this.f = bl;
        this.g = bl2;
        this.i = bl3;
        this.h = bl4;
    }

    public static int a(String string, int n2, int n3, boolean bl) {
        while (n2 < n3) {
            char c2 = string.charAt(n2);
            boolean bl2 = c2 < ' ' && c2 != '\t' || c2 >= '' || c2 >= '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 == ':';
            if (bl2 == (bl ^ true)) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    /*
     * Exception decompiling
     */
    public static List<j> b(r var0, q var1) {
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

    public static long c(String string, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9 = j.a(string, n2, n3, false);
        Matcher matcher = m.matcher((CharSequence)string);
        int n10 = n4 = (n8 = (n7 = (n6 = (n5 = -1))));
        while (n9 < n3) {
            int n11 = j.a(string, n9 + 1, n3, true);
            matcher.region(n9, n11);
            if (n6 == -1 && matcher.usePattern(m).matches()) {
                n6 = Integer.parseInt((String)matcher.group(1));
                n4 = Integer.parseInt((String)matcher.group(2));
                n10 = Integer.parseInt((String)matcher.group(3));
            } else if (n7 == -1 && matcher.usePattern(l).matches()) {
                n7 = Integer.parseInt((String)matcher.group(1));
            } else if (n8 == -1 && matcher.usePattern(k).matches()) {
                String string2 = matcher.group(1).toLowerCase(Locale.US);
                n8 = k.pattern().indexOf(string2) / 4;
            } else if (n5 == -1 && matcher.usePattern(j).matches()) {
                n5 = Integer.parseInt((String)matcher.group(1));
            }
            n9 = j.a(string, n11 + 1, n3, false);
        }
        if (n5 >= 70 && n5 <= 99) {
            n5 += 1900;
        }
        if (n5 >= 0 && n5 <= 69) {
            n5 += 2000;
        }
        if (n5 >= 1601) {
            if (n8 != -1) {
                if (n7 >= 1 && n7 <= 31) {
                    if (n6 >= 0 && n6 <= 23) {
                        if (n4 >= 0 && n4 <= 59) {
                            if (n10 >= 0 && n10 <= 59) {
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(c.n);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, n5);
                                gregorianCalendar.set(2, n8 - 1);
                                gregorianCalendar.set(5, n7);
                                gregorianCalendar.set(11, n6);
                                gregorianCalendar.set(12, n4);
                                gregorianCalendar.set(13, n10);
                                gregorianCalendar.set(14, 0);
                                return gregorianCalendar.getTimeInMillis();
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object object) {
        if (!(object instanceof j)) {
            return false;
        }
        j j2 = (j)object;
        boolean bl = j2.a.equals((Object)this.a);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = j2.b.equals((Object)this.b);
            bl2 = false;
            if (bl3) {
                boolean bl4 = j2.d.equals((Object)this.d);
                bl2 = false;
                if (bl4) {
                    boolean bl5 = j2.e.equals((Object)this.e);
                    bl2 = false;
                    if (bl5) {
                        long l2 = j2.c LCMP this.c;
                        bl2 = false;
                        if (l2 == false) {
                            boolean bl6 = j2.f;
                            boolean bl7 = this.f;
                            bl2 = false;
                            if (bl6 == bl7) {
                                boolean bl8 = j2.g;
                                boolean bl9 = this.g;
                                bl2 = false;
                                if (bl8 == bl9) {
                                    boolean bl10 = j2.h;
                                    boolean bl11 = this.h;
                                    bl2 = false;
                                    if (bl10 == bl11) {
                                        boolean bl12 = j2.i;
                                        boolean bl13 = this.i;
                                        bl2 = false;
                                        if (bl12 == bl13) {
                                            bl2 = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.d.hashCode()) + this.e.hashCode());
        long l2 = this.c;
        return 31 * (31 * (31 * (31 * (n2 + (int)(l2 ^ l2 >>> 32)) + (true ^ this.f)) + (true ^ this.g)) + (true ^ this.h)) + (true ^ this.i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append('=');
        stringBuilder.append(this.b);
        if (this.h) {
            String string;
            if (this.c == Long.MIN_VALUE) {
                string = "; max-age=0";
            } else {
                stringBuilder.append("; expires=");
                Date date = new Date(this.c);
                string = ((DateFormat)d.a.get()).format(date);
            }
            stringBuilder.append(string);
        }
        if (!this.i) {
            stringBuilder.append("; domain=");
            stringBuilder.append(this.d);
        }
        stringBuilder.append("; path=");
        stringBuilder.append(this.e);
        if (this.f) {
            stringBuilder.append("; secure");
        }
        if (this.g) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }
}

