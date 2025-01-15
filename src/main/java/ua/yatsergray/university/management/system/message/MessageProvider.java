package ua.yatsergray.university.management.system.message;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MessageProvider {

    @Getter
    @Value("${department.head.name.command.message}")
    private String departmentHeadCommandMessage;

    @Value("${department.head.name.result.message}")
    private String departmentHeadResultMessage;

    @Getter
    @Value("${department.statistic.command.message}")
    private String departmentStatisticsCommandMessage;

    @Value("${department.statistic.result.message}")
    private String departmentStatisticsResultMessage;

    @Getter
    @Value("${department.average.salary.command.message}")
    private String departmentAverageSalaryCommandMessage;

    @Value("${department.average.salary.result.message}")
    private String departmentAverageSalaryResultMessage;

    @Getter
    @Value("${department.employee.count.command.message}")
    private String departmentEmployeeCountCommandMessage;

    @Value("${department.employee.count.result.message}")
    private String departmentEmployeeCountResultMessage;

    @Getter
    @Value("${lector.global.search.command.message}")
    private String lectorGlobalSearchCommandMessage;

    @Value("${lector.global.search.result.message}")
    private String lectorGlobalSearchResultMessage;

    @Getter
    @Value("${department.name.input.message}")
    private String departmentNameInputMessage;

    @Getter
    @Value("${lector.name.template.input.message}")
    private String lectorNameTemplateInputMessage;

    @Getter
    @Value("${command.is.not.supported.message}")
    private String commandIsNotSupportedMessage;

    @Getter
    @Value("${welcome.university.management.system.message}")
    private String welcomeMessage;

    @Getter
    @Value("${exiting.university.management.system.message}")
    private String exitingMessage;

    @Getter
    @Value("${exit.command.message}")
    private String exitCommandMessage;

    @Getter
    @Value("${choose.command.number.message}")
    private String chooseCommandNumberMessage;

    @Getter
    @Value("${enter.command.number.message}")
    private String enterCommandNumberMessage;

    @Getter
    @Value("${invalid.command.number.message}")
    private String invalidCommandNumberMessage;

    @Getter
    @Value("${invalid.input.message}")
    private String invalidInputMessage;

    @Value("${command.result.message}")
    private String commandResultMessage;

    @Value("${no.lectors.found}")
    private String noLectorsFoundMessage;

    @Getter
    @Value("${department.not.exist}")
    private String departmentNotExistMessage;

    public String getDepartmentHeadResultMessage(String departmentName, String headName) {
        return String.format(departmentHeadResultMessage, departmentName, headName);
    }

    public String getDepartmentStatisticsResultMessage(Long assistantsCount, Long associateProfessorsCount, Long professorsCount) {
        return String.format(departmentStatisticsResultMessage, assistantsCount, associateProfessorsCount, professorsCount);
    }

    public String getDepartmentAverageSalaryResultMessage(String departmentName, BigDecimal averageSalary) {
        return String.format(departmentAverageSalaryResultMessage, departmentName, averageSalary);
    }

    public String getDepartmentEmployeeCountResultMessage(String departmentName, Long employeeCount) {
        return String.format(departmentEmployeeCountResultMessage, departmentName, employeeCount);
    }

    public String getLectorGlobalSearchResultMessage(String template, String results) {
        return String.format(lectorGlobalSearchResultMessage, template, results);
    }

    public String getCommandResultMessage(String result) {
        return String.format(commandResultMessage, result);
    }

    public String getNoLectorsFoundMessage(String template) {
        return String.format(noLectorsFoundMessage, template);
    }

    public String getDepartmentNotExistMessage(String departmentName) {
        return String.format(departmentNotExistMessage, departmentName);
    }
}

