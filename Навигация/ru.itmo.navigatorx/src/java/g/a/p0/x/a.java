/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.RealmNotifier
 *  io.realm.mongodb.AppException
 *  io.realm.mongodb.ErrorCode
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package g.a.p0.x;

import g.a.p0.x.c;
import g.a.p0.x.d;
import g.a.q0.c;
import io.realm.internal.RealmNotifier;
import io.realm.mongodb.AppException;
import io.realm.mongodb.ErrorCode;

public class a
implements Runnable {
    public final /* synthetic */ d e;

    public a(d d2) {
        this.e = d2;
    }

    public void run() {
        try {
            d d2 = this.e;
            Object t2 = this.e.b();
            if (d2.a != null) {
                d2.b.post((Runnable)new c(d2, t2));
                return;
            }
        }
        catch (Throwable throwable) {
            d.a(this.e, new AppException(ErrorCode.UNKNOWN, "Unexpected error", throwable));
            return;
        }
        catch (AppException appException) {
            d.a(this.e, appException);
        }
    }
}

