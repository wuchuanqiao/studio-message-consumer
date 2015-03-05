import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

public class Consumer {
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		AmqpTemplate amqpTemplate = ctx.getBean("rabbitTemplate",AmqpTemplate.class);
//		AmqpTemplate amqpTemplate = ctx.getBean(AmqpTemplate.class);

		while (true){
//			Message message = amqpTemplate.receive();
			Object message = amqpTemplate.receiveAndConvert();
			if (null!=message){
				System.out.println(message);
			}
		}
	}
}
