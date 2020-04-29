package de.kohnlehome;

public class MaxKursAnstiegFall implements IMaxKursAnstiegFall{
    IBoersenReader boersenReader;

    public MaxKursAnstiegFall(IBoersenReader boersenReader) {
        this.boersenReader = boersenReader;
    }

    @Override
    public double maxKursAnstieg(String aktienname, int jahr) {
        return 0;
    }

    @Override
    public double maxKursFall(String aktienname, int jahr) {
        return 0;
    }
}
