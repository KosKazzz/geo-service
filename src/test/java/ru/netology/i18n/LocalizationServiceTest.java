package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.BRAZIL;
import static ru.netology.entity.Country.RUSSIA;

public class LocalizationServiceTest {
    @Test
    void localizationServiceImpl_RUS_Test() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(RUSSIA);

        Assertions.assertEquals("Добро пожаловать", actual);
    }

    @Test
    void localizationServiceImpl_default_Test() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(BRAZIL);

        Assertions.assertEquals("Welcome", actual);
    }
}
