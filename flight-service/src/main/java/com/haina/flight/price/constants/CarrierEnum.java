package com.haina.flight.price.constants;

/*这个枚举类是通过航司二字码来获取中文名*/
public enum CarrierEnum {

    CA("sd","asd"),
    MU("MU","东方航空"),
    CZ("CZ","南方航空"),
    JD("JD","首都航空"),
    MF("CZ","厦门航空");

    CarrierEnum(String carrier,String name){
        this.carrier=carrier;
        this.name=name;
    }
    private  String carrier;
    private  String name;

    public static String  getNameBuCarrier(String carrier){
        return CarrierEnum.valueOf(carrier).name;
    }
}
