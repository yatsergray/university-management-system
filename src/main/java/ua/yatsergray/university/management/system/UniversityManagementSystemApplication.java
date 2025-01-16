package ua.yatsergray.university.management.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.yatsergray.university.management.system.domain.dto.DepartmentDTO;
import ua.yatsergray.university.management.system.domain.dto.LectorDTO;
import ua.yatsergray.university.management.system.domain.type.DegreeType;
import ua.yatsergray.university.management.system.message.MessageProvider;
import ua.yatsergray.university.management.system.service.impl.DepartmentServiceImpl;
import ua.yatsergray.university.management.system.service.impl.LectorServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class UniversityManagementSystemApplication implements CommandLineRunner {
    private final MessageProvider messageProvider;
    private final DepartmentServiceImpl departmentServiceImpl;
    private final LectorServiceImpl lectorServiceImpl;

    @Autowired
    public UniversityManagementSystemApplication(MessageProvider messageProvider, DepartmentServiceImpl departmentServiceImpl, LectorServiceImpl lectorServiceImpl) {
        this.messageProvider = messageProvider;
        this.departmentServiceImpl = departmentServiceImpl;
        this.lectorServiceImpl = lectorServiceImpl;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.printf("%n%s%n", messageProvider.getWelcomeMessage());

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayMenu();

                String input = scanner.nextLine();

                if (input.equalsIgnoreCase(messageProvider.getExitCommandMessage())) {
                    System.out.printf("%n%s%n%n", messageProvider.getExitingMessage());

                    break;
                }

                processCommand(scanner, input);
            }
        }
    }

    private void displayMenu() {
        System.out.printf("%n%s%n", messageProvider.getChooseCommandNumberMessage(messageProvider.getExitCommandMessage()));
        System.out.printf("1. %s%n", messageProvider.getDepartmentHeadCommandMessage());
        System.out.printf("2. %s%n", messageProvider.getDepartmentStatisticsCommandMessage());
        System.out.printf("3. %s%n", messageProvider.getDepartmentAverageSalaryCommandMessage());
        System.out.printf("4. %s%n", messageProvider.getDepartmentEmployeeCountCommandMessage());
        System.out.printf("5. %s%n", messageProvider.getLectorGlobalSearchCommandMessage());
        System.out.printf("%n%s%n", messageProvider.getEnterCommandNumberMessage());
    }

    private void processCommand(Scanner scanner, String input) {
        try {
            int commandNumber = Integer.parseInt(input);

            switch (commandNumber) {
                case 1 -> handleDepartmentHead(scanner);
                case 2 -> handleDepartmentStatistics(scanner);
                case 3 -> handleDepartmentAverageSalary(scanner);
                case 4 -> handleDepartmentEmployeeCount(scanner);
                case 5 -> handleLectorGlobalSearch(scanner);
                default -> System.out.printf("%n%s%n", messageProvider.getInvalidCommandNumberMessage());
            }
        } catch (NumberFormatException e) {
            System.out.printf("%n%s%n", messageProvider.getInvalidInputMessage());
        }
    }

    private void handleDepartmentHead(Scanner scanner) {
        String departmentName = promptForDepartmentName(scanner);
        DepartmentDTO departmentDTO = getDepartmentByName(departmentName);

        if (departmentDTO == null) {
            return;
        }

        LectorDTO headDTO = departmentDTO.getHeadDTO();
        String result = String.format("%s %s", headDTO.getFirstName(), headDTO.getLastName());

        System.out.printf("%n%s%n", messageProvider.getCommandResultMessage(messageProvider.getDepartmentHeadResultMessage(departmentName, result)));
    }

    private void handleDepartmentStatistics(Scanner scanner) {
        String departmentName = promptForDepartmentName(scanner);
        DepartmentDTO departmentDTO = getDepartmentByName(departmentName);

        if (departmentDTO == null) {
            return;
        }

        long assistantsCount = countByDegree(departmentDTO, DegreeType.ASSISTANT);
        long associateProfessorsCount = countByDegree(departmentDTO, DegreeType.ASSOCIATE_PROFESSOR);
        long professorsCount = countByDegree(departmentDTO, DegreeType.PROFESSOR);

        System.out.printf("%n%s%n", messageProvider.getCommandResultMessage(messageProvider.getDepartmentStatisticsResultMessage(assistantsCount, associateProfessorsCount, professorsCount)));
    }

    private void handleDepartmentAverageSalary(Scanner scanner) {
        String departmentName = promptForDepartmentName(scanner);
        DepartmentDTO departmentDTO = getDepartmentByName(departmentName);

        if (departmentDTO == null) {
            return;
        }

        BigDecimal averageSalary = departmentDTO.getLectorDTOList().stream()
                .map(LectorDTO::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(departmentDTO.getLectorDTOList().size()), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.printf("%n%s%n", messageProvider.getCommandResultMessage(messageProvider.getDepartmentAverageSalaryResultMessage(departmentName, averageSalary)));
    }

    private void handleDepartmentEmployeeCount(Scanner scanner) {
        String departmentName = promptForDepartmentName(scanner);
        DepartmentDTO departmentDTO = getDepartmentByName(departmentName);

        if (departmentDTO == null) {
            return;
        }

        long employeeCount = departmentDTO.getLectorDTOList().size();

        System.out.printf("%n%s%n", messageProvider.getCommandResultMessage(messageProvider.getDepartmentEmployeeCountResultMessage(departmentName, employeeCount)));
    }

    private void handleLectorGlobalSearch(Scanner scanner) {
        System.out.printf("%n%s%n", messageProvider.getLectorNameTemplateInputMessage());

        String lectorNameTemplate = scanner.nextLine();

        List<String> lectorNames = lectorServiceImpl.getAllLectorsByNameTemplate(lectorNameTemplate).stream()
                .map(lectorDTO -> String.format("%s %s", lectorDTO.getFirstName(), lectorDTO.getLastName()))
                .toList();

        if (lectorNames.isEmpty()) {
            System.out.printf("%n%s%n", messageProvider.getNoLectorsFoundMessage(lectorNameTemplate));

            return;
        }

        String result = String.join(", ", lectorNames);

        System.out.printf("%n%s%n", messageProvider.getCommandResultMessage(messageProvider.getLectorGlobalSearchResultMessage(lectorNameTemplate, result)));
    }

    private String promptForDepartmentName(Scanner scanner) {
        System.out.printf("%n%s%n", messageProvider.getDepartmentNameInputMessage());

        return scanner.nextLine().trim();
    }

    private DepartmentDTO getDepartmentByName(String departmentName) {
        Optional<DepartmentDTO> optionalDepartment = departmentServiceImpl.getDepartmentByName(departmentName);

        if (optionalDepartment.isEmpty()) {
            System.out.printf("%n%s%n", messageProvider.getDepartmentNotExistMessage(departmentName));

            return null;
        }

        return optionalDepartment.get();
    }

    private long countByDegree(DepartmentDTO departmentDTO, DegreeType degreeType) {
        return departmentDTO.getLectorDTOList().stream()
                .filter(lectorDTO -> lectorDTO.getDegreeDTO().getType().equals(degreeType))
                .count();
    }
}
