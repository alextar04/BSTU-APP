/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.a
 *  g.a.p
 *  io.realm.internal.OsList
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.Locale
 */
package g.a;

import g.a.a;
import g.a.p;
import io.realm.internal.OsList;
import java.util.Date;
import java.util.Locale;

public final class f
extends p<Date> {
    public f(a a2, OsList osList, Class<Date> class_) {
        super(a2, osList, class_);
    }

    public void a(Object object) {
        OsList osList = this.b;
        Date date = (Date)object;
        OsList.nativeAddDate((long)osList.e, (long)date.getTime());
    }

    public void b(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof Date) {
            return;
        }
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{"java.util.Date", object.getClass().getName()};
        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unacceptable value type. Acceptable: %1$s, actual: %2$s .", (Object[])arrobject));
    }

    public Object c(int n2) {
        return (Date)this.b.a((long)n2);
    }

    public void e(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        Date date = (Date)object;
        OsList.nativeInsertDate((long)osList.e, (long)l2, (long)date.getTime());
    }

    public void g(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        Date date = (Date)object;
        OsList.nativeSetDate((long)osList.e, (long)l2, (long)date.getTime());
    }
}

