package ru.job4j.professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для классов профессий.
 * @author vzamylin
 * @version 1
 * @since 21.03.2018
 */
public class ProfessionTest {

    /**
     * Проверка общих методов для всех классов-профессий из иерархии наследования.
     */
    @Test
    public void whenCommonMethodsCalled() {
        assertThat(new Profession("Profession").getName(), is("Profession"));
        assertThat(new Doctor("Doctor").getName(), is("Doctor"));
        assertThat(new Engineer("Engineer").getName(), is("Engineer"));
        assertThat(new Teacher("Teacher").getName(), is("Teacher"));
    }

    /**
     * Проверка методов вспомогательных объектов, над которыми осуществляются действия в профессиях.
     */
    @Test
    public void whenAdditionalObjects() {
        assertThat(new Patient("Patient").getName(), is("Patient"));
        assertThat(new House("Address").getAddress(), is("Address"));
        assertThat(new Student("Student").getName(), is("Student"));
    }

    /**
     * Проверка вызова специфических методов для конкретных профессий.
     */
    @Test
    public void whenSpecifiedMethodsCalled() {
        int calledCount = 0; // Счетчик вызовов методов.
        Profession[] professionArray = new Profession[4];
        professionArray[0] = new Profession("Profession");
        professionArray[1] = new Doctor("Doctor");
        professionArray[2] = new Engineer("Engineer");
        professionArray[3] = new Teacher("Teacher");
        for (Profession profession : professionArray) {
            profession.getName();
            calledCount++;
            if (profession instanceof Doctor) {
                ((Doctor) profession).heal(new Patient("Patient"));
                calledCount++;
            } else if (profession instanceof Engineer) {
                ((Engineer) profession).build(new House("Address"));
                calledCount++;
            } else if (profession instanceof Teacher) {
                ((Teacher) profession).teach(new Student("Student"));
                calledCount++;
            }
        }
        assertThat(calledCount, is(7));
    }
}