package xin.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : 小新青年
 * @date : 2019-11-28  19:25
 * 描述 : 定时任务2
 **/
@Component
public class Scheduler2Task {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    private int count=0;
    @Scheduled(initialDelay=10000, fixedRate=2000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + DATE_FORMAT.format(new Date())+" --> "+(++count)+"次");
    }
}
