package cn.model.visitor.client;

import cn.model.visitor.eimpl.OamElement;
import cn.model.visitor.eimpl.OmmElement;

public interface Visitor {

    void operateOam(OamElement element);

    void operateOmm(OmmElement element);
}
