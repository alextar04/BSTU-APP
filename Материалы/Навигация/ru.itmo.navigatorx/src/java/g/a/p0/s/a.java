/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package g.a.p0.s;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
implements FileFilter {
    public final /* synthetic */ Pattern a;

    public a(Pattern pattern) {
        this.a = pattern;
    }

    public boolean accept(File file) {
        return this.a.matcher((CharSequence)file.getName()).matches();
    }
}

