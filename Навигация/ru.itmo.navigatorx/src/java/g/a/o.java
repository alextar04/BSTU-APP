/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.a
 *  g.a.p
 *  io.realm.internal.OsList
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package g.a;

import g.a.a;
import g.a.p;
import io.realm.internal.OsList;
import java.util.Locale;

public final class o<T>
extends p<T> {
    public o(a a2, OsList osList, Class<T> class_) {
        super(a2, osList, class_);
    }

    public void a(Object object) {
        OsList osList = this.b;
        long l2 = ((Number)object).longValue();
        OsList.nativeAddLong((long)osList.e, (long)l2);
    }

    public void b(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof Number) {
            return;
        }
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{"java.lang.Long, java.lang.Integer, java.lang.Short, java.lang.Byte", object.getClass().getName()};
        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unacceptable value type. Acceptable: %1$s, actual: %2$s .", (Object[])arrobject));
    }

    public T c(int n2) {
        block8 : {
            Integer n3;
            Class class_;
            block6 : {
                Long l2;
                block7 : {
                    block5 : {
                        l2 = (Long)this.b.a((long)n2);
                        if (l2 == null) {
                            return null;
                        }
                        class_ = this.c;
                        if (class_ == Long.class) {
                            return (T)l2;
                        }
                        if (class_ != Integer.class) break block5;
                        n3 = l2.intValue();
                        break block6;
                    }
                    if (class_ != Short.class) break block7;
                    n3 = l2.shortValue();
                    break block6;
                }
                if (class_ != Byte.class) break block8;
                n3 = l2.byteValue();
            }
            return (T)class_.cast((Object)n3);
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Unexpected element type: ");
        stringBuilder.append(this.c.getName());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void e(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        long l3 = ((Number)object).longValue();
        OsList.nativeInsertLong((long)osList.e, (long)l2, (long)l3);
    }

    public void g(int n2, Object object) {
        OsList osList = this.b;
        long l2 = n2;
        long l3 = ((Number)object).longValue();
        OsList.nativeSetLong((long)osList.e, (long)l2, (long)l3);
    }
}

