package org.pb.webserver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author boge.peng
 * @create 2018-12-19 18:21
 */
public class WebContext {

    private static Map<String, String> servletMap;
    private static Map<String, String> mappingMap;

    public WebContext(WebApp.WebAppHandler handler) {
        servletMap = new HashMap<>();
        mappingMap = new HashMap<>();

        initialize(handler);
    }

    private void initialize(WebApp.WebAppHandler handler) {
        for (WebApp.ServletEntity servletEntity : handler.getServletEntities()) {
            servletMap.put(servletEntity.getServletName(), servletEntity.getServletClass());
        }

        for (WebApp.ServletMapping servletMapping : handler.getServletMappings()) {
            for (String url : servletMapping.getUrlPattern()) {
                mappingMap.put(url, servletMapping.getServletName());
            }
        }
    }

    public Servlet getServletByUrl(String urlPattern) {
        try {
            String className = servletMap.get(mappingMap.get("/" + urlPattern));
            Class<?> clz = Class.forName(className);

            return (Servlet) clz.getConstructor().newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}
