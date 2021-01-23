/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.p0.p
 *  io.realm.RealmFieldType
 *  io.realm.internal.OsList
 *  io.realm.internal.Table
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.Date
 *  org.bson.types.Decimal128
 *  org.bson.types.ObjectId
 */
package g.a.p0;

import g.a.p0.p;
import io.realm.RealmFieldType;
import io.realm.internal.OsList;
import io.realm.internal.Table;
import java.util.Date;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

public final class g
extends Enum<g>
implements p {
    public static final /* enum */ g e;
    public static final /* synthetic */ g[] f;

    public static {
        g g2;
        e = g2 = new g();
        f = new g[]{g2};
    }

    public static g valueOf(String string) {
        return (g)Enum.valueOf(g.class, (String)string);
    }

    public static g[] values() {
        return (g[])f.clone();
    }

    public boolean a() {
        return false;
    }

    public Decimal128 b(long l2) {
        throw this.w();
    }

    public float c(long l2) {
        throw this.w();
    }

    public long d(String string) {
        throw this.w();
    }

    public void e(long l2, String string) {
        throw this.w();
    }

    public long f(long l2) {
        throw this.w();
    }

    public String g(long l2) {
        throw this.w();
    }

    public OsList h(long l2) {
        throw this.w();
    }

    public void i(long l2, long l3) {
        throw this.w();
    }

    public Date j(long l2) {
        throw this.w();
    }

    public Table k() {
        throw this.w();
    }

    public OsList l(long l2, RealmFieldType realmFieldType) {
        throw this.w();
    }

    public boolean m(long l2) {
        throw this.w();
    }

    public boolean n(long l2) {
        throw this.w();
    }

    public byte[] o(long l2) {
        throw this.w();
    }

    public RealmFieldType p(long l2) {
        throw this.w();
    }

    public ObjectId q(long l2) {
        throw this.w();
    }

    public double r(long l2) {
        throw this.w();
    }

    public void s(long l2, double d2) {
        throw this.w();
    }

    public long t() {
        throw this.w();
    }

    public String[] u() {
        throw this.w();
    }

    public boolean v(long l2) {
        throw this.w();
    }

    public final RuntimeException w() {
        return new IllegalStateException("Object is no longer managed by Realm. Has it been deleted?");
    }
}

