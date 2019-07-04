package org.pb.rhino;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author boge.peng
 * @create 2018-12-27 19:14
 */
public class Demo01 {
    public static void main(String[] args) {
        ScriptEngineManager script = new ScriptEngineManager();
        ScriptEngine engine = script.getEngineByName("javascript");

        engine.put("msg","bobo is a good man!");

        //engine.eval("msg");
    }
}
