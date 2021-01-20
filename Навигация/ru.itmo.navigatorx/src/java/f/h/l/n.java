/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 *  f.h.l.l
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 */
package f.h.l;

import android.text.TextUtils;
import android.view.View;
import f.h.l.l;

public class n
extends l.b<CharSequence> {
    public n(int n2, Class class_, int n3, int n4) {
        super(n2, class_, n3, n4);
    }

    @Override
    public Object b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    @Override
    public void c(View view, Object object) {
        view.setAccessibilityPaneTitle((CharSequence)object);
    }

    @Override
    public boolean e(Object object, Object object2) {
        return true ^ TextUtils.equals((CharSequence)((CharSequence)object), (CharSequence)((CharSequence)object2));
    }
}

