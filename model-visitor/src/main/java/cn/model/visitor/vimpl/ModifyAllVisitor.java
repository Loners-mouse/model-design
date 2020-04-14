package cn.model.visitor.vimpl;

import cn.model.visitor.client.Visitor;
import cn.model.visitor.eimpl.OamElement;
import cn.model.visitor.eimpl.OmmElement;

public class ModifyAllVisitor implements Visitor {

    @Override
    public void operateOam(OamElement element) {
        element.action("MODIFY");
    }

    @Override
    public void operateOmm(OmmElement element) {
        element.action("MODIFY");
    }
}
