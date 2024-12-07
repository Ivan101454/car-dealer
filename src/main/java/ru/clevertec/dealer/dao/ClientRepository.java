package ru.clevertec.dealer.dao;

import org.hibernate.Session;
import ru.clevertec.dealer.entity.Client;

public class ClientRepository extends RepositoryBase<Long, Client>{

    public ClientRepository(Session session) {
        super(Client.class, session);
    }
}
