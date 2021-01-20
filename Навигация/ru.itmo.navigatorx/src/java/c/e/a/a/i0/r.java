/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.text.TextWatcher
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  com.google.android.material.internal.CheckableImageButton
 *  com.google.android.material.textfield.TextInputLayout
 *  com.google.android.material.textfield.TextInputLayout$f
 *  com.google.android.material.textfield.TextInputLayout$g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.LinkedHashSet
 */
package c.e.a.a.i0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import c.e.a.a.e;
import c.e.a.a.i;
import c.e.a.a.i0.m;
import c.e.a.a.i0.r;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.LinkedHashSet;

public class r
extends m {
    public final TextWatcher d = new TextWatcher(this){
        public final /* synthetic */ r e;
        {
            this.e = r2;
        }

        public void afterTextChanged(android.text.Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            r r2 = this.e;
            r2.c.setChecked(true ^ r.e(r2));
        }

        public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        }
    };
    public final TextInputLayout.f e = new TextInputLayout.f(){

        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            r r2 = r.this;
            r2.c.setChecked(true ^ r.e(r2));
            editText.removeTextChangedListener(r.this.d);
            editText.addTextChangedListener(r.this.d);
        }
    };
    public final TextInputLayout.g f = new TextInputLayout.g(){

        public void a(TextInputLayout textInputLayout, int n2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && n2 == 1) {
                editText.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
                editText.removeTextChangedListener(r.this.d);
            }
        }
    };

    public r(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static boolean e(r r2) {
        EditText editText = r2.a.getEditText();
        return editText != null && editText.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    @Override
    public void a() {
        this.a.setEndIconDrawable(f.b.l.a.a.b(this.b, e.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(i.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new View.OnClickListener(this){
            public final /* synthetic */ r e;
            {
                this.e = r2;
            }

            public void onClick(View view) {
                EditText editText = this.e.a.getEditText();
                if (editText == null) {
                    return;
                }
                int n2 = editText.getSelectionEnd();
                PasswordTransformationMethod passwordTransformationMethod = r.e(this.e) ? null : PasswordTransformationMethod.getInstance();
                editText.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
                if (n2 >= 0) {
                    editText.setSelection(n2);
                }
            }
        });
        this.a.a(this.e);
        TextInputLayout textInputLayout2 = this.a;
        TextInputLayout.g g2 = this.f;
        textInputLayout2.j0.add((Object)g2);
        EditText editText = this.a.getEditText();
        boolean bl = editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
        if (bl) {
            editText.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
        }
    }

}

