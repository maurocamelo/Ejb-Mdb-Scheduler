# Ejb-Mdb-Scheduler
Example of EJB Message Driven Bean with scheduler that ships the message at a specific day and time of the week (for example every Monday at 12:25 pm)

Used technology : HornetQ Jms Queue<br>
Application Server Target : JBoss AS 7.1.1.Final

JBoss standalone.xml tag :

`<jms-destinations>
    <jms-queue name="testQueue">
         <entry name="queue/MyQueue"/>
    </jms-queue>
</jms-destinations>`

____________________________________

October 2017 - @author : Mauro Camelo
