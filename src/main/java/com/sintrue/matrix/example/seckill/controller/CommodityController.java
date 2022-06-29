package com.sintrue.matrix.example.seckill.controller;

import com.sintrue.matrix.example.seckill.domain.Commodity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.logging.MatrixLogger;
import wang.liangchen.matrix.framework.commons.logging.MatrixLoggerFactory;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.web.response.FormattedResponse;

import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-06-29 22:47
 */
@RestController
@RequestMapping("/")
public class CommodityController {
    private static final MatrixLogger logger = MatrixLoggerFactory.getLogger(CommodityController.class);
    private final StandaloneDao standaloneDao;

    @Inject
    public CommodityController(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    @GetMapping("success")
    public FormattedResponse success() {
        return FormattedResponse.success();
    }

    @GetMapping("failure")
    public FormattedResponse failure() {
        return FormattedResponse.failure();
    }

    @GetMapping("exception")
    public FormattedResponse exception() {
        return FormattedResponse.exception(new MatrixInfoException("I am Info"));
    }

    @GetMapping("auto_exception")
    public FormattedResponse auto_exception() {
        throw new MatrixErrorException("I am Error");
    }

    @GetMapping("insert")
    public FormattedResponse insert() {
        Commodity entity = Commodity.newInstance();
        entity.setCommodityId(NumbericUid.INSTANCE.nextId());
        entity.setCommodityName("要啥自行车");
        entity.setCommodityPrice(52000);
        entity.setCommodityStock(5);
        entity.setCreateDatetime(LocalDateTime.now());
        entity.setState("NORMAL");
        int rows = standaloneDao.insert(entity);
        logger.debug("insert: {}, entity: {}", rows, entity);
        return FormattedResponse.success();
    }
    @GetMapping("pagination")
    public FormattedResponse pagination() {
        Criteria criteria = Criteria.of(Commodity.class)
                .pageSize(3).pageNumber(1);
        PaginationResult pagination = standaloneDao.pagination(criteria);
        logger.debug("pagination: {}", pagination);
        return FormattedResponse.success().payload(pagination);
    }
}
