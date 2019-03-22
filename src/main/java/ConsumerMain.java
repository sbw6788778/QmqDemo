import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext("classpath:spring-consumer.xml");
            ctx.start();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ConsumerMain.class.getName() + " started!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.exit(1);
            if (ctx != null) {
                ctx.close();
            }
        }
    }
}
