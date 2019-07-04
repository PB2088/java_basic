package org.pb.webserver;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-15 13:13
 */
public class WebApp {
    private static WebContext context;

    static {
        try {
            //1.获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2.从解析工厂获取解析器
            SAXParser parser = factory.newSAXParser();
            //3.加载文档Document注册处理器
            WebAppHandler handler = new WebAppHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream
                    ("web.xml"), handler);

            initWebContext(handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebContext getContext() {
        return context;
    }

    private static void initWebContext(WebAppHandler handler) {
        context = new WebContext(handler);
    }

    static class WebAppHandler extends DefaultHandler {
        private static final String WEB_APP_SERVLET = "servlet";
        private static final String WEB_APP_SERVLET_NAME = "servlet-name";
        private static final String WEB_APP_SERVLET_CLASS = "servlet-class";
        private static final String WEB_APP_SERVLET_MAPPING = "servlet-mapping";
        private static final String WEB_APP_URL_PATTERN = "url-pattern";

        private List<ServletEntity> servletEntities;
        private List<ServletMapping> servletMappings;
        private ServletEntity entity;
        private ServletMapping mapping;

        private String tag;
        private boolean isMapping = false;

        @Override
        public void startDocument() throws SAXException {
            servletEntities = new ArrayList<>();
            servletMappings = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //System.out.println(qName + "---->解析开始");
            if (!Objects.equals(qName, null)) {
                tag = qName;
            }

            if (Objects.equals(qName, WEB_APP_SERVLET)) {
                entity = new ServletEntity();
            }

            if (Objects.equals(qName, WEB_APP_SERVLET_MAPPING)) {
                mapping = new ServletMapping();
                isMapping = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String contents = String.valueOf(ch, start, length).trim();

            if (Objects.equals(tag, WEB_APP_SERVLET_NAME) && isMapping) {
                mapping.setServletName(contents);
            }

            if (Objects.equals(tag, WEB_APP_SERVLET_NAME) && !isMapping) {
                entity.setServletName(contents);
            }

            if (Objects.equals(tag, WEB_APP_SERVLET_CLASS)) {
                entity.setServletClass(contents);
            }

            if (Objects.equals(tag, WEB_APP_URL_PATTERN)) {
                mapping.addUrlPattern(contents);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            //System.out.println(qName + "---->解析结束");
            if (Objects.equals(qName, WEB_APP_SERVLET)) {
                servletEntities.add(entity);
            }

            if (Objects.equals(qName, WEB_APP_SERVLET_MAPPING)) {
                servletMappings.add(mapping);
                isMapping = false;
            }

            tag = null;
        }

        public List<ServletEntity> getServletEntities() {
            return servletEntities;
        }

        public List<ServletMapping> getServletMappings() {
            return servletMappings;
        }
    }


    static class ServletEntity {
        private String servletName;

        private String servletClass;

        public String getServletName() {
            return servletName;
        }

        public void setServletName(String servletName) {
            this.servletName = servletName;
        }

        public String getServletClass() {
            return servletClass;
        }

        public void setServletClass(String servletClass) {
            this.servletClass = servletClass;
        }
    }

    static class ServletMapping {
        private String servletName;
        private List<String> urlPatterns;

        public String getServletName() {
            return servletName;
        }

        public void setServletName(String servletName) {
            this.servletName = servletName;
        }

        public List<String> getUrlPattern() {
            return urlPatterns;
        }

        public void setUrlPattern(List<String> urlPatterns) {
            this.urlPatterns = urlPatterns;
        }

        public void addUrlPattern(String pattern) {
            if (urlPatterns == null) {
                urlPatterns = new ArrayList<>();
            }
            urlPatterns.add(pattern);
        }
    }

}
