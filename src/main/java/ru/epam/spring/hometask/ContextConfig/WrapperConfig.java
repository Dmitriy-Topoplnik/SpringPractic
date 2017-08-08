package ru.epam.spring.hometask.ContextConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.epam.spring.hometask.DAO.AuditoriumDAO;
import ru.epam.spring.hometask.DAO.EventDAO;
import ru.epam.spring.hometask.DAO.TicketsDAO;
import ru.epam.spring.hometask.DAO.UserDAO;
import ru.epam.spring.hometask.utils.UserBundle;
import ru.epam.spring.hometask.utils.wrapper.AuditoriumServiceWrapper;
import ru.epam.spring.hometask.utils.wrapper.BookingServiceWrapper;
import ru.epam.spring.hometask.utils.wrapper.EventServiceWrapper;
import ru.epam.spring.hometask.utils.wrapper.UserServiceWraper;

/**
 * Created by Dmitrii_Topolnik on 8/8/2017.
 */
@Configuration
public class WrapperConfig {
    @Autowired
    private TicketsDAO ticketsDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @Autowired
    private UserBundle userBundle;

    @Bean
    public EventServiceWrapper getEventServiceWrapper(){
        return new EventServiceWrapper(eventDAO,auditoriumDAO);
    }

    @Bean
    public UserServiceWraper getUserServiceWraper(){
        return new UserServiceWraper(userDAO,userBundle);
    }

    @Bean
    public AuditoriumServiceWrapper getAuditoriumServiceWrapper(){
        return new AuditoriumServiceWrapper(auditoriumDAO);
    }

    @Bean
    public BookingServiceWrapper getBookingServiceWrapper(){
        return new BookingServiceWrapper(ticketsDAO,eventDAO,userDAO);
    }
}
