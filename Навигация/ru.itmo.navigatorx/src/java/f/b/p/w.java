/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.textclassifier.TextClassificationManager
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 *  java.lang.Class
 *  java.lang.Object
 */
package f.b.p;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

public final class w {
    public TextView a;
    public TextClassifier b;

    public w(TextView textView) {
        this.a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.b;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager)this.a.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            textClassifier = TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}

