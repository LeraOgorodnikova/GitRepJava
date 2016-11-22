package ru.javastudy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.Decoder;
import ru.javastudy.springMVC.model.Encoder;
import ru.javastudy.springMVC.model.Line;
import java.io.IOException;


@Controller
public class MainController {

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("decodeEncode",new Line());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/generateString")
    public ModelAndView generateString(@ModelAttribute("decodeEncode") Line line) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");
        if (line.getLineDecode()!=null || line.getLineEncode()!=null) {
            if (line.getLineDecode()!=""){
                line.setLineDecode(Decoder.decode(line.getLineDecode()));
            }
            if (line.getLineEncode()!="") {
                line.setLineEncode(Encoder.encode(line.getLineEncode()));
            }
        }
        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("decodeEncode",line);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }
}
