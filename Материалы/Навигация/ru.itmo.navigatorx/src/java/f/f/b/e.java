/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package f.f.b;

public class e<T>
implements e<T> {
    public final Object[] a;
    public int b;

    public e(int n2) {
        if (n2 > 0) {
            this.a = new Object[n2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int n2 = this.b;
        if (n2 > 0) {
            int n3 = n2 - 1;
            Object[] arrobject = this.a;
            Object object = arrobject[n3];
            arrobject[n3] = null;
            this.b = n2 - 1;
            return (T)object;
        }
        return null;
    }

    public boolean b(T t2) {
        int n2 = this.b;
        Object[] arrobject = this.a;
        if (n2 < arrobject.length) {
            arrobject[n2] = t2;
            this.b = n2 + 1;
            return true;
        }
        return false;
    }
}

