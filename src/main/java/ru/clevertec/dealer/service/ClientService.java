package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.ClientDto;
import ru.clevertec.dealer.entity.Client;
import ru.clevertec.dealer.mapper.CarMapper;
import ru.clevertec.dealer.dao.ClientRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Optional<ClientDto> findById(Long id) {
        return clientRepository.finById(id).map(CarMapper.INSTANCE::clientToClientDto);
    }

    public List<ClientDto> findAllStore() {
        return clientRepository.findAll().stream().map(CarMapper.INSTANCE::clientToClientDto).toList();
    }

    public Client create(ClientDto clientDto) {
        Client client = CarMapper.INSTANCE.clientDtoToClient(clientDto);
        return clientRepository.save(client);
    }

    public void update(ClientDto clientDto) {
        clientRepository.update(CarMapper.INSTANCE.clientDtoToClient(clientDto));
    }

    public boolean delete(Long id) {
        Optional<Client> client = clientRepository.finById(id);
        client.ifPresent(a -> clientRepository.delete(a.getClientId()));
        return client.isPresent();
    }

    public void buyCar(Long idOfClient, CarDto carDto) {
        Optional<Client> client = Optional.ofNullable(clientRepository.finById(idOfClient)
                .orElseThrow(() -> new RuntimeException("Клиент не найден")));
        client.ifPresent(c -> c.buyACar(CarMapper.INSTANCE.carDtoToCar(carDto)));
        client.ifPresent(clientRepository::update);
    }





}
