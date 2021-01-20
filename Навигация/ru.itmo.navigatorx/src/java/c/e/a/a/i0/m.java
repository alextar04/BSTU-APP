/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.material.internal.CheckableImageButton
 *  com.google.android.material.textfield.TextInputLayout
 *  java.lang.Object
 */
package c.e.a.a.i0;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

public abstract class m {
    public TextInputLayout a;
    public Context b;
    public CheckableImageButton c;

    public m(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int n2) {
        return true;
    }

    public void c(boolean bl) {
    }

    public boolean d() {
        return false;
    }
}

