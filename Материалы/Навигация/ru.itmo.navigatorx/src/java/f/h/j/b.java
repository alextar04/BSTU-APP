/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.PrecomputedText
 *  android.text.PrecomputedText$Params
 *  android.text.PrecomputedText$Params$Builder
 *  android.text.Spannable
 *  android.text.TextDirectionHeuristic
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.style.MetricAffectingSpan
 *  c.b.a.a.a
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 *  java.util.Objects
 */
package f.h.j;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Locale;
import java.util.Objects;

public class b
implements Spannable {
    public char charAt(int n2) {
        throw null;
    }

    public int getSpanEnd(Object object) {
        throw null;
    }

    public int getSpanFlags(Object object) {
        throw null;
    }

    public int getSpanStart(Object object) {
        throw null;
    }

    @SuppressLint(value={"NewApi"})
    public <T> T[] getSpans(int n2, int n3, Class<T> class_) {
        throw null;
    }

    public int length() {
        throw null;
    }

    public int nextSpanTransition(int n2, int n3, Class class_) {
        throw null;
    }

    @SuppressLint(value={"NewApi"})
    public void removeSpan(Object object) {
        if (!(object instanceof MetricAffectingSpan)) {
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @SuppressLint(value={"NewApi"})
    public void setSpan(Object object, int n2, int n3, int n4) {
        if (!(object instanceof MetricAffectingSpan)) {
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int n2, int n3) {
        throw null;
    }

    public String toString() {
        throw null;
    }

    public static final class a {
        public final TextPaint a;
        public final TextDirectionHeuristic b;
        public final int c;
        public final int d;

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
        }

        @SuppressLint(value={"NewApi"})
        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int n2, int n3) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(n2).setHyphenationFrequency(n3).setTextDirection(textDirectionHeuristic).build();
            }
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = n2;
            this.d = n3;
        }

        public boolean a(a a2) {
            if (this.c != a2.c) {
                return false;
            }
            if (this.d != a2.d) {
                return false;
            }
            if (this.a.getTextSize() != a2.a.getTextSize()) {
                return false;
            }
            if (this.a.getTextScaleX() != a2.a.getTextScaleX()) {
                return false;
            }
            if (this.a.getTextSkewX() != a2.a.getTextSkewX()) {
                return false;
            }
            if (this.a.getLetterSpacing() != a2.a.getLetterSpacing()) {
                return false;
            }
            if (!TextUtils.equals((CharSequence)this.a.getFontFeatureSettings(), (CharSequence)a2.a.getFontFeatureSettings())) {
                return false;
            }
            if (this.a.getFlags() != a2.a.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24 ? !this.a.getTextLocales().equals((Object)a2.a.getTextLocales()) : !this.a.getTextLocale().equals((Object)a2.a.getTextLocale())) {
                return false;
            }
            return !(this.a.getTypeface() == null ? a2.a.getTypeface() != null : !this.a.getTypeface().equals((Object)a2.a.getTypeface()));
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof a)) {
                return false;
            }
            a a2 = (a)object;
            if (!this.a(a2)) {
                return false;
            }
            return this.b == a2.b;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object[] arrobject = new Object[]{Float.valueOf((float)this.a.getTextSize()), Float.valueOf((float)this.a.getTextScaleX()), Float.valueOf((float)this.a.getTextSkewX()), Float.valueOf((float)this.a.getLetterSpacing()), this.a.getFlags(), this.a.getTextLocales(), this.a.getTypeface(), this.a.isElegantTextHeight(), this.b, this.c, this.d};
                return Objects.hash((Object[])arrobject);
            }
            Object[] arrobject = new Object[]{Float.valueOf((float)this.a.getTextSize()), Float.valueOf((float)this.a.getTextScaleX()), Float.valueOf((float)this.a.getTextSkewX()), Float.valueOf((float)this.a.getLetterSpacing()), this.a.getFlags(), this.a.getTextLocale(), this.a.getTypeface(), this.a.isElegantTextHeight(), this.b, this.c, this.d};
            return Objects.hash((Object[])arrobject);
        }

        public String toString() {
            LocaleList localeList;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder("{");
            StringBuilder stringBuilder3 = c.b.a.a.a.c((String)"textSize=");
            stringBuilder3.append(this.a.getTextSize());
            stringBuilder2.append(stringBuilder3.toString());
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(", textScaleX=");
            stringBuilder4.append(this.a.getTextScaleX());
            stringBuilder2.append(stringBuilder4.toString());
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(", textSkewX=");
            stringBuilder5.append(this.a.getTextSkewX());
            stringBuilder2.append(stringBuilder5.toString());
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(", letterSpacing=");
            stringBuilder6.append(this.a.getLetterSpacing());
            stringBuilder2.append(stringBuilder6.toString());
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(", elegantTextHeight=");
            stringBuilder7.append(this.a.isElegantTextHeight());
            stringBuilder2.append(stringBuilder7.toString());
            if (Build.VERSION.SDK_INT >= 24) {
                stringBuilder = c.b.a.a.a.c((String)", textLocale=");
                localeList = this.a.getTextLocales();
            } else {
                stringBuilder = c.b.a.a.a.c((String)", textLocale=");
                localeList = this.a.getTextLocale();
            }
            stringBuilder.append((Object)localeList);
            stringBuilder2.append(stringBuilder.toString());
            StringBuilder stringBuilder8 = c.b.a.a.a.c((String)", typeface=");
            stringBuilder8.append((Object)this.a.getTypeface());
            stringBuilder2.append(stringBuilder8.toString());
            if (Build.VERSION.SDK_INT >= 26) {
                StringBuilder stringBuilder9 = c.b.a.a.a.c((String)", variationSettings=");
                stringBuilder9.append(this.a.getFontVariationSettings());
                stringBuilder2.append(stringBuilder9.toString());
            }
            StringBuilder stringBuilder10 = c.b.a.a.a.c((String)", textDir=");
            stringBuilder10.append((Object)this.b);
            stringBuilder2.append(stringBuilder10.toString());
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder11.append(", breakStrategy=");
            stringBuilder11.append(this.c);
            stringBuilder2.append(stringBuilder11.toString());
            StringBuilder stringBuilder12 = new StringBuilder();
            stringBuilder12.append(", hyphenationFrequency=");
            stringBuilder12.append(this.d);
            stringBuilder2.append(stringBuilder12.toString());
            stringBuilder2.append("}");
            return stringBuilder2.toString();
        }
    }

}

