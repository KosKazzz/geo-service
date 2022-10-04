package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;


import static ru.netology.entity.Country.*;

@ExtendWith(MockitoExtension.class)
public class MessageSenderTest {
    @Mock
    GeoService geoServiceImplMock;
    @Mock
    LocalizationService localizationServiceImplMock;
    @Mock
    Location locationMock;


    @Test
    void messageSender_send_rus_text_for_rus_ip() {
        Mockito.when(locationMock.getCountry()).thenReturn(RUSSIA);
        Mockito.when(geoServiceImplMock.byIp("172.123.12.19")).
                thenReturn(locationMock);
        Mockito.when(localizationServiceImplMock.locale(RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl msg =
                new MessageSenderImpl(geoServiceImplMock, localizationServiceImplMock);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        Assertions.assertEquals("Добро пожаловать", msg.send(headers));
    }

    @Test
    void messageSender_send_US_text_for_US_ip() {
        Mockito.when(locationMock.getCountry()).thenReturn(USA);
        Mockito.when(geoServiceImplMock.byIp("96.44.183.149")).
                thenReturn(locationMock);
        Mockito.when(localizationServiceImplMock.locale(USA))
                .thenReturn("Welcome");

        MessageSenderImpl msg =
                new MessageSenderImpl(geoServiceImplMock, localizationServiceImplMock);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        Assertions.assertEquals("Welcome", msg.send(headers));
    }
}