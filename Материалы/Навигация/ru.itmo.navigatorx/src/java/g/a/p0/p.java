/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.RealmFieldType
 *  io.realm.internal.OsList
 *  io.realm.internal.Table
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package g.a.p0;

import io.realm.RealmFieldType;
import io.realm.internal.OsList;
import io.realm.internal.Table;
import java.util.Date;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

public interface p {
    public boolean a();

    public Decimal128 b(long var1);

    public float c(long var1);

    public long d(String var1);

    public void e(long var1, String var3);

    public long f(long var1);

    public String g(long var1);

    public OsList h(long var1);

    public void i(long var1, long var3);

    public Date j(long var1);

    public Table k();

    public OsList l(long var1, RealmFieldType var3);

    public boolean m(long var1);

    public boolean n(long var1);

    public byte[] o(long var1);

    public RealmFieldType p(long var1);

    public ObjectId q(long var1);

    public double r(long var1);

    public void s(long var1, double var3);

    public long t();

    public String[] u();

    public boolean v(long var1);
}

