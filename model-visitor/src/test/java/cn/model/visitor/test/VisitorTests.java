package cn.model.visitor.test;

import cn.model.visitor.client.Visitor;
import cn.model.visitor.eimpl.OamElement;
import cn.model.visitor.eimpl.OmmElement;
import cn.model.visitor.util.VisitorUtils;
import cn.model.visitor.vimpl.CreateAllVisitor;
import cn.model.visitor.vimpl.DeleteAllVisitor;
import cn.model.visitor.vimpl.ModifyAllVisitor;
import cn.model.visitor.vimpl.QueryAllVisitor;
import org.junit.Test;

public class VisitorTests {

    @Test
    public void visitor() {
        OamElement oamElement = new OamElement();
        OmmElement ommElement = new OmmElement();
        VisitorUtils.getInstance().putElement(oamElement);
        VisitorUtils.getInstance().putElement(ommElement);

        Visitor visitor = new CreateAllVisitor();
        VisitorUtils.getInstance().accept(visitor);
        visitor = new ModifyAllVisitor();
        VisitorUtils.getInstance().accept(visitor);
        visitor = new QueryAllVisitor();
        VisitorUtils.getInstance().accept(visitor);
        visitor = new DeleteAllVisitor();
        VisitorUtils.getInstance().accept(visitor);
    }
}
