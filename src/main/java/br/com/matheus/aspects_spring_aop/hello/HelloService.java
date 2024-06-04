package br.com.matheus.aspects_spring_aop.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

  public void hello() {
    System.out.println("Hello");
  }

}
