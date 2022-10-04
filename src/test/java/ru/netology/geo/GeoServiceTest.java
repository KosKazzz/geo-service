package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class GeoServiceTest {
    @Test
    void geoServiceImpl_USA_Test() {

        GeoService geoService = new GeoServiceImpl();
        Country actual = geoService.byIp("96.120.33.250").getCountry();

        Assertions.assertEquals(USA, actual);
    }

    @Test
    void geoServiceImpl_RUS_Test() {

        GeoService geoService = new GeoServiceImpl();
        Country actual = geoService.byIp("172.120.33.250").getCountry();

        Assertions.assertEquals(RUSSIA, actual);
    }
}
