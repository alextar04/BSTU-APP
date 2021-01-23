/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.savedstate.Recreator
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistry$1
 *  f.n.g
 *  f.n.g$b
 *  f.n.l
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 */
package f.q;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import f.c.a.b.b;
import f.n.g;
import f.n.l;
import f.n.o;
import f.q.a;
import f.q.c;
import java.util.Map;

public final class b {
    public final c a;
    public final a b;

    public b(c c2) {
        this.a = c2;
        this.b = new a();
    }

    public void a(Bundle bundle) {
        g g2 = this.a.a();
        if (((o)g2).c == g.b.f) {
            g2.a((l)new Recreator(this.a));
            a a2 = this.b;
            if (!a2.c) {
                if (bundle != null) {
                    a2.b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                g2.a((l)new SavedStateRegistry.1(a2));
                a2.c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        a a2 = this.b;
        if (a2 != null) {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = a2.b;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            b.d d2 = a2.a.c();
            while (d2.hasNext()) {
                Map.Entry entry = (Map.Entry)d2.next();
                bundle2.putBundle((String)entry.getKey(), ((a.b)entry.getValue()).a());
            }
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
            return;
        }
        throw null;
    }
}

