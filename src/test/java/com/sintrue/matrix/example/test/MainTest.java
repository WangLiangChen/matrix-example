package com.sintrue.matrix.example.test;

import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author Liangchen.Wang 2022-04-29 17:37
 */
public class MainTest {
    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.setId(0L);
        ValidationUtil.INSTANCE.validate(staff);
    }

    static class Staff {
        private String name;
        @Min(value = 1,message = "min")
        @Null(message = "null")
        private Long id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
