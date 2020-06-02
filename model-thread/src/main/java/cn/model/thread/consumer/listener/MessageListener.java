package cn.model.thread.consumer.listener;

import cn.model.thread.consumer.BlockQueueHandler;
import cn.model.thread.model.Element;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;

@Service
@Slf4j
public class MessageListener {

    /**
     * 监听到消息直接放入队列
     *
     * @param element
     */
    public void execute(Element element) {
        log.info("execute() id={}", element.getId());
        BlockQueueHandler.getInstance().putIfNot(element);
        log.info("execute() done!");
    }
}
