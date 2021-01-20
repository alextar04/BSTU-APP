/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.SpannableStringBuilder
 *  f.h.j.d$c
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package f.h.j;

import android.text.SpannableStringBuilder;
import f.h.j.c;
import f.h.j.d;
import f.h.j.e;
import java.util.Locale;

public final class a {
    public static final c d = d.c;
    public static final String e = Character.toString((char)'\u200e');
    public static final String f = Character.toString((char)'\u200f');
    public static final a g = new a(false, 2, d);
    public static final a h = new a(true, 2, d);
    public final boolean a;
    public final int b;
    public final c c;

    public a(boolean bl, int n2, c c2) {
        this.a = bl;
        this.b = n2;
        this.c = c2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(CharSequence charSequence) {
        int n2;
        a a2 = new a(charSequence, false);
        a2.d = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while ((n2 = a2.d) < a2.c && n3 == 0) {
            block28 : {
                block26 : {
                    block27 : {
                        int n6;
                        block25 : {
                            block24 : {
                                char c2;
                                a2.e = c2 = a2.a.charAt(n2);
                                if (!Character.isHighSurrogate((char)c2)) break block24;
                                int n7 = Character.codePointAt((CharSequence)a2.a, (int)a2.d);
                                a2.d += Character.charCount((int)n7);
                                n6 = Character.getDirectionality((int)n7);
                                break block25;
                            }
                            a2.d = 1 + a2.d;
                            char c3 = a2.e;
                            n6 = c3 < '\u0700' ? a.f[c3] : Character.getDirectionality((char)c3);
                            if (a2.b) {
                                block23 : {
                                    char c4 = a2.e;
                                    if (c4 == '<') {
                                        int n8;
                                        int n9 = a2.d;
                                        block11 : while ((n8 = a2.d) < a2.c) {
                                            char c5;
                                            CharSequence charSequence2 = a2.a;
                                            a2.d = n8 + 1;
                                            a2.e = c5 = charSequence2.charAt(n8);
                                            if (c5 != '>') {
                                                int n10;
                                                if (c5 != '\"' && c5 != '\'') continue;
                                                char c6 = a2.e;
                                                while ((n10 = a2.d) < a2.c) {
                                                    char c7;
                                                    CharSequence charSequence3 = a2.a;
                                                    a2.d = n10 + 1;
                                                    a2.e = c7 = charSequence3.charAt(n10);
                                                    if (c7 == c6) continue block11;
                                                }
                                                continue;
                                            }
                                            break block23;
                                        }
                                        a2.d = n9;
                                        a2.e = (char)60;
                                        n6 = 13;
                                    } else if (c4 == '&') {
                                        int n11;
                                        while ((n11 = a2.d) < a2.c) {
                                            char c8;
                                            CharSequence charSequence4 = a2.a;
                                            a2.d = n11 + 1;
                                            a2.e = c8 = charSequence4.charAt(n11);
                                            if (c8 != ';') continue;
                                        }
                                    }
                                    break block25;
                                }
                                n6 = 12;
                            }
                        }
                        if (n6 == 0) break block26;
                        if (n6 == 1 || n6 == 2) break block27;
                        if (n6 == 9) continue;
                        switch (n6) {
                            default: {
                                break block28;
                            }
                            case 18: {
                                --n5;
                                n4 = 0;
                                break;
                            }
                            case 16: 
                            case 17: {
                                ++n5;
                                n4 = 1;
                                break;
                            }
                            case 14: 
                            case 15: {
                                ++n5;
                                n4 = -1;
                                break;
                            }
                        }
                        continue;
                    }
                    if (n5 == 0) {
                        return 1;
                    }
                    break block28;
                }
                if (n5 == 0) return -1;
            }
            n3 = n5;
        }
        if (n3 == 0) {
            return 0;
        }
        if (n4 != 0) {
            return n4;
        }
        block14 : while (a2.d > 0) {
            switch (a2.a()) {
                default: {
                    continue block14;
                }
                case 18: {
                    ++n5;
                    continue block14;
                }
                case 16: 
                case 17: {
                    if (n3 != n5) break;
                    return 1;
                }
                case 14: 
                case 15: {
                    if (n3 != n5) break;
                    return -1;
                }
            }
            --n5;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int b(CharSequence charSequence) {
        a a2 = new a(charSequence, false);
        a2.d = a2.c;
        int n2 = 0;
        block5 : do {
            int n3 = n2;
            block6 : while (a2.d > 0) {
                block13 : {
                    block11 : {
                        block12 : {
                            byte by = a2.a();
                            if (by == 0) break block11;
                            if (by == 1 || by == 2) break block12;
                            if (by == 9) continue;
                            switch (by) {
                                default: {
                                    if (n2 != 0) continue block6;
                                    break block13;
                                }
                                case 18: {
                                    ++n3;
                                    continue block6;
                                }
                                case 16: 
                                case 17: {
                                    if (n2 != n3) break;
                                    return 1;
                                }
                                case 14: 
                                case 15: {
                                    if (n2 == n3) return -1;
                                }
                            }
                            --n3;
                            continue;
                        }
                        if (n3 == 0) {
                            return 1;
                        }
                        if (n2 != 0) continue;
                        break block13;
                    }
                    if (n3 == 0) {
                        return -1;
                    }
                    if (n2 != 0) continue;
                }
                n2 = n3;
                continue block5;
            }
            break;
        } while (true);
        return 0;
    }

    public static a c() {
        int n2;
        int n3 = e.a(Locale.getDefault());
        if (n3 != (n2 = 1)) {
            n2 = 0;
        }
        c c2 = d;
        if (c2 == d) {
            if (n2) {
                return h;
            }
            return g;
        }
        return new a((boolean)n2, 2, c2);
    }

    public CharSequence d(CharSequence charSequence, c c2, boolean bl) {
        if (charSequence == null) {
            return null;
        }
        int n2 = charSequence.length();
        boolean bl2 = (c2).b(charSequence, 0, n2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean bl3 = (2 & this.b) != 0;
        String string = "";
        if (bl3 && bl) {
            c c3 = bl2 ? d.b : d.a;
            int n3 = charSequence.length();
            boolean bl4 = (c3).b(charSequence, 0, n3);
            String string2 = !this.a && (bl4 || a.a(charSequence) == 1) ? e : (this.a && (!bl4 || a.a(charSequence) == -1) ? f : string);
            spannableStringBuilder.append((CharSequence)string2);
        }
        if (bl2 != this.a) {
            char c4 = bl2 ? (char)'\u202b' : '\u202a';
            spannableStringBuilder.append(c4);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('\u202c');
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (bl) {
            c c5 = bl2 ? d.b : d.a;
            int n4 = charSequence.length();
            boolean bl5 = (c5).b(charSequence, 0, n4);
            if (!this.a && (bl5 || a.b(charSequence) == 1)) {
                string = e;
            } else if (this.a && (!bl5 || a.b(charSequence) == -1)) {
                string = f;
            }
            spannableStringBuilder.append((CharSequence)string);
        }
        return spannableStringBuilder;
    }

    public static class a {
        public static final byte[] f = new byte[1792];
        public final CharSequence a;
        public final boolean b;
        public final int c;
        public int d;
        public char e;

        public static {
            for (int i2 = 0; i2 < 1792; ++i2) {
                a.f[i2] = Character.getDirectionality((int)i2);
            }
        }

        public a(CharSequence charSequence, boolean bl) {
            this.a = charSequence;
            this.b = bl;
            this.c = charSequence.length();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public byte a() {
            char c2;
            this.e = c2 = this.a.charAt(-1 + this.d);
            if (Character.isLowSurrogate((char)c2)) {
                int n2 = Character.codePointBefore((CharSequence)this.a, (int)this.d);
                this.d -= Character.charCount((int)n2);
                return Character.getDirectionality((int)n2);
            }
            this.d = -1 + this.d;
            char c3 = this.e;
            int n3 = c3 < '\u0700' ? f[c3] : Character.getDirectionality((char)c3);
            if (!this.b) return (byte)n3;
            char c4 = this.e;
            if (c4 == '>') {
                int n4;
                int n5 = this.d;
                block0 : while ((n4 = this.d) > 0) {
                    char c5;
                    int n6;
                    int n7;
                    CharSequence charSequence = this.a;
                    this.d = n6 = n4 - 1;
                    this.e = c5 = charSequence.charAt(n6);
                    if (c5 == '<') return 12;
                    if (c5 == '>') break;
                    if (c5 != '\"' && c5 != '\'') continue;
                    char c6 = this.e;
                    while ((n7 = this.d) > 0) {
                        int n8;
                        char c7;
                        CharSequence charSequence2 = this.a;
                        this.d = n8 = n7 - 1;
                        this.e = c7 = charSequence2.charAt(n8);
                        if (c7 == c6) continue block0;
                    }
                }
                this.d = n5;
                this.e = (char)62;
                return (byte)13;
            } else {
                int n9;
                if (c4 != ';') return (byte)n3;
                int n10 = this.d;
                while ((n9 = this.d) > 0) {
                    char c8;
                    int n11;
                    CharSequence charSequence = this.a;
                    this.d = n11 = n9 - 1;
                    this.e = c8 = charSequence.charAt(n11);
                    if (c8 == '&') {
                        return 12;
                    }
                    if (c8 != ';') continue;
                }
                this.d = n10;
                this.e = (char)59;
            }
            return (byte)13;
        }
    }

}

