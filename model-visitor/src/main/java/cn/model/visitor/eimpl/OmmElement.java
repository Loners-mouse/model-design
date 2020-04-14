package cn.model.visitor.eimpl;

import cn.model.visitor.client.Element;
import cn.model.visitor.client.Visitor;

public class OmmElement implements Element {

    public void action(String operation) {

        switch (operation) {
            case "CREATE":
                System.out.println("this is omm create");
                break;
            case "MODIFY":
                System.out.println("this is omm modify");
                break;
            case "QUERY":
                System.out.println("this is omm query");
                break;
            case "DELETE":
                System.out.println("this is omm delete");
                break;
            default:
                System.out.println("this is omm default");
                break;
        }
    }

    @Override
    public void inject2Visitor(Visitor visitor) {
        visitor.operateOmm(this);
    }
}
