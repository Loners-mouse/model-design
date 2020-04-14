package cn.model.flyweight;

import cn.model.flyweight.client.FlyWeight;
import cn.model.flyweight.factory.FWFactory;
import cn.model.flyweight.model.Context;

public class FlyWeightApp {

    public static void main(String[] args) {
        FWFactory.initFactory();
        FlyWeight flyWeight = FWFactory.getFlyWeight("1");
        flyWeight.operation(new Context("1", "fly1"));
    }
}
