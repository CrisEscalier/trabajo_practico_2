package ar.edu.unju.fi.ejercicio3.model;

public enum Provincia {
	//PROVICNIA(POBLACION,SUPERFICIE EN KM2)
	//Datos poblacionales del censo de 2022
	//https://es.wikipedia.org/wiki/Provincias_de_Argentina
	JUJUY(811_611, 53_219), 
    SALTA(1_441_351, 155_488),
    TUCUMAN(1_731_820, 22_524), 
    CATAMARCA(429_562, 102_602),
    LA_RIOJA(383_865, 89_680),
    SANTIAGO_DEL_ESTERO(1_060_906, 136_351);

    private int cantidadPoblacion;
    private int superficie;

    private Provincia(int cantidadPoblacion, int superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public int getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public void setCantidadPoblacion(int cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    /**
     * Metodo que calcula la densidad poblacional
     * @return la densidad poblacional
     */
    public double calcularDensidadPoblacional() {
        return (double) cantidadPoblacion / superficie;
    }

}
