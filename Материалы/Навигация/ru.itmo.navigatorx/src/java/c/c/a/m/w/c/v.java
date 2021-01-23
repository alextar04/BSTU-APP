/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Xfermode
 *  android.os.Build
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.locks.Condition
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantLock
 */
package c.c.a.m.w.c;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class v {
    public static final Paint a;
    public static final Paint b;
    public static final Set<String> c;
    public static final Lock d;

    public static {
        HashSet hashSet;
        Paint paint;
        a = new Paint(6);
        new Paint(7);
        c = hashSet = new HashSet((Collection)Arrays.asList((Object[])new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        Object object = hashSet.contains((Object)Build.MODEL) ? new ReentrantLock() : new a();
        d = object;
        b = paint = new Paint(7);
        paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static final class a
    implements Lock {
        public void lock() {
        }

        public void lockInterruptibly() {
        }

        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long l2, TimeUnit timeUnit) {
            return true;
        }

        public void unlock() {
        }
    }

}

