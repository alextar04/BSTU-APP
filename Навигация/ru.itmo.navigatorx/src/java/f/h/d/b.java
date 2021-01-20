/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
package f.h.d;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class b {
    public static final Class<?> a;
    public static final Field b;
    public static final Field c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Handler g;

    /*
     * Exception decompiling
     */
    public static {
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

    public static boolean a() {
        int n2 = Build.VERSION.SDK_INT;
        return n2 == 26 || n2 == 27;
        {
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean b(Activity activity) {
        c c2;
        Application application;
        block11 : {
            Object object2;
            Object object;
            if (Build.VERSION.SDK_INT >= 28) {
                activity.recreate();
                return true;
            }
            if (b.a() && f == null) {
                return false;
            }
            if (e == null && d == null) {
                return false;
            }
            try {
                object = c.get((Object)activity);
                if (object == null) {
                    return false;
                }
                object2 = b.get((Object)activity);
                if (object2 == null) {
                    return false;
                }
                application = activity.getApplication();
                c2 = new c(activity);
                application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)c2);
                g.post(new Runnable(){

                    public void run() {
                        c.this.a = object;
                    }
                });
            }
            catch (Throwable throwable) {
                return false;
            }
            if (b.a()) {
                Method method = f;
                Object[] arrobject = new Object[]{object, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE};
                method.invoke(object2, arrobject);
                break block11;
            }
            activity.recreate();
            {
                catch (Throwable throwable) {
                    g.post(new Runnable(c2){
                        public final /* synthetic */ c f;
                        {
                            this.f = c2;
                        }

                        public void run() {
                            Application.this.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.f);
                        }
                    });
                    throw throwable;
                }
            }
        }
        g.post(new /* invalid duplicate definition of identical inner class */);
        return true;
    }

    public static final class c
    implements Application.ActivityLifecycleCallbacks {
        public Object a;
        public Activity b;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;

        public c(Activity activity) {
            this.b = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.b == activity) {
                this.b = null;
                this.d = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.d && !this.e && !this.c) {
                Object object;
                boolean bl;
                block5 : {
                    Object object2 = this.a;
                    bl = false;
                    object = b.c.get((Object)activity);
                    if (object == object2) break block5;
                    bl = false;
                }
                try {
                    Object object3 = b.b.get((Object)activity);
                    b.g.postAtFrontOfQueue((Runnable)new f.h.d.c(object3, object));
                    bl = true;
                }
                catch (Throwable throwable) {
                    Log.e((String)"ActivityRecreator", (String)"Exception while fetching field values", (Throwable)throwable);
                }
                if (bl) {
                    this.e = true;
                    this.a = null;
                }
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.b == activity) {
                this.c = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

}

