/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.EnumSet
 */
package c.e.b.c0;

import c.b.a.a.a;
import c.e.b.c0.g;
import c.e.b.c0.t;
import c.e.b.p;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

public class j
implements t<T> {
    public final /* synthetic */ Type a;

    public j(g g2, Type type) {
        this.a = type;
    }

    @Override
    public T a() {
        Type type = this.a;
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType)type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T)EnumSet.noneOf((Class)((Class)type2));
            }
            StringBuilder stringBuilder = a.c("Invalid EnumSet type: ");
            stringBuilder.append(this.a.toString());
            throw new p(stringBuilder.toString());
        }
        StringBuilder stringBuilder = a.c("Invalid EnumSet type: ");
        stringBuilder.append(this.a.toString());
        throw new p(stringBuilder.toString());
    }
}

