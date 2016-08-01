package xyz.skycat.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by SS on 2016/08/02.
 */
public class Main {
    public static void main(String... args){
        doHello();
    }

    private static void doHello() {
        evalByNashorn("'Hello, World!'.length");
    }

    private static void evalByNashorn(String str) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        Object eval = null;
        try {
            eval = engine.eval(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(eval);
    }
}
