/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.RealmFieldType
 *  io.realm.internal.OsObjectSchemaInfo
 *  io.realm.internal.Property
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package g.a.p0;

import io.realm.RealmFieldType;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.Property;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class c {
    public final Map<String, a> a;
    public final Map<String, a> b;
    public final Map<String, String> c;
    public final boolean d;

    public c(int n2, boolean bl) {
        this.a = new HashMap(n2);
        this.b = new HashMap(n2);
        this.c = new HashMap(n2);
        this.d = bl;
    }

    public final long a(String string, String string2, OsObjectSchemaInfo osObjectSchemaInfo) {
        Property property = new Property(OsObjectSchemaInfo.nativeGetProperty((long)osObjectSchemaInfo.e, (String)string2));
        a a2 = new a(property);
        this.a.put((Object)string, (Object)a2);
        this.b.put((Object)string2, (Object)a2);
        this.c.put((Object)string, (Object)string2);
        return Property.nativeGetColumnKey((long)property.e);
    }

    public abstract void b(c var1, c var2);

    public void c(c c2) {
        if (this.d) {
            if (c2 != null) {
                this.a.clear();
                this.a.putAll(c2.a);
                this.b.clear();
                this.b.putAll(c2.b);
                this.c.clear();
                this.c.putAll(c2.c);
                this.b(c2, this);
                return;
            }
            throw new NullPointerException("Attempt to copy null ColumnInfo");
        }
        throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
    }

    public a d(String string) {
        return (a)this.a.get((Object)string);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ColumnInfo[");
        StringBuilder stringBuilder2 = c.b.a.a.a.c("mutable=");
        stringBuilder2.append(this.d);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(",");
        Map<String, a> map = this.a;
        boolean bl = false;
        if (map != null) {
            stringBuilder.append("JavaFieldNames=[");
            Iterator iterator = this.a.entrySet().iterator();
            boolean bl2 = false;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                if (bl2) {
                    stringBuilder.append(",");
                }
                stringBuilder.append((String)entry.getKey());
                stringBuilder.append("->");
                stringBuilder.append(entry.getValue());
                bl2 = true;
            }
            stringBuilder.append("]");
        }
        if (this.b != null) {
            stringBuilder.append(", InternalFieldNames=[");
            for (Map.Entry entry : this.b.entrySet()) {
                if (bl) {
                    stringBuilder.append(",");
                }
                stringBuilder.append((String)entry.getKey());
                stringBuilder.append("->");
                stringBuilder.append(entry.getValue());
                bl = true;
            }
            stringBuilder.append("]");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static final class a {
        public final long a;
        public final RealmFieldType b;
        public final String c;

        /*
         * Exception decompiling
         */
        public a(Property var1_1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 10[SWITCH]
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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
            StringBuilder stringBuilder = new StringBuilder("ColumnDetails[");
            stringBuilder.append(this.a);
            stringBuilder.append(", ");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(", ");
            return c.b.a.a.a.l(stringBuilder, this.c, "]");
        }
    }

}

