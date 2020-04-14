package cn.model.visitor.vimpl;

import cn.model.visitor.client.Visitor;
import cn.model.visitor.eimpl.OamElement;
import cn.model.visitor.eimpl.OmmElement;

public class QueryAllVisitor implements Visitor {

    @Override
    public void operateOam(OamElement element) {
        element.action("QUERY");
    }

    @Override
    public void operateOmm(OmmElement element) {
        element.action("QUERY");
    }
}
