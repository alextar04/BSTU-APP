/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.a
 *  g.a.p
 *  io.realm.internal.OsList
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package g.a;

import g.a.a;
import g.a.p;
import io.realm.internal.OsList;
import java.util.Locale;

public final class e
extends p<Boolean> {
    public e(a a2, OsList osList, Class<Boolean> class_) {
        super(a2, osList, class_);
    }

    public void a(Object object) {
        OsList osList = this.b;
        boolean bl = (Boolean)object;
        OsList.nativeAddBoolean((long)osList.e, (boolean)bl);
    }

    public void b(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof Boolean) {
            return;
        }
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{"java.lang.Boolean", object.getClass().getName()};
        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unacceptable value type. Acceptable: %1$s, actual: %2$s .", (Object[])arrobject));
    }

    public Object c(int n2) {
        return (Boolean)this.b.a((long)n2);
    }

    public void e(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        boolean bl = (Boolean)object;
        OsList.nativeInsertBoolean((long)osList.e, (long)l2, (boolean)bl);
    }

    public void g(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        boolean bl = (Boolean)object;
        OsList.nativeSetBoolean((long)osList.e, (long)l2, (boolean)bl);
    }
}

