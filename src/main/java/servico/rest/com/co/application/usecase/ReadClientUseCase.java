package servico.rest.com.co.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servico.rest.com.co.application.dto.ClienteDto;
import servico.rest.com.co.infraestructure.out.Repository.ClientRepository;
import servico.rest.com.co.infraestructure.out.service.IClientService;

@Service
public class ReadClientUseCase implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClienteDto readCliente() {
          ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clientRepository.getAllClients(), ClienteDto.class);
    }
}
