/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayDeque
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Queue
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantLock
 */
package c.c.a.m.u.d0;

import f.b.k.h;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    public final Map<String, a> a = new HashMap();
    public final b b = new b();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string) {
        a a2;
        c c2 = this;
        synchronized (c2) {
            int n2;
            Object object = this.a.get((Object)string);
            h.i.p(object, "Argument must not be null");
            a2 = (a)object;
            if (a2.b < 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot release a lock that is not held, safeKey: ");
                stringBuilder.append(string);
                stringBuilder.append(", interestedThreads: ");
                stringBuilder.append(a2.b);
                throw new IllegalStateException(stringBuilder.toString());
            }
            a2.b = n2 = a2.b - 1;
            if (n2 == 0) {
                Queue<a> queue;
                a a3 = (a)this.a.remove((Object)string);
                if (!a3.equals((Object)a2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Removed the wrong lock, expected to remove: ");
                    stringBuilder.append((Object)a2);
                    stringBuilder.append(", but actually removed: ");
                    stringBuilder.append((Object)a3);
                    stringBuilder.append(", safeKey: ");
                    stringBuilder.append(string);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                b b2 = this.b;
                Queue<a> queue2 = queue = b2.a;
                synchronized (queue2) {
                    if (b2.a.size() < 10) {
                        b2.a.offer((Object)a3);
                    }
                }
            }
        }
        a2.a.unlock();
    }

    public static class a {
        public final Lock a = new ReentrantLock();
        public int b;
    }

    public static class b {
        public final Queue<a> a = new ArrayDeque();
    }

}

