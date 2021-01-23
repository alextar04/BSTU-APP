/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.x
 *  g.a.z$a
 *  g.a.z$d
 *  io.realm.internal.OsObjectStore
 *  io.realm.internal.OsRealmConfig
 *  io.realm.internal.OsRealmConfig$a
 *  io.realm.internal.OsSchemaInfo
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.OsSharedRealm$InitializationCallback
 *  io.realm.internal.OsSharedRealm$MigrationCallback
 *  io.realm.internal.OsSharedRealm$a
 *  io.realm.internal.Util
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
package g.a;

import g.a.b0;
import g.a.d0;
import g.a.i;
import g.a.p0.j;
import g.a.x;
import g.a.y;
import g.a.z;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Util;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis.
 */
public final class z {
    public static final List<WeakReference<z>> e;
    public static final Collection<z> f;
    public final Map<g.a.p0.a0.a<b, OsSharedRealm.a>, c> a;
    public final String b;
    public b0 c;
    public final AtomicBoolean d;

    public static {
        e = new ArrayList();
        f = new ConcurrentLinkedQueue();
    }

    public z(String string) {
        this.a = new HashMap();
        this.d = new AtomicBoolean(false);
        this.b = string;
    }

    /*
     * Exception decompiling
     */
    public static void a(String var0, File var1) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <E extends g.a.a> E b(b0 b02, Class<E> class_) {
        String string = b02.c;
        int n2 = 1;
        z z2 = z.c(string, (boolean)n2);
        OsSharedRealm.a a2 = OsSharedRealm.a.g;
        z z3 = z2;
        synchronized (z3) {
            c c2 = z2.d(class_, a2);
            int n3 = z2.e() == 0 ? n2 : 0;
            boolean bl = n2 ^ b02.f();
            if (n3 != 0) {
                File file = n2 ^ Util.d((String)b02.d) ? new File(b02.a, b02.b) : null;
                String string2 = j.getFacade(b02.e()).getSyncServerCertificateAssetName(b02);
                boolean bl2 = n2 ^ Util.d((String)string2);
                if (file != null || bl2) {
                    y y2 = new y(file, b02, bl2, string2);
                    OsObjectStore.nativeCallWithLock((String)b02.c, (Runnable)y2);
                }
                if (b02.e() && bl) {
                    OsRealmConfig osRealmConfig = new OsRealmConfig(b02, "", false, null, null, null, null);
                    j.getSyncFacadeIfPossible().wrapObjectStoreSessionIfRequired(osRealmConfig);
                    j.getSyncFacadeIfPossible().downloadInitialRemoteChanges(b02);
                }
                z2.c = b02;
            } else {
                z2.f(b02);
            }
            if (!c2.d()) {
                Object object;
                if (class_ == x.class) {
                    object = new x(z2, a2);
                } else {
                    if (class_ != i.class) {
                        throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
                    }
                    object = new i(z2, a2);
                }
                c2.e((g.a.a)object);
            }
            Integer n4 = (Integer)c2.a.get();
            ThreadLocal<Integer> threadLocal = c2.a;
            if (n4 != null) {
                n2 += n4.intValue();
            }
            threadLocal.set((Object)n2);
            g.a.a a3 = c2.b();
            return (E)a3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static z c(String string, boolean bl) {
        List<WeakReference<z>> list;
        List<WeakReference<z>> list2 = list = e;
        synchronized (list2) {
            Iterator iterator = e.iterator();
            z z2 = null;
            while (iterator.hasNext()) {
                z z3 = (z)((WeakReference)iterator.next()).get();
                if (z3 == null) {
                    iterator.remove();
                    continue;
                }
                if (!z3.b.equals((Object)string)) continue;
                z2 = z3;
            }
            if (z2 == null && bl) {
                z2 = new z(string);
                e.add((Object)new WeakReference((Object)z2));
            }
            return z2;
        }
    }

    public final <E extends g.a.a> c d(Class<E> class_, OsSharedRealm.a a2) {
        block6 : {
            b b2;
            block5 : {
                block4 : {
                    if (class_ != x.class) break block4;
                    b2 = b.e;
                    break block5;
                }
                if (class_ != i.class) break block6;
                b2 = b.f;
            }
            g.a.p0.a0.a<b, OsSharedRealm.a> a3 = new g.a.p0.a0.a<b, OsSharedRealm.a>(b2, a2);
            c c2 = (c)this.a.get(a3);
            if (c2 == null) {
                c2 = a2.equals((Object)OsSharedRealm.a.g) ? new /* Unavailable Anonymous Inner Class!! */ : new /* Unavailable Anonymous Inner Class!! */;
                this.a.put(a3, (Object)c2);
            }
            return c2;
        }
        throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
    }

    public final int e() {
        Iterator iterator = this.a.values().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((c)iterator.next()).b.get();
        }
        return n2;
    }

    public final void f(b0 b02) {
        if (this.c.equals(b02)) {
            return;
        }
        if (Arrays.equals((byte[])this.c.b(), (byte[])b02.b())) {
            d0 d02 = b02.g;
            d0 d03 = this.c.g;
            if (d03 != null && d02 != null && d03.getClass().equals((Object)d02.getClass()) && !d02.equals((Object)d03)) {
                StringBuilder stringBuilder = c.b.a.a.a.c("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: ");
                stringBuilder.append(b02.g.getClass().getCanonicalName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("Configurations cannot be different if used to open the same file. \nCached configuration: \n");
            stringBuilder.append((Object)this.c);
            stringBuilder.append("\n\nNew configuration: \n");
            stringBuilder.append((Object)b02);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("Wrong key used to decrypt Realm.");
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b e;
        public static final /* enum */ b f;
        public static final /* synthetic */ b[] g;

        public static {
            b b2;
            e = new b();
            f = b2 = new b();
            b[] arrb = new b[]{e, b2};
            g = arrb;
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])g.clone();
        }
    }

    public static abstract class c {
        public final ThreadLocal<Integer> a = new ThreadLocal();
        public AtomicInteger b = new AtomicInteger(0);

        public c() {
        }

        public c(y y2) {
        }

        public abstract void a();

        public abstract g.a.a b();

        public abstract int c();

        public abstract boolean d();

        public abstract void e(g.a.a var1);
    }

}

