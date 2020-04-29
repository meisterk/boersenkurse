package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


public class MaxKursAnstiegFallTest {
    private MaxKursAnstiegFall maxKursAnstiegFall;

    @BeforeEach
    void init(){
        // Arrange
        IBoersenReader boersenReader = mock(IBoersenReader.class);
        when(boersenReader.readKurs("Telekom", 2019)).thenReturn(new double[]{12.0, 17.3, 2.0, 37.99, 5.0});
        when(boersenReader.readKurs("Vodafone", 2017)).thenReturn(new double[]{12.3, 13.4, 123.4, 1.0});
        maxKursAnstiegFall = new MaxKursAnstiegFall(boersenReader);
    }

    @Test
    void maxKursAnstieg_Telekom_2019_Test(){
        double result = maxKursAnstiegFall.maxKursAnstieg("Telekom", 2019);
        assertThat(result).isEqualTo(37.99 - 2.0);
    }

    @Test
    void maxKursAnstieg_Vodafone_2017_Test(){
        double result = maxKursAnstiegFall.maxKursAnstieg("Vodafone", 2017);
        assertThat(result).isEqualTo(123.4 - 13.4);
    }
    @Test
    void maxKursFall_Telekom_2019_Test(){
        double result = maxKursAnstiegFall.maxKursFall("Telekom", 2019);
        assertThat(result).isEqualTo(37.99 - 5.0);
    }

    @Test
    void maxKursFall_Vodafone_2017_Test(){
        double result = maxKursAnstiegFall.maxKursFall("Vodafone", 2017);
        assertThat(result).isEqualTo(123.4 - 1.0);
    }
}
