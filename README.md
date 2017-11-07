# Ejb-Mdb-Scheduler
Example of EJB Message Driven Bean (sender e receiver architecture) with scheduler that ships the message at a specific day and time of the week, for example every Monday at 12:25 pm.

Used technology : HornetQ Jms Queue with acknowledgment session mode setted to AUTO_ACKNOWLEDGE <br>
Application Server Target : JBoss AS 7.1.1.Final

JBoss standalone.xml configuration tag :

`<jms-destinations>
    <jms-queue name="testQueue">
         <entry name="queue/MyQueue"/>
    </jms-queue>
</jms-destinations>`

____________________________________

October 2017 - @author : Mauro Camelo
