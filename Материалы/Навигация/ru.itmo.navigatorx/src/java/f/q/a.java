/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.os.Bundle
 *  androidx.savedstate.Recreator
 *  androidx.savedstate.Recreator$a
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.util.Set
 */
package f.q;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import f.q.c;
import java.lang.reflect.Constructor;
import java.util.Set;

@SuppressLint(value={"RestrictedApi"})
public final class a {
    public f.c.a.b.b<String, b> a = new f.c.a.b.b();
    public Bundle b;
    public boolean c;
    public Recreator.a d;
    public boolean e = true;

    public Bundle a(String string) {
        if (this.c) {
            Bundle bundle = this.b;
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(string);
                this.b.remove(string);
                if (this.b.isEmpty()) {
                    this.b = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void b(Class<? extends a> class_) {
        if (this.e) {
            Recreator.a a2;
            if (this.d == null) {
                this.d = new Recreator.a(this);
            }
            try {
                class_.getDeclaredConstructor(new Class[0]);
                a2 = this.d;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                StringBuilder stringBuilder = c.b.a.a.a.c("Class");
                stringBuilder.append(class_.getSimpleName());
                stringBuilder.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(stringBuilder.toString(), (Throwable)noSuchMethodException);
            }
            String string = class_.getName();
            a2.a.add((Object)string);
            return;
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public static interface a {
        public void a(c var1);
    }

    public static interface b {
        public Bundle a();
    }

}

