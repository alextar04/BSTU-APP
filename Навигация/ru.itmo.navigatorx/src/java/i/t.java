/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package i;

import c.b.a.a.a;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t {
    public static final Pattern c = Pattern.compile((String)"([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern d = Pattern.compile((String)";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final String a;
    public final String b;

    public t(String string, String string2, String string3, String string4) {
        this.a = string;
        this.b = string4;
    }

    public static t a(String string) {
        Matcher matcher = c.matcher((CharSequence)string);
        if (matcher.lookingAt()) {
            String string2 = matcher.group(1).toLowerCase(Locale.US);
            String string3 = matcher.group(2).toLowerCase(Locale.US);
            String string4 = null;
            Matcher matcher2 = d.matcher((CharSequence)string);
            int n2 = matcher.end();
            while (n2 < string.length()) {
                matcher2.region(n2, string.length());
                if (matcher2.lookingAt()) {
                    String string5 = matcher2.group(1);
                    if (string5 != null && string5.equalsIgnoreCase("charset")) {
                        String string6 = matcher2.group(2);
                        if (string6 != null) {
                            if (string6.startsWith("'") && string6.endsWith("'") && string6.length() > 2) {
                                string6 = string6.substring(1, string6.length() - 1);
                            }
                        } else {
                            string6 = matcher2.group(3);
                        }
                        if (string4 != null && !string6.equalsIgnoreCase(string4)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Multiple charsets defined: \"");
                            stringBuilder.append(string4);
                            stringBuilder.append("\" and: \"");
                            stringBuilder.append(string6);
                            stringBuilder.append("\" for: \"");
                            stringBuilder.append(string);
                            stringBuilder.append('\"');
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        string4 = string6;
                    }
                    n2 = matcher2.end();
                    continue;
                }
                StringBuilder stringBuilder = a.c("Parameter is not formatted correctly: \"");
                stringBuilder.append(string.substring(n2));
                stringBuilder.append("\" for: \"");
                stringBuilder.append(string);
                stringBuilder.append('\"');
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return new t(string, string2, string3, string4);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No subtype found for: \"");
        stringBuilder.append(string);
        stringBuilder.append('\"');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static t b(String string) {
        try {
            t t2 = t.a(string);
            return t2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    public boolean equals(Object object) {
        return object instanceof t && ((t)object).a.equals((Object)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}

