package net.heeheehub.apihub.APIHub.development;

import java.lang.reflect.Method;

class HandlerMethod {
    final Object instance;
    final Method method;
    final boolean isVoid;
    HandlerMethod(Object instance, Method method, boolean isVoid){
        this.instance = instance;
        this.method = method;
        this.isVoid = isVoid;
    }
}
