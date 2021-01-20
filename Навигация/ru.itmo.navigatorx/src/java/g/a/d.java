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
 */
package g.a;

import g.a.a;
import g.a.p;
import io.realm.internal.OsList;
import java.util.Locale;

public final class d
extends p<byte[]> {
    public d(a a2, OsList osList, Class<byte[]> class_) {
        super(a2, osList, class_);
    }

    public void a(Object object) {
        OsList osList = this.b;
        byte[] arrby = (byte[])object;
        OsList.nativeAddBinary((long)osList.e, (byte[])arrby);
    }

    public void b(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof byte[]) {
            return;
        }
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{"byte[]", object.getClass().getName()};
        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unacceptable value type. Acceptable: %1$s, actual: %2$s .", (Object[])arrobject));
    }

    public Object c(int n2) {
        return (byte[])this.b.a((long)n2);
    }

    public void e(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        byte[] arrby = (byte[])object;
        OsList.nativeInsertBinary((long)osList.e, (long)l2, (byte[])arrby);
    }

    public void g(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        byte[] arrby = (byte[])object;
        OsList.nativeSetBinary((long)osList.e, (long)l2, (byte[])arrby);
    }
}

