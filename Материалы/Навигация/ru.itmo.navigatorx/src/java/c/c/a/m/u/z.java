/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Object
 */
package c.c.a.m.u;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.c.a.m.u.w;

public class z {
    public boolean a;
    public final Handler b = new Handler(Looper.getMainLooper(), (Handler.Callback)new a());

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(w<?> w2, boolean bl) {
        z z2 = this;
        synchronized (z2) {
            if (!this.a && !bl) {
                this.a = true;
                w2.e();
                this.a = false;
            } else {
                this.b.obtainMessage(1, w2).sendToTarget();
            }
            return;
        }
    }

    public static final class a
    implements Handler.Callback {
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((w)message.obj).e();
                return true;
            }
            return false;
        }
    }

}

