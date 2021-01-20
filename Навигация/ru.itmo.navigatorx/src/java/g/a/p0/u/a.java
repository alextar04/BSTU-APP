/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.mongodb.AppException
 *  io.realm.mongodb.ErrorCode
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  k.a.z0.w
 *  k.a.z0.x
 */
package g.a.p0.u;

import f.b.k.h;
import io.realm.mongodb.AppException;
import io.realm.mongodb.ErrorCode;
import java.io.StringWriter;
import java.io.Writer;
import k.a.w0.l0;
import k.a.w0.n1.d;
import k.a.w0.t0;
import k.a.z0.s;
import k.a.z0.w;
import k.a.z0.x;

public class a {
    public static x a;

    public static {
        x.b b2 = new x.b(null);
        s s2 = s.g;
        h.i.c1("outputMode", s2);
        b2.d = s2;
        a = new x(b2);
    }

    public static <T> String a(T t2, d d2) {
        l0<T> l02;
        Class class_ = t2.getClass();
        try {
            l02 = d2.a(class_);
        }
        catch (k.a.w0.n1.a a2) {
            ErrorCode errorCode = ErrorCode.BSON_CODEC_NOT_FOUND;
            StringBuilder stringBuilder = c.b.a.a.a.c("Could not resolve codec for ");
            stringBuilder.append(class_.getSimpleName());
            throw new AppException(errorCode, stringBuilder.toString(), (Throwable)a2);
        }
        try {
            StringWriter stringWriter = new StringWriter();
            w w2 = new w((Writer)stringWriter, a);
            w2.B0();
            w2.w0("value");
            l02.a((k.a.l0)w2, t2, t0.a().a());
            w2.p0();
            String string = stringWriter.toString();
            return string;
        }
        catch (Exception exception) {
            throw new AppException(ErrorCode.BSON_ENCODING, "Error encoding value", (Throwable)exception);
        }
        catch (k.a.w0.n1.a a3) {
            throw new AppException(ErrorCode.BSON_CODEC_NOT_FOUND, "Could not resolve encoder for end type", (Throwable)a3);
        }
    }
}

