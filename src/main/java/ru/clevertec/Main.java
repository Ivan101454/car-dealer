package ru.clevertec;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.Proxy;
import ru.clevertec.dealer.utils.HibernateUtil;


public class Main {

    public static void main(String[] args) {
        Session session = initDatabaseSession();

    }

    private static Session initDatabaseSession() {
        SessionFactory sessionFactory = HibernateUtil.buildFactory();
        return (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
    }
}
