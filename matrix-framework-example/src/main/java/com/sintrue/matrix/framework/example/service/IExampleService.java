package com.sintrue.matrix.framework.example.service;

public interface IExampleService {
     String zeroParameter();

     String oneParameter(String one);

     String twoParameter(String one, String two);

     String threeParameter(String one, String two, String three);

     void zeroVoid();
     void oneVoid(String one);
     void twoVoid(String one, String two);
}
