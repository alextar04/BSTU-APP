/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.a
 *  g.a.p
 *  io.realm.internal.OsList
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package g.a;

import g.a.a;
import g.a.p;
import io.realm.internal.OsList;
import java.util.Locale;

public final class h
extends p<Double> {
    public h(a a2, OsList osList, Class<Double> class_) {
        super(a2, osList, class_);
    }

    public void a(Object object) {
        OsList osList = this.b;
        double d2 = ((Number)object).doubleValue();
        OsList.nativeAddDouble((long)osList.e, (double)d2);
    }

    public void b(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof Number) {
            return;
        }
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{"java.lang.Number", object.getClass().getName()};
        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unacceptable value type. Acceptable: %1$s, actual: %2$s .", (Object[])arrobject));
    }

    public Object c(int n2) {
        return (Double)this.b.a((long)n2);
    }

    public void e(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        double d2 = ((Number)object).doubleValue();
        OsList.nativeInsertDouble((long)osList.e, (long)l2, (double)d2);
    }

    public void g(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        double d2 = ((Number)object).doubleValue();
        OsList.nativeSetDouble((long)osList.e, (long)l2, (double)d2);
    }
}

