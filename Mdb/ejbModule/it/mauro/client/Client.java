package it.mauro.client;

import it.mauro.dto.Employee;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Session Bean implementation class Client
 */
@Stateless
@LocalBean
public class Client {
	

	final String QUEUE_LOOKUP = "queue/MyQueue";
    final String CONNECTION_FACTORY = "ConnectionFactory";
    /**
     * Default constructor. 
     */
    public Client() {
        // TODO Auto-generated constructor stub
    }
    @Schedule(second="1", minute="25",hour="12", dayOfWeek ="Mon",  persistent=false)
    public void Start() {
    	
    	
         
        
        try{
            Context context = new InitialContext();
            QueueConnectionFactory factory = 
                (QueueConnectionFactory)context.lookup(CONNECTION_FACTORY);
            QueueConnection connection = factory.createQueueConnection();
            QueueSession session = 
                connection.createQueueSession(false, 
                    QueueSession.AUTO_ACKNOWLEDGE);
             
            Queue queue = (Queue)context.lookup(QUEUE_LOOKUP);
            QueueSender sender = session.createSender(queue);
             
            //1. Sending TextMessage to the Queue 
            TextMessage message = session.createTextMessage();
            message.setText("Hello EJB3 MDB Queue!!!");
            sender.send(message);
            System.out.println("1. Sent TextMessage to the Queue");
             
            //2. Sending ObjectMessage to the Queue
            ObjectMessage objMsg = session.createObjectMessage();
             
            Employee employee = new Employee();
            employee.setId(2163);
            employee.setName("Kumar");
            employee.setDesignation("CTO");
            employee.setSalary(100000);
            objMsg.setObject(employee);                     
            sender.send(objMsg);
            System.out.println("2. Sent ObjectMessage to the Queue");
             
            session.close();
        }catch(Exception e){e.printStackTrace();}

    }
}
