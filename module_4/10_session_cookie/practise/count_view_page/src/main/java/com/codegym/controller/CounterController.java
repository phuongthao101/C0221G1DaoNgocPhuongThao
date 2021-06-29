package com.codegym.controller;

import com.codegym.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute("counter")
    public Counter setUpCounter(){
        return new Counter();
    }
    @GetMapping("/")
        public String get(@ModelAttribute("counter") Counter counter) {// thêm model atttribute vào session để lưu dữ liệu(tên giống nhau)
        counter.increment();// gọi phương thức tăng lên 1 giá trị từ class counter
        return "/index";
    }
}
//    Annotation @SessionAttributes("counter") được sử dụng để lưu trữ model attribute trong session.
//    Trong đoạn mã trên, model attribute "counter"  sẽ được thêm vào session nếu tên attribute của @ModelAttribute
//    và @SessionAttributes giống nhau.
//        Annotation @ModelAttribute liên kết một tham số phương thức hoặc một phương thức trả về giá trị cho một model
//        attribute và sau đó trả nó về một view cụ thể.
//        hàm increment() có nhiệm vụ tăng giá trị thuộc tính count của đối tượng counter