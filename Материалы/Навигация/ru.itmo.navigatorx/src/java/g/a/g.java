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
 *  java.util.Locale
 *  org.bson.types.Decimal128
 */
package g.a;

import g.a.a;
import g.a.p;
import io.realm.internal.OsList;
import java.util.Locale;
import org.bson.types.Decimal128;

public final class g
extends p<Decimal128> {
    public g(a a2, OsList osList, Class<Decimal128> class_) {
        super(a2, osList, class_);
    }

    public void a(Object object) {
        OsList osList = this.b;
        Decimal128 decimal128 = (Decimal128)object;
        OsList.nativeAddDecimal128((long)osList.e, (long)decimal128.f, (long)decimal128.e);
    }

    public void b(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof Decimal128) {
            return;
        }
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{"org.bson.types.Decimal128", object.getClass().getName()};
        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unacceptable value type. Acceptable: %1$s, actual: %2$s .", (Object[])arrobject));
    }

    public Object c(int n2) {
        return (Decimal128)this.b.a((long)n2);
    }

    public void e(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        Decimal128 decimal128 = (Decimal128)object;
        OsList.nativeInsertDecimal128((long)osList.e, (long)l2, (long)decimal128.f, (long)decimal128.e);
    }

    public void g(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        Decimal128 decimal128 = (Decimal128)object;
        OsList.nativeSetDecimal128((long)osList.e, (long)l2, (long)decimal128.f, (long)decimal128.e);
    }
}

