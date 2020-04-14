package cn.model.flyweight.impl;

import cn.model.flyweight.client.FlyWeight;
import cn.model.flyweight.model.Context;

public class UnShareFlyWeight implements FlyWeight {

    @Override
    public void operation(Context context) {
        System.out.println("不共享 id=" + context.getId() + "; name=" + context.getName() + ";");
    }
}
