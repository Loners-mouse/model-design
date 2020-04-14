package cn.model.visitor.eimpl;

import cn.model.visitor.client.Element;
import cn.model.visitor.client.Visitor;

public class OamElement implements Element {

    public void action(String operation) {

        switch (operation) {
            case "CREATE":
                System.out.println("this is oam create");
                break;
            case "MODIFY":
                System.out.println("this is oam modify");
                break;
            case "QUERY":
                System.out.println("this is oam query");
                break;
            case "DELETE":
                System.out.println("this is oam delete");
                break;
            default:
                System.out.println("this is oam default");
                break;
        }
    }

    @Override
    public void inject2Visitor(Visitor visitor) {
        visitor.operateOam(this);
    }
}
