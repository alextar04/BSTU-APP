/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package c.e.a.a.g0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class e {
    public static e c;
    public final Object a = new Object();
    public final Handler b = new Handler(Looper.getMainLooper(), new Handler.Callback(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean handleMessage(Message message) {
            Object object;
            if (message.what != 0) {
                return false;
            }
            e e2 = e.this;
            c c2 = (c)message.obj;
            Object object2 = object = e2.a;
            synchronized (object2) {
                b b2;
                if (c2 == null && (b2 = (b)c2.a.get()) != null) {
                    e2.b.removeCallbacksAndMessages((Object)c2);
                    b2.a(2);
                }
                return true;
            }
        }
    });

    public static interface b {
        public void a(int var1);
    }

    public static class c {
        public final WeakReference<b> a;
    }

}

