/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a
 *  d.a.y0
 *  f.b.k.h
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  kotlinx.coroutines.internal.MainDispatcherFactory
 */
package d.a.a;

import d.a.a.q;
import d.a.y0;
import f.b.k.h;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;

public final class l {
    public static final boolean a;
    public static final y0 b;

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static {
        y0 y02;
        MainDispatcherFactory mainDispatcherFactory;
        Object object;
        String string = q.a("kotlinx.coroutines.fast.service.loader");
        boolean bl = string != null ? Boolean.parseBoolean((String)string) : true;
        a = bl;
        List list = h.i.R1(h.i.e(a.b()));
        Iterator iterator = list.iterator();
        if (!iterator.hasNext()) {
            object = null;
        } else {
            Object object2 = iterator.next();
            if (iterator.hasNext()) {
                int n2 = ((MainDispatcherFactory)object2).getLoadPriority();
                do {
                    int n3;
                    Object object3;
                    if (n2 >= (n3 = ((MainDispatcherFactory)(object3 = iterator.next())).getLoadPriority())) continue;
                    object2 = object3;
                    n2 = n3;
                } while (iterator.hasNext());
            }
            object = object2;
        }
        if ((mainDispatcherFactory = (MainDispatcherFactory)object) == null) throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        {
            catch (Throwable throwable) {
                throw throwable;
            }
        }
        try {
            y02 = mainDispatcherFactory.createDispatcher(list);
            if (y02 == null) throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        }
        catch (Throwable throwable) {
            mainDispatcherFactory.hintOnError();
            throw throwable;
        }
        b = y02;
    }
}

