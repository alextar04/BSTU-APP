/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.GenericDeclaration
 *  java.lang.reflect.Modifier
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.lang.reflect.WildcardType
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.NoSuchElementException
 */
package c.e.b.c0;

import f.b.k.h;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

public final class a {
    public static final Type[] a = new Type[0];

    public static Type a(Type type) {
        if (type instanceof Class) {
            Object object = (Class)type;
            if (object.isArray()) {
                object = new a(a.a((Type)object.getComponentType()));
            }
            return object;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType)type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    public static void b(Type type) {
        boolean bl = !(type instanceof Class) || !((Class)type).isPrimitive();
        h.i.k(bl);
    }

    public static boolean c(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals((Object)type2);
        }
        if (type instanceof ParameterizedType) {
            Type type3;
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType)type;
            ParameterizedType parameterizedType2 = (ParameterizedType)type2;
            Type type4 = parameterizedType.getOwnerType();
            boolean bl = type4 == (type3 = parameterizedType2.getOwnerType()) || type4 != null && type4.equals((Object)type3);
            return bl && parameterizedType.getRawType().equals((Object)parameterizedType2.getRawType()) && Arrays.equals((Object[])parameterizedType.getActualTypeArguments(), (Object[])parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            GenericArrayType genericArrayType = (GenericArrayType)type;
            GenericArrayType genericArrayType2 = (GenericArrayType)type2;
            return a.c(genericArrayType.getGenericComponentType(), genericArrayType2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType)type;
            WildcardType wildcardType2 = (WildcardType)type2;
            return Arrays.equals((Object[])wildcardType.getUpperBounds(), (Object[])wildcardType2.getUpperBounds()) && Arrays.equals((Object[])wildcardType.getLowerBounds(), (Object[])wildcardType2.getLowerBounds());
        }
        if (type instanceof TypeVariable) {
            if (!(type2 instanceof TypeVariable)) {
                return false;
            }
            TypeVariable typeVariable = (TypeVariable)type;
            TypeVariable typeVariable2 = (TypeVariable)type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals((Object)typeVariable2.getName());
        }
        return false;
    }

    public static Type d(Type type, Class<?> class_, Class<?> class_2) {
        if (class_2 == class_) {
            return type;
        }
        if (class_2.isInterface()) {
            Class[] arrclass = class_.getInterfaces();
            int n2 = arrclass.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (arrclass[i2] == class_2) {
                    return class_.getGenericInterfaces()[i2];
                }
                if (!class_2.isAssignableFrom(arrclass[i2])) continue;
                return a.d(class_.getGenericInterfaces()[i2], arrclass[i2], class_2);
            }
        }
        if (!class_.isInterface()) {
            while (class_ != Object.class) {
                Class class_3 = class_.getSuperclass();
                if (class_3 == class_2) {
                    return class_.getGenericSuperclass();
                }
                if (class_2.isAssignableFrom(class_3)) {
                    return a.d(class_.getGenericSuperclass(), class_3, class_2);
                }
                class_ = class_3;
            }
        }
        return class_2;
    }

    public static Class<?> e(Type type) {
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType)type).getRawType();
            h.i.k(type2 instanceof Class);
            return (Class)type2;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(a.e(((GenericArrayType)type).getGenericComponentType()), (int)0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return a.e(((WildcardType)type).getUpperBounds()[0]);
        }
        String string = type == null ? "null" : type.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append((Object)type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static Type f(Type type, Class<?> class_, Class<?> class_2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType)type).getUpperBounds()[0];
        }
        h.i.k(class_2.isAssignableFrom(class_));
        return a.g(type, class_, a.d(type, class_, class_2));
    }

    public static Type g(Type type, Class<?> class_, Type type2) {
        return a.h(type, class_, type2, (Collection<TypeVariable>)new HashSet());
    }

    public static Type h(Type type, Class<?> class_, Type type2, Collection<TypeVariable> collection) {
        Class class_2;
        int n2;
        block21 : {
            TypeVariable typeVariable;
            block2 : do {
                Type type3;
                boolean bl = type2 instanceof TypeVariable;
                if (!bl) break block21;
                typeVariable = (TypeVariable)type2;
                if (collection.contains((Object)typeVariable)) {
                    return type2;
                }
                collection.add((Object)typeVariable);
                GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
                Class class_3 = genericDeclaration instanceof Class ? (Class)genericDeclaration : null;
                if (class_3 != null && (type3 = a.d(type, class_, class_3)) instanceof ParameterizedType) {
                    TypeVariable[] arrtypeVariable = class_3.getTypeParameters();
                    int n3 = arrtypeVariable.length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        if (!typeVariable.equals((Object)arrtypeVariable[n2])) continue;
                        type2 = ((ParameterizedType)type3).getActualTypeArguments()[n2];
                        continue block2;
                    }
                    throw new NoSuchElementException();
                }
                type2 = typeVariable;
            } while (type2 != typeVariable);
            return type2;
        }
        if (type2 instanceof Class && (class_2 = (Class)type2).isArray()) {
            Type type4;
            Class class_4 = class_2.getComponentType();
            if (class_4 == (type4 = a.h(type, class_, (Type)class_4, collection))) {
                return class_2;
            }
            return new a(type4);
        }
        if (type2 instanceof GenericArrayType) {
            Type type5;
            GenericArrayType genericArrayType = (GenericArrayType)type2;
            Type type6 = genericArrayType.getGenericComponentType();
            if (type6 == (type5 = a.h(type, class_, type6, collection))) {
                return genericArrayType;
            }
            return new a(type5);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            Type type7 = parameterizedType.getOwnerType();
            Type type8 = a.h(type, class_, type7, collection);
            boolean bl = type8 != type7;
            Type[] arrtype = parameterizedType.getActualTypeArguments();
            int n4 = arrtype.length;
            while (n2 < n4) {
                Type type9 = a.h(type, class_, arrtype[n2], collection);
                if (type9 != arrtype[n2]) {
                    if (!bl) {
                        arrtype = (Type[])arrtype.clone();
                        bl = true;
                    }
                    arrtype[n2] = type9;
                }
                ++n2;
            }
            if (bl) {
                parameterizedType = new b(type8, parameterizedType.getRawType(), arrtype);
            }
            return parameterizedType;
        }
        if (type2 instanceof WildcardType) {
            type2 = (WildcardType)type2;
            Type[] arrtype = type2.getLowerBounds();
            Type[] arrtype2 = type2.getUpperBounds();
            if (arrtype.length == 1) {
                Type type10 = a.h(type, class_, arrtype[0], collection);
                if (type10 != arrtype[0]) {
                    Type[] arrtype3 = type10 instanceof WildcardType ? ((WildcardType)type10).getLowerBounds() : new Type[]{type10};
                    return new c(new Type[]{Object.class}, arrtype3);
                }
            } else if (arrtype2.length == 1) {
                Type type11 = arrtype2[0];
                Type type12 = a.h(type, class_, type11, collection);
                if (type12 != arrtype2[0]) {
                    Type[] arrtype4 = type12 instanceof WildcardType ? ((WildcardType)type12).getUpperBounds() : new Type[]{type12};
                    return new c(arrtype4, a);
                }
            }
        }
        return type2;
    }

    public static String i(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }

    public static final class a
    implements GenericArrayType,
    Serializable {
        public final Type e;

        public a(Type type) {
            this.e = a.a(type);
        }

        public boolean equals(Object object) {
            return object instanceof GenericArrayType && a.c((Type)this, (Type)((GenericArrayType)object));
        }

        public Type getGenericComponentType() {
            return this.e;
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.i(this.e));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    public static final class b
    implements ParameterizedType,
    Serializable {
        public final Type e;
        public final Type f;
        public final Type[] g;

        public /* varargs */ b(Type type, Type type2, Type ... arrtype) {
            boolean bl = type2 instanceof Class;
            int n2 = 0;
            if (bl) {
                Class class_ = (Class)type2;
                boolean bl2 = Modifier.isStatic((int)class_.getModifiers());
                boolean bl3 = true;
                boolean bl4 = !bl2 && class_.getEnclosingClass() != null ? false : bl3;
                if (type == null && !bl4) {
                    bl3 = false;
                }
                h.i.k(bl3);
            }
            Type type3 = type == null ? null : a.a(type);
            this.e = type3;
            this.f = a.a(type2);
            Type[] arrtype2 = (Type[])arrtype.clone();
            this.g = arrtype2;
            int n3 = arrtype2.length;
            while (n2 < n3) {
                h.i.q(this.g[n2]);
                a.b(this.g[n2]);
                Type[] arrtype3 = this.g;
                arrtype3[n2] = a.a(arrtype3[n2]);
                ++n2;
            }
        }

        public boolean equals(Object object) {
            return object instanceof ParameterizedType && a.c((Type)this, (Type)((ParameterizedType)object));
        }

        public Type[] getActualTypeArguments() {
            return (Type[])this.g.clone();
        }

        public Type getOwnerType() {
            return this.e;
        }

        public Type getRawType() {
            return this.f;
        }

        public int hashCode() {
            int n2 = Arrays.hashCode((Object[])this.g) ^ this.f.hashCode();
            Type type = this.e;
            int n3 = type != null ? type.hashCode() : 0;
            return n2 ^ n3;
        }

        public String toString() {
            int n2 = this.g.length;
            if (n2 == 0) {
                return a.i(this.f);
            }
            StringBuilder stringBuilder = new StringBuilder(30 * (n2 + 1));
            stringBuilder.append(a.i(this.f));
            stringBuilder.append("<");
            stringBuilder.append(a.i(this.g[0]));
            for (int i2 = 1; i2 < n2; ++i2) {
                stringBuilder.append(", ");
                stringBuilder.append(a.i(this.g[i2]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    public static final class c
    implements WildcardType,
    Serializable {
        public final Type e;
        public final Type f;

        public c(Type[] arrtype, Type[] arrtype2) {
            boolean bl = arrtype2.length;
            boolean bl2 = true;
            boolean bl3 = bl <= bl2 ? bl2 : false;
            h.i.k(bl3);
            boolean bl4 = arrtype.length == bl2 ? bl2 : false;
            h.i.k(bl4);
            if (arrtype2.length == bl2) {
                h.i.q(arrtype2[0]);
                a.b(arrtype2[0]);
                if (arrtype[0] != Object.class) {
                    bl2 = false;
                }
                h.i.k(bl2);
                this.f = a.a(arrtype2[0]);
                this.e = Object.class;
                return;
            }
            h.i.q(arrtype[0]);
            a.b(arrtype[0]);
            this.f = null;
            this.e = a.a(arrtype[0]);
        }

        public boolean equals(Object object) {
            return object instanceof WildcardType && a.c((Type)this, (Type)((WildcardType)object));
        }

        public Type[] getLowerBounds() {
            Type type = this.f;
            if (type != null) {
                return new Type[]{type};
            }
            return a.a;
        }

        public Type[] getUpperBounds() {
            Type[] arrtype = new Type[]{this.e};
            return arrtype;
        }

        public int hashCode() {
            Type type = this.f;
            int n2 = type != null ? 31 + type.hashCode() : 1;
            return n2 ^ 31 + this.e.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder;
            Type type;
            if (this.f != null) {
                stringBuilder = c.b.a.a.a.c("? super ");
                type = this.f;
            } else {
                if (this.e == Object.class) {
                    return "?";
                }
                stringBuilder = c.b.a.a.a.c("? extends ");
                type = this.e;
            }
            stringBuilder.append(a.i(type));
            return stringBuilder.toString();
        }
    }

}

