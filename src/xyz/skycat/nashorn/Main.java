package xyz.skycat.nashorn;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SS on 2016/08/02.
 */
public class Main {
    public static void main(String... args) {
        doHello();
        doBindings();
    }

    private static void doHello() {
        evalByNashorn("'Hello, World!'.length");
    }

    private static void doBindings() {
        Map<String, Object> map = new HashMap<>();
        map.put("stage", "EASY");
        evalByNashorn("'stege = ' + stage", map);
    }

    private static void evalByNashorn(String str) {
        evalByNashorn(str, null);
    }

    private static void evalByNashorn(String str, Map<String, Object> map) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        Object eval = null;
        try {
            if (map == null) {
                eval = engine.eval(str);
            } else {
                Bindings scope = engine.createBindings();
                map.forEach((k, v) -> scope.put(k, v));
                eval = engine.eval(str, scope);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(eval);
    }
}
