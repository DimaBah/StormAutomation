package by.stormnet.core.utils;

public enum PauseLenght {
    MAX(5),
    AVG(5),
    MIN(5);


    private Integer value;

    PauseLenght(Integer value) {
        this.value = value;
    }

    public Integer value(){
        return this.value;
    }
}
