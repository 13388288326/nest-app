package com.java.admin.controller;

import com.java.admin.entity.DictionaryCode;
import com.java.admin.entity.DictionaryValue;
import com.java.admin.service.DictionaryCodeService;
import com.java.admin.service.DictionaryValueService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionaryValue")
@Api(tags = "字典值管理")
public class DictionaryValueController {
    @Autowired
    private DictionaryValueService dictionaryValueService;

    @Autowired
    private DictionaryCodeService dictionaryCodeService;

    @Autowired
    private RedisUtil redisUtils;

    @PostMapping()
    @ApiOperation("新增")
    public R addItem(@RequestBody DictionaryValue dictionaryValue) {
        DictionaryCode item = this.dictionaryCodeService.getById(dictionaryValue.getCodeValueId());
        if (item == null) {
            throw new CustomException("未找到字典编码父级", 500);
        }
        this.dictionaryValueService.save(dictionaryValue);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R deleteItem(@PathVariable String id) {
        this.dictionaryValueService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R modifyItem(@PathVariable String id, @RequestBody DictionaryValue dictionaryValue) {
        if (id.equals(dictionaryValue.getId())) {
            throw new CustomException(ResponseEnum.PARAMS_IS_NULL);
        }
        this.dictionaryValueService.updateById(dictionaryValue);
        return R.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R getItem(@PathVariable String id) {
        return ResultVoUtil.success(this.dictionaryValueService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("通过字典编码获取字典列表")
    public R codeList(@RequestParam(name = "code", required = true) String code) {
        Object redisResult = this.redisUtils.get(code);
        if (redisResult == null) {
            List<DictionaryValue> listByCode = this.dictionaryValueService.getListByCode(code);
            redisUtils.set(code, listByCode);
            return ResultVoUtil.success(listByCode);
        } else {
            return ResultVoUtil.success(redisResult);
        }
    }
}
