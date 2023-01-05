package com.work.on.application.service.domain;

import com.monitorjbl.xlsx.StreamingReader;
import com.work.on.application.service.domain.dto.create.CreateUserCommand;
import com.work.on.application.service.domain.dto.create.CreateUserResponse;
import com.work.on.application.service.domain.dto.track.GetUserQuery;
import com.work.on.application.service.domain.dto.track.GetUserResponse;
import com.work.on.application.service.domain.dto.track.GetUsersResponse;
import com.work.on.application.service.domain.mapper.UserDataMapper;
import com.work.on.application.service.domain.ports.input.service.UserApplicationService;
import com.work.on.application.service.domain.ports.output.repository.CustomerRepository;
import com.work.on.user.service.domain.entity.Customer;
import com.work.on.user.service.domain.exception.UserDomainException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Validated
@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserCreateCommandHandler userCreateCommandHandler;

    private final GetUserQueryHandler getUserQueryHandler;

    private final CustomerRepository customerRepository;

    private final UserDataMapper customerDataMapper;

    public UserApplicationServiceImpl(UserCreateCommandHandler userCreateCommandHandler, GetUserQueryHandler getUserQueryHandler, CustomerRepository customerRepository, UserDataMapper customerDataMapper) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.getUserQueryHandler = getUserQueryHandler;
        this.customerRepository = customerRepository;
        this.customerDataMapper = customerDataMapper;
    }

    @Override
    public CreateUserResponse createUser(List<CreateUserCommand> createUserCommand) {
        userCreateCommandHandler.createUser(createUserCommand);
        return customerDataMapper
                .createUserCommandToCreateUserResponse(createUserCommand.size()+" Users are saved successfully!");
    }

    @Override
    public List<CreateUserCommand> createUserXlsx(MultipartFile file) {
        ArrayList<CreateUserCommand> createUserCommands = new ArrayList<>();
        String fileName = file.getOriginalFilename();
        Set<String> permittedExtensions = new HashSet<>();
        permittedExtensions.add("xlsx");
        String fileExtension = FilenameUtils.getExtension(fileName);
        if (permittedExtensions.contains(fileExtension)) {
            try {
                BufferedInputStream bfs = new BufferedInputStream(file.getInputStream());

                StreamingReader reader = StreamingReader.builder()
                        .rowCacheSize(1000)    // number of rows to keep in memory (defaults to 10)
                        .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                        .sheetIndex(0)        // index of sheet to use (defaults to 0)
                        .read(file.getInputStream());            // InputStream or File for XLSX file (required)

                for(Row row :reader){

                    if(row.getRowNum() != 0){
                        int cont = 0;
                        Customer auxiliarCustomer;
                        CreateUserCommand auxiliarUser = new CreateUserCommand();
                        for(int cn=0; cn<=9; cn++) {
                            //cellIterator.next()

                            Cell nextCell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                            switch (nextCell.getColumnIndex()) {
                                case 0 -> {
                                    try {
                                        auxiliarCustomer = this.customerRepository.findCustomerByName(nextCell.getStringCellValue()).get();
                                    } catch (Exception e) {
                                        log.error("Error: {}", e.getMessage());
                                        throw new UserDomainException("Error: {}" + e.getMessage());
                                    }
                                    auxiliarUser.setCustomerId(auxiliarCustomer.getId().getValue());
                                }
                                case 1 -> auxiliarUser.setName(nextCell.getStringCellValue());
                                case 2 -> auxiliarUser.setCountry(nextCell.getStringCellValue());
                                case 3 -> auxiliarUser.setState(nextCell.getStringCellValue());
                                case 4 -> auxiliarUser.setZone(nextCell.getStringCellValue());
                                case 5 -> auxiliarUser.setJob(nextCell.getStringCellValue());
                                case 6 ->
                                        auxiliarUser.setEmail(nextCell.getStringCellValue());//formatter.formatCellValue(nextCell)
                                case 7 -> auxiliarUser.setControlNumber(nextCell.getStringCellValue());
                                case 8 -> auxiliarUser.setAddress(nextCell.getStringCellValue());
                                default -> System.out.println("Error");
                            }
                            cont++;
                            if (cont == 8) {
                                createUserCommands.add(auxiliarUser);
                                cont = 0;
                            }
                        }
                    }
                }
                bfs.close();
                reader.close();
            } catch (IOException e) {
                log.error("Error message {}", e.getCause().getCause().getMessage().toString());
                throw new UserDomainException("Error message: "+e.getCause().getCause().getMessage().toString());
            }
        } else {
            log.error("Error message: The extension file is not permitted ");
            throw new UserDomainException("Error message: The extension file is not permitted ");
        }
        return createUserCommands;
    }

    @Override
    public List<CreateUserCommand> createUserXls(MultipartFile file) {
        return null;
    }

    @Override
    public List<CreateUserCommand> createUserCsv(MultipartFile file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(file.getInputStream(),"ISO-8859-1"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int contadorHeader = 0;
        String fileName = file.getOriginalFilename();
        String fileExtension = FilenameUtils.getExtension(fileName);
        ArrayList<CreateUserCommand> registrosInsertados = new ArrayList<>();
        String line ="";

        System.out.println(fileExtension);
        try {
            if (fileExtension.equals("csv")) {

                while ((line = br.readLine()) != null) {
                    Customer auxiliarCustomer = new Customer();
                    CreateUserCommand auxiliarUser = new CreateUserCommand();

                    if (contadorHeader > 0) {

                        String[] data = line.split(",");
                        if (data[0].length() > 1) {

                            try {
                                auxiliarCustomer = this.customerRepository.findCustomerByName(data[0]).get();
                            } catch (Exception e) {
                                log.error("Error: ", e.getMessage());
                            }
                            auxiliarUser.setCustomerId(auxiliarCustomer.getId().getValue());
                        }
                        if (data[1].length() > 1) {
                            auxiliarUser.setName(data[1]);
                        }
                        if (data[2].length() > 1) {

                            auxiliarUser.setCountry(data[2]);
                        }
                        if (data[3].length() > 1) {
                            auxiliarUser.setState(data[3]);
                        }
                        if (data[4].length() > 1) {
                            auxiliarUser.setZone(data[4]);
                        }
                        if (data[5].length() > 1) {
                            auxiliarUser.setJob(data[5]);
                        }
                        if (data[6].length() > 1) {
                            auxiliarUser.setEmail(data[6]);
                        }
                        if (data[7].length() > 1) {
                            auxiliarUser.setControlNumber(data[7]);
                        }
                        if (data[8].length() > 1) {
                            auxiliarUser.setAddress(data[8]);
                        }


                        registrosInsertados.add(auxiliarUser);

                    }

                    contadorHeader++;

                }

            } else {
                log.error("Error: No Valid Format for the line {}",contadorHeader);
                throw new UserDomainException("Error: No Valid Format for the line: "+contadorHeader);
            }

        } catch (Exception e) {
            log.error("Error: {}",e.getMessage());
            throw new UserDomainException("Error: "+e.getMessage());
        }
        return registrosInsertados;
    }

    @Override
    public GetUserResponse getUser(GetUserQuery getUserQuery) {

        return getUserQueryHandler.getUser(getUserQuery);

    }

    @Override
    public GetUsersResponse getUserByCountryAndStateAndZone(String country, String state, String zone) {
        return getUserQueryHandler.getUserByCountryAndStateAndZone(country, state, zone);
    }

    @Override
    public GetUserResponse getUserByControlNumber(String uuid) {
        return getUserQueryHandler.getUserByControlNumber(uuid);
    }
}
