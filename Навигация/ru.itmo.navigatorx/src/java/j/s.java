/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.System
 */
package j;

public final class s {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public s f;
    public s g;

    public s() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public s(byte[] arrby, int n2, int n3, boolean bl, boolean bl2) {
        this.a = arrby;
        this.b = n2;
        this.c = n3;
        this.d = bl;
        this.e = bl2;
    }

    public final s a() {
        s s2 = this.f;
        if (s2 == this) {
            s2 = null;
        }
        s s3 = this.g;
        s3.f = this.f;
        this.f.g = s3;
        this.f = null;
        this.g = null;
        return s2;
    }

    public final s b(s s2) {
        s2.g = this;
        s2.f = this.f;
        this.f.g = s2;
        this.f = s2;
        return s2;
    }

    public final s c() {
        this.d = true;
        s s2 = new s(this.a, this.b, this.c, true, false);
        return s2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void d(s s2, int n2) {
        if (!s2.e) throw new IllegalArgumentException();
        int n3 = s2.c;
        if (n3 + n2 > 8192) {
            if (s2.d) throw new IllegalArgumentException();
            int n4 = n3 + n2;
            int n5 = s2.b;
            if (n4 - n5 > 8192) throw new IllegalArgumentException();
            byte[] arrby = s2.a;
            System.arraycopy((Object)arrby, (int)n5, (Object)arrby, (int)0, (int)(n3 - n5));
            s2.c -= s2.b;
            s2.b = 0;
        }
        System.arraycopy((Object)this.a, (int)this.b, (Object)s2.a, (int)s2.c, (int)n2);
        s2.c = n2 + s2.c;
        this.b = n2 + this.b;
    }
}

