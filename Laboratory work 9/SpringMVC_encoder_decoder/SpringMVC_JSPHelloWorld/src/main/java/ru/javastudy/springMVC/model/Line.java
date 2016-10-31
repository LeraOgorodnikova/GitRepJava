package ru.javastudy.springMVC.model;
import org.springframework.stereotype.Component;


@Component
public class Line {

    private String lineEncode;
    private String lineDecode;

    public String getLineDecode() {
        return lineDecode;
    }

    public void setLineDecode(String lineDecode) {
        this.lineDecode = lineDecode;
    }

    public String getLineEncode() {

        return lineEncode;
    }

    public void setLineEncode(String lineEncode) {
        this.lineEncode = lineEncode;
    }
}
