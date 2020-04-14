package cn.model.visitor.util;

import cn.model.visitor.client.Element;
import cn.model.visitor.client.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorUtils {

    private static VisitorUtils instance = new VisitorUtils();
    List<Element> elements = new ArrayList<>();

    public static VisitorUtils getInstance() {
        return instance;
    }

    public void putElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element e : elements) {
            e.inject2Visitor(visitor);
        }
    }
}
