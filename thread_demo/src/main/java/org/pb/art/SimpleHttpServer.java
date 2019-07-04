package org.pb.art;

import org.pb.util.CommonUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.SortedSet;

/**
 * @author boge.peng
 * @create 2019-05-09 1:00
 */
public class SimpleHttpServer {

    /**
     * 处理HttpRequest的线程池
     */
    private static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(20);

    /**
     * SimpleHttpServer根路径
     */
    private static String basePath;

    private static ServerSocket serverSocket;

    /**
     * 服务监听端口
     */
    private static int port = 8080;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (Objects.nonNull(basePath) && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    public static void start() throws Exception {
        serverSocket = new ServerSocket(port);
        Socket socket = null;

        while (Objects.nonNull(socket = serverSocket.accept())) {
            threadPool.execute(new HttpRequestHandler(socket));
        }

        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable {

        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());

                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    int i = 0;
                    while ((i = reader.read()) != -1) {
                        baos.write(i);
                    }

                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println();
                    out.println("=================");
                    socket.getOutputStream().write(array, 0, array.length);
                } else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html;charset=UTF-8");
                    out.println();
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }

                }

                out.flush();

            } catch (IOException e) {
                //e.printStackTrace();
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                CommonUtils.release(br, in, reader, out, socket);
            }

        }
    }

    public static void main(String[] args) {
        SimpleHttpServer.setBasePath("D:\\simpleHttpServer\\");
        try {
            SimpleHttpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
