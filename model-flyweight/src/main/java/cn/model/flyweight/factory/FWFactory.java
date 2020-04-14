package cn.model.flyweight.factory;

import cn.model.flyweight.client.FlyWeight;
import cn.model.flyweight.impl.ShareFlyWeight;

import java.util.HashMap;
import java.util.Map;

public class FWFactory {

    private static Map<String, FlyWeight> shareMaps = new HashMap<>();

    public static void initFactory() {
        shareMaps.put("1", new ShareFlyWeight());
        shareMaps.put("2", new ShareFlyWeight());
        shareMaps.put("3", new ShareFlyWeight());
    }

    public static FlyWeight getFlyWeight(String id) {
        return shareMaps.get(id);
    }
}
