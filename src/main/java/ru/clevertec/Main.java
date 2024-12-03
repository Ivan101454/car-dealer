package ru.clevertec;

import org.hibernate.Session;

import ru.clevertec.dealer.utils.HibernateUtil;


public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.initDatabaseSession();

    }



}
