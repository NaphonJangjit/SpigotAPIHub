package net.heeheehub.apihub.APIHub.development;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class APIHub {

    private static final Map<String, HandlerMethod> handlers = new HashMap<>();

    public static void registerHandler(String namespace, Object handler){
        Class<?> clazz = handler.getClass();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(APIController.class)){
                APIController controller = method.getAnnotation(APIController.class);
                String endpoint = controller.value();
                if(handlers.containsKey(namespace + ":" + endpoint)){
                    throw new RuntimeException("Duplicate endpoint: " + endpoint);
                }
                boolean isVoid = method.getReturnType().equals(void.class);

                method.setAccessible(true);
                handlers.put(namespace + ":" + endpoint, new HandlerMethod(handler, method, isVoid));
            }
        }
    }

    public static Object request(String endpoint, Object...args){
        HandlerMethod handlerMethod = handlers.get(endpoint);
        if(handlerMethod == null){
            throw new RuntimeException("No such endpoint: " + endpoint);
        }
        if(handlerMethod.isVoid){
            throw new RuntimeException("Cannot request to void endpoint, use APIHub.voidRequest instead");
        }
        try {
            return handlerMethod.method.invoke(handlerMethod.instance, args);
        }catch (IllegalAccessException | InvocationTargetException ex){
            throw new RuntimeException("Failed to request API: " + ex.getMessage(), ex);
        }
    }

    public static void voidRequest(String endpoint, Object...args){
        HandlerMethod handlerMethod = handlers.get(endpoint);
        if(handlerMethod == null){
            throw new RuntimeException("No such endpoint: " + endpoint);
        }
        if(!handlerMethod.isVoid){
            throw new RuntimeException("Cannot request to non-void endpoint, use APIHub.request instead");
        }
        try {
            handlerMethod.method.invoke(handlerMethod.instance, args);
        }catch (IllegalAccessException | InvocationTargetException ex){
            throw new RuntimeException("Failed to request API: " + ex.getMessage(), ex);
        }
    }

}
