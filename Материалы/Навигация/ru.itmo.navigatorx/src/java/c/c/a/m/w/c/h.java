/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.charset.Charset
 */
package c.c.a.m.w.c;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import f.b.k.h;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class h
implements ImageHeaderParser {
    public static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName((String)"UTF-8"));
    public static final int[] b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        h.i.p(byteBuffer, "Argument must not be null");
        return this.d(new a(byteBuffer));
    }

    /*
     * Exception decompiling
     */
    public int b(InputStream var1, c.c.a.m.u.c0.b var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl98.1 : ICONST_M1 : trying to set 1 previously set to 0
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

    public ImageHeaderParser.ImageType c(InputStream inputStream) {
        h.i.p(inputStream, "Argument must not be null");
        return this.d(new d(inputStream));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final ImageHeaderParser.ImageType d(c var1_1) {
        var2_2 = var1_1.c();
        if (var2_2 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        var3_3 = var2_2 << 8 | var1_1.e();
        if (var3_3 == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        var4_4 = var3_3 << 8 | var1_1.e();
        if (var4_4 != -1991225785) ** GOTO lbl19
        var1_1.b(21L);
        {
            catch (a v0) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
        }
        try {
            if (var1_1.e() < 3) return ImageHeaderParser.ImageType.PNG;
            return ImageHeaderParser.ImageType.PNG_A;
        }
        catch (a v1) {
            return ImageHeaderParser.ImageType.PNG;
lbl19: // 1 sources:
            if (var4_4 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            var1_1.b(4L);
            if ((var1_1.c() << 16 | var1_1.c()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            var10_6 = var1_1.c() << 16 | var1_1.c();
            if ((var10_6 & -256) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            var11_7 = var10_6 & 255;
            if (var11_7 == 88) {
                var1_1.b(4L);
                if ((16 & var1_1.e()) == 0) return ImageHeaderParser.ImageType.WEBP;
                return ImageHeaderParser.ImageType.WEBP_A;
            }
            if (var11_7 != 76) return ImageHeaderParser.ImageType.WEBP;
            var1_1.b(4L);
            if ((8 & var1_1.e()) == 0) return ImageHeaderParser.ImageType.WEBP;
            return ImageHeaderParser.ImageType.WEBP_A;
        }
    }

    public final int e(c c2) {
        int n2;
        block7 : {
            short s2;
            long l2;
            long l3;
            do {
                short s3;
                if ((s3 = c2.e()) != 255) {
                    if (Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown segmentId=");
                        stringBuilder.append((int)s3);
                        Log.d((String)"DfltImageHeaderParser", (String)stringBuilder.toString());
                    }
                    return -1;
                }
                s2 = c2.e();
                if (s2 == 218) {
                    return -1;
                }
                if (s2 == 217) {
                    if (Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) {
                        Log.d((String)"DfltImageHeaderParser", (String)"Found MARKER_EOI in exif segment");
                    }
                    return -1;
                }
                n2 = -2 + c2.c();
                if (s2 == 225) break block7;
            } while ((l2 = c2.b(l3 = (long)n2)) == l3);
            if (Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to skip enough data, type: ");
                stringBuilder.append((int)s2);
                stringBuilder.append(", wanted to skip: ");
                stringBuilder.append(n2);
                stringBuilder.append(", but actually skipped: ");
                stringBuilder.append(l2);
                Log.d((String)"DfltImageHeaderParser", (String)stringBuilder.toString());
            }
            return -1;
        }
        return n2;
    }

    public final int f(c c2, byte[] arrby, int n2) {
        block14 : {
            ByteOrder byteOrder;
            int n3 = c2.d(arrby, n2);
            if (n3 != n2) {
                if (Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to read exif segment data, length: ");
                    stringBuilder.append(n2);
                    stringBuilder.append(", actually read: ");
                    stringBuilder.append(n3);
                    Log.d((String)"DfltImageHeaderParser", (String)stringBuilder.toString());
                }
                return -1;
            }
            int n4 = 0;
            boolean bl = arrby != null && n2 > a.length;
            if (bl) {
                byte[] arrby2;
                for (int i2 = 0; i2 < (arrby2 = a).length; ++i2) {
                    if (arrby[i2] == arrby2[i2]) continue;
                    bl = false;
                    break;
                }
            }
            if (!bl) break block14;
            Object object = new Object(arrby, n2){
                public final ByteBuffer a;
                {
                    this.a = (ByteBuffer)ByteBuffer.wrap((byte[])arrby).order(ByteOrder.BIG_ENDIAN).limit(n2);
                }

                public short a(int n2) {
                    boolean bl = this.a.remaining() - n2 >= 2;
                    if (bl) {
                        return this.a.getShort(n2);
                    }
                    return -1;
                }

                public int b(int n2) {
                    boolean bl = this.a.remaining() - n2 >= 4;
                    if (bl) {
                        return this.a.getInt(n2);
                    }
                    return -1;
                }
            };
            short s2 = object.a(6);
            if (s2 != 18761) {
                if (s2 != 19789 && Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown endianness = ");
                    stringBuilder.append((int)s2);
                    Log.d((String)"DfltImageHeaderParser", (String)stringBuilder.toString());
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            object.a.order(byteOrder);
            int n5 = 6 + object.b(10);
            int n6 = object.a(n5);
            while (n4 < n6) {
                block15 : {
                    String string;
                    block18 : {
                        short s3;
                        String string2;
                        StringBuilder stringBuilder;
                        block20 : {
                            block16 : {
                                int n7;
                                short s4;
                                block21 : {
                                    int n8;
                                    int n9;
                                    block19 : {
                                        int n10;
                                        block17 : {
                                            n9 = n5 + 2 + n4 * 12;
                                            s4 = object.a(n9);
                                            if (s4 != 274) break block15;
                                            s3 = object.a(n9 + 2);
                                            if (s3 < 1 || s3 > 12) break block16;
                                            n10 = object.b(n9 + 4);
                                            if (n10 >= 0) break block17;
                                            if (!Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) break block15;
                                            string = "Negative tiff component count";
                                            break block18;
                                        }
                                        if (Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) {
                                            StringBuilder stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("Got tagIndex=");
                                            stringBuilder2.append(n4);
                                            stringBuilder2.append(" tagType=");
                                            stringBuilder2.append((int)s4);
                                            stringBuilder2.append(" formatCode=");
                                            stringBuilder2.append((int)s3);
                                            stringBuilder2.append(" componentCount=");
                                            stringBuilder2.append(n10);
                                            Log.d((String)"DfltImageHeaderParser", (String)stringBuilder2.toString());
                                        }
                                        if ((n8 = n10 + b[s3]) <= 4) break block19;
                                        if (!Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) break block15;
                                        stringBuilder = new StringBuilder();
                                        string2 = "Got byte count > 4, not orientation, continuing, formatCode=";
                                        break block20;
                                    }
                                    n7 = n9 + 8;
                                    if (n7 < 0 || n7 > object.a.remaining()) break block21;
                                    if (n8 >= 0 && n8 + n7 <= object.a.remaining()) {
                                        return object.a(n7);
                                    }
                                    if (!Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) break block15;
                                    string = c.b.a.a.a.b("Illegal number of bytes for TI tag data tagType=", s4);
                                    break block18;
                                }
                                if (!Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) break block15;
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("Illegal tagValueOffset=");
                                stringBuilder3.append(n7);
                                stringBuilder3.append(" tagType=");
                                stringBuilder3.append((int)s4);
                                string = stringBuilder3.toString();
                                break block18;
                            }
                            if (!Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) break block15;
                            stringBuilder = new StringBuilder();
                            string2 = "Got invalid format code = ";
                        }
                        stringBuilder.append(string2);
                        stringBuilder.append((int)s3);
                        string = stringBuilder.toString();
                    }
                    Log.d((String)"DfltImageHeaderParser", (String)string);
                }
                ++n4;
            }
            return -1;
        }
        if (Log.isLoggable((String)"DfltImageHeaderParser", (int)3)) {
            Log.d((String)"DfltImageHeaderParser", (String)"Missing jpeg exif preamble");
        }
        return -1;
    }

    public static final class a
    implements c {
        public final ByteBuffer a;

        public a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override
        public long b(long l2) {
            int n2 = (int)Math.min((long)this.a.remaining(), (long)l2);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(n2 + byteBuffer.position());
            return n2;
        }

        @Override
        public int c() {
            return this.e() << 8 | this.e();
        }

        @Override
        public int d(byte[] arrby, int n2) {
            int n3 = Math.min((int)n2, (int)this.a.remaining());
            if (n3 == 0) {
                return -1;
            }
            this.a.get(arrby, 0, n3);
            return n3;
        }

        @Override
        public short e() {
            if (this.a.remaining() >= 1) {
                return (short)(255 & this.a.get());
            }
            throw new a();
        }
    }

    public static final class d
    implements c {
        public final InputStream a;

        public d(InputStream inputStream) {
            this.a = inputStream;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public long b(long l2) {
            if (l2 < 0L) {
                return 0L;
            }
            long l3 = l2;
            while (l3 > 0L) {
                long l4 = this.a.skip(l3);
                if (l4 <= 0L) {
                    if (this.a.read() == -1) {
                        return l2 - l3;
                    }
                    l4 = 1L;
                }
                l3 -= l4;
            }
            return l2 - l3;
        }

        @Override
        public int c() {
            return this.e() << 8 | this.e();
        }

        @Override
        public int d(byte[] arrby, int n2) {
            int n3;
            int n4 = 0;
            for (n3 = 0; n3 < n2 && (n4 = this.a.read(arrby, n3, n2 - n3)) != -1; n3 += n4) {
            }
            if (n3 == 0) {
                if (n4 != -1) {
                    return n3;
                }
                throw new a();
            }
            return n3;
        }

        @Override
        public short e() {
            int n2 = this.a.read();
            if (n2 != -1) {
                return (short)n2;
            }
            throw new a();
        }
    }

}

