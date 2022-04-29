package com.sintrue.matrix.example.test;

import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

import javax.validation.constraints.NotBlank;

/**
 * @author Liangchen.Wang 2022-04-29 17:37
 */
public class MainTest {
    public static void main(String[] args) {
        Staff staff = new Staff();
        ValidationUtil.INSTANCE.validate(staff);
    }

    static class Staff {
        @NotBlank(message = "helell")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
