package com.faramarz.spring.basic;

import com.faramarz.spring.basic.phase1.PaymentOperation;
import com.faramarz.spring.basic.phase2.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicApplication {

    /**
     * har class ke @component dasht oon class mishe bean
     * A Java class decorated with @Component is found during classpath scanning and registered in the
     * context as a Spring bean.
     *
     * @ComponentScan ensures that the classes decorated with @Component are found and registered
     * as Spring beans.
     * <p>
     * The Spring container is at the core of the Spring Framework.
     * The container will create the objects, wire them together, configure them,
     * and manage their complete life cycle from creation till destruction.
     * The Spring container uses DI to manage the components that make up an application.
     * These objects are called Spring Beans.
     * <p>
     * If more than one bean of the same type is available in the container,
     * the framework will throw NoUniqueBeanDefinitionException,
     * indicating that more than one bean is available for autowiring.
     */

    private static Logger logger = LoggerFactory.getLogger(BasicApplication.class);

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(BasicApplication.class, args);
        PaymentOperation paymentOperation = context.getBean(PaymentOperation.class);
        PaymentOperation paymentOperation2 = context.getBean(PaymentOperation.class);


        /** **** ye nokte khili mohem ******
         *
         * age biay tuye class PersonDAO @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) bezari instance haye personDAO1 , personDAO2
         * ba ham fargh mikonan va getJdbcConnection hashun yeksane (chon vaghti tuye jdbc-connection chizi nist by default type singleton hast)
         * hala bia @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) ro az class PersonDAO bardar bebar class JdbcConnection
         * inja mibini ham instance haye PersonDAO va ham instance haye JdbcConnection yeksan shodan .... CHERA???
         * chon to kollan dari bean ro az PersonDAO migiri ( @Autowired et dar class PersonDAO) va khob JdbcConnection asan dekhalati nadare inja
         * amma ye rahe hal dari ke PersonDAO ro bezari singleton bemune vali JdbcConnection ro prototype koni onam injuri --->
         *          @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
         *
         *
         *
         *
         *
         */
        PersonDAO personDAO1 = context.getBean(PersonDAO.class);
        PersonDAO personDAO2 = context.getBean(PersonDAO.class);
        logger.info("{}", personDAO1);
        logger.info("{}", personDAO1.getJdbcConnection());

        logger.info("{}", personDAO2);
        logger.info("{}", personDAO2.getJdbcConnection());


        /**
         *  1) These are singleton beans (beans scope) one instance per spring context
         *          paymentOperation & paymentOperation2 also same with together:
         *          two reference objs but actually one obj
         *  2) prototype mode: new bean when you request
         *  3) request mode: one bean per HTTP request
         *  4) session mode: one bean per HTTP session
         *
         *  By default is singleton
         */

        System.out.println(paymentOperation.hashCode());
        System.out.println(paymentOperation2.hashCode());

        paymentOperation.getAtmPayment();
        paymentOperation.getMobileBankPayment();

    }

}