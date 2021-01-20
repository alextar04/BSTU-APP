/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.NativeObjectReference
 *  io.realm.log.RealmLog
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 */
package g.a.p0;

import g.a.p0.i;
import io.realm.internal.NativeObjectReference;
import io.realm.log.RealmLog;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class e
implements Runnable {
    public final ReferenceQueue<i> e;

    public e(ReferenceQueue<i> referenceQueue) {
        this.e = referenceQueue;
    }

    public void run() {
        try {
            do {
                ((NativeObjectReference)this.e.remove()).a();
            } while (true);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            RealmLog.d((int)7, null, (String)"The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore", (Object[])new Object[0]);
            return;
        }
    }
}

